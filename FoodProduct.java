public class FoodProduct extends Product {
     //Ini merupakan atribut tambahan yang khusus dimiliki oleh FoodProduct, yang tentunya tidak dimiliki oleh superclass Product.
     private String expiryDate;

     //Constructor untuk menginisialisasi atribut-atribut yang diwarisi dari superclass Product
     public FoodProduct(String productId, String name, double price, int stockQuantity, String expiryDate) {
         //super() digunakan untuk memanggil constructor dari superclass Product
         // agar atribut-atribut yang diwarisi dapat diinisialisasi dengan benar.
         super(productId, name, price, stockQuantity);
         //Atribut expiryDate diinisialisasi dengan nilai yang diberikan saat
         // pembuatan objek FoodProduct.
         this.expiryDate = expiryDate;
     }
     @Override
     public double calculateDiscount() {
         //Logika untuk menghitung diskon berdasarkan jumlah stok, jika stok lebih dari 10 maka diskon 10%, jika tidak maka tidak ada diskon.
         //getStockQuantity() adalah method yang diwarisi dari superclass Product yang digunakan untuk mendapatkan nilai stockQuantity dari superclass Product karena stockQuantity bersifat private sehingga tidak bisa diakses langsung.
         if (getStockQuantity() > 10) {
             return 0.10; 
         }
         return 0.0;
     }
 
     //@Override menandakan bahwa method getProductInfo() ini merupakan implementasi khusus untuk FoodProduct yang menggantikan implementasi default yang mungkin ada di superclass Product.
     @Override
     public void getProductInfo() {
         System.out.println("[Food Product]");
         //super.getProductInfo() digunakan untuk memanggil method getProductInfo() dari superclass Product agar informasi umum tentang produk (seperti productId, name, price, stockQuantity) dapat ditampilkan.
         super.getProductInfo();
         //Lalu di bawahnya ditambahkan informasi khusus untuk FoodProduct, yaitu expiryDate, yang menunjukkan tanggal kedaluwarsa produk makanan tersebut.
         System.out.println("  Exp. Date   : " + expiryDate);
     }
 
     //Getter & Setter untuk atribut expiryDate, yang memungkinkan kita untuk mendapatkan dan mengubah nilai expiryDate setelah objek FoodProduct dibuat.
     public String getExpiryDate() {
         return expiryDate;
     }
 
     public void setExpiryDate(String expiry) {
         this.expiryDate = expiry;
     }
}
