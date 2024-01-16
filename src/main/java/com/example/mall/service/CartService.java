package com.example.mall.service;

import com.example.mall.dto.CartDTO;
import com.example.mall.mapper.CartMapper;
//import com.example.mall.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    CartMapper cartMapper;

    public void addCart(CartDTO cartDTO){
        cartMapper.addCart(cartDTO);
    }
}
