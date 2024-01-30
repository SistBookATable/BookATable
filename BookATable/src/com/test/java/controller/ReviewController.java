package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Review;
import com.test.java.view.ReviewView;

public class ReviewController {
	
	private ReviewView reviewView;
	private ArrayList<Review> reviewList;
	
	public ReviewController(ReviewView reviewView, ArrayList<Review> reviewList) {
		this.reviewList=reviewList;
		this.reviewView=reviewView;
	}
	
	public void delete(int reviewNumber) {
		
	}
	

}
