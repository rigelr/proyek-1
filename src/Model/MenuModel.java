package Model;

public class MenuModel {
 int id_menu,harga,stok,deleted_status,idNow;
 
 String nama,desc,kategori;

    public int getIdNow() {
        return idNow;
    }

    public void setIdNow(int idNow) {
        this.idNow = idNow;
    }
 
 

    public int getId_menu() {
        return id_menu;
    }

    public void setId_menu(int id_menu) {
        this.id_menu = id_menu;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getDeleted_status() {
        return deleted_status;
    }

    public void setDeleted_status(int deleted_status) {
        this.deleted_status = deleted_status;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKategori() {
        return kategori;
    }

    
    
    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
 
 
}
