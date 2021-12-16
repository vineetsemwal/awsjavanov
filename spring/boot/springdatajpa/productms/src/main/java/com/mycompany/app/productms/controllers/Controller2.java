package com.mycompany.app.productms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class Controller2 {

    @ResponseBody
    @GetMapping("/welcome")
    public String welcome(){
        return "welcome to rest";
    }

    /*
    @GetMapping("/home")
    public ModelAndView home(){
        return new ModelAndView("welcome","msg","hello");
    }
    */
}
