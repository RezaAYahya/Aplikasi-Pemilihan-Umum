/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.MenuHasilSitung;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author izar.wh
 */
public class Databases {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    private String url = "jdbc:mysql://localhost:3306/voting";
    private String usr = "root";
    private String pass = "";

    public void connectTo() {
        try {
            conn = DriverManager.getConnection(url, usr, pass);
            st = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }

    public void discFrom() {
        try {
            if (conn != null && st != null) {
                conn.close();
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Provinsi> getDataProv() {
        connectTo();
        ArrayList<Provinsi> listProv = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT NamaProvinsi, SuaraTotal01, SuaraTotal02 FROM suara_provinsi JOIN provinsi USING(id_provinsi)");

            Provinsi u;
            while (rs.next()) {
                u = new Provinsi(
                        rs.getString("NamaProvinsi"),
                        rs.getString("SuaraTotal01"),
                        rs.getString("SuaraTotal02")
                );
                listProv.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return listProv;
    }

    public ArrayList<Kota> getDataKota(Object o) {
        connectTo();
        ArrayList<Kota> listKota = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT NamaKota, SuaraTotal01, SuaraTotal02 FROM suara_kota JOIN kota USING(id_kota)"
                    + "JOIN provinsi USING(id_provinsi)"
                    + "WHERE namaProvinsi = '" + o + "'");

            Kota u;
            while (rs.next()) {
                u = new Kota(
                        rs.getString("NamaKota"),
                        rs.getString("SuaraTotal01"),
                        rs.getString("SuaraTotal02")
                );
                listKota.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return listKota;
    }

    public ArrayList<Kecamatan> getDataKec(Object o) {
        connectTo();
        ArrayList<Kecamatan> listKec = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT NamaKecamatan, SuaraTotal01, SuaraTotal02 FROM suara_kecamatan JOIN kecamatan USING(id_kecamatan) "
                    + "JOIN kota USING(id_kota)"
                    + "WHERE NamaKota = '" + o + "'");

            Kecamatan u;
            while (rs.next()) {
                u = new Kecamatan(
                        rs.getString("NamaKecamatan"),
                        rs.getString("SuaraTotal01"),
                        rs.getString("SuaraTotal02")
                );
                listKec.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return listKec;
    }

    public ArrayList<Kelurahan> getDataKel(Object o) {
        connectTo();
        ArrayList<Kelurahan> listKel = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT NamaKelurahan, SuaraTotal01, SuaraTotal02 FROM suara_kelurahan JOIN kelurahan USING(id_kelurahan)"
                    + "JOIN kecamatan USING(id_kecamatan)"
                    + "WHERE NamaKecamatan = '" + o + "'");

            Kelurahan u;
            while (rs.next()) {
                u = new Kelurahan(
                        rs.getString("NamaKelurahan"),
                        rs.getString("SuaraTotal01"),
                        rs.getString("SuaraTotal02")
                );
                listKel.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return listKel;
    }

    public ArrayList<TPS> getDataTPS(Object o) {
        connectTo();
        ArrayList<TPS> listTPS = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT no_tps, SuaraTotal01, SuaraTotal02 FROM suara_tps "
                    + "JOIN tps USING(id_tps)"
                    + "JOIN kelurahan USING(id_kelurahan)"
                    + "WHERE namaKelurahan LIKE '" + o + "'");

            TPS u;
            while (rs.next()) {
                u = new TPS(
                        rs.getString("no_tps"),
                        rs.getString("SuaraTotal01"),
                        rs.getString("SuaraTotal02")
                );
                listTPS.add(u);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return listTPS;
    }
    
    public ArrayList<Provinsi> setComboBoxProv(){
        connectTo();
        ArrayList<Provinsi> list = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT NamaProvinsi FROM provinsi");
            Provinsi prov;
            while(rs.next()){
                prov = new Provinsi(rs.getString("namaProvinsi"));
                list.add(prov);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuHasilSitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return list;
    }
    
    public ArrayList<Kota> setComboBoxKota(Object o){
        connectTo();
        ArrayList<Kota> list = new ArrayList();
        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT NamaKota FROM kota JOIN provinsi USING(id_provinsi) WHERE namaProvinsi = '" + o + "'");
            Kota kota;
            while(rs.next()){
                kota = new Kota(rs.getString("namaKota"));
                list.add(kota);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuHasilSitung.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return list;
    }
    
    public ArrayList<Kecamatan> setComboBoxKec(Object o) {
        connectTo();
        ArrayList<Kecamatan> list = new ArrayList();
        String query = "SELECT namaKecamatan FROM kecamatan JOIN kota USING(id_kota) WHERE namaKota = '" + o + "'";
        try {
            rs = st.executeQuery(query);
            Kecamatan kec;
            while (rs.next()) {
                kec = new Kecamatan(rs.getString("NamaKecamatan"));
                list.add(kec);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return list;
    }

    public ArrayList<Kelurahan> setComboBoxKel(Object o) {
        connectTo();
        ArrayList<Kelurahan> list = new ArrayList();
        String query = "SELECT namaKelurahan FROM kelurahan JOIN kecamatan USING(id_kecamatan) WHERE namaKecamatan = '" + o + "'";
        try {
            rs = st.executeQuery(query);
            Kelurahan kel;
            while (rs.next()) {
                kel = new Kelurahan(rs.getString("NamaKelurahan"));
                list.add(kel);
            }
        } 
        catch(SQLException ex){
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return list;
    }
    
    public String[] getDataPemilih(String nama, String ID) {
        connectTo();
        String[] dataPemilih = new String[7];
        try {
            String query = "SELECT nama, id_pemilih, namaprovinsi, namakota, namakecamatan, namakelurahan, no_tps  FROM `suara_pemilih` "
                    + "JOIN TPS USING(id_tps)"
                    + "JOIN kelurahan USING(id_kelurahan)"
                    + "JOIN kecamatan USING(id_kecamatan)"
                    + "JOIN kota USING(id_kota)"
                    + "JOIN provinsi USING(id_provinsi)"
                    + "WHERE nama LIKE '" + nama + "'" + " AND id_pemilih LIKE '" + ID + "'";
            rs = st.executeQuery(query);
            if(rs.next() == false){
                JOptionPane.showMessageDialog(null, "Data pemilih tidak ditemukan, harap coba lagi.");
            }else{
                rs.previous();
                while (rs.next()) {
                        dataPemilih[0] = rs.getString("nama");
                        dataPemilih[1] = rs.getString("id_pemilih");
                        dataPemilih[2] = rs.getString("namaprovinsi");
                        dataPemilih[3] = rs.getString("namakota");
                        dataPemilih[4] = rs.getString("namakecamatan");
                        dataPemilih[5] = rs.getString("namakelurahan");
                        dataPemilih[6] = rs.getString("no_tps"); 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return dataPemilih;
    }
    
    public ArrayList<Paslon> setDescPaslon(){
        connectTo();
        ArrayList<Paslon> list = new ArrayList();
        try{
            String query = "SELECT nama, umur FROM paslon";
            rs = st.executeQuery(query);
            Paslon p;
            while(rs.next()){
                p = new Paslon(rs.getString("nama"), rs.getString("umur"));
                list.add(p);
            }
        }catch(Exception ex){
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        discFrom();
        return list;
    }
}

