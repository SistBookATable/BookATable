package com.test.java.controller;

import com.test.java.model.OperatingHours;
import com.test.java.repository.Data;
import com.test.java.view.ChangeBreakHourView;

public class ChangeBreakHourController {

    public void changeBreakHour(String licenseNumber) {
        ChangeBreakHourView changeBreakHourView = new ChangeBreakHourView();

        changeBreakHourView.changeBreakHour(licenseNumber);

        String changeDay;
        String changeBreakStart;
        String changeBreakEnd;

        // 올바른 요일 값이 입력될 때까지 반복
        while (true) {
            changeDay = ChangeBreakHourView.getDay();
            if (isValidDay(changeDay)) {
                break;
            } else {
                System.out.println("올바른 요일을 입력하세요 (월~일).");
            }
        }

        // 올바른 시간 형식이 입력될 때까지 반복
        while (true) {
            changeBreakStart = ChangeBreakHourView.getOpen();
            changeBreakEnd = ChangeBreakHourView.getClose();
            if (isValidTime(changeBreakStart) && isValidTime(changeBreakEnd)) {
                break;
            } else {
                System.out.println("올바른 시간 형식을 입력하세요 (HHmm).");
            }
        }

        for (OperatingHours o : Data.operatingHoursList) {
            if (licenseNumber.equals(o.getLicenseNumber()) && o.getDayOfWeek().equalsIgnoreCase(changeDay)) {
                System.out.println(o.toString());
                o.setBreakStart(changeBreakStart);
                o.setBreakEnd(changeBreakEnd);
                System.out.println(o.toString());
                int index=Data.operatingHoursList.indexOf(o);
                OperatingHours h=new OperatingHours(licenseNumber, changeDay, o.getOpen(), o.getClose(), changeBreakStart, changeBreakEnd);
                Data.operatingHoursList.set(index, h);
            }
        }

        System.out.println("수정이 완료 되었습니다.\n");

        OperatingHourController operatingHourController = new OperatingHourController();
        operatingHourController.showOperatingHour(licenseNumber);

    }

    // 올바른 요일 형식인지 확인하는 메서드
    private boolean isValidDay(String day) {
        String[] validDays = {"월", "화", "수", "목", "금", "토", "일","공휴일"};
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
