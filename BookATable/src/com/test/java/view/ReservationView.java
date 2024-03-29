
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

// 예약 화면을 보여주는 클래스
public class ReservationView {
    
    // 달력을 보여주는 메서드
    public static void showCalendar() {
        System.out.println();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.MONTH - 1, 1);
        
        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        
        System.out.printf("\t\t2024년 %d월 \n", Calendar.MONTH); // 해당 달의 달력 출력
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        
        int currentDay = 1;
        
        for (int i = 0; i <= 42; i++) { // 한 주에 해당하는 달력 출력
            if (i < startDay) {
                System.out.print("\t");
            } else {
                System.out.printf("%02d\t", currentDay);
                currentDay++;
            }
            
            if (i % 7 == 0) {
                System.out.println();
                System.out.println();
            }
            
            if (currentDay > lastDay) {
                break;
            }
        }
    }
    
    // 예약 인원을 입력받는 메서드
    /**
     * 사용자로부터 예약할 인원 수를 입력받는 메서드
     * 
     * @return 입력된 인원 수
     */
    public int getReservationNum() {
        Scanner scan = new Scanner(System.in);
        int tmp;
        while (true) {
            System.out.print("1. 인원 수(1~10명) : ");
            try {
                tmp = Integer.parseInt(scan.nextLine());
                if (tmp >= 1 && tmp <= 10) { // 인원 수가 1에서 10 사이인지 확인
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
    
    // 예약 날짜를 입력받는 메서드
    /**
     * 사용자로부터 예약할 날짜를 입력받는 메서드
     * 
     * @param licenseNumber 라이선스 번호
     * @return 입력된 예약 날짜
     */
    public String getReservationDate(String licenseNumber) {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        String tmp = "";
        
        while (true) {
            // 예약 달력
            System.out.print("2. 예약 날짜(월일 MMDD) : ");
            tmp = scan.nextLine();
            
            // 유효성 검사
            if ((tmp = isValidDate(tmp)) != null) { // 입력된 날짜가 유효한지 확인
                break;
            } else {
                System.out.println("올바른 날짜 형식이 아닙니다. 다시 입력하세요.");
            }
        }
        
        return tmp;
    }
    
    // 예약 날짜의 유효성을 검사하는 메서드
    /**
     * 예약 날짜의 유효성을 검사하는 메서드
     * 
     * @param date 예약 날짜
     * @return 유효한 날짜인 경우 해당 날짜, 그렇지 않은 경우 null
     */
    private String isValidDate(String date) {
        // 예약 날짜 형식(MMDD)에 맞는지 확인
        if (date.matches("^\\d{4}$")) {
            // 2024년 기준으로 월은 01부터 12까지, 일은 01부터 31까지 유효한 범위 내에 있어야 함
            int month = Integer.parseInt(date.substring(0, 2));
            int day = Integer.parseInt(date.substring(2));
            
            Calendar cur = Calendar.getInstance();
            String today = String.format("%tF", cur);
            cur.set(Calendar.YEAR, 2024);
            cur.set(Calendar.MONTH, month - 1);
            cur.set(Calendar.DAY_OF_MONTH, day);
            String thatDay = String.format("%tF", cur);
            
            if (today.compareTo(thatDay) > 0) {
                System.out.println("오늘 이후 날짜를 입력해주세요");
                return null;
            }
            
            if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                return thatDay;
            }
        }
        
        return null;
    }
    
    // 예약 날짜의 유효성을 검사하는 메서드
    /**
     * 예약 날짜의 유효성을 검사하는 메서드
     * 
     * @param date 예약 날짜
     * @return 유효한 날짜인 경우 해당 날짜, 그렇지 않은 경우 null
     */
    private String isValidDate2(String date) {
        // 예약 날짜 형식(MMDD)에 맞는지 확인
        if (date.matches("^\\d{4}$")) {
            // 2024년 기준으로 월은 01부터 12까지, 일은 01부터 31까지 유효한 범위 내에 있어야 함
            int month = Integer.parseInt(date.substring(0, 2));
            int day = Integer.parseInt(date.substring(2));
            
            Calendar cur = Calendar.getInstance();
            String today = String.format("%tF", cur);
            cur.set(cur.get(Calendar.YEAR), month - 1, day);
            String thatDay = String.format("%tF", cur);
            
            if (today.compareTo(thatDay) > 0) {
                System.out.println("오늘 이후 날짜를 입력해주세요");
                return null;
            }
            
            if (month >= 1 && month <= 12 && day >= 1 && day <= 31) {
                return thatDay;
            }
        }
        
        return null;
    }
    
    // 예약 시간을 입력받는 메서드
    /**
     * 사용자로부터 예약할 시간을 입력받는 메서드


     * 
     * @return 입력된 시간
     */
    public String getReservationTime() {
        Scanner scan = new Scanner(System.in);
        String tmp;
        while (true) {
            System.out.print("3. 예약 시간(24시간제, 예: 1500) : ");
            tmp = scan.nextLine();
            if (tmp.matches("^([01]?[0-9]|2[0-3])[0-5][0-9]$")) { // 시간 형식이 올바른지 확인
                break;
            } else {
                System.out.println("올바른 시간 형식이 아닙니다. (24시간제, 예: 1500)");
            }
        }
        return tmp;
    }
    
    // 선택된 메뉴 이름을 받는 메서드
    /**
     * 사용자로부터 선택된 메뉴의 이름을 입력받는 메서드
     * 
     * @param licenseNumber 라이선스 번호
     * @return 선택된 메뉴의 이름 목록
     */
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
                
                // 선택한 메뉴 인덱스가 유효한지 확인
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
                        break; // 입력이 유효할 경우 루프를 종료
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
    
    // 메뉴 목록을 출력하는 메서드
    /**
     * 라이선스 번호에 해당하는 가게의 메뉴 목록을 출력하는 메서드
     * 
     * @param licenseNumber 라이선스 번호
     */
    public void showMenu(String licenseNumber) {
        Map<Integer, Menu> menuMap = new HashMap<>();
        for (Store store : Data.storeList) {
            if (licenseNumber.equals(store.getLicenseNumber()) && !printedStoreName) {
                // 가게 이름 출력 후 출력했음을 표시
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
    
    // 예약 정보를 출력하는 메서드
    /**
     * 예약 정보를 문자열로 반환하는 메서드
     * 
     * @param num       예약 인원 수
     * @param date      예약 날짜
     * @param time      예약 시간
     * @param menuList  선택된 메뉴 목록
     * @return          예약 정보 문자열
     */
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
            if (count >= 1) {
                tmp.append("/").append(count);
            }
            tmp.append(", ");
        }
        
        return tmp.toString();
    }
    
    // 결제 여부를 입력받는 메서드
    /**
     * 사용자로부터 결제 동의 여부를 입력받는 메서드
     * 
     * @return 결제 동의 여부 (Y/y: 동의, N/n: 비동의)
     */
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
    
    // 결제 후 포인트 잔액을 보여주는 메서드
    /**
     * 결제 후 사용자의 포인트 잔액을 출력하는 메서드
     * 
     * @param user 사용자 객체
     */
    public void showPay(User user) {
        System.out.printf("포인트 잔액: [%d]\n", user.getBalance());
    }
    
    // 테이블 인원 수를 입력받는 메서드
    /**
     * 사용자로부터 예약할 테이블의 인원 수를 입력받는 메서드
     * 
     * @param num 선택된 테이블의 현재 예약 인원 수
     * @return 입력된 테이블의 최종 예약 인원 수
     */
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
    
    // 예약화면 타이틀 출력
    public void showTitle() {
        System.out.println();
        System.out.println();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("|                   업체 회원 - 예약관리                   	|");
        System.out.println("└───────────────────────────────────────────────────────┘");
    }
    
    // 선택 상자 출력
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
    
    // 선택 타입을 입력받는 메서드
    /**
     * 사용자로부터 선택한 작업 번호를 입력받는 메서드
     * 
     * @return 사용자가 선택한 번호
     */
    public int getSelectType() {
        Scanner scan = new Scanner(System.in);
        int tmp = scan.nextInt();
        scan.nextLine();
        return tmp;
    }
    
    // 예약 목록을 출력하는 메서드
    /**
     * 현재 예약 상태를 출력하는 메서드
     * 
     * @param cur 예약 목록
     */
    public void showReservationList(ArrayList<Reservation> cur) {
        System.out.println();
        System.out.println();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("|                 예약 관리 - 예약 현황 조회                 	|");
        System.out.println("└───────────────────────────────────────────────────────┘");
        System.out.println();
        
        String header = String.format("%6s%15s\t%10s\t\t%-15s%-15s", "[예약 시간]", "[예약자]", "[예약 테이블]", "[인원]", "[예약 메뉴]");
        System.out.println(header);
        
        for (Reservation r : cur) {
            String tmp = "";
            tmp = String.format("%6s%18s%20s\t%15s명\t",
                                r.getReservationTime(),
                                r.getUserId(),
                                r.getTableCapacity(),
                                r.getNumOfPeople());
            
            for (String name : r.getMenulist()) {
                tmp += name + ",";
            }
            
            System.out.println(tmp);
        }
        System.out.println("1. 방문 확정");
        System.out.println("2. 노쇼 확정");
        System.out.println("0. 이전 화면");
        System.out.print("선택(숫자) : ");
    }
    
    // 예약 내역이 없을 때의 메시지 출력
    public void showNoCurrentResevationMessage() {
        System.out.println();
        System.out.println("현재 예약 내역이 없습니다.");
        System.out.println();
    }
    
    // 방문 기록이 없을 때의 메시지 출력
    public void showNoResevationHistoryMessage() {
        System.out.println();
        System.out.println("방문 기록이 없습니다.");
        System.out.println();
    }
    
    // 방문 예약 헤더 출력
    public void showVistedReservationHeader() {
        System.out.println();
        System.out.println();
        System.out.println("┌───────────────────────────────────────────────────────┐");
        System.out.println("|                 예약 관리 - 방문 고객 조회                 	|");
        System.out.println("└───────────────────────────────────────────────────────┘");
        System.out.println();
        
        String header = String.format("%6s%15s%15s\t%10s\t\t%-15s%-15s\t%-15s", "[예약 시간]", "[예약자ID]", "[예약자]", "[예약 테이블]", "[인원]", "[방문여부]", "[예약 메뉴]");
        System.out.println(header);
    }
    
    // 개별 예약을 출력하는 메서드
    public void showOneReservation(Reservation r, String name) {
        String tmp = "";
        tmp = String.format("%6s%18s%15s%20s인\t%15s명%15s\t",
                            r.getReservationTime(),
                            r.getUserId(),
                            name,
                            r.getTableCapacity(),
                            r.getNumOfPeople(),
                            r.getState());
        
        for (String menuname : r.getMenulist()) {
            tmp += menuname + ",";
        }
        
        System.out.println(tmp);
    }
    
}

