package day15;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Ex04 {
	
	public static void main(String[] args) {
		/* 1~45사이의 중복되지 않은 6개의 번호와 1개의 보너스 번호를 랜덤으로 생성하고
		 * 사용자가 번호를 6개를 입력해서 몇등인지 맞추는 로또 예제
		 * 1등 : 번호 6개 일치
		 * 2등 : 번호 5개와 보너스 번호 일치
		 * 3등 : 번호 5개 일치
		 * 4등 : 번호 4개 일치
		 * 5등 : 번호 3개 일치
		 * 나머지 꽝
		 */
		//로또 번호와 보너스 번호를 생성
		HashSet<Integer> set = new HashSet<Integer>();
		int min = 1, max = 45;
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		while(set.size() != 6) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			set.add(random);
		}
		int bonus;
		do {
			bonus = (int)(Math.random() * (max - min + 1) + min);
		}while(set.contains(bonus));
		System.out.println(set + " : " + bonus);
		//사용자가 6개의 번호를 입력
		HashSet<Integer> user = new HashSet<Integer>();
		System.out.println("번호 입력(1~45사이의 중복되지 않은 수 6개) : ");
		while(user.size() < 6) {
			user.add(sc.nextInt());
		}
		//입력한 번호를 이용하여 당첨 등수를 출력
		int count = 0;
		for(Integer num : user) {
			if(set.contains(num)) {
				count++;
			}
		}
		switch (count) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			if(user.contains(bonus)) {
				System.out.println("2등");
			}else
				System.out.println("3등");
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:		
			System.out.println("5등");
			break;
		default:
			System.out.println("꽝");
		}
	}

}