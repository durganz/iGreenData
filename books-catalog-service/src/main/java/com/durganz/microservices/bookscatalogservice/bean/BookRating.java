package com.durganz.microservices.bookscatalogservice.bean;


public class BookRating {
	
	private String userId;

	private int bookId;
	
	private float rating;
	
	public BookRating() {
		super();
	}
	public BookRating(String userId, int bookId, float rating) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.rating = rating;
	}
	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
