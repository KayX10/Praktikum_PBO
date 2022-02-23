/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prak.pbo_kevinarielyap;

/**
 *
 * @author ASUS
 */
import java.util.Scanner;

public class PrakPBO_KevinArielYap {
    public static void main(String[] args) {
        boolean loop1 = true;
        Scanner input = new Scanner(System.in);
        
        while(loop1){
            System.out.println("-------------------------");
            System.out.println("PROGRAM KONVERSI SUHU AIR");
            System.out.println("-------------------------");
            System.out.println("Input Data");
            System.out.printf("Suhu dalam Celcius: ");
            double celcius = input.nextInt();
            System.out.println("");
            
            Convert_KevinArielYap nilaiSuhu = new Convert_KevinArielYap (celcius);
            boolean loop2 = true;

            do{
                System.out.println("Opsi");
                System.out.println("1. Lihat Data Konversi");
                System.out.println("2. Edit Data Konversi");
                System.out.println("3. Exit");
                System.out.printf("Pilih: ");
                int pilih = input.nextInt();
                System.out.println("");

                if (pilih == 1){
                    nilaiSuhu.hitungNilai();
                }
                else if (pilih == 2){
                    loop2 = false;
                }
                else if (pilih == 3){
                    loop2 = false;
                    loop1 = false;
                }
                else{
                    System.out.println("Input tidak valid. Silakan ulang.\n");
                    continue;
                }
            }while(loop2);
        }
    }
}