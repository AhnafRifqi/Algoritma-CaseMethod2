class TransaksiPengisian {
    Kendaraan kendaraan;
    bbm bbm;
    double liter;
    double totalBayar;

    public TransaksiPengisian(Kendaraan kendaraan, bbm bbm, double liter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        this.totalBayar = liter * bbm.getHargaPerLiter();
    }

    public Kendaraan getKendaraan() { // Metode getter untuk mendapatkan objek Kendaraan dari transaksi.
        return kendaraan; // Mengembalikan objek kendaraan.
    }

    public bbm getBbm() {
        return bbm;
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