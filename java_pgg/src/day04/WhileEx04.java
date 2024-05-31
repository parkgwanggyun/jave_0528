package day04;

public class WhileEx04 {

	public static void main(String[] args) {
		/* 1부터 10까지 합을 구하는 코드를 작성하세요
		 * 
		 * 		sum
		 * sum		0
		 * i=1 sum	0+1
		 * i=2 sum 	0+1+2
		 * i=3 sum 	0+1+2+3
		 * ...
		 * i=10 sum 0+1+2+3+4+5+6+7+8+9+10			
		 * 반복횟수 : 
		 * 규칙성 : 1+1=2+2=4=3
		 * 반복문 종료 후 : sum을 출력
		 */
		int sum = 0;
		int num = 1;
		while(num <= 10) {
			sum= sum+num;
			num++; 
			System.out.println(sum);}
		 
		}

	}


