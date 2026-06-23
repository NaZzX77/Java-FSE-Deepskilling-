class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String toString() {
        return orderId + " " + customerName + " " + totalPrice;
    }
}

public class Solution {
    public static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temporaryOrder = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temporaryOrder;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int smallerIndex = low - 1;

        for (int currentIndex = low; currentIndex < high; currentIndex++) {
            if (orders[currentIndex].getTotalPrice() <= pivot) {
                smallerIndex++;
                Order temporaryOrder = orders[smallerIndex];
                orders[smallerIndex] = orders[currentIndex];
                orders[currentIndex] = temporaryOrder;
            }
        }

        Order temporaryOrder = orders[smallerIndex + 1];
        orders[smallerIndex + 1] = orders[high];
        orders[high] = temporaryOrder;
        return smallerIndex + 1;
    }

    public static void displayOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Order[] bubbleSortOrders = {
                new Order(1, "Asha", 2500.0),
                new Order(2, "Ravi", 1200.0),
                new Order(3, "Meena", 3500.0)
        };

        Order[] quickSortOrders = {
                new Order(1, "Asha", 2500.0),
                new Order(2, "Ravi", 1200.0),
                new Order(3, "Meena", 3500.0)
        };

        bubbleSort(bubbleSortOrders);
        quickSort(quickSortOrders, 0, quickSortOrders.length - 1);

        System.out.println("Bubble Sort:");
        displayOrders(bubbleSortOrders);
        System.out.println("Quick Sort:");
        displayOrders(quickSortOrders);
        System.out.println("Bubble Sort: O(n^2)");
        System.out.println("Quick Sort average: O(n log n)");
    }
}
