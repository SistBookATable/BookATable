package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

public class LogInView {

	public static ArrayList<String> getInput() {
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> tmp = new ArrayList<String>();
		
		System.out.print("ID: ");
		tmp.add(scan.nextLine());
		
		System.out.print("PW: ");
		tmp.add(scan.nextLine());
		
		return tmp;
	}
	
	
	
}
