package day03;

import java.util.Scanner;

public class IfExam05_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int num1 = sc.nextInt();
		
		/*num가 6의 배수이면 6의 배수라고 출력하고
		 * 아니면 num가 2의 배수이면 2의 배수라고 출력하고
		 * 아니면 num가 3의 배수이면 3의 배수라고 출력하고
		 * 아니면 2,3,6 의 배수가 아닙니다라고 출력
		 */
		/* num가 2의 배수이고 3의 배수가 아니면 2의 배수라고 출력하고
		 * num가 3의 배수이고 2의 배수가 아니면 3의 배수라고 출력하고
		 * num가 6의 배수이면 6의 배수라고 출력하고
		 * 아니면 2,3,6의 배수가 아닙니다라고 출력
		 */
		if(num1 % 2 == 0  && num1 % 3 != 0) {
			System.out.println(num1+"는"+"2의 배수입니다");
		}
		else if(num1 % 3 == 0 && num1 % 2 !=0) {
			System.out.println(num1+"는"+"3의 배수입니다");
		}
		else if(num1 % 6 == 0) {
			System.out.println(num1+"는"+"6의 배수입니다");
		}
		else {
			System.out.println("2,3,6의 배수가 아닙니다.");
	}
	}
}
