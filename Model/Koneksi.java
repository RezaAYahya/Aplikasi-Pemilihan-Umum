/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

/**
 *
 * @author Bayu Chandra
 */
public class Koneksi {
    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/voting", "rezaayahya","delapan8");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
     }
    
    public ArrayList<Provinsi> getDataProv(Object o){
            ArrayList<Provinsi> list = new ArrayList<Provinsi>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;
            
            try {
                st = con.createStatement();
                if("Semua Provinsi".equals(o.toString())){
                    rs = st.executeQuery("SELECT NamaProvinsi, SuaraTotal01, SuaraTotal02 FROM suara_provinsi JOIN provinsi USING(id_provinsi) ");

                    Provinsi u;
                    while(rs.next()){
                        u = new Provinsi(
                            rs.getString("NamaProvinsi"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                }else{
                    rs = st.executeQuery("SELECT NamaProvinsi, SuaraTotal01, SuaraTotal02 FROM suara_provinsi JOIN provinsi USING(id_provinsi) "
                            + "WHERE NamaProvinsi = '" + o + "'");

                    Provinsi u;
                    while(rs.next()){
                        u = new Provinsi(
                            rs.getString("NamaProvinsi"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                } 
            }catch (SQLException ex) {
                    Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return list;
    }
    public ArrayList<Kota> getDataKota(Object o){
            ArrayList<Kota> list = new ArrayList<Kota>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;
            
            try {
                st = con.createStatement();
                if("Semua Kota/Kabupaten".equals(o.toString())){
                    rs = st.executeQuery("SELECT NamaKota, SuaraTotal01, SuaraTotal02 FROM suara_kota JOIN kota USING(id_kota) ");

                    Kota u;
                    while(rs.next()){
                        u = new Kota(
                            rs.getString("NamaKota"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                }else{
                    rs = st.executeQuery("SELECT NamaKota, SuaraTotal01, SuaraTotal02 FROM suara_kota JOIN kota USING(id_kota) "
                            + "WHERE NamaKota = '" + o + "'");

                    Kota u;
                    while(rs.next()){
                        u = new Kota(
                            rs.getString("NamaKota"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                } 
            }catch (SQLException ex) {
                    Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return list;
    }
    public ArrayList<Kecamatan> getDataKec(Object o){
            ArrayList<Kecamatan> list = new ArrayList<Kecamatan>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;
            
            try {
                st = con.createStatement();
                if("Semua Kecamatan".equals(o.toString())){
                    rs = st.executeQuery("SELECT NamaKecamatan, SuaraTotal01, SuaraTotal02 FROM suara_kecamatan JOIN kecamatan USING(id_kecamatan) ");

                    Kecamatan u;
                    while(rs.next()){
                        u = new Kecamatan(
                            rs.getString("NamaKecamatan"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                }else{
                    rs = st.executeQuery("SELECT NamaKecamatan, SuaraTotal01, SuaraTotal02 FROM suara_kecamatan JOIN kecamatan USING(id_kecamatan) "
                            + "WHERE NamaKecamatan = '" + o + "'");

                    Kecamatan u;
                    while(rs.next()){
                        u = new Kecamatan(
                            rs.getString("NamaKecamatan"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                } 
            }catch (SQLException ex) {
                    Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return list;
    }
    public ArrayList<Kelurahan> getDataKel(Object o){
            ArrayList<Kelurahan> list = new ArrayList<Kelurahan>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;
            
            try {
                st = con.createStatement();
                if("Semua Kelurahan".equals(o.toString())){
                    rs = st.executeQuery("SELECT NamaKelurahan, SuaraTotal01, SuaraTotal02 FROM suara_kelurahan JOIN kelurahan USING(id_kelurahan) ");

                    Kelurahan u;
                    while(rs.next()){
                        u = new Kelurahan(
                            rs.getString("NamaKelurahan"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                }else{
                    rs = st.executeQuery("SELECT NamaKelurahan, SuaraTotal01, SuaraTotal02 FROM suara_kelurahan JOIN kelurahan USING(id_kelurahan) "
                            + "WHERE NamaKelurahan = '" + o + "'");

                    Kelurahan u;
                    while(rs.next()){
                        u = new Kelurahan(
                            rs.getString("NamaKelurahan"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                } 
            }catch (SQLException ex) {
                    Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return list;
    }
    public ArrayList<TPS> getDataTPS(Object o){
            ArrayList<TPS> list = new ArrayList<TPS>();
            Connection con = getConnection();
            Statement st;
            ResultSet rs;
            
            try {
                st = con.createStatement();
                if("Semua TPS".equals(o.toString())){
                    rs = st.executeQuery("SELECT no_tps, SuaraTotal01, SuaraTotal02 FROM suara_tps JOIN tps USING(id_tps) ");

                    TPS u;
                    while(rs.next()){
                        u = new TPS(
                            rs.getString("no_tps"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                }else{
                    rs = st.executeQuery("SELECT no_tps, SuaraTotal01, SuaraTotal02 FROM suara_tps JOIN tps USING(id_tps) "
                            + "WHERE no_tps = '" + o + "'");

                    TPS u;
                    while(rs.next()){
                        u = new TPS(
                            rs.getString("no_tps"),
                            rs.getString("SuaraTotal01"),
                            rs.getString("SuaraTotal02")
                        );
                        list.add(u);
                    }
                } 
            }catch (SQLException ex) {
                    Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return list;
    }
}
