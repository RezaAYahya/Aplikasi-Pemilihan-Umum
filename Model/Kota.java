/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Bayu Chandra
 */
public class Kota {
    private String NamaKota;
    private String SuaraTotal01;
    private String SuaraTotal02;

    public Kota(String NamaKota) {
        this.NamaKota = NamaKota;
    }
    
    public Kota(String NamaKota, String SuaraTotal01, String SuaraTotal02) {
        this.NamaKota = NamaKota;
        this.SuaraTotal01 = SuaraTotal01;
        this.SuaraTotal02 = SuaraTotal02;
    }

    public String getNamaKota() {
        return NamaKota;
    }

    public String getSuaraTotal01() {
        return SuaraTotal01;
    }

    public String getSuaraTotal02() {
        return SuaraTotal02;
    }

    public void setNamaKota(String NamaKota) {
        this.NamaKota = NamaKota;
    }

    public void setSuaraTotal01(String SuaraTotal01) {
        this.SuaraTotal01 = SuaraTotal01;
    }

    public void setSuaraTotal02(String SuaraTotal02) {
        this.SuaraTotal02 = SuaraTotal02;
    }
    
    
}
