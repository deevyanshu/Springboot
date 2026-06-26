package com.deevyanshu.elasticsearch.controller;

import com.deevyanshu.elasticsearch.Entity.Product;
import com.deevyanshu.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public Iterable<Product> getAll()
    {
        return productService.getProducts();
    }

    @PostMapping("/insert")
    public Product insert(@RequestBody Product product)
    {
        return productService.insert(product);
    }

    @PutMapping("/update")
    public Product update(@RequestBody Product product,@RequestParam(value = "q",required = true) int id)
    {
        return productService.update(product,id);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "q",required = true) int id)
    {
        return productService.delete(id);
    }
}
