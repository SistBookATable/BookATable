package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.PointGiftView;

public class PointGiftController {
	
	public void pointGift() {
		
		PointGiftView pointGiftView = new PointGiftView();
		
		String id = pointGiftView.getId(); // 사용자가 입력한 ID 
		int amountGift = pointGiftView.getAmountGift();
		String name = findNameById(id); // 사용자가 입력한 ID에 해당하는 이름 찾기 
		String result = pointGiftView.showPointGift(id, name);
		
		findNameById(Member.id);
		
		System.out.println(result);
		
		// PointManagement로
		PointManagementController pointManagementController = new PointManagementController();
		pointManagementController.pointManagement();
		
		
		
	}

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
