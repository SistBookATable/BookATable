package com.test.java.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Admin;
import com.test.java.model.BusinessUser;
import com.test.java.model.Member;
import com.test.java.model.Store;
import com.test.java.model.User;

public class Data {
	
	//여러개면 Path 클래스를 만들어서 넣는게 좋음
	private final static String USER = "dat\\User.txt";
	private final static String BUSINESSUSER = "dat\\BusinessUser.txt";
	private final static String ADMIN = "dat\\Admin.txt";
	private final static String STORE = "dat\\Store.txt";
	
	//필요한 자료들
	public static ArrayList<Member> memberList = new ArrayList<>();
	public static ArrayList<Store> storeList = new ArrayList<>();
	
	//프로그램을 시작할 때 file의 내용을 모두 메모리에 넣는 작업
	public static void loadAdmin() {
		try {
			BufferedReader reader
				= new BufferedReader(new FileReader(Data.ADMIN));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				
				Admin admin = new Admin(Integer.parseInt(tmp[0]), tmp[1], tmp[2]); 
				memberList.add(admin);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void loadUser() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.USER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				
				memberList.add(null);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void loadBusinessUser() {
		try {
			BufferedReader reader
			= new BufferedReader(new FileReader(Data.BUSINESSUSER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] tmp = line.split(",");
				
				memberList.add(null);
			}
			
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//프로그램을 끝낼 때 메모리의 내용을 모두 file에 넣는 작업
	public static void save() {

	}
	public static String getUser() {
		return USER;
	}
}
