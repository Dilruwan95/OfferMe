package com.example.login.LoginExample.Controller;

import com.example.login.LoginExample.Models.Item;
import com.example.login.LoginExample.Models.SubscribeCategory;
import com.example.login.LoginExample.Models.WishList;
import com.example.login.LoginExample.Repository.ItemRepository;
import com.example.login.LoginExample.Repository.SubscribeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/subscribe")
public class SubscribeController {

    @Autowired
    private SubscribeCategoryRepository subscribeCategoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @PostMapping("/subscrbeCategory")
    public String subscribeCategory(@Valid @RequestBody SubscribeCategory subscribeCategory){
        subscribeCategoryRepository.save(subscribeCategory);
        return "Saved";
    }

    @GetMapping("/subscribeItem/{userId}")
    public List<Item> getSubscribeItems(@PathVariable Long userId){
        return itemRepository.getSubscribeItems(userId);
    }


}
