// SPBU.java
import java.util.Scanner;

// --- Custom Data Structures ---

// Custom Node for LinkedList
class Node {
    Kendaraan data;
    Node next;

    public Node(Kendaraan data) {
        this.data = data;
        this.next = null;
    }
}

// Custom LinkedList to act as a Queue for Kendaraan
class CustomLinkedListQueue {
    private Node head;
    private Node tail;
    private int size;

    public CustomLinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add to the end (enqueue)
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

    // Remove from the beginning (dequeue)
    public Kendaraan removeFirst() {
        if (isEmpty()) {
            return null; // Or throw an exception if preferred for a proper queue
        }
        Kendaraan data = head.data;
        head = head.next;
        if (head == null) { // If the list becomes empty
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

    // Method to iterate and display elements (instead of get(index))
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

// Custom Array-based structure for storing TransaksiPengisian (simulating ArrayList/Queue)
class CustomArrayTransactionHistory {
    private TransaksiPengisian[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10; // Initial capacity

    public CustomArrayTransactionHistory() {
        elements = new TransaksiPengisian[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(TransaksiPengisian data) {
        if (size == elements.length) {
            resize(); // Double the capacity if full
        }
        elements[size++] = data;
    }

    private void resize() {
        int newCapacity = elements.length * 2;
        TransaksiPengisian[] newElements = new TransaksiPengisian[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    public TransaksiPengisian get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

// SPBU System Class (without main method)
public class SPBU {

    private CustomLinkedListQueue antrianKendaraan; // Custom LinkedList as a Queue
    private CustomArrayTransactionHistory riwayatTransaksi; // Custom Array to store history
    private BBM[] daftarBBM; // Simple array for BBM types
    private int jumlahBBM = 0; // Counter for actual number of BBM types

    public SPBU() {
        antrianKendaraan = new CustomLinkedListQueue();
        riwayatTransaksi = new CustomArrayTransactionHistory();
        daftarBBM = new BBM[5]; // Fixed size for available BBM types for simplicity.
        tambahJenisBBM(new BBM("Pertalite", 10000.0));
        tambahJenisBBM(new BBM("Pertamax", 14000.0));
        tambahJenisBBM(new BBM("Pertamax Turbo", 15300.0));
    }

    private void tambahJenisBBM(BBM bbm) {
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
        System.out.print("Masukkan Merk Kendaraan: ");
        String merk = scanner.nextLine();

        Kendaraan newKendaraan = new Kendaraan(platNomor, tipe, merk);
        antrianKendaraan.addLast(newKendaraan);
        System.out.println("Kendaraan dengan plat " + platNomor + " berhasil ditambahkan ke antrian.");
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
        pilihanBBM = Integer.parseInt(scanner.nextLine()); // NO TRY-CATCH
        
        if (pilihanBBM > 0 && pilihanBBM <= jumlahBBM) {
            selectedBBM = daftarBBM[pilihanBBM - 1];
        } else {
            System.out.println("Pilihan tidak valid. Menggunakan Pertalite sebagai default."); // Fallback if invalid
            selectedBBM = daftarBBM[0]; // Default to first BBM type
        }
        

        double liter;
        System.out.print("Masukkan jumlah liter BBM yang diisi: ");
        liter = Double.parseDouble(scanner.nextLine()); // NO TRY-CATCH
        
        if (liter <= 0) {
            System.out.println("Jumlah liter harus lebih dari 0. Menggunakan 1.0 liter sebagai default."); // Fallback if invalid
            liter = 1.0; // Default to 1 liter
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