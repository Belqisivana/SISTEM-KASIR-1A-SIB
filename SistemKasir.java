import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SistemKasir {
    
    static String beliLagi, member, namaKasir, namaPelanggan, inputNamaBarang, targetBarang, namaBarangBaru, cariIndexBarang, SimpleDateFormat, s,  dateFormatetted;
    static int jmlBarang = 0, totalBayar = 0, stokBarangBaru, tambahStokBarang, metodePembayaran, hargaBarangBaru, menu;
    static double diskon = 0, bayar, total, tunai, kembalian, yangDibayarkan, totPendapatanHarian = 0, totPendapatanBulanan = 0;
    static boolean berhasilMasuk = false, barangSudahAda;
    static String user1 = "Renald", user2 = "Belqis", user3 = "Aqila", username, password,
            userPw1 = "Renald123", userPw2 = "Belqis123", userPw3 = "Aqila123"; 
   
    static String cetakNamaBarang [] = new String [100];
    static int cetakJmlBarang [] = new int[100];
    static double cetakHargaBarang [] = new double[100];
    static String namaBarang[] = new String [100];
    static int stokBarang [] = new int [100];
    static int hargaBarang[] = new int [100];

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        namaBarang[jmlBarang] = "Beras";
        stokBarang[jmlBarang] = 100;
        hargaBarang[jmlBarang] = 15000;
        jmlBarang++;
        namaBarang[jmlBarang] = "Minyak";
        stokBarang[jmlBarang] = 50;
        hargaBarang[jmlBarang] = 10000;
        jmlBarang++;
        namaBarang[jmlBarang] = "Gula";
        stokBarang[jmlBarang] = 80;
        hargaBarang[jmlBarang] = 12000;
        jmlBarang++;
        namaBarang[jmlBarang] = "Sabun";
        stokBarang[jmlBarang] = 120;
        hargaBarang[jmlBarang] = 5000;
        jmlBarang++;
        namaBarang[jmlBarang] = "Susu";
        stokBarang[jmlBarang] = 70;
        hargaBarang[jmlBarang] = 12000;
        jmlBarang++;

// Login kasir
    while (!berhasilMasuk) {
        System.out.println("=====================================");
        System.out.println("||                                 ||");
        System.out.println("||    SELAMAT DATANG DI BAR MART   ||");
        System.out.println("||                                 ||");
        System.out.println("=====================================");
        System.out.println("\n");
        System.out.println("*************************************");
        System.out.println("*                                   *");
        System.out.println("*              LOGIN KASIR          *");
        System.out.println("*                                   *");
        System.out.println("*************************************");
        System.out.print("Masukkan username : ");
        username = sc.next();
        System.out.print("Masukkan password : ");
        password = sc.next();
        if (username.equalsIgnoreCase(user1) && password.equals(userPw1)) {
            System.out.println("---------------------------");
            System.out.println("|   Selamat datang Renald  |");
            System.out.println("---------------------------");
            break;
        } else if (username.equalsIgnoreCase(user2) && password.equals(userPw2)) {
            System.out.println("---------------------------");
            System.out.println("|   Selamat datang Belqis  |");
            System.out.println("---------------------------");
            break;
        } else if (username.equalsIgnoreCase(user3) && password.equals(userPw3)) {
            System.out.println("---------------------------");
            System.out.println("|   Selamat datang Aqila  |");
            System.out.println("---------------------------");
            break;
        } else {
            System.out.println("---------------------------");
            System.out.println("|GAGAL MASUK DAN COBA LAGI!|");
            System.out.println("---------------------------");
            continue;
        }
    }

    do {
        System.out.println("--------------------------------------------------------");
        System.out.println("||                   PILIH MENU :                     ||");
        System.out.println("--------------------------------------------------------");
        System.out.println("||                  1. Transaksi                      ||");
        System.out.println("||                  2. Cetak Struk                    ||");
        System.out.println("||                  3. Update Stok Barang             ||");
        System.out.println("||                  4. Tambah Stok Barang             ||");
        System.out.println("||                  5. Tambah Barang Baru             ||");
        System.out.println("||                  6. Laporan Pendapatan             ||");
        System.out.println("||                  7. Exit                           ||");
        System.out.println("--------------------------------------------------------");
        System.out.print("Masukkan menu pilihan Anda (1/2/3/4/5/6/7) : ");
        menu = sc.nextInt();
        sc.nextLine();
            switch (menu) {
                case 1:
                    transaksi(sc);
                    break;
                case 2:
                    cetakStruk();
                    break;
                case 3:
                    daftarStokBarang();
                    break;
                case 4:
                    tambahStok(sc);
                    break;
                case 5:
                    tambahBarangBaru(sc);
                    break;
                case 6:
                    laporanPendapatan();
                    break;
            }
        } while (menu != 7);

        sc.close();
    }

    // Fungsi Transaksi
    private static void transaksi(Scanner sc) {
        System.out.println("Kasir: " + username);
        System.out.print("A/N: ");
        namaPelanggan = sc.nextLine();
        System.out.print("Tanggal transaksi : ");
        Date d = new Date();
        s ="dd-MM-yyyy";
        SimpleDateFormat sd = new SimpleDateFormat(s);

        dateFormatetted = sd.format(d);
        System.out.println(dateFormatetted);

        boolean beliBarang = true;
        while (beliBarang) {
            System.out.print("Masukkan nama barang: ");
            inputNamaBarang = sc.nextLine();
            // temukan indeks hargaBarang dari inputNamaBarang di Array
            int index = -1;
            for (int i = 0; i < namaBarang.length; i++) {
                if (inputNamaBarang.equalsIgnoreCase(namaBarang[i])) {
                    index = i;
                    break;
                }
            }
            // Apabila barang tidak ditemukan
            if (index == -1) {
                System.out.println("barang tidak ditemukan");
                continue;
            }
            System.out.println("Harga: " + hargaBarang[index]);
           
            if (index != -1) {
                System.out.print("Masukkan jumlah barang: ");
                jmlBarang = sc.nextInt();
                stokBarang[index] -= jmlBarang;
                System.out.print("Beli lagi (y/n)? ");
                beliLagi = sc.next();
                sc.nextLine();
                total = hargaBarang[index] * jmlBarang;
                totalBayar += total;
                if (beliLagi.equalsIgnoreCase("y")) {
                beliBarang = true;
            } else if (beliLagi.equalsIgnoreCase("n")) {
                beliBarang = false;
            }
            } else {
                System.out.println("Barang tidak ditemukan.");
            }

            
        }
        System.out.println("Total harga belanjaan anda Rp " + totalBayar);
        System.out.print("Apakah anda punya kartu member (ya atau tidak)? :");
        member = sc.nextLine();
        if (member.equals("ya")) {
            if (totalBayar >= 200000) {
                diskon = totalBayar * 0.15;
            } else {
                diskon = totalBayar * 0.10;
            }
            bayar = totalBayar - diskon;
            System.out.println("Diskon: Rp " + diskon);
            System.out.println("Total yang harus dibayar: Rp " + bayar);
            System.out.print("Tunai : ");
            yangDibayarkan = sc.nextDouble();
            kembalian = yangDibayarkan - bayar;
            System.out.println("Kembalian: " + kembalian);
        } else {
            if (totalBayar >= 300000) {
                diskon = totalBayar * 0.05;
                bayar = totalBayar - diskon;
                System.out.println("Hasil diskon " + diskon);
                System.out.println("Total yang harus dibayar: Rp " + bayar);
                System.out.print("Tunai : ");
                yangDibayarkan = sc.nextDouble();
                kembalian = yangDibayarkan - bayar;
                System.out.println("Kembalian: " + kembalian);
            } else if (totalBayar < 300000) {
                System.out.println("Tidak dapat diskon");
                System.out.print("Tunai : ");
                bayar = totalBayar;
                yangDibayarkan = sc.nextDouble();
                kembalian = yangDibayarkan - totalBayar;
                System.out.println("Kembalian: " + kembalian);
            }
        }

        totPendapatanHarian += totalBayar;
        totPendapatanBulanan += totPendapatanHarian;
        totPendapatanHarian = 0;
    }

    // Fungsi Cetak Struk
    private static void cetakStruk() {
        System.out.println("||===================================================||");
        System.out.println("||                    BAR MART                       ||");
        System.out.println("||                Struk Pembayaran                   ||");
        System.out.println("||===================================================||");
        System.out.println("  Kasir : " + username );
        System.out.println("  Nama Pelanggan : " + namaPelanggan );
        System.out.println("  Tanggal transaksi : " + dateFormatetted );
        // System.out.println( cetakNamaBarang [i]+ );  
        // System.out.println( + jmlBarang[index] + "\nx" + hargaBarang + "\n=" + total );
        System.out.println("-------------------------------------------------------");
        System.out.println("  Total Belanja                     Rp:" + totalBayar );
        System.out.println("  Diskon                            Rp:" + diskon );
        System.out.println("-------------------------------------------------------");
        System.out.println("  TOTAL                             Rp:" + bayar  );
        System.out.println("-------------------------------------------------------");
        System.out.println("  Tunai                             Rp:" + yangDibayarkan);
        System.out.println("  Kembalian                         Rp:" + kembalian);
        System.out.println("=======================================================");
    }

    // Fungsi Daftar Stok Barang
    private static void daftarStokBarang() {
         // Menampilkan daftar barang
         System.out.println("Daftar Barang:");
         System.out.println("--------------------------------------------");
         System.out.println("| No | Nama Barang |   Harga   |    Stok   |");
         System.out.println("--------------------------------------------");
         // code u/ kolom daftar
         for (int i = 0; i < jmlBarang; i++) {
             System.out.printf("| %-2d | %-12s | %-8d | %-9d |\n", i + 1, namaBarang[i],
             hargaBarang[i], stokBarang[i]);
         }
         System.out.println("--------------------------------------------");

    }

    // Fungsi Tambah Stok
    private static void tambahStok(Scanner sc) {
        System.out.print("Masukkan nama barang: ");
                    inputNamaBarang = sc.nextLine();
                    int index = -1;
                    for (int i = 0; i < namaBarang.length; i++) {
                        if (namaBarang[i].equalsIgnoreCase(inputNamaBarang)) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("Barang tidak ditemukan.");
                    } else {
                        System.out.println("Harga: " + hargaBarang[index]);

                        System.out.print("Masukkan jumlah barang yang akan ditambahkan ke stok: ");
                        int jumlahTambahStok = sc.nextInt();
                        stokBarang[index] += jumlahTambahStok;

                        System.out.println("---------------------------------------------------------------------------------");
                        System.out.println("Stok barang " + namaBarang[index] + " berhasil ditambahkan sebanyak "
                                + jumlahTambahStok + " unit.");
                        System.out.println("---------------------------------------------------------------------------------");
                    }
    }

    // Fungsi Tambah Barang Baru
    private static void tambahBarangBaru(Scanner sc) {
        boolean barangSudahAda;
                do {
                    System.out.print("Masukkan barang baru: ");
                    namaBarangBaru = sc.nextLine();
                    barangSudahAda = false; // Inisialisasi sebagai false di awal

                    // Pengecekan apakah barang sudah ada dalam array namaBarang
                    for (int i = 0; i < jmlBarang; i++) {
                        if (namaBarangBaru.equalsIgnoreCase(namaBarang[i])) {
                            System.out.println(namaBarangBaru + " sudah ada dalam daftar barang!");
                            barangSudahAda = true; // Jika barang sudah ada, ubah menjadi true
                            break; // Keluar dari loop segera setelah ditemukan barang yang sama
                        }
                    }

                    if (!barangSudahAda) {
                        System.out.print("Masukkan harga barang: ");
                        hargaBarangBaru = sc.nextInt();
                        System.out.print("Masukkan stok barang: ");
                        stokBarangBaru = sc.nextInt();
                        
                        if (jmlBarang < namaBarang.length && jmlBarang < stokBarang.length && jmlBarang < hargaBarang.length) {
                            namaBarang[jmlBarang] = namaBarangBaru;
                            stokBarang[jmlBarang] = stokBarangBaru;
                            hargaBarang[jmlBarang] = hargaBarangBaru;
                            jmlBarang++;
                            System.out.println("-------------------------------------------");
                            System.out.println(namaBarangBaru + " berhasil ditambahkan! ");
                            System.out.println("-------------------------------------------");
                            break;
                        } else {
                            System.out.println("Jumlah barang telah melebihi batas!");
                            break; // Keluar dari loop jika jumlah barang melebihi batas
                        }
                    }
                } while (true); // Loop terus sampai kondisi di dalamnya dihentikan dengan break
    }

    // Fungsi Laporan Pendapatan
    private static void laporanPendapatan() {
        System.out.println("Total Pendapatan Harian: Rp "  + totPendapatanHarian);
        System.out.println("Total Pendapatan Bulanan: Rp "  + totPendapatanBulanan);
    }
}
