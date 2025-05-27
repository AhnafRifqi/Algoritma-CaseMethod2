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

// Main SPBU System Class
public class SPBU {

    private CustomLinkedListQueue antrianKendaraan; // Custom LinkedList as a Queue
    private CustomArrayTransactionHistory riwayatTransaksi; // Custom Array to store history
    private BBM[] daftarBBM; // Simple array for BBM types
    private int jumlahBBM = 0; // Counter for actual number of BBM types

    public SPBU() {
        antrianKendaraan = new CustomLinkedListQueue();
        riwayatTransaksi = new CustomArrayTransactionHistory();
        daftarBBM = new BBM[5]; // Fixed size for available BBM types for simplicity.
                                 // This can be changed or made dynamic similarly to CustomArrayTransactionHistory.
        // Initialize some BBM types
        tambahJenisBBM(new BBM("Pertalite", 10000.0));
        tambahJenisBBM(new BBM("Pertamax", 14000.0));
        tambahJenisBBM(new BBM("Pertamax Turbo", 15300.0));
    }

    // Helper method to add BBM types to our simple array
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
        antrianKendaraan.addLast(newKendaraan); // Adds to the end of the queue
        System.out.println("Kendaraan dengan plat " + platNomor + " berhasil ditambahkan ke antrian.");
    }

    public void tampilkanAntrian() {
        System.out.println("\n--- Daftar Antrian Kendaraan Saat Ini ---");
        antrianKendaraan.display(); // Uses the custom display method
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

        Kendaraan servedKendaraan = antrianKendaraan.removeFirst(); // Removes the head of the queue
        System.out.println("Melayani kendaraan: " + servedKendaraan.getPlatNomor());

        System.out.println("Pilih jenis BBM:");
        for (int i = 0; i < jumlahBBM; i++) { // Iterate only up to actual number of BBMs
            System.out.println((i + 1) + ". " + daftarBBM[i].getNamaBBM() + " (Rp " + String.format("%.2f", daftarBBM[i].getHargaPerLiter()) + "/L)");
        }
        BBM selectedBBM = null;
        int pilihanBBM;
        while (true) {
            System.out.print("Masukkan pilihan BBM (nomor): ");
            try {
                pilihanBBM = Integer.parseInt(scanner.nextLine());
                if (pilihanBBM > 0 && pilihanBBM <= jumlahBBM) {
                    selectedBBM = daftarBBM[pilihanBBM - 1];
                    break;
                } else {
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }

        double liter;
        while (true) {
            System.out.print("Masukkan jumlah liter BBM yang diisi: ");
            try {
                liter = Double.parseDouble(scanner.nextLine());
                if (liter > 0) {
                    break;
                } else {
                    System.out.println("Jumlah liter harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }

        TransaksiPengisian transaksi = new TransaksiPengisian(servedKendaraan, selectedBBM, liter);
        riwayatTransaksi.add(transaksi); // Add to the end of the history list
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
                System.out.println(); // Add a blank line for readability
            }
        }
    }

    public void tampilkanMenu() {
        System.out.println("\nMenu SPBU");
        System.out.println("1. Tambah Antrian Kendaraan");
        System.out.println("2. Tampilkan Antrian");
        System.out.println("3. Cek Jumlah Antrian Kendaraan");
        System.out.println("4. Layani Kendaraan");
        System.out.println("5. Tampilkan Riwayat Transaksi");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    public static void main(String[] args) {
        SPBU spbu = new SPBU();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            spbu.tampilkanMenu();
            try {
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
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                pilihan = -1; // To keep the loop running
            }
        } while (pilihan != 0);

        scanner.close();
    }
}