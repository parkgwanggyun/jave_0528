package day03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("과목1 성적 입력 : ");
		int num1 = scan.nextInt();
		
		System.out.print("과목2 성적 입력 : ");
		int num2 = scan.nextInt();
		
		//총점을 계산해서 sum에 저장
		int sum = num1 + num2;
		//총점을 이용하여 평균을 계산하여 avg에 저장
		double avg = (double)sum / 2;
		//과락이 있는지 확인하여 결과를 isFail에 저장
		boolean isFail = (num1 < 40 || num2 < 40);
		//평균이 60점이상이고 과락이 아니면 합격,아니면 불합격을 문자열 result에 저장
		//조건식  : 평균이 60점 이상익 과락이 아니다
		//avg이 60보다 크거나 같다 && isFail 이 아니다.
		
		String result = (avg >= 60 && !isFail) ? "합격" : "불합격";
		//result을 이용하여 결과를 출력
		System.out.println(result);

	}

}
