package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/*5개의 정수를 입력을 받아 배열에 저장하고, 역순으로 출력하는 코드를 작성하세요
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int [] sco = new int[5];
		for(int i=0 ; i<5; i++) {
			System.out.print("학생"+(i+1) + "의 성적 : ");
			//총점을 구하기 위해 학생 성적을 입력할 때마다 누적을 시킴
			sco[i] = sc.nextInt();
	}System.out.println("입력된 성적:");
	for(int i = 4; i > 0; i--) {
		System.out.println("학생" + (i+1)+"의 성적 : " + sco[i]);

}
}
}