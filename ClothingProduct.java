public class ClothingProduct extends Product{
    private String size;
    private String brand;

    @Override
    double calculateDiscount(){
        if (this.size == "XL" || this.size == "L"){
            return this.price * 0.15;
        }else{
            return 0;
        }
    }
}
