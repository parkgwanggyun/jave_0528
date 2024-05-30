package day03;

import java.util.Scanner;

public class IfExam02_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("달을 입력해주세요");
		int m = sc.nextInt();
		
		if((m>=1)&&(m<=12)) {
			if((m ==3)|| (m==4)||(m==5)) {
				System.out.println("봄");
			}else if((m ==6)|| (m==7)||(m==8)) {
				System.out.println("여름");
			}else if((m ==9)|| (m==10)||(m==11)) {
				System.out.println("가을");			
			}else {
				System.out.println("겨울");
			}
				
				
		}else {
			System.out.println("잘못입력");
		}

	}

}
