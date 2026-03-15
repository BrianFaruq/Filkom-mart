public class ElectronicProduct extends Product {
    //Atribut spesifik subclass ElectronicProduct
    private String warrantyPeriod;

    //Constructor untuk membuat objek ElectronicProduct
    public ElectronicProduct(String productId, String name, double price, int stockQuantity, String warrantyPeriod) {
        //super() digunakan untuk memanggil constructor dari superclass (Product)
        super(productId, name, price, stockQuantity);
        //Inisialisasi atribut spesifik ElectronicProduct
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    //Implementasi method calculateDiscount() untuk ElectronicProduct.
    //Diskon dasar 5%, ditambah 2% jika harga produk di atas 500.000.
    public double calculateDiscount() {
        double diskon = 0.05;
        if (getPrice() > 500000) {
            diskon += 0.02;
        }
        return diskon;
    }

    @Override
    //Override method getProductInfo() dari superclass Product
    public void getProductInfo() {
        System.out.println("[Electronic Product]");
        //super.getProductInfo() digunakan untuk memanggil method getProductInfo() dari superclass Product,
        // sehingga informasi umum seperti ID, nama, harga, dan stok tetap ditampilkan.
        // Setelah itu, kita menambahkan informasi khusus untuk produk elektronik yaitu periode garansi.
        super.getProductInfo();
        System.out.println("  Garansi     : " + warrantyPeriod);
    }

    //Getter dan setter untuk atribut spesifik subclass ini
    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warranty) {
        this.warrantyPeriod = warranty;
    }
}