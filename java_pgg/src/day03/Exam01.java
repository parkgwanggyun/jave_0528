package day03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		
		//성적을 입력받아 입력받은 성적이 60점이상이면 pass,아니면 Fail이 출력되도록 코드를 작성하세요
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("성적을 입력해주세요 : ");
		int score = scanner.nextInt();
		
		String str1 = (score >= 60) ? "Pass" : "Fail";
		System.out.println( score + "점은" + str1);
		

	}

}
