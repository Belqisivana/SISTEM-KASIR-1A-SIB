import java.util.Scanner;

public class SistemKasir {

    static String beliLagi, member, namaKasir, namaPelanggan, inputNamaBarang, targetBarang, namaBarangBaru,
            cariIndexBarang, SimpleDateFormat, s, dateFormatetted, masukkanUsername, masukkanPassword, akun, status;
    static int jmlBarang = 0, totalBayar = 0, stokBarangBaru, tambahStokBarang, metodePembayaran, hargaBarangBaru, menu,
            menuManager;
    static double diskon = 0, bayar, total, tunai, kembalian, yangDibayarkan, totPendapatanBulanan = 0;
    static boolean berhasilMasuk = false, barangSudahAda;

    static String username[] = { "Renald", "Belqis", "Aqila", "Manager" };
    static String password[] = { "Renald123", "Belqis123", "Aqila123", "Manager123" };
    static boolean berhasilLogin = false;
    static boolean isManager = false;

    static String cetakNamaBarang[] = new String[100];
    static int cetakJmlBarang[] = new int[100];
    static double cetakHargaBarang[] = new double[100];
    static String namaBarang[] = new String[100];
    static int stokBarang[] = new int[100];
    static int hargaBarang[] = new int[100];
    static String tanggal[] = new String[100];
    static int a = 0, b = 0, c, d;
    static int totPendapatanHarian[] = new int[100];
    static String namaBarangStruk[] = new String[5];
    static int hargaBarangStruk[] = new int[5];
    static double totalHargaBarangStruk[] = new double[5];
    static int jumlahbarangStruk[] = new int[5];

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
            System.out.println("*                LOGIN              *");
            System.out.println("*************************************");
            System.out.print("Masukkan username : ");
            masukkanUsername = sc.next();
            System.out.print("Masukkan password : ");
            masukkanPassword = sc.next();

