package com.test.java.view;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Review;
import com.test.java.model.Store;

public class WrittenReviewHistoryView {
	
	public static ArrayList<Review> reviewList = new ArrayList<>();
	public static ArrayList<Store> storeList = new ArrayList<>();
	
	
	public void showWrittenReviewHistory(String name, Calendar dateWritten, String storeName, String menu, String content) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 작성 리뷰 조회		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("[작성일]\t[상호명]\t[메뉴]\t[리뷰내용]");
		System.out.printf("[%s]\t[%s]\t[%d]\t[%s]\n", dateWritten, storeName, menu, content);
		
		
	}

}
