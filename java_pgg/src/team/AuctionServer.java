package team;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


class AuctionItem {
    String name;
    double startingBid;
    double highestBid;
    String highestBidder;
    Date endTime; // 경매 종료 시간
    Timer timer; // 타이머 객체

    AuctionItem(String name, double startingBid) {
        this.name = name;
        this.startingBid = startingBid;
        this.highestBid = startingBid;
        this.highestBidder = "No bidder yet";
        this.endTime = new Date(System.currentTimeMillis() + auctionTimeSeconds * 1000); // 경매 종료 시간 설정
        this.timer = new Timer();
        this.timer.schedule(new AuctionEndTask(), this.endTime);
    }
}
class AuctionEndTask extends TimerTask {
    public void run() {
        System.out.println("Auction for item '" + name + "' has ended.");
		timer.cancel(); // 타이머 종료
    }
}

class Auction {
    List<AuctionItem> items = new ArrayList<>();
    List<String> bidders = new ArrayList<>();

    void addItem(String name, double startingBid, int auctionTimeSeconds) {
        AuctionItem item = new AuctionItem(name, startingBid, auctionTimeSeconds);
        items.add(item);
        System.out.println("Added item '" + name + "' with starting bid of " + startingBid + " and auction time of " + auctionTimeSeconds + " seconds");
    }

    void addBidder(String name) {
        bidders.add(name);
        System.out.println("Added bidder '" + name + "'");
    }

    String placeBid(String bidderName, String itemName, double bidAmount) {
        for (AuctionItem item : items) {
            if (item.name.equals(itemName)) {
                if (bidAmount > item.highestBid) {
                    item.highestBid = bidAmount;
                    item.highestBidder = bidderName;
                    return bidderName + " placed a bid of " + bidAmount + " on " + itemName;
                } else {
                    return "Bid is lower than the current highest bid.";
                }
            }
        }
        return "Item not found.";
    }

    String showHighestBidder(String itemName) {
        for (AuctionItem item : items) {
            if (item.name.equals(itemName)) {
                return "Highest bidder for " + itemName + " is " + item.highestBidder + " with a bid of " + item.highestBid;
            }
        }
        return "Item not found.";
    }

    String endAuction(String itemName) {
        for (AuctionItem item : items) {
            if (item.name.equals(itemName)) {
                item.timer.cancel(); // 타이머 종료
                return "Auction for item '" + itemName + "' has ended. Final results: Highest bidder is " + item.highestBidder + " with a bid of " + item.highestBid;
            }
        }
        return "Item not found.";
    }
}

public class AuctionServer {
    private static Auction auction = new Auction();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Auction server started...");
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    String[] parts = inputLine.split(" ");
                    String command = parts[0];
                    switch (command) {
                        case "ADD_ITEM":
                            String itemName = parts[1];
                            double startingBid = Double.parseDouble(parts[2]);
                            auction.addItem(itemName, startingBid);
                            out.println("Item added.");
                            break;
                        case "ADD_BIDDER":
                            String bidderName = parts[1];
                            auction.addBidder(bidderName);
                            out.println("Bidder added.");
                            break;
                        case "PLACE_BID":
                            bidderName = parts[1];
                            itemName = parts[2];
                            double bidAmount = Double.parseDouble(parts[3]);
                            String result = auction.placeBid(bidderName, itemName, bidAmount);
                            out.println(result);
                            break;
                        case "SHOW_HIGHEST_BIDDER":
                            itemName = parts[1];
                            result = auction.showHighestBidder(itemName);
                            out.println(result);
                            break;
                        case "END_AUCTION":
                            result = auction.endAuction();
                            out.println(result);
                            break;
                        default:
                            out.println("Unknown command.");
                            break;
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
            }
        }
    }
}