import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PruebasUnitarias {
    private BinarySearchTree<Product> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void testInsertProduct() {
        Product product = new Product("12345", 100.0, 80.0, "Laptop", "Electronics");
        bst.insert(product);

        Product found = bst.search(product);
        assertNotNull(found, "El producto debería estar en el árbol");
        assertEquals("12345", found.getSku(), "El SKU debería coincidir");
        assertEquals(80.0, found.getPriceCurrent(), "El precio actual debería ser 80.0");
    }

    @Test
    void testSearchProductBySKU() {
        Product product1 = new Product("A001", 200.0, 150.0, "Teclado", "Accesorios");
        Product product2 = new Product("A002", 50.0, 40.0, "Mouse", "Accesorios");

        bst.insert(product1);
        bst.insert(product2);

        Product found = bst.search(new Product("A002", 0, 0, "", ""));
        assertNotNull(found, "El producto con SKU A002 debería encontrarse");
        assertEquals("A002", found.getSku(), "El SKU debería ser A002");
        assertEquals(40.0, found.getPriceCurrent(), "El precio actual debería ser 40.0");
    }

    @Test
    void testSearchNonExistentProduct() {
        Product result = bst.search(new Product("99999", 0, 0, "", ""));
        assertNull(result, "No debería encontrar un producto inexistente");
    }
}

