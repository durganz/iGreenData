package com.durganz.microservices.booksratingservice.bean;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="This is the description about book rating ")
@IdClass(RatingId.class)
public class BookRating {
	
	
	
	@JsonIgnore
	@Id
	@NotBlank(message = "UserId is mandatory")
	private String userId;
	
	@Id
	@Min(1)
	private int bookId;
	
//	@ManyToOne
//	@JoinColumn(name = "bookId", insertable = false, updatable = false)
//  private BookInfo bookInfo;
	
	@ApiModelProperty(notes="Rating of the book")
	@Min(1)
	@Max(10)
	@Digits(fraction = 1, integer = 3)
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
