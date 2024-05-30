package day03;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("나이를 입력하세요 : ");
		int num1 = scan.nextInt();
		
		if(num1 >= 60) {
			System.out.println("노인입니다.");
		}
		else if(num1 >= 19){
			System.out.println("성인입니다.");
		}
		else {
			System.out.println("미성년자입니다.");
		}

	}

}
