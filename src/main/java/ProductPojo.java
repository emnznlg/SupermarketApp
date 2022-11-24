public class ProductPojo {
    public String name;
    public double price;
    public String category;
    public int stockCount;
    private int productID;

    public ProductPojo(String name, double price, String category, int stockCount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockCount = stockCount;
        this.productID = (int) (Math.random() * 10000);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
       this.productID = productID;
    }

    @Override
    public String toString() {
        return "Product ID: " + getProductID() +
                " Name: " + name +
                " Price: " + price +
                " Category: " + category +
                " Stock Count: " + stockCount;
    }
}
