class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String toString() {
        return productId + " " + productName + " " + category;
    }
}

public class Solution {
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (products[middle].getProductId() == productId) {
                return products[middle];
            }

            if (products[middle].getProductId() < productId) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(103, "Book", "Education")
        };

        System.out.println("Linear Search: " + linearSearch(products, 102));
        System.out.println("Binary Search: " + binarySearch(products, 103));
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
    }
}
