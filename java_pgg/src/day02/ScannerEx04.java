package day02;

import java.util.Scanner;

public class ScannerEx04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("연산을 할 첫번째 숫자를 입력하세요 :");
		double num1 = Double.parseDouble(sc.nextLine());
		
		System.out.println("연산을 할 두번째 숫자를 입력하세요 :");
		double num2 = Double.parseDouble(sc.nextLine());
		System.out.println("어떤 연산을 수행하시겠습니까?" + ("+(더하기), - (빼기), *(곱하기), / (나누기), %(나머지)"));
		String user = sc.nextLine();
		
		String result =
				user.equals("+")? ""+(num1+num2) :
				(user.equals("-")? ""+(num1-num2)	:
					(user.equals("/")? ""+(Math.round((num1/num2)*10)/10.0):
						(user.equals("*")? ""+(Math.round((num1*num2)*10)/10.0) :
							(user.equals("%")? ""+(num1%num2):"") )));
							System.out.println(result);
	}

}
