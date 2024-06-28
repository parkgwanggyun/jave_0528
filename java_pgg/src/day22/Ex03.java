package day22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex03 {

	public static void main(String[] args) {
		/* 리스트에 숫자들을 저장하고,저장된 숫자들을 정렬하는 코드를 작성하세요.
		 * */
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		
		while(true) {
			System.out.println("숫자를 입력 : ");
			int num = sc.nextInt();
			if(num == 0) {
				break;
			}
			list.add(num);
		}

		Collections.sort(list);
		System.out.println("정렬된 숫자들 : ");
		for(Integer num : list) {
			System.out.println(num + " ");
		}
		/* 정렬된 숫자들을 역순으로 정렬하는 코드를 작성하세요
		 * */
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("역정렬된 숫자들 : ");
		for(Integer num : list) {
			System.out.println(num + " ");
		}
	}

}
