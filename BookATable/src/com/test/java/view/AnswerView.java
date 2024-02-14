/**
 * AnswerView 클래스는 문의사항에 대한 답변을 보여주는 화면을 담당하는 클래스입니다.
 * 사용자로부터 답변 등록, 삭제, 뒤로 가기 등의 메뉴를 출력하고, 
 * 해당 기능을 수행하기 위한 정보를 입력받습니다.
 */
public class AnswerView {

    /**
     * 문의사항과 해당 문의에 대한 답변을 화면에 출력하는 메서드입니다.
     * @param inquiry 문의사항 객체
     */
    public void show(Inquiry inquiry) {
        // 화면 출력 로직 생략
    }

    /**
     * 사용자로부터 답변 등록, 삭제, 뒤로 가기 메뉴를 출력하는 메서드입니다.
     */
    public void showSelectBox() {
        // 화면 출력 로직 생략
    }

    /**
     * 사용자로부터 메뉴 선택(답변 등록, 삭제, 뒤로 가기)을 받아오는 메서드입니다.
     * @return 사용자가 선택한 메뉴 번호
     */
    public int getSelectType() {
        return View.getSelectType();
    }

    /**
     * 이미 등록된 답변이 있는 경우 사용자에게 알리는 메서드입니다.
     */
    public void hasAnswerMessage() {
        // 메시지 출력 로직 생략
        View.pause();
    }

    /**
     * 사용자로부터 답변 내용을 입력받는 메서드입니다.
     * @return 사용자가 입력한 답변 내용
     */
    public String getAnswer() {
        // 입력 받는 로직 및 마지막에 "wq" 입력으로 종료하는 방법에 대한 주석 추가
    }

    /**
     * 답변 삭제가 완료된 경우 사용자에게 알리는 메서드입니다.
     */
    public void deleteSuccessMessage() {
        // 메시지 출력 로직 생략
        View.pause();
    }

}
