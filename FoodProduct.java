public class FoodProduct extends Product {
    //Atribut spesifik subclass FoodProduct
    private String expiryDate;

    //Constructor untuk membuat objek FoodProduct
    public FoodProduct(String productId, String name, double price, int stockQuantity, String expiryDate) {
        //super() digunakan untuk memanggil constructor dari superclass (Product)
        super(productId, name, price, stockQuantity);
        //Inisialisasi atribut spesifik FoodProduct
        this.expiryDate = expiryDate;
    }
    @Override
    //Implementasi method calculateDiscount() untuk FoodProduct.
    //Diskon 10% diberikan jika stok lebih dari 10. Jika tidak, tidak ada diskon.
    public double calculateDiscount() {
        if (getStockQuantity() > 10) {
            return 0.10; 
        }
        return 0.0;
    }

    @Override
    //Override method getProductInfo() dari superclass Product
    public void getProductInfo() {
        System.out.println("[Food Product]");
        //super.getProductInfo() digunakan untuk memanggil method getProductInfo() dari superclass Product,
        // sehingga informasi umum seperti ID, nama, harga, dan stok tetap ditampilkan.
        // Setelah itu, kita menambahkan informasi khusus untuk produk makanan yaitu tanggal kadaluarsa.
        super.getProductInfo();
        System.out.println("  Exp. Date   : " + expiryDate);
    }

    //Getter dan setter untuk atribut spesifik subclass ini
    public String getExpiryDate() {
        return expiryDate;
    }
 
     public void setExpiryDate(String expiry) {
         this.expiryDate = expiry;
     }
}