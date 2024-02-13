package com.test.java.controller;

import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.EditTableView;

/**
 * 테이블을 편집하는 컨트롤러 클래스입니다.
 */
public class EditTableController {
    
    /**
     * 주어진 라이선스 번호에 해당하는 업체의 테이블을 편집합니다.
     *
     * @param licenseNumber 편집할 업체의 라이선스 번호
     */
    public void editTable(String licenseNumber) {
        
        int editTableCapacity = EditTableView.getTableCapacity();
        boolean found = false;
        //사업자 번호와 정원이 맞는 테이블을 찾아 새로운 테이블 객체에 넣어 테이블 리스트 수정
        for (Table t : Data.tableList) {
            if (t.getLicenseNumber().equals(licenseNumber) && editTableCapacity == t.getTableCapacity()) {
                found = true;

                int editTableNum = EditTableView.getTableNum();
                Table e = new Table(licenseNumber, editTableCapacity, editTableNum, true);

                int index = Data.tableList.indexOf(t);
                if (index != -1) {
                    Data.tableList.set(index, e);
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("해당 테이블을 찾을 수 없습니다.");
        }

        
        for(Table n:Data.tableList) {
            if(licenseNumber.equals(n.getLicenseNumber())) {
                System.out.println(n.getTableCapacity()+"+"+n.getNumber());
            }
        }
        TableManagementController back= new TableManagementController();
        back.showTableManagement(licenseNumber);
    }
}
