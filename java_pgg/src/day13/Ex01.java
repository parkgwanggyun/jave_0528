package day13;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/*다음과 가은 책 제목들이 있을 때 원하는 단어를 검색해서 해당 언어가 있는 책을 출력하는 코드를 작성하세요.
		 * 일치하는 책이 없는 경우 일치하는 책이 없습니다라고 출력.
		 * */
	       String[] books = {"자바의 정석", "혼자하는 자바", "혼자하는 C", "수학의 정석", "누구나 하는 C"};
	        Scanner sc = new Scanner(System.in);
	        System.out.println("책 검색 : ");
	        String search = sc.nextLine();
	        boolean distinction = false;

	        if (search.equals("")) {
	            System.out.println("잘못입력하셨습니다");
	        } else {
	            System.out.print("일치하는 책: ");
	            for (String title : books) {
	                if (title.contains(search)) {
	                    System.out.print(title + ", ");
	                    distinction = true;
	                }
	            }
	            if (!distinction) {
	                System.out.println("일치하는 책이 없습니다.");
	            }
	        }
	    }
	}