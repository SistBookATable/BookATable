package com.test.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.repository.BlackListRepository;
import com.test.java.repository.MemberRepository;
import com.test.java.repository.ReservationRepository;
import com.test.java.view.CustomerManagementView;

public class CustomerManagementController {

	CustomerManagementView customerManagementView = new CustomerManagementView(); 
	
	public void customerManagement() {
		customerManagementView.showTitle();
		BusinessUser user;
		String lisenceNumber;
		boolean loop = true;
		
		while(loop) {
			customerManagementView.showSelectBox();
			int choice = customerManagementView.getSelectType();
			
			switch (choice) {
			case 1:
				// 단골 고객 관리
				
				//ID로 유저 조회 
				user = (BusinessUser)MemberRepository.findOneById(Member.id);
				
				//라이센스 넘버 조회
				lisenceNumber = user.getLicenseNumber(); 
				
				//회원 아이디로 예약횟수를 저장할 해쉬맵 생성 <회원ID, 이용횟수>
				//라이센스 넘버로 예약 회원 리스트 조회 
				HashMap<String, Integer> customerList = ReservationRepository.findAllCountByState(lisenceNumber, "방문");
				
				if(customerList.isEmpty()) {
					customerManagementView.hasNoHistory();
					continue;
				}
				
				//이용횟수로 키셋 정렬
				List<String> keySet = new ArrayList<>(customerList.keySet());
				
				if(keySet.size()>1) {
					keySet.sort((o1,o2)-> customerList.get(o1) - customerList.get(o2));
				}
				
				//모든 방문자 리스트 출력
				customerManagementView.showCustomerTitle();
				for (String key : keySet) {
					int count = customerList.get(key);
					String userName = MemberRepository.findOneById(key).getName();
					HashMap<String, Integer> menuCount = ReservationRepository.findMenuByUserId(lisenceNumber,key);
					

					//메뉴 주문 횟수로 키셋 정렬
					List<String> menuCountKeySet = new ArrayList<>(menuCount.keySet());
					
					//키셋 개수가 1보다 크면 정렬
					if(menuCountKeySet.size() > 1) {
						menuCountKeySet.sort((o1,o2) -> menuCount.get(o2) - menuCount.get(o1));	
					}
					
					String menuName = menuCountKeySet.get(0);
					int cnt = menuCount.get(menuCountKeySet.get(0));
					
					customerManagementView.showCustomerList(userName,count, menuName, cnt);
		        }
				customerManagementView.pause();
				
				break;
			case 2:
				//블랙리스트 관리

				//ID로 유저 조회 
				user = (BusinessUser)MemberRepository.findOneById(Member.id);
				
				//라이센스 넘버 조회
				lisenceNumber = user.getLicenseNumber(); 
				
				//회원 아이디로 예약횟수를 저장할 해쉬맵 생성 <회원ID, 이용횟수>
				//라이센스 넘버로 예약 회원 리스트 조회 
				HashMap<String, Integer> blackList = ReservationRepository.findAllCountByState(lisenceNumber, "노쇼");
				
				//노쇼 회원이 없으
				if(blackList.isEmpty()) {
					customerManagementView.hasNoBlackList();
					continue;
				}
				
				//노쇼횟수로 키셋 정렬
				List<String> blackListKeySet = new ArrayList<>(blackList.keySet());
				
				if(blackListKeySet.size()>1) {
					blackListKeySet.sort((o1,o2)-> blackList.get(o1) - blackList.get(o2));
				}
				
				//모든 블랙리스트 출력
				customerManagementView.showBlackListTitle();
				for (String key : blackListKeySet) {
					
					//노쇼 횟수
					int count = blackList.get(key);
					
					//사용자
					boolean stop = BlackListRepository.findOne(lisenceNumber, key);
					
					customerManagementView.showBlackList(count, key, stop);
		        }
				AddBlackListController addBlackListController = new AddBlackListController();
				addBlackListController.addBlackList();
				break;
			case 0:
				loop = false;
				break;
			default:
				customerManagementView.incorrectInputMessage();
			}
		}
	}

}
