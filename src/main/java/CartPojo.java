public class CartPojo {

    public String productName;
    public double totalCost;
    public int quantity;

    public CartPojo(String productName, double totalCost, int quantity) {
        this.productName = productName;
        this.totalCost = totalCost;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
