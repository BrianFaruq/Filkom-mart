public class ClothingProduct extends Product{
    //Atribut spesifik subclass ClothingProduct
    private String size;
    private String brand;


    public ClothingProduct(String productId, String name, double price, int stockQuantity, String size, String brand) {
        //super() digunakan untuk memanggil constructor dari superclass (Product) 
        //untuk menginisialisasi atribut yang diwarisi
        super(productId, name, price, stockQuantity);
        this.size = size;
        this.brand = brand;
    }
    @Override
    public double calculateDiscount() {
        //Pertama-tama, kita memeriksa ukuran pakaian apakah L atau XL, disini menggunakan ".equals()"
        //untuk membandingkan isi String. "||" berarti OR, jadi jika salah satu kondisi terpenuhi 
        //(antara "L" atau "XL") maka kondisi if sudah terpenuhi.
        if (size.equals("L") || size.equals("XL")) {
            return 0.15; 
        }
        return 0.0; //Jika ukuran tidak L atau XL, maka tidak ada diskon, sehingga mengembalikan 0.0.
    }
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

    //Getter dan setter untuk atribut spesifik subclass ini
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
