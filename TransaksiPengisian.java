
class TransaksiPengisian {
    private Kendaraan kendaraan;
    private BBM bbm;
    private double liter;
    private double totalBayar;

    public TransaksiPengisian(Kendaraan kendaraan, BBM bbm, double liter) {
        this.kendaraan = kendaraan;
        this.bbm = bbm;
        this.liter = liter;
        this.totalBayar = liter * bbm.getHargaPerLiter();
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public BBM getBbm() {
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
        System.out.println("Kendaraan: " + kendaraan.getPlatNomor() + " (" + kendaraan.getMerk() + " " + kendaraan.getTipe() + ")");
        System.out.println("Jenis BBM: " + bbm.getNamaBBM());
        System.out.println("Harga per Liter: Rp " + String.format("%.2f", bbm.getHargaPerLiter()));
        System.out.println("Jumlah Liter: " + String.format("%.2f", liter) + " L");
        System.out.println("Total Bayar: Rp " + String.format("%.2f", totalBayar));
        System.out.println("------------------------");
    }
}