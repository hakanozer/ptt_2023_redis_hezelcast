package com.works.controllers;

import com.works.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @PostMapping("/productAdd")
    public String productAdd(Product product) {
        System.out.println(product);
        return "dashboard";
    }

}
