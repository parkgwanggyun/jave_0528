package day08;

import java.io.ObjectOutputStream.PutField;

public class MethodEx05 {

	public static void main(String[] args) {
		/* 정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는지 없는지 확인하는
		 * 코드를 작성하세요
		 * 단 메서드를 이용하여 
		 * */
		int []num = null;
		int num2 = 1;
		boolean result = Discrimination(num, num2);
		if(result) {
			System.out.println(num2 + "true");
		}else {
			System.out.println(num2 + "false");
		}
	}
	public static boolean Discrimination(int num[],int num2) {
		/**기능 : 정수 배열이 주어지면 배열에 정수 num가 있는지 없는지 알려주는 메서드
		 * 매개변수 : 주어진 정수 배열 정수 => int []num,int num2
		 * 리턴타입 :	있는지 없는지 boolean
		 * 메서드명 : Discrimination
		 * */
		//배열이 null이면 false를 리턴
		if(num == null) {
			return false;
		}
		//반복문을 이용하여 배열 전체를 탐색
		for(int tmp : num) {
			if(tmp == num2) {
				return true;
			}
		}return false;
		//배열에서 꺼낸 값과 num가 같으면 true를 리턴
		
		//반복문이 끝날때까지 못찾으면 false를 리턴
		/*for(int i = 0; i < num.length; i++) {
			if(num[i] == num2) {
				return true;
			}
		}return false;*/
	}
}
