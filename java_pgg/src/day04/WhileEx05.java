package day04;

public class WhileEx05 {

	public static void main(String[] args) {
		/* 1부터 10까지 짝수 합을 구하는 코드를 작성하세요
		 * 
		 * 		sum
		 * sum		0
		 * i=1 sum	0+2
		 * i=2 sum 	0+2+4
		 * i=3 sum 	0+2+4+6
		 * ...
		 * i=10 sum 0+2+4+6+8+10			
		 * 반복횟수 : i는 0부터 *2씩 증가
		 * 규칙성 : sum = sum + i*2
		 * 반복문 종료 후 : sum을 출력
		 */
		int sum = 0;
		int num = 2;
		while(num <= 10) {
			
			sum+= num;
			num += 2; 
			System.out.println(sum);} 
		
	}

}
