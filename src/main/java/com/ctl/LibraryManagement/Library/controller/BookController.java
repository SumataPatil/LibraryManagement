package com.ctl.LibraryManagement.Library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ctl.LibraryManagement.Library.model.Book;
import com.ctl.LibraryManagement.Library.model.ResponseStatus;
import com.ctl.LibraryManagement.Library.service.BookService;

@RestController
public class BookController {
	
	@Autowired 
	BookService bookService;
	
	@RequestMapping("/addBook")
	public ResponseStatus addBook(@Valid @RequestBody  Book book)
	{
		return bookService.addBook(book);
	}
	
	
	@RequestMapping("/findAllBooks")
	public List<Book> findAllBooks()
	{
		return bookService.findAllBooks();
	}
	

}
