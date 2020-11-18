/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Christian
 */
public class lihatJurusan implements ActionListener{
    
    JLabel judul, lkode, lnama;
    JTextField kode, nama;
    JButton insert;
    JFrame frame;
    JTable jt;
    JPanel panel;
    JScrollPane sp;
    ArrayList<Jurusan> jrs = new ArrayList<>();
    public lihatJurusan(){
        frame = new JFrame("Lihat Semua Data Jurusan");
        frame.setSize(800,400);
        
        //lihat riwayatTopUp
        jt = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        Object[] namaKolom = new Object[2];
        namaKolom[0] = "Kode Jurusan";
        namaKolom[1] = "Nama Jurusan";
        model.setColumnIdentifiers(namaKolom);
        Object[] dataKolom = new Object[2];
        for (int i = 0; i < jrs.size(); i++) {
           dataKolom[0] = jrs.get(i).getKode();
           dataKolom[1] = jrs.get(i).getNama();
           model.addRow(dataKolom);
        }
        jt.setModel(model);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        sp = new JScrollPane(jt);
        sp.setVisible(false);
        frame.add(sp);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new lihatJurusan();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String kode = this.kode.getText();
        String nama = this.nama.getText();
        Jurusan jrs = new Jurusan (kode, nama);
        if(e.getActionCommand().equals("Insert")){
            Controller.insertJurusan(jrs);
            JOptionPane.showMessageDialog(null, "berhasil insert data");
            frame.dispose();
        }
    }
}
