package com.product.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import com.product.redis.controller.ProductController;
import com.product.redis.entity.Product;
import com.product.redis.respository.ProductDao;

import java.util.List;

@SpringBootApplication
/*@RestController
@RequestMapping("/product")
@EnableCaching*/
public class SpringDataRedisExampleApplication {
/*
    @Autowired
    private ProductDao dao;

    @PostMapping
    public Product save(@RequestBody Product product) {
    	System.out.println("product "+product.toString());
    	System.out.println("product id"+product.getId());
        return dao.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
   @Cacheable(key = "Product"+"#id",value = "Products")
    public String findProduct(@PathVariable int id) {
    	System.out.println("Inside Cache");
        return dao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Products")
    public String remove(@PathVariable int id) {
         return dao.deleteProduct(id);
       // return true;
    }
*/

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }

}
