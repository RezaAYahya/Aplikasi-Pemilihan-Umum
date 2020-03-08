/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.FAQ;
import View.MainMenu;
import View.MenuDataPaslon;
import View.MenuHasilSitung;
import View.MenuSearching;
import View.Petunjuk1;
import View.Profile;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Bayu Chandra
 */
public class Controller extends MouseAdapter implements ActionListener {
    private MenuHasilSitung view;
    private MainMenu menu;
    private MenuSearching search;
    private MenuDataPaslon paslon;
    private FAQ faq;
    private Petunjuk1 ptnjk;
    private Profile prof;
    private Databases DB = new Databases();
    private Color colorMainMenu;
    private Color colorMenuSitung;
    private Color colorMenuSearch;
    private Load_Table table = new Load_Table();
    private Load_ComboBox comboBox = new Load_ComboBox();

    public Controller() {
        menu = new MainMenu();
        view = new MenuHasilSitung();
        search = new MenuSearching();
        paslon = new MenuDataPaslon();
        faq = new FAQ();
        ptnjk = new Petunjuk1();
        prof = new Profile();
        colorMainMenu = menu.getMenuSitung().getBackground();
        colorMenuSitung = view.getMenuCari().getBackground();
        colorMenuSearch = search.getMenuSitung().getBackground();
        menu.setVisible(true);
        ptnjk.setVisible(true);
        doThisFirst();
        menu.addMouseAdapter(this);
        search.addMouseAdapter(this);
        search.addActionListener(this);
        view.addActionListener(this);
        view.addMouseAdapter(this);
        paslon.addMouseAdapter(this);
        faq.addMouseAdapter(this);
        ptnjk.addActionPerformed(this);
        ptnjk.addMouseAdaptor(this);
        prof.addMouseAdapter(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source.equals(view.getComboBoxProv())){
            ComboBoxProvActionPerformed(view.getComboBoxProv().getSelectedItem());
        } else if(source.equals(view.getComboBoxKota())){
            ComboBoxKotaActionPerformed(view.getComboBoxKota().getSelectedItem());
        } else if(source.equals(view.getComboBoxKec())){
            ComboBoxKecActionPerformed(view.getComboBoxKec().getSelectedItem());
        } else if(source.equals(view.getComboBoxKel())){
            ComboBoxKelActionPerformed(view.getComboBoxKel().getSelectedItem());
        } else if(source.equals(view.getComboBoxTPS())){
            ComboBoxTPSActionPerformed(view.getComboBoxTPS().getSelectedItem());
        } else if(source.equals(view.getResetButton())){
            ResetButtonActionPerformed();
        } else if(source.equals(search.getCariButton())){
            Searching();
        } else if(source.equals(ptnjk.getRB1())){
            ptnjk.getRBP2().setSelected(false);
            ptnjk.getRBP3().setSelected(false);
            ptnjk.getPetunjuk1().setText("Menu Hasil Situng\n"
                    + "Pada menu hasil situng user dapat melihat data suara di daerah yang tersedia");
        } else if(source.equals(ptnjk.getRBP2())){
            ptnjk.getRBP1().setSelected(false);
            ptnjk.getRBP3().setSelected(false);
            ptnjk.getPetunjuk1().setText("Menu Cari Pemilih\n"
                    + "Pada menu cari pemilih, user dapat mencari data orang yang mengikuti pemilihan");
        } else if(source.equals(ptnjk.getRBP3())){
            ptnjk.getRBP2().setSelected(false);
            ptnjk.getRBP1().setSelected(false);
            ptnjk.getPetunjuk1().setText("Menu Data Paslon\n"
                    + "Pada menu data paslon, user dapat melihat data paslon yang ada");
        } else if (source.equals(menu.getProfilePanel())){
            menu.setVisible(false);
            prof.setVisible(true);
        } else if (source.equals(prof.getHomeBtn())){
            menu.setVisible(true);
            prof.setVisible(false);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if(source.equals(menu.getMenuSitung())){
            situngMouseClicked();
            menu.setVisible(false);
        } else if(source.equals(menu.getMenuSearching())){
            search.setVisible(true);
            menu.setVisible(false);
        } else if(source.equals(menu.getMenuDataPaslon())){
            DataPaslon();
            menu.setVisible(false);
        } else if(source.equals(menu.getExit())){
            System.exit(0);
        } else if(source.equals(menu.getHelp())){
            faq.setVisible(true);
        } else if(source.equals(menu.getProfilePanel())){
            menu.setVisible(false);
            prof.setVisible(true);
        } else if(source.equals(view.getHomeLabel())){
            view.setVisible(false);
            menu.setVisible(true);
        } else if (source.equals(view.getMenuCari())){
            view.setVisible(false);
            search.setVisible(true);
        } else if (source.equals(view.getMenuPaslon())){
            view.setVisible(false);
            DataPaslon();
        } else if(source.equals(search.getLabelHome())){
            search.setVisible(false);
            menu.setVisible(true); 
        } else if(source.equals(search.getMenuSitung())){
            situngMouseClicked();
            search.setVisible(false);
        } else if(source.equals(search.getMenuPaslon())){
            search.setVisible(false);
            DataPaslon();
        } else if (source.equals(paslon.getMenuCari())){
            search.setVisible(true);
            paslon.setVisible(false);
        } else if (source.equals(paslon.getMenuSitung())){
            situngMouseClicked();
            paslon.setVisible(false);
        } else if (source.equals(paslon.getHome())){
            paslon.setVisible(false);
            menu.setVisible(true);
        } else if(source.equals(faq.getHomeBtn())){
            faq.setVisible(false);
            menu.setVisible(true); 
        } else if (source.equals(faq.getPertanyaan1())){
            faq.getJawaban1().setVisible(true);
            faq.getJawaban2().setVisible(false);
            faq.getJawaban3().setVisible(false);
            QuestionAnwer(faq.getPertanyaan1()); 
        } else if (source.equals(faq.getPertanyaan2())){
            faq.getJawaban1().setVisible(false);
            faq.getJawaban2().setVisible(true);
            faq.getJawaban3().setVisible(false);
            QuestionAnwer(faq.getPertanyaan2());
        } else if (source.equals(faq.getPertanyaan3())){
            faq.getJawaban1().setVisible(false);
            faq.getJawaban2().setVisible(false);
            faq.getJawaban3().setVisible(true);
            QuestionAnwer(faq.getPertanyaan3());
        } else if (source.equals(ptnjk.getExit())){
            ptnjk.setVisible(false);
        } else if (source.equals(prof.getHomeBtn())){
            prof.setVisible(false);
            menu.setVisible(true);
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(menu.getMenuSitung())){
            menu.getMenuSitung().setBackground(Color.getHSBColor(150,21,86));
        } else if (source.equals(menu.getMenuSearching())){
            menu.getMenuSearching().setBackground(Color.getHSBColor(150,21,86));
        } else if (source.equals(menu.getMenuDataPaslon())){
            menu.getMenuDataPaslon().setBackground(Color.getHSBColor(150,21,86));
        } else if (source.equals(view.getMenuCari())){
            view.getMenuCari().setBackground(Color.getHSBColor(74,77,86));
        } else if (source.equals(view.getMenuPaslon())){
            view.getMenuPaslon().setBackground(Color.getHSBColor(74,77,86));
        } else if(source.equals(search.getMenuSitung())){
            search.getMenuSitung().setBackground(Color.getHSBColor(74,77,86));
        } else if(source.equals(search.getMenuPaslon())){
            search.getMenuPaslon().setBackground(Color.getHSBColor(74,77,86));
        } else if (source.equals(paslon.getMenuCari())){
            paslon.getMenuCari().setBackground(Color.getHSBColor(74,77,86));
        } else if (source.equals(paslon.getMenuSitung())){
           paslon.getMenuSitung().setBackground(Color.getHSBColor(74,77,86));
        }
    }
    
    @Override
    public void mouseExited(MouseEvent e){
        Object source = e.getSource();
        if(source.equals(menu.getMenuSitung())){
            menu.getMenuSitung().setBackground(colorMainMenu);
        } else if (source.equals(menu.getMenuSearching())){
            menu.getMenuSearching().setBackground(colorMainMenu);
        } else if (source.equals(menu.getMenuDataPaslon())){
            menu.getMenuDataPaslon().setBackground(colorMainMenu);
        } else if (source.equals(view.getMenuCari())){
            view.getMenuCari().setBackground(colorMenuSitung);
        } else if (source.equals(view.getMenuPaslon())){
            view.getMenuPaslon().setBackground(colorMenuSitung);
        } else if(source.equals(search.getMenuSitung())){
            search.getMenuSitung().setBackground(colorMenuSearch);
        } else if(source.equals(search.getMenuPaslon())){
            search.getMenuPaslon().setBackground(colorMenuSearch);
        } else if (source.equals(paslon.getMenuCari())){
            paslon.getMenuCari().setBackground(colorMenuSearch);
        } else if (source.equals(paslon.getMenuSitung())){
           paslon.getMenuSitung().setBackground(colorMenuSearch);
        }
    }
    
    private void ComboBoxProvActionPerformed(Object o) {
        if("Semua Provinsi".equals(o.toString())) {
            view.getComboBoxKota().setVisible(false);
            view.getComboBoxKec().setVisible(false);
            view.getComboBoxKel().setVisible(false);
            view.getComboBoxTPS().setVisible(false);
            view.getTabel1().setModel(table.load_tableProv());
        } else {
            view.getComboBoxKota().setVisible(true);
            view.getTabel1().setModel(table.load_tableKota(o));
            comboBox.Removeitem(view.getComboBoxKota());
            comboBox.load_comboboxKota(DB.setComboBoxKota(o), view);
        }
    }
    
    private void ComboBoxKotaActionPerformed(Object o) {
        if("Semua Kota/Kabupaten".equals(o.toString())) {
            view.getComboBoxKec().setVisible(false);
            comboBox.Removeitem(view.getComboBoxKec());
            view.getTabel1().setModel(table.load_tableKota(view.getComboBoxProv().getSelectedItem()));
        }
        else{
            view.getComboBoxKec().setVisible(true);
            comboBox.Removeitem(view.getComboBoxKec());
            comboBox.load_comboboxKec(DB.setComboBoxKec(o), view);
            view.getTabel1().setModel(table.load_tableKec(o));
        }
    }
    
    private void ComboBoxKecActionPerformed(Object o) {                                            
        // TODO add your handling code here:
        if("Semua Kecamatan".equals(o.toString())){
            view.getComboBoxKel().setVisible(false);
            comboBox.Removeitem(view.getComboBoxKel());
            view.getTabel1().setModel(table.load_tableKec(view.getComboBoxKota().getSelectedItem()));
        }
        else{
            view.getComboBoxKel().setVisible(true);
            comboBox.Removeitem(view.getComboBoxKel());
            comboBox.load_comboboxKel(DB.setComboBoxKel(o),view);
            view.getTabel1().setModel(table.load_tableKel(o));
        }
    }
    
    private void ComboBoxKelActionPerformed(Object o) {                                            
        // TODO add your handling code here:
        if("Semua Kelurahan".equals(o.toString())){
            view.getComboBoxTPS().setVisible(false);
            view.getTabel1().setModel(table.load_tableKel(view.getComboBoxKec().getSelectedItem()));
        }
        else{
            view.getComboBoxTPS().setVisible(true);
            view.getTabel1().setModel(table.load_tableTPS(o));
        }
    }
    
    private void ComboBoxTPSActionPerformed(Object o) {                                            
        // TODO add your handling code here:
        view.getTabel1().setModel(table.load_tableTPS(view.getComboBoxKel().getSelectedItem()));
    }
    
    private void ResetButtonActionPerformed() {                                            
        // TODO add your handling code here:
        view.getComboBoxProv().setSelectedIndex(0);
        view.getComboBoxKota().setSelectedIndex(0);
        comboBox.Removeitem(view.getComboBoxKec());
        comboBox.Removeitem(view.getComboBoxKel());
        comboBox.Removeitem(view.getComboBoxTPS());
        view.getComboBoxKota().setVisible(false);
        view.getComboBoxKec().setVisible(false);
        view.getComboBoxKel().setVisible(false);
        view.getComboBoxTPS().setVisible(false);
        view.getTabel1().setModel(table.load_tableProv());
    }
    
    private void situngMouseClicked() {         
        comboBox.load_comboboxProv(DB.setComboBoxProv(), view);
        view.getTabel1().setModel(table.load_tableProv());
        view.setVisible(true);
    }
    
    private void Searching(){
        String[] dataPemilih = new String[7];
        dataPemilih = DB.getDataPemilih(search.getNamaTF().getText(), search.getNIKTF().getText());
        search.setLabelNama(dataPemilih[0]);
        search.setLabelID(dataPemilih[1]);
        search.setLabelProv(dataPemilih[2]);
        search.setLabelKota(dataPemilih[3]);
        search.setLabelKel(dataPemilih[4]);
        search.setLabelKec(dataPemilih[5]);
        search.setLabelTPS(dataPemilih[6]);
    }
    
    private void DataPaslon(){
        ArrayList<Paslon> list = DB.setDescPaslon();
        paslon.setDesc01("Nama : " + list.get(0).getNama() + "\n"
                + "Umur : " + list.get(0).getUmur());
        paslon.setDesc02("Nama : " + list.get(1).getNama() + "\n"
                + "Umur : " + list.get(1).getUmur());
        paslon.setVisible(true);
    }
    
    private void QuestionAnwer(Object o){
        if (o.equals(faq.getPertanyaan1())){
            faq.getJawaban1().setText("Karena aplikasi ini hanya sebatas memenuhi tugas,\n"
                    + "aplikasi ini tidak dirilis untuk publik");
        } else if (o.equals(faq.getPertanyaan2())){
            faq.getJawaban2().setText("Tentu tidak, aplikasi ini menerapkan asas luber jurdil,\n"
                    + "maka user tidak dapat melihat pilihan pemilih karena bersifat rahasia");
        } else if (o.equals(faq.getPertanyaan3())){
            faq.getJawaban3().setText("Data pada Databases aplikasi ini tidaklah sama dengan \n"
                    + "databases KPU milik negara");
        }
    }
    
    private void doThisFirst(){
        ptnjk.getRBP1().setSelected(true);
        ptnjk.getPetunjuk1().setText("Menu Hasil Situng\n"
                    + "Pada menu hasil situng user dapat melihat data suara di daerah yang tersedia");
    }
}
