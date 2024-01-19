package com.example.mall.dto;

import lombok.*;

@Data
public class MemberDTO  {
    private Integer id;
    private String email;
    private String username;
    private String password;
    public MemberDTO(Integer id, String email, String password, String username) {
        this.id =id;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
