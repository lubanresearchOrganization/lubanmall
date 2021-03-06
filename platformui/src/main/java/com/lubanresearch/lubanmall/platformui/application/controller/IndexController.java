package com.lubanresearch.lubanmall.platformui.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author hilbert.cao
 */
@ApiIgnore
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(path = {"info","/"})
    public String index() {
        return "redirect:index.html";
    }

    @RequestMapping(path = {"/go"})
    public @ResponseBody
    String go() {
        return "success";
    }

}
