/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan.view;

/**
 *
 * @author User
 */

import datakaryawan.controller.*;
import java.awt.event.*;

public class ViewInputData extends ViewFormData {
    ControllerInputData controllerInputData = new ControllerInputData();
    
    public ViewInputData() {
        super("Input Data Karyawan");   
        setLocationRelativeTo(null);
    }
    
    public void actionPerformed(ActionEvent e){
         if (e.getSource() == super.buttonSubmit){
            controllerInputData.addData(this);
        }
         if (e.getSource() == super.buttonBack){
            controllerFormData.viewMenu(this);
        }
         if (e.getSource() == super.buttonReset){
            controllerFormData.resetForm(this);
        }
    }
}
