package com.myproj.springbootexample.mycrudoperation.dao;

import com.myproj.springbootexample.mycrudoperation.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

    Page<Customer> findByCompanyId(Long id, Page page);
    Page<Customer> findByIdAndCompanyId (Long id, Long companyId);
}
