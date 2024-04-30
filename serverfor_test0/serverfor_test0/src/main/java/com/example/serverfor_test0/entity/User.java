package com.example.serverfor_test0.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    @JsonIgnore   //忽略密码  不展示给前端
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
}
