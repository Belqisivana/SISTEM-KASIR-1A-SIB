import java.util.Scanner;

public class SistemKasir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String member, namaBarang, beliLagi;
        int hargaBarang, jmlBarang, totalBayar = 0;
        double diskon, bayar, total;

        do {
            System.out.println("Masukkan nama barang: ");
            namaBarang = input.next();
            System.out.println("Masukkan harga barang: ");
            hargaBarang = input.nextInt();
            System.out.println("Masukkan jumlah barang: ");
            jmlBarang = input.nextInt();
            System.out.println("Beli lagi (y/n)?");
            beliLagi = input.next();
            total = hargaBarang * jmlBarang;
            totalBayar += total;
        } while (beliLagi.equals("y"));

        System.out.println("Total harga belanjaan anda Rp " + totalBayar);
        input.nextLine();
        System.out.println("Apakah anda punya kartu member (ya atau tidak)? :");
        member = input.nextLine();
        if (member.equals("ya")) {
            if (total >= 200000) {
                diskon = total * 0.15;
            } else {
                diskon = total * 0.10;
            }
            bayar = total - diskon;
            System.out.println("Diskon: Rp " + diskon);
            System.out.println("Total yang harus dibayar: Rp " + bayar);
        } else {
            if (total >= 300000) {
                diskon = total * 0.05;
                bayar = total - diskon;
                System.out.println("Hasil diskon " + diskon);
                System.out.println("Total yang harus dibayar: Rp " + bayar);
            } else
                System.out.println("Tidak dapat diskon");

        }

    }
}
