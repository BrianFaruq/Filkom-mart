import java.util.ArrayList;
/**
 * Kelas Transaction merepresentasikan sebuah transaksi pembelian yang berisi daftar produk yang dibeli.
 * Setiap transaksi memiliki ID unik dan dapat menyimpan beberapa produk.
 */
public class Transaction {
    // Atribut untuk menyimpan ID unik transaksi
    private final String transactionId;
    // Atribut untuk menyimpan daftar produk yang termasuk dalam transaksi
    private ArrayList<Product> items;

    /**
     * Constructor untuk membuat objek Transaction baru.
     * Menginisialisasi ID transaksi dan membuat ArrayList kosong untuk menyimpan produk.
     */
    public Transaction(String transactionId) {
        this.transactionId = transactionId;
        this.items = new ArrayList<>();
    }

    /**
     * Menghitung total harga dari semua produk dalam transaksi setelah memperhitungkan diskon.
     * Iterasi melalui setiap produk, menghitung harga akhir setelah diskon, dan dijumlahkan.
     */
    public double processSale() {
        double total = 0;

        // Iterasi melalui setiap produk dalam daftar items
        for (Product p : items) {
            // Menghitung diskon yang berlaku untuk produk saat ini
            double discount = p.calculateDiscount();
            // Menghitung harga akhir produk setelah diskon
            double finalPrice = p.getPrice() - (p.getPrice() * discount);

            // Menambahkan harga akhir ke total transaksi
            total += finalPrice;
        }

        return total;
    }

    /**
     * Menambahkan satu produk ke dalam transaksi.
     * Produk akan ditambahkan ke ArrayList items dan kuantitas beli produk akan diatur ke 1.
     */
    public void addItem(Product item) {
        items.add(item);
        // Mengatur kuantitas produk yang dibeli menjadi 1
        items.get(items.size() - 1).boughtQuantity(1);
    }

    /**
     * Overload method addItem untuk menambahkan beberapa produk sekaligus ke dalam transaksi.
     * Produk akan ditambahkan sebanyak 'quantity' kali ke ArrayList items.
     */
    public void addItem(Product item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
            // Mengatur kuantitas produk yang dibeli menjadi 1 untuk setiap item yang ditambahkan
            items.get(items.size() - 1).boughtQuantity(1);
        }
    }

    /**
     * Mengembalikan daftar semua produk yang ada dalam transaksi.
     */
    public ArrayList<Product> getItems(){
        return items;
    }

    /**
     * Mencetak detail transaksi, termasuk nama produk, jumlah, diskon, dan total keseluruhan.
     * Metode ini menghitung jumlah setiap produk unik dan menampilkan informasinya.
     */
    public void printTransactionDetail() {
        // ArrayList untuk melacak produk yang sudah dihitung agar tidak mencetak duplikat
        ArrayList<Product> counted = new ArrayList<>();
        // Loop melalui setiap produk dalam transaksi
        for (Product p : items) {
            // Jika produk sudah dihitung, lewati
            if (counted.contains(p)) {
                continue;
            }
            int quantity = 0;
            // Hitung berapa kali produk ini muncul dalam transaksi
            for (Product q : items) {
                if (q == p) {
                    quantity++;
                }
            }
            // Hitung diskon dalam persentase
            double discount = p.calculateDiscount() * 100;
            System.out.println(
                p.getName() +
                " | Jumlah: " + quantity +
                " | Discount: " + discount + "%"
            );
            // Tambahkan produk ke daftar yang sudah dihitung
            counted.add(p);
        }
    
        // Mencetak total harga keseluruhan transaksi
        System.out.println("Total: Rp " + processSale());
    }
}