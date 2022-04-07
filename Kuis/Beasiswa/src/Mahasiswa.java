import beasiswa.BeasiswaMahasiswa;

public class Mahasiswa implements BeasiswaMahasiswa {
    private String nama;
    private int umur;
    private double nilaiSkj;
    private double nilaiRd;
    private double nilaiPs;

    public Mahasiswa(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        nilaiSkj = 0;
        nilaiRd = 0;
        nilaiPs = 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public double getTotal() {
        return Ps() + Skj() + Rd();
    }

    public double getNilaiSkj() {
        return nilaiSkj;
    }

    public void setNilaiSkj(double nilaiSkj) {
        this.nilaiSkj = nilaiSkj;
    }

    public double getnilaiRd() {
        return nilaiRd;
    }

    public void setnilaiRd(double nilaiRd) {
        this.nilaiRd = nilaiRd;
    }

    public double getnilaiPs() {
        return nilaiPs;
    }

    public void setnilaiPs(double nilaiPs) {
        this.nilaiPs = nilaiPs;
    }

    public void lolos(){
        System.out.println("Selamat! " + nama + "(" + umur + " tahun)" +
                "dinyatakan diterima pada program BEASISWA MAHASISWA karena" +
                "mencapai nilai yang diharapkan pada tahap seleksi.");
    }
    public void tidakLolos(){
        System.out.print("Mohon maaf, " + nama + "(" + umur + " tahun)" +
                "dinyatakan tidak diterima pada program BEASISWA MAHASISWA karena ");
        if(umur < 16 || umur > 24){
            System.out.println("memiliki usia yang tidak sesuai dengan prasyaratan penerima beasiswa");
        }else if (getTotal() < rerata){
            System.out.println("belum mencapai nilai yang diharapkan pada tahap seleksi");
        }
    }

    @Override
    public double Skj() {
        return nilaiSkj*0.6;
    }

    @Override
    public double Rd() {
        return nilaiRd*0.25;
    }

    @Override
    public double Ps() {
        return nilaiPs*0.15;
    }
}