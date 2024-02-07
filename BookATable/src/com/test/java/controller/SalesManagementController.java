package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Review;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.ReviewRepository;
import com.test.java.view.SalesManagementView;
import com.test.java.view.View;

public class SalesManagementController {

	SalesManagementView salesManagementView = new SalesManagementView();
	
	public void salesManagemnet() {
		
		boolean loop = true;
		while(loop) {
			
			salesManagementView.showTitle();
			salesManagementView.showSelectBox();
			int choice = salesManagementView.getSelectType();
			
			switch (choice) {
			case 1:
				//리뷰 조회
				BusinessUserReviewController businessUserReviewController = new BusinessUserReviewController();
				businessUserReviewController.reviewManagement();
				break;
			case 2:
				//즐겨찾기 조회
				BusinessUserBookmarkController businessUserBookmarkController = new BusinessUserBookmarkController();
				businessUserBookmarkController.bookmarkManagement();
				break;
			case 3:
				//고객 관리
				CustomerManagementController customerManagementController = new CustomerManagementController();
				customerManagementController.customerManagement();
				break;
			case 0:
				loop = false;
				break;
			default:
				salesManagementView.incorrectInputMessage();
			}
		}
	}

}
