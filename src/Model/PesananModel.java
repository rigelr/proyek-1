/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class PesananModel {
    int id_pesanan,jumlah,deleted_status,menu_id_menu,idNow;
    String transaksi_idtransaksi;

    public int getIdNow() {
     
        
        return idNow;
    }

    public void setIdNow(int idNow) {
        this.idNow = idNow;
    }

    
    public int getId_pesanan() {
        return id_pesanan;
    }

    public void setId_pesanan(int id_pesanan) {
        this.id_pesanan = id_pesanan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getDeleted_status() {
        return deleted_status;
    }

    public void setDeleted_status(int deleted_status) {
        this.deleted_status = deleted_status;
    }

    public int getMenu_id_menu() {
        return menu_id_menu;
    }

    public void setMenu_id_menu(int menu_id_menu) {
        this.menu_id_menu = menu_id_menu;
    }

    public String getTransaksi_idtransaksi() {
        return transaksi_idtransaksi;
    }

    public void setTransaksi_idtransaksi(String transaksi_idtransaksi) {
        this.transaksi_idtransaksi = transaksi_idtransaksi;
    }
    
    
    
    

    
    
}
