import java.util.Scanner; // Mengimpor kelas Scanner untuk membaca input dari pengguna.

class Node { // Deklarasi kelas Node untuk digunakan dalam Linked List Queue.
    Kendaraan data; // Variabel untuk menyimpan data Kendaraan di dalam node.
    Node next; // Variabel untuk menunjuk ke node berikutnya dalam list.

    public Node(Kendaraan data) { // Konstruktor untuk membuat Node baru.
        this.data = data; // Menginisialisasi data node dengan Kendaraan yang diberikan.
        this.next = null; // Awalnya, node berikutnya diatur ke null.
    }
}

class LLQueue { // Deklarasi kelas LLQueue (Linked List Queue) untuk mengelola antrian kendaraan.
    Node head; // Node pertama (depan) dari antrian.
    Node tail; // Node terakhir (belakang) dari antrian.
    int size; // Ukuran antrian (jumlah elemen).

    public LLQueue() { // Konstruktor untuk LLQueue.
        head = null; // Awalnya, head kosong.
        tail = null; // Awalnya, tail kosong.
        size = 0; // Ukuran antrian awal adalah 0.
    }

    public void addLast(Kendaraan data) { // Metode untuk menambahkan elemen ke akhir antrian (enqueue).
        Node newNode = new Node(data); // Membuat node baru dengan data Kendaraan yang diberikan.
        if (isEmpty()) { // Jika antrian kosong,
            head = newNode; // Node baru menjadi head.
            tail = newNode; // Node baru juga menjadi tail.
        } else { // Jika antrian tidak kosong,
            tail.next = newNode; // Node baru ditambahkan setelah tail yang lama.
            tail = newNode; // Node baru menjadi tail.
        }
        size++; // Menambah ukuran antrian.
    }

    public Kendaraan removeFirst() { // Metode untuk menghapus dan mengembalikan elemen pertama dari antrian (dequeue).
        if (isEmpty()) { // Jika antrian kosong,
            return null; // Mengembalikan null karena tidak ada yang bisa dihapus.
        }
        Kendaraan data = head.data; // Menyimpan data dari head yang akan dihapus.
        head = head.next; // Head bergerak ke node berikutnya.
        if (head == null) { // Jika setelah penghapusan head menjadi null (antrian menjadi kosong),
            tail = null; // Tail juga diatur ke null.
        }
        size--; // Mengurangi ukuran antrian.
        return data; // Mengembalikan data Kendaraan yang dihapus.
    }

    public boolean isEmpty() { // Metode untuk memeriksa apakah antrian kosong.
        return head == null; // Mengembalikan true jika head null (antrian kosong), false jika tidak.
    }

    public int size() { // Metode untuk mendapatkan ukuran antrian.
        return size; // Mengembalikan nilai size.
    }

    public void display() { // Metode untuk menampilkan semua elemen dalam antrian.
        if (isEmpty()) { // Jika antrian kosong,
            System.out.println("Antrian kosong."); // Mencetak pesan bahwa antrian kosong.
            return; // Menghentikan eksekusi metode.
        }
        Node current = head; // Memulai dari head.
        int i = 1; // Inisialisasi nomor urut tampilan.
        while (current != null) { // Selama masih ada node,
            System.out.println(i + ". " + current.data.getPlatNomor() + " (" + current.data.getMerk() + " " + current.data.getTipe() + ")"); // Mencetak informasi kendaraan.
            current = current.next; // Pindah ke node berikutnya.
            i++; // Menambah nomor urut.
        }
    }
}

class HistoriTransaksi { // Deklarasi kelas HistoriTransaksi untuk menyimpan riwayat transaksi menggunakan array dinamis.
    TransaksiPengisian[] transaksi; // Array untuk menyimpan objek TransaksiPengisian.
    int size; // Ukuran riwayat transaksi (jumlah elemen).

    public HistoriTransaksi() { // Konstruktor HistoriTransaksi.
        transaksi = new TransaksiPengisian[10]; // Menginisialisasi array dengan kapasitas awal 10.
        size = 0; // Ukuran awal adalah 0.
    }

    public void add(TransaksiPengisian data) { // Metode untuk menambahkan transaksi ke riwayat.
        if (size == transaksi.length) { // Jika array penuh,
            resize(); // Panggil metode resize untuk menambah kapasitas.
        }
        transaksi[size++] = data; // Menambahkan data transaksi ke array dan menambah ukuran.
    }

    public void resize() { // Metode untuk menambah kapasitas array transaksi.
        int newCapacity = transaksi.length * 2; // Kapasitas baru adalah dua kali lipat kapasitas lama.
        TransaksiPengisian[] newtransaksi = new TransaksiPengisian[newCapacity]; // Membuat array baru dengan kapasitas yang lebih besar.
        for (int i = 0; i < size; i++) { // Menyalin elemen dari array lama ke array baru.
            newtransaksi[i] = transaksi[i];
        }
        transaksi = newtransaksi; // Mengganti array lama dengan array baru.
    }

