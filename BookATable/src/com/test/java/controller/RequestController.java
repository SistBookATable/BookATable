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
			boolean hasRequests = requestView.FindAllRequest();
			if(!hasRequests) {
				return;
			}
			requestView.showSelectBox();
			int choice = requestView.getSelectType();
			
			if(choice == 1) {
				//요청 번호 입력 받기
				String requestNumber = requestView.getRequestNumber();
			
				//입력받은 요청번호가 이미 승인된 요청이면 메시지 출력 후 다시 선택
				if(alreadPermitted(requestNumber)) {
					requestView.showAlreadPermittedMessage();
					continue;
				}
				
				//요청번호를 사용해서 요청사유 찾기
				String reason = findReason(requestNumber);
				
				//요청번호를 사용해서 리뷰내용 찾기
				int reviewNumber = findReviewNumber(requestNumber);
				Review selected = findReview(reviewNumber);
				
				//리뷰내용 보고 승인하기
				ReviewManagementController reviewManagementController = new ReviewManagementController();
				int permission = reviewManagementController.reviewManagement(selected, reason);
				
				//리뷰 삭제 시 요청을 승인으로 변경
				if(permission==1) {
					changeRequestState(requestNumber, "승인");
				}
				else if(permission == 2) {
					changeRequestState(requestNumber, "거부");
				}
				
			}
			else if(choice == 0) {
				loop = false;
			}
		}
	}

	private boolean alreadPermitted(String requestNumber) {
		for(Request r : Data.requestList) {
			if(r.getRequestNumber() == Integer.parseInt(requestNumber)) {
				if(r.getPermission().equals("승인")) {
					return true;
				}
				break;
			}
		}
		return false;
	}

	private void changeRequestState(String requestNumber, String string) {
		for(Request r : Data.requestList) {
			if(r.getRequestNumber() == Integer.parseInt(requestNumber)) {
				r.setPermission(string);
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
