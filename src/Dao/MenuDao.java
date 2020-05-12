package Dao;

import static com.oracle.jrockit.jfr.ContentType.Bytes;
import config.KoneksiDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.MenuModel;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class MenuDao {
     private final Connection koneksiDatabase;
    
    public MenuDao(){
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }

     public ArrayList<MenuModel> getList() {
        String query = "SELECT * FROM `menu` WHERE `deleted_status` = 0";
        MenuModel model;
        ArrayList<MenuModel> list = new ArrayList<>();
        
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new MenuModel();
                model.setId_menu(hasilQuery.getInt("id_menu"));
                model.setNama(hasilQuery.getString("nama"));
                model.setHarga(hasilQuery.getInt("harga"));
                model.setDesc(hasilQuery.getString("desc"));
                model.setStok(hasilQuery.getInt("stok"));
                model.setKategori(hasilQuery.getString("kategori"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                model.setImage(hasilQuery.getBytes("foto"));
                list.add(model);
            }            
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public MenuModel byKategori(String kategori ){
        String namaTable = "menu";
        String query = "SELECT * FROM "+namaTable+" WHERE kategori = "+kategori;
        MenuModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new MenuModel();
                model.setId_menu(hasilQuery.getInt("id_menu"));
                model.setNama(hasilQuery.getString("nama"));
                model.setHarga(hasilQuery.getInt("harga"));
                model.setDesc(hasilQuery.getString("desc"));
                model.setStok(hasilQuery.getInt("stok"));
                model.setKategori(hasilQuery.getString("kategori"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                model.setImage(hasilQuery.getBytes("foto"));
                //model.setFoto(hasilQuery.getString("foto"));
                
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public MenuModel byId(int id ){
        String namaTable = "menu";
        String query = "SELECT * FROM "+namaTable+" WHERE `deleted_status` = 0 AND `id_menu`= "+id;
        MenuModel model = null;
        try {
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet hasilQuery = preparedStatement.executeQuery(query);
            
            while(hasilQuery.next()){
                model = new MenuModel();
                model.setId_menu(hasilQuery.getInt("id_menu"));
                model.setNama(hasilQuery.getString("nama"));
                model.setHarga(hasilQuery.getInt("harga"));
                model.setDesc(hasilQuery.getString("desc"));
                model.setStok(hasilQuery.getInt("stok"));
                model.setKategori(hasilQuery.getString("kategori"));
                model.setDeleted_status(hasilQuery.getInt("deleted_status"));
                model.setImage(hasilQuery.getBytes("foto"));
               // model.setFoto(hasilQuery.getString("foto"));
                
            }            
            return model;
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
     public boolean update(int id_menu, String nama, int harga, 
             String desc,int stok,String kategori, int deleted_status) {
         String namaTable = "menu";
         
         String query= "UPDATE `menu` SET "
                + "`nama` = '"+nama+"', "
                + "`harga` = '"+harga+"', "
                + "`desc` = '"+desc+"', "
                + "`stok` = '"+stok+"', "
                + "`kategori` = '"+kategori+"' "
                + "WHERE `menu`.`id_menu` ="+id_menu+";";
        
        try {
            
            PreparedStatement preparedStatement2 = koneksiDatabase.prepareStatement(query);
            preparedStatement2.executeUpdate();   
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            return true;
          
        } catch (SQLException ex) {
            
        
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
     public boolean insert(MenuModel model, String s) throws FileNotFoundException {
        String namaTable = "menu";
        //String queryId = "SELECT MAX(id_menu) + 1 FROM menu";
        
        try {
//            //get id
//            Statement preparedStatement = koneksiDatabase.createStatement();
//            ResultSet hasilQuery = preparedStatement.executeQuery(queryId);
//            
//               // model.setId_menu(hasilQuery.getInt("id_menu"));
//            while(hasilQuery.next()){
//                model = new MenuModel();
//                model.setIdNow(hasilQuery.getInt(model.getIdNow()));
//                
//            }
//            String query = "INSERT INTO "+namaTable+" (`id_menu`, `nama`, `harga`, `desc`, `stok`,`kategori`,`deleted_status`,`foto`) VALUES "
//                + "('?', '?','?', '?', '?','?','?','?');";
          
            PreparedStatement preparedStatement2 = koneksiDatabase.prepareStatement("INSERT INTO "+namaTable+" (`id_menu`, `nama`, `harga`, `desc`, `stok`,`kategori`,`deleted_status`,`foto`) VALUES "
                + "('?', '?','?', '?', '?','?','?','?');");
            InputStream is = new FileInputStream(new File(s));
            
            preparedStatement2.setInt(1, model.getId_menu());
            preparedStatement2.setString(2, model.getNama());
            preparedStatement2.setInt(3, model.getHarga());
            preparedStatement2.setString(4, model.getDesc());
            preparedStatement2.setInt(5, model.getStok());
            preparedStatement2.setString(6, model.getKategori());
            preparedStatement2.setInt(7, model.getDeleted_status());
            preparedStatement2.setBlob(8,is);
            
            preparedStatement2.execute();   
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
            return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
    public boolean delete(int id) {
        String query = "UPDATE `menu` SET `deleted_status`= 1 WHERE `id_menu`="+id;
        
        try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(query);
            preparedStatement.execute();   
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
