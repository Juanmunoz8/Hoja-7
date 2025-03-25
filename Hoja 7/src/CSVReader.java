import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    public static void loadProducts(String filePath, BinarySearchTree<Product> bst) {
        int filasInsuficientes = 0;
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.nextLine(); // Saltar encabezado
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");

                // Validar que la fila tenga suficientes valores esperados
                if (data.length < 19) {
                    filasInsuficientes++;
                    continue;
                }

                try {
                    String sku = data[6].trim();
                    double priceRetail = parseDoubleSafe(data[9].trim());
                    double priceCurrent = parseDoubleSafe(data[10].trim());
                    String productName = data[18].trim();
                    String category = data[0].trim();

                    // Validar que SKU no esté vacío
                    if (!sku.isEmpty() && priceRetail >= 0 && priceCurrent >= 0) {
                        Product product = new Product(sku, priceRetail, priceCurrent, productName, category);
                        bst.insert(product);
                    }
                } catch (Exception e) {
                    System.out.println("Error procesando fila: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        }
        
        if (filasInsuficientes > 0) {
            System.out.println("Filas insuficientes encontradas y omitidas: " + filasInsuficientes);
        }
    }

    private static double parseDoubleSafe(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0; // Retornamos un valor por defecto válido en vez de -1
        }
    }
}

