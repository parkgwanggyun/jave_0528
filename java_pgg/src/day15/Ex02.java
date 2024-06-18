package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/*다음 기능을 가진 프로그램을 작성하세요
		 * 메뉴
		 * 1. 번호추가
		 * 2. 번호 삭제
		 * 3. 번호 조회 (sysout(list))로 대체
		 * 4. 종료*/
		Scanner sc = new Scanner(System.in);
		ArrayList<String>list = new ArrayList<String>();
		int mune;
		do {
			System.out.println("메뉴\n" + "1. 번호추가\n"+
					"2. 번호삭제\n"+
					"3. 번호조회\n"+
					"4. 종료\n");
			System.out.print("메뉴 선택 : ");
			mune = sc.nextInt();
			if(mune == 1) {
				System.out.println("번호추가 : ");			
				String num1 = sc.next();
				if(list.contains(num1)) {
					System.out.println("이미 등록된 번호입니다.");
				}else {
					System.out.println("번호를 등록했습니다.");
					list.add(num1);
				}
			}if(mune == 2) {
				System.out.println("번호삭제 : ");
				if(list.remove(sc.next())) {
					System.out.println("번호를 삭제했습니다.");
				}else {
					System.out.println("일치하는 번호가 없습니다.");
				}
			}if(mune == 3) {
				System.out.println(list);
			}if(mune == 4) {
				System.out.println("종료합니다.");
			}
		}while(mune != 4);
	}

}
