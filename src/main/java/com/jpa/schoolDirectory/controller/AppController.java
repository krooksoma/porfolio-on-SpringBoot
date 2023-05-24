package com.jpa.schoolDirectory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AppController {
    
    @GetMapping("/time")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", new java.util.Date());
        
        return "homepage";
    }

    @GetMapping("/error")
    public String errorPage(Model theModel){
        theModel.addAttribute("error");

        return "errorPage";
    }
        
}
