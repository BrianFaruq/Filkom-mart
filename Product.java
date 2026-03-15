public abstract class Product {
        private String productId;
        private String name;
        private double price;
        private int stockQuantity;
    
        /**
         * Constructor default diisi kosong karena object construct
         * tidak memungkinkan tanpa penambahan identitas produk
         */
        public Product() {
            this.productId = "000";
            this.name = "Unknown";
            this.price = 0;
            this.stockQuantity = 0;
        }
        public Product(String productId, String name, double price, int stockQuantity) {
            this.productId = productId;
            this.name = name;
            this.price = price;
            this.stockQuantity = stockQuantity;
        }
    
        /**
         * Method abstract untuk mengakomodasi perbedaan sistem
         * perhitungan diskon yang berbeda-beda untuk tiap produk
         */
        public abstract double calculateDiscount();
    
        /*
         * Method untuk menampilkan detail dari produk.
         * Beberapa informasi ter-override di subclass lain untuk 
         * menampilkan informasi spesifik dari produk tersebut.
         */
        public void getProductInfo() {
        //Diskon dikalikan dengan 100 untuk mengubahnya ke bentuk persentase
            double diskon = calculateDiscount() * 100;
            double hargaAkhir = price - (price * calculateDiscount());
            System.out.println("  ID          : " + productId);
            System.out.println("  Nama        : " + name);
            System.out.println("  Harga       : Rp " + price);
            System.out.println("  Stok        : " + stockQuantity + " unit");
            System.out.printf("  Diskon      : %.2f %% \n" , diskon );
            System.out.println("  Harga Akhir : Rp " + hargaAkhir);
        }
    
        /*
         * Method mutator untuk mengubah jumlah stok produk dari sisi management
         */
        public void updateStock(int quantity) {
            this.stockQuantity += quantity;
            System.out.println("Stok " + name + " diperbarui. Stok sekarang: " + stockQuantity);
        }
    
        /*
         * Method overload untuk menambahkan alasan perubahan jumlah stok
         */
        public void updateStock(int quantity, String reason) {
            this.stockQuantity += quantity;
            System.out.println("Stok " + name + " diperbarui (" + reason + "). Stok sekarang: " + stockQuantity);
        }
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
        /*
         * Method mutator untuk mengurangi jumlah stok produk sesuai dengan quantitas 
         * yang dibeli oleh customer
         */
        public void boughtQuantity(int qty){
            this.stockQuantity -= qty;
        }
}