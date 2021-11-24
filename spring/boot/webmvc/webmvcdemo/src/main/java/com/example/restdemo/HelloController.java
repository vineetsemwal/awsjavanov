package com.example.restdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/app/welcome")
    public ModelAndView welcome(){
        System.out.println("inside welcome");
        String model="welcome to webmvc";
        ModelAndView response=new ModelAndView("hello", "msg",model);
        return response;
    }


}
