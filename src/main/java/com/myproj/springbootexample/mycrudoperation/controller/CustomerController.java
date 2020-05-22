package com.myproj.springbootexample.mycrudoperation.controller;

import com.myproj.springbootexample.mycrudoperation.dao.CompanyDao;
import com.myproj.springbootexample.mycrudoperation.dao.CustomerDao;
import com.myproj.springbootexample.mycrudoperation.model.Company;
import com.myproj.springbootexample.mycrudoperation.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
@Autowired
    CustomerDao customerDao;
@Autowired
    CompanyDao companyDao;

@GetMapping("/company/{companyId}/customer")
   public Page<Customer> findAllCustomerByComanyId(@PathVariable Long id,Page page){
    return customerDao.findByCompanyId(id, page);
}



@PostMapping ("/company/{id}/customer")
    public Customer createCustomer(@PathVariable Long companyId, @RequestBody Customer customerDetail){
    Company company = companyDao.findById(companyId)
            .orElseThrow(()-> new FileNotFoundException());
    Customer customer =  customerDetail.setCompany(company);

    return customerDao.save(customerDetail);
}


@PutMapping ("/customer/{id}")
    public Customer updateCustomer(@PathVariable Long id,
                                   @RequestBody Customer customerDetail) throws FileNotFoundException {

    Customer customer = customerDao.findById(id)
            .orElseThrow(()-> new FileNotFoundException());
    customer.setAge(customerDetail.getAge());
    customer.setName(customerDetail.getName());
    Customer customer1 = customerDao.save(customer);
    return customer1;

}
    @DeleteMapping ("/customer/{id}")
    public String  deleteCustomer (@PathVariable Long id) throws FileNotFoundException {
    Customer customer = customerDao.findById(id)
            .orElseThrow(()-> new FileNotFoundException());
    customerDao.delete(customer);
    return "delete";
    }

}
