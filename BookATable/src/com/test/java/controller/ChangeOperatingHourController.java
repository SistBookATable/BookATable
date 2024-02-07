package com.test.java.controller;

import com.test.java.model.OperatingHours;
import com.test.java.repository.Data;
import com.test.java.view.ChangeOperatingHourView;

import java.util.Scanner;

public class ChangeOperatingHourController {

    public void changeOperatingHour(String licenseNumber) {
        ChangeOperatingHourView changeOperatingHourView = new ChangeOperatingHourView();

        changeOperatingHourView.changeOperatingHour(licenseNumber);

        String changeDay;
        String changeOpenHour;
        String changeCloseHour;

        // 올바른 요일 값이 입력될 때까지 반복
        while (true) {
            changeDay = ChangeOperatingHourView.getDay();
            if (isValidDay(changeDay)) {
                break;
            } else {
                System.out.println("올바른 요일을 입력하세요 (월~일).");
            }
        }

        // 올바른 시간 형식이 입력될 때까지 반복
        while (true) {
            changeOpenHour = ChangeOperatingHourView.getOpen();
            changeCloseHour = ChangeOperatingHourView.getClose();
            if (isValidTime(changeOpenHour) && isValidTime(changeCloseHour)) {
                break;
            } else {
                System.out.println("올바른 시간 형식을 입력하세요 (HHmm).");
            }
        }

        for (OperatingHours o : Data.operatingHoursList) {
            if (licenseNumber.equals(o.getLicenseNumber()) && o.getDayOfWeek().equalsIgnoreCase(changeDay)) {
                System.out.println(o.toString());
                o.setOpen(changeOpenHour);
                o.setClose(changeCloseHour);
                System.out.println(o.toString());
                int index=Data.operatingHoursList.indexOf(o);
                OperatingHours h=new OperatingHours(licenseNumber, changeDay, changeOpenHour,changeCloseHour , o.getBreakStart(), o.getBreakEnd());
                Data.operatingHoursList.set(index, h);
            }
        }

        System.out.println("수정이 완료 되었습니다.\n");

        OperatingHourController operatingHourController = new OperatingHourController();
        operatingHourController.showOperatingHour(licenseNumber);

    }

    // 올바른 요일 형식인지 확인하는 메서드
    private boolean isValidDay(String day) {
        String[] validDays = {"월", "화", "수", "목", "금", "토", "일"};
        for (String validDay : validDays) {
            if (validDay.equalsIgnoreCase(day)) {
                return true;
            }
        }
        return false;
    }

    // 올바른 시간 형식인지 확인하는 메서드
    private boolean isValidTime(String time) {
        return time.matches("^([01]?[0-9]|2[0-3])[0-5][0-9]$");
    }
}
