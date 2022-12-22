package com.youcode.visionarycrofting.controller;

import com.youcode.visionarycrofting.classes.Message;
import com.youcode.visionarycrofting.entity.Client;
import com.youcode.visionarycrofting.entity.Product;
import com.youcode.visionarycrofting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "visionarycrofting/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = {"/products","/",""})
    @ResponseBody
    public List < Product > getProducts()
    {
        return productService.getProducts();
    }

    @PostMapping(path = {"/addProduct","/addproduct","/add","/new"})
    @ResponseBody
    public Product addProduct(@RequestBody Product product) {
            return productService.addProduct(product);
    }

    @PutMapping("/updateproduct")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Integer deleteProduct(@PathVariable Long id){ return productService.deleteProduct(id);}
}
