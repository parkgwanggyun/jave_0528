package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		/* 문자 입력 : up
		 * up 은 없습니다.
		 * 문자 입력
		 * */
		String [] list = {"dog" , "cat" , "java", "cup", "computer"};
		boolean str = false;
		//문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는 코드를 작성하세요
		//입력받아야해서 스캐너를 넣고
		Scanner sc = new Scanner(System.in);
		//배열에 문자를 넣고
		while(!str) {
		System.out.print("문자를 입력하세요 : ");
		String Q = sc.next();
		
		for(String N : list) {
			if(N.equals(Q)) {
				str = true;
				break;
			}			
			
		}
		if(str) {
			System.out.println("입력하신 "+Q+" 는"+"있습니다.");
		}
		
		else{
			System.out.println("입력하신 "+Q+" 는"+ "없습니다.");
		}
		}
	}
}


