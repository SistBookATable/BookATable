package com.test.java.controller;

import com.test.java.model.Member;
import com.test.java.repository.Data;
import com.test.java.view.InquiryReservationStatusView;
import com.test.java.view.ReservationManagementView;

public class ReservationManagementController {

	public void reservationManagement() {

		ReservationManagementView reservationManagementView = new ReservationManagementView();
		reservationManagementView.showReservationManagement();

		int choice = InquiryReservationStatusView.get();

		switch (choice) {
		case 1:
			InquiryReservationStatusController inquiryReservationStatusController = new InquiryReservationStatusController();
			inquiryReservationStatusController.inquiryReservationStatus();
			break;
		case 2:
			InquiryCompletedReservationController inquiryCompletedReservationController
				= new InquiryCompletedReservationController();
			inquiryCompletedReservationController.inquiryCompletedReservation();
			break;
		case 0:
			break;

		}

	}

	private String findNameById(String id) {
		String name = "";

		for (Member u : Data.memberList) {
			if (u.getId().equals(id)) {
				name = u.getName();
				break;
			}
		}
		return name;

	}

}