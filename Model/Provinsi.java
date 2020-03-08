/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Query;

public class Provinsi {
    private String NamaProvinsi;
    private String SuaraTotal01;
    private String SuaraTotal02;

    public Provinsi(String NamaProvinsi){
        this.NamaProvinsi = NamaProvinsi;
    }
    
    public Provinsi(String NamaProvinsi, String SuaraTotal01, String SuaraTotal02) {
        this.NamaProvinsi = NamaProvinsi;
        this.SuaraTotal01 = SuaraTotal01;
        this.SuaraTotal02 = SuaraTotal02;
    }

    public String getNamaProvinsi() {
        return NamaProvinsi;
    }

    public String getSuaraTotal01() {
        return SuaraTotal01;
    }

    public String getSuaraTotal02() {
        return SuaraTotal02;
    }

    public void setNamaProvinsi(String NamaProvinsi) {
        this.NamaProvinsi = NamaProvinsi;
    }

    public void setSuaraTotal01(String SuaraTotal01) {
        this.SuaraTotal01 = SuaraTotal01;
    }

    public void setSuaraTotal02(String SuaraTotal02) {
        this.SuaraTotal02 = SuaraTotal02;
    }
    
    
}
