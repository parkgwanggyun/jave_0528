package day04;

public class NestedForEx02_1 {

	public static void main(String[] args) {
		int num =3;
		int i ,count = 0;
		
		for(num =2; num <=100; num++) {
			for(i=1, count = 0; i<=num; i++) {
				if(num%i==0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(num + " ");
			}
		}

	}

}
