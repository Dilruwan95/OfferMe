package com.example.login.LoginExample.Controller;


import com.example.login.LoginExample.Models.*;
import com.example.login.LoginExample.Repository.CategoryRepository;
import com.example.login.LoginExample.Repository.ItemRepository;
import com.example.login.LoginExample.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<Item> getAllAdvertisments(){
       return itemRepository.findAll();
    }

    @GetMapping("/{categoryId}")
    public List<Item> getFindCategory(@PathVariable int categoryId){
        return itemRepository.findByCategoryId(categoryId);
    }

    @GetMapping("/allCategory")
    public List<Category> getAllCategory(){
        return categoryRepository.findAllCategory();
    }

    @GetMapping("/users")
    public List<User> getFind(){
        return userRepository.findAll();
    }
}

