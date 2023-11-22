import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class SistemKasir {
    /**
     * @param args
     */
    static String beliLagi;
    static String member, tgl, namaKasir, namaPelanggan, inputNamaBarang;
    static int jmlBarang, totalBayar = 0;
    static double diskon, bayar, total, tunai, kembalian;
    static String user1 = "Renald", user2 = "Belqis", user3 = "Aqila", username, password,
            userPw1 = "Renald123", userPw2 = "Belqis123", userPw3 = "Aqila123";
    static String[] namaBarang = { "Beras", "Minyak", "Gula", "Sabun", "Susu" };
    static int[] hargaBarang = { 15000, 10000, 12000, 5000, 12000 };
    static int[] stokBarang = { 100, 50, 80, 120, 70 };
    static String barang[][] = new String[100][3];
    static int menu;
    static boolean berhasilMasuk = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Login kasir
        while (!berhasilMasuk) {
             System.out.println("*********************");
             System.out.println("*                   *");
             System.out.println("*    Login Kasir    *");
             System.out.println("*                   *");
             System.out.println("*********************");
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
            System.out.println("||                  3. Update stok Barang             ||");
            System.out.println("||                  4. Tambah stok                    ||");
            System.out.println("||                  5. Laporan Pendapatan             ||");
            System.out.println("||                  6. Exit                           ||");
            System.out.println("--------------------------------------------------------");
            System.out.print("Masukkan pilihan Anda : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1: // transaksi
                    System.out.println("Kasir: " + username);
                    System.out.print("A/N: ");
                    namaPelanggan = sc.nextLine();
                    System.out.print("Masukkan tanggal transaksi : ");
                    tgl = sc.nextLine();
                    boolean beliBarang = true;
                    while (beliBarang) {
                        System.out.print("Masukkan nama barang: ");
                        inputNamaBarang = sc.nextLine();
                        // temukan indeks hargaBarang dari inputNamaBarang di Array
                        int index = -1;
                        for (int i = 0; i < namaBarang.length; i++) {
                            if (namaBarang[i].equalsIgnoreCase(inputNamaBarang)) {
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
                        } else {
                            System.out.println("Barang tidak ditemukan.");
                        }

                        if (beliLagi.equalsIgnoreCase("y")) {
                            beliBarang = true;
                        } else if (beliLagi.equalsIgnoreCase("n")) {
                            beliBarang = false;
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

                    } else {
                        if (totalBayar >= 300000) {
                            diskon = totalBayar * 0.05;
                            bayar = totalBayar - diskon;
                            System.out.println("Hasil diskon " + diskon);
                            System.out.println("Total yang harus dibayar: Rp " + bayar);
                        } else {
                            System.out.println("Tidak dapat diskon");
                        }
                    }
                    break;
                case 2: // Cetak Struk
                    System.out.println("||===================================================||");
                    System.out.println("||                    BAR MART                       ||");
                    System.out.println("||                Struk Pembayaran                   ||");
                    System.out.println("||===================================================||");
                    System.out.println("||Kasir : " + username + "||");
                    System.out.println("||Nama Pelanggan : " + namaPelanggan + "||");
                    System.out.println("||Tanggal transaksi : " + tgl + "||");
                    // System.out.println("||" +namaBarang[i]+ "||");
                    System.out.println("||" + jmlBarang + "\nx" + hargaBarang + "\n=" + total + "||");
                    System.out.println("-----------------------------------------------------||");
                    System.out.println("||Total Belanja                     Rp:" + totalBayar + "||");
                    System.out.println("||Diskon                            Rp:" + diskon + "||");
                    System.out.println("||---------------------------------------------------||");
                    System.out.println("||TOTAL                             Rp:" + bayar + "||");
                    System.out.println("||---------------------------------------------------||");
                    System.out.println("||Tunai                              Rp:" + tunai + "||");
                    System.out.println("||Kembalian                        Rp:" + kembalian + "||");
                    System.out.println("||===================================================||");

                case 3: // Daftar stok Barang

                    // Menampilkan daftar barang
                    System.out.println("Daftar Barang:");
                    System.out.println("--------------------------------------------");
                    System.out.println("| No | Nama Barang |   Harga   |    Stok   |");
                    System.out.println("--------------------------------------------");
                    // code u/ kolom daftar
                    for (int i = 0; i < namaBarang.length; i++) {
                        System.out.printf("| %-2d | %-12s | %-8d | %-9d |\n", i + 1, namaBarang[i], hargaBarang[i],
                                stokBarang[i]);
                    }
                    System.out.println("--------------------------------------------");

                    break;
                case 4: //Tambah Stok 
                System.out.print("Masukkan nama barang: ");
                        inputNamaBarang = sc.nextLine();
                        // temukan indeks hargaBarang dari inputNamaBarang di Array
                        int index = -1;
                        for (int i = 0; i < namaBarang.length; i++) {
                            if (namaBarang[i].equalsIgnoreCase(inputNamaBarang)) {
                                index = i;
                                break;
                            }
                        }
                        // Apabila barang tidak ditemukan
                        if (index == -1) {
                            barang[jmlBarang][0] = inputNamaBarang;
                            barang[jmlBarang][1]= Double.toString(hargaBarang);
                            barang[jmlBarang][2]= Integer.toString(stokBarang);
                            jmlBarang++;
                            continue;
                        }
                        System.out.println("Harga: " + hargaBarang[index]);

                        if (index != -1) {
                            System.out.print("Masukkan jumlah barang: ");
                            jmlBarang = sc.nextInt();
                            stokBarang[index] += jmlBarang;
                        }
            }
        } while (menu != 6);

        sc.close(); // Close the scanner to prevent resource leak
}
}
    