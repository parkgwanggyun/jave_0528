package day05;

public class AlphabetEx01 {

	public static void main(String[] args) {
		/*a
		 * ab
		 * abc
		 * abcd
		 * ...
		 * abcdefg...xyz
		 * 반복횟수 : i는 0부터 26보다 작을 때 까지 1 씩 증
		 * 규칙성 : a부터 'a'+i까지 알파벳을 출력
		 * =>반복횟수 : j는 0부터 i까지 1씩증가
		 * 	규칙성 : 'a'+'j'를 출력
		 * 	반복문 종료 후 : 엔터 출력
		 * 반복문 종료 후
		 */
			for(int i = 0; i < 26; i++) {
				char ch = 'A';
				for(int k = 1; k > i; k++) {
				}for(int j = 0; j < i+1; j++) {
					System.out.print(ch++);
				}System.out.println();
			}
			/* 반복횟수 : ch1은 'a'부터 'z'까지 1씩 증가
			 * 규칙성 : ch2는 'a'부터 ch1까지 출력
			 * =>반복횟수 : ch2는 'a'부터 ch1까지 1씩 증가
			 * 	규칙성 : ch2를 출력
			 * 	반복문 종료 후 : 엔터를 출력
			 */
			char ch1 ,ch2;
			for(ch1 = 'a'; ch1 <= 'z'; ch1++) {
				for(ch2 = 'a'; ch2 <= ch1; ch2++) {
					System.out.print(ch2);
				}
				System.out.println();
			}
		}

	}
