package com.example.login.LoginExample.PayLoad;

public class UserProfile {

    private Long id;
    private String username;
    private String name;
    private String address;
    private String telephone;


    public UserProfile(Long id, String username, String name, String address, String telephone) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
