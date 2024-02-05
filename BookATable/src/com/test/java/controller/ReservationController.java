package com.test.java.controller;

import java.util.ArrayList;
import java.util.Calendar;

import com.test.java.model.Member;
import com.test.java.model.Reservation;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.ReservationView;

public class ReservationController {
<<<<<<< HEAD
	
	private ReservationView reservationView = new ReservationView();
	//private ArrayList<Reservation> reservation;
	
	public void reservation(String licenseNumber) {
        //System.out.println(Data.reservationList.ge);
        System.out.println(Member.id);
        System.out.println(Data.userList.get(0));
        for(User u:Data.userList) {
           //System.out.println(u);
           if(Member.id.equals(u.getId())) {
              //Data.loadReservation();
              User user=u;
              System.out.println(Data.reservationList);
              int num=reservationView.getUserReservationNum();
              ReservationView.showCalendar();
              System.out.println();
              String date=reservationView.getUserReservationDate();
              String time=reservationView.getUserReservationTime();
              System.out.println();
              reservationView.showMenu(licenseNumber);
              String reservationSummary=reservationView.getSelectedMenuName(licenseNumber);
              
              System.out.println();
              
              System.out.println();
              
              String menuResult=reservationSummary;
              
              System.out.println(reservationView.showReservation(num, date, time, menuResult));
              
              
              
              
              int reservationPay=3000;
              reservationView.showPay(user);
              String userInput=reservationView.get();
              switch(userInput) {
              case "Y","y":
                 System.out.printf("예약금 결제가 완료 되었습니다.\n예약금 결제 후의 포인트 잔액 [%d원]",user.getBalance()-reservationPay);
                 int changeBalance=user.getBalance()-reservationPay;
                 //TODO user 포인트 변경
                 
                 break;
              case "N", "n":
                 reservationView.showPay(user);
                 //엔터 누르면 메인 이동
              }
              int index=1;
              for(Member m:Data.userList) {
                 
                 if(Member.id.equals(m.getId())) {
//                    System.out.println(u);
                    //Reservation reservation=new Reservation(index,Member.id,licenseNumber,time,date,num,4,"예약",menuResult);
                    //Data.reservationList.add(reservation);
                   // Data.saveReservation();
                    index++;
                 }
                 
              }
              
              System.out.println();
              
           }
           
           
        }
        
        
        
        
  }
=======
   
   ReservationView reservationView = new ReservationView();
   
   public void reservation(String licenseNumber) {
         //System.out.println(Data.reservationList.ge);
         System.out.println(Member.id);
         System.out.println(Data.userList.get(0));
         for(User u:Data.userList) {
            //System.out.println(u);
            if(Member.id.equals(u.getId())) {
               //Data.loadReservation();
               User user=u;
               System.out.println(Data.reservationList);
               int num=reservationView.getReservationNum();
               ReservationView.showCalendar();
               System.out.println();
               String date=reservationView.getReservationDate(licenseNumber);
               String time=reservationView.getReservationTime(licenseNumber);
               System.out.println();
               reservationView.showMenu(licenseNumber);
               String reservationSummary=reservationView.getSelectedMenuName(licenseNumber);
               
               System.out.println();
               
               System.out.println();
               
               String menuResult=reservationSummary;
               
               System.out.println(reservationView.showReservation(num, date, time, menuResult));
               
               
               
               
               int reservationPay=3000;
               reservationView.showPay(user);
               String userInput=reservationView.get();
               switch(userInput) {
               case "Y","y":
                  System.out.printf("예약금 결제가 완료 되었습니다.\n예약금 결제 후의 포인트 잔액 [%d원]",user.getBalance()-reservationPay);
                  int changeBalance=user.getBalance()-reservationPay;
                  //TODO user 포인트 변경
                  
                  break;
               case "N", "n":
                  reservationView.showPay(user);
                  //엔터 누르면 메인 이동
               }
               int index=1;
               for(Member m:Data.userList) {
                  
                  if(Member.id.equals(m.getId())) {
//                     System.out.println(u);
                     Reservation reservation=new Reservation(index,Member.id,licenseNumber,time,date,num,4,"예약",menuResult);
                     Data.reservationList.add(reservation);
                    // Data.saveReservation();
                     index++;
                  }
                  
               }
               
               System.out.println();
               
            }
            
            
         }
         
         
         
         
   }
   
   
   
   
>>>>>>> f9ba0fb460eabfde7008cc9d6edc291ba70b23bc

}