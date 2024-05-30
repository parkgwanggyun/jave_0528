package day03;

import java.util.Scanner;

public class SwitchExam02 {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요 (Switch문 이용하여)
		 * 3,4,5 봄
		 * 6,7,8 여름
		 * ,9,10,11 가을
		 * 12,1,2 겨울
		 * 그 외 : 잘못된 월
		 */
        Scanner sc = new Scanner(System.in);
		
		System.out.println("달을 입력해주세요");
		int m = sc.nextInt();
		
		switch (m) {
		case 3,4,5:
			System.out.println("봄입니다.");
			break;
		case 6,7,8:
			System.out.println("여름입니다.");
			break;
		case 9,10,11:
			System.out.println("가을입니다.");
			break;
		case 12,1,2:
			System.out.println("겨울입니다.");
			break;	
		default:
			System.out.println("잘못된 월입니다.");

			
		}

	}

}
