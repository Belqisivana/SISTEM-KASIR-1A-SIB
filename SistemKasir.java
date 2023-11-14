import java.util.Scanner;

public class SistemKasir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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


    }
}
