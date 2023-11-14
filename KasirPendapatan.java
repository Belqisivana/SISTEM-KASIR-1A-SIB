import java.util.Scanner;
public class KasirPendapatan {
    public static void main(String[] args) {
        Scanner kasir = new Scanner(System.in);

        //inisiasi variabel
        int jumlahHari, jmlTransaksi;
        double totPendapatanHarian = 0, totPendapatanBulanan = 0;

        // Input jumlah hari dalam sebulan
        System.out.print("Masukkan jumlah hari dalam sebulan: ");
        jumlahHari = kasir.nextInt();


        // Perulangan untuk setiap hari dalam sebulan
        for (int hari = 1; hari <= jumlahHari; hari++) {
            System.out.println("\nHari ke-" + hari);

            // Input jumlah transaksi harian
            System.out.print("Masukkan jumlah transaksi harian: ");
            jmlTransaksi = kasir.nextInt();


                //perulangan untuk traksaksi harian
                for (int i = 1; i < jmlTransaksi; i++) {
                    System.out.println("Transaksi ke-" +i);

                    //input jumlah barang belanjaan
                    System.out.print("Masukkan jumlah barang belanjaan : ");
                    int jumlahBarang = kasir.nextInt();

                    double totalHarga = 0;


                    //perulangan setiap barang belanja
                    for (int j =1; j <= jumlahBarang; j++) {
                        System.out.println("\nBarang ke- " +j);

                        //input nama barang 
                        System.out.print("Masukkan nama barang : ");
                        String namaBarang = kasir.next();

                        //input harga barang
                        System.out.print("Masukkan harga barang : ");
                        double hargaBarang = kasir.nextDouble();

                        //input jumlah Barang
                        System.out.print("Masukkan jumlah barang : ");
                        int jumlah = kasir.nextInt();

                        //Menghitung total harga untuk barang tertentu
                        double totalBarang = hargaBarang * jumlah;

                        //Menambahkan totalBarang ke totalHarga transaksi
                        totalHarga += totalBarang;
                }

                // Menambahkan totalHarga transaksi ke totalPendapatan
                totPendapatanHarian += totalHarga;

                // Menampilkan totalHarga Transaksi
                System.out.println("Total harga transaksi ke-" + i + ": Rp " + totalHarga);
            
                }

                // Menambahkan totalPendapatan harian ke totalPendapatan bulanan
                totPendapatanBulanan += totPendapatanHarian;

                // Luaran total pendapatan harian
                System.out.println("Total Pendapatan harian : Rp " + totPendapatanHarian);

            }

            // Output total pendapatan bulanan
            System.out.println("\nTotal Pendapatan Bulanan: Rp " + totPendapatanBulanan);

        //tutup scanner
        kasir.close();
        }
}
