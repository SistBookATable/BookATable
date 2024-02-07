package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.repository.Data;
import com.test.java.view.MenuEditView;

import java.util.Scanner;

public class MenuEditController {

    MenuEditView menuEditView = new MenuEditView();

    public void editMenu(String licenseNumber) {
        boolean foundMenu = false;
        do {
            String findMenu = MenuEditView.findMenuName();

            for (Menu m : Data.menuList) {
                if (licenseNumber.equals(m.getLicenseNumber()) && findMenu.equals(m.getMenuName())) {
                    // 해당 라이센스 번호와 메뉴 이름을 가진 메뉴를 찾았을 때
                    foundMenu = true;
                    String menuName = MenuEditView.getMenuName();
                    int menuPrice = MenuEditView.getMenuPrice();

                    // 수정된 메뉴를 새로운 Menu 객체로 생성
                    Menu editMenu = new Menu(licenseNumber, menuName, menuPrice);

                    // 해당 메뉴를 리스트에서 찾아서 수정
                    int index = Data.menuList.indexOf(m);
                    if (index != -1) { // 리스트에서 해당 메뉴를 찾은 경우에만 수정
                        Data.menuList.set(index, editMenu);
                        break; // 수정 후에는 더 이상 반복할 필요가 없으므로 반복문 종료
                    } else {
                        System.out.println("해당 메뉴를 찾을 수 없습니다.");
                    }
                }
            }

            if (!foundMenu) {
                System.out.println("입력한 메뉴가 없습니다. 다시 입력하세요.");
            }
        } while (!foundMenu);

        // TODO 데이터 세이브.
        for (Menu n : Data.menuList) {
            if (licenseNumber.equals(n.getLicenseNumber())) {
                System.out.println(n.getMenuName());
            }
        }
        MenuManagementController back = new MenuManagementController();
        back.showMenuManagement(licenseNumber);
    }
}
