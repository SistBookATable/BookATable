package com.test.java.controller;

import java.util.Comparator;

import com.test.java.model.Store;


public class FindByNameController implements Comparator<Store> {

	@Override
	public int compare(Store o1, Store o2) {

		double score1 = o1.getScore();
		double score2 = o2.getScore();
		
		return Double.compare(score2, score1);

	}
}















