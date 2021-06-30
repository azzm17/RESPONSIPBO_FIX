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

import java.awt.*;
import java.awt.event.*;
import datakaryawan.controller.*;
import datakaryawan.model.*;
import javax.swing.*;

public class ViewHitungGaji extends JFrame implements ActionListener {
ControllerHitungGaji controllerHitungGaji = new ControllerHitungGaji();
    
    private JTextField flembur = new JTextField();
    JLabel fnama = new JLabel();
    JLabel fgaji = new JLabel();
    JLabel fusia = new JLabel();
    
    JLabel lnama = new JLabel("NAMA:");
    JLabel lgaji = new JLabel("GAJI:");
    JLabel lusia = new JLabel("USIA:");
    JLabel llembur = new JLabel("WAKTU LEMBUR:");
    JLabel ljudul = new JLabel("Perhitungan Gaji");
    
    JButton buttonSubmit = new JButton("Edit");
    JButton buttonReset = new JButton("Delete");
    JButton buttonBack = new JButton("Back");
    JButton buttonGaji = new JButton("Total Gaji");

    DtKaryawan karyawan;
    public ViewHitungGaji(DtKaryawan karyawan) {
        
        setTitle("Perhitungan Gaji");
        setSize(350,350);
        setVisible(true);
        setLocationRelativeTo(null);
        
        this.karyawan = karyawan;
        
        fnama.setText(karyawan.getNama());
        fusia.setText(String.valueOf(karyawan.getUsia()));
        fgaji.setText(String.format("%,.2f", karyawan.getGaji()));
        
        this.setLayout(null);
        
        this.add(fnama);
        this.add(fgaji);
        this.add(fusia);
        this.add(flembur);
        fnama.setBounds  (150, 60, 130, 30);
        fgaji.setBounds  (150, 90, 130, 30);
        fusia.setBounds  (150, 120,130, 30);
        flembur.setBounds(150, 150, 100, 20);
        
        this.add(lnama);
        this.add(lgaji);
        this.add(lusia);
        this.add(ljudul);
        this.add(llembur);
        lnama.setBounds  (10, 60, 40, 20);
        lgaji.setBounds  (10, 90, 40, 20);
        lusia.setBounds  (10, 120, 40, 20);
        ljudul.setBounds (10, 20, 250, 20);
        llembur.setBounds(10, 150, 120, 20);
        
        this.add(buttonSubmit);
        this.add(buttonReset);
        this.add(buttonBack);  
        this.add(buttonGaji);
        buttonGaji.setBounds  (80, 170, 100, 30);
        buttonSubmit.setBounds(100, 220, 90, 30);
        buttonReset.setBounds (190, 220, 90, 30);
        buttonBack.setBounds  (10,  220, 90, 30);
       
        buttonSubmit.addActionListener(this);
        buttonReset.addActionListener(this);
        buttonBack.addActionListener(this);
        buttonGaji.addActionListener(this);
        
        buttonSubmit.setBackground(Color.BLUE);
        buttonReset.setBackground(Color.RED);
        buttonBack.setBackground(Color.YELLOW);
        buttonGaji.setBackground(Color.GREEN);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getFlembur() {
        return flembur;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == buttonSubmit){
            controllerHitungGaji.edit(this, karyawan);
        }
        if (e.getSource() == buttonReset){
            controllerHitungGaji.delete(this, karyawan.getId());
        }
        if (e.getSource() == buttonBack){
            controllerHitungGaji.back(this);
        }
        int total = Integer.parseInt(this.flembur.getText());
        if (e.getSource() == buttonGaji){
            controllerHitungGaji.viewHasil(this, karyawan,total );
        }
    }
    
}
