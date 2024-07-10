package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;



public class AuctionServer {
    private static final int PORT = 5001;
    private static Set<ClientHandler> clientHandlers = Collections.newSetFromMap(new ConcurrentHashMap<>());
    private static volatile int highestBid = 0;
    private static volatile String highestBidder = "";
    private static String item;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            registerItem();

            System.out.println("경매서버 입장 포트 " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void registerItem() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("경매 물품: ");
            item = scanner.nextLine();
            System.out.print("시작가: ");
            highestBid = scanner.nextInt();
            scanner.nextLine(); // 공백
        } catch (InputMismatchException e) {
            System.err.println("정수 입력해주세요 .");
            System.exit(1);
        }
    }

    public static synchronized void placeBid(String bidder, int bid) {
        if (bid > highestBid) {
            highestBid = bid;
            highestBidder = bidder;
            broadcast("현재 최고가 : " + bid + " 원 " + bidder);
        } else {
            broadcast("입찰 시도자 " + bidder + " 잘못된 입찰가 : " + highestBid);
        }
    }

    public static void broadcast(String message) {
        for (ClientHandler clientHandler : clientHandlers) {
            clientHandler.sendMessage(message);
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String nickname;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // 닉네임 입력 받기
                nickname = in.readLine();
                System.out.println("Client connected: " + nickname);

                // 물품 정보 전송
                out.println("Item for auction: " + item);
                out.println("Starting bid: " + highestBid);
                out.println("Current highest bid: " + highestBid + " by " + (highestBidder.isEmpty() ? "No bids yet" : highestBidder));

                // 입찰 처리
                String clientInput;
                while ((clientInput = in.readLine()) != null) {
                    try {
                        String[] parts = clientInput.split("\\s+");
                        if (parts.length == 2 && parts[0].equalsIgnoreCase("입찰")) {
                            int bid = Integer.parseInt(parts[1]);
                            placeBid(nickname, bid);
                        } else {
                            out.println("Invalid command. Use '입찰 <amount>' format.");
                        }
                    } catch (NumberFormatException e) {
                        out.println("Invalid bid amount. Please enter a valid number.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clientHandlers.remove(this);
                System.out.println("Client disconnected: " + nickname);
            }
        }

        public void sendMessage(String message) {
            if (out != null) {
                out.println(message);
            }
        }
    }
}