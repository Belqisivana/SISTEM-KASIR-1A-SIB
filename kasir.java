import java.util.Scanner;
public class kasir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu;

        while (menu) {
            System.out.println("Menu : ");
            System.out.println("1. Login Kasir");
            System.out.println("2. Transaksi");
            System.out.println("4. Update stok");
            System.out.println("5. Tampilkan Barang");
            System.out.println("6. Tambahkan Barang");
            System.out.println("7. Laporan Pendapatan Harian");
            System.out.println("8. Laporan Pendapatan Bulanan");
            System.out.println("9. Exit");
            System.out.println("Piih menu : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1 : //input login kasir (user dan password)
                String user1 = "Renald", user2 = "Belqis", user3 = "Aqila", username, password,
                userPw1 = "Renald123", userPw2 = "Belqis123", userPw3 = "Aqila123";
                System.out.println("Masukkan username : ");
                username = sc.next();
                System.out.println("Masukkan password : ");
                password = sc.next();
                if (username.equals(user1) && password.equals(userPw1)) {
                System.out.println("Selamat datang Renald");
                } else if (username.equals(user2) && password.equals(userPw2)) {
                    System.out.println("Selamat datang Belqis");
                } else if (username.equals(user3) && password.equals(userPw3)){
                    System.out.println("Selamat datang Aqila");
                } else {
                    System.out.println("Gagal masuk");
                }
            }
        }
    }
}