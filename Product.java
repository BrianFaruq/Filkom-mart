public abstract class Product {
    String productId;
    String name;
    double price; 
    int stockQuantity;
     public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    public Product() {
    }

    double calculateDiscount(){
        double discount =0;
        return discount;
    }

    String getProductInfo(){
        return productId + "\n" + name + "\n" + price + "\n" + stockQuantity;
    }
    
    void updateStock(int quantity){
        stockQuantity += quantity;
    }
    
    void updateStock(int quantity, String reason){

    }
}
