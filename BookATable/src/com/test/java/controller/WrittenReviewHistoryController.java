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

/**
 * 작성한 리뷰를 조회하는 기능을 담당하는 Controller 클래스입니다.
 */
public class WrittenReviewHistoryController {
	
	/**
	 * 작성한 리뷰를 조회하는 메서드입니다.
	 * 사용자의 ID를 기반으로 해당 사용자가 작성한 리뷰를 조회하고 해당 리뷰를 출력합니다.
	 */
	public void writtenReviewHistory() {
		
		WrittenReviewHistoryController writtenReviewHistoryController = new WrittenReviewHistoryController();
	
		String id = Member.id; // 사용자 ID 지정
		String name = writtenReviewHistoryController.findNameById(id);
		
		
		WrittenReviewHistoryView writtenReviewHistoryView = new WrittenReviewHistoryView();
		writtenReviewHistoryView.showWrittenReviewHistory(name);
		
	}


	/**
	 * 사용자 ID로 이름을 찾는 메서드입니다.
	 * @param id 사용자 ID
	 * @return 사용자 ID에 해당하는 이름을 반환합니다. 없을 경우, null을 반환합니다.
	 */
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
	
