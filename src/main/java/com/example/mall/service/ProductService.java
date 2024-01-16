package com.example.mall.service;

import com.example.mall.dto.ProductDTO;
import com.example.mall.mapper.ProductMapper;
//import com.example.mall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductMapper productMapper;
     public List<ProductDTO> selectProduct(){
         return productMapper.selectProduct();
     }

     public ProductDTO selectProductId(int product_id) {
         return productMapper.selectProductId(product_id);
     }
}
