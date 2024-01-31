package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Store;
import com.test.java.view.StoreView;

public class StoreController {
	
	private StoreView storeView;
	private ArrayList<Store> storeList;
	
	public StoreController(StoreView storeView, ArrayList<Store> storeList) {
		this.storeView = storeView;
		this.storeList = storeList;
	}
	
	
	
}
