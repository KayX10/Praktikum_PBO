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
public class Convert_KevinArielYap {
    double celcius;

    public Convert_KevinArielYap(double celcius) {
        this.celcius = celcius;
    };
    
    int hitungNilai(){
        double R = (4*this.celcius)/5;
        double F = ((9*this.celcius)/5)+32;
        double K = this.celcius + 273.15;
        
        System.out.println("Suhu dalam Celcius\t: " + this.celcius + "°C");
        System.out.println("Suhu dalam Fahrenheit\t: " + F + "°F");
        System.out.println("Suhu dalam Reamur\t: " + R + "°R");
        System.out.println("Suhu dalam Kelvin\t: " + K + "°K");
        
        if (this.celcius <= 0){
            System.out.println("Kondisi air beku.\n");
        }
        else if (this.celcius > 0 && this.celcius < 100){
            System.out.println("Kondisi air normal.\n");
        }
        else{
            System.out.println("Kondisi air mendidih.\n");
        }
        
        return 0;
    };    
}