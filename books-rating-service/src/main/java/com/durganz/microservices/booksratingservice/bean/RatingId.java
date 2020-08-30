package com.durganz.microservices.booksratingservice.bean;

import java.io.Serializable;

public class RatingId implements Serializable {
	
	private String userId;
	private Integer bookId;
 
	public RatingId(){

    }
 
    public RatingId(String userId, Integer bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

}