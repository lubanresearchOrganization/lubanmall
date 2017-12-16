package com.lubanresearch.lubanmall.userservice.application.controller;

import com.lubanmall.userserviceapi.bean.UserDTO;
import com.lubanresearch.lubanmall.userservice.domain.User;
import com.lubanresearch.lubanmall.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by hilbertcao on 2017/12/16.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{id}")
    @ResponseBody
    public User getUser(@PathVariable("id") Long id){


        return userService.getById(id);
    }
}
