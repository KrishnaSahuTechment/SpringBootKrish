package com.techment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book501")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IsBN;
	private String title;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="author_id")
	private Author author;


	public Book() {
		super();
	}


	public Book(String title, double price, Author author) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
	}

	

	public Integer getIsBN() {
		return IsBN;
	}


	public void setIsBN(Integer isBN) {
		IsBN = isBN;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Author getAuthor() {
		return author;
	}


	public void setAuthor(Author author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [IsBN=" + IsBN + ", title=" + title + ", price=" + price + ", author=" + author + "]";
	}

	
	
	
}
