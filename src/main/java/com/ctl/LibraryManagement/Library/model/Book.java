package com.ctl.LibraryManagement.Library.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
@Entity

public class Book implements Serializable {
	
	
	@Id
	int bookId;
	
	  @NotBlank(message = "Author is required")
	String author  ;
	  @NotBlank(message = "Book name is required")
    String bookName;	
   
   
    String returnDate;							 
   //Address address;
   
    int numbers ;
   
    
   
    public Book() {
		super();
	}

	public Book(int bookId, @NotBlank(message = "Author is required") String author,
		@NotBlank(message = "Book name is required") String bookName,
		@NotBlank(message = "bookCategory is required") String bookCategory) {
	super();
	this.bookId = bookId;
	this.author = author;
	this.bookName = bookName;
	this.bookCategory = bookCategory;
}

	@NotBlank(message = "bookCategory is required")
    String bookCategory ;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	

	

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
    
    

}
