import java.util.Scanner;

class Node {
    Kendaraan data;
    Node next;

    public Node(Kendaraan data) {
        this.data = data;
        this.next = null;
    }
}

class LLQueue {
    Node head;
    Node tail;
    int size;

    public LLQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addLast(Kendaraan data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public Kendaraan removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Kendaraan data = head.data;
        head = head.next;
        if (head == null) { 
            tail = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
            return;
        }
        Node current = head;
        int i = 1;
        while (current != null) {
            System.out.println(i + ". " + current.data.getPlatNomor() + " (" + current.data.getMerk() + " " + current.data.getTipe() + ")");
            current = current.next;
            i++;
        }
    }
}

class HistoriTransaksi {
    TransaksiPengisian[] transaksi;
    int size;

    public HistoriTransaksi() {
        transaksi = new TransaksiPengisian[10]; 
        size = 0;
    }

    public void add(TransaksiPengisian data) {
        if (size == transaksi.length) {
            resize();
        }
        transaksi[size++] = data;
    }

    public void resize() {
        int newCapacity = transaksi.length * 2;
        TransaksiPengisian[] newtransaksi = new TransaksiPengisian[newCapacity];
        for (int i = 0; i < size; i++) {
            newtransaksi[i] = transaksi[i];
        }
        transaksi = newtransaksi;
    }

    public TransaksiPengisian get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index tidak valid: " + index + ". Ukuran saat ini: " + size);
            return null;
        }
        return transaksi[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class SPBU {
    LLQueue antrianKendaraan; 
    HistoriTransaksi riwayatTransaksi; 
    BBM[] daftarBBM; 
    int jumlahBBM = 0; 

    public SPBU() {
        antrianKendaraan = new LLQueue();
        riwayatTransaksi = new HistoriTransaksi();
        daftarBBM = new BBM[5];
        tambahJenisBBM(new BBM("Pertalite", 10000.0));
        tambahJenisBBM(new BBM("Pertamax", 14000.0));
        tambahJenisBBM(new BBM("Pertamax Turbo", 15300.0));
    }

    public void tambahJenisBBM(BBM bbm) {
        if (jumlahBBM < daftarBBM.length) {
            daftarBBM[jumlahBBM++] = bbm;
        } else {
            System.out.println("Kapasitas daftar BBM penuh, tidak bisa menambah jenis BBM baru.");
        }
    }

    public void tambahAntrianKendaraan(Scanner scanner) {
        System.out.println("\n--- Tambah Antrian Kendaraan ---");
        System.out.print("Masukkan Plat Nomor: ");
        String platNomor = scanner.nextLine();
        System.out.print("Masukkan Tipe Kendaraan: ");
        String tipe = scanner.nextLine();
        System.out.print("Masukkan Merk: ");
        String merk = scanner.nextLine();

        Kendaraan newKendaraan = new Kendaraan(platNomor, tipe, merk);
        antrianKendaraan.addLast(newKendaraan);
        System.out.println(">> Kendaraan dengan plat " + platNomor + " berhasil ditambahkan ke antrian.");
    }

    public void tampilkanAntrian() {
        System.out.println("\n--- Daftar Antrian Kendaraan Saat Ini ---");
        antrianKendaraan.display();
    }

    public void cekJumlahAntrianKendaraan() {
        System.out.println("\n--- Jumlah Antrian Kendaraan ---");
        System.out.println("Jumlah kendaraan yang masih menunggu di antrian: " + antrianKendaraan.size());
    }

    public void layaniKendaraan(Scanner scanner) {
        System.out.println("\n--- Layani Kendaraan ---");
        if (antrianKendaraan.isEmpty()) {
            System.out.println("Tidak ada kendaraan dalam antrian untuk dilayani.");
            return;
        }

        Kendaraan servedKendaraan = antrianKendaraan.removeFirst();
        System.out.println("Melayani kendaraan: " + servedKendaraan.getPlatNomor());

        System.out.println("Pilih jenis BBM:");
        for (int i = 0; i < jumlahBBM; i++) {
            System.out.println((i + 1) + ". " + daftarBBM[i].getNamaBBM() + " (Rp " + String.format("%.2f", daftarBBM[i].getHargaPerLiter()) + "/L)");
        }
        BBM selectedBBM = null;
        int pilihanBBM;
        
        System.out.print("Masukkan pilihan BBM (nomor): ");
        pilihanBBM = Integer.parseInt(scanner.nextLine()); 
        
        if (pilihanBBM > 0 && pilihanBBM <= jumlahBBM) {
            selectedBBM = daftarBBM[pilihanBBM - 1];
        } else {
            System.out.println("Pilihan tidak valid. Menggunakan Pertalite sebagai default."); 
            selectedBBM = daftarBBM[0]; 
        }

        double liter;
        System.out.print("Masukkan jumlah liter BBM yang diisi: ");
        liter = Double.parseDouble(scanner.nextLine()); 
        
        if (liter <= 0) {
            System.out.println("Jumlah liter harus lebih dari 0. Menggunakan 1.0 liter sebagai default."); 
            liter = 1.0;
        }
        
        TransaksiPengisian transaksi = new TransaksiPengisian(servedKendaraan, selectedBBM, liter);
        riwayatTransaksi.add(transaksi);
        System.out.println("Transaksi pengisian BBM berhasil dicatat.");
        transaksi.tampilkanDetailTransaksi();
    }

    public void tampilkanRiwayatTransaksi() {
        System.out.println("\n--- Riwayat Transaksi Pengisian BBM ---");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada riwayat transaksi.");
        } else {
            for (int i = 0; i < riwayatTransaksi.size(); i++) {
                System.out.println("Transaksi ke-" + (i + 1));
                riwayatTransaksi.get(i).tampilkanDetailTransaksi();
                System.out.println();
            }
        }
    }
}