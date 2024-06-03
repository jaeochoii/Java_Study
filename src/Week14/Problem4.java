package Week14;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Trade {
    private String stockSymbol;
    private int quantity;
    private double price;
    private String type; // "BUY" or "SELL"
    private boolean success;

    public Trade(String stockSymbol, int quantity, double price, String type, boolean success) {
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
        this.success = success;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public boolean isSuccess() {
        return success;
    }
}

public class Problem4 {
    private double initialBudget;
    private double remainingBudget;
    private HashMap<String, List<Trade>> tradeHistory;
    private HashMap<String, Integer> stockHoldings;

    public Problem4(double initialBudget) {
        this.initialBudget = initialBudget;
        this.remainingBudget = initialBudget;
        this.tradeHistory = new HashMap<>();
        this.stockHoldings = new HashMap<>();
    }

    public void addTrade(String stockSymbol, int quantity, double price, String type) {
        boolean success = false;

        if (type.equals("BUY")) {
            if (remainingBudget >= quantity * price) {
                remainingBudget -= quantity * price;
                stockHoldings.put(stockSymbol, stockHoldings.getOrDefault(stockSymbol, 0) + quantity);
                success = true;
            }
        } else if (type.equals("SELL")) {
            if (stockHoldings.getOrDefault(stockSymbol, 0) >= quantity) {
                remainingBudget += quantity * price;
                stockHoldings.put(stockSymbol, stockHoldings.get(stockSymbol) - quantity);
                success = true;
            }
        }

        Trade trade = new Trade(stockSymbol, quantity, price, type, success);
        tradeHistory.putIfAbsent(stockSymbol, new ArrayList<>());
        tradeHistory.get(stockSymbol).add(trade);

        System.out.println("거래 " + stockSymbol + " " + type + " " + quantity + " 매수 " + price + "에서: " + (success ? "성공" : "실패"));
    }

    public double getTotalSpent() {
        double totalSpent = 0;
        for (List<Trade> trades : tradeHistory.values()) {
            for (Trade trade : trades) {
                if (trade.getType().equals("BUY") && trade.isSuccess()) {
                    totalSpent += trade.getQuantity() * trade.getPrice();
                }
            }
        }
        return totalSpent;
    }

    public double getTotalEarned() {
        double totalEarned = 0;
        for (List<Trade> trades : tradeHistory.values()) {
            for (Trade trade : trades) {
                if (trade.getType().equals("SELL") && trade.isSuccess()) {
                    totalEarned += trade.getQuantity() * trade.getPrice();
                }
            }
        }
        return totalEarned;
    }

    public double getNetProfitOrLoss() {
        return getTotalEarned() - getTotalSpent();
    }

    public double getRemainingBudget() {
        return remainingBudget;
    }

    public void printCurrentHoldings() {
        System.out.println("현재 주식 보유량:");
        for (String stock : stockHoldings.keySet()) {
            System.out.println(stock + ": " + stockHoldings.get(stock) + " 주");
        }
    }

    public void printTradeHistory(String stockSymbol) {
        if (tradeHistory.containsKey(stockSymbol)) {
            System.out.println(stockSymbol + " 주식의 거래 기록:");
            for (Trade trade : tradeHistory.get(stockSymbol)) {
                System.out.println("- 수량: " + trade.getQuantity() + ", 가격: " + trade.getPrice() + ", 유형: " + trade.getType() + ", 성공: " + trade.isSuccess());
            }
        } else {
            System.out.println(stockSymbol + " 주식에 대한 거래 기록이 없습니다.");
        }
    }

    public int getTotalVolume(String stockSymbol) {
        int totalVolume = 0;
        if (tradeHistory.containsKey(stockSymbol)) {
            for (Trade trade : tradeHistory.get(stockSymbol)) {
                totalVolume += trade.getQuantity();
            }
        }
        return totalVolume;
    }

    public double getMaxPrice(String stockSymbol) {
        double maxPrice = 0;
        if (tradeHistory.containsKey(stockSymbol)) {
            for (Trade trade : tradeHistory.get(stockSymbol)) {
                if (trade.getPrice() > maxPrice) {
                    maxPrice = trade.getPrice();
                }
            }
        }
        return maxPrice;
    }

    public int getTotalMarketVolume() {
        int totalMarketVolume = 0;
        for (String stockSymbol : tradeHistory.keySet()) {
            totalMarketVolume += getTotalVolume(stockSymbol);
        }
        return totalMarketVolume;
    }

    public static void main(String[] args) {
        Problem4 manager = new Problem4(100000);

        manager.addTrade("AAPL", 100, 150.0, "BUY");
        manager.addTrade("AAPL", 50, 150.0, "BUY");
        manager.addTrade("AAPL", 200, 155.0, "SELL");
        manager.addTrade("GOOG", 300, 1000.0, "BUY");
        manager.addTrade("AAPL", 150, 149.0, "BUY");
        manager.addTrade("GOOG", 200, 1100.0, "SELL");
        manager.addTrade("AAPL", 100, 155.0, "SELL");

        System.out.println("\n총 지출: " + manager.getTotalSpent());
        System.out.println("총 수익: " + manager.getTotalEarned());
        System.out.println("순이익 또는 손실: " + manager.getNetProfitOrLoss());
        System.out.println("남은 예산: " + manager.getRemainingBudget());

        manager.printCurrentHoldings();

        System.out.println("\nAAPL 주식의 거래 기록:");
        manager.printTradeHistory("AAPL");
        System.out.println("\nGOOG 주식의 거래 기록:");
        manager.printTradeHistory("GOOG");

        System.out.println("\nAAPL의 총 거래량: " + manager.getTotalVolume("AAPL"));
        System.out.println("AAPL의 최고 가격: " + manager.getMaxPrice("AAPL"));
        System.out.println("GOOG의 총 거래량: " + manager.getTotalVolume("GOOG"));
        System.out.println("GOOG의 최고 가격: " + manager.getMaxPrice("GOOG"));

        System.out.println("\n총 거래량: " + manager.getTotalMarketVolume());
    }
}