            for (int i = 0; i < username.length; i++) {
                if (masukkanUsername.equalsIgnoreCase(username[i]) && masukkanPassword.equals(password[i])) {
                    System.out.println("============================");
                    System.out.println("| SELAMAT DATANG " + username[i] + " |");
                    System.out.println("============================");
                    berhasilLogin = true;
                    isManager = username[i].equalsIgnoreCase("Manager");
                    break;
                }
            }
            if (berhasilLogin) {
                break;
            } else {
                System.out.println("==============================");
                System.out.println("|    GAGAL MASUK. COBA LAGI  |");
                System.out.println("==============================");
            }
        }

        if (isManager) {
            int pilih;
            do {
                System.out.println("--------------------------------------------------------");
                System.out.println("||                 PILIH MENU MANAGER                 ||");
                System.out.println("--------------------------------------------------------");
                System.out.println("||                  1. Update Stok Barang             ||");
                System.out.println("||                  2. Laporan Pendapatan             ||");
                System.out.println("||                  3. Exit                           ||");
                System.out.println("--------------------------------------------------------");
                System.out.print("Masukkan menu pilihan Anda (1/2/3) : ");
                menuManager = sc.nextInt();
                switch (menuManager) {
                    case 1:
                        daftarStokBarang();
                        break;
                    case 2:
                        laporanPendapatan();
                        break;
                }
            } while (menuManager != 5);

            sc.close();
        } else {
            do {
                System.out.println("--------------------------------------------------------");
                System.out.println("||                   PILIH MENU :                     ||");
                System.out.println("--------------------------------------------------------");
                System.out.println("||                  1. Transaksi                      ||");
                System.out.println("||                  2. Cetak Struk Tunai              ||");
                System.out.println("||                  3. Cetak Struk Transfer           ||");
                System.out.println("||                  4. Update Stok Barang             ||");
                System.out.println("||                  5. Tambah Stok Barang             ||");
                System.out.println("||                  6. Tambah Barang Baru             ||");
                System.out.println("||                  7. Laporan Pendapatan             ||");
                System.out.println("||                  8. Exit                           ||");
                System.out.println("--------------------------------------------------------");
                System.out.print("Masukkan menu pilihan Anda (1/2/3/4/5/6/7) : ");
                menu = sc.nextInt();
                sc.nextLine();
                switch (menu) {
                    case 1:
                        transaksi();
                        break;
                    case 2:
                        cetakStrukTunai();
                        break;
                    case 3:
                        cetakStrukTransfer();
                        break;
                    case 4:
                        daftarStokBarang();
                    case 5:
                        tambahStok(sc);
                        break;
                    case 6:
                        tambahBarangBaru(sc);
                        break;
                    case 7:
                        laporanPendapatan();
                        break;
                }
            } while (menu != 7);

            sc.close();
        }
    }

    // Fungsi Transaksi
    public static void transaksi() {
        Scanner sc = new Scanner(System.in);
        c = 0;
        d = 0;
        totalBayar = 0;
        totPendapatanHarian[b] = 0;
        System.out.println("Kasir: " + masukkanUsername);
        System.out.print("A/N: ");
        namaPelanggan = sc.nextLine();
        System.out.print("Tanggal transaksi : ");
        tanggal[a] = sc.nextLine();
        boolean beliBarang = true;
        while (beliBarang) {
            System.out.print("Masukkan nama barang: ");
            inputNamaBarang = sc.nextLine();
            namaBarangStruk[c] = inputNamaBarang;
            c++;
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
            hargaBarangStruk[d] = hargaBarang[index];

            if (index != -1) {
                System.out.print("Masukkan jumlah barang: ");
                jmlBarang = sc.nextInt();
                stokBarang[index] -= jmlBarang;
                jumlahbarangStruk[d] = jmlBarang;
                System.out.print("Beli lagi (y/n)? ");
                beliLagi = sc.next();
                sc.nextLine();
                total = hargaBarang[index] * jmlBarang;
                totalHargaBarangStruk[d] = total;
                totalBayar += total;
                d++;
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
            System.out.println("Metode pembayaran");
            System.out.println("1. Tunai");
            System.out.println("2. Transfer bank BRI");
            System.out.print("Pilih metode pembayaran: ");
            int metode = sc.nextInt();
            if (metode == 1) {
                if (totalBayar >= 200000) {
                    diskon = totalBayar * 0.15;
                    bayar = totalBayar - diskon;
                    System.out.println("Hasil diskon " + diskon);

                    System.out.println("Total yang harus dibayar: Rp " + bayar);
                    do {
                        System.out.print("Tunai : ");
                        yangDibayarkan = sc.nextDouble();
                        if (yangDibayarkan < bayar) {
                            System.out.println("Uang anda tidak cukup. Silahkan masukkan jumlah uang yang mencukupi");
                        }
                    } while (yangDibayarkan < bayar);

                    kembalian = yangDibayarkan - bayar;
                    System.out.println("Kembalian: " + kembalian);
                } else if (totalBayar < 200000) {
                    System.out.println("Tidak dapat diskon");
                    do {
                        System.out.print("Tunai : ");
                        bayar = totalBayar;
                        yangDibayarkan = sc.nextDouble();
                        if (yangDibayarkan < bayar) {
                            System.out.println("Uang anda tidak cukup. Silahkan masukkan jumlah uang yang mencukupi");
                        }
                    } while (yangDibayarkan < bayar);
                    kembalian = yangDibayarkan - totalBayar;
                    System.out.println("Kembalian: " + kembalian);
                }
            } else if (metode == 2) {
                System.out.println("-----------------------------------------------------");
                System.out.println("||              Transfer bank BRI                  ||");
                System.out.println("-----------------------------------------------------");
                System.out.println("|| 2341760022----------Aqila Nur Azza              ||");
                System.out.println("|| 2341760075----------Belqis Ivana Fidelia Arfany ||");
                System.out.println("|| 2341760090----------Renald Agustinus            ||");
                System.out.println("-----------------------------------------------------");
                if (totalBayar >= 200000) {
                    diskon = totalBayar * 0.15;
                    bayar = totalBayar - diskon;
                    System.out.println("Hasil diskon " + diskon);
                } else if (totalBayar < 200000) {
                    System.out.println("Tidak dapat diskon");
                }
                bayar = totalBayar - diskon;
                System.out.println("Diskon: Rp " + diskon);
                System.out.println("Total yang harus dibayar: Rp " + bayar);

            }
        } else if (member.equals("tidak")) {
            System.out.println("Metode pembayaran");
            System.out.println("1. Tunai");
            System.out.println("2. Transfer bank BRI");
            System.out.print("Pilih metode pembayaran: ");
            int metode = sc.nextInt();
            if (metode == 1) {
                if (totalBayar >= 300000) {
                    diskon = totalBayar * 0.05;
                    bayar = totalBayar - diskon;
                    System.out.println("Hasil diskon " + diskon);

                    System.out.println("Total yang harus dibayar: Rp " + bayar);
                    do {
                        System.out.print("Tunai : ");
                        yangDibayarkan = sc.nextDouble();
                        if (yangDibayarkan < bayar) {
                            System.out.println("Uang anda tidak cukup. Silahkan masukkan jumlah uang yang mencukupi");
                        }
                    } while (yangDibayarkan < bayar);

                    kembalian = yangDibayarkan - bayar;
                    System.out.println("Kembalian: " + kembalian);
                } else if (totalBayar < 300000) {
                    System.out.println("Tidak dapat diskon");
                    do {
                        System.out.print("Tunai : ");
                        bayar = totalBayar;
                        yangDibayarkan = sc.nextDouble();
                        if (yangDibayarkan < bayar) {
                            System.out.println("Uang anda tidak cukup. Silahkan masukkan jumlah uang yang mencukupi");
                        }
                    } while (yangDibayarkan < bayar);
                    kembalian = yangDibayarkan - totalBayar;
                    System.out.println("Kembalian: " + kembalian);
                }
            } else if (metode == 2) {
                System.out.println("-----------------------------------------------------");
                System.out.println("||              Transfer bank BRI                  ||");
                System.out.println("-----------------------------------------------------");
                System.out.println("|| 2341760022----------Aqila Nur Azza              ||");
                System.out.println("|| 2341760075----------Belqis Ivana Fidelia Arfany ||");
                System.out.println("|| 2341760090----------Renald Agustinus            ||");
                System.out.println("-----------------------------------------------------");
                bayar = totalBayar - diskon;
                System.out.println("Diskon: Rp " + diskon);
                System.out.println("Total yang harus dibayar: Rp " + bayar);

            }

        }

        totPendapatanHarian[b] += totalBayar;
        totPendapatanBulanan += totPendapatanHarian[b];
        a++;
        b++;

    }

    // Fungsi Cetak Struk
    private static void cetakStrukTunai() {
        System.out.println("||===================================================||");
        System.out.println("||                    BAR MART                       ||");
        System.out.println("||                Struk Pembayaran                   ||");
        System.out.println("||   Jl. Soekarno Hatta No. 9 Kelurahan Jatimulyo,   ||");
        System.out.println("|| Kecamatan Lowokwaru, Kota Malang,Jawa Timur 65141 || ");
        System.out.println("||===================================================||");
        System.out.println("  Kasir : " + masukkanUsername);
        System.out.println("  Nama Pelanggan : " + namaPelanggan);
        System.out.println("  Tanggal transaksi : " + tanggal[a - 1]);
        System.out.println("  Nama Barang : ");
        for (int i = 0; i < c; i++) {
            System.out.print("  " + namaBarangStruk[i]);
            System.out.print(" " + hargaBarangStruk[i]);
            System.out.print(" X " + jumlahbarangStruk[i]);
            System.out.println(" total: " + totalHargaBarangStruk[i]);
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("  Total Belanja                     Rp:" + totalBayar);
        System.out.println("  Diskon                            Rp:" + diskon);
        System.out.println("-------------------------------------------------------");
        System.out.println("  TOTAL                             Rp:" + bayar);
        System.out.println("-------------------------------------------------------");
        System.out.println("  Tunai                             Rp:" + yangDibayarkan);
        System.out.println("  Kembalian                         Rp:" + kembalian);
        System.out.println("=======================================================");
        System.out.println("            TERIMAKASIH ATAS KUNJUNGANNYA              ");
        System.out.println("    BARANG YANG SUDAH DIBELI TIDAK DAPAT DIKEMBALIKAN  ");
        System.out.println("=======================================================");
    }

    // Cetak struk transfer
    private static void cetakStrukTransfer() {
        System.out.println("||===================================================||");
        System.out.println("||                    BAR MART                       ||");
        System.out.println("||                Struk Pembayaran                   ||");
        System.out.println("||   Jl. Soekarno Hatta No. 9 Kelurahan Jatimulyo,   ||");
        System.out.println("|| Kecamatan Lowokwaru, Kota Malang,Jawa Timur 65141 || ");
        System.out.println("||===================================================||");
        System.out.println("  Kasir : " + masukkanUsername);
        System.out.println("  Nama Pelanggan : " + namaPelanggan);
        System.out.println("  Tanggal transaksi : " + tanggal[a - 1]);
        System.out.println("  Nama Barang : ");
        for (int i = 0; i < c; i++) {
            System.out.print("  " + namaBarangStruk[i]);
            System.out.print(" " + hargaBarangStruk[i]);
            System.out.print(" X " + jumlahbarangStruk[i]);
            System.out.println(" total: " + totalHargaBarangStruk[i]);
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("  Total Belanja                     Rp:" + totalBayar);
        System.out.println("  Diskon                            Rp:" + diskon);
        System.out.println("-------------------------------------------------------");
        System.out.println("  TOTAL                             Rp:" + bayar);
        System.out.println("Transfer Bank BRI");
        System.out.println("BERHASIL");
        System.out.println("=======================================================");
        System.out.println("            TERIMAKASIH ATAS KUNJUNGANNYA              ");
        System.out.println("    BARANG YANG SUDAH DIBELI TIDAK DAPAT DIKEMBALIKAN  ");
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
    static void tambahStok(Scanner sc) {
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
            System.out.println("Stok barang " + namaBarang[index] + " berhasil ditambahkan sebanyak " + jumlahTambahStok + " unit.");
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
        for (int i = 0; i < a; i++) {
            System.out.print("Total Pendapatan tanggal " + tanggal[i] + " : ");
            System.out.println(totPendapatanHarian[i]);
        }
        System.out.println("Total Pendapatan Bulanan: Rp " + totPendapatanBulanan);
    }
}
