package day20.socket5;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientEx05 {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "192.168.30.199";
		
		try{
			System.out.println("아이디 입력 : ");
			Scanner sc = new Scanner(System.in);
			String id = sc.next();
			Socket socket = new Socket(ip,port);
			System.out.println("[연결 성공]");
			Client client = new Client(id, socket);
			client.recive();
			client.send();
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
