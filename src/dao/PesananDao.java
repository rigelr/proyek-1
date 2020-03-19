/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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
import model.PesananModel;

/**
 *
 * @author Acer Swift 3
 */
public class PesananDao {
    private final Connection koneksiDatabase;
    
    public PesananDao(){
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }
    
     public List<PesananModel> getList() {
        String namaTable = "pesanan";
        String query = "SELECT * FROM "+namaTable;
        PesananModel model;
        List<PesananModel> list = new ArrayList<>();
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new PesananModel();
                model.setMenu_id_menu(hasilQuery.getInt("menu_id_menu"));
                model.setId_pesanan(hasilQuery.getInt("id_pesanan"));
                model.setTransaksi_idtransaksi(hasilQuery.getString("transaksi_idtransaksi"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                model.setJumlah(hasilQuery.getInt("jumlah"));
                list.add(model);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     
    public PesananModel byId(int id){
        String namaTable = "pesanan";
        String query = "SELECT * FROM "+namaTable+" WHERE id = "+id;
        PesananModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new PesananModel();
                model.setMenu_id_menu(hasilQuery.getInt("menu_id_menu"));
                model.setId_pesanan(hasilQuery.getInt("id_pesanan"));
                model.setTransaksi_idtransaksi(hasilQuery.getString("transaksi_idtransaksi"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                model.setJumlah(hasilQuery.getInt("jumlah"));
                
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public boolean update(int jumlah, int id_pesanan, int id_menu, String id_transaksi, int deleted_status) {
        String namaTable = "pesanan";
        String query= "update pesanan set"
                + " id_pesanan='"+id_pesanan+"'"
                + ",jumlah='"+jumlah+"'"
                + ",menu_id_menu='"+id_menu+"'"
                + ",transaksi_idtransaksi='"+id_transaksi+"'"
                + ",deleted_status='"+deleted_status+"'"
                + " where id='"+id_pesanan+"'";
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            
        
            Logger.getLogger(PesananDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean insert(int jumlah, int id_pesanan, int id_menu, String id_transaksi, int deleted_status) {
        String namaTable = "pesanan";
        String query = "INSERT INTO "+namaTable+" (`id_pesanan`, `jumlah`, `menu_id_menu`, `transaksi_idtransaksi`, `deleted_status`) VALUES "
                + "('"+id_pesanan+"', '"+jumlah+"','"+id_menu+"', '"+id_transaksi+"','"+deleted_status+"');";
                
        
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
