package day04;

import java.util.Scanner;

public class WhileEx02 {

	public static void main(String[] args) {
		// 1부터 5까지 콘솔에 출력하는 코드를 작성하세요.
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요(1~100) : ");
		
		int i = scanner.nextInt();		
		while(i <= 100) {
			
			}
			System.out.println(i);
			++i;
			
	if(i > 100) {
		System.out.println("정상 입력 수치를 넘겼습니다.");
	}else {
		System.out.println(i);

	}
	}
}
