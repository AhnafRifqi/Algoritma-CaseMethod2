import java.util.Scanner;

public class Main {
    public static void tampilkanMenu() {
        System.out.println("\n--- Menu SPBU ---");
        System.out.println("1. Tambah Antrian Kendaraan");
        System.out.println("2. Tampilkan Antrian");
        System.out.println("3. Cek Jumlah Antrian Kendaraan");
        System.out.println("4. Layani Kendaraan");
        System.out.println("5. Tampilkan Riwayat Transaksi");
        System.out.println("0. Keluar");
        System.out.print("Pilih: ");
    }

    public static void main(String[] args) {
        SPBU spbu = new SPBU();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            tampilkanMenu(); 
            //pilihan = Integer.parseInt(scanner.nextLine()); 
            pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    spbu.tambahAntrianKendaraan(scanner);
                    break;
                case 2:
                    spbu.tampilkanAntrian();
                    break;
                case 3:
                    spbu.cekJumlahAntrianKendaraan();
                    break;
                case 4:
                    spbu.layaniKendaraan(scanner);
                    break;
                case 5:
                    spbu.tampilkanRiwayatTransaksi();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem SPBU.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);
        scanner.close();
    }
}
