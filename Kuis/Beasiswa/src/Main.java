import java.util.*;

public class Main {
    public static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
            int opsi = menu();
            switch (opsi){
                case 1:
                    mahasiswa();
                    break;
                case 2:
                    pelajar();
                    break;
        }

    }

    public static int menu(){
        System.out.print("+---------------------------------+");
        System.out.print("| Pendaftaran Beasiswa PT. Benang |");
        System.out.print("+---------------------------------+");
        System.out.print("Terdapat 2 program beasiswa yang dibuka: ");
        System.out.print("1. Beasiswa Pelajar");
        System.out.print("2. Beasiswa Mahasiswa");
        System.out.print("Pilih beasiswa yang didaftar: ");
        return in.nextInt();
    }

    public static void mahasiswa(){
        String nama;
        int umur;
        boolean redo = true;

        while(redo) {
            System.out.println("=== FORM PENDAFTARAN ===");
            System.out.print("Nama Lengkap\t: ");
            nama = in.next();
            System.out.print("Usia\t\t: ");
            umur = in.nextInt();

            Mahasiswa mahasiswa = new Mahasiswa(nama, umur);
            formNilaiMahasiswa(mahasiswa);

            switch (subMenu()) {
                case 1:
                    if (umur >= 16 && umur <= 24 && mahasiswa.getTotal() >= 87.5)
                        mahasiswa.lolos();
                    else
                        mahasiswa.tidakLolos();
                    break;
                case 2:
                    formNilaiMahasiswa(mahasiswa);
                    break;
                case 3:
                    redo = false;
                    break;
            }
        }
    }

    public static void formNilaiMahasiswa(Mahasiswa mahasiswa) {
        System.out.println("== FORM PENILAIAN ==");
        System.out.println("Keterangan: Nilai yang valid berada di antara 0 - 100\n");

        System.out.println("Nilai Struktur dan Konten Jurnal: ");
        mahasiswa.setNilaiSkj(inputValidNumber());
        System.out.println("Nilai Relevansi Data: ");
        mahasiswa.setnilaiRd(inputValidNumber());
        System.out.println("Kemampuan Problem Solving: ");
        mahasiswa.setnilaiPs(inputValidNumber());
    }

    public static void pelajar(){
        String nama;
        int umur;
        boolean redo = true;

        while(redo) {
            System.out.println("== FORM PENDAFTARAN ==");
            System.out.print("Nama Lengkap\t: ");
            nama = in.next();
            System.out.print("Usia\t\t: ");
            umur = in.nextInt();

            Pelajar pelajar = new Pelajar(nama, umur);
            formNilaiPelajar(pelajar);

            boolean loop = true;
            while (loop) {
                switch (subMenu()) {
                    case 1:
                        if (umur >= 16 && umur <= 24 && pelajar.getTotal() >= 87.5)
                            pelajar.lolos();
                        else
                            pelajar.tidakLolos();
                        break;
                    case 2:
                        formNilaiPelajar(pelajar);
                        break;
                    case 3:
                        loop = false;
                        redo = false;
                        System.out.println("Terima Kasih!");
                        break;
                }
            }
        }
    }
    public static void formNilaiPelajar(Pelajar pelajar) {
        System.out.println("== FORM PENILAIAN ==");
        System.out.println("Keterangan: Nilai yang valid berada di antara 0 - 100\n");

        System.out.println("Nilai Struktur dan Konten Esai: ");
        pelajar.setnilaiSke(inputValidNumber());
        System.out.println("Nilai Teknik Visualisasi: ");
        pelajar.setnilaiTv(inputValidNumber());
        System.out.println("Nilai Design Thinking: ");
        pelajar.setnilaiDt(inputValidNumber());
    }
    public static double inputValidNumber(){
        double n = 0;
        boolean correct = false;
        while(!correct){
            try {
                n = in.nextDouble();
                correct = true;
            }catch (NumberFormatException e){
                System.out.print("");
            }
        }
        return n;
    }

    public static int Menu2(){
        boolean redo = true;
        int n = 0;
        while(redo) {
            System.out.println("+++ MENU +++");
            System.out.println("\t1. Tampilkan Hasil");
            System.out.println("\t2. Ubah Nilai");
            System.out.println("\t3. Keluar");
            System.out.print("Pilih: ");
            try {
                n = in.nextInt();
                if(n > 3 || n < 1)
                    throw new NumberFormatException("");
                else redo = false;
            }catch (NumberFormatException e){
                System.out.print(e);
            }
        }
        return n;
    }
}
