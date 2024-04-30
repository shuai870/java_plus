package com.example.serverfor_test0.controller;

import com.example.serverfor_test0.entity.User;
import com.example.serverfor_test0.mapper.UserMapper;
import com.example.serverfor_test0.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//代表返回json格式数据
@RestController

//表示此url为user的操作内容

@RequestMapping("/user")
public class UserController {
    //引入接口
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    //所有用户
    @GetMapping
    public List<User> index(){
        return userMapper.findAll();
    }
    //数据插入 @RequestBody 使得json转换为Java对象
    @PostMapping
    private Integer save(@RequestBody User user){
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userMapper.deleteById(id);
    }
    @GetMapping("/page")
    public Map<String,Object> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam String username){
        //计算页码
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userMapper.selectPage(pageNum,pageSize,username);
        //查询总条数
        Integer total = userMapper.selectTotal(username);
        //封装数据
        Map<String,Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}

