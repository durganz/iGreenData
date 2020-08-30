package com.durganz.microservices.booksinfoservice.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@ApiModel(description="This is the description about BookInfo")
public class BookInfo {
	
	@Id
	@GeneratedValue
	@Min(1)
	private Integer bookId;
	
	@ApiModelProperty(notes="Name of the book")
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
