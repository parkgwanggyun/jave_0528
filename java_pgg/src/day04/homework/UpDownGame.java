package day04.homework;

import java.util.Scanner;

public class UpDownGame {

	public static void main(String[] args) {
		/* 1~100사이의 랜덤한 수를 생성하여 해당 숫자를 맞추는 게임을 작성하세요.
		 * 예 (랜덤한 수가 30)
		 * 정수 입력 : 50
		 * Down!
		 * 정수 입력 : 20
		 * Up!
		 * 정수 입력 : 25
		 * Up!
		 * 정수 입력 : 30
		 * 정답입니다.
		 */
		Scanner sc = new Scanner(System.in);
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max = min + 1) + min);
		int num1;
		do {
			System.out.println("숫자를 입력해주세요");
			num1 = sc.nextInt();
			if (num1 > random) {
				System.out.println("Down");
			}else if(num1 < random) {
				System.out.println("Up");
			}else {
				System.out.println("정답입니다" + random + "입니다" );
			}
		}while (num1 != random);
	}
}
