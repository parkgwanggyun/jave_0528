package day03;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("달을 입력하세요 : ");
		int num1 = scan.nextInt();
		
		if(num1 == 0) {
			System.out.println("잘못 입력하셨습니다.");
	    }else if(num1 <= 2 || num1 == 12) {
			System.out.println("겨울입니다.");
			
		}else if(num1 <= 5 && num1 >= 3) {
			System.out.println("봄입니다.");
			
		}else if(num1 <= 8 && num1 >= 6) {
			System.out.println("여름입니다.");
			
		}else if(num1 <= 11 && num1 >= 9) {
			System.out.println("가을입니다");
		}else {
			System.out.println("잘못 입력하셨습니다.");
		}
		/* 월이 3이상이고 월이 5이하이면 봄이라고 출력하고
		 * 아니면 월이 6이상이고 월이 8이하이면 여름이라고 출력하고
		 * 아니면 월이 9이상이고 월이 11이하이면 가을이라고 출력하고
		 * 아니면 월이 12이거나 월이 1이상이고 2이하이면 겨울이라고 출력하고
		 * 아니면 잘못된 월이라고 출력	
		 */
		if(num1 >= 3 && num1 <= 5) {
			System.out.println("봄");
		}else if(num1 >= 6 && num1 <=8) {
			System.out.println("여름");
		}else if(num1 >= 9 && num1 <= 11) {
			System.out.println("가을");
			
		}else if(num1 == 12 || (num1 >= 1 && num1 <=2)) {
			System.out.println("겨울");
		}else {
			System.out.println("잘못된 월");
		}
	}

}
