package day20.socket2;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ServerEx01 {

	//클라이언트가 연결되면 클라이언트에서 보낸 값을 입력 받고 서버에서 클라이언트에게 값을 전송하고
	//종료하는 프로그램
	public static void main(String[] args) {
		// 1.포트 번호를 설정
		int port = 5001;
		
		Scanner sc = new Scanner(System.in);
		
		//2.서버용 소켓 객체 생성
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("[대기 중].......");
			//3.대기
			//4.요철 수락 후 소켓 객체를 생성
			Socket socket = serverSocket.accept();
			System.out.println("[연결 성공].......");
			InputStream is = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(is);
			
			String tmp = ois.readUTF();
			System.out.println("클라이언트 : " + tmp);
			
			System.out.println("[수신 성공]");
			//서버에서 클라이언트로 문자열들을 전송
			OutputStream os = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(os);
			
			System.out.println("전송할 내용 : ");
			String send = sc.nextLine();
			oos.writeUTF(send);
			oos.flush();
			
			System.out.println("[전송 성공]");
			ois.close();
			oos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
