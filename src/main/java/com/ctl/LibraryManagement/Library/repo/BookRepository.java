package com.ctl.LibraryManagement.Library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ctl.LibraryManagement.Library.model.Book;





@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
	@Query(value="SELECT * from Book  ", nativeQuery = true )   // using @query
    List<Book> findAllBooks();
	
	 

}
