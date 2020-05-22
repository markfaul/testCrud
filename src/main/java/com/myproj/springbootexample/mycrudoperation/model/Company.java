package com.myproj.springbootexample.mycrudoperation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "company")
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "company_name")
    private String companyName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Customer> customers;
    public Company(){

    }

    public Company(String companyName){
        this.companyName = companyName;
    }


}
