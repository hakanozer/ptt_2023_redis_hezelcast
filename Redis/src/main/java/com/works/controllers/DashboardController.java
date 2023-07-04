package com.works.controllers;

import com.works.entities.Product;
import com.works.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class DashboardController {

    final ProductService productService;
    final HttpServletRequest request;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        boolean status = request.getSession().getAttribute("admin") == null;
        if (status) {
            return "redirect:/";
        }
        model.addAttribute("allProduct", productService.all());
        return "dashboard";
    }

    @PostMapping("/productAdd")
    public String productAdd(Product product) {
        productService.save(product);
        return "redirect:/dashboard";
    }

    @GetMapping("/delete/{pid}")
    public String productDelete(@PathVariable Long pid) {
        productService.delete(pid);
        return "redirect:/dashboard";
    }

}
