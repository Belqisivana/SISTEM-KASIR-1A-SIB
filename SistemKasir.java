import java.util.Scanner;

public class SistemKasir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;

        do {
            System.out.println("Menu : ");
            System.out.println("1. Login Kasir");
            System.out.println("2. Transaksi");
            System.out.println("3. Update stok");
            System.out.println("4. Laporan Pendapatan");
            System.out.println("5. Exit");
            System.out.println("Pilih menu : ");
            
           
            menu = sc.nextInt();
            sc.nextLine();  
            
            switch (menu) {
                case 1: // input login kasir (user dan password)

                        String user1 = "Renald", user2 = "Belqis", user3 = "Aqila", username, password,
                        userPw1 = "Renald123", userPw2 = "Belqis123", userPw3 = "Aqila123";

                        boolean berhasilMasuk = false;
                        
                        while (!berhasilMasuk) {
                            System.out.println("Masukkan username : ");
                            username = sc.next();
                            System.out.println("Masukkan password : ");
                            password = sc.next();
                        
                            if (username.equalsIgnoreCase(user1) && password.equals(userPw1)) {
                                System.out.println("Selamat datang Renald");
                                berhasilMasuk = true;
                                break;
                            } else if (username.equalsIgnoreCase(user2) && password.equals(userPw2)) {
                                System.out.println("Selamat datang Belqis");
                                berhasilMasuk = true;
                                break;
                            } else if (username.equalsIgnoreCase(user3) && password.equals(userPw3)) {
                                System.out.println("Selamat datang Aqila");
                                berhasilMasuk = true;
                                break;
                            } else {
                                System.out.println("Username atau Password salah.");
                                System.out.println("Coba lagi.");
                                continue;
                            }
                        }

                case 2:
                    // Add code for Transaksi
                    System.out.println("Transaksi menu selected");

                    String namaBarang[] = { "Beras", "Minyak", "Gula", "Garam", "Detergen", "Susu", "Mie Instant",
                    "Air mineral 1500ml", "Air mineral 600ml", "Aqua galon isi ulang 19lt", "Saus tomat ABC",
                    "Saus cabai ABC", "Telur 1 box", "Kecap manis", "Kecap asin", "Saori saus tiram", "Saori teriyaki",
                    "Saori Lada hitam", "Penyedap", "Rokok" };

                        String beliLagi;
                        int hargaBarang, jmlBarang, totalBayar = 0;
                        double diskon, bayar, total;

                        for (int i = 0; i < namaBarang.length; i++) {
                        System.out.println(namaBarang[i]);
                        }

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
                        String member = sc.nextLine();

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
                case 3:
                    // Add code for Update stok
                    String[][] barang = new String[100][4];
                    int jumlahBarang = 0;
                    
                    while (true) {
                        System.out.println("\nMenu:");
                        System.out.println("1. Tambah Barang");
                        System.out.println("2. Tampilkan Barang");
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
                            for (int i = 0; i < jumlahBarang; i++) {
                                System.out.println(barang[i][0] + "\t" + barang[i][1] + "\t" + barang[i][2] + "\t" + barang[i][3]);
                            }
                        } else if (pilihan == 3) {
                            System.out.println("Terima kasih!");
                            break;
                        } else {
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        }
                    }
                   
                    break;
                // Add other cases for remaining menu options

                case 4: 
                    // Laporan Pendapatan
                    //inisiasi variabel
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


                                //perulangan untuk traksaksi harian
                                for (int i = 1; i < jmlTransaksi; i++) {
                                    System.out.println("Transaksi ke-" +i);

                                    //input jumlah barang belanjaan
                                    System.out.print("Masukkan jumlah barang belanjaan : ");
                                    int JumlahBarang = sc.nextInt();

                                    double totalHarga = 0;


                                    //perulangan setiap barang belanja
                                    for (int j =1; j <= JumlahBarang; j++) {
                                        System.out.println("\nBarang ke- " +j);

                                        //input nama barang 
                                        System.out.print("Masukkan nama barang : ");
                                        String NamaBarang = sc.next();

                                        //input harga barang
                                        System.out.print("Masukkan harga barang : ");
                                        double HargaBarang = sc.nextDouble();

                                        //input jumlah Barang
                                        System.out.print("Masukkan jumlah barang : ");
                                        int jumlah = sc.nextInt();

                                        //Menghitung total harga untuk barang tertentu
                                        double totalBarang = HargaBarang * jumlah;

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
                        sc.close();
                case 5:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Menu not recognized. Please choose a valid option.");
            }
        } while (menu != 5);

        sc.close(); // Close the scanner to prevent resource leak
    }
}
