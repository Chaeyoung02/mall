package com.example.mall.controller;


import com.example.mall.dto.CartDTO;
import com.example.mall.dto.MemberDTO;
import com.example.mall.service.CartService;
import com.example.mall.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
public class CartController {
    @Autowired
    MemberService memberService;


    @Autowired
    CartService cartService;

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
            return "redirect:/main";
        }
        return "redirect:/";
    }

}
