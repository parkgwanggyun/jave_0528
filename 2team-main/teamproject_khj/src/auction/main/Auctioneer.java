package auction.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import auction.controller.AuctionController;
import auction.controller.MemberController;
import auction.controller.PrintController;
import auction.model.vo.MemberVO;

/* 1. 회원정보 관리
 * 2. 경매 관리
 * */

public class Auctioneer {

	private Scanner scan = new Scanner(System.in);
	MemberController memberController = new MemberController(scan);
	AuctionController auctionController = new AuctionController(scan);
	RunMainMenu runMainMenu;
	List<PrintWriter> clients;
	boolean auctionState = false; // 경매 시작 상태
	boolean exitFlag = false;
	PresentCondition presentCondition;
	LocalTime finishAuction;
	public Auctioneer(){
		clients = new ArrayList<PrintWriter>();
		Collections.synchronizedList(clients); //리스트 동기화
	}

	public void start() {
		int port = 6006; // 서버 포트번호
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip + "  " + port);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		runMainMenu = new RunMainMenu();
		runMainMenu.start();
		try(ServerSocket serverSocket = new ServerSocket(port)) {
			while(true) {
				Socket clientSocket = serverSocket.accept();
				if(exitFlag) {
					break;
				}
				//				if(clientSocket.isConnected()) {
				//					System.out.println("[" + clientSocket + "에서 접속]");
				//				}	

				ClientHandler clientHandler = new ClientHandler(clientSocket);
				clientHandler.start();
			}
		}  catch (IOException e) {
			e.printStackTrace();
		} 

	}
	// 
	class RunMainMenu extends Thread{
		public void run() {
			int menu = 0;
			do {
				System.out.println("1. 회원 관리");
				System.out.println("2. 경매 관리");
				System.out.println("3. 종료");
				System.out.print("메뉴 선택 >> ");

				menu = nextInt();
				runMenu(menu);

			} while(menu != 3);
		}
	}

	public void runMenu(int menu)  {
		switch (menu) {
		case 1 : 
			PrintController.mniBar();
			memberMenuList();
			break;
		case 2 :
			PrintController.mniBar();
			auctionMenuList();
			break;
		case 3 :
			exitFlag = true;
			System.out.println("[프로그램 종료]");
			try {
				Socket socket = new Socket("localhost", 6006);
			} catch (Exception e) {
			}
			break;
		default :
//			System.out.println(menu);
			System.out.println("잘못된 메뉴 입니다.");
		}
	}
	public void auctionMenuList() {
		int menu = 0;
		do {
			System.out.println("1. 경매정보 등록");
			System.out.println("2. 경매 시작");
			System.out.println("3. 경매기록 조회");
			System.out.println("4. 입찰기록 조회");
			System.out.println("5. 이전 메뉴");
			System.out.print("메뉴 선택 >> ");

			menu = nextInt();
			runAuctionMenu(menu);

		}while(menu != 5);
	}	

	public void memberMenuList() {
		int menu = 0;
		while(menu != 5) {
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 수정");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 회원 조회");
			System.out.println("5. 이전 메뉴");
			System.out.print("메뉴 선택 >> ");

			menu = nextInt();
			runMemberMenu(menu);
		}
	}	

	// 멤버 메뉴
	private void runMemberMenu(int menu) {
		switch (menu) {
		case 1 : 
			memberController.insertMember();
			break;
		case 2 :
			memberController.updateMember();
			break;
		case 3 :
			memberController.deleteMember();
			break;
		case 4 :
			memberController.searchMember();
			break;
		case 5 :
			PrintController.mniBar();
			break;
		default :
			System.out.println("잘못된 메뉴 입니다.");
		}
	}

	// 경매 타이머
	private void auctionTimer() {
		Thread at = new Thread(()->{
			int count = 10;
			while(!exitFlag) {
				if(finishAuction.minusSeconds(count).isBefore(LocalTime.now())) {
					for(PrintWriter out : clients) {
						out.println("경매 종료까지 " + count + "초 남았습니다.");
					}
					count--;
				}
				if(count == 0) {
					auctionState = false;
					for(PrintWriter out : clients) {
						out.println("FINISH::경매가 종료되었습니다. ");
						if(presentCondition.getId().equals("아이디")) {
							out.println("이번 경매품 " + presentCondition.getName() + "은(는) 유찰되었습니다.");
						} else {
							out.println("이번 경매품 " + presentCondition.getName() + "은(는) " + presentCondition.getId()
							+ "님에게 " + presentCondition.getHighestBid() + "원에 낙찰되었습니다.");
						}
					}
					PrintController.bar();
					System.out.println("경매품 <" + presentCondition.getName() + "> " + presentCondition.getId() + "님이 " 
							+ presentCondition.getHighestBid() + "원에 낙찰");
					auctionController.finishAuction();
					presentCondition = null;
					break;
				}
			}
		});
		at.start();
	} 

	// 경매 메뉴 
	private void runAuctionMenu(int menu) {
		switch (menu) {
		case 1 : 
			if(auctionState) {
				System.out.println("진행 중인 경매가 있습니다.");
				PrintController.bar();
				break;
			}
			presentCondition = insertItem();
			if(presentCondition != null) {
				System.out.println("[등록 완료]");
				PrintController.mniBar();
			}
			break;
		case 2 :
			if(auctionState) {
				System.out.println("진행 중인 경매가 있습니다.");
				PrintController.bar();
				break;
			}
			if(presentCondition == null) {
				System.out.println("먼저 경매정보를 입력해주세요");	
				PrintController.bar();
				break;
			}
			auctionState = true;
			auctionController.startAuction(presentCondition); //경매기록
			if(clients.size() > 0) {
				for(PrintWriter out : clients) {
					out.println("AUCTION_START::");
//					out.println("AUCTION_START::"+ presentCondition.getName() + "::" + presentCondition.getStartPrice() 
//					+"::" + presentCondition.getEndTimeToString() + "::" + presentCondition.getIncrement());
				}
			}
			auctionTimer();
			break;
		case 3 :
			//컨트롤에게 전체 경매기록 출력을 시킴
			auctionController.searchAuctionList();
			PrintController.bar();
			break;
		case 4 :
			//검색된 입찰기록 출력
			auctionController.searchBidList();
			PrintController.bar();
			break;
		case 5 :
			PrintController.mniBar();
			break;
		default :
			System.out.println("잘못된 메뉴 입니다.");
			PrintController.mniBar();
			
		}		
	}

	//	경매품명, 시작가, 입찰 유효 시간, 인상액 을 입력하여 등록하는 기능
	public PresentCondition insertItem() {
		try {

			System.out.print("경매품명 입력 > ");
			scan.nextLine();
			String name = scan.nextLine();
			if(!Pattern.matches(getRegex("itemName"), name)) {
				System.out.println("-> 특수문자 없이 20자 이내로 입력하십시오.");
				return null;
			}
			System.out.print("시작가 입력 > ");
			int startPrice;
			while((startPrice = scan.nextInt()) < 0) {
				System.out.println("-> 0보다 커야 됩니다.");
				System.out.print("시작가 입력 > ");
				startPrice = scan.nextInt();
			}
			System.out.print("유효시간 입력(분) > ");
			int validityPeriod = scan.nextInt();
			while(validityPeriod < 1 || validityPeriod > 120) {
				System.out.println("-> 입력 가능 범위: 1~120분");
				System.out.print("유효시간 입력(분) > ");
				validityPeriod = scan.nextInt();
			}
			System.out.print("인상액 입력 > ");
			int increment = scan.nextInt();
			while(increment < 100 || increment > 1000000) {
				System.out.println("-> 입력 가능 범위: 100~1,000,000");
				System.out.print("인상액 > ");
				increment = scan.nextInt();
			}
			//현재 시간에 입력한 유효시간을 더함
			LocalTime endTime = LocalTime.now().plusMinutes(validityPeriod);
			finishAuction = endTime;
			int highestBid = startPrice;
			//경매현황에는 경매품명, 시작가, 최고입찰가, 종료시간, 인상액 있다
			PresentCondition presentCondition = new PresentCondition(name, startPrice, highestBid, endTime, increment, "아이디");
			return presentCondition;
			//경매기록에는 날짜, 경매품명, 시작가, 낙찰가, 낙찰자 아이디가 있다.
		} catch (InputMismatchException e) {
			System.out.println("[입력이 올바르지 않음]");
			PrintController.mniBar();
			scan.nextLine();
			return null;
		}
	}

	// 클라이언트 요청 처리를 담당하는 쓰레드
	class ClientHandler extends Thread {
		private final Socket clientSocket;
		private BufferedReader in;
		private PrintWriter out;
		String logId = null;
		boolean firstSend = true; // 처음 보내는 경매현황인지 체크
		public ClientHandler(Socket socket) {
			this.clientSocket = socket;
		}
		@Override
		public void run() {
			try {
				in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				out = new PrintWriter(clientSocket.getOutputStream(), true);
				clients.add(out);
				String request;
				while ((request = in.readLine()) != null) {
					if (request.startsWith("JOIN")) {
						handleJoin(request);
					} else if (request.startsWith("BID")) {
						handleBid(request);
					} else if (request.startsWith("REGISTER")) {
						handleRegister(request);
					} else if (request.startsWith("LOGIN")) {						
						handleLogin(request);
					} else if (request.startsWith("LOGOUT")) {						
						handleLogout(request);
					} else if (request.startsWith("FINISH")) {						
						firstSend = true;
					} else if (request.equals("EXIT")) {
						break;
					}						
				}
				//				clientSocket.close();
			} catch (IOException e) {
			} finally {
//				if(logId != null) {
//					System.out.println("[나감 > " + logId + "]");
//				} else {
//					System.out.println("[나감 > " + clientSocket + "]");
//				}
				clients.remove(out);
				try {
					clientSocket.close();
				} catch (IOException e) {
				}
			}
		}		
		private void handleBid(String request) {
			//들어온 입찰 처리			
			if(auctionState) {
				String[] parts = request.split("::");
				String id = parts[1];
				String bid = parts[2];
				presentCondition.setHighestBidToInt(bid); // 경매현황 최고입찰가/id 갱신
				presentCondition.setId(id); 
				if(auctionController.insertBid(id, bid)) { // 입찰기록 db에 추가
					sendPc(presentCondition);
				}

			} else {
				out.println("AUCTION_OFF::진행 중인 경매가 없습니다.");
			}
		}

		// 신규 회원 확인
		public void handleRegister(String request) {
			String[] parts = request.split("::");
			String id = parts[1];
			String name = parts[2];
			String address = parts[3];
			String contact = parts[4];
			System.out.println("아이디확인" + id);
			MemberVO member = new MemberVO(id, "", name, address, contact);
			System.out.println("<신규회원 가입> ");
			System.out.println(member);
			PrintController.bar();
		}
		public void handleJoin(String request) {
			if(auctionState) {
				if(firstSend) {
					sendPc(presentCondition); 
				}
			} else {
				out.println("AUCTION_OFF::진행 중인 경매가 없습니다.");
			}
		}

		// 로그인 요청 처리
		public void handleLogin(String request) {
			String[] parts = request.split("::");
			String id = parts[1];
			logId = id;
			System.out.println("[ "+ id+" >> 로그인 ]");	
			firstSend = true;
			if(auctionState) {
				out.println("AUCTION_ON::경매가 진행 중입니다.");
			} else {
				out.println("AUCTION_OFF::진행 중인 경매가 없습니다.");
			}
		}
		// 로그아웃 요청 처리
		public void handleLogout(String request) {
			String[] parts = request.split("::");
			String id = parts[1];
			logId = id;
			System.out.println("[ "+ id+" >> 로그아웃 ]");	
			firstSend = true;
				out.println("AUCTION_OUT::");
		}

		// 로그인 중인 회원들에게 경매현황을 전송하는 기능
		public void sendPc(PresentCondition presentCondition) {
			String name = presentCondition.getName();
			String startPrice = Integer.toString(presentCondition.getStartPrice());
			String highestPrice = Integer.toString(presentCondition.getHighestBid());
			String endTime = presentCondition.getEndTimeToString();
			String increment = Integer.toString(presentCondition.getIncrement());
			String id = presentCondition.getId();
			if(firstSend) {
				out.println("PRESENT_CONDITION::" + name + "::" + startPrice +"::" + highestPrice + "::" + endTime + "::" + increment
						+ "::" + id); // 수정 
				firstSend = false;
			} else {
				for(PrintWriter out : clients) {
					out.println("PRESENT_CONDITION::" + name + "::" + startPrice +"::" + highestPrice + "::" + endTime + "::" + increment 
							+ "::" + id);
				}
			}
		}
	}	


	//정규표현식 모음
	private String getRegex(String regex) {
		if(regex.equals("itemName")) {
			return "^[a-zA-Z0-9가-힣 ]{1,20}$";
		}
		if(regex.equals("validityPeriod")) {
			return "";
		}
		if(regex.equals("increment")) {
			return "";
		}
		return null;
	}

	public int nextInt() {
		try {
			return scan.nextInt();
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("잘못 입력하셨습니다.");
			return Integer.MIN_VALUE;
		}
	}
}
