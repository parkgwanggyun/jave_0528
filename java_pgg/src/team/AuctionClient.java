package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class AuctionClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 5002;

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // 닉네임 입력
            System.out.println("닉네임 입력 :");
            String nickname = consoleInput.readLine();
            out.println(nickname);

            // 서버에서 물품 정보 받기
            String itemInfo;
            while ((itemInfo = in.readLine()) != null) {
                if (itemInfo.isEmpty()) {
                    break;
                }
                System.out.println(itemInfo);
            }

            // 입찰 진행
            String serverResponse;
            while ((serverResponse = in.readLine()) != null) {
                System.out.println(serverResponse);
                if (serverResponse.startsWith("현재 최고 입찰가")) {
                    break;
                }

                // 사용자 입력 받기
                System.out.print("입찰가격 입력 : (Ex.입찰 200): ");
                String bidCommand = consoleInput.readLine();
                out.println(bidCommand); // 서버로 입찰 명령 전송
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}