package com.test.java.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.test.java.model.Menu;
import com.test.java.model.Reservation;
import com.test.java.model.Store;
import com.test.java.model.User;
import com.test.java.repository.Data;

public class ReservationView {
	
	public int getReservationNum() {
	      
	      Scanner scan=new Scanner(System.in);
	      int tmp=0;
	      
	      while(true) {
	         System.out.print("1. 인원 수(숫자) : ");
	         tmp=scan.nextInt();
	         //유효성 검사{
	      //
	         // break;    }
	         break;
	      }
	      
	      return tmp;
	   }
	   
	   public String getReservationDate(String licenseNumber) {
	         
	         Scanner scan=new Scanner(System.in);
	         String tmp="";
	         
	         while(true) {
	            //예약 달력
	            System.out.print("2. 예약 날짜(월일 0000) : ");
	            tmp=scan.nextLine();
	            //유효성 검사{
	         //
	            // break;    }
	            break;
	         }
	         
	         return tmp;
	      }
	      
	   
	   public String getReservationTime(String licenseNumber) {
	      
	      Scanner scan=new Scanner(System.in);
	      String tmp="";
	      
	      while(true) {
	         //예약 타임 표
	         System.out.print("3. 예약 시간(00:00) : ");
	         tmp=scan.nextLine();
	         //유효성 검사{
	      //
	         // break;    }
	         break;
	      }
	      
	      return tmp;
	   }
	   
	   

	   
	   public static void showCalendar() {
	      
	      Calendar calendar=Calendar.getInstance();
	      calendar.set(2024,Calendar.MONTH-1,1);
	      
	      int lastDay=calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	      int startDay=calendar.get(Calendar.DAY_OF_WEEK);
	      
	      
	      System.out.printf("\t\t2024 년 %s 월 \n",Calendar.MONTH);
	      System.out.println("일\t월\t화\t수\t목\t금\t토");
	      
	      int currentDay=1;
	      
	      for(int i=0 ; i<=42;i++) {
	         if(i<startDay) {
	            System.out.print("\t");
	         }else {
	            System.out.printf("%02d\t",currentDay);
	            currentDay++;
	         }
	         
	         if(i%7==0) {
	            System.out.println();
	            System.out.println();
	         }
	         
	         if(currentDay>lastDay) {
	            break;
	         }
	      }
	      
	      
	   }//showCalendar
	   
	   //사업자 번호에 해당하는 메뉴 출력
	    public String getSelectedMenuName(String licenseNumber) {
	           Map<String, Integer> menuMap = new HashMap<>();
	           Scanner scan = new Scanner(System.in);
	           

	           while (true) {
	               System.out.print(" 메뉴 번호를 입력하세요 (-1 입력시 종료): ");
	               int selectedMenuIndex = scan.nextInt();
	               scan.nextLine(); // 버퍼 비우기

	               // -1 입력 시 종료
	               if (selectedMenuIndex == -1) {
	                   break;
	               }

	               System.out.print(" 개수를 입력하세요: ");
	               int quantity = scan.nextInt();
	               scan.nextLine(); // 버퍼 비우기

	               // 선택한 메뉴 번호에 해당하는 메뉴 출력
	               if (selectedMenuIndex >= 1 && selectedMenuIndex <= Data.menuList.size()) {
	                   Menu selectedMenu = Data.menuList.get(selectedMenuIndex - 1);
	                   String menuName = selectedMenu.getMenuName();
	                   
	                   // 메뉴가 이미 선택되었을 경우에는 개수만 증가시킴
	                   if (menuMap.containsKey(menuName)) {
	                       quantity += menuMap.get(menuName);
	                   }
	                   
	                   // 메뉴와 개수를 Map에 저장
	                   menuMap.put(menuName, quantity);
	               } else {
	                   System.out.println("유효하지 않은 메뉴 번호입니다.");
	               }
	           }

	           // 예약한 메뉴와 개수 출력
	           StringBuilder reservationSummary = new StringBuilder();
	           
	           for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
	               reservationSummary.append(entry.getKey()).append("/").append(entry.getValue()).append("개 ");
	           }

