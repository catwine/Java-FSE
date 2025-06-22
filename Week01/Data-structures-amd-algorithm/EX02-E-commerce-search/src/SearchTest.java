import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {

        System.out.println("Enter number of products\n3");
        Product[] products = {
                new Product(101, "Shoes", "Fashion"),
                new Product(102, "Phone", "Electronics"),
                new Product(103, "Book", "Education")
        };

        for (Product product : products) {
            System.out.println("Enter product ID:" + product.productId);
            System.out.println("Enter product name:" + product.productName);
            System.out.println("Enter Category:" + product.category);
        }

        int targetId = 103;
        System.out.println("REnter Taget ID\n" + targetId);

        // Linear Search
        System.out.println("Linear Search");
        Product linearResult = ECommerceSearch.linearSearch(products, targetId);
        if (linearResult != null) {
            System.out.println("FOUND:" + linearResult);
        } else {
            System.out.println("NOT FOUND");
        }

        // Binary Search (sort by productId first)
        Arrays.sort(products, (a, b) -> Integer.compare(a.productId, b.productId));
        System.out.println("\nBinary Search");
        Product binaryResult = ECommerceSearch.binarySearch(products, targetId);
        if (binaryResult != null) {
            System.out.println("FOUND: " + binaryResult);
        } else {
            System.out.println("NOT FOUND");
        }
    }
}
