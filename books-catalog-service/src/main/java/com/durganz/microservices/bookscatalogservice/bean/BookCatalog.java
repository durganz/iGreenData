package com.durganz.microservices.bookscatalogservice.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookCatalog {
	
	@JsonIgnore
	private String userId;
	private Integer bookId;
	private String name;
	private float rating;
	
	public BookCatalog() {
		super();
	}
	
	public BookCatalog(String userId, Integer bookId, String name, float rating) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.name = name;
		this.rating = rating;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}

}
