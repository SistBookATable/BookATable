package com.test.java.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.java.model.Reservation;

public class ReservationRepository {

	public static Reservation findOneById(String id) {

		for(Reservation r : Data.reservationList) {
			if(r.getUserId().equals(id)) {
				return r;
			}
		}
		return null;
	}
	
	public static ArrayList<Reservation> findAllById(String id) {

		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			if(r.getUserId().equals(id)) {
				tmp.add(r);
			}
		}
		return tmp;
	}

	public static HashMap<String, Integer> findMenuCountByReservationNumber(int reservationNumber) {
		
		HashMap<String, Integer> tmp = new HashMap<>();
		
		for(Reservation r : Data.reservationList) {
			if(r.getReservationNumber()==reservationNumber) {
				if(r.getState().equals("노쇼") || r.getState().equals("취소")) {
					continue;
				}
				for(String name : r.getMenulist()) {
					if(tmp.containsKey(name)) {
						tmp.put(name,	tmp.get(name)+1);	
					}
					else {
						tmp.put(name,1);
					}
				}
			}
		}
		
		return tmp;
	}
	
	public static void findMenuCount(String lisenceNumber, String today, HashMap<String, Integer> menuCount) {
		
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getReservationDate().equals(today)) {
				if(r.getState().equals("노쇼") || r.getState().equals("취소")) {
					continue;
				}
				for(String name : r.getMenulist()) {
					if(menuCount.containsKey(name)) {
						menuCount.put(name,	menuCount.get(name)+1);	
					}
					else {
						menuCount.put(name,1);
					}
				}
			}
		}
		
	}

	public static HashMap<String, Integer> findAllCountByState(String lisenceNumber, String state) {
		HashMap<String, Integer> tmp = new HashMap<>();
		
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber))
			{
				if(r.getState().equals(state)) {
					String userid = r.getUserId();
					if(tmp.containsKey(userid)) {
						tmp.put(r.getUserId(), tmp.get(userid) + 1);	
					}
					else {
						tmp.put(userid, 1);
					}
				}
			
			}
		}
		
		return tmp;
	}

	public static HashMap<String, Integer> findMenuByUserId(String lisenceNumber, String key) {
		HashMap<String, Integer> tmp = new HashMap<>();
		for(Reservation r : Data.reservationList) {
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getUserId().equals(key) &&r.getState().equals("방문")) {
				for(String menu : r.getMenulist()) {
					if(tmp.containsKey(menu)) {
						tmp.put(menu, tmp.get(menu)+1);
					}
					else {
						tmp.put(menu, 1);
					}
				}
			}
		}
		
		
		return tmp;
	}
	
}
