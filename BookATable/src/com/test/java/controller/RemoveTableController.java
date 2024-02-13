package com.test.java.controller;

import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.RemoveTableView;

/**
 * 테이블을 제거하는 컨트롤러 클래스입니다.
 */
public class RemoveTableController {
    
    /**
     * 주어진 라이선스 번호에 해당하는 업체의 테이블을 제거합니다.
     *
     * @param licenseNumber 제거할 업체의 라이선스 번호
     */
    public void removeTable(String licenseNumber) {
        int findTableCapacity;
        boolean found = false;

        do {
            findTableCapacity = RemoveTableView.findTableCapacity(); //view에서 삭제할 테이블 정원 받아오기
            for (Table t : Data.tableList) {
                if (t.getLicenseNumber().equals(licenseNumber) && findTableCapacity == t.getTableCapacity()) {
                    found = true; //사업자 번호와 테이블 정원이 일치하면 found true 설정
                    break;
                }
            }
            if (!found) {
                System.out.println("해당 테이블이 없습니다. 다시 입력하세요.");
            }
        } while (!found);

        int removeCheck = RemoveTableView.removeCheck();
        if (removeCheck == 1) { //1번 전체 삭제를 누르면 전체 삭제
            for (Table t : Data.tableList) {
                if (t.getLicenseNumber().equals(licenseNumber) && findTableCapacity == t.getTableCapacity()) {
                    int index = Data.tableList.indexOf(t);

                    if (index != -1) {
                        Data.tableList.remove(index);
                        break;
                    } else {
                        break;
                    }
                }
            }

        } else if (removeCheck == 2) { // 2번을 누르면 수정할 테이블 개수를 입력받아 새로운 테이블 객체 생성 후 테이블 리스트에 수정
            int getRemoveTableNum = RemoveTableView.getRemoveTableNum();
            for (Table e : Data.tableList) {
                if (e.getLicenseNumber().equals(licenseNumber) && findTableCapacity == e.getTableCapacity()) {
                    int index = Data.tableList.indexOf(e);
                    int changeTableNum = e.getNumber() - getRemoveTableNum;
                    if (changeTableNum >= 0) {
                        Table k = new Table(licenseNumber, findTableCapacity, e.getNumber() - getRemoveTableNum, true);
                        if (index != -1) {
                            Data.tableList.set(index, k);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("테이블 개수보다 많습니다.");
                    }

                }

            }
        } else {
            System.out.println("잘못된 값 입력");
        }

       
        TableManagementController back = new TableManagementController();
        back.showTableManagement(licenseNumber);
    }
}
