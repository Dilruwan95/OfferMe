package com.example.login.LoginExample.Controller;

import com.example.login.LoginExample.Models.Item;
import com.example.login.LoginExample.Models.Order;
import com.example.login.LoginExample.Models.WishList;
import com.example.login.LoginExample.Repository.ItemRepository;
import com.example.login.LoginExample.Repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/wishList")
public class WishListController {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping("/wishListItems/{id}")
    public Optional<WishList> getWishList(@PathVariable(value = "id") Long id){
        return wishListRepository.findById(id);
 }

    @PostMapping("/addWishListList")
    public String addOrderList(@Valid @RequestBody WishList wishList){
        wishListRepository.save(wishList);
        return "Saved";
    }

    @GetMapping("/WishLists/{userId}")
    public List<Item> getUserWishLists(@PathVariable Long userId){
        return itemRepository.getUserWishList(userId);
    }

    @DeleteMapping("/DeleteWishList/{id}")
    public String deleteWishListItems(@PathVariable Long id){
        wishListRepository.deleteById(id);
        return "delete wishList";
    }

}
