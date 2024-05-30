package day03;

import java.util.Scanner;

public class ScannerEx03 {

	public static void main(String[] args) {
		/* Scanner 예제
		 * 한 번에 여러 값을 받는 예제
		 * 3학생의 성적을 한 번에 입력받는 예제
		 */
		
		int score1 , score2 , score3;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("세 학생의 성적을 입력하세요 : ");
		score1 = sc.nextInt();
		score2 = sc.nextInt();
		score3 = sc.nextInt();
		
		System.out.println("세 학생의 성적 : " + score1 + "," + score2 + "," + score3);
		
	}

}
