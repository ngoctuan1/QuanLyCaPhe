/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author loith
 */

public class PN_CTPN_Frame extends javax.swing.JFrame {
    DefaultTableModel modelPhieuNhap = new DefaultTableModel() ;
    DefaultTableModel modelChiTietPN;
    DefaultTableModel modelTimKiem;
    DefaultTableModel modelTimKiem2;
    ArrayList<PhieuNhapDTO> dspn;
    ArrayList<ChiTietPNDTO> dsctpn;
    String SelectedItem = "Phiếu Nhập";
    String[] MucTimKiemPN = {"Mã PN", "Mã NV", "Mã NCC", "Tổng Tiền", "Ngày Nhập"};
    String[] MucTimKiemChiTietPN ={"Mã PN", "Mã SP", "Số lượng", "Đơn giá"};
    /**
     * Creates new form HD_CTHD_Frame
     */
    public PN_CTPN_Frame() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   
        docPhieuNhap();
        docChiTietPhieuNhap(); 
        //initChiTietPNTBL();
        comboBoxTBLCanTim.addItemListener(itemListener);
        tblScrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
        tblScrollPane1.getVerticalScrollBar().setUI(new MyScrollBarUI());
        comboBoxMucTimKiem = myComboBox(comboBoxMucTimKiem, new Color(14,142,233));
        comboBoxTBLCanTim = myComboBox(comboBoxTBLCanTim, new Color(14,142,233));
    }
    
    public void setComboBoxMucTimKiem(String arr[]) throws  Exception{
        comboBoxMucTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(arr));
    }
    

    
    public JComboBox myComboBox(JComboBox box, Color color)
    {   
        box.setRenderer(new MyComboBoxRenderer());
        box.setEditor(new MyComboBoxEditor());
        
        box.setUI(new BasicComboBoxUI() 
        {
            @Override
            protected ComboPopup createPopup() 
            {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new MatteBorder(4,4,4,4,color));
                return basicComboPopup;
            }
            
            @Override 
            protected JButton createArrowButton() 
            {
                Color matteGrey = new Color(223,230,233);
                Color flatBlue = new Color(14,142,233);
        
                BasicArrowButton custom = new BasicArrowButton(
                BasicArrowButton.SOUTH, null, null, Color.WHITE, null);
                custom.setBorder(new MatteBorder(0,0,0,0,flatBlue));
                return custom;
            }
        }); 

       return box;
    }
    
    public void docPhieuNhap()
    {   
       
        PhieuNhapBUS bus = new PhieuNhapBUS();
        try {
            bus.docDSPN();
        } catch (Exception ex) {
            Logger.getLogger(PN_CTPN_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dspn = PhieuNhapBUS.getDspn();
         
        
        String[] columnNames = {"Mã phiếu nhập","Mã nhân viên","Mã nhà cung cấp","Tổng tiền","Ngày nhập"};
        Vector header = createHeader(columnNames);

       
        modelPhieuNhap = new DefaultTableModel(header, 0);
        

        for (PhieuNhapDTO pn : dspn) {
            
            Vector row = new Vector();
            row.add(pn.getMaPN());
            row.add(pn.getMaNV());
            row.add(pn.getMaNCC());
            row.add(pn.getTongTien());
            row.add(pn.ngayNhap);
            
            modelPhieuNhap.addRow(row);
        }

        tblPhieuNhap.setModel(modelPhieuNhap);
        tblPhieuNhap = initHeaderColor(tblPhieuNhap, 14, 142, 233);
        
        
    }
    
    public void docChiTietPhieuNhap(String maPN)
    {  
        ChiTietPNBUS bus = new ChiTietPNBUS();
        try {
           bus.docCTPN(maPN);
        } catch (Exception ex) {
            Logger.getLogger(PN_CTPN_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dsctpn = ChiTietPNBUS.getDsctpn();
        
        String[] columnNames = {"Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá"};
        Vector header = createHeader(columnNames);

        
        modelChiTietPN = new DefaultTableModel(header, 0);
        
        
        for (ChiTietPNDTO ctpn : dsctpn) {
           Vector row = new Vector();
            row.add(ctpn.getMaPN());
            row.add(ctpn.getMaSP());
            row.add(ctpn.getSoLuong());
            row.add(ctpn.getDonGia());
    
            modelChiTietPN.addRow(row);
        }

        tblChiTietPN.setModel(modelChiTietPN);
        tblChiTietPN = initHeaderColor(tblChiTietPN, 14, 142, 233);
    }
    
    public void docChiTietPhieuNhap()
    {  
        ChiTietPNBUS bus = new ChiTietPNBUS();
        try {
           bus.docDSCTPN();
        } catch (Exception ex) {
            Logger.getLogger(PN_CTPN_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dsctpn = ChiTietPNBUS.getDsctpn();
        
        String[] columnNames = {"Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá"};
        Vector header = createHeader(columnNames);

       
        modelChiTietPN = new DefaultTableModel(header, 0);
        
        
        for (ChiTietPNDTO ctpn : dsctpn) {
           Vector row = new Vector();
            row.add(ctpn.getMaPN());
            row.add(ctpn.getMaSP());
            row.add(ctpn.getSoLuong());
            row.add(ctpn.getDonGia());
    
            modelChiTietPN.addRow(row);
        }

        tblChiTietPN.setModel(modelChiTietPN);
        tblChiTietPN = initHeaderColor(tblChiTietPN, 14, 142, 233);
    }
    
     
    
    public Vector createHeader(Object[] columnNames) {
        Vector header = new Vector();
        for (Object colName : columnNames) {
            header.add(colName);
        }

        return header;
    }
    
    public JTable initHeaderColor(JTable List,int r,int b, int g)
    {
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(r, b, g));
        headerRenderer.setForeground(Color.WHITE);
        
            for (int i = 0; i < List.getModel().getColumnCount(); i++) 
            {
                List.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }
        
        return List;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        comboBoxMucTimKiem = new javax.swing.JComboBox<>();
        comboBoxTBLCanTim = new javax.swing.JComboBox<>();
        tblScrollPane = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        tblScrollPane1 = new javax.swing.JScrollPane();
        tblChiTietPN = new javax.swing.JTable();
        btnHienThiTatCa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 142, 233));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Phiếu Nhập - Chi Tiết Phiếu Nhập");

        txtTimKiem.setBackground(new java.awt.Color(223, 230, 233));
        txtTimKiem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTimKiem.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));

        btnTimKiem.setBackground(new java.awt.Color(14, 142, 233));
        btnTimKiem.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_icon.png"))); // NOI18N
        btnTimKiem.setBorder(null);
        btnTimKiem.setContentAreaFilled(false);
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.setOpaque(true);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        comboBoxMucTimKiem.setBackground(new java.awt.Color(14, 142, 233));
        comboBoxMucTimKiem.setEditable(true);
        comboBoxMucTimKiem.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        comboBoxMucTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxMucTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã PN", "Mã NV", "Mã NCC", "Tổng Tiền", "Ngày Nhập" }));
        comboBoxMucTimKiem.setToolTipText("null");
        comboBoxMucTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxMucTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMucTimKiemActionPerformed(evt);
            }
        });

        comboBoxTBLCanTim.setBackground(new java.awt.Color(14, 142, 233));
        comboBoxTBLCanTim.setEditable(true);
        comboBoxTBLCanTim.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        comboBoxTBLCanTim.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxTBLCanTim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phiếu Nhập", "Chi Tiết Phiếu Nhập" }));
        comboBoxTBLCanTim.setToolTipText("null");
        comboBoxTBLCanTim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxTBLCanTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxTBLCanTimActionPerformed(evt);
            }
        });

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        tblScrollPane.setViewportView(tblPhieuNhap);

        tblChiTietPN.setModel(new javax.swing.table.DefaultTableModel(
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
        tblScrollPane1.setViewportView(tblChiTietPN);

        btnHienThiTatCa.setBackground(new java.awt.Color(14, 142, 233));
        btnHienThiTatCa.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHienThiTatCa.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiTatCa.setText("Hiển thị tất cả");
        btnHienThiTatCa.setBorder(null);
        btnHienThiTatCa.setContentAreaFilled(false);
        btnHienThiTatCa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHienThiTatCa.setOpaque(true);
        btnHienThiTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tblScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(txtTimKiem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(comboBoxTBLCanTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(29, 29, 29))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(19, 19, 19)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxTBLCanTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tblScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    ItemListener itemListener = new ItemListener() {
      public void itemStateChanged(ItemEvent itemEvent) {
        int state = itemEvent.getStateChange();
        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
        System.out.println("Item: " + itemEvent.getItem());
        SelectedItem =  itemEvent.getItem().toString();
        
        if (SelectedItem.equals("Phiếu Nhập"))
            try {
                setComboBoxMucTimKiem(MucTimKiemPN);
            } catch (Exception ex) {
            Logger.getLogger(PN_CTPN_Frame.class.getName()).log(Level.SEVERE, null, ex);
            } 
        else 
        {
            try {
                setComboBoxMucTimKiem(MucTimKiemChiTietPN);
            } catch (Exception ex) {
                Logger.getLogger(PN_CTPN_Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
      }

        

       
        
    };
    
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String mucTimKiem = comboBoxMucTimKiem.getSelectedItem().toString();
        String duLieu = txtTimKiem.getText();
        
        if (SelectedItem.equals("Phiếu Nhập"))
         {   
             
             String[] columnNames = {"Mã phiếu nhập","Mã nhân viên","Mã nhà cung cấp","Tổng tiền","Ngày nhập"};
             Vector header = createHeader(columnNames);

            if (duLieu.equals("") == false) {
                ArrayList<PhieuNhapDTO> tempArr = new ArrayList<PhieuNhapDTO>();
                PhieuNhapBUS bus = new PhieuNhapBUS();

                tempArr = bus.timKiem(mucTimKiem, duLieu);

                if (tempArr.size() > 0) {
                    modelTimKiem = new DefaultTableModel();

                    if (modelTimKiem.getRowCount() == 0) {
                        modelTimKiem = new DefaultTableModel(header, 0);
                    }

                    for (PhieuNhapDTO pn : tempArr) {
                         Vector row = new Vector();
                         row.add(pn.getMaPN());
                         row.add(pn.getMaNV());
                         row.add(pn.getMaNCC());
                         row.add(pn.getTongTien());
                         row.add(pn.ngayNhap);
                      
                         modelTimKiem.addRow(row);
                    }
                    tblPhieuNhap.setModel(modelTimKiem);
                    tblPhieuNhap = initHeaderColor(tblPhieuNhap, 14, 142, 233);

                } else {
                    JOptionPane.showMessageDialog(this, "Rất tiếc. Dữ liệu không được tìm thấy!");
                }
            }
         }
         else
         {
             String[] columnNames = {"Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Đơn giá"};
             Vector header = createHeader(columnNames);

            if (duLieu.equals("") == false) {
                ArrayList<ChiTietPNDTO> tempArr = new ArrayList<ChiTietPNDTO>();
                ChiTietPNBUS bus = new ChiTietPNBUS();

                tempArr = bus.timKiem(mucTimKiem, duLieu);

                if (tempArr.size() > 0) {
                    modelTimKiem = new DefaultTableModel();

                    if (modelTimKiem.getRowCount() == 0) {
                        modelTimKiem = new DefaultTableModel(header, 0);
                    }

                 for (ChiTietPNDTO ctpn : tempArr) {
                     Vector row = new Vector();
                     row.add(ctpn.getMaPN());
                     row.add(ctpn.getMaSP());
                     row.add(ctpn.getSoLuong());
                     row.add(ctpn.getDonGia());

                     modelTimKiem.addRow(row);
                 }
                    tblChiTietPN.setModel(modelTimKiem);
                    tblChiTietPN = initHeaderColor(tblChiTietPN, 14, 142, 233);
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Rất tiếc. Dữ liệu không được tìm thấy!");
                }
            }
         }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void comboBoxMucTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMucTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMucTimKiemActionPerformed

    private void comboBoxTBLCanTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxTBLCanTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxTBLCanTimActionPerformed

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        int i = tblPhieuNhap.getSelectedRow();     
        docChiTietPhieuNhap(tblPhieuNhap.getValueAt(i,0).toString());
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void btnHienThiTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiTatCaActionPerformed
        docPhieuNhap();
        docChiTietPhieuNhap();
    }//GEN-LAST:event_btnHienThiTatCaActionPerformed

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
            java.util.logging.Logger.getLogger(PN_CTPN_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PN_CTPN_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PN_CTPN_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PN_CTPN_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PN_CTPN_Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThiTatCa;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> comboBoxMucTimKiem;
    private javax.swing.JComboBox<String> comboBoxTBLCanTim;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable tblChiTietPN;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JScrollPane tblScrollPane1;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
