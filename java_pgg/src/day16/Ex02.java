package day16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex02 {

	/*
	 * Up Down 게임에 기록을 저장하는 기능을 추가 
	 * - 최대 5등까지 저장하며, 먼저 등록된 순으로 저장 
	 * - 아이디를 입력받아 저장 메뉴
	 * 1. 플레이 2. 기록확인 3. 종료 
	 * 메뉴 선택 :
	 */
	static List<String> records = new ArrayList<>(); // 사용자 기록을 저장할 리스트
	static Scanner sc = new Scanner(System.in); // 입력을 받기 위한 Scanner 객체
	static int min = 1, max = 100; // 게임의 숫자 범위
	static int random = ranDom(min, max); // 랜덤으로 생성된 숫자
	static int num = 0; // 사용자가 입력한 숫자
	static int menu = 0; // 메뉴 선택 변수

	public static void main(String[] args) {
		do {
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt(); // 사용자에게 메뉴 선택 받기

			switch (menu) {
			case 1:
				playGame();
				break;
			case 2:
				displayRecords();
				break;
			case 3:
				System.out.println("게임을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 선택해 주세요.");
				break;
			}
		} while (menu != 3);
	}

	// 게임 플레이 메서드
	public static void playGame() {
		int count = 0; // 시도 횟수 카운트
		while (num != random) {
			System.out.println("숫자를 입력하세요: ");
			num = sc.nextInt();
			printResult(random, num);
			count++;
		}

		// 정답을 맞췄을 때
		System.out.println("정답입니다");

		// 사용자 이름 입력 받기
		System.out.print("사용자 이름을 입력하세요: ");
		String userId = sc.next();

		// 기록 저장
		String record = userId + ": " + count + "회";
		saveRecord(record);
		
	}

	// Up 또는 Down 출력 메서드
	public static void printResult(int random, int num) {
		if (num < random) {
			System.out.println("Up");
		} else if (num > random) {
			System.out.println("Down");
		}
	}

	// 기록 저장 메서드
	public static void saveRecord(String record) {
		records.add(record); // 리스트에 기록 추가
		System.out.println("기록이 저장되었습니다.");
	}

	// 기록 확인 메서드
	public static void displayRecords() {
		System.out.println("최고 기록");
		if (records.isEmpty()) {
			System.out.println("기록이 없습니다.");
		} else {
			for (String record : records) {
				System.out.println(record);
			}
		}
	}

	// 랜덤 숫자 생성 메서드
	public static int ranDom(int min, int max) {
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
