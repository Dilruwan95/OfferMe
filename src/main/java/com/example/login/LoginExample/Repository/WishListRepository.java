package com.example.login.LoginExample.Repository;

import com.example.login.LoginExample.Models.Item;
import com.example.login.LoginExample.Models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long> {
//    @Query(value = "SELECT * FROM `wish_lists` WHERE id IN (SELECT item_id FROM `wish_lists` WHERE user_id = :userId ) ", nativeQuery = true)
//    List<WishList> getUserWishList(@Param("userId")Long userId);
}
