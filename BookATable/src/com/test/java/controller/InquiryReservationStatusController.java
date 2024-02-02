package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryReservationStatusView;

public class InquiryReservationStatusController {

	public static void inquiryReservationStatus() {
		InquiryReservationStatusView inquiryReservationStatusView
			= new InquiryReservationStatusView ();
		InquiryReservationStatusView.showInquiryReservationStatus();
		
		int choice = inquiryReservationStatusView.get();
		
		switch(choice) {
		case 1:
			ReservationCancelController reservationCancelController
				= new ReservationCancelController();
			reservationCancelController.reservationCancel();
		case 0:
			
			break;
		}
	}

	
	
	
}
