/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Muh
 */
public class Barang {
    String id_barang, nama_barang;
    int harga;

    public Barang() {}
    
    public Barang(String id_barang, String nama_barang, int harga) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.harga = harga;
    }

    public String getId_barang() {
        return id_barang;
    }

    public void setId_barang(String id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}