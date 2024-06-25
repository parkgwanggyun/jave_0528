package day20.stock;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class StockTradingSimulator {

    private static final String API_KEY = "your_alpha_vantage_api_key";
    private static final double INITIAL_CASH_BALANCE = 10000.0;

    private double cashBalance;
    private Map<String, Integer> portfolio;

    public StockTradingSimulator() {
        this.cashBalance = INITIAL_CASH_BALANCE;
        this.portfolio = new HashMap<>();
    }

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("\nCurrent cash balance: $" + cashBalance);
            System.out.println("Choose an option:");
            System.out.println("1. Get Stock Quote");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            try {
                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        getStockQuote(reader);
                        break;
                    case "2":
                        buyStock(reader);
                        break;
                    case "3":
                        sellStock(reader);
                        break;
                    case "4":
                        viewPortfolio();
                        break;
                    case "5":
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid option. Please choose again.");
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void getStockQuote(BufferedReader reader) throws IOException {
        System.out.print("Enter stock symbol to get quote (e.g., AAPL): ");
        String symbol = reader.readLine().toUpperCase();

        String apiUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject quote = jsonResponse.getJSONObject("Global Quote");

            String symbolOutput = quote.getString("01. symbol");
            String priceOutput = quote.getString("05. price");
            String changeOutput = quote.getString("09. change");

            System.out.println("\nStock Quote:");
            System.out.println("Symbol: " + symbolOutput);
            System.out.println("Price: $" + priceOutput);
            System.out.println("Change: " + changeOutput);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buyStock(BufferedReader reader) throws IOException {
        System.out.print("\nEnter stock symbol to buy (e.g., AAPL): ");
        String symbol = reader.readLine().toUpperCase();

        System.out.print("Enter quantity to buy: ");
        int quantity = Integer.parseInt(reader.readLine());

        double pricePerShare = fetchStockPrice(symbol);

        if (pricePerShare == -1) {
            System.out.println("Failed to fetch stock price. Purchase aborted.");
            return;
        }

        double totalCost = pricePerShare * quantity;

        if (totalCost > cashBalance) {
            System.out.println("Insufficient funds to buy.");
            return;
        }

        cashBalance -= totalCost;

        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + quantity);

        System.out.println(quantity + " shares of " + symbol + " bought for $" + totalCost);
    }

    private void sellStock(BufferedReader reader) throws IOException {
        System.out.print("\nEnter stock symbol to sell (e.g., AAPL): ");
        String symbol = reader.readLine().toUpperCase();

        if (!portfolio.containsKey(symbol)) {
            System.out.println("You do not own any shares of " + symbol);
            return;
        }

        System.out.print("Enter quantity to sell: ");
        int quantity = Integer.parseInt(reader.readLine());

        int currentQuantity = portfolio.get(symbol);
        if (quantity > currentQuantity) {
            System.out.println("You do not have enough shares to sell.");
            return;
        }

        double pricePerShare = fetchStockPrice(symbol);

        if (pricePerShare == -1) {
            System.out.println("Failed to fetch stock price. Sale aborted.");
            return;
        }

        double totalSale = pricePerShare * quantity;

        cashBalance += totalSale;

        portfolio.put(symbol, currentQuantity - quantity);

        System.out.println(quantity + " shares of " + symbol + " sold for $" + totalSale);
    }

    private void viewPortfolio() {
        System.out.println("\nCurrent Portfolio:");
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();
            System.out.println(symbol + ": " + quantity + " shares");
        }
    }

    private double fetchStockPrice(String symbol) {
        String apiUrl = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + API_KEY;

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject quote = jsonResponse.getJSONObject("Global Quote");

            return Double.parseDouble(quote.getString("05. price"));

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static void main(String[] args) {
        StockTradingSimulator simulator = new StockTradingSimulator();
        simulator.start();
    }
}
