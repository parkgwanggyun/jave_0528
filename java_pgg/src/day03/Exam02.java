package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		//학생 3명의 성적을 입력받아 총점과 평균을 구하는 코드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("첫번째 학생의 점수 :");
		double num1 = Double.parseDouble(scan.nextLine());
		
		System.out.println("두번째 학생의 점수 :");
		double num2 = Double.parseDouble(scan.nextLine());
		
		System.out.println("세번째 학생의 점수 :");
		double num3 = Double.parseDouble(scan.nextLine());
		
		System.out.println("총점 : "+ (num1 + num2 + num3));
		System.out.println("평균 값 : "+ (num1 + num2 + num3)/3);
		
		
		

	}

}
