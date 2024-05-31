package day04;

import java.util.Scanner;

public class WhileEx10 {

	public static void main(String[] args) {
		/* 반복문을 이용하여 문자를 입력받고 입력받은 문자가 y이면 반복문을 종료하는 코드를 작서하세요.
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		char A;
		
		while(A <= 'z') {
			if(A != 'y') {
				System.out.println("알파벳을 입력하세요");
				char A = sc.next().charAt(0);
				System.out.println("못찾으셨습니다.");
				break;
			}else {
				System.out.println("찾으셨습니다.");
				break;
			}
			
		}
	}

}
