package day07.homework;

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
		int randomnumber[] = new int[3];
		//1~9사이의 랜덤한 숫자를 만들기위한 값 부여
		int min = 1 , max = 9;
		int count = 0;
		int random;
		Scanner sc = new Scanner(System.in);
		//랜덤한수를 배열하고 중복을 걸러주기 위한 반복문 (ArrayEx02참고)
		while(count < 3) {
			random = (int)(Math.random() * (max - min + 1) + min);
			for(int i = 0; i < count; i++) {
				if(randomnumber[i] == random) {
					break;
				}if(i == count) {
					randomnumber[count] = random;
					count++;
				}
			}
		}
		//랜덤한 수 생성
		
	}

}
