package com.test.java;

import com.test.java.controller.MainController;
import com.test.java.repository.Data;

public class Main {
	public static void main(String[] args) {

		MainController.load();
		MainController.start();  
	}
}

