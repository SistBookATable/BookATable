package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.Review;
import com.test.java.view.RequestView;

public class RequestController {
	
	public void requestManagement() {
		RequestView requestView = new RequestView();
		
		boolean loop = true;
		while(loop) {

			requestView.FindAllRequest();
		}
	}
	

}
