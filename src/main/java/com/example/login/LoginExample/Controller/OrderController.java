package com.example.login.LoginExample.Controller;

import com.example.login.LoginExample.Exception.ResourceNotFoundException;
import com.example.login.LoginExample.Models.Item;
import com.example.login.LoginExample.Models.Order;
import com.example.login.LoginExample.Models.User;
import com.example.login.LoginExample.Models.WishList;
import com.example.login.LoginExample.PayLoad.EditOrder;
import com.example.login.LoginExample.PayLoad.OrderList;
import com.example.login.LoginExample.Repository.ItemRepository;
import com.example.login.LoginExample.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

//    @GetMapping("/orderListItems/{userId}")
//    public List<Order> getWishList(@PathVariable Long userId){
//        return orderRepository.findByUserId(userId);
//    }

    @GetMapping("/items")
    public List<Item> getItem(){
        return itemRepository.findAll();
    }

    @PostMapping("/addOrderList")
    public String addOrderList(@Valid @RequestBody Order order){
        orderRepository.save(order);
        return "Saved";
    }

    @GetMapping("/Orders/{userId}")
    public List<Item> getUserOrders(@PathVariable Long userId){
        return itemRepository.getUserOrders(userId);
    }

    @DeleteMapping("/DeleteOrder/{id}")
    public String deleteOrderItems(@PathVariable Long id){
        orderRepository.deleteById(id);
        return "delete order";
    }

    @GetMapping("/DeleteOrder/{itemId}/{userId}")
    public String  deleteOrderItems(@PathVariable Long itemId, @PathVariable Long userId){
        Order ab = orderRepository.getOrderId(itemId, userId);
        orderRepository.deleteById(ab.getId());
        return "successfully deleted";

    }

    @GetMapping("/findOrder/{itemId}/{userId}")
    public Boolean findOredr(@PathVariable Long itemId, @PathVariable Long userId){
        Order ab = orderRepository.getOrderId(itemId, userId);
        if(ab!=null) {
            return true;
        }
        return false;

    }

}
