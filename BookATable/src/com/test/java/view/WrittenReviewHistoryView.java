package com.test.java.view;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Inquiry;
import com.test.java.model.Menu;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class WrittenReviewHistoryView {
	
	public static ArrayList<Review> reviewList = new ArrayList<>();
	public static ArrayList<Store> storeList = new ArrayList<>();
	
	
	public void showWrittenReviewHistory(String name) {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.printf("■           %s님 작성 리뷰 조회		   ■", name);
		System.out.println();
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println();

		String header = String.format("%-15s\t%-20s\t%-15s%-15s%-20s", "[작성일]","[상호명]","[메뉴]","[별점]","[리뷰내용]");
		System.out.println(header);
		
		if(Data.reviewList.isEmpty()) {
			System.out.println();
			System.out.println("리뷰 내역이 없습니다.");
			System.out.println();
			View.pause();
		} else {
			for(Review r : Data.reviewList) {
			String storeNameFromReview = findStoreNameById(r.getLicenseNumber()); // 상호명 찾기
				String menuFromReview = getMenuById(r.getLicenseNumber()); // 메뉴 찾기
				String tmp = String.format("%-15s\t%-20s\t%-15s%-15s\t%-20s",
						r.getDateWritten(),
						storeNameFromReview,
						menuFromReview,
						r.getScore(),
						r.getContent());

				System.out.println(tmp);
				
			}
		}
	}

private String findStoreNameById(String id) {
	for (Store s : Data.storeList) {
		if (s.getLicenseNumber().equals(id)) {
			return s.getStoreName();
	
		}
	}
	return null;
}


// 메뉴 찾기
private String getMenuById(String id) {
	for (Menu m : Data.menuList) {
		if (m.getLicenseNumber().equals(id)) {
			return m.getMenuName();
			}
		}
	
		return null;
	}
}