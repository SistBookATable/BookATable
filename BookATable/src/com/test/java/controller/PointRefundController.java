//package com.test.java.controller;
//
//import java.util.Scanner;
//
//import com.test.java.model.Member;
//import com.test.java.model.PointRefund;
//import com.test.java.model.User;
//import com.test.java.repository.Data;
//import com.test.java.view.PointRefundHistoryView;
//import com.test.java.view.PointRefundView;
//
//public class PointRefundController {
//
//	
//	public void pointRefund() {
//		
//		PointRefundView pointRefundView = new PointRefundView(); 
//		pointRefundView.showPointRefund();
//		
//		int choice = pointRefundView.get();
//		
//		String userId = Member.id;
//		User currentUser = findUserById(userId);
//    
//		Scanner scan = new Scanner(System.in);
//		
//		boolean loop = true;
//		
//		while(loop) {
//		
//		switch(choice) {
//		// 포인트 환불신청
//		case 1: pointRefundView.showRefund();
//				if (currentUser != null) {
//				// 보유 포인트 0
//				currentUser.setBalance(currentUser.getBalance() - currentUser.getBalance());
//				} else {
//			System.out.println("환불 가능한 포인트가 존재하지 않습니다.");
//				}	
//				// 엔터 입력 시 이전 화면으로 이동
//				if (scan.nextLine().isEmpty()) {
//					return;
//				}
//				break;
//		// 포인트 환불신청내역
//		case 2: PointRefundHistoryController pointRefundHistoryController = new PointRefundHistoryController();
//				pointRefundHistoryController.pointRefundHistory();
//			break;
//			
//		case 0: PointManagementController pointManagementController = new PointManagementController();
//				pointManagementController.pointManagement();
//			break;
//
//			}
//		}
//	}
//	
//	
//	private User findUserById(String userId) {
//		for (Member member : Data.memberList) {
//			if (member instanceof User && member.getId().equals(userId)) {
//				return (User) member;
//			}
//		}
//		return null;
//	}
//	
//
//	private String findNameById(String id) {
//		String userName = "";
//		for (Member u : Data.memberList) {
//			if (u.getId().equals(id)) {
//				userName = u.getName();
//				break;
//			}
//		}
//		return userName;
//	}
//	
//
//	
//	private String findRefundDateById(String id) {
//		String refundDate = "";
//		for (PointRefund p : Data.pointRefundList) {
//			if (p.getUserId().equals(Member.id)) {
//					refundDate = p.getRefundDate(); 
//					break;					
//			}
//		}	
//		return refundDate;
//	}
//	
//
//	private int findPointAmountById(String id) {
//		int pointAmount = 0;
//		for (PointRefund p : Data.pointRefundList) {
//			if (p.getUserId().equals(Member.id)) {		
//					pointAmount = p.getPointAmount();
//						break;
//				}
//		}
//		return pointAmount;
//	}
//
//	
//	
//
//	
//	
//}
