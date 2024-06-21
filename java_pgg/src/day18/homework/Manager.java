package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class Manager implements Program {

	private List<Calendar> list = new ArrayList<Calendar>();
	private Scanner sc = new Scanner(System.in);

	private final int ADDITION = 1;
	private final int RETOUCH = 2;
	private final int DELETE = 3;
	private final int CHECK = 4;
	private final int EXIT = 5;

	@Override
	public void printMenu() {
		System.out.println("---메뉴---");
		System.out.println("1. 일정 추가 " + "\n2. 일정 수정" + "\n3. 일정 삭제" + "\n4. 일정 확인" + "\n5. 프로그램종료" + "\n메뉴 선택: ");
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case ADDITION:
			addition();
			break;
		case RETOUCH:
			retouch();
			break;
		case DELETE:
			delete();
			break;
		case CHECK:
			check();
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. 올바른 메뉴를 선택하세요.");
		}

	}

	private void check() {
		/* 
		 * -------------------
		 * 날짜(yyyy-MM-dd) : 2024-06-21
		 * -------------------
		 * 2024-06-21 일정 리스트
		 * -------------------
		 * 1.2024 -06 -21 17:50 퇴근 없음
		 * -------------------
		 * 메뉴로 가시려면 엔터를 입력하세요.
		 *  -------------------
		*/
	}

	public void run() {
		String fileName = "src/day18/homework/homework.txt";

		load(fileName);
		// 프로그램 실행
		int menu = 0;

		do {
			printMenu();
			try {
				// 메뉴 선택
				menu = sc.nextInt();
				// 선택한 메뉴 선택
				runMenu(menu);
			} catch (Exception e) {
				sc.nextLine();
			}
		} while (menu != EXIT);

		save(fileName);
	}

	@Override
	public void save(String fileName) {
		// run()메소드에 추가한 샘플 데이터들을 이용해서 파일에 저장하는 코드를 작성하세요
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(list);
			System.out.println("저장 완료");
		} catch (IOException e) {
			System.out.println("저장 실패");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		// 파일에 있는 연락처 리스트를 가져와서 list에 저장하는 코드 작성
		try (FileInputStream fis = new FileInputStream(fileName); ObjectInputStream ois = new ObjectInputStream(fis)) {
			list = (List<Calendar>) ois.readObject();
		} catch (Exception e) {
			System.out.println("파일을 불러오는것의 실패했습니다.");
		}

	}

}
