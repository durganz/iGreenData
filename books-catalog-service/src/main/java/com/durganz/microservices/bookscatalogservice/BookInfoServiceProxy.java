package com.durganz.microservices.bookscatalogservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.durganz.microservices.bookscatalogservice.bean.BookInfo;
import com.durganz.microservices.bookscatalogservice.bean.BookRating;

@FeignClient(name="books-info-service")
@RibbonClient(name="books-info-service")
public interface BookInfoServiceProxy {
	
	@GetMapping("/books/{bookId}")
	public BookInfo retrieveBookInfo(@PathVariable("bookId") Integer bookId);

}
