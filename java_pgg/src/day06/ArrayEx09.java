package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		String [] list = {"dog" , "cat" , "java", "cup", "computer"};
		boolean str = false;
		//문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는 코드를 작성하세요
		//입력받아야해서 스캐너를 넣고
		Scanner sc = new Scanner(System.in);
		//배열에 문자를 넣고
		System.out.print("문자를 입력하세요 : ");
		String why = sc.next();
		
		for(String tmp : list) {
			if(tmp.equals(why)) {
				str = true;
				break;
			}			
			
		}
		if(str) {
			System.out.println("입력하신"+why+"맞습니다.");
		}
		
		else{
			System.out.println("입력하신" + why+ "없습니다.");
		}
	}
}


