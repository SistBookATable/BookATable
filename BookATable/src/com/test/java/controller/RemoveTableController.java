package com.test.java.controller;

import com.test.java.model.Menu;
import com.test.java.model.Table;
import com.test.java.repository.Data;
import com.test.java.view.RemoveTableView;

public class RemoveTableController {
	
	public void removeTable(String licenseNumber) {
		
		int findTableCapacity=RemoveTableView.findTableCapacity();
		int removeCheck=RemoveTableView.removeCheck();
		if(removeCheck==1) {
			for(Table t:Data.tableList) {
				if(t.getLicenseNumber().equals(licenseNumber)&&findTableCapacity==t.getTableCapacity()) {
					int index = Data.tableList.indexOf(t);	
			        
			        
			        if (index != -1) { // 리스트에서 해당 메뉴를 찾은 경우에만 수정
			            Data.tableList.remove(index);
			            break; // 수정 후에는 더 이상 반복할 필요가 없으므로 반복문 종료
			        } else {
			            break;
			        }
				}
			}
			
		}
		else if(removeCheck==2) {
			int getRemoveTableNum=RemoveTableView.getRemoveTableNum();
			for(Table e:Data.tableList) {
				if(e.getLicenseNumber().equals(licenseNumber)&&findTableCapacity==e.getTableCapacity()) {
					int index = Data.tableList.indexOf(e);	
			        
			        Table k=new Table(licenseNumber,findTableCapacity,e.getNumber()-getRemoveTableNum,true);
			        if (index != -1) { // 리스트에서 해당 메뉴를 찾은 경우에만 수정
			            Data.tableList.set(index,k);
			            break; // 수정 후에는 더 이상 반복할 필요가 없으므로 반복문 종료
			        } else {
			            break;
			        }
					
					
				}
			}//for
		}//else if
		else {
			System.out.println("잘못된 값 입력");
		}//else
		
		for(Table n:Data.tableList) {
			if(licenseNumber.equals(n.getLicenseNumber())) {
				System.out.println(n.getTableCapacity()+"+"+n.getNumber());
			}
		}
		TableManagementController back= new TableManagementController();
		back.showTableManagement(licenseNumber);
	}//removeTable()

}
