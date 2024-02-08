package com.test.java.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.ReservationRepository;
import com.test.java.view.ReservationView;
import com.test.java.view.View;

public class ReservationController {
	
	private ReservationView reservationView = new ReservationView();
	
	public void reservation(String licenseNumber) {
        
        // 멤버 목록에서 사용자 찾기
        for (Member m : Data.memberList) {
            if (Member.id.equals(m.getId())) {
                if (m instanceof User) {
                    User user = (User) m;

                    // 예약 인원 입력
                    int num = reservationView.getReservationNum();

                    // 테이블 번호 계산
                    int tableNum = reservationView.getTableNum(num);

                    // 예약 날짜, 시간 입력
                    ReservationView.showCalendar();
                    System.out.println();
                    String date = reservationView.getReservationDate(licenseNumber);
                    String time = reservationView.getReservationTime();

                    // 예약 메뉴 선택
                    reservationView.showMenu(licenseNumber);
                    ArrayList<String> selectedMenuList = reservationView.getSelectedMenuName(licenseNumber);
                    System.out.println(reservationView.showReservation(num, date, time, selectedMenuList)); 

                    // 예약 정보 출력
                    reservationView.showReservation(num, date, time, selectedMenuList);

                    // 예약 금액 계산 및 결제
                    int reservationPay = 3000;
                    reservationView.showPay(user);
                    String userInput = reservationView.get();
                    switch (userInput) {
                        case "Y":
                        case "y":
                            int changeBalance = user.getBalance() - reservationPay;
                            if (changeBalance >= 0) {
                                System.out.printf("예약금 결제가 완료되었습니다.\n예약금 결제 후의 포인트 잔액 [%d원]\n", user.getBalance() - reservationPay);
                                user.setBalance(changeBalance);
                            } else {
                                PointChargingController pointChargingController = new PointChargingController();
                                pointChargingController.pointCharging();
                            }
                            break;
                        case "N":
                        case "n":
                            System.out.println("예약을 취소하셨습니다.");
                            break;
                    }
                    
                    // 예약 정보 저장
                    int index = 1;
                    for (Member member : Data.memberList) {
                        if (Member.id.equals(member.getId())) {
                            Reservation reservation = new Reservation(index, Member.id, licenseNumber, time, date, num, tableNum, "예약", selectedMenuList);
                            Data.reservationList.add(reservation);
                            index++;
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
				lisenceNumber = ((BusinessUser)MemberRepository.findOneById(Member.id)).getLicenseNumber();
				
				//라이센스번호로 현재 예약상태인 모든 예약 조회
				ArrayList<Reservation> cur = ReservationRepository.findAllByLisenceNumberState(lisenceNumber,"예약");
				
				//현재 예약이 없을 때
				if(cur.isEmpty()) {
					reservationView.showNoCurrentResevationMessage();
					break;
				}
				
				//예약리스트 출력
				reservationView.showReservationList(cur);
				
				int choice2=reservationView.getSelectType();
				switch(choice2) {
				
				case 1:
					//상세 내역 조회
					Scanner scan=new Scanner(System.in);
					System.out.println("id를 입력하세요 : ");
					String visitId=scan.nextLine();
					for(Reservation r:Data.reservationList) {
						if(visitId.equals(r.getUserId())&&lisenceNumber.equals(r.getLicenseNumber())) {
							r.setState("방문");
						}
					}
					
					for(Reservation d:Data.reservationList) {
						if(visitId.equals(d.getUserId())&&lisenceNumber.equals(d.getLicenseNumber())) {
							System.out.println(d.getState());
						}
					}
					loop=false;
					break;
					
				
				case 2:
					Scanner scanner=new Scanner(System.in);
					System.out.println("id를 입력하세요 : ");
					String noShowId=scanner.nextLine();
					for(Reservation r:Data.reservationList) {
						if(noShowId.equals(r.getUserId())&&lisenceNumber.equals(r.getLicenseNumber())) {
							r.setState("노쇼");
						}
					}
					
					for(Reservation d:Data.reservationList) {
						if(noShowId.equals(d.getUserId())&&lisenceNumber.equals(d.getLicenseNumber())) {
							System.out.println(d.getState());
						}
					}
					loop=false;
					break;
					
				case 0:
					//뒤로가	
					reservationView.showTitle();
					reservationView.showSelectBox();
					loop=false;
					break;
				}
				break;
				
				
			// 방문 고객 조회
			case 2:  

				//업체회원 ID로 음식점 라이센스번호 조회
				lisenceNumber = ((BusinessUser)MemberRepository.findOneById(Member.id)).getLicenseNumber();

				//라이센스번호로 고객이 방문했던 모든 예약 조회
				ArrayList<Reservation> visited = ReservationRepository.findAllByLisenceNumber(lisenceNumber);
				
				//방문 기록이 없을 때
				if(visited.isEmpty()) {
					reservationView.showNoResevationHistoryMessage();
					break;
				}
				
				//방문 리스트 출력
				reservationView.showVistedReservationHeader();
				for(Reservation r : visited) {
					String name = MemberRepository.findOneById(r.getUserId()).getName();
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

}