package com.test.java;

import com.test.java.controller.MainController;
import com.test.java.repository.Data;

public class Main {
	public static void main(String[] args) {
//		Data.loadBlackList();
//		Data.loadOperatingHours();
//		Data.loadFaq();
		MainController.load();
		MainController.start();  
	}
}

