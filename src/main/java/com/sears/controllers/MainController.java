package com.sears.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sears.models.Product;
import com.sears.services.MainServices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        System.out.println("*** sayHello ***" );

        return "Hello, World!";
    }

    @GetMapping("/home")
    public String home(Model model) {
        System.out.println("*** home ***" );
        
        MainServices service = new MainServices();
        
        List<Product> products = service.allProducts();
        
        model.addAttribute("products", products);

        return "index";
    }
    
    @GetMapping("/add")
    public String addProductForm(Model model) {
    	System.out.println("*** addProductForm ***" );
    	
        model.addAttribute("product", new Product());
        return "add-product";
    }
    
    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
    	System.out.println("*** addProduct ***" );
    	
    	MainServices service = new MainServices();
    	
    	service.saveAddProduct(product);
        return "redirect:/home";
    }
    
    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable String id, Model model) {
    	System.out.println("*** editProductForm ***" );
    	
    	MainServices service = new MainServices();
    	
        Product product = service.findProduct(id);
        model.addAttribute("product", product);
        
        return "edit-product";
    }
    
    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable String id, @ModelAttribute Product product) {
    	System.out.println("*** editProduct ***" );

    	MainServices service = new MainServices();
    	
    	service.saveEditProduct(product);
    	
        return "redirect:/home";
    }
    
    
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
    	System.out.println("*** deleteProduct ***" );
    	
    	MainServices service = new MainServices();
    	
    	service.deleteProduct(id);
  
        return "redirect:/home";
    }
    
    
    

}
