package day05;

public class ArrayEx03 {

	public static void main(String[] args) {
		/* 1~10사이의 랜덤한 수 3개를 저장하고 출력하는 코드를 작성하세요
		 * 3개짜리 정수 배열을 생성
		 * 반복문을 이용하여 배열 전체를 반복
		 * 1~10사이 랜덤한 수를 생성
		 * 배열에 생성한 랜덤한 수를 저장
		 * 반복문을 이용하여 배열 전체를 반복
		 * 배열에 있는 값을 콘솔에 출력
		 */	
		int []num = new int[3];
		int min = 1, max = 10;
		for(int i = 0; i < num.length; i++) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			System.out.println("랜덤한 수" + (i+1) + "를 생성합니다 : " + random);
			
		}
		
		
	}

}
