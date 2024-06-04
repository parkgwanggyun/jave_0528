package day06;

public class Ex02 {

	public static void main(String[] args) {
		int[] numbers = {10, 5, 8, 2, 7};
		int max = numbers[0]; 
		int min	= numbers[0];		
		for(int num : numbers) {
			if(num > max) {
				max = num;
			}if(num < min) {
				min = num;
			}
		}System.out.print("최대값 : " + max + "최소값" + min);
				
	}

}
