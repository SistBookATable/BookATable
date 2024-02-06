package com.test.java.controller;

import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.UnableReservationTableView;

public class UnableReservationTableController {
	
	public void unableReservation(String licenseNumber) {
		
		int unableTableCapacity=UnableReservationTableView.getTableCapacity();
		
		for(Table t:Data.tableList) {
			if(t.getLicenseNumber().equals(licenseNumber)
					&&unableTableCapacity==t.getTableCapacity()){
				if(t.isUsage()==true) {
				
				Table e=new Table(licenseNumber,t.getTableCapacity(),t.getNumber(),false);
				int index=Data.tableList.indexOf(t);
				Data.tableList.set(index, e);
				}else {
					System.out.println("예약불가로 전환할 수 없는 테이블이거나 잘못 입력하셨습니다.");
				}
			}
			
		}
		
		
		for(Table u:Data.tableList) {
			if(u.getLicenseNumber().equals(licenseNumber)) {
				System.out.println(u.getTableCapacity()+","+u.getNumber()+","+u.isUsage());
			}
				
		}
		
		TableManagementController back= new TableManagementController();
		back.showTableManagement(licenseNumber);
	}

}