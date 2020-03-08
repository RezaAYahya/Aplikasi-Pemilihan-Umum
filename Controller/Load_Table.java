/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Kecamatan;
import Model.Kelurahan;
import Model.Kota;
import Model.Provinsi;
import Model.TPS;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Model.Databases;
/**
 *
 * @author Bayu Chandra
 */
public class Load_Table {
    private Databases DB = new Databases();
    
    public DefaultTableModel load_tableProv(){   
        ArrayList<Provinsi> list = DB.getDataProv();
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Wilayah","(01)Faishal Darma Putra","(02)Irfan Budi Prakoso"});
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getNamaProvinsi();
            row[1] = list.get(i).getSuaraTotal01();
            row[2] = list.get(i).getSuaraTotal02();
            model.addRow(row);
        }
        return model;
    }
    
    public DefaultTableModel load_tableKota(Object o){   
        ArrayList<Kota> list = DB.getDataKota(o);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Wilayah","(01)Faishal Darma Putra","(02)Irfan Budi Prakoso"});
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getNamaKota();
            row[1] = list.get(i).getSuaraTotal01();
            row[2] = list.get(i).getSuaraTotal02();
            model.addRow(row);
        }
        return model;
    }
    
    public DefaultTableModel load_tableKec(Object o){
        ArrayList<Kecamatan> list = DB.getDataKec(o);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Wilayah","(01)Faishal Darma Putra","(02)Irfan Budi Prakoso"});
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getNamaKecamatan();
            row[1] = list.get(i).getSuaraTotal01();
            row[2] = list.get(i).getSuaraTotal02();
            model.addRow(row);
        }
        return model;
    }
    
    public DefaultTableModel load_tableKel(Object o){
        ArrayList<Kelurahan> list = DB.getDataKel(o);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Wilayah","(01)Faishal Darma Putra","(02)Irfan Budi Prakoso"});
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getNamaKelurahan();
            row[1] = list.get(i).getSuaraTotal01();
            row[2] = list.get(i).getSuaraTotal02();
            model.addRow(row);
        }
        return model;
    }
    
    public DefaultTableModel load_tableTPS(Object o){
        ArrayList<TPS> list = DB.getDataTPS(o);
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Wilayah","(01)Faishal Darma Putra","(02)Irfan Budi Prakoso"});
        Object[] row = new Object[5];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getNo_tps();
            row[1] = list.get(i).getSuaraTotal01();
            row[2] = list.get(i).getSuaraTotal02();
            model.addRow(row);
        }
        return model;
    }
}
