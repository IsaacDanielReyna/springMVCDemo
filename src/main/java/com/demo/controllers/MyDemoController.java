package com.demo.controllers;

import com.demo.model.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.util.Random;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

// Cookies
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SessionAttributes("aNewAccount")
public class MyDemoController {
    // http://localhost:8080/springMVCDemo/getQuote.html

    private String [] quotes = {
            "to be or not to be",
            "spring is nature's way of saying 'let's party",
            "the time is always right to do what's right"
    };

    // @RequestMapping(value = "/getQuote", params="from") // other examples: params="from", !from, from=Keisha
    // @RequestMapping(value = "/getQuote", headers = "X-API-KEY")
    // @RequestMapping(value = "/getQuote", headers = "X-API-KEY=7654321")
    @RequestMapping(value = "/getQuote")
    public String getRandomQuote(@RequestParam("userName") String userName, Model model){

        System.out.println("URL Mapped Successfully");
        int rand = new Random().nextInt(quotes.length);
        String randomQuote = quotes[rand];

        model.addAttribute("randomQuote", randomQuote); // var get passed to view

        System.out.println("Username is: " + userName);
        model.addAttribute("userName", userName);

        return "quote"; // view name
    }

    // I've commented the following because it would force me to add ?userName to the URL on any mapping
    /**
    // @ModelAttribute run before any @RequestMapping
    @ModelAttribute
    public void setUserDetails(@RequestParam ("userName") String userName, Model model){
        model.addAttribute("userName", userName);

        // Simulate going off and retrieving role based on userName
        String userRole = "undefined";

        if(userName.equals("Andy")){
            userRole = "Student";
        } else if (userName.equals("John")){
            userRole = "Teacher";
        } else if (userName.equals("Allana")){
            userRole = "Dean";
        }

        model.addAttribute("userRole", userRole);

        System.out.println("Model updated with user information.");
    }
    /**/
    // Defining Method that Enhance the Spring Model

    @RequestMapping(value = "/createAccount")
    public String createAccount(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result){

        if(account.getFirstName() == "admin") {
            System.out.println("you can't use admin"); // print "you can't use admin";
        }

        if(result.hasErrors()){
            System.out.println("Error: " + account.getFirstName() + " " + account.getLastName());
        } else {
            System.out.println("No Error: " + account.getFirstName() + " " + account.getLastName());
        }

        return "createAccount";
    }

    @RequestMapping(value = "/accountCreated", method = RequestMethod.POST)
    public String performCreate(Account account){
        System.out.println(account.getFirstName() + " " + account.getLastName() + " ");
        return "accountCreated";
    }



    // Uploading Files Using Commons FileUpload
    @RequestMapping(value = "myForm")
    public String myForm(){
        return "myForm";
    }

    @RequestMapping(value="/handleForm")
    public String handleForm(@RequestParam("file") MultipartFile file){

        try{
            if (!file.isEmpty()){
                byte[] bytes = file.getBytes();
                FileOutputStream fos = new FileOutputStream("C:\\dev\\uploads\\myFile.jpg");
                fos.write(bytes);
                fos.close();
                System.out.println("File saved successfully");
            } else {
                System.out.println("No file available to save.");
            }

        } catch(Exception e) {
            System.out.println("Error saving file.");
        }
        return "operationComplete";
    }

    // Redirecting in Spring MVC
    @RequestMapping(value="/doCreate")
    public String doCreate(@ModelAttribute ("aNewAccount") Account account){
        System.out.println("Do Create: New account info: " + account.getFirstName() + " " + account.getLastName());
        System.out.println("Do Create: Going off and creating an actual account");

        // TODO: Implement saving given information to database.

        // Redirect to accConfirm
        return "redirect:accConfirm";
    }


    // Using @SessionAttributes Annotation
    @ModelAttribute
    public void addAccountToModel(Model model){
        System.out.println("Making sure account object is on model");
        if (!model.containsAttribute("aNewAccount")){
            Account a = new Account();
            model.addAttribute("aNewAccount", a);
        }
    }

    @RequestMapping(value="/accConfirm")
    public String accountConfirmation(@ModelAttribute("aNewAccount") Account account){
        System.out.println("Account confirmed: Welcome " + account.getFirstName() + " " + account.getLastName());
        // TODO: Understand why the above println only works with Session and addAccounToModel
        return "accountCreated";
    }



    // Working with Cookies in Spring MVC
    @RequestMapping(value="/addCookie")
    public String addCookie(HttpServletResponse response){
        // Add a random cookie
        response.addCookie(new Cookie("myRandomCookie", "aCookieIAdded"));

        System.out.println("Cookie added");

        return "demoPage";
    }

    @RequestMapping(value="/getCookie")
    public String getCookie(@CookieValue("myRandomCookie") String myCookie){
        System.out.println("Cookie retrieved:" + myCookie);

        return "demoPage";
    }

    // END
}
