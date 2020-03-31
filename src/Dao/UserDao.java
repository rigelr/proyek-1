package Dao;

import com.sun.istack.internal.logging.Logger;
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
import model.UserModel;

public class UserDao implements UserInterface{
    UserModel user;
    
    private String SQL_GETALL = "SELECT * FROM user WHERE deleted_status = 0";
    private String SQL_GETBYID = "SELECT * FROM user WHERE deleted_status = 0 AND WHERE iduser = " + user.getIduser();
    
    private final Connection koneksiDatabase;
    
    public UserDao(Connection koneksiDatabase){
        this.koneksiDatabase = koneksiDatabase;
    }
    
    public UserDao(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<UserModel> getList(){
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
    
    public UserModel byId(int id){
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
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        String IdUser = String.valueOf(dtf.format(now));
        String SQL_INSERT = "INSERT INTO user ('iduser', 'username', 'password', 'level', 'nama', 'deleted_status') "
                + "VALUES("+IdUser+","+user.getUsername()+","+user.getPassword()+","+"1"+user.getNama()+"0"+")";
        
            try{
                Statement preparedStatement = koneksiDatabase.createStatement();
                preparedStatement.executeQuery(SQL_INSERT);
            } catch(SQLException e){
                java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
            }
    }
    
    @Override
    public void update(UserModel user) throws SQLException {
        String SQL_UPDATE = "UPDATE user SET username = "+user.getUsername() +", password ="+user.getPassword()+"nama ="+user.getNama()+"WHERE iduser = "+user+"";
        
        try{
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(SQL_UPDATE);
            preparedStatement.executeQuery();
        } catch(SQLException e){
            java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }               
    }
    
    @Override
    public void delete(UserModel user) throws SQLException{
        String SQL_DELETE = "UPDATE user SET deleted_status = 1 WHERE 'iduser' = "+user.getIduser();
        
        try{
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(SQL_DELETE);
            preparedStatement.executeQuery();
        } catch(SQLException e){
            java.util.logging.Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, e);
        }         
    }
    
   
}
