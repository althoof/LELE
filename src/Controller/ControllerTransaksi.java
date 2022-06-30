/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Transaksi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Muh
 */
public class ControllerTransaksi extends AbstractTableModel{
    private final List<Transaksi> list = new ArrayList<>();

    public ControllerTransaksi() {
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_transaksi();
            case 1:
                return list.get(rowIndex).getUsername();
            case 2:
                return list.get(rowIndex).getId_barang();
            case 3:
                return list.get(rowIndex).getQty();
            case 4:
                return list.get(rowIndex).getTotal();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int kolom) {
         switch (kolom) {
            case 0:
                return "Kode Transaksi";
            case 1:
                return "Pembeli";
            case 2:
                return "Kode Barang";
            case 3:
                return "Jumlah Beli";
            case 4:
                return "Total Bayar";
            default:
                return null;
        }
    }
    
    public void add(Transaksi transaksi) {
        list.add(transaksi);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    
    public void delete(int i, int baris) {
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    
    public Transaksi get(int baris) {
        return (Transaksi) list.get(baris);
    }
}