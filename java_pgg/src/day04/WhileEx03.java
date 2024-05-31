package day04;

public class WhileEx03 {

	public static void main(String[] args) {
		/*구구단 2단을 출력하는 코드를 작성하세요.
		 * 2*1 = 2
		 * 2*2 = 4
		 * ...
		 * 2*9=18
		 * 반복회수 : i는 1부터 9까지 1씩 증가
		 * 규칙성 : 2 x i = (2*i)를 출력
		 * 반복문 종료 후 : 없음
		 */
		int num = 2;
		int num2 = 1;
		
		while (num2 <= 9) {
			System.out.println(num + "x" + num2 + "=" + (num*num2));
			++num2;
		}
		

	}

}
