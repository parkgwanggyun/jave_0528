package day06;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		/*4과목의 성적을 입력받아 배열에 저장하고, 과락(40점 미만)이 없고 
		 * 평균이 60점이 넘으면 pass,아니면 Fail라고 출력하세요.
		 * */
		Scanner sc = new Scanner(System.in);
		//4개짜리 배열 생성
		int sco[] = new int[4];
		int sum = 0;	
		//성적 4개를 입력
		for(int i =0; i < sco.length; i++ ) {
			System.out.println("학생" + (i+1) + "번째 과목성적을 입력하세요");
			sco[i] = sc.nextInt();
			sum += sco[i];
			/*입력받은 성적의 총합을 계산
			 *반복횟수 : 향상된 for문을 이용하여 전체탐색
			 *실행문 : 배열에서 가져온 값을 sum에 누적
			 *반복 종료 후 : 없음
			 **/
		//총합을 이용하여 평균을 계산
		}double ave = (double)sum/sco.length;
		/*과락여부를 확인하여 변수에 저장
		 *반복횟수 : 향상된 for문을 이용하여 전체 탐색
		 *실행문 : 배열에서 가져온 값이 40보다 작으면 과락 변수를 true로 변경
		 *반복 종료 후 : 없음*/
		boolean pass = true;
		for(int sco1 : sco) {
			if(sco1 < 40) {
				pass = false;
				break;//break가 없어도 결과는 같지만,조금이라도 덜 비교하기 위해 쓰는 게 좋음
			}
		}
		//과락이 아니고 평균이 60이상이면 pass
		if( !pass && ave >= 60) {
			System.out.println("pass");
		}
		//아니면 Fail;
		else {
			System.out.println("Fail");
		}
		System.out.println(pass && ave > 60 ? "pass" : "Fail");
		}
	}
