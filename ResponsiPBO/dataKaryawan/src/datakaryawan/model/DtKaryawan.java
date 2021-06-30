/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan.model;

/**
 *
 * @author User
 */
public class DtKaryawan {
    private int id;
    private int usia;
    private double gaji;
    private String nama;
    
    public DtKaryawan(int id, String nama, double gaji,int usia ) {
        this.id = id;
        this.nama = nama;
        this.gaji = gaji;
        this.usia = usia;

    }
    
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }

    public double getGaji() {
        return gaji;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setUsia(int usia) {
        this.usia = usia;
    }
    
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    
}
