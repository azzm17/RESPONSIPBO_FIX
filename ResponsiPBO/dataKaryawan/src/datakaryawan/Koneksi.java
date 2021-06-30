/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan;

/**
 *
 * @author User
 */
import java.sql.*;
public class Koneksi {
    String DBurl = "jdbc:mysql://localhost/karyawan";
    String DBusername = "root";
    String DBpassword = "";
    public Connection koneksi;
    public Statement statement;
    public Koneksi() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Terkoneksi");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
