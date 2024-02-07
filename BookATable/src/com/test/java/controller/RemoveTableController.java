package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.RemoveTableView;

public class RemoveTableController {
	
	public void removeTable(String licenseNumber) {
	    int findTableCapacity;
	    boolean found = false;

	    do {
	        findTableCapacity = RemoveTableView.findTableCapacity();
	        for (Table t : Data.tableList) {
	            if (t.getLicenseNumber().equals(licenseNumber) && findTableCapacity == t.getTableCapacity()) {
	                found = true;
	                break;
	            }
	        }
	        if (!found) {
	            System.out.println("해당 테이블이 없습니다. 다시 입력하세요.");
	        }
	    } while (!found);

	    int removeCheck = RemoveTableView.removeCheck();
	    if (removeCheck == 1) {
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

	    } else if (removeCheck == 2) {
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

	    for (Table n : Data.tableList) {
	        if (licenseNumber.equals(n.getLicenseNumber())) {
	            System.out.println(n.getTableCapacity() + "+" + n.getNumber());
	        }
	    }
	    TableManagementController back = new TableManagementController();
	    back.showTableManagement(licenseNumber);
	}


}
