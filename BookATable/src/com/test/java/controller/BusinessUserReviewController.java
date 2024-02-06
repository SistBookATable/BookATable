package com.test.java.controller;

import java.util.ArrayList;
import java.util.Collections;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Review;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.RequestRepository;
import com.test.java.repository.ReviewRepository;
import com.test.java.view.BusinessUserReviewView;

public class BusinessUserReviewController {
	
	BusinessUserReviewView businessUserReviewView = new BusinessUserReviewView();
	
	public void reviewManagement() {
		//ID로 라이센스 넘버 찾기
		String lisenceNumber = ((BusinessUser)MemberRepository.findOneById(Member.id)).getLicenseNumber();
		
		//라이센스 넘버로 모든 리뷰 찾기
		ArrayList<Review> reviewList = ReviewRepository.findAllByLisenceNumber(lisenceNumber);
		
		//날짜순으로 정렬
		Collections.sort(reviewList, (o1,o2)-> o1.getDateWritten().compareTo(o2.getDateWritten()));
		

		int curPage = 0;
		int choice;
		int prevPage = -10;
		int i = 0;
		boolean loop = true;
		while(loop) {
			
			if(reviewList.isEmpty()) {
				businessUserReviewView.hasNoHistory();
				break;
			}
			else {
				//10개씩 출력
				businessUserReviewView.showReviewHeader();
				for(i = 0; i<10; i++) {
					if(curPage+i == reviewList.size()) {
						break;
					}
					Review r = reviewList.get(curPage+i);
					businessUserReviewView.showReview(r);
				}
				
			}
			
			businessUserReviewView.showSelectBox();
			choice = businessUserReviewView.getSelectType();
			switch (choice) {
			case 1:
				//다음 페이지 보기
				//마지막 페이지일 때
				if(reviewList.size()==curPage+i) {
					businessUserReviewView.lastPageMessage();
				}
				else {
					prevPage = curPage;
					curPage += i;
					loop = false;	
				}
				break;
			case 2:
				//이전 페이지 보기
				//첫 페이지 일 때
				if(prevPage<0) {
					businessUserReviewView.firstPageMessage();
				}
				else {
					curPage = prevPage;
					prevPage -= 10;
					loop = false;
				}
				break;
			case 3:
				//리뷰 삭제 요청

				//리뷰 번호 입력
				businessUserReviewView.showReviewNumberInputBox();
				int reviewNumber = businessUserReviewView.getReviewNumber();
				
				if(reviewNumber==-1) {
					businessUserReviewView.incorrectInputMessage();
					continue;
				}
				
				//리뷰 번호로 리뷰 찾기
				Review selected = find(reviewNumber, reviewList, curPage, curPage+i);
				
				//리뷰가 없으면 == 보여진 화면에 없는 리뷰 번호 입력 시
				if(selected == null) {
					businessUserReviewView.incorrectReviewNumberMessage();
					continue;
				}
				
				//삭제 요청 사유 입력
				businessUserReviewView.showInputReasonBox(selected.getUserId());
				String reason = businessUserReviewView.getReason();
				
				//삭제 요청 취소 시
				if(reason.equals("0")) {
					break;
				}
				

				//요청 완료 메시지
				RequestRepository.addRequest(reviewNumber, selected.getLicenseNumber(), reason, selected.getUserId());
				businessUserReviewView.requestSuccessMessage();
				
				break;
			case 0:
				//뒤로 가기
				loop = false;
				break;
			default:
				businessUserReviewView.incorrectInputMessage();
			}
		}
	}

	private Review find(int reviewNumber, ArrayList<Review> reviewList, int i, int curPage) {
		
		for(; i<curPage; i++) {
			if(reviewList.get(i).getReviewNumber()==reviewNumber) {
				return reviewList.get(i);
			}
		}
		return null;
	}

}
