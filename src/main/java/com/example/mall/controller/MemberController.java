package com.example.mall.controller;

import com.example.mall.dto.MemberDTO;
//import com.example.mall.repository.MemberRepository;
import com.example.mall.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/member/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/member/signup")
    public String signup(MemberDTO memberDTO) {
        if (memberService.insertMember(memberDTO) > 0) {
            return "login";
        }
        return "signup";
    }

    @GetMapping("/member/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login(String email, String password, HttpSession session) {
        System.out.println(email + password);
        MemberDTO loginMember = memberService.loginMember(email, password);
        System.out.println(loginMember);

        if (loginMember != null) {
            session.setAttribute("email", email);

            session.setAttribute("id", loginMember.getId());

            System.out.println(session.getAttribute("id"));
            return "redirect:/main";
        }
        return "login";
    }


}

