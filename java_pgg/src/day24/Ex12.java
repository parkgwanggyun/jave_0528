package day24;

public class Ex12 {

	public static void main(String[] args) {
		/* 1+2의 결과를 출력하기 위해 다음과 같이 작성했다.
		 * 원인 : sum메소드는 리턴타입이 없기 때문에 정수에 저장할 수 없음
		 * 해결방법 :정수에 저장하지 않거나 sum메소드에 리턴타입이 정수가 되도록 수정
		 * */
		//int res = sum(3,5);
		sum(3,5);
		
	}
	public static void sum(int num1,int num2) {
		System.out.println(num1+num2);
	}
}
