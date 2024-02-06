package com.test.java.controller;

import java.util.ArrayList;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.ReservationView;
import com.test.java.view.View;

public class ReservationController {
	
	private ReservationView reservationView = new ReservationView();
	private ArrayList<Reservation> reservation;
	
	public void reservation(String licenseNumber) {
	    System.out.println(Member.id);
	    
	    for (Member m : Data.memberList) {
	        if (Member.id.equals(m.getId())) {
	            if (m instanceof User) {
	                User user = (User) m;
	                System.out.println(Data.reservationList);
	                
	                int num = reservationView.getReservationNum();
	                ReservationView.showCalendar();
	                System.out.println();
	                
	                String date = reservationView.getReservationDate(licenseNumber);
	                String time = reservationView.getReservationTime(licenseNumber);
	                System.out.println();
	                
	                reservationView.showMenu(licenseNumber);
	                ArrayList<String> selectedMenuList = reservationView.getSelectedMenuName(licenseNumber);
	                System.out.println();
	                
	                System.out.println(reservationView.showReservation(num, date, time, selectedMenuList));
	                
	                int reservationPay = 3000;
	                reservationView.showPay(user);
	                String userInput = reservationView.get();
	                
	                switch (userInput) {
	                    case "Y":
	                    case "y":
	                    	
	                    	int changeBalance = user.getBalance() - reservationPay;
	                    	if(changeBalance>=0) {
	                        System.out.printf("예약금 결제가 완료되었습니다.\n예약금 결제 후의 포인트 잔액 [%d원]\n", user.getBalance() - reservationPay);
	                        
	                        user.setBalance(changeBalance);
	                    	}
	                    	else {
	                    		PointChargingController pointChargingController = new PointChargingController();
	                    		pointChargingController.pointCharging();
	                    	}
	                        // TODO: user 포인트 변경
	                        break;
	                    case "N":
	                    case "n":
	                        reservationView.showPay(user);
	                        // 엔터를 누르면 메인 이동
	                        break;
	                }
	                
	                int index =1;
	                for (Member member : Data.memberList) {
	                    if (Member.id.equals(member.getId())) {
	                        Reservation reservation = new Reservation(index, Member.id, licenseNumber, time, date, num, 4, "예약", selectedMenuList);
	                        Data.reservationList.add(reservation);
	                        // Data.saveReservation();
	                        index++;
	                    }
	                }
	                for (Reservation r : Data.reservationList) {
	                    if (r.getLicenseNumber().equals(licenseNumber)) {
	                        System.out.println(r.getMenulist());
	                    }
	                }
	                for (Member q : Data.memberList) {
	                    if (Member.id.equals(q.getId())) {
	                        if (q instanceof User) {
	                            User user3 = (User) q;
	                            System.out.println(user3.getBalance());
	                        }
	                    }
	                }

	                System.out.println();
	            }
	        }
	    }
	}


	public void BusinessUserReservationManagement() {
		
		String lisenceNumber = "";
		boolean loop = true;
		while(loop) {

			reservationView.showTitle();
			reservationView.showSelectBox();
			int choice = reservationView.getSelectType();
			
			switch (choice) {
			
			//예약 현황 조회
			case 1: 
				
				//업체회원 ID로 음식점 라이센스번호 조회
				lisenceNumber = findLisenceNumber(Member.id);
				
				//라이센스번호로 현재 예약상태인 모든 예약 조회
				ArrayList<Reservation> cur = findAllReservation(lisenceNumber,"예약");
				
				//현재 예약이 없을 때
				if(cur.isEmpty()) {
					reservationView.showNoCurrentResevationMessage();
					break;
				}
				
				//예약리스트 출력
				reservationView.showReservationList(cur);
				break;
				
			// 방문 고객 조회
			case 2:  

				//업체회원 ID로 음식점 라이센스번호 조회
				lisenceNumber = findLisenceNumber(Member.id);

				//라이센스번호로 고객이 방문했던 모든 예약 조회
				ArrayList<Reservation> visited = findAllReservation(lisenceNumber);
				
				//방문 기록이 없을 때
				if(visited.isEmpty()) {
					reservationView.showNoResevationHistoryMessage();
					break;
				}
				
				//방문 리스트 출력
				reservationView.showVistedReservationHeader();
				for(Reservation r : visited) {
					String name = findUserName(r.getUserId());
					reservationView.showOneReservation(r, name);
				}
				View.pause();
				break;
			case 0:
				loop = false;
				break;
			default:
				break;
			}
		}
		
	}

	private ArrayList<Reservation> findAllReservation(String lisenceNumber) {
		
		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			
			if(r.getLicenseNumber().equals(lisenceNumber)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}

	private String findUserName(String userId) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(userId)) {
				return m.getName();
			}
		}
		return null;
	}

	private String findLisenceNumber(String id) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				return ((BusinessUser)m).getLicenseNumber();
			}
		}
		return null;
	}

	private ArrayList<Reservation> findAllReservation(String lisenceNumber,String state) {
		
		ArrayList<Reservation> tmp = new ArrayList<>();
		
		for(Reservation r : Data.reservationList) {
			
			if(r.getLicenseNumber().equals(lisenceNumber) && r.getState().equals(state)) {
				tmp.add(r);
			}
		}
		
		return tmp;
	}
	
	

}