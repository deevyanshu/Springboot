package com.deevyanshu.elasticsearch.service;

import com.deevyanshu.elasticsearch.Entity.Product;
import com.deevyanshu.elasticsearch.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product insert(Product product)
    {
        return productRepository.save(product);
    }

    public Product update(Product product,int id)
    {
        Product prod=productRepository.findById(id).get();
        prod.setPrice(product.getPrice());
        return prod;
    }

    public String delete(int id)
    {
        productRepository.deleteById(id);
        return "Deleted";
    }
}
