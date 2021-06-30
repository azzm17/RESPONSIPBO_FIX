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

import datakaryawan.controller.ControllerListData;
import datakaryawan.model.DtKaryawan;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.*;

public class ViewListData extends JFrame implements MouseListener, ActionListener {
    ControllerListData controllerListData = new ControllerListData();
    
    JLabel ljudul = new JLabel("List Data Karyawan");
    JButton buttonBack = new JButton("Back");    
    DefaultTableModel model;
    JTable tabel;
    DtKaryawan[] karyawan1 = new DtKaryawan[500];
    
    public ViewListData(DtKaryawan[] karyawan1){
        addMouseListener(this); 
        this.karyawan1 = karyawan1;
        setTitle("List Data Karyawan");
        setSize(700,450);
        setVisible(true);
        setLayout(null);
        this.add(ljudul);
        ljudul.setFont(new Font("Arial",Font.BOLD,20));
        ljudul.setBounds(10, 10, 260, 40);
        
        model = new DefaultTableModel();
        tabel = new JTable(model);
        model.setColumnIdentifiers(new Object[]{"ID", "Nama", "Usia", "Gaji"});
        					
        TableColumn column;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tabel.getColumnModel().getColumn(0); 
        column.setPreferredWidth(50);
        column = tabel.getColumnModel().getColumn(1); 
        column.setPreferredWidth(250); 
        column = tabel.getColumnModel().getColumn(2); 
        column.setPreferredWidth(50); 
        column = tabel.getColumnModel().getColumn(3); 
        column.setPreferredWidth(200);
        
        tabel.setBackground(Color.PINK);
        tabel.setRowSelectionAllowed(true);
        tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tabel.setFont(new Font("Arial",Font.PLAIN,14));
        tabel.setSelectionBackground(Color.GREEN);
        tabel.setSelectionForeground(Color.CYAN);
        tabel.addMouseListener(this);
        
        JScrollPane scroll = new JScrollPane(tabel);
        this.add(scroll);
        scroll.setBounds(20,50,600,250);
        this.addData();
        
        this.add(buttonBack);
        buttonBack.setBounds(0,320,650,20);
        buttonBack.addActionListener(this);
        
         
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addData() {
        DtKaryawan[] listData = this.karyawan1;
       for (DtKaryawan dtkaryawan : listData) {
            try {
                model.addRow(new Object[]{
                    dtkaryawan.getId(), 
                    dtkaryawan.getNama(),
                    dtkaryawan.getUsia(), 
                    String.format("%,.2f", dtkaryawan.getGaji())});
            } catch (Exception e) {

            }
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (tabel.getSelectedRow() != -1) {
            int index = tabel.getSelectedRow() ;
            controllerListData.viewPerhitunganGaji(this, karyawan1[index]);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == buttonBack){
            controllerListData.back(this);
        }
    }
    
}
