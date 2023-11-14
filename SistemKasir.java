import java.util.Scanner;

public class SistemKasir {
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

                default:
                    System.out.println("Menu not recognized. Please choose a valid option.");
            }
        } while (menu != 4);

        sc.close(); // Close the scanner to prevent resource leak

    }
}