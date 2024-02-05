package com.test.java.controller;

import java.util.Comparator;

import com.test.java.model.Store;

public class FindDistanceFromController implements Comparator<Store> {

   @Override
   public int compare(Store stationDistance1, Store stationDistance2) {
      
      int distance1 = stationDistance1.getDistanceFrom();
      int distance2 = stationDistance2.getDistanceFrom();
      
      return Integer.compare(distance1, distance2);
   }
   

}