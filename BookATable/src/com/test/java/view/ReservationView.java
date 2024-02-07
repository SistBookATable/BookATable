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
	
	 public int getReservationNum() {
	        Scanner scan = new Scanner(System.in);
	        int tmp;
	        while (true) {
	            System.out.print("1. 인원 수(1~10명) : ");
	            try {
	                tmp = Integer.parseInt(scan.nextLine());
	                if (tmp >= 1 && tmp <= 10) {
	                    break;
	                } else {
	                    System.out.println("인원 수는 1에서 10 사이여야 합니다.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("숫자를 입력하세요.");
	            }
	        }
	        return tmp;
	    }

	 public String getReservationDate(String licenseNumber) {
		    Scanner scan = new Scanner(System.in);
		    String tmp = "";
		    
		    while (true) {
		        // 예약 달력
		        System.out.print("2. 예약 날짜(월일 MMDD) : ");
		        tmp = scan.nextLine();
		        
		        // 유효성 검사
		        if (isValidDate(tmp)) {
		            break;
		        } else {
		            System.out.println("올바른 날짜 형식이 아닙니다. 다시 입력하세요.");
		        }
		    }
		    
		    return tmp;
		}

		private boolean isValidDate(String date) {
		    // 예약 날짜 형식(MMDD)에 맞는지 확인
		    if (date.matches("^\\d{4}$")) {
		        // 2024년 기준으로 월은 01부터 12까지, 일은 01부터 31까지 유효한 범위 내에 있어야 함
		        int month = Integer.parseInt(date.substring(0, 2));
		        int day = Integer.parseInt(date.substring(2));
		        
		        if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
		            return true;
		        }
		    }
		    
		    return false;
		}

	    public String getReservationTime() {
	        Scanner scan = new Scanner(System.in);
	        String tmp;
	        while (true) {
	            System.out.print("3. 예약 시간(24시간제, 예: 1500) : ");
	            tmp = scan.nextLine();
	            if (tmp.matches("^([01]?[0-9]|2[0-3])[0-5][0-9]$")) {
	                break;
	            } else {
	                System.out.println("올바른 시간 형식이 아닙니다. (24시간제, 예: 1500)");
	            }
	        }
	        return tmp;
	    }

	    public ArrayList<String> getSelectedMenuName(String licenseNumber) {
	        ArrayList<String> selectedMenuList = new ArrayList<>();
	        Scanner scan = new Scanner(System.in);

	        while (true) {
	            System.out.print("메뉴 번호를 입력하세요 (-1 입력시 종료): ");
	            String selectedMenuInput = scan.nextLine();

	            // -1 입력 시 종료
	            if (selectedMenuInput.equals("-1")) {
	                break;
	            }

	            try {
	                int selectedMenuIndex = Integer.parseInt(selectedMenuInput);

	                // Check if the selectedMenuIndex is valid for the menu list of the specific restaurant
	                int menuListSize = 0;
	                for (Menu menu : Data.menuList) {
	                    if (menu.getLicenseNumber().equals(licenseNumber)) {
	                        menuListSize++;
	                    }
	                }
	                if (selectedMenuIndex < 1 || selectedMenuIndex > menuListSize) {
	                    System.out.println("유효하지 않은 메뉴 번호입니다. 다시 입력하세요.");
	                    continue;
	                }
	                
	                int quantity = 0;
	                while (true) {
	                    System.out.print("개수를 입력하세요: ");
	                    String quantityInput = scan.nextLine();
	                    try {
	                        quantity = Integer.parseInt(quantityInput);
	                        if (quantity <= 0) {
	                            System.out.println("메뉴 개수는 1 이상이어야 합니다. 다시 입력하세요.");
	                            continue;
	                        }
	                        break; // Exit the loop if input is valid
	                    } catch (NumberFormatException e) {
	                        System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
	                    }
	                }

	                // 선택한 메뉴를 개수만큼 추가
	                Menu selectedMenu = null;
	                int count = 0;
	                for (Menu menu : Data.menuList) {
	                    if (menu.getLicenseNumber().equals(licenseNumber)) {
	                        count++;
	                        if (count == selectedMenuIndex) {
	                            selectedMenu = menu;
	                            break;
	                        }
	                    }
	                }
	                String menuName = selectedMenu.getMenuName();
	                for (int i = 0; i < quantity; i++) {
	                    selectedMenuList.add(menuName);
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
	            }
	        }
	        
	        return selectedMenuList;
	    }


	    boolean printedStoreName = false; // 가게 이름 출력 여부를 나타내는 변수

	    public void showMenu(String licenseNumber) {
	        Map<Integer, Menu> menuMap = new HashMap<>();
	        for (Store store : Data.storeList) {
	            if (licenseNumber.equals(store.getLicenseNumber()) && !printedStoreName) {
	                // 가게 이름을 출력하고 출력했음을 표시
	                System.out.println("[" + store.getStoreName() + "]");
	                printedStoreName = true;
	            }
	        }
	        
	        System.out.println("==========MENU===========");

	        int index = 1;
	        for (Menu menu : Data.menuList) {
	            if (licenseNumber.equals(menu.getLicenseNumber())) {
	                menuMap.put(index, menu);
	                System.out.println(index + "." + menu.getMenuName() + "(" + menu.getPrice() + "원)");
	                index++;
	            }
	        }

	        System.out.println("=========================");
	    }


	    public String showReservation(int num, String date, String time, ArrayList<String> menuList) {
	        StringBuilder tmp = new StringBuilder();
	        String txt = "인원 수 \t 예약 날짜 \t 예약 시간 \t 예약 메뉴 ";
	        tmp.append(txt).append("\n").append(num).append("\t ").append(date).append("\t\t ").append(time).append("\t\t ");

	        Map<String, Integer> menuCounts = new HashMap<>();
	        for (String menu : menuList) {
	            menuCounts.put(menu, menuCounts.getOrDefault(menu, 0) + 1);
	        }

	        for (Map.Entry<String, Integer> entry : menuCounts.entrySet()) {
	            String menu = entry.getKey();
	            int count = entry.getValue();
	            tmp.append(menu);
	            if (count > 1) {
	                tmp.append("/").append(count);
	            }
	            tmp.append(", ");
	        }

	        return tmp.toString();
	    }

	    public String get() {
	        Scanner scan = new Scanner(System.in);
	        String tmp;
	        while (true) {
	            System.out.print("포인트에서 예약금 [3000원]을 결제하겠습니까? 동의하시면 Y/y, 동의하지 않으시면 N/n을 입력하세요: ");
	            tmp = scan.nextLine();
	            if (tmp.equalsIgnoreCase("Y") || tmp.equalsIgnoreCase("N")) {
	                break;
	            } else {
	                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
	            }
	        }
	        return tmp;
	    }

	    public void showPay(User user) {
	        System.out.printf("포인트 잔액: [%d]\n", user.getBalance());
	    }

	    public int getTableNum(int num) {
	        if (num >= 1 && num <= 2) {
	            return 2;
	        } else if (num <= 4) {
	            return 4;
	        } else if (num <= 6) {
	            return 6;
	        } else if (num <= 8) {
	            return 8;
	        } else if (num <= 10) {
	            return 10;
	        } else {
	            return 0;
	        }
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