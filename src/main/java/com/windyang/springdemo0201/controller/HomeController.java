package com.windyang.springdemo0201.controller;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author windyang
 */
@Controller
@RequestMapping("/home")
public class HomeController {


    @Value("${taco.orders.pageSize}")
    private int pageSize;


    @GetMapping("/index")
    public String index(){

        System.out.println("pageSize = " + pageSize);

        return "index";
    }

}
