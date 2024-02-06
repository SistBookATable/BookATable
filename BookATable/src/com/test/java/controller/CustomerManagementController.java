package com.test.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.MenuRepository;
import com.test.java.repository.ReservationRepository;
import com.test.java.view.CustomerManagementView;

public class CustomerManagementController {

	CustomerManagementView customerManagementView = new CustomerManagementView(); 
	
	public void customerManagement() {
		customerManagementView.showTitle();
		
		boolean loop = true;
		
		while(loop) {
			customerManagementView.showSelectBox();
			int choice = customerManagementView.getSelectType();
			
			switch (choice) {
			case 1:
				// 단골 고객 관리
				
				//ID로 라이센스 넘버 조회
				BusinessUser user = (BusinessUser)MemberRepository.findOneById(Member.id);
				String lisenceNumber = user.getLicenseNumber(); 
				
				//회원 아이디로 예약횟수를 저장할 해쉬맵 생성 <회원ID, 이용횟수>
				//라이센스 넘버로 예약 회원 리스트 조회 
				HashMap<String, Integer> customerList = ReservationRepository.findAllCountByState(lisenceNumber, "방문");
				
				if(customerList.isEmpty()) {
					customerManagementView.hasNoHistory();
				}
				
				//이용횟수로 키셋 정렬
				List<String> keySet = new ArrayList<>(customerList.keySet());
				keySet.sort((o1,o2)-> customerList.get(o1) - customerList.get(o2));
				
				//모든 방문자 리스트 출력
				for (String key : keySet) {
					int count = customerList.get(key);
					String userName = MemberRepository.findOneById(key).getName();
					String menuName = ReservationRepository.findOneByUserId(lisenceNumber,key);
		        }
				
				break;
			case 2:
				break;
			case 0:
				break;
			default:
				customerManagementView.incorrectInputMessage();
			}
		}
	}

}
