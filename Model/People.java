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
public class People {
    private String nama;
    private String id;
    
    public People(String nama){
        this.nama = nama;
    }
    
    public People(String nama, String id){
        this.nama = nama;
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public String getId() {
        return id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}
