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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                model.setIduser(hasilQuery.getString("iduser"));
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
                model.setIduser(hasilQuery.getString("iduser"));
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
        String query = "SELECT * FROM "+namaTable+" WHERE id = "+id;
        TransaksiModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new TransaksiModel();
                model.setNama_cust(hasilQuery.getString("nama_cust"));
                model.setNo_meja(hasilQuery.getString("no_meja"));
                model.setIdtransaksi(hasilQuery.getString("idtransaksi"));
                model.setIduser(hasilQuery.getString("iduser"));
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
    
    public boolean insert(String nama_cust, String no_meja, String idtransaksi, String iduser, String waktu, int total_harga, int deleted_status) {
        String namaTable = "transaksi";
        String query = "INSERT INTO "+namaTable+" (`nama_cust`, `no_meja`, `idtransaksi`, `iduser`, `waktu`,`total_harga`,`deleted_status`) VALUES "
                + "('"+nama_cust+"', '"+no_meja+"','"+idtransaksi+"', '"+iduser+"', '"+waktu+"','"+total_harga+"','"+deleted_status+"');";
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
