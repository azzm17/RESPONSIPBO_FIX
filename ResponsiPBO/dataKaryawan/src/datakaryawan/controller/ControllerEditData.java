/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan.controller;

/**
 *
 * @author User
 */
import javax.swing.*;
import datakaryawan.model.*;
import datakaryawan.view.*;

public class ControllerEditData {
    public void updateKaryawan(ViewEditData input, int id){
        try{
            String nama = input.getFnama().getText();
            int usia = Integer.parseInt(input.getFusia().getText());
            double gaji = Double.parseDouble(input.getFgaji().getText());
            if(usia <= 0 || gaji < 0){
                throw new ArithmeticException("Bilangan Tidak Positif");  
            }
            DtKaryawan baru = new DtKaryawan(id,nama,gaji,usia);
            ModelDataKaryawan mdk = new ModelDataKaryawan();
            String msg = mdk.update(baru);
            JOptionPane.showMessageDialog(input,msg);
        }catch(Exception e){
            System.out.print(e.getMessage());
            if ("Bilangan tidak Positif".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(input,e.getMessage());
            }else{
                JOptionPane.showMessageDialog(input,"Usia dan Gaji Harus Angka");
            }
        }
    }
}
