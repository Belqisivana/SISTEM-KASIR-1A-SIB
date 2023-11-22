import java.util.Scanner;

public class kasirLagi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;
        boolean berhasilMasuk = false;

        while (!berhasilMasuk) {
            System.out.println("*****Login Kasir*****");
            System.out.println("*********************");
            String user1 = "Renald", user2 = "Belqis", user3 = "Aqila", username, password,
                    userPw1 = "Renald123", userPw2 = "Belqis123", userPw3 = "Aqila123";
            System.out.print("Masukkan username : ");
            username = sc.next();
            System.out.print("Masukkan password : ");
            password = sc.next();
            if (username.equalsIgnoreCase(user1) && password.equals(userPw1)) {
                System.out.println("Selamat datang Renald");
                break;
            } else if (username.equalsIgnoreCase(user2) && password.equals(userPw2)) {
                System.out.println("Selamat datang Belqis");
                break;
            } else if (username.equalsIgnoreCase(user3) && password.equals(userPw3)) {
                System.out.println("Selamat datang Aqila");
                break;
            } else {
                System.out.println("Gagal masuk");
                System.out.println("Coba lagi!");
                continue;
            }
        }

        do {
            System.out.println("Menu : ");
            System.out.println("1. Transaksi");
            System.out.println("2. Update stok");
            System.out.println("3. Laporan Pendapatan");
            System.out.println("4. Exit");
            System.out.print("Pilih menu : ");

            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    // Add code for Transaksi
                    System.out.println("*****Transaksi menu selected*****");
                    System.out.println("*********************************");
                    String namaBarang[] = { "Beras", "Minyak", "Gula", "Garam", "Detergen", "Susu", "Mie Instant",
                            "Air mineral 1500ml", "Air mineral 600ml", "Aqua galon isi ulang 19lt", "Saus tomat ABC",
                            "Saus cabai ABC", "Telur 1 box", "Kecap manis", "Kecap asin", "Saori saus tiram",
                            "Saori teriyaki",
                            "Saori Lada hitam", "Penyedap", "Rokok" };

                    String member, beliLagi;
                    int hargaBarang, jmlBarang, totalBayar = 0;
                    double diskon, bayar, total;

                    System.out.println(namaBarang[0]); // menampilkan Beras
                    System.out.println(namaBarang[1]); // menampilkan Minyak
                    System.out.println(namaBarang[2]); // menampilkan Gula
                    System.out.println(namaBarang[3]); // menampilkan Garam
                    System.out.println(namaBarang[4]); // menampilkan detergen
                    System.out.println(namaBarang[5]); // menampilkan Susu
                    System.out.println(namaBarang[6]); // menampilkan Mie Instant
                    System.out.println(namaBarang[7]); // menampilkan Air mineral 1500ml
                    System.out.println(namaBarang[8]); // menampilkan Air mineral 600ml
                    System.out.println(namaBarang[9]); // menampilkan Aqua galon isi ulang 19lt
                    System.out.println(namaBarang[10]); // menampilkan Saus tomat ABC
                    System.out.println(namaBarang[11]); // menampilkan Saus cabai ABC
                    System.out.println(namaBarang[12]); // menampilkan Telur 1 box
                    System.out.println(namaBarang[13]); // menampilkan Kecap manis
                    System.out.println(namaBarang[14]); // menampilkan Kecap asin
                    System.out.println(namaBarang[15]); // menampilkan Saori saus tiram
                    System.out.println(namaBarang[16]); // menampilkan Saori teriyaki
                    System.out.println(namaBarang[17]); // menampilkan Saori Lada hitam
                    System.out.println(namaBarang[18]); // menampilkan Penyedap
                    System.out.println(namaBarang[19]); // menampilkan Rokok

                    System.out.println("-----------------------------");
                    System.out.println("-----------BAR MART----------");
                    System.out.println("-----------------------------");

                    System.out.print("Kasir: ");
                    String namaKasir = sc.nextLine();
                    System.out.print("A/N: ");
                    String namaPelanggan = sc.nextLine();

                    do {
                        System.out.println("Masukkan nama barang: ");
                        String inputNamaBarang = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Masukkan harga barang: ");
                        hargaBarang = sc.nextInt();
                        System.out.println("Masukkan jumlah barang: ");
                        jmlBarang = sc.nextInt();
                        System.out.println("Beli lagi (y/n)?");
                        beliLagi = sc.next();
                        total = hargaBarang * jmlBarang;
                        totalBayar += total;
                    } while (beliLagi.equals("y"));

                    System.out.println("Total harga belanjaan anda Rp " + totalBayar);
                    sc.nextLine();
                    System.out.println("Apakah anda punya kartu member (ya atau tidak)? :");
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

                case 2:
                    // Add code for Update stok
                    System.out.println("*****Update stok menu selected*****");
                    System.out.println("***********************************");
                    // Membuat array dua dimensi untuk menyimpan informasi barang
                    String[][] barang = new String[100][4];
                    int jumlahBarang = 0;

                    while (true) {
                        System.out.println("\nMenu:");
                        System.out.println("1. Update stok barang");
                        System.out.println("2. Tampilkan stok barang");
                        System.out.println("3. Keluar");

                        System.out.print("Pilih menu (1/2/3): ");
                        int pilihan = sc.nextInt();

                        if (pilihan == 1) {
                            System.out.print("Nama barang: ");
                            String nama = sc.next();
                            System.out.print("Harga barang: ");
                            double harga = sc.nextDouble();
                            System.out.print("Jumlah stok: ");
                            int stok = sc.nextInt();
                            double totalHarga = harga * stok;

                            barang[jumlahBarang][0] = nama;
                            barang[jumlahBarang][1] = Double.toString(harga);
                            barang[jumlahBarang][2] = Integer.toString(stok);
                            barang[jumlahBarang][3] = Double.toString(totalHarga);
                            jumlahBarang++;

                            System.out.println("Barang ditambahkan!");
                        } else if (pilihan == 2) {
                            System.out.println("Daftar barang:\n");
                            System.out.println("Nama\tHarga\tStok\tTotal Harga\n");
                            System.out.println("Minyak\t14000\t3\t42000");
                            System.out.println("Beras\t15000\t4\t60000");
                            System.out.println("Garam\t5000\t4\t20000");
                            System.out.println("Gula\t13000\t2\t26000");
                            System.out.println("Susu\t20000\t5\t100000");
                            System.out.println("dtrgn\t5000\t25\t125000");
                            System.out.println("Mie\t3000\t72\t216000");
                            System.out.println("Mnrl1,5\t6000\t12\t72000");
                            System.out.println("Mnrl600\t3000\t24\t72000");
                            System.out.println("AquaGln\t20000\t10\t200000");
                            System.out.println("SausTmt\t6000\t12\t72000");
                            System.out.println("SausCbi\t6000\t12\t72000");
                            System.out.println("Telur\t13000\t10\t130000");
                            System.out.println("KecapMn\t7000\t24\t168000");
                            System.out.println("KecapAn\t8000\t24\t192000");
                            System.out.println("SaoriTm\t2000\t50\t100000");
                            System.out.println("SaoriTy\t2000\t50\t100000");
                            System.out.println("SaoriLd\t2000\t50\t100000");
                            System.out.println("Penydp\t500\t100\t50000");
                            System.out.println("Rokok X\t25000\t24\t600000");

                            for (int i = 0; i < jumlahBarang; i++) {
                                System.out.println(
                                        barang[i][0] + "\t" + barang[i][1] + "\t" + barang[i][2] + "\t" + barang[i][3]);
                            }
                        } else if (pilihan == 3) {
                            System.out.println("Terima kasih!");
                            break;
                        } else {
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("*****Laporan Pendapatan menu selected*****");
                    System.out.println("******************************************");
                    // inisiasi variabel
                    int jumlahHari, jmlTransaksi;
                    double totPendapatanHarian = 0, totPendapatanBulanan = 0;

                    // Input jumlah hari dalam sebulan
                    System.out.print("Masukkan jumlah hari dalam sebulan: ");
                    jumlahHari = sc.nextInt();

                    // Perulangan untuk setiap hari dalam sebulan
                    for (int hari = 1; hari <= jumlahHari; hari++) {
                        System.out.println("\nHari ke-" + hari);

                        // Input jumlah transaksi harian
                        System.out.print("Masukkan jumlah transaksi harian: ");
                        jmlTransaksi = sc.nextInt();

                        // perulangan untuk traksaksi harian
                        for (int i = 1; i < jmlTransaksi; i++) {
                            System.out.println("Transaksi ke-" + i);

                            // input jumlah barang belanjaan
                            System.out.print("Masukkan jumlah barang belanjaan : ");
                            jumlahBarang = sc.nextInt();

                            double totalHarga = 0;

                            // perulangan setiap barang belanja
                            for (int j = 1; j <= jumlahBarang; j++) {
                                System.out.println("\nBarang ke- " + j);
                                System.out.print("Masukkan nama barang : ");
                                String inputNamaBarang = sc.nextLine();
                                System.out.print("Masukkan harga barang : ");
                                double inputHargaBarang = sc.nextDouble();
                                System.out.print("Masukkan jumlah barang : ");
                                int jumlah = sc.nextInt();

                                // hitung total harga untuk barang tertentu
                                double totalBarang = inputHargaBarang * jumlah;

                                // Menambahkan totalBarang ke totalHarga transaksi
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

                    // tutup scanner
                    sc.close();

                    // Add other cases for remaining menu options
                case 6:
                    System.out.println("*****Exiting program. Goodbye!*****");
                    break;
                default:
                    System.out.println("Menu not recognized. Please choose a valid option.");
            }
        } while (menu != 4);

        sc.close(); // Close the scanner to prevent resource leak

    }
}
