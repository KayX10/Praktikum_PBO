import java.util.*;

public class Main{
    double ske, tk, kds, rerata;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("+------------------------------+");
        System.out.println("Pendaftaran Beasiswa PT. Benang");
        System.out.println("+------------------------------+");
        System.out.println("Terdapat 2 Program Beasiswa");
        System.out.println("1. Beasiswa Mahasiswa");
        System.out.println("2. Beasiswa Pelajar");

        System.out.print("Pilih Beasiswa yang didaftar : ");
        int pilih = input.nextInt();

        System.out.println();
        // Menu
        switch(pilih){
            case 1 :{
                Scanner input2 = new Scanner(System.in);
                System.out.println("== FORM PENDAFTARAN ==");
                System.out.print("Nama Lengkap : ");
                String nama = input2.nextLine();
                System.out.print("Usia : ");
                int usia = input2.nextInt();

                System.out.println("== FORM PENILAIAN ==");
                System.out.println("Keterangan : Nilai yang valid berada di antara 0 - 100");
                System.out.println();
                System.out.print("Nilai Struktur dan Konten Esai : ");
                double ske = input2.nextInt();
                System.out.println();
                System.out.print("Nilai Teknik Visualisasi : ");
                double tk = input2.nextInt();
                System.out.println();
                System.out.print("Nilai Kemampuan Design Thinking : ");
                double kds = input2.nextInt();
                System.out.println();
                double rerata = (ske+tk+kds)/2;

                System.out.println("+++ MENU +++");
                System.out.println("1. Tampilkan Hasil");
                System.out.println("2. Ubah Nilai");
                System.out.println("3. Keluar");
                System.out.print("Pilih : ");
                int pilih2 = input2.nextInt();

            }
            case 2 :{
                Scanner input3 = new Scanner(System.in);
                System.out.println("== FORM PENDAFTARAN ==");
                System.out.print("Nama Lengkap : ");
                String nama = input3.nextLine();
                System.out.print("Usia : ");
                int usia = input3.nextInt();

                System.out.println("== FORM PENILAIAN ==");
                System.out.println("Keterangan : Nilai yang valid berada di antara 0 - 100");
                System.out.println();
                System.out.print("Nilai Struktur dan Konten Esai : ");
                int ske = input3.nextInt();
                System.out.println();
                System.out.print("Nilai Teknik Visualisasi : ");
                int tk = input3.nextInt();
                System.out.println();
                System.out.print("Nilai Kemampuan Design Thinking : ");
                int kds = input3.nextInt();
                System.out.println();

                System.out.println("+++ MENU +++");
                System.out.println("1. Tampilkan Hasil");
                System.out.println("2. Ubah Nilai");
                System.out.println("3. Keluar");
                System.out.print("Pilih : ");
                int pilih3 = input3.nextInt();

                switch(pilih3){
                    case 1:{

                    }
                    case 2:{
                        
                    }
                    case 3:{
                        System.out.println("Terima kasih!");
                    }
                }
            }
        }
    }
}
