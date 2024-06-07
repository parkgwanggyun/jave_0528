package day08.homework;

import java.util.Scanner;

public class MethodEx01 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("배열의 크기를 입력하세요: ");
	        int n = sc.nextInt();
	        int[] arr = Arrangement(n);
	        System.out.println("생성된 배열의 크기: " + arr.length);
	    }

	    /**
	     * 기능 : 정수 n을 입력받아 입력받은 n만큼 배열크기를 생성
	     * 매개변수 : int n
	     * 리턴타입 :	int
	     * 메서드명 :	Arrangement
	     *
	     */
	    public static int[] Arrangement(int n) {
	        int[] arr = new int[n];
	        return arr;
	    }
	}
