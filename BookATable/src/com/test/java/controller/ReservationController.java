package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Reservation;
import com.test.java.view.ReservationView;

public class ReservationController {
	
	private ReservationView reservationView;
	private ArrayList<Reservation> reservation;
	
	public void reservation() {
			
			int num=reservationView.getReservationNum();
			String date=reservationView.getReservationDate();
			String time=reservationView.getReservationTime();
			String menu=reservationView.getReservationMenu(); 
			
			reservationView.showReservation(num, date, time, menu);
		
	}
	
	

}
