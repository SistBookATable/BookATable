package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Store;
import com.test.java.view.StoreView;

public class StoreController {
	ArrayList<Store> storeList = new ArrayList<>();
	
	
	private StoreView storeView;
	private ArrayList<Store> storeList;
	
	public StoreController(StoreView storeView, ArrayList<Store> storeList) {
		this.storeView = storeView;
		this.storeList = storeList;
	}
	
	public Calendar findTimeByName(String storeName) {
		Calendar c = Calendar.getInstance();
		
		return c;
	}
}
