import java.util.ArrayList;

public class Transaction {
    private String transactionId;
    private ArrayList<Product> items;

    // constructor untuk membuat transaksi
    public Transaction(String transactionId) {
        this.transactionId = transactionId;
        this.items = new ArrayList<>();
    }

    // menghitung total harga setelah diskon semua item
    public double processSale() {
        double total = 0;

        for (Product p : items) {
            double discount = p.calculateDiscount();
            double finalPrice = p.getPrice() - (p.getPrice() * discount);

            total += finalPrice;
        }

        return total;
    }

    // menambahkan satu produk ke transaksi
    public void addItem(Product item) {
        items.add(item);
    }

    // method overloading untuk menambahkan beberapa produk sekaligus
    public void addItem(Product item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(item);
        }
    }

    public ArrayList<Product> getItems(){
        return items;
    }
}