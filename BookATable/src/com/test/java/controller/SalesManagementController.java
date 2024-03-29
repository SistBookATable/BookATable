package com.test.java.controller;

import com.test.java.view.SalesManagementView;

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
