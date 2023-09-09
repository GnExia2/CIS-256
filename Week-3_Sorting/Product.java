import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product {
    private int productID;
    private String productName;
    private double productRating;
    private double price;

    public Product(int productID, String productName, double productRating, double price) {
        this.productID = productID;
        this.productName = productName;
        this.productRating = productRating;
        this.price = price;
    }

    // Getters and setters for the Product class

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductRating() {
        return productRating;
    }

    public double getPrice() {
        return price;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductRating(double productRating) {
        this.productRating = productRating;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + productID + ", Name: " + productName + ", Rating: " + productRating + ", Price: " + price;
    }
}

public class ProductSorting {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        // Populate the products list with some sample products
        products.add(new Product(1, "Product A", 4.5, 19.99));
        products.add(new Product(2, "Product B", 3.9, 29.99));
        products.add(new Product(3, "Product C", 4.0, 14.99));

        // Sort the products based on user's choice (e.g., by Name, Rating, or Price)
        long startTime = System.nanoTime(); // Record start time
        sortProducts(products, "Name");
        long endTime = System.nanoTime(); // Record end time

        // Calculate and display the sorting time
        long elapsedTime = endTime - startTime;
        System.out.println("Sorting Time (ns): " + elapsedTime);

        // Display the sorted products
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void sortProducts(List<Product> products, String key) {
        // Implement the sorting logic based on the selected key
        if (key.equals("Name")) {
            Collections.sort(products, Comparator.comparing(Product::getProductName));
        } else if (key.equals("Rating")) {
            Collections.sort(products, Comparator.comparing(Product::getProductRating));
        } else if (key.equals("Price")) {
            Collections.sort(products, Comparator.comparing(Product::getPrice));
        }
    }
}
