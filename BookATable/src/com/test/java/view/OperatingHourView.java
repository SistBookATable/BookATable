package com.test.java.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.test.java.model.Menu;
import com.test.java.model.OperatingHours;
import com.test.java.model.Store;
import com.test.java.repository.Data;

public class OperatingHourView {
	
public void showOperatingHour(String licenseNumber) {
		
		 Map<Integer, Menu> menuMap = new HashMap<>();
	     for (Store store : Data.storeList) {
	            if (licenseNumber.equals(store.getLicenseNumber())) {
	                System.out.println("  \t[" + store.getStoreName() + "]");
	            }
	        }
		System.out.println("요일(평일/공휴일)\t\t영업시간\t\t휴게시간");
//	OperatingHours o = new OperatingHours(licenseNumber,"월","1200","1500","1600","2000");
////		System.out.println(licenseNumber.equals(o.getLicenseNumber()));
//		System.out.println(licenseNumber.equals(o.getLicenseNumber()));
		for(OperatingHours o :Data.operatingHoursList) {
			System.out.println(o.getDayOfWeek());
//			if(licenseNumber.equals(o.getLicenseNumber())) {
//				System.out.println(o.getDayOfWeek());
//			}
		}
		
		
		
	}

public static int get() {
	Scanner scan = new Scanner(System.in);
	System.out.println("1. 영업 시간 관리");
	System.out.println("2. 휴게 시간 관리");
	System.out.print("선택(번호) : ");
	int temp = scan.nextInt();
	scan.nextLine();
	
	return temp;
}

}