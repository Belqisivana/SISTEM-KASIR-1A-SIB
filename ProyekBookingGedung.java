import java.util.Scanner;

public class ProyekBookingGedung {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String akun, inputUserAdmin, inputPwAdmin, inputUserMember, inputPwMember, inputKodeMenu1, inputKodeMenu2;
        String kodeVeriv[] = { "01234", "12345", "23456", "34567", "45678", "56789", "67890" };
        int tm, stepLogin, menuGd, stepGd, MmtdBayar, menuAdm, menuMemb;
        String name, noTelp, tgl, inputStepBrg, konfirm, verivikasi;
        long tarif, hargaPil1, hargaPil2, hargaPil3, hargaPil4, totalTarif = 0;
        int meja = 1000, kursi = 1000, karpet = 10, sound = 5, mic = 10;
        int stokMeja, tambahStok, jmlPsnMeja, jmlPsnKursi, jmlPsnKarpet, jmlPsnSound, jmlPsnMic;
        int pilGd, jmlGd, stokGd = 4, tambahGd;
        String namaGd = " ", sisaGd = " ", inputChoiceMemb, ulangMemb;
        String[] namaStokGd = { "| Pernikahan |", "| Olahraga   |", "| Kesenian   |", "| Auditorium |" };
        String[][] riwayat = new String[3][4];
        int userLogin = 0, jmlPsnGd = 0;
        jmlPsnGd++;
        String catatanPesanGd = "ulangMemb";
        System.out.println("Nominal");
        riwayat[userLogin][jmlPsnGd] = catatanPesanGd;

        String[][] users = {
                { "april", "111" },
                { "gerly", "222" },
                { "jaden", "333" },
        };
        String[] regUserMemb = new String[100];
        String[] regPwMemb = new String[100];
        int jmlUserMemb = 1;
        regUserMemb[jmlUserMemb] = "member";
        regPwMemb[jmlUserMemb] = "12345";
        jmlUserMemb++;

