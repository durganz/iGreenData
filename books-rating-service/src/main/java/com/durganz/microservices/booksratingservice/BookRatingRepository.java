package com.durganz.microservices.booksratingservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durganz.microservices.booksratingservice.bean.BookRating;

public interface BookRatingRepository extends JpaRepository<BookRating, Integer>{
	 
	List<BookRating> findByUserId(String userId);
}
