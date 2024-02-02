package com.example.mall.controller;


import com.example.mall.dto.*;
import com.example.mall.service.CartService;
import com.example.mall.service.MemberService;
import com.example.mall.service.ProductService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
public class CartController {
    @Autowired
    MemberService memberService;


    @Autowired
    CartService cartService;


    @Autowired
    ProductService productService;

    @PostMapping("/product/cart/{product_id}")
    public String addCart(@PathVariable int product_id, @RequestParam int quantity, HttpSession session){

        String email = (String) session.getAttribute("email");
        int member_id = (int) session.getAttribute("id");

        System.out.println(member_id);
        if(session.getAttribute("email") == null){
            return "redirect:/member/login";
        }
         String checkMember = memberService.checkMember(email);

        System.out.println(email);


        if(checkMember != null){
            CartDTO cartDTO = new CartDTO();
            cartDTO.setMember_id(member_id);
            cartDTO.setProduct_id(product_id);
            cartDTO.setQuantity(quantity);
            cartService.addCart(cartDTO);
            System.out.print(cartDTO);

        }
        return"redirect:/main";
    }

//    @GetMapping("/product/cartList")
//    public String viewCart(HttpSession session, Model model){
//        int member_id = (int) session.getAttribute("id");
//
//        if(session.getAttribute("id") != null) {
//            System.out.println(member_id);
//            List<CartDTO> cartItem = cartService.selectCartList(member_id);
//            model.addAttribute("cartItem", cartItem);
//
//        }
//        return "cart";
//
//    }
    @GetMapping("/product/cartList")
    public String viewCart(HttpSession session, Model model){
        int member_id = (int)session.getAttribute("id");


        if(session.getAttribute("id") != null) {
            List<CartItem> cartList = cartService.selectCartList(member_id);
            model.addAttribute("cartlist", cartList);

        }
        return "cart";
    }

    @PostMapping("/deleteItem")
    public String deleteItem(HttpSession session) {
        int member_id = (int)session.getAttribute("id");

        cartService.deleteItem(member_id);
        //product_id 별 삭제 기능 추가

        return "cart";
    }

    //수량수정
}
