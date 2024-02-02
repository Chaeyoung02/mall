package com.example.mall.mapper;

import com.example.mall.dto.CartDTO;

import com.example.mall.dto.CartItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    void addCart(CartDTO cartDTO);
    void updateQuantity(CartDTO cartDTO);

    CartDTO selectItem(int member_id, int product_id);

    List<CartItem>  selectCartList(int member_id);

    void deleteItem(int member_id);

//    List<CartDTO> selectCartList(int member_id);
}
