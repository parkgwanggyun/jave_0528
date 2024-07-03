package com.kr.test;

import java.util.Scanner;

public class Test {
	static void main(String[] args) {
		
	}
	public void count() {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("문자열을 입력해주세요 : ");
			String str = sc.nextLine();
			if(str.equals("exit")) {
				break;
				
			}else {
				System.out.println(str.length() + "글자 수");
			}
		}
		System.out.println("종료");
	}
}
