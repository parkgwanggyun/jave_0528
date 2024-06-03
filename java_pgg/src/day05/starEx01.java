package day05;

public class starEx01 {

	public static void main(String[] args) {
		/* 을 하나씩출력해서 다음과 같이 출력되도록 중첩 반복문을 이용하여 작성하세요.
		 * *****
		 * *****
		 * *****
		 * *****
		 * *****
		 * 반복횟수 :i는 1부터 5까지 1씩 증가
		 * 규칙성 :*****을 출력
		 * => 반복횟수 : J는 1부터 5까지 1씩증가
		 * 규칙성 : *을 출력 (한줄로)
		 * 
		 */
		int num1 = 5;
		
		for(int num2=0; num2 <num1; num2++) {
			for(int num3=0; num3 < 5; num3++) {
				System.out.print("*");
			}System.out.println();
			
		}
	}

}
