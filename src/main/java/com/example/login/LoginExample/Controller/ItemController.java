package com.example.login.LoginExample.Controller;

import com.example.login.LoginExample.Exception.ResourceNotFoundException;
import com.example.login.LoginExample.Models.Item;
import com.example.login.LoginExample.PayLoad.ApproveItem;
import com.example.login.LoginExample.PayLoad.ItemDetails;
import com.example.login.LoginExample.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/advertisment/{id}")
    public Optional<Item> getItem(@PathVariable(value = "id") Long id) {
        return itemRepository.findById(id);
    }

    @PostMapping("/addAdvertisment")
    public String addAdvertisement(@Valid @RequestBody Item item) {
        itemRepository.save(item);
        return "Saved";
    }


    @PostMapping("/addspeclAdvertisment")
    public String addspeclAdvertisment(@Valid @RequestBody Item item) {
        itemRepository.save(item);
        return "Saved";
    }

    @PutMapping("addAdvertisment /{id}")
    public Item updateitem(@PathVariable(value = "id") Long itemId,
                           @Valid @RequestBody ItemDetails itemDetails) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", itemId));

        item.setName(itemDetails.getName());
        item.setOldPrice(itemDetails.getOldPrice());
        item.setNewPrice(itemDetails.getNewPrice());
        item.setDiscount(itemDetails.getDiscount());
        item.setStartDate(itemDetails.getStartDate());
        item.setEndDate(itemDetails.getEndDate());
        item.setPhotoUrl(itemDetails.getPhotoUrl());
        item.setCategoryId(itemDetails.getCategoryId());
        item.setItemCode(itemDetails.getItemCode());

        Item updatedItem = itemRepository.save(item);
        return updatedItem;


    }

    @PutMapping("/approveItem/{id}")
    public Item approveItem(@PathVariable(value = "id") Long id,
                            @Valid @RequestBody ApproveItem approveItem) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item", "id", id));

        item.setAccpet(approveItem.isAccept());

        Item updatedItem = itemRepository.save(item);

        return updatedItem;
    }

    @DeleteMapping("/DeleteItem/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
        return "delete item";
    }

    @GetMapping("/user/{id}")
    public Iterable<Item> getItemBySupplierId(@PathVariable(value = "id") Long id) {
        return itemRepository.getAllItemBySupplierId(id);
    }

    @DeleteMapping("/deleteExpItem/{itemId}")
    public String deleteExpItem(@PathVariable Long itemId){
        itemRepository.deleteExpItem(itemId);
        return  "delete Item";
    }


}


