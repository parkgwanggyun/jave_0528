package day04;

public class NestedForEx02 {

	public static void main(String[] args) {
		/*num가 소수인지 아닌지 판별하는 코드를 이용하여 100이하의 소수를 출력하는 코드를 작성하세요
		 * 
		 * */
		
		for (int i=2; i <100; i++) {
			int c=0;
			for(int j=1; j<=i; j++)
				if (i%j==0)
					c = c+1;
			
		}
		if (c==2); {
			
		}
	}
}

		
