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
public class Menu implements ActionListener{
    JLabel judul;
    JButton insertJurusan, lihatDataJurusan, insertDataMahasiswa, lihatDataMahasiswaPerJurusan;
    JFrame frame;
    public Menu() {
        frame = new JFrame("Main Menu");
        frame.setSize(800,400);
        
        judul = new JLabel("Menu utama");
        judul.setBounds(350,0,100,50);
        judul.setVisible(true);
        frame.add(judul);
        
        insertJurusan = new JButton("Insert Data Jurusan Baru");
        insertJurusan.setBounds(310,150,150,30);
        insertJurusan.setVisible(true);
        insertJurusan.addActionListener(this);
        frame.add(insertJurusan);
        
        
        lihatDataJurusan = new JButton("Lihat Data Semua Jurusan");
        lihatDataJurusan.setBounds(310,200,150,30);
        lihatDataJurusan.setVisible(true);
        lihatDataJurusan.addActionListener(this);
        frame.add(lihatDataJurusan);
        
        insertDataMahasiswa = new JButton("Insert Data Mahasiswa Baru");
        insertDataMahasiswa.setBounds(310,250,150,30);
        insertDataMahasiswa.setVisible(true);
        insertDataMahasiswa.addActionListener(this);
        frame.add(insertDataMahasiswa);
        
        lihatDataMahasiswaPerJurusan = new JButton("Lihat Data Mahasiswa Per Jurusan");
        lihatDataMahasiswaPerJurusan.setBounds(310,250,150,30);
        lihatDataMahasiswaPerJurusan.setVisible(true);
        lihatDataMahasiswaPerJurusan.addActionListener(this);
        frame.add(lihatDataMahasiswaPerJurusan);
        
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Menu();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
            Mahasiswa mhs = new Mahasiswa();
            Jurusan jrs = new Jurusan();
        if(e.getActionCommand().equals("Insert Data Jurusan Baru")){
            new insertJurusan();
            frame.dispose();
        }else if(e.getActionCommand().equals("Lihat Data Semua Jurusan")){
            new lihatJurusan();
            frame.dispose();
        }else if(e.getActionCommand().equals("Insert Data Mahasiswa Baru")){
            new insertMahasiswa(mhs);
            frame.dispose();
        }else if(e.getActionCommand().equals("Lihat Data Mahasiswa Per Jurusan")){
            new lihatMemberJurusan();
            frame.dispose();
        }
    }
}
