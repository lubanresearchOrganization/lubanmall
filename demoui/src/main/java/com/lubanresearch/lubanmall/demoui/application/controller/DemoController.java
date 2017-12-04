package com.lubanresearch.lubanmall.demoui.application.controller;

import com.lubanresearch.lubanmall.common.bean.Response;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author hilber.cao
 */
@Api(tags = "demo" , description = "【示例】")
@Controller
@RequestMapping("/demos")
public class DemoController {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Response<String> get(@PathVariable("id") String id) {

        return new Response(0,"成功",id);
    }
}