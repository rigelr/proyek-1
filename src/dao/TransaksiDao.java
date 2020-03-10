/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.TransaksiModel;
import config.KoneksiDatabase;
import java.sql.Connection;
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
     
      public TransaksiDao() {
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
                model.setIdtransaksi(hasilQuery.getString("idtransaksi"));
                model.setNama_cust(hasilQuery.getString("nama_cust"));
                model.setNo_meja(hasilQuery.getString("no_meja"));
                model.setTotal_harga(hasilQuery.getInt("total_harga"));
               // model.setWaktu(hasilQuery.getTime);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
