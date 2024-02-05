package com.test.java.repository;

import java.util.ArrayList;

import com.test.java.model.Member;

public class MemberRepository {
	
	public Member findOneById(String id) {
		for(Member m : Data.memberList) {
			if(m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Member> findAll() {
		ArrayList<Member> tmp = new ArrayList<>();
		for(Member m : Data.memberList) {
			tmp.add(m);
		}
		return tmp;
	}

	public static boolean isValidName(String name) {
		
		for(Member m : Data.memberList) {
			if(m.getName().equals(name)) {
				return true;
			}
		}
		
		return false;
	}

	public static boolean checkDuplicate(String id) {
		for(Member m : Data.memberList) {
			if(m.getName().equals(id)) {
				return false;
			}
		}
		return true;
	}
}
