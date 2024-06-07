package day08.homework;

public class MethodEx02 {
	/*1~9사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는 코드를 작성하세요
	 * 메서드 이용
	 * */
	public static void main(String[] args) {
		int []arr = new int[3];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = random();
		}
		for(int num : arr) {
			System.out.println(num);
		}
		
	}
	/**기능 : 1~9사이의 랜덤한 수를 만드는 기능
	 * 매개변수 : 
	 * 리턴타입 : int
	 * 메서드명 : random
	 * */
	public static int random() {
		int min =1 , max = 9;		
		int random = (int)(Math.random() * (max - min + 1) + min);
			
		return random;
		}
	}

