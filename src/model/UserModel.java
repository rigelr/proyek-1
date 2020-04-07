package model;

public class UserModel {
    String iduser,username,password,nama;
    int deleted_status;
    int level;

    public String getIduser() {
        return iduser;
    }

    public void setIduser(String iduser) {
        this.iduser = iduser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDeleted_status() {
        return deleted_status;
    }

    public void setDeleted_status(int deleted_status) {
        this.deleted_status = deleted_status;
    }

    
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    

}
