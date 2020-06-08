package com.ctl.LibraryManagement.Library.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctl.LibraryManagement.Library.model.Book;
import com.ctl.LibraryManagement.Library.model.ResponseStatus;
import com.ctl.LibraryManagement.Library.repo.BookRepository;
import com.ctl.LibraryManagement.Library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	 @Autowired
	  BookRepository bookRepository;
	   //private static final String FILE_NAME = "C:/Project/Book1.xlsx";

	   
	   

	@Override
	public ResponseStatus addBook(Book book) {
		// TODO Auto-generated method stub
		Book bookRes=bookRepository.save(book);
		ResponseStatus rs=new ResponseStatus();
		if(bookRes.getBookId()>0)
{
	rs.setStatus("saved");
}
		return rs;
			}

	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAllBooks();
	}

}
