package com.test.java.controller;

import java.util.Calendar;

import com.test.java.model.Member;
import com.test.java.model.User;
import com.test.java.repository.Data;
import com.test.java.view.UserCancellationView;

/**
 * UserCancellationController 클래스는 사용자 계정 취소 프로세스를 처리합니다.
 */
public class UserCancellationController {

    /**
     * 사용자 계정 취소 프로세스를 시작하는 메서드입니다.
     */
    public void UserCancellation() {

        // 반복문을 통해 사용자 입력을 받고 처리합니다.
        boolean loop = true;
        while (loop) {
            // 사용자 취소 화면을 표시합니다.
            UserCancellationView.show();

            // 사용자에게 비밀번호를 입력받습니다.
            String inputPw = UserCancellationView.getPw();
            // 저장된 비밀번호를 찾습니다.
            String pw = findPwById(Member.id);

            // 입력된 비밀번호와 저장된 비밀번호를 비교합니다.
            if (!inputPw.equals(pw)) {
                // 비밀번호가 일치하지 않을 경우 사용자에게 알립니다.
                System.out.println("비밀번호를 잘못 입력하셨습니다.");
                loop = true;
            } else {
                // 비밀번호가 일치할 경우 사용자 탈퇴를 처리합니다.
                userSignOut(pw);
                System.out.println("회원탈퇴가 완료되었습니다.");
                loop = false;
            }
        }
    }

    /**
     * 사용자를 탈퇴 처리하는 메서드입니다.
     *
     * @param pw 사용자의 비밀번호
     */
    private void userSignOut(String pw) {
        // 현재 날짜를 가져와 탈퇴일자로 설정합니다.
        Calendar c = Calendar.getInstance();
        String signOut = String.format("%tF", c);

        // 멤버 리스트를 순회하며 해당 사용자를 찾아 탈퇴일자를 설정합니다.
        for (Member u : Data.memberList) {
            if (u.getPw().equals(pw)) {
                ((User) u).setSignOut(signOut);
            }
        }
    }

    /**
     * ID를 기반으로 사용자의 비밀번호를 찾는 메서드입니다.
     *
     * @param id 사용자의 ID
     * @return ID에 해당하는 사용자의 비밀번호, 없으면 null
     */
    private String findPwById(String id) {
        for (Member u : Data.memberList) {
            if (u.getId().equals(id)) {
                return u.getPw();
            }
        }
        return null;
    }
}
