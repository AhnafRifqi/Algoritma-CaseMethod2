import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna.

public class Main { // Deklarasi kelas Main.
    
    public static void tampilkanMenu() { // Metode statis untuk menampilkan opsi menu kepada pengguna.
        System.out.println("\n--- Menu SPBU ---"); // Mencetak judul menu.
        System.out.println("1. Tambah Antrian Kendaraan"); // Opsi 1: Menambah kendaraan ke antrian.
        System.out.println("2. Tampilkan Antrian"); // Opsi 2: Menampilkan antrian kendaraan.
        System.out.println("3. Cek Jumlah Antrian Kendaraan"); // Opsi 3: Mengecek jumlah kendaraan dalam antrian.
        System.out.println("4. Layani Kendaraan"); // Opsi 4: Melayani kendaraan dari antrian.
        System.out.println("5. Tampilkan Riwayat Transaksi"); // Opsi 5: Menampilkan riwayat transaksi.
        System.out.println("0. Keluar"); // Opsi 0: Keluar dari program.
        System.out.print("Pilih: "); // Meminta pengguna untuk memilih opsi.
    }

    public static void main(String[] args) { // Metode utama (entry point) dari aplikasi.
        SPBU spbu = new SPBU(); // Membuat objek SPBU baru.
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari konsol.
        int pilihan; // Variabel untuk menyimpan pilihan menu dari pengguna.

        do {
            tampilkanMenu(); 
            pilihan = Integer.parseInt(scanner.nextLine()); 
            
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
        } while (pilihan != 0); // Kondisi loop: terus berjalan selama pilihan bukan 0.
        scanner.close(); // Menutup objek scanner untuk membebaskan sumber daya sistem.
    }
}
