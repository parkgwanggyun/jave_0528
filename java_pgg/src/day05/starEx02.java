package day05;

public class starEx02 {

	public static void main(String[] args) {
		/* 을 하나씩출력해서 다음과 같이 출력되도록 중첩 반복문을 이용하여 작성하세요.
		 * *		i=1
		 * **		i=2
		 * ***		i=3
		 * ****		i=4
		 * *****	i=5
		 * 반복횟수 :i는 1부터 5까지 1씩 증가
		 * 규칙성 :*****을 출력
		 * => 반복횟수 : J는 1부터 5까지 1씩증가
		 * 규칙성 : *을 출력 (한줄로)
		 * 
		 */
		int num1 = 5;
		
		for(int i = 1; i < num1; i++) {
			for(int k=0; k < num1-i; k++) {
				System.out.print("ㅁ");
			}
			for(int j=0; j < 2*i -1; j++) {
				System.out.print("★");
			}
			System.out.println();
			
			
		}
	}

}
