package day05;

public class Ex03 {

	public static void main(String[] args) {
		int[] numbers = {2,4,3,5,7,8};
		int targetSum = 7;
		boolean sum = false;
		for(int i = 0; i < numbers.length; i++) {
			int num1 = numbers[i];
			for(int j = 0; j < numbers.length; j++ ) {
				int num2 = numbers[j];
				if(num1+num2 == targetSum) {
					sum = true;
					System.out.println("숫자" + num1 + "과" + num2 + "의 합은 " + targetSum);
				}
			}
			
		}
		if(!sum) {
			System.out.println("주어진 배열에서 합이 " + targetSum + "이 되는 숫자 쌍을 찾을수 없습니다.");
		}

	}

}
