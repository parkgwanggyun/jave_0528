package day04;

public class NestedForEx01 {

	public static void main(String[] args) {
		/*구구단 2~9단을 출력하는 코드를 작성하세요.
		 * 
		 */
		int num1;
		int num2;
		
		for(num1=2; num1<= 9 ; ++num1) {
			//num1단 출력
			System.out.println(num1 + "단");
			for(num2=2; num2<=9; ++num2)
			System.out.println(num1 + "X" + num2 + " = " + num1*num2);
		}

	}

}
