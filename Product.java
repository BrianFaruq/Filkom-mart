public abstract class Product {
        //Atribut-atribut ini ditulis sebagai private agar hanya bisa diakses melalui method getter dan setter, sehingga data produk lebih aman dan terkontrol.
        private String productId;
        private String name;
        private double price;
        private int stockQuantity;
    
        //Constructor default yang akan dipanggil saat membuat objek tanpa paramater (Gunanya buat memberikan nilai default untuk setiap atribut produk).
        public Product() {
            this.productId = "000";
            this.name = "Unknown";
            this.price = 0;
            this.stockQuantity = 0;
        }
    
        //Constructor dengan parameter yang akan dipanggil saat membuat objek dengan nilai langsung (Jadi nanti nilai yang dikirim dari subclass via super() bakal masuk ke parameter ini, terus di assign ke atribut produk).
        public Product(String productId, String name, double price, int stockQuantity) {
            this.productId = productId;
            this.name = name;
            this.price = price;
            this.stockQuantity = stockQuantity;
        }
    
        //Method abstract, kenapa pake abstract? karena setiap jenis produk punya cara perhitungan diskon yang berbeda-beda, jadi method ini dijadikan abstract dan akan di override di setiap subclassnya sesuai dengan aturan diskon masing-masing produk.
        public abstract double calculateDiscount();
    
        //Method buat nampilin informasi produk, termasuk harga akhir setelah diskon. Masih bisa di-override di subclass kalau mau nambahin informasi khusus buat jenis produk tertentu.
        public void getProductInfo() {
            //Mengubah diskon dari bentuk desimal (misalnya 0.1) ke bentuk persentase (misalnya 10%) dengan cara mengalikan hasil dari calculateDiscount() dengan 100. Jadi nanti yang ditampilkan di informasi produk itu diskon dalam bentuk persentase, biar lebih mudah dipahami sama pelanggan.
            double diskon = calculateDiscount() * 100;
            //Harga akhir dihitung dengan mengurangi harga asli dengan diskon yang sudah dihitung sebelumnya. Jadi nanti harga akhir yang ditampilkan udah termasuk diskon.
            double hargaAkhir = price - (price * calculateDiscount());
            System.out.println("  ID          : " + productId);
            System.out.println("  Nama        : " + name);
            System.out.println("  Harga       : Rp " + price);
            System.out.println("  Stok        : " + stockQuantity + " unit");
            System.out.printf("  Diskon      : %.2f %% \n" , diskon );
            System.out.println("  Harga Akhir : Rp " + hargaAkhir);
        }
    
        //Method overloading buat ngupdate stok produk tanpa keterangan alasan. Bisa dipakai buat nambahin stok baru atau ngurangin stok yang udah ada, tergantung nilai quantity yang dikirim (positif buat nambah, negatif buat ngurang).
        public void updateStock(int quantity) {
            this.stockQuantity += quantity;
            System.out.println("Stok " + name + " diperbarui. Stok sekarang: " + stockQuantity);
        }
    
        //Method overloading buat ngupdate stok produk dengan keterangan alasan. Jadi selain ngupdate stok, kita juga bisa ngasih tau kenapa stoknya berubah, misalnya karena penjualan, restock, atau retur produk.
        public void updateStock(int quantity, String reason) {
            this.stockQuantity += quantity;
            System.out.println("Stok " + name + " diperbarui (" + reason + "). Stok sekarang: " + stockQuantity);
        }
    
        //Area getter & setter buat setiap atribut produk, jadi kita bisa mengakses dan memodifikasi data produk dengan cara yang lebih aman dan terkontrol.
        public String getProductId() {
            return productId;
        }
    
        public void setProductId(String id) {
            this.productId = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public double getPrice() {
            return price;
        }
    
        public void setPrice(double price) {
            this.price = price;
        }
    
        public int getStockQuantity() {
            return stockQuantity;
        }
    
        public void setStockQuantity(int qty) {
            this.stockQuantity = qty;
            
        }
}