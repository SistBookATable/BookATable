//package com.test.java;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.util.ArrayList;
//
//import com.test.java.model.Menu;
//import com.test.java.model.OperatingHours;
//import com.test.java.model.PointUsage;
//import com.test.java.model.Reservation;
//import com.test.java.model.Table;
//import com.test.java.model.User;
//
//public class Test {
//	public static void main(String[] args) {
//		System.out.println("Hello Test1");
//
//		String USER = "dat\\user.txt";
//		String TABLE = "dat\\table.txt";
//		String RESERVATION = "dat\\reservation.txt";
//		String BUSINESSUSER = "dat\\businessUser";
//		String POINT = "dat\\pointUsage.txt";
//		String OH = "dat\\operatinghours.txt";
//		String MENU = "dat\\menu";
//		
//		
//		ArrayList<User> userList = new ArrayList<>();
//		ArrayList<Table> tableList = new ArrayList<>();
//		ArrayList<Reservation> reservationList = new ArrayList<>();
//		ArrayList<PointUsage> pointList = new ArrayList<>();
//		ArrayList<OperatingHours> hourList = new ArrayList<>();
//		ArrayList<Menu> menuList = new ArrayList<>();
//
//		
//		try {
//			BufferedReader reader
//			= new BufferedReader(new FileReader(MENU));
//			
//			String line = null;
//			
//			while((line = reader.readLine()) != null) {
//				
//				String[] tmp = line.split(",");
//				Menu m = new Menu(tmp[0],tmp[1],Integer.parseInt(tmp[2]));
//				
//				menuList.add(m);
//			}
//			
//			reader.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	
//		
//		try {
//			BufferedReader reader
//			= new BufferedReader(new FileReader(OH));
//			
//			String line = null;
//			
//			while((line = reader.readLine()) != null) {
//				
//				String[] tmp = line.split(",");
//				OperatingHours o = new OperatingHours(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4],tmp[5]);
//				
//				hourList.add(o);
//			}
//			
//			reader.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	
//		
//		try {
//			BufferedReader reader
//			= new BufferedReader(new FileReader(POINT));
//			
//			String line = null;
//			
//			while((line = reader.readLine()) != null) {
//				
//				String[] tmp = line.split(",");
//				PointUsage p = new PointUsage(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]),tmp[2],tmp[3],tmp[4]);
//				
//				pointList.add(p);
//			}
//			
//			reader.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	
//		try {
//			BufferedReader reader
//			= new BufferedReader(new FileReader(USER));
//			
//			String line = null;
//			
//			while((line = reader.readLine()) != null) {
//				
//				String[] tmp = line.split(",");
//				User user = new User(Integer.parseInt(tmp[0]), tmp[1], tmp[2], tmp[3], tmp[4], tmp[5]
//									, tmp[6], tmp[7]
//									, Integer.parseInt(tmp[8]), Integer.parseInt(tmp[9]), Integer.parseInt(tmp[10]), tmp[11], tmp[12],tmp[13]);
//				
//				userList.add(user);
//			}
//			
//			reader.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		try {
//			BufferedReader reader
//			= new BufferedReader(new FileReader(TABLE));
//			
//			String line = null;
//			
//			while((line = reader.readLine()) != null) {
//				
//				String[] tmp = line.split(",");
//				Table t = new Table(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]), tmp[3].equals("true")? true:false);
//				
//				tableList.add(t);
//			}
//			
//			reader.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//
//		int reservationNumber = 1;
//
//		for(User u : userList) {
//			int noshowCount = u.getNoshowCount();
//			int s = 0;
//			
//			for(int i=0; i<u.getReservationCount(); i++) {
//				
//				Reservation r = new Reservation();
//				r.setUserId(u.getId());
//				r.setReservationNumber(reservationNumber);
//				
//
//				//1~1700 (정수)
//				int start = (int)(Math.random()*1700+1);
//				String licenseNumber = tableList.get(start).getLicenseNumber();
//				r.setLicenseNumber(licenseNumber);
//				
//
//				//0,1 (정수)
//				int idx = (int)(Math.random()*10)%2;
//				int capa = tableList.get(start).getTableCapacity();
//				r.setNumOfPeople(capa-idx);
//				r.setTableCapacity(capa);
//			
//				
//				r.setState(noshowCount > 0? "노쇼":"방문");
//				noshowCount--;
//				
//				for(; s<pointList.size(); s++) {
//					if(pointList.get(s).getUserId().equals(u.getId())) {
//						r.setReservationDate(pointList.get(s).getUseTime());
//						break;
//					}
//				}
//				
//				for(OperatingHours o : hourList) {
//					if(o.getLicenseNumber().equals(licenseNumber)) {
//						r.setReservationTime(o.getOpen());
//						break;
//					}
//				}
//				
//				for(Menu m : menuList) {
//					if(m.getLicenseNumber().equals(licenseNumber)) {
//						System.out.println(m.getMenuName());
//						for(int k=0; k<r.getNumOfPeople(); k++) {
//							r.addmenu(m.getMenuName());
//						}
//						break;
//					}
//				}
//				
//				
//				System.out.println(r);
//				reservationList.add(r);
//				
//				reservationNumber++;
//				
//			}
//			
//		}
//		
//		
//		try {
//			BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATION));
//			
//			for(Reservation r : reservationList) {
//				String line = String.format("%d,%s,%s,%s,%s,%d,%d,%s",
//						r.getReservationNumber(),
//						r.getUserId(),
//						r.getLicenseNumber(),
//						r.getReservationTime(),
//						r.getReservationDate(),
//						r.getNumOfPeople(),
//						r.getTableCapacity(),
//						r.getState());
//				
//				for(String name :r.getMenulist()) {
//					line += "," + name;
//				}
//				
//				line += "\n";
//				writer.write(line);
//			}
//			
//			writer.close();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		
//		
//	}
//}
//
///*
//
//	dat/reservation.txt : 예약 릴레이션
//	[예약 번호], 일반회원ID, 사업자 등록번호, 예약 시간, 예약 날짜, 인원 수, 예약 테이블 크기, 예약 상태(노쇼,취소,방문,예약) 
//
//*/