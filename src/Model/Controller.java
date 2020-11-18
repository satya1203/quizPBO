/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class Controller {
    static DatabaseHandler conn = new DatabaseHandler();
    
    
    // INSERT jurusuan
    public static boolean insertJurusan(Jurusan jrs) {
        conn.connect();
        String query = "INSERT INTO jurusan VALUES(?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, jrs.getKode());
            stmt.setString(2, jrs.getNama());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
     // SELECT ALL from jurusan
    public static ArrayList<Jurusan> lihatJurusan() {
        ArrayList<Jurusan> jrs = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM jurusan";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Jurusan jurusan = new Jurusan();
                jurusan.setKode(rs.getString("kode"));
                jurusan.setNama(rs.getString("nama"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (jrs);
    }
    
    // INSERT Mahasiswa
    public static boolean insertMahasiswa(Mahasiswa mhs) {
        conn.connect();
        String query = "INSERT INTO mahasiswa VALUES(?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, mhs.getNim());
            stmt.setString(2,mhs.getNama());
            stmt.setInt(3, mhs.getAngkatan());
            stmt.setString(4, mhs.getKode_jurusan());
            stmt.executeUpdate();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }
    
    // SELECT data mahasiswa perjurusan 
    public static Mahasiswa lihatMhsJurusan(String kode1, String kode2, String kode3 ) {
        conn.connect();
        String query = "SELECT * FROM mahasiswa WHERE (kode_jurusan='" + kode1 + "') && (kode_jurusan='" + kode2 + "') &&"
                + "(kode_jurusan='" + kode3 + "')";
        Mahasiswa mhs = new Mahasiswa();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                mhs.setKode_jurusan(rs.getString("kode_jurusan"));
                mhs.setNama(rs.getString("nama"));
                mhs.setAngkatan(rs.getInt("angkatan"));
                mhs.setKode_jurusan(rs.getString("kode_jurusan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (mhs);
    }
}
