package com.example.mall.service;

import com.example.mall.dto.CartDTO;

import com.example.mall.dto.CartItem;
import com.example.mall.mapper.CartMapper;
//import com.example.mall.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;

    public void addCart(CartDTO cartDTO){

        CartDTO selectItem =  cartMapper.selectItem(cartDTO.getMember_id(), cartDTO.getProduct_id());

        //상품 유무
        if(selectItem != null) {
            int newQuantity = selectItem.getQuantity() + cartDTO.getQuantity();
            cartDTO.setQuantity(newQuantity);
            cartMapper.updateQuantity(cartDTO);
        }
        else{
            cartMapper.addCart(cartDTO);
        }


    }
    public List<CartItem> selectCartList(int member_id){
        List<CartItem> cartRSVo = cartMapper.selectCartList(member_id);

        return cartRSVo;

    }


//    public List<CartDTO> selectCartList(int member_id){
//        return cartMapper.selectCartList(member_id);
//    }
}
