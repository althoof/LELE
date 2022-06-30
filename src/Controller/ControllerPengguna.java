/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pengguna;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Muh
 */
public class ControllerPengguna extends AbstractTableModel{
    private final List<Pengguna> list = new ArrayList<>();

    public ControllerPengguna() {
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
                return list.get(rowIndex).getUsername();
            case 1:
                return list.get(rowIndex).getNama_pengguna();
            case 2:
                return list.get(rowIndex).getPassword();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int kolom) {
         switch (kolom) {
            case 0:
                return "Username";
            case 1:
                return "Nama Pengguna";
            case 2:
                return "Password";
            default:
                return null;
        }
    }
    
    public void add(Pengguna pengguna) {
        list.add(pengguna);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    
    public void delete(int i, int baris) {
        list.remove(i);
        fireTableRowsDeleted(i, baris);
    }
    
    public Pengguna get(int baris) {
        return (Pengguna) list.get(baris);
    }
}