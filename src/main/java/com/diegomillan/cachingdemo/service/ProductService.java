package com.diegomillan.cachingdemo.service;

import com.diegomillan.cachingdemo.model.Product;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {
    Map<Long, Product> products = new HashMap<>() {
        {
            put(1L, new Product(1L, "Notebook", "Macbook Pro"));
            put(2L, new Product(2L, "Notebook", "Dell XPS"));
            put(3L, new Product(3L, "Notebook", "Lenovo ThinkPad"));
            put(4L, new Product(4L, "Notebook", "Acer Aspire"));
            put(5L, new Product(5L, "Notebook", "Dell Alienware"));
        }
    };

    @Cacheable("products")
    public Product getById(Long id) {
        System.out.println(" Searching Product... ");
        simulateLatency();
        return products.get(id);
    }

    private void simulateLatency() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
