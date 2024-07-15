package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class AuctionClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to auction server.");
            while (true) {
                System.out.println("1. Add item");
                System.out.println("2. Add bidder");
                System.out.println("3. Place bid");
                System.out.println("4. Show highest bidder");
                System.out.println("5. End auction");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (option) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine();
                        System.out.print("Enter starting bid: ");
                        double startingBid = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        out.println("ADD_ITEM " + itemName + " " + startingBid);
                        break;
                    case 2:
                        System.out.print("Enter bidder name: ");
                        String bidderName = scanner.nextLine();
                        out.println("ADD_BIDDER " + bidderName);
                        break;
                    case 3:
                        System.out.print("Enter bidder name: ");
                        String bidder = scanner.nextLine();
                        System.out.print("Enter item name: ");
                        String item = scanner.nextLine();
                        System.out.print("Enter bid amount: ");
                        double bidAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        out.println("PLACE_BID " + bidder + " " + item + " " + bidAmount);
                        break;
                    case 4:
                        System.out.print("Enter item name: ");
                        String itemToCheck = scanner.nextLine();
                        out.println("SHOW_HIGHEST_BIDDER " + itemToCheck);
                        break;
                    case 5:
                        out.println("END_AUCTION");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }

                String response = in.readLine();
                System.out.println(response);
                if (option == 5) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}