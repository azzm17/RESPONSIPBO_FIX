/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datakaryawan.model;

/**
 *
 * @author User
 */
import java.sql.*;
import datakaryawan.Koneksi;

public class ModelDataKaryawan {
    DtKaryawan data[] = new DtKaryawan[100]; 
    Koneksi connector = new Koneksi();
    
    public DtKaryawan[] getAll(){
         try{
            int jumlahDT = 0;
            String query = "Select * from `karyawan`"; //pengambilan data dari 'karyawan'
            
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            
            while(resultSet.next()){ 
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                double gaji = resultSet.getDouble("gaji");
                int usia = resultSet.getInt("usia");
                data[jumlahDT] = new DtKaryawan(id,nama,gaji,usia);
                jumlahDT++;
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
    return data;
    }
    
    public DtKaryawan getOne(String ids){
         try{
            String query = "Select * from `karyawan` where `id` ='"+ids+"'";
            
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            
            while(resultSet.next()){ 
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                double gaji = resultSet.getDouble("gaji");
                int usia = resultSet.getInt("usia");
                data[0] = new DtKaryawan(id,nama,gaji,usia);
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
    return data[0];
    }
    
     public String create(DtKaryawan karyawan){
         String message = "...";
         try{
                String nama = karyawan.getNama();
                int usia = karyawan.getUsia();
                double gaji = karyawan.getGaji();
                String query = "INSERT INTO `karyawan`(`nama`, `usia`,`gaji`) VALUES ('"+nama+"',"+usia+","+gaji+")"; 
                    connector.statement = connector.koneksi.createStatement();
                    connector.statement.executeUpdate(query); 
            message = "Berhasil Create Data";
                    connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
    return message;
    }
    
    public String delete(int id) {
        String message = "...";
        try {
                String query = "DELETE FROM karyawan WHERE id = '" + id + "'";
                    connector.statement = connector.koneksi.createStatement();
                    connector.statement.executeUpdate(query);
            message = "Berhasil Delete Data";
                    connector.statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
        return message;
    }
    
    public String update(DtKaryawan karyawan) {
        String message = "...";
        try {
                String query = "UPDATE karyawan SET nama = '"+karyawan.getNama()+"',usia = "+karyawan.getUsia()+",gaji = "+karyawan.getGaji()+" WHERE id = '" + karyawan.getId() + "'";
                    connector.statement = connector.koneksi.createStatement();
                    connector.statement.executeUpdate(query);
            message = "Berhasil Update Data";
                    connector.statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("404 Error");
        }
        return message;
    }
    
}
