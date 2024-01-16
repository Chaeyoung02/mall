package com.example.mall.service;

import com.example.mall.dto.MemberDTO;


import com.example.mall.mapper.MemberMapper;
//import com.example.mall.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;


@Service
@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberMapper memberMapper;


    public int insertMember(MemberDTO memberDTO){
        return memberMapper.insertMember(memberDTO);
    }

    public String checkMember(String email) {return memberMapper.checkMember(email);}
    public MemberDTO loginMember(String email, String password) { return memberMapper.loginMember(email,password);}


}
