class BBM { // Deklarasi kelas bernama BBM.
    
    String namaBBM; // Mendeklarasikan variabel instance untuk menyimpan nama BBM (misalnya, "Pertalite").
    double hargaPerLiter; // Mendeklarasikan variabel instance untuk menyimpan harga BBM per liter.

    public BBM(String namaBBM, double hargaPerLiter) { // Konstruktor kelas BBM, digunakan untuk membuat objek BBM baru.
        this.namaBBM = namaBBM; // Menginisialisasi namaBBM dengan nilai yang diberikan saat objek dibuat.
        this.hargaPerLiter = hargaPerLiter; // Menginisialisasi hargaPerLiter dengan nilai yang diberikan.
    }

    public String getNamaBBM() { // Metode getter untuk mendapatkan nama BBM.
        return namaBBM; // Mengembalikan nilai dari namaBBM.
    }

    public double getHargaPerLiter() { // Metode getter untuk mendapatkan harga per liter BBM.
        return hargaPerLiter; // Mengembalikan nilai dari hargaPerLiter.
    }

    public String toString() { // Metode toString() yang dioverride untuk memberikan representasi string dari objek BBM.
        return "BBM [namaBBM=" + namaBBM + ", hargaPerLiter=" + hargaPerLiter + "]"; // Mengembalikan string yang berisi namaBBM dan hargaPerLiter.
    }
}