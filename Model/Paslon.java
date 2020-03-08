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
public class Paslon extends People {
    private String nama;
    private String umur;

    public Paslon(String nama, String umur) {
        super(nama);
        this.umur = umur;
    }

    @Override
    public String getNama() {
        return super.getNama();
    }

    public String getUmur() {
        return umur;
    }
}
