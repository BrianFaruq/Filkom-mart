public class FoodProduct extends Product {
    private String expiryDate;

    @Override
    double calculateDiscount(){
        if (this.stockQuantity < 10) {
            return this.price * 0.1;
        }else{
            return 0;
        }
    }
}
