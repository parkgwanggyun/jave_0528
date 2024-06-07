package day07.homework;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		/*숫자 야구 게임을 구현하세요.
		 * 규칙
		 * - 중복되지 않은 1~9사이의 랜덤한 수를 생성
		 * -스트라이트 : 해당 숫자가 있고 , 위치도 같은 경우
		 * -볼 : 숫자가 있지만 위치가 다른 경우
		 * -아웃 : 일치하는 숫자가 하나도 없는경우
		 * 예시
		 * (3 9 7)
		 * 입력 : 1 2 3
		 * 1B
		 * 입력 : 5 6 7
		 * 1S
		 * 입력 : 4 5 6
		 * 아웃
		 * 입력 : 3 7 9
		 * 1S2B
		 * 입력 : 3 9 7
		 * 3S
		 * 정답입니다.
		 * */
		//1~9사이의 랜덤한 수를 생성
		//생성된 랜덤한수를 배열에 입력
		//스캐너를 이용하여 콘솔에 입력
		//랜덤한 수와 콘솔에 입력된수를 비교
		//배열 저장된 위치 와 숫자가 맞으면 스트라이트
		//배열 저장된 숫자가 맞으면 볼
		//하나도 맞는게 없다면 아웃
		//배열 저장된 위치 와 숫자가 3개 다 맞추면 3스트라이크
		//3스트라이크 시 승리 출력

		//3개의 랜덤한 숫자를 저장할수있는 배열을 생성
		int list [] = new int[3];
		int count = 0;
		int min =1 , max = 9;
		int random;
		int i;
		int s =0 , b=0;
		do {
			s = 0;
			b = 0;
			while(count < 3) {
				random = (int)(Math.random() * (max - min + 1) + min);
				for(i =0; i < count; i++) {
					if(list[i] == random) {
						break;//break를 만나면 i는 count보다 작을수밖에 없음
					}
				}
				if(i == count) {
					list[count] = random;
					count++;
				}
			}
			System.out.println(Arrays.toString(list));
			Scanner sc = new Scanner(System.in);
			int [] user = new int[3];

			System.out.print("입력 : ");
			//3개입력
			for(int k = 0; k <user.length; k++) {
				user[k] = sc.nextInt();
			}		
			for(i = 0; i < user.length; i++) {
				for(int j =0; j < user.length; j++) {
					if(list[i] == user[j]) {
						if(i==j) {
							s++;
						}else {
							b++;
						}
					}
				}
				/*for(int j =0; j < user.length; j++) {
			if(list[0] == user[j]) {
				if(0==j) {
					s++;
				}else {
					b++;
				}
			}
		}
		for(int j =0; j < user.length; j++) {
			if(list[1] == user[j]) {
				if(1==j) {
					s++;
				}else {
					b++;
				}
			}
		}

		for(int j =0; j < user.length; j++) {
			if(list[2] == user[j]) {
				if(2==j) {
					s++;
				}else {
					b++;
				}
			}*/

				if(s != 0) {
					System.out.print(s + "S");
				}if (b != 0) {
					System.out.print(b + "B");
				}if(s == 0 && b ==0) {
					System.out.print("O");
				}System.out.println();

			}
		}while(s != 3);
		System.out.println("정답입니다.");

	}
}

		//반복문을 이용하여 정수 3개를 입력 받은 후 판별(다 맞출 때까지)		
		//입력 안내문구 출력
		//3개를 입력
		//결과 판별 후 출력
		//첫번째 랜덤수와 첫번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//첫번째 랜덤수와 두번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//첫번째 랜덤수와 세번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//두번째 랜덤수와 첫번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//두번째 랜덤수와 두번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//두번째 랜덤수와 세번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//세번째 랜덤수와 첫번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//세번째 랜덤수와 두번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					
		//세번째 랜덤수와 세번째 입력값이 같으면 스트라이크 아니면 볼로 판별
					

