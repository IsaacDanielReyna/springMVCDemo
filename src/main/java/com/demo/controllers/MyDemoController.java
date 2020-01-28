package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
public class MyDemoController {
    // http://localhost:8080/springMVCDemo/getQuote.html

    private String [] quotes = {
            "to be or not to be",
            "spring is nature's way of saying 'let's party",
            "the time is always right to do what's right"
    };

    @RequestMapping(value = "/getQuote")
    public String getRandomQuote(Model model){
        int rand = new Random().nextInt(quotes.length);
        String randomQuote = quotes[rand];

        model.addAttribute("randomQuote", randomQuote);
        return "quote"; // view name
    }
}
