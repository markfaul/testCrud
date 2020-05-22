package com.myproj.springbootexample.mycrudoperation.controller;

import com.myproj.springbootexample.mycrudoperation.dao.CompanyDao;
import com.myproj.springbootexample.mycrudoperation.dao.CustomerDao;
import com.myproj.springbootexample.mycrudoperation.model.Company;
import com.myproj.springbootexample.mycrudoperation.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    CompanyDao companyDao;


    @GetMapping("/company")
    public List<Company> getAllCompany(){

        return companyDao.findAll();
    }
    @GetMapping("/company/{id}")
    public Company getCustomerById(@PathVariable Long id, Model model) throws FileNotFoundException {
        Company company = companyDao.findById(id)
                .orElseThrow(()-> new FileNotFoundException());
        return company;


    }


    @PostMapping("/company")
    public Company createCompany(@PathVariable Company company){

        return companyDao.save(company);
    }


    @PutMapping ("/company/{id}")
    public Company updateCompany(@PathVariable Long id,
                                   @RequestBody Company companyDetail) throws FileNotFoundException {

        Company company = companyDao.findById(id)
                .orElseThrow(()-> new FileNotFoundException());
        company.setCompanyName(companyDetail.getCompanyName());
        Company company1 = companyDao.save(company);
        return company1;

    }
    @DeleteMapping ("/company/{id}")
    public String  deleteCompany (@PathVariable Long id) throws FileNotFoundException {
        Company company = companyDao.findById(id)
                .orElseThrow(()-> new FileNotFoundException());
        companyDao.delete(company);
        return "delete";
    }
}