        boolean halUtama = false;
        do {
            System.out.println(" T-.___________________________________________________.-T");
            System.out.println(" ||                                                     ||");
            System.out.println(" ||   SELAMAT DATANG DI WEBSITE BOOKING GEDUNG SOEHAT   ||");
            System.out.println(" ||        ! Silahkan masuk untuk melanjutkan !         ||");
            System.out.println(" ||                                                     ||");
            System.out.println("<||.---------------------------------------------------.||>");
            System.out.print("\nApakah Anda sudah punya akun ? (y/t) : ");
            akun = input.next();

            if (akun.equalsIgnoreCase("t")) {
                System.out.println("--------------------------------------------");
                System.out.print("Masukkan username baru: ");
                String inputUserBaru = input.next();
                System.out.println("--------------------------------------------");
                System.out.print("Masukkan password baru: ");
                String inputPwBaru = input.next();
                System.out.println("--------------------------------------------");
                if (jmlUserMemb < regUserMemb.length && jmlUserMemb < regPwMemb.length) {
                    regUserMemb[jmlUserMemb] = inputUserBaru;
                    regPwMemb[jmlUserMemb] = inputPwBaru;
                    jmlUserMemb++;
                    System.out.println("\n-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                    System.out.println("   ! USER BARU BERHASIL TERDAFTAR !   ");
                    System.out.println("-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-\n");
                } else {
                    System.out.println("\nMohon maaf, jumlah member melebihi batas.");
                }

            } else if (akun.equalsIgnoreCase("y")) {
                boolean choiceMenu = true;
                do {
                    System.out.println("\n,----------------------------------------------<");
                    System.out.println("|  Selamat Datang di Website Booking Gedung:)  |");
                    System.out.println("|        Silahkan pilih halaman login!         |");
                    System.out.println("|----------------------------------------------|");
                    System.out.println("|   1. Login Admin                             |");
                    System.out.println("|   2. Login Member                            |");
                    System.out.println("|   3. Keluar                                  |");
                    System.out.println("|_____________________________________________/.");
                    System.out.print("Masukkan Pilihan Anda 1/2/3 : ");
                    stepLogin = input.nextInt();
                    if (stepLogin < 1 || stepLogin > 3) {
                        System.out.println("\n! Mohon masukkan nomor antara 1 dan 3 !");
                    }
                } while (stepLogin < 1 || stepLogin > 3);

                if (stepLogin == 1) {
                    boolean userAdminValid = true;
                    do {
                        System.out.println("\n----------------------------------");
                        System.out.print("Masukkan username: ");
                        inputUserAdmin = input.next();
                        System.out.println("----------------------------------");
                        System.out.print("Masukkan password: ");
                        inputPwAdmin = input.next();
                        System.out.println("----------------------------------");
                        userAdminValid = false;
                        for (String[] user : users) {
                            if (user[0].equals(inputUserAdmin) && user[1].equals(inputPwAdmin)) {
                                userAdminValid = true;
                                break;
                            }
                        }
                        if (userAdminValid) {
                            System.out.println("\n-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                            System.out.println("          ! LOGIN BERHASIL !          ");
                            System.out.println("       SELAMAT DATANG, ADMIN :)       ");
                            System.out.println("-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                        } else {
                            System.out.println("! Login gagal. Username atau password salah. Silakan coba lagi !");
                        }
                    } while (!userAdminValid);

                    boolean choiceAdm = true;
                    while (choiceAdm) {
                        do {
                            System.out.println("\n,---------------------------------<");
                            System.out.println("|           MENU ADMIN            |");
                            System.out.println("|---------------------------------|");
                            System.out.println("|   1. Lihat data member          |");
                            System.out.println("|   2. Lihat sisa stok barang     |");
                            System.out.println("|   3. Tambah Stok Barang         |");
                            System.out.println("|   4. Lihat sisa stok Gedung     |");
                            System.out.println("|   5. Tambah Stok Gedung         |");
                            System.out.println("|   6. Keluar                     |");
                            System.out.println("|_________________________________/.");
                            System.out.print("Masukkan Pilihan Anda 1/2/3/4/5/6 : ");
                            menuAdm = input.nextInt();
                            if (menuAdm < 1 || menuAdm > 6) {
                                System.out.println("\n! Mohon masukkan nomor antara 1 dan 6 !\n");
                            }
                        } while (menuAdm < 1 || menuAdm > 6);
                        switch (menuAdm) {
                            case 1:
                                System.out.println("\nJumlah Member : " + jmlUserMemb);
                                System.out.println("User yang telah terdaftar :\n");
                                for (int i = 1; i < jmlUserMemb; i++) {
                                    System.out.println("Member ke-" + i);
                                    System.out.println("Username : " + regUserMemb[i]);
                                    System.out.println("Password : " + regPwMemb[i]);
                                    System.out.println("---------------------------");
                                }
                                break;
                            case 2:
                                System.out.println("Stok meja   : " + meja);
                                System.out.println("Stok kursi  : " + kursi);
                                System.out.println("Stok karpet : " + karpet);
                                System.out.println("Stok sound  : " + sound);
                                System.out.println("Stok mic    : " + mic);
                                break;
                            case 3:
                                boolean pilihStok = true;
                                System.out.println("Stok Barang yang ingin ditambahkan");
                                System.out.println("1. Meja");
                                System.out.println("2. Kursi");
                                System.out.println("3. Karpet");
                                System.out.println("4. Sound");
                                System.out.println("5. Mic");
                                System.out.print("Masukkan Pilihan 1/2/3/4/5 : ");
                                tambahStok = input.nextInt();
                                if (tambahStok < 1 || tambahStok > 5) {
                                    System.out.println("\n! Mohon masukkan nomor antara 1 dan 5 !\n");
                                }
                                switch (tambahStok) {
                                    case 1:
                                        System.out.print("Jumlah stok meja yang ingin ditambah : ");
                                        tambahStok = input.nextInt();
                                        meja += tambahStok;
                                        break;
                                    case 2:
                                        System.out.print("Jumlah stok kursi yang ingin ditambah : ");
                                        tambahStok = input.nextInt();
                                        kursi += tambahStok;
                                        break;
                                    case 3:
                                        System.out.print("Jumlah stok karpet yang ingin ditambah : ");
                                        tambahStok = input.nextInt();
                                        karpet += tambahStok;
                                        break;
                                    case 4:
                                        System.out.print("Jumlah stok sound system yang ingin ditambah : ");
                                        tambahStok = input.nextInt();
                                        sound += tambahStok;
                                        break;
                                    case 5:
                                        System.out.print("Jumlah stok mikrofon yang ingin ditambah : ");
                                        tambahStok = input.nextInt();
                                        mic += tambahStok;
                                        break;
                                    default:
                                        break;
                                }
                                boolean choicevalid = true;
                                do {
                                    System.out.print("Kembali ke Menu Admin ? (y/t) : ");
                                    verivikasi = input.next();
                                    choicevalid = false;
                                    if (verivikasi.equalsIgnoreCase("y")) {
                                        choiceAdm = true;
                                        break;
                                    } else if (verivikasi.equalsIgnoreCase("t")) {
                                        choiceAdm = false;
                                        break;
                                    } else {
                                        System.out.println("\nPilihan salah. Mohon masukkan y/t !\n");
                                    }
                                } while (tambahStok < 1 || tambahStok > 5);
                                break;
                            case 4:
                                System.out.println("\n> Sisa Stok Gedung Ada : " + stokGd);
                                System.out.println("\nNama Stok Gedung Yang Tersedia : ");
                                System.out.println(",------------<");
                                for (String gedung : namaStokGd) {
                                    System.out.println(gedung);
                                }
                                System.out.println("|___________/.");
                                break;
                            case 5:
                                System.out.println("\n> Jumlah Stok Gedung yang akan ditambah : ");
                                tambahGd = input.nextInt();
                                stokGd += tambahGd;
                                break;
                            case 6:
                                choiceAdm = false;
                                halUtama = true;
                                break;
                        }
                    }

                    System.out.print("Kembali ke Halaman Utama ? (y/t) : ");
                    verivikasi = input.next();

                    if (verivikasi.equalsIgnoreCase("y")) {
                        choiceMenu = false;
                        choiceAdm = false;
                        halUtama = true;
                    } else if (verivikasi.equalsIgnoreCase("t")) {
                        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println("!                                               !");
                        System.out.println("!   TERIMA KASIH! Selamat berjumpa kembali :)   !");
                        System.out.println("!                                               !");
                        System.out.println("!.=============================================.!\n");
                        System.exit(0);
                    } else {
                        System.out.println("\n!Pilihan salah. Mohon masukkan y/t !\n");
                    }

                } else if (stepLogin == 2) {
                    boolean userMemberValid;
                    do {
                        System.out.println("-----------------------------------");
                        System.out.print("Masukkan username : ");
                        inputUserMember = input.next();
                        System.out.println("-----------------------------------");
                        System.out.print("Masukkan password : ");
                        inputPwMember = input.next();
                        System.out.println("-----------------------------------");
                        userMemberValid = false;
                        for (int i = 0; i < jmlUserMemb; i++) {
                            if (inputUserMember.equals(regUserMemb[i]) && inputPwMember.equals(regPwMemb[i])) {
                                userMemberValid = true;
                                break;
                            }
                        }
                        if (userMemberValid) {
                            System.out.println("\n-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                            System.out.println("          ! LOGIN BERHASIL !         ");
                            System.out.println("      SELAMAT DATANG, MEMBER :)      ");
                            System.out.println("-VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV-");
                        } else {
                            System.out.println("\n! Login gagal. Username atau password salah. Silakan coba lagi !\n");
                        }
                    } while (!userMemberValid);

                    boolean choiceMemb = true;
                    while (choiceMemb) {
                        do {
                            System.out.println("\n,---------------------------------<");
                            System.out.println("|           MENU MEMBER           |");
                            System.out.println("|---------------------------------|");
                            System.out.println("|   1. Lihat sisa stok barang     |");
                            System.out.println("|   2. Pesan Sekarang             |");
                            System.out.println("|   3. Lihat Sisa Stok Gedung     |");
                            System.out.println("|   4. Keluar                     |");
                            System.out.println("|________________________________/.");
                            System.out.print("Masukkan Pilihan Anda 1/2/3/4 : ");
                            menuMemb = input.nextInt();
                            System.out.println();
                            if (menuMemb < 1 || menuMemb > 4) {
                                System.out.println("! Mohon masukkan nomor antara 1 dan 3 !");
                            }
                            switch (menuMemb) {
                                case 1:
                                    System.out.println("Stok meja   : " + meja);
                                    System.out.println("Stok kursi  : " + kursi);
                                    System.out.println("Stok karpet : " + karpet);
                                    System.out.println("Stok sound  : " + sound);
                                    System.out.println("Stok mic    : " + mic);
                                    choiceMemb = true;
                                    break;
                                case 2:
                                    System.out.print("Masukkan Jumlah Gedung Yang Ingin Dipesan : ");
                                    jmlGd = input.nextInt();
                                    System.out.println();
                                    boolean langkahSelanjutnya = true;
                                    for (int i = 0; i < jmlGd; i++) {
                                        boolean gedungDipilih = false;
                                        do {
                                            System.out.println("\t.-------------.");
                                            System.out.println("\t| Gedung ke-" + (i + 1) + " |");
                                            System.out.println(",------------------------------------------<");
                                            System.out.println("|        Daftar Gedung yang tersedia!      |");
                                            System.out.println("|__________________________________________|");
                                            System.out.println("| No. | Nama Gedung | Maks Tamu | Tarif    |");
                                            System.out.println("|-----|-------------|-----------|----------|");
                                            System.out.println("| 1.  | Pernikahan  | 900       | Rp.90000 |");
                                            System.out.println("| 2.  | Olahraga    | 250       | Rp.25000 |");
                                            System.out.println("| 3.  | Kesenian    | 100       | Rp.10000 |");
                                            System.out.println("| 4.  | Auditorium  | 500       | Rp.50000 |");
                                            System.out.println("|_____|_____________|___________|_________/.");
                                            System.out.print("Masukkan Pilihan Anda : ");
                                            pilGd = input.nextInt();
                                            if (pilGd < 1 || pilGd > 4) {
                                                System.out.println("\n.-------------------------------------------.");
                                                System.out.println("!   Mohon masukkan Angka antara 1 dan 4     !");
                                                System.out.println("!.-----------------------------------------.!");
                                            }
                                            if (pilGd == 1) {
                                                namaGd += namaStokGd[0];
                                                if (stokGd > 0) {
                                                    stokGd--;
                                                    gedungDipilih = true;
                                                } else {
                                                    System.out.println("Maaf, stok Gedung habis.");
                                                }
                                            } else if (pilGd == 2) {
                                                namaGd += namaStokGd[1];
                                                if (stokGd > 0) {
                                                    stokGd--;
                                                    gedungDipilih = true;
                                                } else {
                                                    System.out.println("Maaf, stok Gedung habis.");
                                                }
                                            } else if (pilGd == 3) {
                                                namaGd += namaStokGd[2];
                                                if (stokGd > 0) {
                                                    stokGd--;
                                                    gedungDipilih = true;
                                                } else {
                                                    System.out.println("Maaf, stok Gedung habis.");
                                                }
                                            } else if (pilGd == 4) {
                                                namaGd += namaStokGd[3];
                                                if (stokGd > 0) {
                                                    stokGd--;
                                                    gedungDipilih = true;
                                                } else {
                                                    System.out.println("Maaf, stok Gedung habis.");
                                                }
                                            }
                                        } while (pilGd < 1 || pilGd > 4);

                                        System.out.print("Masukkan Nama Anda : ");
                                        name = input.next();
                                        input.nextLine();
                                        System.out.print("Masukkan No. Telepon : ");
                                        noTelp = input.next();
                                        System.out.print("Masukkan Tanggal Acara (DD-MM-YYY) : ");
                                        tgl = input.next();
                                        input.nextLine();
                                        do {
                                            System.out.print("Masukkan Jumlah Tamu : ");
                                            tm = input.nextInt();
                                            tarif = tm * 90000;
                                            totalTarif += tarif;
                                            if (tm > 900) {
                                                System.out.println(
                                                        "Mohon Maaf, jumlah tamu melebihi kapasitas maks. 900");
                                            } else if (tm < 1) {
                                                System.out.println("Mohon memasukkan jumlah tamu minimal 1");
                                            }
                                        } while (tm < 1 || tm > 900);

                                        System.out.println("-------------------------------------------");
                                        System.out.println("\t\tGEDUNG SOEHAT");
                                        System.out.println("----------Informasi Pemesanan Anda!--------");
                                        System.out.println("Nama Gedung     :" + namaGd);
                                        System.out.println("Atas Nama       : " + name);
                                        System.out.println("No. Telepon     : " + noTelp);
                                        System.out.println("Tanggal         : " + tgl);
                                        System.out.println("Jumlah Tamu     : " + tm);
                                        System.out.println("Total Biaya     : Rp." + totalTarif);
                                        System.out.println("------------------------------------------");
                                        System.out.println("\t  Jl. Soekarno Hatta No.9");
                                        System.out.println("      Kel. Jatimulyo, Kec. Lowokwaru");
                                        System.out.println("\t      MALANG 65141");
                                        System.out.println("------------------------------------------");
                                        if (stokGd == 0) {
                                            gedungDipilih = false;
                                            System.out.println("Apakah Anda ingin kembali ke Menu Member?  (y/t) : ");
                                            inputChoiceMemb = input.next();
                                            if (inputChoiceMemb.equalsIgnoreCase("y")) {
                                                choiceMemb = true;
                                            } else if (inputChoiceMemb.equalsIgnoreCase("t")) {
                                                System.out.println("Bayar Sekarang ?");
                                            }
                                        }
                                        do {
                                            System.out.println("Pilih Langkah Selanjutnya!");
                                            System.out.println("1. Sewa Barang tambahan Lain");
                                            System.out.println("2. Bayar Sekarang");
                                            System.out.print("Masukkan Pilihan : ");
                                            stepGd = input.nextInt();
                                            if (stepGd < 1 || stepGd > 2) {
                                                System.out
                                                        .println("\n! Mohon Masukkan Pilihan Antara Angka 1 dan 2 !\n");
                                            }
                                            if (stepGd == 1) {
                                                boolean stepBarang = true;
                                                while (stepBarang) {
                                                    System.out.print("Apakah Anda Ingin Memesan Barang? (y/t) : ");
                                                    inputStepBrg = input.next();
                                                    if (inputStepBrg.equalsIgnoreCase("y")) {
                                                        do {
                                                            System.out.println(
                                                                    ",--------------------------------------------------<");
                                                            System.out.println(
                                                                    "|              Daftar Barang yang tersedia!        |");
                                                            System.out.println(
                                                                    "|__________________________________________________|");
                                                            System.out.println(
                                                                    "| No. | Nama Barang | Harga          | Jumlah Stok |");
                                                            System.out.println(
                                                                    "|-----|-------------|----------------|-------------|");
                                                            System.out.println(
                                                                    "| 1.  | Meja        | Rp.10000/pcs   | 1000        |");
                                                            System.out.println(
                                                                    "| 2.  | Kursi       | Rp.5000/pcs    | 1000        |");
                                                            System.out.println(
                                                                    "| 3.  | Karpet      | Rp.50000/pcs   | 10          |");
                                                            System.out.println(
                                                                    "| 4.  | Sound       | Rp.200000/pcs  | 5           |");
                                                            System.out.println(
                                                                    "| 5.  | Mic         | Rp.50000/pcs   | 10          |");
                                                            System.out.println(
                                                                    "|_____|_____________|________________|____________/.");
                                                            System.out.print("Masukkan Pilihan Anda 1/2/3/4/5 : ");
                                                            menuGd = input.nextInt();
                                                            if (menuGd < 1 || menuGd > 4) {
                                                                System.out.println(
                                                                        "\n! Pilihan Salah.Mohon masukkan angka antara 1 dan 4 !\n");
                                                            }
                                                        } while (menuGd < 1 || menuGd > 4);
                                                        switch (menuGd) {
                                                            case 1:
                                                                System.out.print("Jumlah Meja yang akan dipesan : ");
                                                                jmlPsnMeja = input.nextInt();
                                                                meja -= jmlPsnMeja;
                                                                hargaPil1 = meja * 10000;
                                                                totalTarif += hargaPil1;
                                                                break;
                                                            case 2:
                                                                System.out.print("Jumlah Kursi yang akan dipesan : ");
                                                                jmlPsnKursi = input.nextInt();
                                                                kursi -= jmlPsnKursi;
                                                                hargaPil2 = kursi * 5000;
                                                                totalTarif += hargaPil2;
                                                                break;
                                                            case 3:
                                                                System.out.print("Jumlah Karpet yang akan dipesan : ");
                                                                jmlPsnKarpet = input.nextInt();
                                                                karpet -= jmlPsnKarpet;
                                                                hargaPil3 = karpet * 50000;
                                                                totalTarif += hargaPil3;
                                                                break;
                                                            case 4:
                                                                System.out.print("Jumlah Sound yang akan dipesan : ");
                                                                jmlPsnSound = input.nextInt();
                                                                sound -= jmlPsnSound;
                                                                hargaPil4 = sound * 300000;
                                                                totalTarif += hargaPil4;
                                                                break;
                                                            case 5:
                                                                System.out.print("Jumlah Mic yang akan dipesan : ");
                                                                jmlPsnMic = input.nextInt();
                                                                mic -= jmlPsnMic;
                                                                hargaPil4 = mic * 300000;
                                                                totalTarif = hargaPil4;
                                                                break;
                                                            default:
                                                                break;
                                                        }
                                                        break;
                                                    } else if (inputStepBrg.equalsIgnoreCase("t")) {
                                                        break;
                                                    } else {
                                                        System.out.println(
                                                                "\n! Maaf, pilihan anda salah! masukkan y/t !\n");
                                                    }
                                                }
                                            } else if (stepGd == 2) {
                                                do {
                                                    System.out.println(
                                                            "\n,-------------------------------------------------------------------<");
                                                    System.out.println(
                                                            "|                        METODE PEMBAYARAN!                         |");
                                                    System.out.println(
                                                            "|___________________________________________________________________|");
                                                    System.out.println(
                                                            "| No.| VIA                      | No.Rek/No.telp | Atas nama        |");
                                                    System.out.println(
                                                            "|----|--------------------------|----------------|------------------|");
                                                    System.out.println(
                                                            "| 1. | BRI/BNI/BCA              | 2341760195     | Gerly Vaeyungfan |");
                                                    System.out.println(
                                                            "| 2. | DANA/ShopeePay/LinkAja   | 085604054712   | Gerly Vaeyungfan |");
                                                    System.out.println(
                                                            "|____|__________________________|________________|_________________/.");
                                                    System.out.print("Pilih Metode Pembayaran 1/2 : ");
                                                    MmtdBayar = input.nextInt();
                                                    if (MmtdBayar < 1 || MmtdBayar > 2) {
                                                        System.out.println("\n! Mohon masukkan nomor antara 1 dan 2 !");
                                                    }
                                                } while (MmtdBayar < 1 || MmtdBayar > 2);
                                                switch (MmtdBayar) {
                                                    case 1:
                                                        boolean isKode1Valid = false;
                                                        do {
                                                            System.out.println(
                                                                    "\nKode verivikasiikasi dikirim melalui SMS");
                                                            System.out.print("Masukkan Kode Verivikasi : ");
                                                            inputKodeMenu1 = input.next();
                                                            isKode1Valid = false;
                                                            for (String kode : kodeVeriv) {
                                                                if (inputKodeMenu1.equals(kode)) {
                                                                    isKode1Valid = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (!isKode1Valid) {
                                                                System.out.println(
                                                                        "Kode verivikasiikasi Salah. Silahkan coba lagi");
                                                            } else {
                                                                System.out.println(
                                                                        "-------------------------------------------");
                                                                System.out.println("\t\tGEDUNG SOEHAT");
                                                                System.out.println(
                                                                        "----------Informasi Pemesanan Anda!--------");
                                                                System.out.println("Atas Nama       : " + name);
                                                                System.out.println("No. Telepon     : " + noTelp);
                                                                System.out.println("Tanggal         : " + tgl);
                                                                System.out.println("Jumlah Tamu     : " + tm);
                                                                System.out.println("Barang tambahan : BELUM BETUL!");
                                                                System.out
                                                                        .println("Total Biaya     : Rp." + totalTarif);
                                                                System.out.println(
                                                                        "------------------------------------------");
                                                                System.out.println("\t  Jl. Soekarno Hatta No.9");
                                                                System.out.println(
                                                                        "      Kel. Jatimulyo, Kec. Lowokwaru");
                                                                System.out.println("\t      MALANG 65141");
                                                                System.out.println(
                                                                        "------------------------------------------");
                                                            }
                                                        } while (!isKode1Valid);
                                                        break;

                                                    case 2:
                                                        boolean isKode2Valid = false;
                                                        do {
                                                            System.out.println(
                                                                    "\nKode verivikasiikasi dikirim melalui SMS");
                                                            System.out.print("Masukkan Kode Verivikasi : ");
                                                            inputKodeMenu2 = input.next();
                                                            isKode2Valid = false;
                                                            for (String kode : kodeVeriv) {
                                                                if (inputKodeMenu2.equals(kode)) {
                                                                    isKode2Valid = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (!isKode2Valid) {
                                                                System.out.println(
                                                                        "Kode verivikasiikasi Salah. Silahkan coba lagi");
                                                            } else {
                                                                System.out.println(
                                                                        "-------------------------------------------");
                                                                System.out.println("\t\tGEDUNG SOEHAT");
                                                                System.out.println(
                                                                        "----------Informasi Pemesanan Anda!--------");
                                                                System.out.println("Atas Nama       : " + name);
                                                                System.out.println("No. Telepon     : " + noTelp);
                                                                System.out.println("Tanggal         : " + tgl);
                                                                System.out.println("Jumlah Tamu     : " + tm);
                                                                System.out.println("Barang tambahan : BELUM BETUL!");
                                                                System.out.println("Total Biaya     : Rp." + tarif);
                                                                System.out.println(
                                                                        "------------------------------------------");
                                                                System.out.println("\t  Jl. Soekarno Hatta No.9");
                                                                System.out.println(
                                                                        "      Kel. Jatimulyo, Kec. Lowokwaru");
                                                                System.out.println("\t      MALANG 65141");
                                                                System.out.println(
                                                                        "------------------------------------------");
                                                                langkahSelanjutnya = true;
                                                            }
                                                        } while (!isKode2Valid);
                                                }
                                            }
                                        } while (stepGd < 1 || stepGd > 2);
                                    }
                                    System.out.print("\nApakah Anda Ingin Kembali Ke Menu Member ? (y/t) : ");
                                    konfirm = input.next();
                                    System.out.println();
                                    if (konfirm.equalsIgnoreCase("y")) {
                                        choiceMemb = true;
                                        langkahSelanjutnya = false;
                                    } else if (konfirm.equalsIgnoreCase("t")) {
                                        System.out.print("Apakah Anda Ingin Kembali Ke Halaman Awal ? (y/t) : ");
                                        konfirm = input.next();
                                        System.out.println();
                                        if (konfirm.equalsIgnoreCase("y")) {
                                            choiceMemb = false;
                                            halUtama = true;
                                            break;
                                        } else if (konfirm.equalsIgnoreCase("t")) {
                                            System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                                            System.out.println("!                                               !");
                                            System.out.println("!   TERIMA KASIH! Selamat berjumpa kembali :)   !");
                                            System.out.println("!                                               !");
                                            System.out.println("!.=============================================.!\n");
                                            System.exit(0);
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("> Sisa Stok Gedung : " + stokGd);
                                    choiceMemb = true;
                                    break;
                                case 4:
                                    choiceMenu = true;
                                    choiceMemb = false;
                                    halUtama = false;
                                    break;
                            }
                        } while (menuMemb < 1 || menuMemb > 4);
                    }
                } else if (stepLogin == 3) {
                    System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!                                               !");
                    System.out.println("!   TERIMA KASIH! Selamat berjumpa kembali :)   !");
                    System.out.println("!                                               !");
                    System.out.println("!.=============================================.!\n");
                    System.exit(0);
                }
            } else if (!akun.equalsIgnoreCase("y") || !akun.equalsIgnoreCase("t")) {
                System.out.println("\n! Pilihan tidak tersedia. Mohon masukkan huruf y/t !\n");
            }

        } while (!akun.equalsIgnoreCase("y") || !akun.equalsIgnoreCase("t"));
    }
}