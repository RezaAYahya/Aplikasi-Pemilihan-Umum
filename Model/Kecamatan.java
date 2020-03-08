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
public class Kecamatan {
    private String NamaKecamatan;
    private String SuaraTotal01;
    private String SuaraTotal02;

    public Kecamatan(String NamaKecamatan) {
        this.NamaKecamatan = NamaKecamatan;
    }

    public Kecamatan(String NamaKecamatan, String SuaraTotal01, String SuaraTotal02) {
        this.NamaKecamatan = NamaKecamatan;
        this.SuaraTotal01 = SuaraTotal01;
        this.SuaraTotal02 = SuaraTotal02;
    }

    public String getNamaKecamatan() {
        return NamaKecamatan;
    }

    public String getSuaraTotal01() {
        return SuaraTotal01;
    }

    public String getSuaraTotal02() {
        return SuaraTotal02;
    }

    public void setNamaKecamatan(String NamaKecamatan) {
        this.NamaKecamatan = NamaKecamatan;
    }

    public void setSuaraTotal01(String SuaraTotal01) {
        this.SuaraTotal01 = SuaraTotal01;
    }

    public void setSuaraTotal02(String SuaraTotal02) {
        this.SuaraTotal02 = SuaraTotal02;
    }
    
    
}
