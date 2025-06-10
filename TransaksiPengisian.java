class TransaksiPengisian { // Deklarasi kelas bernama TransaksiPengisian.
    
    Kendaraan kendaraan; // Mendeklarasikan variabel instance untuk menyimpan objek Kendaraan yang melakukan transaksi.
    BBM bbm; // Mendeklarasikan variabel instance untuk menyimpan objek BBM yang diisi.
    double liter; // Mendeklarasikan variabel instance untuk menyimpan jumlah liter BBM yang diisi.
    double totalBayar; // Mendeklarasikan variabel instance untuk menyimpan total biaya transaksi.

    public TransaksiPengisian(Kendaraan kendaraan, BBM bbm, double liter) { // Konstruktor kelas TransaksiPengisian.
        this.kendaraan = kendaraan; // Menginisialisasi kendaraan dengan objek Kendaraan yang diberikan.
        this.bbm = bbm; // Menginisialisasi bbm dengan objek BBM yang diberikan.
        this.liter = liter; // Menginisialisasi liter dengan jumlah liter yang diberikan.
        this.totalBayar = liter * bbm.getHargaPerLiter(); // Menghitung totalBayar berdasarkan jumlah liter dan harga per liter BBM.
    }

    public Kendaraan getKendaraan() { // Metode getter untuk mendapatkan objek Kendaraan dari transaksi.
        return kendaraan; // Mengembalikan objek kendaraan.
    }

    public BBM getBbm() { // Metode getter untuk mendapatkan objek BBM dari transaksi.
        return bbm; // Mengembalikan objek bbm.
    }

    public double getLiter() { // Metode getter untuk mendapatkan jumlah liter BBM yang diisi.
        return liter; // Mengembalikan nilai liter.
    }

    public double getTotalBayar() { // Metode getter untuk mendapatkan total pembayaran transaksi.
        return totalBayar; // Mengembalikan nilai totalBayar.
    }

    public void tampilkanDetailTransaksi() { // Metode untuk menampilkan detail lengkap dari transaksi.
        System.out.println("--- Detail Transaksi ---"); // Mencetak header detail transaksi.
        System.out.printf("Kendaraan      : %s (%s %s)%n", kendaraan.getPlatNomor(), kendaraan.getMerk(), kendaraan.getTipe()); // Mencetak plat nomor, merk, dan tipe kendaraan.
        System.out.printf("Jenis BBM      : %s%n", bbm.getNamaBBM()); // Mencetak jenis BBM.
        System.out.printf("Harga per Liter: Rp %.2f%n", bbm.getHargaPerLiter()); // Mencetak harga per liter BBM dengan format dua desimal.
        System.out.printf("Jumlah Liter   : %.2f L%n", liter); // Mencetak jumlah liter BBM dengan format dua desimal.
        System.out.printf("Total Bayar    : Rp %.2f%n", totalBayar); // Mencetak total pembayaran dengan format dua desimal.
        System.out.println("------------------------"); // Mencetak footer detail transaksi.
    }
}