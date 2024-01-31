package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Reservation;
import com.test.java.view.ReservationView;

public class ReservationController {
	
	private ReservationView reservationView;
	private ArrayList<Reservation> reservationList;
	
	public ReservationController(ReservationView reservationView, ArrayList<Reservation> reservationList) {
		this.reservationView = reservationView;
		this.reservationList = reservationList;
	}
	
	public void findBySignOut(Calendar signOut) {
		
	}
	
	public void findAll() {
		
	}
	
	public void findByUserId(String id) {
		
	}
	
	

}
