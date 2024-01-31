package com.test.java.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.LogInView;

public class LogInController {
	
	public void logIn() {
		ArrayList<String> inputList = new ArrayList<String>();
		inputList = LogInView.getInput();
		
		User user = new User();
		
		try {
			BufferedReader reader
				= new BufferedReader(new FileReader(Data.getUser())); 
			
			String line = null;
			while((line = reader.readLine()) != null) {
				String[] tmp = line.split(",");
				
				if(tmp[1].equals(inputList.get(0))) {
					break;
				} else {
					System.out.println("해당 ID를 찾을 수 없습니다.");
				}
			}
			
			
		} catch (Exception e) {

		}
		
		
	
	}
	
}
     