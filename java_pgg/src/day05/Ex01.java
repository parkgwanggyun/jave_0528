package day05;

public class Ex01 {

	public static void main(String[] args) {
		int[] num = {3, 8, 5, 2, 9};
        int target = 5; // 찾고자 하는 값
        
        boolean found = false; // 값을 찾았는지 여부를 저장하는 변수
        
        // 배열의 모든 요소를 반복하면서 찾고자 하는 값과 일치하는지 확인
        for (int number : num) {
            if (number == target) {
                found = true; // 값을 찾았음을 표시
                break; // 값을 찾았으므로 더 이상 반복할 필요가 없음
            }
        }
        
        // 값을 찾은 경우와 찾지 못한 경우에 따라 메시지 출력
        if (found) {
            System.out.println("값이 발견되었습니다!");
        } else {
            System.out.println("값이 발견되지 않았습니다!");
        }
    }
}

