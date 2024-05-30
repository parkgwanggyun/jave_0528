package day03;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력해주세요");
		int num1 = sc.nextInt();
		
		if(num1%3 == 0) {
			System.out.println(num1 +"는"+ "3의 배수입니다");
		}else {
			System.out.println(num1 +"는"+ "3의 배수가 아닙니다.");
		}
		

	}

}
