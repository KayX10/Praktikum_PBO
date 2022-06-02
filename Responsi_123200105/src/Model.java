/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;

/**
 *
 * @author Asus
 */
public class Model {

    String DBurl = "jdbc:mysql://localhost/movie_db";
    String DBusername = "root";
    String DBpassword = "";
    Connection koneksi;
    Statement statement;

    public Model() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Koneksi Berhasil");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Koneksi Gagal");
            System.out.println(ex);
        }
    }

    public String[][] DaftarFilm() { 

        try {
            int jmlData = 0;

            String data[][] = new String[getBanyakData()][5]; 

            String query = "Select * from movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[jmlData][0] = resultSet.getString("judul"); 
                data[jmlData][1] = resultSet.getString("alur");
                data[jmlData][2] = resultSet.getString("penokohan");
                data[jmlData][3] = resultSet.getString("akting");
                data[jmlData][4] = resultSet.getString("nilai");
                jmlData++;
            }
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Execute Failed");
            return null;
        }
    }

    public void insertFilm(String judul, String alur, String penokohan, String akting) {
        int jmlData = 0;
        double nilai_alur = Float.parseFloat(alur);
        double nilai_penokohan = Float.parseFloat(penokohan);
        double nilai_akting = Float.parseFloat(akting);
        double nilai = (nilai_alur + nilai_penokohan + nilai_akting) / 3;
        try {
            String query = "Select * from movie WHERE judul = '" + judul + "' ";
            System.out.println(judul + " " + nilai_alur + " " + nilai_penokohan + " " + nilai_akting + " " + nilai);
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 0) {
                query = "INSERT INTO movie VALUES('" + judul + "','" + nilai_alur + "','" + nilai_penokohan + "','" + nilai_akting + "','" + nilai + "')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (HeadlessException | SQLException sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }

    }

    public void updateFilm(String judul, String alur, String penokohan, String akting) {
        int jmlData = 0;
        double nilai_alur = Float.parseFloat(alur);
        double nilai_penokohan = Float.parseFloat(penokohan);
        double nilai_akting = Float.parseFloat(akting);
        double nilai = (nilai_alur + nilai_penokohan + nilai_akting) / 3;
        try {
            String query = "Select * from movie WHERE judul= '" + judul + "' ";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                jmlData++;
            }

            if (jmlData == 1) {
                query = "UPDATE movie SET alur='" + nilai_alur + "', penokohan='" + nilai_penokohan + "', nilai='" + nilai + "', akting = '" + akting + "' WHERE judul='" + judul + "'";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil diupdate");
                JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak Ada");
            }

        } catch (HeadlessException | SQLException sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }

    public int getBanyakData() {
        int jmlData = 0;
        try {
            statement = koneksi.createStatement();
            String query = "Select * from movie";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                jmlData++;
            }
            return jmlData;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public void deleteFilm(String judul) {
        try {
            String query = "DELETE FROM movie WHERE judul = '" + judul + "'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");

        } catch (SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

}
