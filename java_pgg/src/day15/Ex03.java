package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Ex03 {

	public static void main(String[] args) {
		/* 1~10사이의 랜덤한 수 6개를 중복되지 생성해서 저장하고 출력하는 코드를 작성하세요*/
		HashSet<Integer> set = new HashSet<Integer>();
		int min = 1, max = 100;
		
		while(set.size() != 6) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(set.add(random));
		}System.out.println(set);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		Collections.shuffle(list);
		System.out.println(list);
	}

}

/* 랜덤메서드
 * Random random = new Random();
 * int r = random.nextInt(min,max+1);
 */
