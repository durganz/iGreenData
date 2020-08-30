package com.durganz.microservices.bookscatalogservice.bean;



public class BookInfo {
	

	private Integer bookId;
	private String name;
	
	public BookInfo() {
		super();
	}
	
	public BookInfo(int bookId, String name) {
		super();
		this.bookId = bookId;
		this.name = name;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
