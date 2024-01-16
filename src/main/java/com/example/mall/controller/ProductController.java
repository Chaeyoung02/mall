package com.example.mall.controller;

import com.example.mall.dto.CartDTO;
import com.example.mall.dto.MemberDTO;
import com.example.mall.dto.ProductDTO;
import com.example.mall.service.CartService;
import com.example.mall.service.MemberService;
import com.example.mall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Member;
import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CartService cartService;

    @Autowired
    MemberService memberService;

    @GetMapping("/main")
    public String main(Model model) {
        List<ProductDTO> product = productService.selectProduct();
        model.addAttribute("product", product);
        return "main";
    }

    @GetMapping("/product/{product_id}")
    public String product(@PathVariable int product_id, Model model) {
        ProductDTO product = productService.selectProductId(product_id);
        model.addAttribute("product", product);
        return "productDetail";

    }



}
