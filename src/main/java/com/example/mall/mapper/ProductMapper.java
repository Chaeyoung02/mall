package com.example.mall.mapper;

import com.example.mall.dto.ProductDTO;
import com.example.mall.service.ProductService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDTO> selectProduct();
    ProductDTO selectProductId(int product_id);
}
