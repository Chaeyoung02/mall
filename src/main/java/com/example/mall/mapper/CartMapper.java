package com.example.mall.mapper;

import com.example.mall.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CartMapper {
    void addCart(CartDTO cartDTO);
}
