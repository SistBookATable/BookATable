package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.repository.Data;
import com.test.java.view.MenuRemoveView;


public class MenuRemoveController {
	
	MenuRemoveView menuRemoveView=new MenuRemoveView();

	public void removeMenu(String licenseNumber) {
		String findMenu=MenuRemoveView.findMenuName();
		
		for (Menu m : Data.menuList) {
		    if (licenseNumber.equals(m.getLicenseNumber()) && findMenu.equals(m.getMenuName())) {
		        // 해당 라이센스 번호와 메뉴 이름을 가진 메뉴를 찾았을 때
		        String check=MenuRemoveView.removeCheck();
		        
//		        
		        int index = Data.menuList.indexOf(m);	
		        
		        
		        if (index != -1 &&check.equals("y")) { // 리스트에서 해당 메뉴를 찾은 경우에만 수정
		            Data.menuList.remove(index);
		            break; // 수정 후에는 더 이상 반복할 필요가 없으므로 반복문 종료
		        } else {
		            break;
		        }
		    }
		}
		//TODO 데이터 세이브.
		for(Menu n:Data.menuList) {
			if(licenseNumber.equals(n.getLicenseNumber())) {
				System.out.println(n.getMenuName());
			}
		}
		
		
	}

}
