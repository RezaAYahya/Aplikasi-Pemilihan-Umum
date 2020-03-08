/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author izar.wh
 */
public class Pemilih extends People {
    private String nama;
    private String id;
    private String noPaslon;

    public Pemilih(String nama, String idPemilih, String noPaslon) {
        super(nama, idPemilih);
        this.noPaslon = noPaslon;
    }
    
    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public String getNoPaslon() {
        return noPaslon;
    }
            
    
}
