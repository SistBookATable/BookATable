package com.test.java.controller;

import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.EditTableView;

public class EditTableController {
	
	public void editTable(String licenseNumber) {
		
		int editTableCapacity=EditTableView.getTableCapacity();
		for(Table t : Data.tableList) {
			if(t.getLicenseNumber().equals(licenseNumber)&&editTableCapacity==t.getTableCapacity()) {
				
				int editTableNum=EditTableView.getTableNum();
				Table e = new Table(licenseNumber,editTableCapacity,editTableNum,true);
				
				int index = Data.tableList.indexOf(t);
		        if (index != -1) { 
		            Data.tableList.set(index, e);
		            break; 
		        } else {
		            System.out.println("해당 테이블을 찾을 수 없습니다.");
		        }
			}
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
