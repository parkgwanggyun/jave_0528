package day04;

public class WhileEx08_01 {

	public static void main(String[] args) {
		
		int gcd = 1;
		int i = 1;
		int num1 = 8, num2 = 12;
		while(i<=num1) {
			if(num1 % i == 0 && num2 %i ==0) {
				gcd = i;
			}
			if(num1 % i == 0) {
				if(num2 % i ==0) {
					gcd= i;
				}
				i++;
			}
			System.out.println(num1 + "과" + num2 + "의 최대 공약수 : " + gcd);
		}

	}

}
