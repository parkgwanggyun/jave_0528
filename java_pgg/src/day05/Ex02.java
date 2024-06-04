package day05;

public class Ex02 {

	public static void main(String[] args) {
		int []numbers = new int[] {5,2,9,1,7,3};
		
		int max = numbers[0];
		int min = numbers[0];
		for(int num : numbers) {
			if(num > max) {
				max = num;
			}if(num < min) {
				min = num;
		}		
	}System.out.println("최대값" + max);
	System.out.println("최소값" + min);
		
		

	}

}
