package com.test.java.controller;

import com.test.java.view.InquiryReservationStatusView;
import com.test.java.view.ReservationManagementView;

public class ReservationManagementController {

	public void reservationManagement() {

		boolean loop = true;

		while (loop) {
			ReservationManagementView.showReservationManagement();
			int choice = InquiryReservationStatusView.get();
			switch (choice) {
			case 1:
				InquiryReservationStatusController inquiryReservationStatusController = new InquiryReservationStatusController();
				inquiryReservationStatusController.inquiryReservationStatus();
				break;
			case 2:
				InquiryCompletedReservationController inquiryCompletedReservationController = new InquiryCompletedReservationController();
				inquiryCompletedReservationController.inquiryCompletedReservation();
				break;
			case 0:
				loop = false;
				break;

			}
		}

	}

}