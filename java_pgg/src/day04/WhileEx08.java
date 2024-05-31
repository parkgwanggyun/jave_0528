package day04;

public class WhileEx08 {

	public static void main(String[] args) {
		/* 두 정수 8과 12의 최대 공약수를 구하는 코드를 작성하세요.
		 * 약수 : 나누어서 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 최대 공약수 : 공약수 중 가장 큰 공약수
		 * 8 : 1 2 4 8
		 * 12: 1 2 3 4 6 12
		 * 8과 12의 공약수 1 2 4
		 * 8과 12의 최대 공약수 4
		 * 반복횟수 : 
		 * 규칙성 :
		 * 반복문 종료 후
		 */
		int num = 8;
		int num2 = 12;
		int i = 1;
		int rus = 0;
		while(i< num && i < num2) {
			if(num%i == 0 && num2%i == 0) {
				rus=i;
			}
			i++;
		}
		System.out.println("최대 공약수 : " + rus);

	}

}
