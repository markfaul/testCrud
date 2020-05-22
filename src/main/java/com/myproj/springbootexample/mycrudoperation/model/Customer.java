package com.myproj.springbootexample.mycrudoperation.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private String name;
    private Integer age;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id")
    private Company company;

    public  Customer(){

    }
    public Customer(Integer age, String name){
        this.age = age;
        this.name = name;
    }

}
