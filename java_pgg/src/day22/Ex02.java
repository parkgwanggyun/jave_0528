package day22;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/* 정수로 이루어진 문자열에서 각 정수들의 합을 수하는 코드를 작성하세요
		 * 예
		 * 1 23 4 45 3 9 7 5
		 * 103
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력 :  ");
		String num = sc.nextLine();
		int sum = num1(num);
		
		System.out.println("총합 : " + sum);
	}
	/* 위에서 작성한 코드 중 일부를 메소드로 만든다고 했을 때 필요하다고 생각하는 코드
	 * 를 메소드로 만들어 보세요
	 * */
	public static int num1(String num) {
		String []list = num.split(" ");
		int sum = 0;
		for(String tmp : list) {
			sum += Integer.parseInt(tmp);
		}
		return sum;
	}
}
