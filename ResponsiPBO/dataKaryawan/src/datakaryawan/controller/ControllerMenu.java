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

import datakaryawan.model.*;
import datakaryawan.view.*;

public class ControllerMenu {
    public void viewLihatData(ViewMenu menu){
        ModelDataKaryawan mdk = new ModelDataKaryawan();
        DtKaryawan[] result = mdk.getAll();
        menu.toBack();
        ViewListData baru = new ViewListData(result);
        baru.toFront(); 
    }
    public void viewTambahData(ViewMenu menu){
        menu.toBack();
        ViewInputData baru = new ViewInputData();
        baru.toFront(); 
    }

}
