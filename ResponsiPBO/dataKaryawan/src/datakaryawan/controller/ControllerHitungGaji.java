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
import javax.swing.*;
import datakaryawan.model.*;

public class ControllerHitungGaji {
    public void edit(ViewHitungGaji gaji, DtKaryawan karyawan) {
        gaji.toBack();
        ViewEditData baru = new ViewEditData(karyawan);
        baru.toFront();
    }

    public void delete(ViewHitungGaji gaji, int id) {
        int input = JOptionPane.showConfirmDialog(gaji,
                "Yakin ingin menghapus?", "Hapus data",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        System.out.println(input);
        if (input == 0) {
            ModelDataKaryawan mdk = new ModelDataKaryawan();
            String msg = mdk.delete(id);
            JOptionPane.showMessageDialog(gaji,msg);
            gaji.toBack();
        }
    }
     public void back(ViewHitungGaji gaji){
        gaji.toBack();
        gaji.setVisible(false);
        
    }
     public void viewHasil(ViewHitungGaji gaji, DtKaryawan karyawan, int total) {
        gaji.toBack();
        ViewHasil baru = new ViewHasil(karyawan, total);
        baru.toFront();
    }
}
