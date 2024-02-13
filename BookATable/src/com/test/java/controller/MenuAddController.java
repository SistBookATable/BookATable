package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.repository.Data;
import com.test.java.view.MenuAddView;

public class MenuAddController {

    public void addMenu(String licenseNumber) {
        
        String menuName = MenuAddView.getMenuName();
        int menuPrice = MenuAddView.getMenuPrice();
        Menu m = new Menu(licenseNumber, menuName, menuPrice);
        Data.menuList.add(m);
        
        //메뉴 이름, 가격, 사업자 번호를 받아와서 새로운 메뉴 객체 생성 후 메뉴리스트에 추가
        
        
        
        MenuManagementController back = new MenuManagementController();
        back.showMenuManagement(licenseNumber);
    }
}

