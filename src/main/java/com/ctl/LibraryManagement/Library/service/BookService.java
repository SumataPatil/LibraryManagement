package com.ctl.LibraryManagement.Library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ctl.LibraryManagement.Library.model.Book;
import com.ctl.LibraryManagement.Library.model.ResponseStatus;





public interface BookService {

		
	ResponseStatus addBook(Book book);

	List<Book> findAllBooks();

	}


