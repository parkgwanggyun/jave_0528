package day03;

import java.util.Scanner;

public class IfExam06_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력해주세요");
		int num1 = sc.nextInt();
		
		if(num1 < 0 || num1 > 100) {
			//여기까지 왔다면 num1은 0보다크고 100보다 작음
			System.out.println("잘못된 성적입니다.");
		}else if (num1 >= 90) {
			System.out.println("A");
			
		}else if (num1 >= 80) {
			System.out.println("B");
			
		}else if(num1 >= 70) {
			System.out.println("C");
		}else if(num1 >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}

	}

}
