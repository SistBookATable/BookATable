package com.test.java.controller;

import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.model.Review;
import com.test.java.repository.Data;
import com.test.java.view.ReviewManagementView;
import com.test.java.view.SignOutUserManagementView;

public class ReviewManagementController {

	ReviewManagementView reviewManagementView = new ReviewManagementView();
	
	public int reviewManagement(Review selected, String reason) {
		
		boolean loop = true;
		while(loop) {
			reviewManagementView.show(selected,reason);
			reviewManagementView.showSelectBox();
			int choice = reviewManagementView.getSelectType();
			
			switch (choice) {
			case 1:
				//리뷰 삭제
				deleteReview(selected.getReviewNumber());
				return choice;
			case 2:
				//요청 거부
				return choice;
			case 0:
				//뒤로가기
				return choice;
			default:
				break;
			}
		}
		return 0;
	}

	private void deleteReview(int reviewNumber) {

		Iterator it = Data.reviewList.iterator();

		while(it.hasNext()) {
			Review r = (Review)it.next();

			if(r.getReviewNumber() == reviewNumber) {

				it.remove();
				reviewManagementView.deleteSuccessMessage();
			}	
		}
	}

}
