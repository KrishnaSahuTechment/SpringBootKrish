package com.techment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techment.dao.IProductDao;
import com.techment.entity.Product;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner {

	@Autowired
	IProductDao iProductDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		System.out.println("Hello this is my first spring boot program");
		
		Product product1 = new Product("laptop", "electronics",45000);
		Product product2 = new Product("mobile", "electronics",45000);						
		iProductDao.save(product1);
		iProductDao.save(product2);		
		System.out.println("inserted");
		
		System.out.println("=========findAll=======================");
		List<Product> products = iProductDao.findAll();
		products.forEach(System.out::println);

		System.out.println("=========find by id =====================");
		Optional<Product> product = iProductDao.findById(1);
		
		if(product.isPresent())
			System.out.println(product.get());
		else
			System.out.println("Not present");
		
		System.out.println("=========Total count==================");
		
		long totalProduct = iProductDao.count();
		
		System.out.println("totalProduct: "+totalProduct);
		
		System.out.println("================List by name=====================");
		
		
//		List<Product> prodListByName = iProductDao.findByName("laptop");
//		System.out.println("prodListByName :"+prodListByName);
		
		System.out.println("================List by category=====================");
		List<Product> prodListByCategory = iProductDao.findByCategory("electronics");
		System.out.println("prodListByCategory: "+prodListByCategory);
		
		
		
		
		
	}

	
	
}
