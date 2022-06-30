/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerTransaksi;
import Model.Transaksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Muh
 */
public class ManageTransaksi extends javax.swing.JFrame {
    private final ControllerTransaksi controllerTransaksi;
    private final Config.Config config;

    /**
     * Creates new form ManageTransaksi
     */
    public ManageTransaksi() {
        initComponents();
        config = new Config.Config();
        controllerTransaksi = new ControllerTransaksi();
        tableBarang.setModel(controllerTransaksi);
        tampilData();
        SetEditOff();
        GetDataPengguna();
        GetDataBarang();
    }
    
    private void tampilData(){
        try{
            int baris = tableBarang.getRowCount();
            for(int i = 0; i < baris; i++) {
                controllerTransaksi.delete(0, baris);
            }
            String sql = "SELECT * FROM transaksi";
            ResultSet rs = config.getData(sql);
            while(rs.next()){
                Transaksi transaksi = new Transaksi();
                transaksi.setId_transaksi(rs.getString(1));
                transaksi.setUsername(rs.getString(2));
                transaksi.setId_barang(rs.getString(3));
                transaksi.setQty(rs.getString(4));
                transaksi.setTotal(rs.getString(5));
                controllerTransaksi.add(transaksi);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    
    public void autoKodeTransaksi(){
        try{
            String sql="SELECT MAX(RIGHT(id_transaksi, 4))FROM transaksi";
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
                    txtKodeTransaksi.setText("TRS_"+itung);
                }else{
                    txtKodeTransaksi.setText("TRS_0001");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void GetDataPengguna(){
        try{
            Config.Config conn = new Config.Config();
            String sql = "SELECT * FROM pengguna";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                cbNamaPembeli.addItem(rs.getString(1));
            }
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void GetDataBarang(){
        try{
            Config.Config conn = new Config.Config();
            String sql = "SELECT * FROM barang";
            ResultSet rs = conn.getData(sql);
            while(rs.next()){
                cbNamaBarang.addItem(rs.getString(2));
            }
        }catch (SQLException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public void TampilText(){
        int row = 0;
        row = tableBarang.getSelectedRow();
        Transaksi transaksi = controllerTransaksi.get(row);
        txtKodeTransaksi.setText(transaksi.getId_transaksi());
        txtUsername.setText(transaksi.getUsername());
        txtKodeBarang.setText(transaksi.getId_barang());
        txtQty.setText(transaksi.getQty());
        txtTotalBayar.setText(transaksi.getTotal());
        btnSave.setEnabled(false);
        btnNew.setEnabled(false);
        SetEditOn();
    }
    
    public void clearText(){
        txtKodeTransaksi.setText("");
        txtQty.setText("");
        txtTotalBayar.setText("");
        cbNamaBarang.setSelectedIndex(0);
        cbNamaPembeli.setSelectedIndex(0);
    }
    
    public void SetEditOff(){
        txtKodeTransaksi.setEnabled(false);
        txtUsername.setEnabled(false);
        txtKodeBarang.setEnabled(false);
        txtQty.setEnabled(false);
        txtHarga.setEnabled(false);
        txtTotalBayar.setEnabled(false);
        cbNamaPembeli.setEnabled(false);
        cbNamaBarang.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnNew.setEnabled(true);
        btnHitung.setEnabled(false);
    }
    
    public void SetEditOn(){
        txtKodeTransaksi.setEnabled(false);
        txtUsername.setEnabled(false);
        txtKodeBarang.setEnabled(false);
        txtQty.setEnabled(true);
        txtHarga.setEnabled(false);
        txtTotalBayar.setEnabled(false);
        txtHarga.setEnabled(false);
        cbNamaPembeli.setEnabled(true);
        cbNamaBarang.setEnabled(true);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnNew.setEnabled(true);
        btnHitung.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBarang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbNamaPembeli = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        txtKodeBarang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbNamaBarang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHarga = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtTotalBayar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtKodeTransaksi = new javax.swing.JTextField();
        btnHitung = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        btnSave.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnSave.setText("Save");
        btnSave.setPreferredSize(new java.awt.Dimension(73, 23));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TRANSAKSI");
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

        jLabel2.setText("Nama Pembeli");

        jLabel3.setText("Username");

        cbNamaPembeli.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNamaPembeliItemStateChanged(evt);
            }
        });

        jLabel4.setText("Kode Barang");

        jLabel5.setText("Nama Barang");

        cbNamaBarang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbNamaBarangItemStateChanged(evt);
            }
        });

        jLabel6.setText("Harga Barang");

        jLabel7.setText("Qty");

        jLabel8.setText("Total Bayar");

        jLabel9.setText("Kode Transaksi");

        btnHitung.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        btnHitung.setText("Hitung");
        btnHitung.setPreferredSize(new java.awt.Dimension(73, 23));
        btnHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(5, 5, 5)))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbNamaPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(74, 74, 74)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel8))
                                                .addGap(32, 32, 32)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtTotalBayar)
                                                    .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtKodeTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbNamaPembeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(txtKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String id_transaksi = txtKodeTransaksi.getText();
        String username = txtUsername.getText();
        String id_barang = txtKodeBarang.getText();
        String qty = txtQty.getText();
        String total = txtTotalBayar.getText();
        if ((id_transaksi.isEmpty()) | (username.isEmpty()) | (id_barang.isEmpty()) | (qty.isEmpty()) | (total.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, " +
                "silahkan dilengkapi");
            txtKodeTransaksi.requestFocus();
        }else {
            try {
                String sql = "UPDATE transaksi SET "
                + "username = '" + username + "',"
                + "id_barang = '" + id_barang + "',"
                + "qty = '" + qty + "',"
                + "total = '" + total + "'WHERE "
                + "id_transaksi = '" + id_transaksi + "'";
                config.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, "Transaksi dengan kode "+ id_transaksi +" Berhasil Diperbarui");
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
        String id_transaksi = txtKodeTransaksi.getText();
        int app;
        if ((app = JOptionPane.showConfirmDialog(null, "Anda yakin akan menghapus data "
            + id_transaksi+ " ?", "Perhatian", JOptionPane.YES_NO_OPTION)) == 0){
            try {
                String sql = "DELETE FROM transaksi WHERE"
                + " id_transaksi = '" + id_transaksi+ "'";
                config.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, "Transaksi dengan kode "+ id_transaksi +" Berhasil Dihapus");
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
        autoKodeTransaksi();
        SetEditOn();
        txtQty.requestFocus();
        txtKodeTransaksi.setEnabled(false);
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnNew.setEnabled(false);
        btnCancel.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String id_transaksi = txtKodeTransaksi.getText();
        String username = txtUsername.getText();
        String id_barang = txtKodeBarang.getText();
        String qty = txtQty.getText();
        String total = txtTotalBayar.getText();
        if ((id_transaksi.isEmpty()) | (username.isEmpty()) | (id_barang.isEmpty()) | (qty.isEmpty()) | (total.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, " +
                "silahkan dilengkapi");
            txtKodeTransaksi.requestFocus();
        }else {
            try {
                String sql = "INSERT INTO transaksi (id_transaksi, username, id_barang, qty, total) "
                + "VALUES ("
                + "'" + id_transaksi + "',"
                + "'" + username+ "',"
                + "'" + id_barang+ "',"
                + "'" + qty+ "',"
                + "'" + total + "'"
                + ")";
                config.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, "Transaksi dengan kode "+ id_transaksi +" Berhasil Dibuat.");
                clearText();
                SetEditOff();
                btnNew.setEnabled(true);
            }catch(Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tableBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBarangMouseClicked
        if(evt.getClickCount()==1){
            TampilText();
        }
        btnCancel.setEnabled(true);
        btnNew.setEnabled(false);
        txtKodeTransaksi.setEnabled(false);
    }//GEN-LAST:event_tableBarangMouseClicked

    private void cbNamaPembeliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNamaPembeliItemStateChanged
        try{
            String SQL = "SELECT * FROM pengguna WHERE nama_pengguna='"+
                    cbNamaPembeli.getSelectedItem().toString()+"'";
            ResultSet rs = config.getData(SQL);
            while(rs.next()){
                txtUsername.setText(rs.getString(2));
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_cbNamaPembeliItemStateChanged

    private void cbNamaBarangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbNamaBarangItemStateChanged
        try{
            String SQL = "SELECT * FROM barang WHERE nama_Barang='"+
                    cbNamaBarang.getSelectedItem().toString()+"'";
            ResultSet rs = config.getData(SQL);
            while(rs.next()){
                txtKodeBarang.setText(rs.getString(1));
                txtHarga.setText(rs.getString(3));
            }
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_cbNamaBarangItemStateChanged

    private void btnHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitungActionPerformed
        int harga = Integer.parseInt(txtHarga.getText());
        int qty = Integer.parseInt(txtQty.getText());
        String total = String.valueOf(harga*qty);
        txtTotalBayar.setText(total);
    }//GEN-LAST:event_btnHitungActionPerformed

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
            java.util.logging.Logger.getLogger(ManageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHitung;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbNamaBarang;
    private javax.swing.JComboBox<String> cbNamaPembeli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableBarang;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtKodeBarang;
    private javax.swing.JTextField txtKodeTransaksi;
    private javax.swing.JTextField txtQty;
    private javax.swing.JTextField txtTotalBayar;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
