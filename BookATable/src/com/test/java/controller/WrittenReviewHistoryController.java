package com.test.java.controller;

import java.util.Calendar;
import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Review;
import com.test.java.model.Store;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.FavoriteStoreManagementView;
import com.test.java.view.PointManagementView;
import com.test.java.view.UserMyPageView;
import com.test.java.view.WrittenReviewHistoryView;

public class WrittenReviewHistoryController {
	
	public void writtenReviewHistory() {
		
		WrittenReviewHistoryController writtenReviewHistoryController = new WrittenReviewHistoryController();
	
		String id = Member.id; // 사용자 ID 지정
		String name = writtenReviewHistoryController.findNameById(id);
		
		
		WrittenReviewHistoryView writtenReviewHistoryView = new WrittenReviewHistoryView();
		writtenReviewHistoryView.showWrittenReviewHistory(name);
		
		
		// 사용자가 엔터를 입력할 때까지 대기
				Scanner scan = new Scanner(System.in);
				System.out.println("<<엔터를 입력하면 이전 화면으로 이동합니다.>>");
				while (scan.nextLine().isEmpty()) {
					FavoriteStoreManagementView favoriteStoreManagementView = new FavoriteStoreManagementView();
					favoriteStoreManagementView.showFavoriteStoreManagement();
				}
		
	}


	// 이름
	private String findNameById(String id) {
		
		String name = "";
		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				return u.getName();	
				}
			}
		return null;
		}	
	
	
}
	
