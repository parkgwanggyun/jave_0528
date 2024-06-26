package day21.socket2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class ClientMg implements Program{
	private Scanner sc = new Scanner(System.in);
	private List<Contact> list = new ArrayList<Contact>();
	private String ip = "192.168.30.188";
	private int port = 5003;

	@Override
	public void printMenu() {
		System.out.println("메뉴\n"
				+ "1.연락처 추가\n"
				+ "2.연락처 수정\n"
				+ "3.연락처 삭제\n"
				+ "4.연락처 확인\n"
				+ "5.프로그램 종료\n"
				+ "메뉴 선택 : ");
	}
	@Override
	public void run() {
		int meun = 0;
		
		do {
			printMenu();
			meun = sc.nextInt();
			try { 
				runMenu(meun);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(meun != 5);
		save();
	}

	@Override
	public void runMenu(int menu) throws Exception {
		printMenu();
		
		switch(menu) {
		case 1 :
			insert();
			break;
		case 2 :
			update();
			break;
		case 3 :
			delete();
			break;
		case 4 : 
			search();
			break;
		case 5 :
			exit();
			break;
		default :
			System.out.println("잘못된 메뉴입니다.");
				
		}
	}
	private void insert() {
		
		//연락처 입력
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String num = sc.next();
		//연락처를 이용한 객체 생성
		Contact contact = new Contact(name, num);
		//중복된 번호이면 안내문구 출력 후 종료
		if(list.contains(contact)) {
			System.out.println("이미 등록된 번호입니다.");
		}
		//리스트에 연락처 추가
		list.add(contact);
		//안내문구 출력
		System.out.println("연락처를 추가했습니다.");
		return;
	}
	private void update() {
		//검색
		//검색 : 이름을 입력
		System.out.println("이름 : ");
		String search = sc.next();
		//검색 : 입력한 이름이 포함된 연락처들을 번호와 함께 출력
		int i = 0,count =0;
		for(Contact contact : list) {
			i++;
			if(contact.getName().contains(search)) {
				System.out.println(i+ "." + contact);
			}
		}
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		System.out.println("번호 입력 : ");
		int index = sc.nextInt()-1;
		
		Contact contact = list.get(index);
		
		//새로운 연락처 정보를입력(이름,번호)
		System.out.print("새 이름 : ");
		String name = sc.next();
		System.out.print("새 전화번호 : ");
		String num = sc.next();
		//새로운 연락처 객체를 생성
		Contact newContact = new Contact(name, num);
		
		//수정
		//수정 : 새로운 연락처가 리스트에 있으면 안내문구 출력 후 종료(단,현재 선택한 연락처가 아닌 연락처 중에서)
		//전체 탐색
		
		for(Contact tmp : list) {
			//리스트에서 가져온 객체와 위에서 가져온 객체가 같으면 건너뜀
			if(tmp == contact) {
				continue;
			}
			//리스트에서 가져온 객체와 새로운 연락처 객체가 같으면 안내 문구 출력후 종료
			if(tmp.equals(newContact)) {
				System.out.println("이미 등록된 번호 입니다.");
				return; 
			}
		}
			
		//위에서 가져온 객체를 새로운 객체로 수정(Contact 클래스에 update 메소드를 추가)
		contact.update(newContact);
		System.out.println("연락처를 수정했습니다.");
	}
	private void delete() {
		//이름을 입력
		System.out.print("이름 : ");
		String search = sc.next();
		//입력한 이름이 포함된 연락처들을 번호와 함께 출력
		int i = 0,count =0;
		for(Contact contact : list) {
			i++;
			if(contact.getName().contains(search)) {
				System.out.println(i+ "." + contact);
				
			}
		}
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
		//번호를 선택
		System.out.println("번호 입력 : ");
		int index = sc.nextInt()-1;
		//선택한 번호의 연락처를 삭제
		if(list.remove(index) != null) {
			System.out.println("연락처를 삭제했습니다");
			return;
		}
			System.out.println("연락처를 삭제하지 못했습니다.");
	}
	
	private void search() {
		//이름 입력
		System.out.print("이름 : ");
		String search = sc.next();
		//이름이 포함된 연락처들을 출력
		int count =0;
		for(Contact contact : list) {
			if(contact.getName().contains(search)) {
				System.out.println(contact);
				
			}
		}
		//일치하는 연락처들이 없으면 안내문구 출력
		if(count == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		}
	}
	private void exit() {
		System.out.println("시스템을 종료합니다.");
		
	}
	public void load() {
		//소켓 생성
		try {
			Socket socket = new Socket(ip,port);
			//ObjectInput/OutPutStream 생성
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			//oos를 이용해서 load 문자열 전송
			oos.writeUTF("load");
			oos.flush();
			//ois를 이용해서 연락처 리스트를 저장
			list = (List<Contact>)ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void save() {
		//1. 소켓 생성
		try {
			Socket socket = new Socket(ip,port);
			//소켓을 이용하여 ObjectOutputStream 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			//2. save 문자열 전송
			oos.writeUTF("save");
			//3. 연락처 리스트를 전송
			oos.writeObject(list);
			oos.flush();
			
		} catch (Exception e) {
			System.out.println("예외 발생[저장]");
			e.printStackTrace();
		}
		
	}

}
