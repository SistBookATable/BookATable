package com.test.java.repository;

import java.util.ArrayList;
import java.util.Iterator;

import com.test.java.model.Member;
import com.test.java.model.PointUsage;
import com.test.java.view.SignOutUserManagementView;

public class PointRepository {

	public static ArrayList<PointUsage> findAllById(String userId) {

		ArrayList<PointUsage> tmp = new ArrayList<>();
		
		for(PointUsage p :Data.pointList) {
			if(p.getUserId().equals(userId)) {
				tmp.add(p);
			}
		}
		return tmp;
	}

	public static void addOne(int balance, String today, String string, String userId) {
		
		PointUsage tmp = new PointUsage(0,balance, today, string, userId);
		Data.pointList.add(tmp);
		
	}

	public static PointUsage findLastRefundById(String id) {
		PointUsage tmp = null;
		for(PointUsage p :Data.pointList) {
			if(p.getUserId().equals(id) && p.getContent().equals("포인트환불신청")) {
				tmp = p;
			}
		}
		return tmp;
	}

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
