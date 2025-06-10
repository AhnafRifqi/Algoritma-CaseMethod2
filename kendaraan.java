class Kendaraan { // Deklarasi kelas bernama Kendaraan.
    
    String platNomor; // Mendeklarasikan variabel instance untuk menyimpan plat nomor kendaraan.
    String tipe; // Mendeklarasikan variabel instance untuk menyimpan tipe kendaraan (misalnya, "Mobil", "Motor").
    String merk; // Mendeklarasikan variabel instance untuk menyimpan merk kendaraan.

    public Kendaraan(String platNomor, String tipe, String merk) { // Konstruktor kelas Kendaraan, digunakan untuk membuat objek Kendaraan baru.
        this.platNomor = platNomor; // Menginisialisasi platNomor dengan nilai yang diberikan.
        this.tipe = tipe; // Menginisialisasi tipe dengan nilai yang diberikan.
        this.merk = merk; // Menginisialisasi merk dengan nilai yang diberikan.
    }

    public void tampilkanInformasi() { // Metode untuk menampilkan informasi lengkap kendaraan.
        System.out.println("Plat Nomor: " + platNomor); // Mencetak plat nomor.
        System.out.println("Tipe: " + tipe); // Mencetak tipe kendaraan.
        System.out.println("Merk: " + merk); // Mencetak merk kendaraan.
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getTipe() { // Metode getter untuk mendapatkan tipe kendaraan.
        return tipe; // Mengembalikan nilai dari tipe.
    }

    public String getMerk() { // Metode getter untuk mendapatkan merk kendaraan.
        return merk; // Mengembalikan nilai dari merk.
    }

    public String toString() { // Metode toString() yang dioverride untuk memberikan representasi string dari objek Kendaraan.
        return "Kendaraan [platNomor=" + platNomor + ", tipe=" + tipe + ", merk=" + merk + "]"; // Mengembalikan string yang berisi platNomor, tipe, dan merk.
    }
}
