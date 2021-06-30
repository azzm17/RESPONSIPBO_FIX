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

public class ControllerFormData {
    public void viewMenu(ViewFormData form){
        form.toBack();
        form.setVisible(false);
    }
    public void resetForm(ViewFormData form){
        form.getFnama().setText("");
        form.getFgaji().setText("");
        form.getFusia().setText("");
    }
}
