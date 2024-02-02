package com.test.java.controller;

import com.test.java.model.Request;
import com.test.java.model.Review;
import com.test.java.repository.Data;
import com.test.java.view.RequestView;

public class RequestController {
	
	public void requestManagement() {
		RequestView requestView = new RequestView();
		
		boolean loop = true;
		while(loop) {

			requestView.FindAllRequest();
			requestView.showSelectBox();
			int choice = requestView.getSelectType();
			
			if(choice == 1) {
				//요청 번호 입력 받기
				String requestNumber = requestView.getRequestNumber();
				
				//요청번호를 사용해서 요청사유 찾기
				String reason = findReason(requestNumber);
				
				//요청번호를 사용해서 리뷰내용 찾기
				int reviewNumber = findReviewNumber(requestNumber);
				Review selected = findReview(reviewNumber);
				
				//리뷰내용 보고 승인하기
				ReviewManagementController reviewManagementController = new ReviewManagementController();
				reviewManagementController.reviewManagement(selected, reason);
			}
			else if(choice == 0) {
				loop = false;
			}
		}
	}

	private String findReason(String requestNumber) {

		for(Request request : Data.requestList) {
			if(request.getRequestNumber()==Integer.parseInt(requestNumber)) {
				return request.getReason();
			}
		}
		return null;
	}

	private Review findReview(int reviewNumber) {
		for(Review r : Data.reviewList) {
			if(r.getReviewNumber() == reviewNumber) {
				return r;
			}
		}
		return null;
	}

	private int findReviewNumber(String requestNumber) {
		for(Request request : Data.requestList) {
			if(request.getRequestNumber()==Integer.parseInt(requestNumber)) {
				return request.getReviewNumber();
			}
		}
		return 0;
	}
	

}
