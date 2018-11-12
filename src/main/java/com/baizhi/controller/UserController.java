package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("regist")
    @ResponseBody
    public void regist(User user){
        userService.add(user);
    }
    @RequestMapping("login")
    @ResponseBody
    public String login(User user){
        User login = userService.login(user.getPassword());
        if(login!=null){
            return null;
        }else{
            return null;
        }
    }
    @RequestMapping("update")
    @ResponseBody
    public void update(User user){
        userService.update(user);
    }
}
