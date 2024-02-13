package com.test.java.controller;

import com.test.java.model.OperatingHours;
import com.test.java.repository.Data;
import com.test.java.view.ChangeBreakHourView;

/**
 * 업무 휴식 시간을 변경하는 컨트롤러 클래스입니다.
 */
public class ChangeBreakHourController {

    /**
     * 특정 라이선스 번호에 해당하는 업체의 휴식 시간을 변경합니다.
     *
     * @param licenseNumber 변경할 업체의 라이선스 번호
     */
    public void changeBreakHour(String licenseNumber) {
        ChangeBreakHourView changeBreakHourView = new ChangeBreakHourView();

        // 휴식 시간 변경 뷰를 인스턴스화하고 호출합니다.
        changeBreakHourView.changeBreakHour(licenseNumber);

        String changeDay;
        String changeBreakStart;
        String changeBreakEnd;

        // 올바른 요일이 입력될 때까지 반복
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

    /**
     * 주어진 문자열이 올바른 요일 형식인지 확인합니다.
     *
     * @param day 확인할 요일 문자열
     * @return 올바른 요일 형식인 경우 true를 반환하고, 그렇지 않으면 false를 반환합니다.
     */
    private boolean isValidDay(String day) {
        String[] validDays = {"월", "화", "수", "목", "금", "토", "일","공휴일"};
        for (String validDay : validDays) {
            if (validDay.equalsIgnoreCase(day)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 주어진 문자열이 올바른 시간 형식인지 확인합니다.
     *
     * @param time 확인할 시간 문자열
     * @return 올바른 시간 형식인 경우 true를 반환하고, 그렇지 않으면 false를 반환합니다.
     */
    private boolean isValidTime(String time) {
        return time.matches("^([01]?[0-9]|2[0-3])[0-5][0-9]$");
    }
}
