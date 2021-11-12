package com.defaria.portfoliospringmvc.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String homepage(){
        System.out.println("Homepage Controller Called");
        return "home";
    }

    @GetMapping("/works")
    public String worksPage(){
        System.out.println("Works controller Called");
        return "works";
    }

    @GetMapping("/contact")
    public String contactsPage(){
        System.out.println("Contacts Controller Called");
        return "contact";
    }
}
