package com.example.login.LoginExample.Repository;

import com.example.login.LoginExample.Models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT * FROM `items` WHERE category_id = :categoryId ORDER BY id DESC", nativeQuery = true)
    List<Item> findByCategoryId(@Param("categoryId") int categoryId);

    @Query(value = "SELECT * FROM `items` WHERE id IN (SELECT item_id FROM `orders` WHERE user_id = :userId ) ORDER BY id DESC", nativeQuery = true)
    List<Item> getUserOrders(@Param("userId")Long userId);

    @Query(value = "SELECT * FROM `items` WHERE id IN (SELECT item_id FROM `wish_lists` WHERE user_id = :userId ) ORDER BY id DESC", nativeQuery = true)
    List<Item> getUserWishList(@Param("userId")Long userId);

    @Query(value = "SELECT * FROM `items` WHERE category_id IN (SELECT category_id FROM `subscribe_category` WHERE user_id = :userId) ORDER BY id DESC", nativeQuery = true)
    List<Item> getSubscribeItems(@Param("userId")Long userId);

    @Query(value = "SELECT * FROM `items` ORDER BY id DESC ", nativeQuery = true)
    List<Item> findAllItems();

    @Query(value = "SELECT * FROM `items` WHERE supply_id = :supplierId", nativeQuery = true)
    List<Item> getAllItemBySupplierId(@Param("supplierId")Long supplierId);

    @Query(value = "DELETE  FORM `items` WHERE end_date < NOW() AND item_id = :itemId",nativeQuery = true)
    void deleteExpItem (@Param("itemId") Long itemId);

    }
