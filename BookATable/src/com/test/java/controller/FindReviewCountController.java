package com.test.java.controller;

import java.util.Comparator;

import com.test.java.model.Store;

public class FindReviewCountController implements Comparator<Store> {

	@Override
	public int compare(Store o1, Store o2) {
		int review1 = o1.getReviewCount();
		int review2 = o2.getReviewCount();
		
		return Integer.compare(review2, review1);
	}
}
