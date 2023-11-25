import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class cobaDulu {

    private static Map<String, Integer> produkHarga = new HashMap<>();
    private static Map<String, Integer> keranjangBelanja = new HashMap<>();

    public static void main(String[] args) {
        // Inisialisasi data produk dan harga
        produkHarga.put("Produk A", 10);
        produkHarga.put("Produk B", 20);
        produkHarga.put("Produk C", 30);

        // Contoh penggunaan
        tambahProduk("Produk A", 2);
        tambahProduk("Produk B", 1);
        tambahProduk("Produk C", 3);

        cetakNota();
    }

    // Fungsi untuk menambah produk ke keranjang belanja
    private static void tambahProduk(String produk, int jumlah) {
        if (produkHarga.containsKey(produk)) {
            keranjangBelanja.put(produk, keranjangBelanja.getOrDefault(produk, 0) + jumlah);
            System.out.println(jumlah + " " + produk + " ditambahkan ke keranjang belanja.");
        } else {
            System.out.println("Produk tidak valid.");
        }
    }

    // Fungsi untuk menghitung total belanja
    private static int hitungTotalBelanja() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : keranjangBelanja.entrySet()) {
            String produk = entry.getKey();
            int jumlah = entry.getValue();
            total += produkHarga.get(produk) * jumlah;
        }
        return total;
    }

    // Fungsi untuk mencetak nota
    private static void cetakNota() {
        System.out.println("\n===== Nota Pembelian =====");
        for (Map.Entry<String, Integer> entry : keranjangBelanja.entrySet()) {
            String produk = entry.getKey();
            int jumlah = entry.getValue();
            System.out.println(produk + "\t\t" + jumlah + "\t\tRp " + produkHarga.get(produk) * jumlah);
        }
        System.out.println("=========================");
        System.out.println("Total Belanja:\t\t\t\tRp " + hitungTotalBelanja());
        System.out.println("=========================");
    }
}
    

