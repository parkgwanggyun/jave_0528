package day24;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		/* 문자열을 입력받아 exit가 아니면 입력한 문자열을 출력하고,exit이면 종료하는 코드를 작성하려고 했다
		 * 원인 : 거짓이 선언되어있으면 반복문이 진행이안됌 진실로 바꾸고 문자열 비교는 == 연산자로 안되므로 이퀄스
		 * continue이면 조건식으로 이동하기 때문에 맞았을때 break
		 * 해결방법 :
		 * */
		Scanner sc = new Scanner(System.in);
		boolean res = true;//false;
		while(res) {
			System.out.println("문자열 입력 : ");
			String str = sc.next();
			if(str.equals/*==*/("exit")) {
				res = false;
				break;//continue
			}
			System.out.println(str);
		}

	}

}
