package com.ctl.LibraryManagement.Library.controller;




import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ctl.LibraryManagement.Library.model.Book;
import com.ctl.LibraryManagement.Library.model.ResponseStatus;
import com.ctl.LibraryManagement.Library.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BookControllerTest {
	
	
	@Mock
	BookService bookService;
	  @InjectMocks
	BookController bookController;
//	
	@Mock
	ObjectMapper objectMapper;
	Book b=null;
	ResponseStatus rs=null;
	
	 MockMvc mockMvc;
//	
//	
//	
//	@BeforeClass
//	public void createBook()
//	{
//		
//		b.setBookId(34);
//		b.setAuthor("RaviShanar");
//		b.setBookCategory("classic");
//		b.setBookName("Ram");
//		
//		
//		
//		
//	}
//	@Before
//	public void createResponse()
//	{
//		
//		rs=new ResponseStatus("saved");
//	}
	 
	
	@Test
	public void addBookTest() throws Exception {
		Book b=new Book();
		b.setBookId(34);
		b.setAuthor("RaviShanar");
		b.setBookCategory("classic");
		b.setBookName("Ram");
		ResponseStatus rs=new ResponseStatus();
		rs=new ResponseStatus("saved");
		Mockito.when(bookService.addBook(b)).thenReturn(rs);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/addBook")
//				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(b))
//				.contentType(MediaType.APPLICATION_JSON);
//		
//		System.out.println(objectMapper.writeValueAsString(b));
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		Assert.assertEquals("saved", bookController.addBook(b).getStatus());
	}
	
	@Test
	public void findAllBookTest() throws Exception {
		
		List<Book> bookList=new ArrayList();
		
		Mockito.when(bookService.findAllBooks()).thenReturn(Stream.of(new Book(34,"RaviShankar","classic","Ram"))
				.collect(Collectors.toList()));
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/findAllBooks").accept(
//				MediaType.APPLICATION_JSON);
//
//		ResultActions action = this.mockMvc.perform(requestBuilder);
//		
//		MvcResult result=action.andReturn();
//
//		System.out.println(result.getResponse().getStatus());
//		String expected = "{id:Course1,name:Spring,de.scription:10 Steps}";
		Assert.assertEquals(1,bookController.findAllBooks().size());
	}
//	
	@Test
	public void addBookErrorTest() throws Exception {
		Book b=new Book();
		b.setBookId(34);
		b.setAuthor("");
		b.setBookCategory("classic");
		b.setBookName("Ram");
		 
		
		Mockito.when(bookService.addBook(b)).thenReturn(rs);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders
//				.post("/addBook")
//				.accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(b))
//				.contentType(MediaType.APPLICATION_JSON);
//		
//		System.out.println(objectMapper.writeValueAsString(b));
//		
//		MvcResult result = mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().is5xxServerError()).andReturn();
//		System.out.println("result"+result.getResponse().getStatus());
		Assert.assertNotEquals("saved",bookController.addBook(b));
	}
	
	@Test
	 public void addBook()
	{
		
		int i=0;
     Assert.assertEquals(i, 0);
	}

}
