package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		String [] list = {"dog" , "cat" , "java", "cup", "computer"};
		boolean str = true;
		//문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는 코드를 작성하세요
		//입력받아야해서 스캐너를 넣고
		Scanner sc = new Scanner(System.in);
		//배열에 문자를 넣고
		for(int i = 0; i < list.length; i++) {
			

		}for(String tmp : list) {
			System.out.print("문자를 입력하세요 : ");
			tmp = sc.next();
			if(tmp.equals(list.length)) {
				str = false;
				break;
			}
			if(str = true) {
				System.out.println("아닙니다.");
			}if (str = false){
				System.out.println("있습니다.");
			}
		}
	}
}


