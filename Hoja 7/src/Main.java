import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Product> bst = new BinarySearchTree<>();
        CSVReader.loadProducts("productos.csv", bst);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un SKU para buscar: ");
        String sku = scanner.nextLine();
        Product result = bst.search(new Product(sku, 0, 0, "", ""));

        if (result != null) {
            System.out.println("Producto encontrado: " + result);
        } else {
            System.out.println("Producto no encontrado.");
        }

        scanner.close();
    }
}
