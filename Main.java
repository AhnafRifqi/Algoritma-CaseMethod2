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

        do { // Memulai loop do-while yang akan terus berjalan sampai pengguna memilih untuk keluar (pilihan 0).
            tampilkanMenu(); // Memanggil metode untuk menampilkan menu.
            pilihan = Integer.parseInt(scanner.nextLine()); // Membaca input pilihan dari pengguna dan mengonversinya menjadi integer.

            switch (pilihan) { // Menggunakan pernyataan switch untuk menanggapi pilihan pengguna.
                case 1: // Jika pilihan adalah 1 (Tambah Antrian Kendaraan).
                    spbu.tambahAntrianKendaraan(scanner); // Memanggil metode tambahAntrianKendaraan pada objek spbu.
                    break; // Keluar dari switch.
                case 2: // Jika pilihan adalah 2 (Tampilkan Antrian).
                    spbu.tampilkanAntrian(); // Memanggil metode tampilkanAntrian pada objek spbu.
                    break; // Keluar dari switch.
                case 3: // Jika pilihan adalah 3 (Cek Jumlah Antrian Kendaraan).
                    spbu.cekJumlahAntrianKendaraan(); // Memanggil metode cekJumlahAntrianKendaraan pada objek spbu.
                    break; // Keluar dari switch.
                case 4: // Jika pilihan adalah 4 (Layani Kendaraan).
                    spbu.layaniKendaraan(scanner); // Memanggil metode layaniKendaraan pada objek spbu.
                    break; // Keluar dari switch.
                case 5: // Jika pilihan adalah 5 (Tampilkan Riwayat Transaksi).
                    spbu.tampilkanRiwayatTransaksi(); // Memanggil metode tampilkanRiwayatTransaksi pada objek spbu.
                    break; // Keluar dari switch.
                case 0: // Jika pilihan adalah 0 (Keluar).
                    System.out.println("Terima kasih telah menggunakan sistem SPBU."); // Mencetak pesan keluar.
                    break; // Keluar dari switch.
                default: // Jika pilihan tidak cocok dengan kasus di atas.
                    System.out.println("Pilihan tidak valid. Silakan coba lagi."); // Mencetak pesan error.
            }
        } while (pilihan != 0); // Kondisi loop: terus berjalan selama pilihan bukan 0.
        scanner.close(); // Menutup objek scanner untuk membebaskan sumber daya sistem.
    }
}