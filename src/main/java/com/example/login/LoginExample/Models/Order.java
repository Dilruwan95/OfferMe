package com.example.login.LoginExample.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long itemId;

    private Long userId;

//    @ManyToOne(fetch = FetchType.LAZY,cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//    })
//    @JoinColumn(name = "item_id", insertable = false, updatable = false)
//    @Fetch(FetchMode.JOIN)
//    private Item item;

    public Order() {
    }

    public Order(Long id, Long itemId, Long userId) {

        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
