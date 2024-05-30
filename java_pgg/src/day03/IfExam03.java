package day03;

import java.util.Scanner;

public class IfExam03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double answer =0;
		
		System.out.println("연산");
		double num1 = sc.nextDouble();
		String oper= sc.next();
		double num2 = sc.nextDouble();
		
		if(num2 != 0) {
			if (oper.equals("+"))
				answer=num1+num2;
			else if (oper.equals("-")) {
				answer=num1-num2;
				
			}else if (oper.equals("*")) {
				answer=num1*num2;
			}else
				answer=num1/num2;
			System.out.println((num1)+oper+(num2)+"의 계산값은"+(int)(answer));
		}else
			System.out.println("0은 나눌수 없습니다.");
		
		
				

				

	}

}
