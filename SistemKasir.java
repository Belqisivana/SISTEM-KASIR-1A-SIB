import java.util.Scanner;

public class SistemKasir {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String member;
        double diskon, bayar, total;
        System.out.println("Apalah anda punya kartu member (y atau t)? :");
        member = input.nextLine();
        System.out.println("Berapa total harga belanjaan anda ? Rp ");
        total = input.nextDouble();
        if (member.equals("y")) {
            if (total >= 200000) {
                diskon = total * 0.15;
            } else {
                diskon = total * 0.10;
            }
            bayar = total - diskon;
            System.out.println("Diskon: Rp " + diskon);
            System.out.println("Total yang harus dibayar: Rp " + bayar);
        }
        if (member.equals("t")) {
            if (total >= 300000) {
                diskon = total * 0.5;
            } else
                System.out.println("Tidak dapat diskon");
        }

    }
}