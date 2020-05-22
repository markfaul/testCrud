package com.myproj.springbootexample.mycrudoperation.dao;

import com.myproj.springbootexample.mycrudoperation.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDao extends JpaRepository<Company, Long> {
}
