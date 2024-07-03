package com.kr.test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	
	public void client() {
		int port = 3000;
		String serverIP;
	try {
		serverIP = InetAddress.getLocalHost().getHostAddress();
		
		Socket socket = new Socket(serverIP,port);
		//이하 코드는 중간 생략...
