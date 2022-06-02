/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class View extends JFrame implements ActionListener {

    //COMPONENT DECLARATION
    JLabel ljudul = new JLabel("Judul");
    JLabel lAlur = new JLabel("Alur");
    JLabel lPenokohan = new JLabel("Penokohan");
    JLabel lAkting = new JLabel("Akting");

    public JTextField tfJudul = new JTextField();
    public JTextField tfAlur = new JTextField();
    public JTextField tfPenokohan = new JTextField();
    public JTextField tfAkting = new JTextField();

    public JButton btnTambah = new JButton("Tambah");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Clear");

    public JTable tabel;
    DefaultTableModel dtm;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"Judul", "Alur", "Penokohan", "Akting", "Nilai"};

    public View() {
        dtm = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dtm);
        scrollPane = new JScrollPane(tabel);

        //SetWindow
        setTitle("Data Movie");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLayout(null);
        setSize(850, 485);
        setLocationRelativeTo(null);

        //ADD COMPONENT & PLACEMENT
        add(scrollPane);
        
            //JUDUL
        add(ljudul);
        add(tfJudul);
        
            //ALUR
        add(lAlur);
        add(tfAlur);
        
            //NILAI PENOKOHAN
        add(lPenokohan);
        add(tfPenokohan);
        
            //NILAI AKTING
        add(lAkting);
        add(tfAkting);
        
            //BUTTON TAMBAH, UPDATE, DELETE, RESET
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnReset);
        
        //SET BOUNDS
        scrollPane.setBounds(20, 20, 480, 300);

            //JUDUL
        ljudul.setBounds(510, 20, 90, 20);
        tfJudul.setBounds(510, 40, 200, 20);

            //ALUR
        lAlur.setBounds(510, 60, 90, 20);
        tfAlur.setBounds(510, 80, 200, 20);
            
            //NILAI PENOKOHAN
        lPenokohan.setBounds(510, 100, 90, 20);
        tfPenokohan.setBounds(510, 120, 200, 20);

            //NILAI AKTING
        lAkting.setBounds(510, 140, 90, 20);
        tfAkting.setBounds(510, 160, 200, 20);

        btnTambah.setBounds(510, 190, 90, 25);        
        btnUpdate.setBounds(510, 220, 90, 25);        
        btnDelete.setBounds(510, 250, 90, 25);        
        btnReset.setBounds(510, 280, 90, 25);
        btnReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //Mengosongkan Kolom Judul,Alur,Penokohan, dan Akting
        if (e.getSource() == btnReset) {
            tfJudul.setText("");
            tfAlur.setText("");
            tfPenokohan.setText("");
            tfAkting.setText("");

        }
    }

    public String getJudul() {
        return tfJudul.getText();
    }

    public String getAlur() {
        return tfAlur.getText();
    }

    public String getPenokohan() {
        return tfPenokohan.getText();
    }

    public String getAkting() {
        return tfAkting.getText();
    }
}