    public TransaksiPengisian get(int index) { // Metode untuk mendapatkan transaksi berdasarkan indeks.
        if (index < 0 || index >= size) { // Memeriksa apakah indeks valid.
            System.out.println("Index tidak valid: " + index + ". Ukuran saat ini: " + size); // Mencetak pesan error jika indeks tidak valid.
            return null; // Mengembalikan null jika indeks tidak valid.
        }
        return transaksi[index]; // Mengembalikan objek TransaksiPengisian pada indeks yang diminta.
    }

    public int size() { // Metode untuk mendapatkan ukuran riwayat transaksi.
        return size; // Mengembalikan nilai size.
    }

    public boolean isEmpty() { // Metode untuk memeriksa apakah riwayat transaksi kosong.
        return size == 0; // Mengembalikan true jika size 0, false jika tidak.
    }
}

<<<<<<< HEAD
public class SPBU { // Deklarasi kelas utama SPBU.
    LLQueue antrianKendaraan; // Objek LLQueue untuk mengelola antrian kendaraan.
    HistoriTransaksi riwayatTransaksi; // Objek HistoriTransaksi untuk menyimpan riwayat transaksi.
    BBM[] daftarBBM; // Array untuk menyimpan daftar jenis BBM yang tersedia.
    int jumlahBBM = 0; // Jumlah jenis BBM yang saat ini ada dalam daftar.

    public SPBU() { // Konstruktor kelas SPBU.
        antrianKendaraan = new LLQueue(); // Menginisialisasi antrian kendaraan.
        riwayatTransaksi = new HistoriTransaksi(); // Menginisialisasi riwayat transaksi.
        daftarBBM = new BBM[5]; // Menginisialisasi array daftar BBM dengan kapasitas awal 5.
        tambahJenisBBM(new BBM("Pertalite", 10000.0)); // Menambahkan jenis BBM Pertalite.
        tambahJenisBBM(new BBM("Pertamax", 14000.0)); // Menambahkan jenis BBM Pertamax.
        tambahJenisBBM(new BBM("Pertamax Turbo", 15300.0)); // Menambahkan jenis BBM Pertamax Turbo.
    }

