package Dao;

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
import model.UserModel;

public class UserDao implements UserInterface{
    UserModel user;
    
    
    private final Connection koneksiDatabase;
    
    public UserDao(){
        this.koneksiDatabase = KoneksiDatabase.koneksiDB();
    }
    
    public List<UserModel> getList(){
        String SQL_GETALL = "SELECT * FROM user WHERE deleted_status = 0";
        List<UserModel> list = new ArrayList<>();
        try{
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet result = preparedStatement.executeQuery(SQL_GETALL);
            
            while(result.next()){
                user = new UserModel();
                user.setIduser(result.getString("iduser"));
                user.setLevel(result.getInt("level"));
                user.setDeleted_status(result.getInt("deleted_status"));
                user.setNama(result.getString("nama"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                list.add(user);
            }
            return list;
        } catch (SQLException e){
            java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }
    }
    
    public UserModel byId(String id){
        String SQL_GETBYID = "SELECT * FROM user WHERE deleted_status = 0 AND WHERE iduser = " + user.getIduser();
        user.setIduser(String.valueOf(id));
        try{
            Statement preparedStatement = koneksiDatabase.createStatement();
            ResultSet result = preparedStatement.executeQuery(SQL_GETBYID);
            
            while (result.next()){
            user = new UserModel();
                user.setIduser(result.getString("iduser"));
                user.setLevel(result.getInt("level"));
                user.setDeleted_status(result.getInt("deleted_status"));
                user.setNama(result.getString("nama"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
            }
            return user;
        } catch (SQLException e){
            java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE,null,e);
            return null;
        }
    }
    
    @Override
    public void insert(UserModel user) throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime now = LocalDateTime.now();
        String IdUsernow = String.valueOf(dtf.format(now));
            String SQL_INSERT = "INSERT INTO `user` (`iduser`, `username`, `password`, `level`, `nama`, `deleted_status`)"
                    +" VALUES ('" +IdUsernow+"', '"+user.getUsername()+"', '"+user.getPassword()+"','"+user.getLevel()+"','"+user.getNama()+"', '0');";
            try{
                PreparedStatement PreparedInsert = koneksiDatabase.prepareStatement(SQL_INSERT);
                PreparedInsert.executeUpdate();
               
            } catch(SQLException e){
                java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            }
    }
    
    @Override
    public void update(UserModel user) throws SQLException {
        String SQL_UPDATE = "UPDATE user SET username = "+user.getUsername() +", password ="+user.getPassword()+"nama ="+user.getNama()+"WHERE iduser = "+user+"";
        
        try{
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(SQL_UPDATE);
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }               
    }
    

    @Override
    public void delete(String id) throws SQLException{
        String SQL_DELETE = "UPDATE user SET deleted_status = 1 WHERE 'iduser' = "+id;
        
        try{
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(SQL_DELETE);
            preparedStatement.executeUpdate();
        } catch(SQLException e){
            java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }         
    }
    
//    public int maxId(){
//        int maxId = 0;
//        try {
//            String SQL_MAXID = "SELECT MAX(iduser)as Max FROM `user`";
//     
//            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(SQL_MAXID);
//            ResultSet rs = preparedStatement.executeQuery();
//            if (rs.next()) {
//                maxId = Integer.parseInt(rs.getString("Max"));
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return maxId;
//    }
//    
   
}
