package com.test.java.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.view.SignOutUserManagementView;
/**
 * point 사용 내역을 조회하고 조작하는 클래스입니다.
 */
public class PointRepository {

	/**
	 * 특정 사용자의 모든 포인트 사용 내역을 찾는 메서드입니다.
	 * @param userId
	 * @return if(p.getUserId().equals(userId)) {
				tmp.add(p);
				}
	 */
	public static ArrayList<PointUsage> findAllById(String userId) {

		ArrayList<PointUsage> tmp = new ArrayList<>();
		
		for(PointUsage p :Data.pointList) {
			if(p.getUserId().equals(userId)) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	/**
	 * 포인트 사용 내역을 추가하는 메서드입니다.
	 * @param balance
	 * @param today
	 * @param string
	 * @param userId
	 */
	public static void addOne(int balance, String today, String string, String userId) {
		
		PointUsage tmp = new PointUsage(0,balance, today, string, userId);
		Data.pointList.add(tmp);
		
	}

	/**
	 * 특정 사용자ID의 마지막 포인트 환불 신청 내역을 찾는 메서드입니다.
	 * @param id
	 * @return
	 */
	public static PointUsage findLastRefundById(String id) {
		PointUsage tmp = null;
		for(PointUsage p :Data.pointList) {
			if(p.getUserId().equals(id) && p.getContent().equals("포인트환불신청")) {
				tmp = p;
			}
		}
		return tmp;
	}

	/**
	 * 포인트 사용 내역을 삭제하는 메서드입니다.
	 * @param usage
	 */
	public static void delete(PointUsage usage) {
		
		Iterator it = Data.pointList.iterator();
		
		while(it.hasNext()) {
			PointUsage p = (PointUsage) it.next();

			if(p.getUsageNumber() == usage.getUsageNumber()) {
				it.remove();
			}	
		}
		
	}

}
