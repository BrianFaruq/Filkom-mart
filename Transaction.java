public class Transaction {
    
    // atribut untuk menyimpan id transaksi
    private String transactionId;
    
    // array untuk menyimpan produk yang dibeli dalam transaksi
    private Product[] items;
    
    // menghitung jumlah produk yang sudah dimasukkan ke transaksi
    private int totalItems;

    // constructor untuk membuat transaksi baru
    public Transaction(String transactionId) {
        // menyimpan id transaksi
        this.transactionId = transactionId;
        
        // membuat array produk dengan kapasitas maksimal 50 item
        this.items = new Product[50];
        
        // awalnya belum ada produk di transaksi
        this.totalItems = 0;
    }

    // method untuk menghitung total harga setelah diskon
    public double processSale(){
        // variabel untuk menyimpan total harga transaksi
        double total = 0;

        // loop semua produk yang ada di transaksi
        for(int i = 0; i < totalItems; i++){
            
            // mengambil produk dari array
            Product p = items[i];

            // menghitung diskon produk (method ini berasal dari subclass Product)
            double discount = p.calculateDiscount();
            
            // menghitung harga akhir setelah dikurangi diskon
            double finalPrice = p.getPrice() - (p.getPrice() * discount);

            // menambahkan harga produk ke total transaksi
            total += finalPrice;
        }

        // mengembalikan total harga semua produk
        return total;
    }

    // method untuk menambahkan satu produk ke transaksi
    public void addItem(Product item){
        
        // mengecek apakah array masih memiliki ruang
        if(totalItems < items.length){
            
            // memasukkan produk ke posisi array berikutnya
            items[totalItems] = item;
            
            // menambah jumlah item dalam transaksi
            totalItems++;
        }else{
            // pesan jika keranjang sudah penuh
            System.out.println("Keranjang penuh");
        }
    }

    // method overloading untuk menambahkan produk dalam jumlah tertentu
    public void addItem(Product item, int quantity){
        
        // menambahkan produk berulang sesuai jumlah quantity
        for(int i = 0; i < quantity; i++){
            addItem(item);
        }
    }
}
