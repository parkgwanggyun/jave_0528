package day07;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/* 3명의 학생의 국어, 영어 , 수학 , 성적을 입력받고
		 * 각 학생의 평균을 구하는 코드를 작성하세요.
		 * 학생1의 성적을 입력하세요 (국어, 영어,수학 순) : 100 90 80
		 * 학생2의 성적을 입력하세요 (국어, 영어,수학 순) : 100 100 100
		 * 학생3의 성적을 입력하세요 (국어, 영어,수학 순) : 81 80 80
		 * 학생1의 평균 : 90
		 * 학생2의 평균 : 100
		 * 학생3의 평균 : 80.33333
		 * */
		Scanner sc = new Scanner(System.in);
		int[] kor, eng, math;
		int studentCount = 3;
		kor = new int[studentCount];
		eng = new int[studentCount];
		math = new int[studentCount];
		double average = 0;
		int sum = 0;
		// 반복문을 이용하여 학생 성적을 입력
		// i는 0부터 3보다 작을 때까지 1씩 증가
		for (int i = 0; i < studentCount; i++) {
		    // 학생(i+1)의 성적을 입력 문구를 출력
		    System.out.print("학생" + (i + 1) + "의 성적을 입력하세요 (국어, 영어, 수학 순)");
		    kor[i] = sc.nextInt();
		    eng[i] = sc.nextInt();
		    math[i] = sc.nextInt();
		}

		// 각 학생의 평균을 구함
		for (int i = 0; i < studentCount; i++) {
		    sum = kor[i] + eng[i] + math[i];
		    average = sum / (double) studentCount;
		    System.out.println("학생" + (i + 1) + "의 평균은 " + average + "입니다.");
		}
		sum = 0;
		for (int i = 0; i < kor.length; i++) {
		    sum = sum + kor[i];
		}
		double korAverage = sum / (double) kor.length;
		System.out.println("국어 평균은 " + korAverage + "입니다.");

		sum = 0;
		for (int i = 0; i < eng.length; i++) {
		    sum = sum + eng[i];
		}
		double engAverage = sum / (double) eng.length;
		System.out.println("영어 평균은 " + engAverage + "입니다.");

		sum = 0;
		for (int i = 0; i < math.length; i++) {
		    sum = sum + math[i];
		}
		double mathAverage = sum / (double) math.length;
		System.out.println("수학 평균은 " + mathAverage + "입니다.");
}
}