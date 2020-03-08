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
public class Kelurahan {
    private String NamaKelurahan;
    private String SuaraTotal01;
    private String SuaraTotal02;

    public Kelurahan(String NamaKelurahan) {
        this.NamaKelurahan = NamaKelurahan;
    }

    public Kelurahan(String NamaKelurahan, String SuaraTotal01, String SuaraTotal02) {
        this.NamaKelurahan = NamaKelurahan;
        this.SuaraTotal01 = SuaraTotal01;
        this.SuaraTotal02 = SuaraTotal02;
    }

    public String getNamaKelurahan() {
        return NamaKelurahan;
    }

    public String getSuaraTotal01() {
        return SuaraTotal01;
    }

    public String getSuaraTotal02() {
        return SuaraTotal02;
    }

    public void setNamaKelurahan(String NamaKelurahan) {
        this.NamaKelurahan = NamaKelurahan;
    }

    public void setSuaraTotal01(String SuaraTotal01) {
        this.SuaraTotal01 = SuaraTotal01;
    }

    public void setSuaraTotal02(String SuaraTotal02) {
        this.SuaraTotal02 = SuaraTotal02;
    }
    
    
}
