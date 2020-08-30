package com.durganz.microservices.booksinfoservice;

import org.springframework.data.jpa.repository.JpaRepository;

import com.durganz.microservices.booksinfoservice.bean.BookInfo;

public interface BookInfoRepository extends JpaRepository<BookInfo, Integer>{
	 
	BookInfo findById(int bookId);
}
