/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.MenuModel;
import Model.TransaksiModel;
import config.KoneksiDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PesananModel;
import model.UserModel;

/**
 *
 * @author Acer Swift 3
 */
public class TransaksiDao {
    private final Connection koneksiDatabase;
    
    public TransaksiDao(){
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }
    
    public List<TransaksiModel> getList() {
        String namaTable = "transaksi";
        String query = "SELECT * FROM "+namaTable;
        TransaksiModel model;
        List<TransaksiModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new TransaksiModel();
                model.setNama_cust(hasilQuery.getString("nama_cust"));
                model.setNo_meja(hasilQuery.getString("no_meja"));
                model.setIdtransaksi(hasilQuery.getString("idtransaksi"));
                model.setIduser(hasilQuery.getString("user_iduser"));
                model.setWaktu(hasilQuery.getString("waktu"));
                model.setTotal_harga(hasilQuery.getInt("total_harga"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                list.add(model);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
   
    }
    
    public TransaksiModel byWaktu(String waktu){
        String namaTable = "transaksi";
        String query = "SELECT * FROM "+namaTable+" WHERE waktu = "+waktu;
        TransaksiModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new TransaksiModel();
                model.setNama_cust(hasilQuery.getString("nama_cust"));
                model.setNo_meja(hasilQuery.getString("no_meja"));
                model.setIdtransaksi(hasilQuery.getString("idtransaksi"));
                model.setIduser(hasilQuery.getString("user_iduser"));
                model.setWaktu(hasilQuery.getString("waktu"));
                model.setTotal_harga(hasilQuery.getInt("total_harga"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public TransaksiModel byId(int id ){
        String namaTable = "transaksi";
        String query = "SELECT * FROM "+namaTable+" WHERE idtransaksi = "+id;
        TransaksiModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new TransaksiModel();
                model.setNama_cust(hasilQuery.getString("nama_cust"));
                model.setNo_meja(hasilQuery.getString("no_meja"));
                model.setIdtransaksi(hasilQuery.getString("idtransaksi"));
                model.setIduser(hasilQuery.getString("user_iduser"));
                model.setWaktu(hasilQuery.getString("waktu"));
                model.setTotal_harga(hasilQuery.getInt("total_harga"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
//    public void insert(UserModel user) throws SQLException {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//        LocalDateTime now = LocalDateTime.now();
//        String IdUser = String.valueOf(dtf.format(now));
//        String SQL_INSERT = "INSERT INTO user ('iduser', 'username', 'password', 'level', 'nama', 'deleted_status') "
//                + "VALUES("+IdUser+","+user.getUsername()+","+user.getPassword()+","+"1"+user.getNama()+"0"+")";
//        
//            try{
//                Statement preparedStatement = koneksiDatabase.createStatement();
//                preparedStatement.executeQuery(SQL_INSERT);
//            } catch(SQLException e){
//                java.util.logging.Logger.getLogger(Dao.UserDao.class.getName()).log(Level.SEVERE, null, e);
//            }
//    }
    
    public void insert(TransaksiModel model) throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String IdUser = String.valueOf(dtf.format(now));
        String SQL_INSERT = "INSERT INTO transaksi (`idtransaksi`, `nama_cust`, `no_meja`, `total_harga`, `waktu`, `deleted_status`, `user_iduser`) VALUES "
                + "('"+model.getIdtransaksi()+"', "
                + "'"+model.getNama_cust()+"',"
                + "'"+model.getNo_meja()+"', "
                + "'"+model.getTotal_harga()+"',"
                + "'"+model.getWaktu()+"',"
                + "'"+IdUser+"',"
                + "'"+model.getDeleted_status()+"');";
        
            try{
                Statement preparedStatement = koneksiDatabase.createStatement();
                preparedStatement.executeQuery(SQL_INSERT);
            } catch(SQLException e){
                java.util.logging.Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, e);
            }
    }
//    public boolean insert(TransaksiModel model) {
//        String namaTable = "transaksi";
//        String queryId = "SELECT MAX(id_pesanan) + 1 FROM pesanan";
//        String query = "INSERT INTO "+namaTable+" (`idtransaksi`, `nama_cust`, `no_meja`, `total_harga`, `waktu`, `deleted_status`, `user_iduser`) VALUES "
//                + "('"+model.getIdNow()+"', "
//                + "'"+model.getNama_cust()+"',"
//                + "'"+model.getNo_meja()+"', "
//                + "'"+model.getTotal_harga()+"',"
//                + "'"+model.getWaktu()+"',"
//                + "'"+model.getIduser()+"',"
//                + "'"+model.getDeleted_status()+"');";
//                
//        try {
//            //get id
//            Statement preparedStatement = koneksiDatabase.createStatement();
//            ResultSet hasilQuery = preparedStatement.executeQuery(queryId);
//            
//                model.setIdtransaksi(hasilQuery.getString("idtransaksi"));
//            while(hasilQuery.next()){
//                model = new TransaksiModel();
//                model.setIdNow(hasilQuery.getInt(model.getIdNow()));
//                
//            }
//            //insert data
//            PreparedStatement preparedStatement1 = koneksiDatabase.prepareStatement(query);
//            preparedStatement1.execute();   
//            return true;
//        } catch (SQLException ex) {
//            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
    
}
