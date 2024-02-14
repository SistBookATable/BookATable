package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.AddTableView;

/**
 * 테이블을 추가하는 기능을 담당하는 컨트롤러 클래스입니다.
 */
public class AddTableController {
	
	/**
     * 주어진 라이선스 번호에 대한 테이블을 추가합니다.
     *
     * @param licenseNumber 추가할 테이블이 속한 사업자의 라이선스 번호
     */
	public void addTable(String licenseNumber) {
		
AddTableView addTableView = new AddTableView();
        
        int tableCapacity = AddTableView.getTableCapacity();
        int tableNum = AddTableView.getTableNum();
        
        boolean tableFound = false;
        
        for (Table t : Data.tableList) {
            if (t.getLicenseNumber().equals(licenseNumber) && t.getTableCapacity() == tableCapacity) {
                t.setNumber(t.getNumber() + tableNum);
                t.setUsage(true);
                tableFound = true;
                break;
            }
        }
        
        if (!tableFound) {
            Table newTable = new Table(licenseNumber, tableCapacity, tableNum, true);
            Data.tableList.add(newTable);
        }
        
        
    
		        
		    

		
		
		
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