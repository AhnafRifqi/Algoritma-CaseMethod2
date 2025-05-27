import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("--- Menu SPBU ---");
            System.out.println("1. Tambah Antrian Kendaraan");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Cek Jumlah Antrian Kendaraan");
            System.out.println("4. Layani Kendaraan");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.println("Pilih");
            pilihan = input.nextInt();
            switch (pilihan) {
                case 1:
                    System.out.println("Masukkan Plat Nomor: ");
                    String platNomor = input.nextLine();
                    System.out.println("Masukkan Jenis Kendaraan: ");
                    String tipe = input.nextLine();
                    System.out.println("Masukkan Merk: ");
                    String merk = input.nextLine();
                    kendaraan kendaraan = new kendaraan(platNomor, tipe, merk);

                    break;
            
                default:
                    break;
            }
        } while (pilihan >=0);
    }
}
