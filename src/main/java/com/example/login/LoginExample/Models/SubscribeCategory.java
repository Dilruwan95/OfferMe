package com.example.login.LoginExample.Models;

import javax.persistence.*;

@Entity
@Table(name = "subscribe_category")
public class SubscribeCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int categoryId;

    private Long userId;

    public SubscribeCategory() {
    }

    public SubscribeCategory(Long id, int categoryId, Long userId) {
        this.id = id;
        this.categoryId = categoryId;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
