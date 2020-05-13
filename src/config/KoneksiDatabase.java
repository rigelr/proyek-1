package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class KoneksiDatabase {
    
    private static java.sql.Connection mysqlkonek;
    
    public static java.sql.Connection koneksiDB() {
        if(mysqlkonek==null){
            try {
                String DB="jdbc:mysql://www.remotemysql.com:3306/1Hu4AvcfUp?useSSL=false"; // fp_pbo database sudah di hosting
                String user="1Hu4AvcfUp"; // user database
                String pass="ZFKGkixsoy"; // password database
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (java.sql.Connection) DriverManager.getConnection(DB,user,pass);
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, pastikan MySQL berjalan !");
            }
        }
        return mysqlkonek;
    }
    

}
