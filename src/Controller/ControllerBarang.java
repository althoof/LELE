/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Barang;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Muh
 */
public class ControllerBarang extends AbstractTableModel{
    private final List<Barang> list = new ArrayList<>();

    public ControllerBarang() {
    }
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_barang();
            case 1:
                return list.get(rowIndex).getNama_barang();
            case 2:
                return list.get(rowIndex).getHarga();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int kolom) {
         switch (kolom) {
            case 0:
                return "Kode Barang";
            case 1:
                return "Nama Barang";
            case 2:
                return "Harga";
            default:
                return null;
        }
    }
    
    public void add(Barang barang) {
        list.add(barang);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    
    public void delete(int i, int baris) {
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    
    public Barang get(int baris) {
        return (Barang) list.get(baris);
    }
}
