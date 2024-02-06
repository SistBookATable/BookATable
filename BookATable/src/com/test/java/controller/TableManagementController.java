package com.test.java.controller;

import com.test.java.view.OperationalInfoManagementView;
import com.test.java.view.TableManagementView;

public class TableManagementController {
	
public void showTableManagement(String licenseNumber) {
		

		TableManagementView tableManagementView=new TableManagementView();
		tableManagementView.showChoice();
		boolean loop = true;
		while (loop) {
			
			int choice = TableManagementView.get();
			switch (choice) {
			case 1:
				AddTableController addTableController=new AddTableController();
				addTableController.addTable(licenseNumber);
				
				break;
			case 2:
				EditTableController editTableController=new EditTableController();
				editTableController.editTable(licenseNumber);
				
				break;
				
			case 3:
				RemoveTableController removeTableController=new RemoveTableController();
				removeTableController.removeTable(licenseNumber);
			
				break;
				
			case 4:
				
				
				break;	
			case 5:
				
				
				break;
				

			

			case 0:

			}
		}

	}

}
