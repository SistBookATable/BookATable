package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.InquiryReservationStatusView;

public class ReservationManagementController {

	public void reservationStatusInquiry() {
		InquiryReservationStatusView reservationStatusInquiryView
			= new InquiryReservationStatusView();
		reservationStatusInquiryView.showInquiryReservationStatus();
		
		int choice = InquiryReservationStatusView.get();
		
		switch(choice) {
		case 1:
			ReservationCancelController reservationCancelController
				= new ReservationCancelController();
			reservationCancelController.reservationCancel();
		case 0:
			
		}
	}

	private String findNameById(String id) {
		String name = "";

		for(Member u : Data.memberList) {
			if(u.getId().equals(id)) {
				name = u.getName();
				break;
			}
		}
		return name;
		
	}
	
}