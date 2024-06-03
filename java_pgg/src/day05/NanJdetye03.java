package day05;

import java.util.Scanner;

public class NanJdetye03 {
	    public static void main(String[] args) {
	        // 사용자로부터 양의 정수를 입력받아 해당 정수의 팩토리얼을 계산하세요
	        Scanner sc = new Scanner(System.in);
	        System.out.println("정수를 입력하세요:");
	        int num = sc.nextInt();
	        long factorial = 1;

	        if (num < 0) {
	            System.out.println("양의 정수를 입력하세요.");
	        } else {
	            for (int i = num; i >= 1; i--) {
	                factorial *= i;
	            }
	            System.out.println(num + "의 팩토리얼은 " + factorial + "입니다.");
	        }

	    }
	}
