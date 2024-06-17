package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneManger {
	
	private Contact [] list;
	private int count;
	private Scanner sc = new Scanner(System.in);
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void runMenu(int menu) throws Exception {
		
		switch (menu) {
		case INSERT: 
			insert();
			break;
		case UPDATE:
			update();
			break;
		case DELETE:
			
			break;
		case SEARCH:
			
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
	}
	private void update() throws Exception {
		//이름 입력
				sc.nextLine();//공백 처리
				System.out.print("이름 : ");
				String name = sc.nextLine();
				//연락처 리스트에서 이름과 일치한는 연락처를 번지+1과 함께 출력
				if(!printContact(name)) {
					return;
				}
				
				//번호 선택
				System.out.print("번호 선택 : ");
				int index = sc.nextInt() - 1;
				//번호가 올바르지 않으면 잘못선택했습니다 하고 종료
				boolean res = checkContact(name,index);
				if(!res) {
					System.out.println("잘못 선택했습니다.");
					return;
				}
				//번화가 올바르면 이름,번호를 입력받음
				sc.nextLine();//엔터처리
				System.out.print("이름 : ");
				String newName = sc.nextLine();
				System.out.print("번호 : ");
				String newNumber = sc.nextLine();
				//이름,번호를 이용하여 객체를 생성
				Contact contact = new Contact(newName, newNumber);
				//생성된 객체가 중복된 번호이면 안내문구 출력하고 아니면 객체를 추가
				if(indexOf(index,contact) >= 0) {
					System.out.println("이미 등록된 번호입니다.");
					return;
				}
				list[index] = contact;
		
	}

	private boolean checkContact(String name, int index) {
		if(list == null || count == 0) {
			return false;
		}
		if(index < 0 || index >= count) {
			return false;
		}
		return list[index].getName().contains(name);
	}

	private boolean printContact(String name) {
		if(list == null || count == 0) {
			System.out.println("등록된 연락처가 없습니다.");
			return false;
		}
		int sameCount = 0;//이름과 일치하는 연락처 개수 => 없는 경우 안내문구를 위해
		for(int i = 0; i <count; i++) {
			if(list[i].getName().contains(name)) {
				System.out.println(i+1+list[i].toString());
				sameCount++;
			}
		}
		if(sameCount == 0) {
			System.out.println("일치하는 연락처가 없습니다.");
			return false;
		}
		return true;
	}
	private void insert() throws Exception {
		sc.nextLine();//엔터 처리
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("번호 : ");
		String number = sc.nextLine();
		//입력한 정보를 이용하여 객체를 생성
		Contact contact = new Contact(name, number);
		
		//연락처 리스트에 입력한 번호 객체가 있는지 없는지 확인해서
		int index = indexOf(contact);
		
		//있으면 이미 등록된 번호입니다라고 출력하고
		if(index >= 0) {
			System.out.println("이미 등록된 번호입니다.");
			return;
		}
		//없으면 연락처를 등록하고
		list[count] = contact;
		count++;
		//등록이 완료되었습니라고 출력
		System.out.println("등록이 완료되었습니다.");
		
	}
	private int indexOf(Contact contact) {
		if(list == null || count == 0) {
			return -1;
		}
		for(int i = 0; i < count; i++) {
			if(list[i].equals(contact)) {
				return i;
			}
		}
		return -1;
	}
	private int indexOf(int index,Contact contact) {
			if(list == null || count == 0) {
				return -1;
			}
			for(int i = 0; i < count; i++) {
				if(i == index) {
					continue;
				}
				if(list[i].equals(contact)) {
					return i;
				}
			}
			return -1;
	}

	@Override
	public void run() {
		String fileName = null;
		//불러오기
		load(fileName);
		int menu = EXIT +1;
		do {
			//메뉴출력
			printMenu();
			//메뉴 선택
			try {
				menu = sc.nextInt();
				runMenu(menu);
			}catch (InputMismatchException e) {
				System.out.println("메뉴를 잘못 입력 했습니다.");
				//입력 버퍼에 있는 내용을 비움
				sc.next();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			//선택한 메뉴에 따른 기능 실행
			
		}while(menu != EXIT);
		
		//저장하기
		//save(fileName)
	}
	@Override
	public void load(String fileName) {
		if(fileName == null) {
			System.out.println("불러올 파일이 없습니다.");
			list = new Contact[10];
			return;
		}
	}
	

}
