package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.AddTableView;

public class AddTableController {
	
	public void addTable(String licenseNumber) {
		
		AddTableView addTableView=new AddTableView();
		
		int tableCapacity=AddTableView.getTableCapacity();
		int tableNum=AddTableView.getTableNum();
		
		for (Table t : Data.tableList) {
		    if (t.getLicenseNumber().equals(licenseNumber) && t.getTableCapacity() == tableCapacity) {
		        int index = Data.tableList.indexOf(t);
		        Table u = new Table(licenseNumber, tableCapacity, t.getNumber() + tableNum, true);
		        Data.tableList.set(index, u);
		        
		        }
		    

		}
		
		
			
		        Table u = new Table(licenseNumber, tableCapacity,  tableNum, true);
		        Data.tableList.add(u);
		        //TODO 할거있음
		        
		        
		    

		
		
		
//		for(Table u:Data.tableList) {
//			if(u.getTableCapacity()==tableCapacity&&u.getLicenseNumber().equals(licenseNumber)) {
//				Table t=new Table(licenseNumber,tableCapacity,tableNum+u.getNumber(),true);
//				int index=Data.tableList.indexOf(u);
//				Data.tableList.set(index,t);
//			}
//				
//			
//		}
//		
//		Table k=new Table(licenseNumber,tableCapacity,tableNum,true);
//				Data.tableList.add(k);
//		
		
		
		for(Table n:Data.tableList) {
			if(licenseNumber.equals(n.getLicenseNumber())) {
				System.out.println(n.getTableCapacity()+","+n.getNumber());
			}
		}
		
		TableManagementController back= new TableManagementController();
		back.showTableManagement(licenseNumber);
	}

}