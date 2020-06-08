package com.ctl.LibraryManagement.Library;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ctl.LibraryManagement.Library.controller.BookController;
import com.ctl.LibraryManagement.Library.model.Book;
import com.ctl.LibraryManagement.Library.model.ResponseStatus;
import com.ctl.LibraryManagement.Library.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
	
	
	@Mock
	BookService bookService;
	@Autowired
	BookController bookController;
	
	@Autowired
	ObjectMapper objectMapper;
	Book b=null;
	ResponseStatus rs=null;
	@Autowired
	private MockMvc mockMvc;
	
	
	
	@BeforeClass
	public void createBook()
	{
		
		b.setBookId(34);
		b.setAuthor("RaviShanar");
		b.setBookCategory("classic");
		b.setBookName("Ram");
		
		
		
		
	}
	@Before
	public void createResponse()
	{
		
		rs=new ResponseStatus("saved");
	}
	
	@Test
	void addBookTest() throws Exception {
		Book b=new Book();
		b.setBookId(34);
		b.setAuthor("RaviShanar");
		b.setBookCategory("classic");
		b.setBookName("Ram");
		 
		
		Mockito.when(bookService.addBook(b)).thenReturn(rs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addBook")
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(b))
				.contentType(MediaType.APPLICATION_JSON);
		
		System.out.println(objectMapper.writeValueAsString(b));
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
	}
	
	@Test
	void findAllBookTest() throws Exception {
		
		List<Book> bookList=new ArrayList();
		
		Mockito.when(bookService.findAllBooks()).thenReturn(Stream.of(new Book(34,"RaviShankar","classic","Ram"))
				.collect(Collectors.toList()));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/findAllBooks").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse().getStatus());
		String expected = "{id:Course1,name:Spring,de.scription:10 Steps}";
		assertEquals(HttpStatus.OK.value(),result.getResponse().getStatus());
	}
	
	@Test
	void addBookErrorTest() throws Exception {
		Book b=new Book();
		b.setBookId(34);
		b.setAuthor("");
		b.setBookCategory("classic");
		b.setBookName("Ram");
		 
		
		Mockito.when(bookService.addBook(b)).thenReturn(rs);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addBook")
				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(b))
				.contentType(MediaType.APPLICATION_JSON);
		
		System.out.println(objectMapper.writeValueAsString(b));
		
		MvcResult result = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is5xxServerError()).andReturn();
		System.out.println("result"+result.getResponse().getStatus());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getResponse().getStatus());
	}

}
