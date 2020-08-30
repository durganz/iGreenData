package com.durganz.microservices.bookscatalogservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.durganz.microservices.bookscatalogservice.bean.BookRating;

@FeignClient(name="books-rating-service")
@RibbonClient(name="books-rating-service")
public interface BookRatingServiceProxy {
	
	@GetMapping("/rating/{userId}")
	public BookRating[] retrieveBookRating(@PathVariable("userId") String userId);

}
