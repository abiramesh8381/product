package com.product.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.redis.entity.Product;
import com.product.redis.respository.ProductDao;

@RestController
@RequestMapping
public class ProductController {
	@Autowired
    private ProductDao dao;

    @PostMapping("/product")
    public Product save(@RequestBody Product product) {
    	System.out.println("product "+product.toString());
    	System.out.println("product id"+product.getId());
        return dao.save(product);
    }

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/product/{id}")
   @Cacheable(key = "Product"+"#id",value = "Products")
    public String findProduct(@PathVariable int id) {
    	System.out.println("Inside Cache");
        return dao.findProductById(id);
    }

    @DeleteMapping("/product/{id}")
    @CacheEvict(key = "#id",value = "Products")
    public String remove(@PathVariable int id) {
         return dao.deleteProduct(id);
       // return true;
    }

}
