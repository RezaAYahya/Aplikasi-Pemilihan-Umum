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
public class TPS {
    private String no_tps;
    private String SuaraTotal01;
    private String SuaraTotal02;
    
    public TPS(String no_tps) {
        this.no_tps = no_tps;
    }
    
    public TPS(String no_tps, String SuaraTotal01, String SuaraTotal02) {
        this.no_tps = no_tps;
        this.SuaraTotal01 = SuaraTotal01;
        this.SuaraTotal02 = SuaraTotal02;
    }

    public String getNo_tps() {
        return no_tps;
    }

    public String getSuaraTotal01() {
        return SuaraTotal01;
    }

    public String getSuaraTotal02() {
        return SuaraTotal02;
    }

    public void setNo_tps(String no_tps) {
        this.no_tps = no_tps;
    }

    public void setSuaraTotal01(String SuaraTotal01) {
        this.SuaraTotal01 = SuaraTotal01;
    }

    public void setSuaraTotal02(String SuaraTotal02) {
        this.SuaraTotal02 = SuaraTotal02;
    }
    
    
}
