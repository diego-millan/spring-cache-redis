package com.diegomillan.cachingdemo;

import com.diegomillan.cachingdemo.service.ProductService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class CachingdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CachingdemoApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(ProductService service) {
		return args -> {
			System.out.println("Id: 1: " + service.getById(1L));
			System.out.println("Id: 2: " + service.getById(2L));
			System.out.println("Id: 1: " + service.getById(1L));
			System.out.println("Id: 2: " + service.getById(2L));
			System.out.println("Id: 3: " + service.getById(3L));
			System.out.println("Id: 4: " + service.getById(4L));
			System.out.println("Id: 5: " + service.getById(5L));
			System.out.println("Id: 5: " + service.getById(5L));
		};
	}
}
