import beasiswa.BeasiswaPelajar;

public class Pelajar implements BeasiswaPelajar {
    private String nama;
    private int umur;
    private double nilaiSke;
    private double nilaiTv;
    private double nilaiDt;

    public Pelajar(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
        nilaiSke = 0;
        nilaiTv = 0;
        nilaiDt = 0;
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

    public double getnilaiSke() {
        return nilaiSke;
    }

    public void setnilaiSke(double nilaiSke) {
        this.nilaiSke = nilaiSke;
    }

    public double getnilaiTv() {
        return nilaiTv;
    }

    public void setnilaiTv(double nilaiTv) {
        this.nilaiTv = nilaiTv;
    }

    public double getnilaiDt() {
        return nilaiDt;
    }

    public void setnilaiDt(double nilaiDt) {
        this.nilaiDt = nilaiDt;
    }

    public double getTotal(){
        return Ske() + Tv() +Dt();
    }

    public void lolos(){
        System.out.println("Selamat! " + nama + "(" + umur + " tahun)" +
                "dinyatakan diterima pada program BEASISWA PELAJAR karena" +
                "mencapai nilai yang diharapkan pada tahap seleksi.");
    }
    public void tidakLolos(){
        System.out.print("Mohon maaf, " + nama + "(" + umur + " tahun)" +
                "dinyatakan tidak diterima pada program BEASISWA PELAJAR karena ");
        if(umur < 16 || umur > 24){
            System.out.println("memiliki usia yang tidak sesuai dengan prasyaratan penerima beasiswa");
        }else if (getTotal() < rerata){
            System.out.println("belum mencapai nilai yang diharapkan pada tahap seleksi");
        }
    }

    @Override
    public double Ske() {
        return nilaiSke*0.5;
    }

    @Override
    public double Tv() {
        return nilaiTv*0.2;
    }

    @Override
    public double Dt() {
        return nilaiDt*0.3;
    }
}