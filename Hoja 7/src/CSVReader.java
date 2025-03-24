import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    public static void loadProducts(String filePath, BinarySearchTree<Product> bst) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.nextLine(); // Saltar encabezado
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");

                // Validar que la fila tenga al menos 5 valores esperados
                if (data.length < 5) {
                    System.out.println("Fila con datos insuficientes, saltando...");
                    continue;
                }

                try {
                    String sku = data[0].trim();
                    double priceRetail = parseDoubleSafe(data[1].trim());
                    double priceCurrent = parseDoubleSafe(data[2].trim());
                    String productName = data[3].trim();
                    String category = data[4].trim();

                    // Solo insertamos productos válidos (con precios numéricos)
                    if (priceRetail >= 0 && priceCurrent >= 0) {
                        bst.insert(new Product(sku, priceRetail, priceCurrent, productName, category));
                    } else {
                        System.out.println("Fila con valores inválidos, saltando...");
                    }
                } catch (Exception e) {
                    System.out.println("Error procesando fila: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
    }

    private static double parseDoubleSafe(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return -1; // Retornamos un valor inválido para ignorarlo
        }
    }
}
