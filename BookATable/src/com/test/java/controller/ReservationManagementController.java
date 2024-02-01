package com.test.java.controller;

import com.test.java.view.ReservationManagementView;
import com.test.java.view.ReservationView;

public class ReservationManagementController {

	public void reservaionManagement() {
		ReservationManagementView.showReservationManagement();
		int choice = ReservationManagementView.get();
		
		switch(choice) {
		case 1:
			ReservationStatusInquiryController reservationStatusInquiryController
				= new ReservationStatusInquiryController();
			reservationStatusInquiryController.reservationStatusInquiry();
			
		case 2:
			
		case 0:
		
		}
		
	}

}
