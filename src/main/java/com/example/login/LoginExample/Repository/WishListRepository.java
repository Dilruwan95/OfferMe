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

    @Query(value = "DELETE FROM WishList WHERE item_id = :itemId and user_id = :userId", nativeQuery = true)
    String deleteItem(@Param("itemId") Long itemId, @Param("userId") Long userId);

    @Query(value = "SELECT * FROM `wish_lists` WHERE item_id= :itemId AND user_id =:userId ", nativeQuery = true)
    WishList getWishListId(@Param("itemId") Long itemId, @Param("userId") Long userId);
}
