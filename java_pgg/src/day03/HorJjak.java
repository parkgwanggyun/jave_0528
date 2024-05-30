package day03;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HorJjak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int account = 0; //시작하는 돈 액수
		
		System.out.println("프로그램 시작");
		
		//사용자에게 시작 원금을 입력받습니다.
		boolean isString = true; //사용자가 돈입력시 정수가 아닌 문자 열을 입력하는지 확인할 코드
		while(isString) {
				try {
						System.out.println("*시작 원금: ");
						account = sc.nextInt();
						sc.nextLine(); //버퍼에 남아있는 엔터제거
						isString = false; //nextLine()에서 예외가 발생되지않으면 정수이므로
				} catch(InputMismatchException e) {
						sc.nextLine(); //예외발생시에도 엔터 제거. 안할시 무한루프
						System.out.println("돈을 정수로 입력하세요.");
				}
		}
		int money = account; //이기고 짐에 따라 변하게 될 금액
		
		String choice = null; //홀인지 짝인지 선택
		int bet = 0; //베팅할 금액
		int num = 0; //홀(1) 이나 짝(2)을 저장할 변수
		String choS = null; //선택한 홀, 짝을 한글로 저장
		String result = null; //랜덤 (홀,짝)의 결과
		
		//무한반복 : 1.메뉴 선택시 0번 입력으로 종료
		//         2.money가 0원 => 재도전(y/n)? y 이외의 문자 입력으로 종료
		while (true) {
			System.out.println("*현황 : " + money + "원");
			
			//메뉴 출력
			System.out.println("1) 홀 2) 짝 입력 (0:프로그램종료): ");
			
			//1(홀) , 2(짝) , 0(프로그램 종료)번 중 입력 받음
			choice = sc.nextLine();
			
			// 1,2,0번에 맞게 분기
			switch (choice) {
			case "1": choS = "홀";break;
			case "2": choS = "짝";break;
			case "0": 
				System.out.println("프로그램 종료");
				return;
			default:
					System.out.println("다시 입력하세요.");
					continue; //1,2,0 외의 다른 문자를 입력했을때 메뉴로 돌아가기
			}
			//베팅 : 몇 원를 걸것인가?
			//이경우는 위와 다르게 NumberFormatException발생
			isString = true;
			while(isString) {
					try {
							System.out.println("*bet: ");
							//따로 엔터를 버퍼에서 제거하는 것이 번거러울 경우
							//아래와 같은 방법도 있습니다.
							bet = Integer.parseInt(sc.nextLine());
							isString = false;
					}catch (NumberFormatException e) {
							System.out.println("돈을 정수로 입력하세요");
					}
			}
			
			//가지고 있는 돈보다 많이 걸 경우 다시 메뉴로
			if(money < bet) {
					System.out.println("돈이 부족하다.");
					continue;
			}
			//가지고 있는 돈에서 베팅한 돈만큼 차감
			money -= bet;
			
			//random() 메서드를 이용해서 홀(1) 이나 짝(2) 가져와 num에 정수 저장
			num = (int)(Math.random()*2) + 1;
			//랜덤 결과를 한글로 저장
			result = (num == 1) ? "홀" : "짝";
			//홀짝 결과 출력
			System.out.println("*결과: " + result);
			//본인이 베팅한 것과 결과가 맞으면
			if(choS.equals(result)) {
				System.out.println("*success");
				//베팅한 돈의 2배를 현재 가지고 있는 돈에 더해줌
				money += bet*2;
			}
			//결과가 다르면 그대로 베팅한 돈을 잃는다.
			else {
				System.out.println("*Fail");
			}
			
			//가지고 있던 돈이 0이 되면
			if(money ==0) {
				System.out.println("game set");
				//재도전 여부를 물어보고
				System.out.println("재도전 (Y/N): ");
				String str = sc.nextLine();
				//y를 입력했다면 초기 정했던 시작 돈으로 게임을 재시작
				if(str.equals("y")) {
						money = account;
						continue;
				}
			}
		}
		}
	}

