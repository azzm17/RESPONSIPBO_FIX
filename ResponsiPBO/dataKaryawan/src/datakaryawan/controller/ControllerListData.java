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
import datakaryawan.view.*;
import datakaryawan.model.DtKaryawan;

public class ControllerListData {
    public void viewPerhitunganGaji(ViewListData list, DtKaryawan karyawan){
        list.toBack();
        ViewHitungGaji baru = new ViewHitungGaji(karyawan);
        baru.toFront(); 
    }
    public void back(ViewListData list){
        list.toBack();
        list.setVisible(false);
    }
}
