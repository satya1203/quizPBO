/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author Christian
 */
public class insertMahasiswa implements ActionListener{
    JLabel judul, lnim, lnama, langkatan, lkode;
    JTextField nim, nama, angkatan, kode;
    JButton insert;
    JFrame frame;
    public insertMahasiswa(){
        frame = new JFrame("Insert Jurusan");
        frame.setSize(800,400);
        
        judul = new JLabel("Insert Jurusan");
        judul.setBounds(350,0,100,50);
        judul.setVisible(true);
        frame.add(judul);
        
        lnim = new JLabel("NIM : ");
        lnim.setBounds(250,150,150,30);
        nim = new JTextField();
        nim.setBounds(310,150,150,30);
        frame.add(lnim);frame.add(nim);
                
        lnama = new JLabel("Nama : ");
        lnama.setBounds(250,200,150,30);
        nama = new JTextField();
        nama.setBounds(310,200,150,30);
        frame.add(lnama);frame.add(nama);
        
        langkatan = new JLabel("Angkatan : ");
        langkatan.setBounds(250,250,150,30);
        angkatan = new JTextField();
        angkatan.setBounds(310,250,150,30);
        frame.add(langkatan);frame.add(angkatan);
        
        lkode = new JLabel("Kode : ");
        lkode.setBounds(250,250,150,30);
        kode = new JTextField();
        kode.setBounds(310,250,150,30);
        frame.add(lkode);frame.add(kode);
        
        insert = new JButton("Insert");
        insert.setBounds(310,250,150,30);
        insert.setVisible(true);
        insert.addActionListener(this);
        frame.add(insert);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new insertJurusan();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String nim = this.nim.getText();
        String nama = this.nama.getText();
        int angkatan = this.angkatan.getText();
        String kode = this.kode.getText();
        Mahasiswa mhs = new Mahasiswa (nim, nama, angkatan,kode);
        if(e.getActionCommand().equals("Insert")){
            Controller.insertMahasiswa(mhs);
            JOptionPane.showMessageDialog(null, "berhasil insert data");
            frame.dispose();
        }
    }
}
