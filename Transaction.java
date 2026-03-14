public class Transaction {
    private String transactionId;
    private Product[] items;
    private int totalItems;

    // constructor untuk membuat transaksi
    public Transaction(String transactionId) {
        this.transactionId = transactionId;
        this.items = new Product[50];
        this.totalItems = 0;
    }

    // menghitung total harga setelah diskon semua item
    public double processSale() {
        double total = 0;

        for (int i = 0; i < totalItems; i++) {
            Product p = items[i];

            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() - (p.getPrice() * discount);

            total += finalPrice;
        }

        return total;
    }

    // menambahkan satu produk ke transaksi
    public void addItem(Product item) {
        if (totalItems < items.length) {
            items[totalItems] = item;
            totalItems++;
        } else {
            System.out.println("Keranjang penuh");
        }
    }

    // method overloading untuk menambahkan beberapa produk sekaligus
    public void addItem(Product item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addItem(item);
        }
    }
}
