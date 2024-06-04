package day06;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		/* UpDown 게임에 다음 기능을 추가하세요.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * (랜덤이 35라고 가정)
		 * 정수 입력 : 50
		 *Down!
		 *정수 입력 : 30
		 *Up
		 *정수 입력 : 35
		 *정답입니다.
		 *맞힌 횟수는 3회입니다.
		 *기록이 등록됩니다.
		 * 메뉴
		 * 1. 플레이
		 * 2. 기록확인
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 기록확인
		 * 1. 3회
		 * 메뉴 선택 : 3
		 * 프로그램을 종료합니다.
		 */

		//메뉴 제작
		//선택한 메뉴가 3이 아닐때 실행되는 반복문을 작성
			//메뉴 출력
			//Scanner를 이용하여 메뉴를 입력
			//선택한 메뉴에 따른 기능 실행
			//선택한 메뉴가 1이면 게임 플레이하는 코드 작성
			//선택한 메뉴가 2이면 기록 확인하는 코드 작성
			//선택한 메뉴가 3이면 프로그램 종료 문구 출력
			//아니면 잘못된 메뉴 문구 출력하는 코드 작성
		Scanner sc = new Scanner(System.in);
		int min = 1, max = 100;
		int random = (int)(Math.random() * (max - min + 1) + min);
		int num1;
		int munu;
		int sco [] = new int[100];
		int playerCount = 0;
		do {
			System.out.println("1.플레이");
			System.out.println("2.기록확인");
			System.out.println("3.종료");
			System.out.print("메뉴 선택 : ");
			munu = sc.nextInt();
			
			if(munu == 1) {
				System.out.println("게임을 시작합니다.");
				System.out.println("랜덤한 수가 지정되었습니다.");
				do {
					System.out.println("숫자를 입력해주세요");
					num1 = sc.nextInt();
					sco[playerCount++] = num1;
					if (num1 > random) { //num1 = 입력받은 수가 랜덤 숫자보다 작을때 다운나오게하기
						System.out.println("Down");
					}else if(num1 < random) { //num1 = 입력받은 수가 랜덤한 숫자보다 클때 업나게하기
						System.out.println("Up");
					}else if(num1 != random) {
						for(int i = 0; i < sco.length; i++) {
							sco[i] = num1;
						}
					}else { // 위에 사항 외 의 정답이 나왔을때 정답문구 나오게하기
						System.out.println("정답입니다" + random + "입니다" );
					}// 정답이 나올때 까지 반복하기 위해 num1과 랜덤이 틀릴때 반복하게 만들기
				}while (num1 != random);
			}else if(munu == 2) {
				System.out.println("기록을 확인합니다.");
				Arrays.sort(sco, 0 , playerCount);
				System.out.println("순위 : ");
				for(int i = 0; i < playerCount; i++) {
					System.out.println("순위" + (i+1) + ": " + sco[i] + "번 시도");
				}
				
			}else if(munu > 4 && munu <= 0){
				System.out.println("허용된 숫자만 입력해주세요");
			}
		}while (munu != 3);
	}
}



