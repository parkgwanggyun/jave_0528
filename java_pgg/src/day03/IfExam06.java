package day03;

import java.util.Scanner;

public class IfExam06 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력해주세요");
		int num1 = sc.nextInt();
		
		if((num1>=0)||(num1<=100)) {
			
		}if(num1 < 60) {
			System.out.println("귀하 점수" + num1 +"점은"+"F입니다.");
		}else if (num1 >= 60 && num1 < 70) {
			System.out.println("귀하 점수" + num1 +"점은"+"D입니다.");			
		}else if (num1 >= 70 && num1 < 80) {
			System.out.println("귀하 점수" + num1 +"점은"+"C입니다.");			
		}else if (num1 >= 80 && num1 < 90) {
			System.out.println("귀하 점수" + num1 +"점은"+"B입니다.");	
		}else if (num1 >= 90 && num1 <= 100) {
			System.out.println("귀하 점수" + num1 +"점은"+"A입니다.");	
		}else{
			System.out.println("잘못된 성적입니다.");
		}
	}

}
