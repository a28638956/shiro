package com.lianxi.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
    @RequestMapping({"/","/index"})
    public String toIndex(Model model){
        model.addAttribute("msg","helloword");

        return "index";
    }
    @RequestMapping("/user/add")
    public String add(Model model){
        model.addAttribute("msg","helloword");

        return "/user/add";
    }
    @RequestMapping("/user/update")
    public String update(){


        return "/user/update";
    }
}
