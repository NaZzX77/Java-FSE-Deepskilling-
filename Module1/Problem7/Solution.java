import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName, double price);
}

interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setStockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Mobile App: " + stockName + " price is " + price);
    }
}

class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Web App: " + stockName + " price is " + price);
    }
}

public class Solution {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        stockMarket.registerObserver(new MobileApp());
        stockMarket.registerObserver(new WebApp());

        stockMarket.setStockPrice("ABC", 125.50);
    }
}
