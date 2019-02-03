package com.example.login.LoginExample.Repository;

import com.example.login.LoginExample.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT * FROM `categories`", nativeQuery = true)
    List<Category> findAllCategory();

}
