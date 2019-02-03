package com.example.login.LoginExample.Models;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private Long noOfSubscriptions;


    public Category() {

    }

    public Category(int id, String name, Long noOfSubscriptions) {
        this.id = id;
        this.name = name;
        this.noOfSubscriptions = noOfSubscriptions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNoOfSubscriptions() {
        return noOfSubscriptions;
    }

    public void setNoOfSubscriptions(Long noOfSubscriptions) {
        this.noOfSubscriptions = noOfSubscriptions;
    }

}
