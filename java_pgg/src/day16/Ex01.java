package day16;

import java.util.HashSet;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* Up Down 게임 예제를 구현하세요
		 * 랜덤으로 숫자를 만들고(1~100) 만들어진 숫자를 맞추는 게임
		 * 랜덤 : 33
		 * 입력 : 50
		 * Down
		 * 입력 : 25
		 * Up
		 * 입력 : 33
		 * 정답
		 * */
		HashSet<Integer> us = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		int min = 1,max = 100;
		int random = random(min,max);
		int num = 0;
		int count = 0;
		do {
			System.out.println("숫자를 입력하세요");
			num = sc.nextInt();
			printResult(random,num);
			/*if(num < random) {
				System.out.println("Up");
				count++;
			}if(num > random) {
				System.out.println("Down");
				count++;
			}if(num == random) {
				System.out.println("정답");
			}*/
		}while(num != random);
	}
	public static int random(int min, int max) {
	    if(min > max) {
	        int temp = min;
	        min = max;
	        max = temp;
	    }
	    int random = (int)(Math.random() * (max - min + 1) + min);
	    return random;
	}
	public static void printResult(int random, int num) {
		if(num < random) {
			System.out.println("Up");
		
		}else if(num > random) {
			System.out.println("Down");
		}else {
			System.out.println("정답");
		}		
	}
}
