package com.travelwithme.TravelLog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//redirect to index form
@Controller
public class HomeController {
    @GetMapping
    public String index(){
        return "index";
    }
}
