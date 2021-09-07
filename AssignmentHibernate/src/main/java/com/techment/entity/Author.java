package com.techment.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="auther501")
public class Author {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String name;   


	 
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Book> books; 

    

	public Author() {
		super();
	}



	public Author(String name) {
		super();
		this.name = name;
	}


	

	public Integer getAuthorId() {
		return Id;
	}



	public void setAuthorId(Integer authorId) {
		this.Id = authorId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Set<Book> getBooks() {
		return books;
	}



	public void setBooks(Set<Book> books) {
		this.books = books;
	}



	@Override
	public String toString() {
		return "Author [Id=" + Id + ", name=" + name + ", books=" + books + "]";
	}



	



	

	
	    
        
    
}
