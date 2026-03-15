import java.util.ArrayList;

public class ShopManagementSystem {

    public static void main(String[] args) {

        ArrayList<Product> shop = new ArrayList<>();

        // Products Declaration
        shop.add(new FoodProduct("001", "Indomie", 4_000, 100, "2027-12-31"));
        shop.add(new FoodProduct("002", "Sari Roti", 12_000, 9, "2026-03-31"));
        shop.add(new ElectronicProduct("003", "Lampu LED", 12_000, 10, "2027-06-30"));
        shop.add(new ElectronicProduct("004", "Gergaji mesin", 3_000_000, 7, "2027-06-30"));
        shop.add(new ClothingProduct("005", "Sweater", 120_000, 50, "L", "Louis Vuitton"));
        shop.add(new ClothingProduct("006", "Cardigan", 90_000, 20, "M", "Channel"));
              /**
         * Membuat 2 contoh objek Transaksi untuk mensimulasikan 2 sesi pembelian
         */
              Transaction t1 = new Transaction("T01");
              Transaction t2 = new Transaction("T02");
      
              /**
               * Penambahan produk beserta kuantitasnya ke transaksi t1
               */
              t1.addItem(shop.get(0),3);
              t1.addItem(shop.get(1),1);
              t1.addItem(shop.get(2),5);
      
              /**
               * Penambahan produk beserta kuantitasnya ke transaksi t2
               */
              t2.addItem(shop.get(3),2);
              t2.addItem(shop.get(4),1);
              t2.addItem(shop.get(5),3);
      
              /**
               * Perhitungan total penjualan dari kedua transaksi
               * dengan mengaggregasikan processSale() dari kedua objek
               */
              System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
              double totalSales = t1.processSale() + t2.processSale();
              System.out.println("Transaction 1:");
                t1.printTransactionDetail();
              System.out.println("----------------------------------");
               System.out.println("Transaction 2:");
                t2.printTransactionDetail();
              System.out.println("----------------------------------");
              System.out.println("Total Sales: Rp " + totalSales);
            
              for (Product p : shop) {
                  p.getProductInfo();
              }
      
              /**
               * Menghitung sales terbanyak dengan menghitung frekuensi
               * munculnya itemn di kedua transaksi
               */
              int[] count = new int[shop.size()];
      
              for(Product p : t1.getItems()){
                  for(int i=0;i<shop.size();i++){
                      if(p == shop.get(i)) count[i]++;
                  }
              }
      
              for(Product p : t2.getItems()){
                  for(int i=0;i<shop.size();i++){
                      if(p == shop.get(i)) count[i]++;
                  }
              }
      
              /**
               * Men-assign maxIndex dengan index item yang memiliki
               * frekuensi penjualan tertinggi
               */
              int maxIndex = 0;
              for(int i=1;i<count.length;i++){
                  if(count[i] > count[maxIndex]){
                      maxIndex = i;
                  }
              }
      
              /**
               * Mencetak nama item yang memiliki frekuensi penjualan tertinggi
               */
              System.out.println("Best Selling Product: " + shop.get(maxIndex).getName());
          }
    }
