/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserModel;

/**
 *
 * @author USER
 */
public class UserDao implements UserInterface{
    UserModel user;
    private int maxId; //harusnya ada di model 
    private String SQL_INSERT = "INSERT INTO `user` (`iduser`, `username`, `password`, `level`, `nama`, `deleted_status`) VALUES("+this.maxId+","+user.getUsername()+" ,"+user.getPassword()+",2,"+user.getNama()+",0)";
 
    private String SQL_UPDATE = "UPDATE `user` SET `username`="+user.getUsername() +",`password`="+user.getPassword() +"`nama`="+user.getNama()+"WHERE `iduser`= "+user.getIduser();
 
    private String SQL_DELETE = "UPDATE `user` SET `deleted_status`= 1 WHERE `iduser`= "+user.getIduser();
 
    private String SQL_GETALL = "SELECT * FROM `user` WHERE `deleted_status` = 0";
 
    private String SQL_GETBYID = "SELECT * FROM `user` WHERE `deleted_status` = 0 AND WHERE `iduser`= "+user.getIduser();
    private final Connection koneksiDatabase;

    public UserDao(Connection koneksiDatabase) {
        this.koneksiDatabase = koneksiDatabase;
    }
    
    @Override
    public void insert(UserModel user) throws SQLException {
        PreparedStatement statement = null;
        ResultSet result = null;
        statement = koneksiDatabase.prepareStatement(SQL_INSERT);
        
       try {
            PreparedStatement preparedStatement = koneksiDatabase.prepareStatement(SQL_INSERT);
            preparedStatement.execute();
            result = statement.getGeneratedKeys();
            
        } catch (SQLException ex) {
            koneksiDatabase.rollback();
            throw ex;
        } finally {
            try {
                koneksiDatabase.setAutoCommit(true);
                if (statement == null) {
                    statement.close();
                }
                if (result == null) {
                    result.close();
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void update(UserModel user) throws SQLException {
        
    }

    @Override
    public void delete(UserModel user) throws SQLException {
        
    }
    
    
    
}
