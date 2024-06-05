package day07;

import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {
		/* 다음 메뉴를 출력하고 메뉴를 출력하면 안내문구를 출력하는 코드를 작성하세요
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴선택 : 1
		 * ---------
		 * 단어 입력 (종료: -1) : abc
		 * 단어를 추가했습니다./ 단어를 추가하지 못했습니다.
		 * 단어 입력 (종료: -1) : -1
		 * 메뉴로 돌아갑니다.
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴선택 : 2
		 * --------
		 * 단어 검색 (종료 : -1) : abc
		 * 단어를 확인했습니다 / 없는 단어입니다.
		 * 단어 검색 (종료: -1) : abc
		 * 메뉴로 돌아갑니다.
		 * ---------
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴선택 : 0
		 * ----------
		 * 잘못된 메뉴입니다.
		 * */
		Scanner sc = new Scanner(System.in);
		String munu;
		String  word[] = new String[10];
		String tmp;//추가/검색 기능에서 입력할 단어를 저장하는변수
		int count = 0;//추가된 단어의 개수
		boolean list = false;//검색할 때 있다 없다를 확인할 변수
		do {
			System.out.println("메뉴");
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			munu = sc.next();
			if(munu.equals("1")) {
				while(true) {
					System.out.print("단어 추가 (종료 : -1 ) : ");
					tmp = sc.next();
					if(tmp.equals("-1")) {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}if(count == word.length) {
						System.out.println("공간이 부족하여 단어를 더이상 추가 할 수없습니다.");
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}else {
						word[count] = tmp;
						count++;
						System.out.println("단어를 추가합니다.");
					}
				}

			}else if(munu.equals("2")){ 
				while(!list) {
					System.out.print("단어를 검색하세요 (종료 : -1) : ");
					String Q = sc.next();
					if(Q.equals("-1")) {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}for(int i = 0; i<count; i++) {
						String N = word[i];
						if(Q.equals(N)) {
							list = true;
							break;
						}
					}if(list) {
						System.out.println("해당 단어를 찾았습니다.");
					}else {
						System.out.println("해당 단어를 찾지못했습니다.");
					}
				}

			}else if(munu.equals("3")){
				System.out.println("종료합니다.");
			}else {
				System.out.println("잘못된 메뉴입니다.");
			}
		}while(!munu.equals("3")); 

	}

}
