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


    @GetMapping("/DeleteWishList/{itemId}/{userId}")
    public String  deleteWishListItems(@PathVariable Long itemId, @PathVariable Long userId){
        WishList ab = wishListRepository.getWishListId(itemId, userId);
        wishListRepository.deleteById(ab.getId());
        return "successfully deleted";

    }

    @GetMapping("/findWishList/{itemId}/{userId}")
    public Boolean findWishList(@PathVariable Long itemId, @PathVariable Long userId){
        WishList ab = wishListRepository.getWishListId(itemId, userId);
        if(ab!=null) {
            return true;
        }
        return false;

    }


}
