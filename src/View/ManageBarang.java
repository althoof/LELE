/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerBarang;
import Model.Barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Muh
 */
public class ManageBarang extends javax.swing.JFrame {
    private final ControllerBarang controllerBarang;
    private final Config.Config config;

    /**
     * Creates new form ManageBarang
     */
    public ManageBarang() {
        initComponents();
        config = new Config.Config();
        controllerBarang = new ControllerBarang();
        tableBarang.setModel(controllerBarang);
        tampilData();
        SetEditOff();
    }
    
    private void tampilData(){
        try{
            int baris = tableBarang.getRowCount();
            for(int i = 0; i < baris; i++) {
                controllerBarang.delete(0, baris);
            }
            String sql = "SELECT * FROM barang";
            ResultSet rs = config.getData(sql);
            while(rs.next()){
                Barang barang = new Barang();
                barang.setId_barang(rs.getString(1));
                barang.setNama_barang(rs.getString(2));
                barang.setHarga(Integer.parseInt(rs.getString(3)));
                controllerBarang.add(barang);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    
    public void autoKodeBarang(){
        try{
            String sql="SELECT MAX(RIGHT(id_barang, 4))FROM barang";
            ResultSet rs=config.getData(sql);
            while(rs.next()){
                if(rs.first()==true){
                    rs.last();
                    int hitung=rs.getInt(1)+1;
                    String itung=String.valueOf(hitung);
                    int panjang = itung.length();
                    for (int i=0; i<4-panjang;i++){
                        itung="000"+hitung;    
                    }
                    txtKodeBarang.setText("BRG_"+itung);
                }else{
                    txtKodeBarang.setText("BRG_0001");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void TampilText(){
        int row = 0;
        row = tableBarang.getSelectedRow();
        Barang barang = controllerBarang.get(row);
        txtKodeBarang.setText(barang.getId_barang());
        txtNamaBarang.setText(barang.getNama_barang());
        txtHarga.setText(String.valueOf(barang.getHarga()));
        btnSave.setEnabled(false);
        btnNew.setEnabled(false);
        SetEditOn();
    }
    
    public void clearText(){
        txtKodeBarang.setText("");
        txtNamaBarang.setText("");
        txtHarga.setText("");
    }
    
    public void SetEditOff(){
        txtKodeBarang.setEnabled(false);
        txtNamaBarang.setEnabled(false);
        txtHarga.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnNew.setEnabled(true);
    }
    
    public void SetEditOn(){
        txtKodeBarang.setEnabled(true);
        txtNamaBarang.setEnabled(true);
        txtHarga.setEnabled(true);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnNew.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtKodeBarang = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        txtHarga = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BARANG");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tableBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBarang);

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Nama Barang");

        jLabel4.setText("Harga");

        btnSave.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(73, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(73, 23));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(73, 23));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(73, 23));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnNew.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnNew.setText("New");
        btnNew.setPreferredSize(new java.awt.Dimension(73, 23));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel3)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(53, 53, 53)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(21, 21, 21)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(171, 171, 171)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseClicked
        if(evt.getClickCount()==1){
            TampilText();
        }
        btnCancel.setEnabled(true);
        btnNew.setEnabled(false);
        txtKodeBarang.setEnabled(false);
    }//GEN-LAST:event_tableBarangMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String kode_barang = txtKodeBarang.getText();
        String nama_barang = txtNamaBarang.getText();
        String harga = txtHarga.getText();
        if ((kode_barang.isEmpty()) | (nama_barang.isEmpty()) | (harga.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, " +
                "silahkan dilengkapi");
            txtKodeBarang.requestFocus();
        }else {
            try {
                String sql = "INSERT INTO barang (id_barang, nama_barang, harga) "
                + "VALUES ("
                + "'" + kode_barang + "',"
                + "'" + nama_barang+ "',"
                + "'" + harga + "'"
                + ")";
                config.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, "Data Barang "+ nama_barang +" Berhasil Dibuat.");
                clearText();
                SetEditOff();
                btnNew.setEnabled(true);
            }catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String kode_barang = txtKodeBarang.getText();
        String nama_barang = txtNamaBarang.getText();
        String harga = txtHarga.getText();
        if ((kode_barang.isEmpty()) | (nama_barang.isEmpty()) | (harga.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, " +
                "silahkan dilengkapi");
            txtKodeBarang.requestFocus();
        }else {
            try {
                String sql = "UPDATE barang SET "
                + "nama_barang = '" + nama_barang + "',"
                + "harga = '" + harga + "'WHERE "
                + "id_barang = '" + kode_barang + "'";
                config.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, "Data Barang "+ nama_barang +" Berhasil Diperbarui");
                clearText();
                SetEditOff();
                btnNew.setEnabled(true);
            }catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearText();
        SetEditOff();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String kode_barang = txtKodeBarang.getText();
        int app;
        if ((app = JOptionPane.showConfirmDialog(null, "Anda yakin akan menghapus data "
            + kode_barang+ " ?", "Perhatian", JOptionPane.YES_NO_OPTION)) == 0){
    try {
        String sql = "DELETE FROM barang WHERE"
        + " id_barang = '" + kode_barang+ "'";
        config.query(sql);
        tampilData();
        JOptionPane.showMessageDialog(null, "Data Barang "+ kode_barang +" Berhasil Dihapus");
        clearText();
        SetEditOff();
        btnNew.setEnabled(true);
        }catch (Exception ex) {
            System.err.print(ex.getMessage());
        }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearText();
        autoKodeBarang();
        txtNamaBarang.requestFocus();
        SetEditOn();
        txtKodeBarang.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnNew.setEnabled(false);
        btnCancel.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnNewActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtNamaBarang;
    // End of variables declaration//GEN-END:variables
}
