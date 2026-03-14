public class ElectronicProduct extends Product {
    //Atribut khusus miliki ElectronicProduct yaitu warrantyPeriod, tidak ada di superclass Product
    private String warrantyPeriod;

    //Constructor untuk inisialisasi atribut dari superclass Product
    public ElectronicProduct(String productId, String name, double price, int stockQuantity, String warrantyPeriod) {
        //super() memanggil constructor yang berparameter milik superclass Product untuk menginisialisasi atribut productId, name, price, dan stockQuantity
        super(productId, name, price, stockQuantity);
        //Atribut warrantyPeriod diinisialisasi dengan parameter yang diterima
        this.warrantyPeriod = warrantyPeriod;
    }

    //@Override menandakan bahwa method ini menggantikan versi abstract method di superclass Product
    @Override
    public double calculateDiscount() {
        //Ini menjadi dasar diskon untuk semua produk elektronik yaitu 5%
        double diskon = 0.05;
        //Jika kondisi memenuhi(yaitu harga produk lebih dari 500000) maka akan mendapatkan tambahan diskon sebesar 2%
        //getPrice() digunakan untuk mengakses atribut price yang ada di superclass Product, hal ini terjadi karena atribut price bersifat private sehingga tidak bisa diakses langsung dari subclass, harus melalui method getter yang disediakan di superclass
        if (getPrice() > 500000) {
            //+= berarti diskon = diskon + 0.02, jadi totalnya menjadi 0.07 (7%) jika kondisi terpenuhi
            diskon += 0.02;
        }
        //Nilai diskon akhir (0.05 atau 0.07) akan dikembalikan dalam bentuk desimal
        return diskon;
    }

    //@Override menandakan bahwa method ini menggantikan versi method getProductInfo() miliki superclass Product, hal ini bertujuan untuk menambahkan info garansi yang tidak ada pada superclass Product
    @Override
    public void getProductInfo() {
        System.out.println("[Electronic Product]");
        //super.getProductInfo() akan memanggil method getProductInfo() yang ada di superclass Product untuk menampilkan informasi umum produk seperti productId, name, price, dan stockQuantity
        super.getProductInfo();
        System.out.println("  Garansi     : " + warrantyPeriod);
    }

    //Karena warrantyPeriod adalah atribut khusus milik ElectronicProduct, maka kita buat getter dan setter untuk mengakses dan memodifikasi nilai warrantyPeriod
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warranty) {
        this.warrantyPeriod = warranty;
    }
}