	           return reservationSummary.toString();
	       }
	    
	    public void showMenu(String licenseNumber) {
	       Map<Integer, Menu> menuMap = new HashMap<>();
	       for (Store store : Data.storeList) {
	              if (licenseNumber.equals(store.getLicenseNumber())) {
	                  System.out.println("  [" + store.getStoreName() + "]");
	              }
	          }
	          System.out.println("==========MENU===========");

	          int index = 1;
	          for (Menu menu : Data.menuList) {
	              if (licenseNumber.equals(menu.getLicenseNumber())) {
	                  menuMap.put(index, menu);
	                  System.out.println(index + "." + menu.getMenuName() +
	                          "(" + menu.getPrice() + "원)");
	                  index++;
	              }
	          }

	          System.out.println("=========================");
	    }
	   
	      
	      
	      
	   
	   
	   public String showReservation(int num, String date, String time, String menu) {
	      String tmp="";
	      String txt="인원 수 \t 예약 날짜 \t 예약 시간 \t 예약 메뉴 ";
	      tmp=txt+"\n"+num+"\t "+date+"\t\t "+time+"\t\t "+menu;
	      return tmp;
	   }//showReservation
	   
	public  String get() {
	      
	      Scanner scan = new Scanner(System.in);
	      String tmp = "";
	      System.out.print("포인트에서 예약금 [3000원]을 결제하겠습니다. 동의하시면 Y/y를 동의하지 않으시면 N/n을 눌러주세요 : ");
	      
	      tmp = scan.nextLine();
	      return tmp;
	   }
	   public void showPay(User user) {
	      Scanner scan =new Scanner(System.in);
	      System.out.printf("포인트 잔액 : [%d]\n",user.getBalance());
	      
	   }

	public void showTitle() {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                   업체 회원 - 예약관리                    <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		
	}

	public void showSelectBox() {

		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("■            1. 예약 현황 조회       \t■");
		System.out.println("■            2. 방문 고객 조회       \t■");
		System.out.println("■            0. 이전 화면	         \t■");
		System.out.println();
		System.out.println("==========================================================================================");
		System.out.println();
		System.out.println("선택(번호) : ");
		
	}

	public int getSelectType() {
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		scan.nextLine();
		return tmp;
	}

	public void showReservationList(ArrayList<Reservation> cur) {

		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                 예약 관리 - 예약 현황 조회                 <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%6s%15s\t%10s\t\t%-15s%-15s", "[예약 시간]","[예약자]","[예약 테이블]","[인원]","[예약 메뉴]");
		System.out.println(header);
		

		for(Reservation r : cur) {
			String tmp = "";
			tmp = String.format("%6s%18s%20s\t%15s명\t",
					r.getReservationTime(),
					r.getUserId(),
					r.getTableCapacity(),
					r.getNumOfPeople());
			
			for(String name : r.getMenulist()) {
				tmp += name + ",";
			}
			
			System.out.println(tmp);
			
		}
		
		View.pause();
		
	}

	public void showNoCurrentResevationMessage() {

		System.out.println();
		System.out.println("현재 예약 내역이 없습니다.");
		System.out.println();
		View.pause();
		
	}

	public void showNoResevationHistoryMessage() {

		System.out.println();
		System.out.println("방문 기록이 없습니다.");
		System.out.println();
		View.pause();
	}

	public void showVistedReservationHeader() {
		System.out.println();
		System.out.println();
		System.out.println("┌───────────────────────────────────────────────────────┐");
		System.out.println("|                 예약 관리 - 방문 고객 조회                 <");
		System.out.println("└───────────────────────────────────────────────────────┘");
		System.out.println();
		
		String header = String.format("%6s%15s%15s\t%10s\t\t%-15s%-15s\t%-15s", "[예약 시간]","[예약자ID]","[예약자]","[예약 테이블]","[인원]","[방문여부]","[예약 메뉴]");
		System.out.println(header);
		
	}
	

	public void showOneReservation(Reservation r, String name) {

		String tmp = "";
		tmp = String.format("%6s%18s%15s%20s인\t%15s명%15s\t",
				r.getReservationTime(),
				r.getUserId(),
				name,
				r.getTableCapacity(),
				r.getNumOfPeople(),
				r.getState());

		for(String menuname : r.getMenulist()) {
			tmp += menuname + ",";
		}
		
		System.out.println(tmp);
	}
	

}//ReservationView
