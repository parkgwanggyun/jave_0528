package day07;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/* 입력한 문자열이 배열에 있는지 없는지 확인하는 코드를 작성하세요
		 * 단어 입력 (종료 : -1 ): apple
		 *  
		 * */
		String [] list = new String[] {"cat" , "dog" , "banana"};
		Scanner sc = new Scanner(System.in);
		boolean word = false;
		while (!word) {
			System.out.println("단어를 입력하세요 (종료 : -1) : ");
			String Q = sc.next();
			if(Q.equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}
			for(String N : list) {
				if(N.equals(Q)) {
					word = true;
					break;
				}
			}if(word) {
				System.out.println("해당 단어는 배열에 있습니다");
			}else {
				System.out.println("해당 단어는 배열에 없습니다.");
			}
		}
		
	}

}
