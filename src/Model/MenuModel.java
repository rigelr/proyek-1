package Model;

public class MenuModel {
 int id_menu,harga,stok,deleted_status,idNow;
 
 String nama,desc,kategori;
 
  byte[] Image;

    public MenuModel() {
    }
  
  

    public MenuModel(int id_menu, int harga, int stok, int deleted_status, int idNow, String nama, String desc, String kategori, byte[] Image) {
        this.id_menu = id_menu;
        this.harga = harga;
        this.stok = stok;
        this.deleted_status = deleted_status;
        this.idNow = idNow;
        this.nama = nama;
        this.desc = desc;
        this.kategori = kategori;
        this.Image = Image;
    }
  
  

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    

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
