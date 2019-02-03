package com.example.login.LoginExample.PayLoad;

public class ItemCategory {

    private String name;
    private Long noOfSubscriptions;

    public ItemCategory(String name, Long noOfSubscriptions) {
        this.name = name;
        this.noOfSubscriptions = noOfSubscriptions;
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
