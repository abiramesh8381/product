package com.product.redis.respository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.product.redis.entity.Product;

import java.util.List;

@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate template;

    public Product save(Product product){
        //template.opsForHash().put(HASH_KEY,product.getId(),product);
    	//template.opsForHash().put(product.getId()+HASH_KEY,product.getId(),product.toString());
    	template.opsForValue().set(HASH_KEY+product.getId(),product.toString());
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public String findProductById(int id){
        System.out.println("called findProductById() from DB");
        //return (Product) template.opsForHash().get(HASH_KEY+id,id);
       return  (String) template.opsForValue().get(HASH_KEY+id);
    }


    public String deleteProduct(int id){
    	if(template.opsForValue().getOperations().delete(HASH_KEY+id))
    		 return "product "+id+" removed !!" ;
    	else
    		 return "product "+id+" not removed !!" ;
    //	template.opsForHash().delete(HASH_KEY+id, id);
       // template.opsForHash().
         //template.opsForValue().(HASH_KEY+id);
       // return "product "+id+" removed !!" ;;
    }
}
