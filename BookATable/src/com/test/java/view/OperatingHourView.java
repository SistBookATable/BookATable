package com.test.java.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.test.java.model.Menu;
import com.test.java.model.OperatingHours;
import com.test.java.model.Store;
import com.test.java.repository.Data;

/**
 * 운영 시간을 관리하는 화면을 출력하는 클래스
 */
public class OperatingHourView {

    /**
     * 해당 음식점의 운영 시간을 보여주는 메서드
     * 
     * @param licenseNumber 음식점 라이선스 번호
     */
    public void showOperatingHour(String licenseNumber) {
        // 메뉴 맵 초기화
        Map<Integer, Menu> menuMap = new HashMap<>();
        // 데이터베이스에서 모든 가게 목록 조회
        for (Store store : Data.storeList) {
            // 라이선스 번호가 일치하는 가게를 찾으면 가게 이름 출력
            if (licenseNumber.equals(store.getLicenseNumber())) {
                System.out.println("  \t     [" + store.getStoreName() + "]");
            }
        }
        // 요일(평일/공휴일), 영업 시간, 휴게 시간 출력
        System.out.println("요일(평일/공휴일)\t\t영업시간\t\t휴게시간");
        for (OperatingHours o : Data.operatingHoursList) {
            if (licenseNumber.equals(o.getLicenseNumber())) {
                System.out.println("\t" + o.getDayOfWeek() + "\t\t" + o.getOpen() + "-" + o.getClose() + "\t"
                        + o.getBreakStart() + "-" + o.getBreakEnd());
            }
        }
    }

    /**
     * 선택을 입력 받는 메서드
     * 
     * @return 사용자가 선택한 번호
     */
    public static int get() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. 영업 시간 관리");
        System.out.println("2. 휴게 시간 관리");
        System.out.println("0. 이전 화면으로");
        System.out.print("선택(번호) : ");
        int temp = scan.nextInt();
        scan.nextLine();

        return temp;
    }

}
