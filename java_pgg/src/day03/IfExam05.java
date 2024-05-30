package day03;

import java.util.Scanner;

public class IfExam05 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int num1 = sc.nextInt();
		
		if(num1%6 ==0) {
			System.out.println(num1+"는"+"6의 배수입니다");
		}else if (num1%3==0) {
			System.out.println(num1+"는"+"3의 배수입니다");			
		}else if (num1%2==0) {
			System.out.println(num1+"는"+"2의 배수입니다");
		}else {
			System.out.println("오류입니다.");
		}

	}

}
