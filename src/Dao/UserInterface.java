/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.SQLException;
import model.UserModel;

/**
 *
 * @author USER
 */
public interface UserInterface {
    void insert (UserModel user) throws SQLException;
    void update (UserModel user) throws SQLException;
    void delete (UserModel user) throws SQLException;
    
    
}
