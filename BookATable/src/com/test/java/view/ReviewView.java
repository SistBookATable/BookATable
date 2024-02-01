package com.test.java.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.Review;

public class ReviewView {
	
	
	public void show(ArrayList<Review> review) {
		
		
	}
	
	public int getNumber() {
		Scanner scan=new Scanner(System.in);
		System.out.print("삭제할 리뷰 선택 : ");
		return scan.nextInt();
	}

}
