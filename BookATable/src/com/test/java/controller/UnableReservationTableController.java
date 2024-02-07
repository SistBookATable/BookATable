package com.test.java.controller;

import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.UnableReservationTableView;

public class UnableReservationTableController {
	
	public void unableReservation(String licenseNumber) {
	    boolean foundTable = false;
	    do {
	        int unableTableCapacity = UnableReservationTableView.getTableCapacity();
	        
	        for (Table t : Data.tableList) {
	            if (t.getLicenseNumber().equals(licenseNumber) && unableTableCapacity == t.getTableCapacity()) {
	                if (t.isUsage()) {
	                    Table e = new Table(licenseNumber, t.getTableCapacity(), t.getNumber(), false);
	                    int index = Data.tableList.indexOf(t);
	                    Data.tableList.set(index, e);
	                    foundTable = true;
	                } else {
	                    System.out.println("예약불가로 전환할 수 없는 테이블이거나 잘못 입력하셨습니다.");
	                }
	            }
	        }
	        
	        if (!foundTable) {
	            System.out.println("입력한 테이블이 없거나 예약불가 전환할 수 없는 테이블입니다. 다시 입력하세요.");
	        }
	    } while (!foundTable);
	    
	    for (Table u : Data.tableList) {
	        if (u.getLicenseNumber().equals(licenseNumber)) {
	            System.out.println(u.getTableCapacity() + "," + u.getNumber() + "," + u.isUsage());
	        }
	    }
	    
	    TableManagementController back = new TableManagementController();
	    back.showTableManagement(licenseNumber);
	}


}
