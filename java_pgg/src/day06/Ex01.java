package day06;

public class Ex01 {

	public static void main(String[] args) {
		int[] numbers = {2, 4, 3, 5, 7, 8};
		int targetSum = 10;
		
		boolean isFail = true;
		for(int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			for(int j = i+1; j < numbers.length; j++) {
				int num1 = numbers[j];
				if(num+num1 == targetSum) {
					isFail = false;
					System.out.println("숫자" + num + "과" + num1 + "의 합은 " + targetSum);
				}
			}
				
		}
		if(isFail) {
			System.out.println("Fail");
		}
	}

}