    public void tambahJenisBBM(BBM bbm) { // Metode untuk menambahkan jenis BBM baru ke daftar.
        if (jumlahBBM < daftarBBM.length) { // Jika kapasitas daftar BBM belum penuh,
            daftarBBM[jumlahBBM++] = bbm; // Menambahkan BBM ke array dan menambah jumlahBBM.
        } else { // Jika kapasitas daftar BBM penuh,
            System.out.println("Kapasitas daftar BBM penuh, tidak bisa menambah jenis BBM baru."); // Mencetak pesan error.
=======
public class SPBU {
    LLQueue antrianKendaraan; 
    HistoriTransaksi riwayatTransaksi; 
    bbm[] daftarBBM; 
    int jumlahBBM = 0; 

    public SPBU() {
        antrianKendaraan = new LLQueue();
        riwayatTransaksi = new HistoriTransaksi();
        daftarBBM = new bbm[5];
        tambahJenisBBM(new bbm("Pertalite", 10000.0));
        tambahJenisBBM(new bbm("Pertamax", 14000.0));
        tambahJenisBBM(new bbm("Pertamax Turbo", 15300.0));
    }

    public void tambahJenisBBM(bbm bbm) {
        if (jumlahBBM < daftarBBM.length) {
            daftarBBM[jumlahBBM++] = bbm;
        } else {
            System.out.println("Kapasitas daftar BBM penuh, tidak bisa menambah jenis BBM baru.");
>>>>>>> ff1f19ed23fc4b3428407eea02580798a5bc289d
        }
    }

    public void tambahAntrianKendaraan(Scanner scanner) { // Metode untuk menambahkan kendaraan ke antrian.
        System.out.println("\n--- Tambah Antrian Kendaraan ---"); // Mencetak header.
        System.out.print("Masukkan Plat Nomor: "); // Meminta input plat nomor.
        String platNomor = scanner.nextLine(); // Membaca plat nomor.
        System.out.print("Masukkan Tipe Kendaraan: "); // Meminta input tipe kendaraan.
        String tipe = scanner.nextLine(); // Membaca tipe kendaraan.
        System.out.print("Masukkan Merk: "); // Meminta input merk kendaraan.
        String merk = scanner.nextLine(); // Membaca merk kendaraan.

        Kendaraan newKendaraan = new Kendaraan(platNomor, tipe, merk); // Membuat objek Kendaraan baru.
        antrianKendaraan.addLast(newKendaraan); // Menambahkan kendaraan baru ke antrian.
        System.out.println(">> Kendaraan dengan plat " + platNomor + " berhasil ditambahkan ke antrian."); // Mencetak konfirmasi.
    }

    public void tampilkanAntrian() { // Metode untuk menampilkan daftar antrian kendaraan.
        System.out.println("\n--- Daftar Antrian Kendaraan Saat Ini ---"); // Mencetak header.
        antrianKendaraan.display(); // Memanggil metode display dari LLQueue untuk menampilkan antrian.
    }

    public void cekJumlahAntrianKendaraan() { // Metode untuk memeriksa jumlah kendaraan dalam antrian.
        System.out.println("\n--- Jumlah Antrian Kendaraan ---"); // Mencetak header.
        System.out.println("Jumlah kendaraan yang masih menunggu di antrian: " + antrianKendaraan.size()); // Mencetak jumlah kendaraan di antrian.
    }

    public void layaniKendaraan(Scanner scanner) { // Metode untuk melayani kendaraan dari antrian.
        System.out.println("\n--- Layani Kendaraan ---"); // Mencetak header.
        if (antrianKendaraan.isEmpty()) { // Jika antrian kosong,
            System.out.println("Tidak ada kendaraan dalam antrian untuk dilayani."); // Mencetak pesan.
            return; // Menghentikan eksekusi metode.
        }

        Kendaraan servedKendaraan = antrianKendaraan.removeFirst(); // Menghapus dan mendapatkan kendaraan pertama dari antrian.
        System.out.println("Melayani kendaraan: " + servedKendaraan.getPlatNomor()); // Mencetak plat nomor kendaraan yang dilayani.

        System.out.println("Pilih jenis BBM:"); // Meminta pengguna memilih jenis BBM.
        for (int i = 0; i < jumlahBBM; i++) { // Loop untuk menampilkan daftar BBM yang tersedia.
            System.out.println((i + 1) + ". " + daftarBBM[i].getNamaBBM() + " (Rp " + String.format("%.2f", daftarBBM[i].getHargaPerLiter()) + "/L)"); // Mencetak nama dan harga BBM.
        }
<<<<<<< HEAD
        BBM selectedBBM = null; // Variabel untuk menyimpan BBM yang dipilih.
        int pilihanBBM; // Variabel untuk menyimpan pilihan BBM dari pengguna.

        System.out.print("Masukkan pilihan BBM (nomor): "); // Meminta input pilihan BBM.
        pilihanBBM = Integer.parseInt(scanner.nextLine()); // Membaca pilihan BBM dan mengonversinya ke integer.

        if (pilihanBBM > 0 && pilihanBBM <= jumlahBBM) { // Memeriksa apakah pilihan BBM valid.
            selectedBBM = daftarBBM[pilihanBBM - 1]; // Mendapatkan BBM yang dipilih dari array.
        } else { // Jika pilihan tidak valid,
            System.out.println("Pilihan tidak valid. Menggunakan Pertalite sebagai default."); // Mencetak pesan peringatan.
            selectedBBM = daftarBBM[0]; // Mengatur Pertalite sebagai BBM default.
=======
        bbm selectedBBM = null;
        int pilihanBBM;
        
        System.out.print("Masukkan pilihan BBM (nomor): ");
        pilihanBBM = Integer.parseInt(scanner.nextLine()); 
        
        if (pilihanBBM > 0 && pilihanBBM <= jumlahBBM) {
            selectedBBM = daftarBBM[pilihanBBM - 1];
        } else {
            System.out.println("Pilihan tidak valid. Menggunakan Pertalite sebagai default."); 
            selectedBBM = daftarBBM[0]; 
>>>>>>> ff1f19ed23fc4b3428407eea02580798a5bc289d
        }

        double liter; // Variabel untuk menyimpan jumlah liter BBM.
        System.out.print("Masukkan jumlah liter BBM yang diisi: "); // Meminta input jumlah liter.
        liter = Double.parseDouble(scanner.nextLine()); // Membaca jumlah liter dan mengonversinya ke double.

        if (liter <= 0) { // Memeriksa apakah jumlah liter valid.
            System.out.println("Jumlah liter harus lebih dari 0. Menggunakan 1.0 liter sebagai default."); // Mencetak pesan peringatan.
            liter = 1.0; // Mengatur 1.0 liter sebagai jumlah default.
        }

        TransaksiPengisian transaksi = new TransaksiPengisian(servedKendaraan, selectedBBM, liter); // Membuat objek TransaksiPengisian baru.
        riwayatTransaksi.add(transaksi); // Menambahkan transaksi ke riwayat transaksi.
        System.out.println("Transaksi pengisian BBM berhasil dicatat."); // Mencetak konfirmasi.
        transaksi.tampilkanDetailTransaksi(); // Menampilkan detail transaksi.
    }

    public void tampilkanRiwayatTransaksi() { // Metode untuk menampilkan riwayat transaksi.
        System.out.println("\n--- Riwayat Transaksi Pengisian BBM ---"); // Mencetak header.
        if (riwayatTransaksi.isEmpty()) { // Jika riwayat transaksi kosong,
            System.out.println("Belum ada riwayat transaksi."); // Mencetak pesan.
        } else { // Jika ada riwayat transaksi,
            for (int i = 0; i < riwayatTransaksi.size(); i++) { // Loop melalui semua transaksi dalam riwayat.
                System.out.println("Transaksi ke-" + (i + 1)); // Mencetak nomor transaksi.
                riwayatTransaksi.get(i).tampilkanDetailTransaksi(); // Menampilkan detail transaksi individual.
                System.out.println(); // Mencetak baris kosong untuk pemisah.
            }
        }
    }
}