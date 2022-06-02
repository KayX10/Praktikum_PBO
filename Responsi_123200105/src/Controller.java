/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Asus
 */
public class Controller {

    Model model;
    View view;

    public String dataterpilih;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0) {
            String dataFilm[][] = model.DaftarFilm();
            view.tabel.setModel((new JTable(dataFilm, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Masih Belum Terisi");
        }

        view.btnTambah.addActionListener((ActionEvent ae) -> {
            String judul = view.getJudul();
            String alur = view.getAlur();
            String penokohan = view.getPenokohan();
            String akting = view.getAkting();
            model.insertFilm(judul, alur, penokohan, akting);
            
            String dataFilm[][] = model.DaftarFilm();
            view.tabel.setModel((new JTable(dataFilm, view.namaKolom)).getModel());
        });

        view.btnUpdate.addActionListener((ActionEvent ae) -> {
            String judul = view.getJudul();
            String alur = view.getAlur();
            String penokohan = view.getPenokohan();
            String akting = view.getAkting();
            model.updateFilm(judul, alur, penokohan, akting);
            
            String dataFilm[][] = model.DaftarFilm();
            view.tabel.setModel((new JTable(dataFilm, view.namaKolom)).getModel());
        });

        view.tabel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = view.tabel.getSelectedRow();

                dataterpilih = view.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);

            }

        });

        view.btnDelete.addActionListener((ActionEvent ae) -> {
            int input = JOptionPane.showConfirmDialog(null,
                    "Apa anda ingin menghapus Film " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);
            
            if (input == 0) {
                model.deleteFilm(dataterpilih);
                String dataFilm[][] = model.DaftarFilm();
                view.tabel.setModel((new JTable(dataFilm, view.namaKolom)).getModel());
            } else {
                JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
            }
        });

    }
}
