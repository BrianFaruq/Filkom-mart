public class ElectronicProduct extends Product {
    private String warrantyPeriod;

    @Override
    double calculateDiscount(){
        if (this.price >500_000){
            return (this.price * 0.05 + this.price * 0.95*0.02);
        }else{
            return 0;
        }
    }
}
