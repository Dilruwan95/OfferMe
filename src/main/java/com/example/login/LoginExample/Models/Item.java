package com.example.login.LoginExample.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "items", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "itemCode"
        })
})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int oldPrice;

    private int newPrice;

    private Long itemCode;

    private float rate;

    private float discount;

    private Date startDate;

    private Date endDate;

    private String photoUrl;

    private int categoryId;

    private boolean accpet;

    private String supplierName;

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String location;

    public Long getSupplyId() {
        return SupplyId;
    }

    public void setSupplyId(Long supplyId) {
        SupplyId = supplyId;
    }

    private Long SupplyId;

    public Item() {

    }

    public Item(Long id, float discount, Date startDate, Date endDate, String photoUrl, String name, int oldPrice, int newPrice, Long itemCode, float rate, int categoryId, boolean accpet,Long SupplyId , String location) {
        this.id = id;
        this.name = name;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.itemCode = itemCode;
        this.rate = rate;
        this.discount = discount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.photoUrl=photoUrl;
        this.categoryId=categoryId;
        this.accpet=accpet;
        this.SupplyId=SupplyId;
        this.location=location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public Long getItemCode() {
        return itemCode;
    }

    public void setItemCode(Long itemCode) {
        this.itemCode = itemCode;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isAccpet() {
        return accpet;
    }

    public void setAccpet(boolean accpet) {
        this.accpet = accpet;
    }
}
