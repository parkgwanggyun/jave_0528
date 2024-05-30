package day03;

import java.util.Scanner;

public class NestedIfEx02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println( "두 정수와 산술 연산자를 입력하세요 (예  1+2)");
		int num1 = scan.nextInt();
		char operator = scan.next().charAt(0);
		int num2 = scan.nextInt();
		
		double result;
		if(operator == '+') {
			result = num1 +num2;
			System.out.println("" + num1 + operator + num2 + "=" + (int)result);
			
		}else if (operator == '-') {
			result = num1 -num2;
			System.out.println("" + num1 + operator + num2 + "=" + (int)result);
			
		}else if (operator == '*') {
			result = num1*num2;
			System.out.println("" + num1 + operator + num2 + "=" + (int)result);
			
			//num2가 0이면 0으로 나눌수 없습니다고 출력
		}else if (operator == '/') {
			if(num2 !=0)
			   result = num1/num2;
			   System.out.println("" + num1 + operator + num2 + "=" + (int)result);
		}else {
			System.out.println("0으로 나눌 수 없습니다.");
			//num2가 0이면 0으로 나눌수 없습니다고 출력
		}else if (operator == '%') {
			if(num2 != 0) {
			result = num1%num2;
			System.out.println("" + num1 + operator + num2 + "=" + (int)result);
		}
			else {
			System.out.println(operator + "는 산술 연산자가 아닙니다.");
		}
	}

}
}		
