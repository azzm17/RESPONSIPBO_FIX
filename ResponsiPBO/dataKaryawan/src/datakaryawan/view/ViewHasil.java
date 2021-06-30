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
import datakaryawan.model.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ViewHasil extends JFrame implements ActionListener {
    ControllerHasil controllerHasil = new ControllerHasil();
    JLabel flembur = new JLabel();
    JLabel fnama = new JLabel();
    JLabel fgaji = new JLabel();
    JLabel fusia = new JLabel();
    JLabel lnama = new JLabel("NAMA:");
    JLabel lgaji = new JLabel("GAJI:");
    JLabel lusia = new JLabel("USIA:");
    JLabel llembur = new JLabel("TOTAL GAJI:");
    JLabel ljudul = new JLabel("Menghitung Gaji");
    JButton buttonBack = new JButton("Kembali");
    
    public ViewHasil(DtKaryawan karyawan, int total) {

        setTitle("Hitung Gaji");
        setSize(350,350);
        setVisible(true);
        setLocationRelativeTo(null);
        
        fnama.setText(karyawan.getNama());
        fusia.setText(String.valueOf(karyawan.getUsia()));
        fgaji.setText(String.valueOf(String.format("%,.2f", karyawan.getGaji())));
        flembur.setText(String.format("%,.2f", (total*25000)+karyawan.getGaji()));
        
        this.setLayout(null);
        this.add(fnama);
        this.add(fgaji);
        this.add(fusia);
        this.add(flembur);
        fnama.setBounds(160, 60, 130, 30);
        fgaji.setBounds(160, 90, 130, 30);
        fusia.setBounds(160, 120, 130, 30);
        flembur.setBounds(160, 150, 105, 30);
        
        this.add(lnama);
        this.add(lgaji);
        this.add(lusia);
        this.add(ljudul);
        this.add(llembur);   
        lnama.setBounds(20, 60, 40, 30);
        lgaji.setBounds(20, 90, 40, 30);
        lusia.setBounds(20, 120, 40, 30);
        ljudul.setBounds(20, 20, 250, 30);
        llembur.setBounds(20, 150, 120, 30);
        this.add(buttonBack);
        buttonBack.setBounds(20, 230, 85, 35);
        buttonBack.addActionListener(this);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == buttonBack){
            controllerHasil.back(this);
        }

    }
}
