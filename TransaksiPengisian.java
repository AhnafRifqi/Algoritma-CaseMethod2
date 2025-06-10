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

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public bbm getBbm() {
        return bbm;
    }

    public double getLiter() {
        return liter;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public void tampilkanDetailTransaksi() {
        System.out.println("--- Detail Transaksi ---");
        System.out.printf("Kendaraan      : %s (%s %s)%n", kendaraan.getPlatNomor(), kendaraan.getMerk(), kendaraan.getTipe());
        System.out.printf("Jenis BBM      : %s%n", bbm.getNamaBBM());
        System.out.printf("Harga per Liter: Rp %.2f%n", bbm.getHargaPerLiter());
        System.out.printf("Jumlah Liter   : %.2f L%n", liter);
        System.out.printf("Total Bayar    : Rp %.2f%n", totalBayar);
        System.out.println("------------------------");
    }
}