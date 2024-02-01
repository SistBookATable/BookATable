package com.test.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Reservation;
import com.test.java.model.Table;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello Test1");

		String USER = "dat\\user.txt";
		String TABLE = "dat\\table.txt";
		String RESERVATION = "dat\\reservation.txt";
		String BUSINESSUSER = "dat\\businessUser";

		ArrayList<User> userList = new ArrayList<>();
		ArrayList<Table> tableList = new ArrayList<>();
		ArrayList<Reservation> reservationList = new ArrayList<>();
		
		
	
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(USER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				User user = new User(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]
									, tmp[6], tmp[7]
									, Integer.parseInt(tmp[8]), Integer.parseInt(tmp[9]), Integer.parseInt(tmp[10]), tmp[11], tmp[12],tmp[13]);
				
				userList.add(user);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(TABLE));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				Table t = new Table(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]), tmp[3].equals("true")? true:false);
				
				tableList.add(t);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		int reservationNumber = 1;

		for(User u : userList) {
			int noshowCount = u.getNoshowCount();
			for(int i=0; i<u.getReservationCount(); i++) {
				
				Reservation r = new Reservation();
				r.setUserId(u.getId());
				r.setReservationNumber(reservationNumber);
				

				//1~1700 (정수)
				int start = (int)(Math.random()*1700+1);
				String licenseNumber = tableList.get(start).getLicenseNumber();
				r.setLicenseNumber(licenseNumber);
				

				//0,1 (정수)
				int idx = (int)(Math.random()*10)%2;
				int capa = tableList.get(start).getTableCapacity();
				r.setNumOfPeple(capa-idx);
				r.setTableCapacity(capa);
			
				
				r.setState(noshowCount > 0? "노쇼":"방문");
				noshowCount--;
				
				
				System.out.println(r);
				
				
				reservationNumber++;
				
			}
			
		}
		
	}
}

/*

	dat/reservation.txt : 예약 릴레이션
	[예약 번호], 일반회원ID, 사업자 등록번호, 예약 시간, 예약 날짜, 인원 수, 예약 테이블 크기, 예약 상태(노쇼,취소,방문,예약) 

*/