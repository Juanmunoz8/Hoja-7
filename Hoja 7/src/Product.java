public class Product implements Comparable<Product> {
    private String sku;
    private double priceRetail;
    private double priceCurrent;
    private String productName;
    private String category;

    public Product(String sku, double priceRetail, double priceCurrent, String productName, String category) {
        this.sku = sku;
        this.priceRetail = priceRetail;
        this.priceCurrent = priceCurrent;
        this.productName = productName;
        this.category = category;
    }

    public String getSku() { return sku; }
    public double getPriceRetail() { return priceRetail; }
    public double getPriceCurrent() { return priceCurrent; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public int compareTo(Product other) {
        return this.sku.trim().toLowerCase().compareTo(other.sku.trim().toLowerCase());
    }

    @Override
    public String toString() {
        return "SKU: " + sku + ", Price_Current: $" + priceCurrent + ", Price_Retail: $" + priceRetail +
               ", Name: " + productName + ", Category: " + category;
    }
}
