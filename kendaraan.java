public class kendaraan {
    public String platNomor;
    public String tipe;
    public String merk;

    public kendaraan(String platNomor, String tipe, String merk) {
        this.platNomor = platNomor;
        this.tipe = tipe;
        this.merk = merk;
    }

    public void tampilkanInformasi() {
        System.out.println("Plat Nomor: " + platNomor);
        System.out.println("Tipe: " + tipe);
        System.out.println("Merk: " + merk);
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getTipe() {
        return tipe;
    }

    public String getMerk() {
        return merk;
    }

    
    public String toString() {
        return "Kendaraan [platNomor=" + platNomor + ", tipe=" + tipe + ", merk=" + merk + "]";
    }
}
