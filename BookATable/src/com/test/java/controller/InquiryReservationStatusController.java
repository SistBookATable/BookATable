package com.test.java.controller;

import java.util.Scanner;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.repository.Data;
import com.test.java.view.InquiryReservationStatusView;

public class InquiryReservationStatusController {

	public void inquiryReservationStatus() {
		InquiryReservationStatusView inquiryReservationStatusView
			= new InquiryReservationStatusView ();
		
		InquiryReservationStatusView.showInquiryReservationStatus(findNameById(Member.id)
																, findStoreNameById(Member.id)
																, findNumOfPepleById(Member.id)
																, findreservationTimeById(Member.id));
		
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
	
	private String findStoreNameById(String id) {
		String storeName = "";
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				for(Store s : Data.storeList) {
					if (r.getLicenseNumber().equals(s.getStoreName())) {
						storeName = s.getStoreName();
					}
				}
				
			}
		
		}
		
		return storeName;
	}
	
	
	
	private int findNumOfPepleById(String id) {
		int numOfPeple = 0;
		
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				numOfPeple = r.getNumOfPeople();
			}
		}
		
		return numOfPeple;
	}
	
	private String findreservationTimeById(String id) {
		String reservationTime = "";
		for(Reservation r : Data.reservationList) {
			if (r.getUserId().equals(id)) {
				reservationTime = r.getReservationTime();
			}
		}
		
		return reservationTime;
	}
	
	

	
	
	
}
