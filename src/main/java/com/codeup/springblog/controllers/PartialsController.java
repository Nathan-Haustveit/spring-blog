package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partials")
public class PartialsController {
    @GetMapping
    public String showNavbar(){
        return "views-lecture/partials-test";
    }

}
