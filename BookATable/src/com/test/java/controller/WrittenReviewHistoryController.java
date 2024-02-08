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
	
