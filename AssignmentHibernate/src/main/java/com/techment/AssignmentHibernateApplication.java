package com.techment;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techment.dao.IAuthorDao;
import com.techment.dao.IBookDao;
import com.techment.entity.Author;
import com.techment.entity.Book;

@SpringBootApplication
public class AssignmentHibernateApplication implements CommandLineRunner {

	@Autowired
	IBookDao iBookDao;
	
	@Autowired
	IAuthorDao iAutherDao;
	
	
	
	
	public static void main(String[] args)  {
		SpringApplication.run(AssignmentHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("this is my first spring boot app============================");
		
		Author auth1 = new Author ("Ebalaguruswami");
		Author auth2 = new Author ("Krishna");
		Author auth3 = new Author ("Anmol");
		Author auth4 = new Author ("Devesh");
		Author auth5 = new Author ("Prateek");
		
		
		iAutherDao.save(auth1);
		iAutherDao.save(auth2);
		iAutherDao.save(auth3);
		iAutherDao.save(auth4);
		iAutherDao.save(auth5);
		
		
		
		
		iBookDao.save(new Book("java",300,auth1));
		iBookDao.save(new Book("C",500,auth2));
		iBookDao.save(new Book("C++",700,auth3));
		iBookDao.save(new Book("HTML",800,auth4));
		iBookDao.save(new Book("JS",900,auth5));
		iBookDao.save(new Book("JSP",1500,auth5));
		
		System.out.println("inserted");
		
		
		
		System.out.println("=============list of all books============");		
		List<Book> bookList = iBookDao.findAll();		
		bookList.forEach(System.out::println);			
			
//		System.out.println("=================find by author name===================");			
//		List<Book> bookListByauth =iBookDao.findByAuthorName("Ebalaguruswami");			
//		bookListByauth.forEach(System.out::println);				
//				
//		System.out.println("=====find by price between 500 to 1000 =======");
//				
//		List<Book> booklistByPrice = iBookDao.findPriceBetween(500, 800);
//		booklistByPrice.forEach(System.out::println);
//				
//		System.out.println("=====find by author name by  =======");		 
//		Optional<Author> auths = iAutherDao.findById(1);		 
//		System.out.println(auths.get().getName()+" "+auths.get().getAuthorId());
		 
		 
	}

}
