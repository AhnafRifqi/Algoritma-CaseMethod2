class BBM {
    String namaBBM;
    double hargaPerLiter;

    public BBM(String namaBBM, double hargaPerLiter) {
        this.namaBBM = namaBBM;
        this.hargaPerLiter = hargaPerLiter;
    }

    public String getNamaBBM() {
        return namaBBM;
    }

    public double getHargaPerLiter() {
        return hargaPerLiter;
    }

    public String toString() {
        return "BBM [namaBBM=" + namaBBM + ", hargaPerLiter=" + hargaPerLiter + "]";
    }
}