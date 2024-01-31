package com.test.java.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.BusinessUser;
import com.test.java.model.Store;
import com.test.java.model.User;

public class Data {
	
	//여러개면 Path 클래스를 만들어서 넣는게 좋음
	private final static String USER = "dat\\User.txt";
	private final static String BUSINESSUSER = "dat\\BusinessUser.txt";
	private final static String STORE = "dat\\Store.txt";
	
	//필요한 자료들
	public static ArrayList<User> userList = new ArrayList<>();
	public static ArrayList<BusinessUser> businessUserList = new ArrayList<>();
	public static ArrayList<Store> StoreList = new ArrayList<>();
	
	//프로그램을 시작할 때 file의 내용을 모두 메모리에 넣는 작업
	public static void load() {

	}
	//프로그램을 끝낼 때 메모리의 내용을 모두 file에 넣는 작업
	public static void save() {

	}
}
