package com.example.serverfor_test0;

import com.example.serverfor_test0.entity.User;
import com.example.serverfor_test0.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



//代表应用启动主体代码
@SpringBootApplication
public class ServerforTest0Application {




    public static void main(String[] args) {
        SpringApplication.run(ServerforTest0Application.class, args);
    }



}
