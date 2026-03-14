public class ClothingProduct extends Product{
    //Atribut tambahan untuk produk pakaian yang tidak ada di superclass Product
    private String size;
    private String brand;

    //Constructor yang menerima semua data untuk inisialisasi objek ClothingProduct
    public ClothingProduct(String productId, String name, double price, int stockQuantity, String size, String brand) {
        //super() digunakan untuk memanggil constructor dari superclass (Product) untuk menginisialisasi atribut yang diwarisi
        super(productId, name, price, stockQuantity);
        //Karena atribut size dan brand adalah atribut khusus yang dimiliki oleh ClothingProduct, maka diinisialisasi langsung di constructor ini
        this.size = size;
        this.brand = brand;
    }

    //@Override menandakan bahwa method ini akan menggantikan versi abstract method calculateDiscount() yang ada di superclass Product. Ini adalah implementasi diskon spesifik untuk produk pakaian.
    @Override
    public double calculateDiscount() {
        //Pertama-tama, kita memeriksa ukuran pakaian apakah L atau XL, disini menggunakan ".equals()" untuk membandingkan isi String (bukannya "==" yang membandingkan referensi objek). "||" berarti OR, jadi jika salah satu kondisi terpenuhi (antara "L" atau "XL") maka kondisi if sudah terpenuhi.
        if (size.equals("L") || size.equals("XL")) {
            return 0.15; 
        }
        return 0.0; //Jika ukuran tidak L atau XL, maka tidak ada diskon, sehingga mengembalikan 0.0.
    }

    //@Override ini digunakan untuk menggantikan getProductInfo() yang ada di Product, tujuannya untuk menambahkan informasi mengenai size dan brand yang tidak ada pada produk.
    @Override
    public void getProductInfo() {
        System.out.println("[Clothing Product]");
        //super.getProductInfo() digunakan untuk memanggil method getProductInfo() dari superclass Product,
        // sehingga informasi umum seperti ID, nama, harga, stok, diskon, dan harga akhir tetap ditampilkan.
        // Setelah itu, kita menambahkan informasi khusus untuk produk pakaian yaitu ukuran dan brand.
        super.getProductInfo();
        System.out.println("  Ukuran      : " + size);
        System.out.println("  Brand       : " + brand);
    }

    //Karena atribut lain di Product sudah punya getter dan setternya sendiri, maka saat ini hanya perlu membuat getter dan setter untuk atribut size dan brand yang merupakan atribut khusus di ClothingProduct
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
