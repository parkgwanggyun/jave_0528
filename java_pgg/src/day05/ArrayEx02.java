package day05;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		/*학생 3명의 성적을 저장한는 배열을 생성하고,
		 * 학생 3명의 성적을 콘솔을 통해 입력받고.
		 * 출력하는 코드를 작성하세요
		 * 입력받은 성적의 평균을 구하는 코드를 작성하세요
		 */
		Scanner sc = new Scanner(System.in);
		int [] sco = new int[3];
		for(int i=0 ; i<3; i++) {
			System.out.print("학생"+(i+1) + "의 성적 : ");
			//총점을 구하기 위해 학생 성적을 입력할 때마다 누적을 시킴
			sco[i] = sc.nextInt();
			
		}
		System.out.println("입력된 성적:");
		for(int i = 0; i< 3; i++) {
			System.out.println("학생" + (i+1)+"의 성적 : " + sco[i]);
		}
		int sum = 0;
		for(int i =0 ; i<3;i++) {
			sum += sco[i];
			
			
		}double avg = (double)sum /3;
		System.out.println("힉생 3명의 평균 : " + avg);
		

	}

}
