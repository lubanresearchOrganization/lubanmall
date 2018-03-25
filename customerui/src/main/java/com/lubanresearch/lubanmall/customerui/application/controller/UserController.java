package com.lubanresearch.lubanmall.customerui.application.controller;

import com.lubanmall.userserviceapi.bean.UserDTO;
import com.lubanmall.userserviceapi.command.ChangepasswordCommandDTO;
import com.lubanresearch.lubanmall.common.exception.UIException;
import com.lubanresearch.lubanmall.customerui.infrastructure.remote.UserService;
import com.lubanresearch.lubanmall.ssoclient.bean.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by hilbertcao on 2018/3/12.
 */
@Controller
@RequestMapping("/v/0.1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/authentication", method = RequestMethod.GET)
    @ResponseBody
    public UserDTO getUser(HttpSession session){

        Authentication authentication = (Authentication) session.getAttribute("authentication");

        if(authentication == null){
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setName(authentication.getUserName());
        userDTO.setId(authentication.getUserId());
        userDTO.setMobile(authentication.getPhone());
        return userDTO;


    }
    @RequestMapping(path = {"/logout"})
    @ResponseBody public Boolean logout(HttpSession session) {

        session.invalidate();
        return true;
    }


    private Long getCustomerId(HttpSession session){
        Authentication authentication = (Authentication) session.getAttribute("authentication");
        if(authentication==null){

            throw new UIException(500,"用户未登录");
        }
        return authentication.getUserId();
    }

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    @ResponseBody
    public UserDTO updateUser( @RequestBody UserDTO user,HttpSession session){
        user.setId(getCustomerId(session));
        return userService.update(user.getId(),user);
    }

    @RequestMapping(value = "/commands/changePassword",method = RequestMethod.POST)
    @ResponseBody
    public UserDTO changePassword(@RequestBody ChangepasswordCommandDTO command,HttpSession session){


        return userService.changePassword(getCustomerId(session),command);
    }

}
