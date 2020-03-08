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
import java.util.ArrayList;
import View.*;
import javax.swing.JComboBox;

/**
 *
 * @author Bayu Chandra
 */
public class Load_ComboBox {
    
    public void load_comboboxProv(ArrayList<Provinsi> list, MenuHasilSitung view){
        for(int i = 0; i < list.size(); i++){
            view.getComboBoxProv().addItem(list.get(i).getNamaProvinsi());
        }
    }
    
    public void load_comboboxKota(ArrayList<Kota> list, MenuHasilSitung view){
        for(int i = 0; i < list.size(); i++){
            view.getComboBoxKota().addItem(list.get(i).getNamaKota());
        }
    }
    
    public void load_comboboxKec(ArrayList<Kecamatan> list, MenuHasilSitung view){
        for(int i = 0; i < list.size(); i++){
            view.getComboBoxKec().addItem(list.get(i).getNamaKecamatan());
        }
    }
    
    public void load_comboboxKel(ArrayList<Kelurahan> list, MenuHasilSitung view){
        for(int i = 0; i < list.size(); i++){
            view.getComboBoxKel().addItem(list.get(i).getNamaKelurahan());
        }
    }
    
    public void Removeitem(JComboBox<String> jcb) {
        int itemCount = jcb.getItemCount();
        int i = 1;
        while (itemCount != 1) {
            jcb.removeItemAt(i);
            itemCount = jcb.getItemCount();
        }
    }
}
