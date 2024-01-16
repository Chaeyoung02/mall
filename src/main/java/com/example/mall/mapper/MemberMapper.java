package com.example.mall.mapper;

import com.example.mall.dto.MemberDTO;
import com.example.mall.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface MemberMapper {
     int insertMember(MemberDTO memberDTO);

     String checkMember(String email);

     MemberDTO loginMember(String email, String password);

}
