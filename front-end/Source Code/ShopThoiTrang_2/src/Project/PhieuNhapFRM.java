/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import com.itextpdf.text.DocumentException;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LLOST
 */
public class PhieuNhapFRM extends javax.swing.JPanel {

    /**
     * Creates new form PhieuNhapFRM
     */
    Color flatBlue = new Color(14,142,233);
    Color matteGrey = new Color(223,230,233);
    
    ChiTietPNFrame ctpn;
    ShopForm shop;
   
    
    public PhieuNhapFRM(ShopForm shop) throws Exception {
        initComponents();
        this.shop = shop;
        tblScrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());   
        tblPhieuNhap = initHeaderColor(tblPhieuNhap,14,142,233);
        comboBoxMucTimKiem = myComboBox(comboBoxMucTimKiem,flatBlue);
        tblPhieuNhap = initHeaderColor(tblPhieuNhap,14,142,233); 
        DCNgayNhap = myDateChooser(DCNgayNhap);
        txtTongTien.setText("0");
        docDataBase();
        docComboBox();
        autoGenerateID(txtMaPN);
    }

    public JDateChooser myDateChooser(JDateChooser chooser)
    {   
        JTextFieldDateEditor dateChooserEditor = ((JTextFieldDateEditor)chooser.getDateEditor());
        dateChooserEditor.setBackground(matteGrey);
        dateChooserEditor.setBorder(new MatteBorder(3,3,3,3,matteGrey));
        dateChooserEditor.setEditable(false);
        return chooser;
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
                Color flatBlue = new Color(14,142,233);
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
    
    public void resetMoney(String maPN) throws Exception
    {
        PhieuNhapBUS bus = new PhieuNhapBUS();
        PhieuNhapDTO old = bus.timPN(maPN);
        PhieuNhapDTO pn = old;
        
        ChiTietPNBUS ctpnBus = new ChiTietPNBUS();
        pn.setTongTien(ctpnBus.tinhTongTien(maPN));
        bus.sua(pn, old);
        refreshTableRowMoney(maPN);
    }
    
    public void refreshTableRowMoney(String maPN)
    {
        PhieuNhapBUS bus = new PhieuNhapBUS();
        int i = -1;
        if(flag == true)
        {
            i = bus.timIndex(maPN);
            model.setValueAt(bus.getDspn().get(i).getTongTien(), i, 4);
        }
        else
        {
            for(int j = 0; j < modelTimKiem.getRowCount(); ++j)
            {
                if(modelTimKiem.getValueAt(j, 0).equals(maPN))
                    i = j;
            }
            modelTimKiem.setValueAt(bus.getDspn().get(i).getTongTien(), i, 4);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightClickMenu = new javax.swing.JPopupMenu();
        xuatExcelFile = new javax.swing.JMenuItem();
        nhapExcelFile = new javax.swing.JMenuItem();
        reportPDF = new javax.swing.JMenuItem();
        pnlTable = new javax.swing.JPanel();
        tblScrollPane = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        pnlMain = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        lblMaPN = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblMaNCC = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        pnlChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnHienThiTatCa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnHienThiTatCaChiTiet = new javax.swing.JButton();
        btnHienThiChiTiet = new javax.swing.JButton();
        comboBoxMucTimKiem = new javax.swing.JComboBox<>();
        lblNgayNhap = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JTextField();
        DCNgayNhap = new com.toedter.calendar.JDateChooser();
        comboBoxMaNV = new javax.swing.JComboBox<>();
        comboBoxMaNCC = new javax.swing.JComboBox<>();
        btnShow = new javax.swing.JButton();

        xuatExcelFile.setText("Export to excel file");
        xuatExcelFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatExcelFileActionPerformed(evt);
            }
        });
        rightClickMenu.add(xuatExcelFile);

        nhapExcelFile.setText("Import Excel File\n");
        nhapExcelFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapExcelFileActionPerformed(evt);
            }
        });
        rightClickMenu.add(nhapExcelFile);

        reportPDF.setText("Report");
        reportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportPDFActionPerformed(evt);
            }
        });
        rightClickMenu.add(reportPDF);

        setPreferredSize(new java.awt.Dimension(683, 535));

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseReleased(evt);
            }
        });
        tblScrollPane.setViewportView(tblPhieuNhap);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
        );

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setForeground(new java.awt.Color(14, 142, 233));
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMainMouseClicked(evt);
            }
        });

        lblTieuDe.setBackground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(14, 142, 233));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("PHIẾU NHẬP");

        lblMaPN.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMaPN.setForeground(new java.awt.Color(14, 142, 233));
        lblMaPN.setText("Mã phiếu nhập:");

        lblMaNV.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMaNV.setForeground(new java.awt.Color(14, 142, 233));
        lblMaNV.setText("Mã nhân viên:");

        lblMaNCC.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMaNCC.setForeground(new java.awt.Color(14, 142, 233));
        lblMaNCC.setText("Mã nhà cung cấp:");

        lblTongTien.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(14, 142, 233));
        lblTongTien.setText("Tổng tiền:");

        txtTongTien.setBackground(new java.awt.Color(223, 230, 233));
        txtTongTien.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTongTien.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));

        pnlChucNang.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setBackground(new java.awt.Color(14, 142, 233));
        btnThem.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/plus_icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(null);
        btnThem.setContentAreaFilled(false);
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.setIconTextGap(15);
        btnThem.setOpaque(true);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(14, 142, 233));
        btnXoa.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash_icon.png"))); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setBorder(null);
        btnXoa.setContentAreaFilled(false);
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.setIconTextGap(15);
        btnXoa.setOpaque(true);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(14, 142, 233));
        btnSua.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pencil_icon.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setBorder(null);
        btnSua.setContentAreaFilled(false);
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.setIconTextGap(15);
        btnSua.setOpaque(true);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlChucNangLayout = new javax.swing.GroupLayout(pnlChucNang);
        pnlChucNang.setLayout(pnlChucNangLayout);
        pnlChucNangLayout.setHorizontalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

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

        btnHienThiTatCaChiTiet.setBackground(new java.awt.Color(14, 142, 233));
        btnHienThiTatCaChiTiet.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHienThiTatCaChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiTatCaChiTiet.setText("Hiển thị tất cả chi tiết");
        btnHienThiTatCaChiTiet.setBorder(null);
        btnHienThiTatCaChiTiet.setContentAreaFilled(false);
        btnHienThiTatCaChiTiet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHienThiTatCaChiTiet.setOpaque(true);
        btnHienThiTatCaChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiTatCaChiTietActionPerformed(evt);
            }
        });

        btnHienThiChiTiet.setBackground(new java.awt.Color(14, 142, 233));
        btnHienThiChiTiet.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnHienThiChiTiet.setForeground(new java.awt.Color(255, 255, 255));
        btnHienThiChiTiet.setText("Hiển thị chi tiết");
        btnHienThiChiTiet.setBorder(null);
        btnHienThiChiTiet.setContentAreaFilled(false);
        btnHienThiChiTiet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHienThiChiTiet.setOpaque(true);
        btnHienThiChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiChiTietActionPerformed(evt);
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

        lblNgayNhap.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNgayNhap.setForeground(new java.awt.Color(14, 142, 233));
        lblNgayNhap.setText("Ngày nhập:");

        txtMaPN.setBackground(new java.awt.Color(223, 230, 233));
        txtMaPN.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtMaPN.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));

        comboBoxMaNV.setBackground(new java.awt.Color(223, 230, 233));
        comboBoxMaNV.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboBoxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboBoxMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMaNVActionPerformed(evt);
            }
        });

        comboBoxMaNCC.setBackground(new java.awt.Color(223, 230, 233));
        comboBoxMaNCC.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboBoxMaNCC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboBoxMaNCC.setPreferredSize(new java.awt.Dimension(53, 22));

        btnShow.setBackground(new java.awt.Color(14, 142, 233));
        btnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eye_icon_white.png"))); // NOI18N
        btnShow.setBorder(null);
        btnShow.setContentAreaFilled(false);
        btnShow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnShow.setOpaque(true);
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblMaPN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblMaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaPN, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(comboBoxMaNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxMaNCC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnHienThiTatCaChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                            .addComponent(btnHienThiChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayNhap))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DCNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtTongTien))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(lblMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DCNgayNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(btnHienThiTatCaChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnShow, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHienThiChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    DefaultTableModel model = new DefaultTableModel() ;
    DefaultTableModel modelTimKiem;

    boolean flag = true;

    public Vector createHeader(Object[] columnNames) {
        Vector header = new Vector();
        for (Object colName : columnNames) {
            header.add(colName);
        }

        return header;
    }
    
    public void docComboBox() throws  Exception{
        NhanVienBUS busNV= new  NhanVienBUS();
        NhaCungCapBUS busNCC= new  NhaCungCapBUS();
        
        String [] arrayMaNV = busNV.docComboBoxMaNV();
        comboBoxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(arrayMaNV));
        comboBoxMaNV = myComboBox(comboBoxMaNV,matteGrey);


        String [] arrayMaNCC = busNCC.docComboBoxMaNCC();   
        comboBoxMaNCC.setModel(new javax.swing.DefaultComboBoxModel<>(arrayMaNCC));
        comboBoxMaNCC = myComboBox(comboBoxMaNCC,matteGrey);
    }
        
      public void docComboBoxNV(String ma[]) throws  Exception{
        comboBoxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(ma));
    }
 
        public void docComboBoxNCC(String ma[]) throws  Exception{
        comboBoxMaNCC.setModel(new javax.swing.DefaultComboBoxModel<>(ma)); 
    }
        
    public void docDataBase() throws  Exception{
        PhieuNhapBUS bus= new PhieuNhapBUS();
        if(PhieuNhapBUS.getDspn() == null){
            bus.docDSPN();
        }
        
        String[] columnNames= {"Mã phiếu nhập","Mã nhân viên","Mã nhà cung cấp","Ngày nhập","Tổng tiền"};
        Vector header = createHeader(columnNames);
        
        if(model.getRowCount() == 0){
            model = new DefaultTableModel(header,0);
        }
        
        for(PhieuNhapDTO pn : PhieuNhapBUS.getDspn()){
            Vector row = new Vector();
            row.add(pn.getMaPN());
            row.add(pn.getMaNV());
            row.add(pn.getMaNCC());
            row.add(pn.ngayNhap);
            row.add(pn.getTongTien());
            
            model.addRow(row);
        }
        
        tblPhieuNhap.setModel(model);
        tblPhieuNhap= initHeaderColor(tblPhieuNhap, 14, 142, 233);
        
    }
    
        void autoGenerateID(JTextField txt) throws Exception
    {
        PhieuNhapBUS bus = new PhieuNhapBUS();
        String ID = bus.taoIdTuDong();
        txt.setText(ID);
    }
    
    public void resetTxt() throws Exception{
        autoGenerateID(txtMaPN);
        DCNgayNhap.setDate(null);
        txtTongTien.setText("0");
    }
    
    public boolean checkEmptyTxt(){
        if(txtMaPN.getText().equals("") || DCNgayNhap.getDate() == null){
            return true;
        }
        return false;
    }
    
    public void hienCacNutChucNang(){
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }
    
    public void anCacNutChucNang(){
        btnThem.setEnabled(false);
        btnXoa.setEnabled(false);
        btnSua.setEnabled(false);
    }
    
    private void comboBoxMucTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMucTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMucTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(checkEmptyTxt() == true)
            return;
        else{
            PhieuNhapBUS bus = new PhieuNhapBUS();
            
            if(bus.kiemTraTrung(txtMaPN.getText())){
                JOptionPane.showMessageDialog(this, "Mã phiếu nhập đã tồn tại. Mời nhập Mã phiếu nhập khác!");
                return;
            }
            
            PhieuNhapDTO pn = new PhieuNhapDTO();
            Date date = DCNgayNhap.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = df.format(date);
            pn.setNgayNhap(strDate);
            pn.setMaPN(txtMaPN.getText());
            pn.setMaNV(comboBoxMaNV.getSelectedItem().toString());
            pn.setMaNCC(comboBoxMaNCC.getSelectedItem().toString());
            pn.setTongTien(Float.parseFloat(txtTongTien.getText()));
            
            try{
                bus.them(pn);
            }
            catch (Exception ex){
                Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
            String[] columnNames = {"Mã phiếu nhập","Mã nhân viên","Mã nhà cung cấp","Ngày nhập","Tổng tiền"};
            Vector header = createHeader(columnNames);

            if (model.getRowCount() == 0) {
                model = new DefaultTableModel(header, 0);
            }

            Vector row = new Vector();
            row.add(pn.getMaPN());
            row.add(pn.getMaNV());
            row.add(pn.getMaNCC());
            row.add(pn.getNgayNhap());
            row.add(pn.getTongTien());

            model.addRow(row);
            tblPhieuNhap.setModel(model);
            
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            try {
                resetTxt();
            } catch (Exception ex) {
                Logger.getLogger(NhanVienFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int i= tblPhieuNhap.getSelectedRow();
        if(i>=0){
            int selection = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa dòng này?","Thông báo xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(selection == JOptionPane.YES_OPTION){
                PhieuNhapBUS bus = new PhieuNhapBUS();
                if(flag == true){
                    String maPN = model.getValueAt(i, 0).toString();
                    try{
                        bus.xoa(maPN);
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Bạn không thể xóa dòng này");
                        return;
                    }
                    
                    model.removeRow(i);
                    tblPhieuNhap.setModel(model);
                }
                else{
                    String maPN= modelTimKiem.getValueAt(i, 0).toString();
                    try{
                        bus.xoa(maPN);
                    }
                    catch (Exception ex){
                        JOptionPane.showMessageDialog(this, "Bạn không thể xóa dòng này");
                        return;
                    }
                    int index= bus.timIndex(maPN);
                    modelTimKiem.removeRow(i);
                    tblPhieuNhap.setModel(modelTimKiem);
                    model.removeRow(index);
                }
                btnSua.setEnabled(false);
                btnXoa.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                try{
                    resetTxt();
                }
                catch (Exception ex){
                    Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
                        int temp = -1;
        int i = tblPhieuNhap.getSelectedRow();
        if(i>=0){
            PhieuNhapBUS bus = new PhieuNhapBUS();
            String maPNCu;
            if(flag == true){
                maPNCu = model.getValueAt(i, 0).toString();
            }
            else{
                temp=i;
                maPNCu = modelTimKiem.getValueAt(temp, 0).toString();
                i = bus.timIndex(maPNCu);
            }
            
            if(bus.kiemTraTrung(txtMaPN.getText(), maPNCu)){
                JOptionPane.showMessageDialog(this, "Mã phiếu nhập đã tồn tại. Mời nhập Mã phiếu nhập khác!");
                return;
            }
            else{
                PhieuNhapDTO pn = new PhieuNhapDTO();
                Date date = DCNgayNhap.getDate();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = df.format(date);
                pn.setNgayNhap(strDate);
                pn.setMaPN(txtMaPN.getText());
                pn.setMaNV(comboBoxMaNV.getSelectedItem().toString());
                pn.setMaNCC(comboBoxMaNCC.getSelectedItem().toString());
                pn.setTongTien(Float.parseFloat(txtTongTien.getText()));
                
                PhieuNhapDTO old = PhieuNhapBUS.getDspn().get(i);
                
                try{
                    bus.sua(pn, old);
                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(this, "Bạn không thể thay đổi Mã phiếu nhập này");
                    return;
                }
                
                model.setValueAt(pn.getMaPN(), i, 0);
                model.setValueAt(pn.getMaNV(), i, 1);
                model.setValueAt(pn.getMaNCC(), i, 2);
                model.setValueAt(pn.getNgayNhap(), i, 3);
                model.setValueAt(pn.getTongTien(), i, 4);
                
                if(flag == false){
                    modelTimKiem.setValueAt(pn.getMaNV(), temp, 0);
                    modelTimKiem.setValueAt(pn.getMaNV(), temp, 1);
                    modelTimKiem.setValueAt(pn.getMaNCC(), temp, 2);
                    modelTimKiem.setValueAt(pn.getNgayNhap(), temp, 3);
                    modelTimKiem.setValueAt(pn.getTongTien(), temp, 4);
                }
                
                hienCacNutChucNang();
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                try{
                    resetTxt();
                }
                catch (Exception ex){
                    Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnHienThiTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiTatCaActionPerformed
        // TODO add your handling code here:
        flag = true;
        tblPhieuNhap.setModel(model);
        btnThem.setEnabled(true);
        tblPhieuNhap = initHeaderColor(tblPhieuNhap, 14, 142, 233);
    }//GEN-LAST:event_btnHienThiTatCaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String mucTimKiem = comboBoxMucTimKiem.getSelectedItem().toString();
        String duLieu = txtTimKiem.getText();
        
        String[] columnNames = {"Mã phiếu nhập","Mã nhân viên","Mã nhà cung cấp","Ngày nhập","Tổng tiền"};
        Vector header = createHeader(columnNames);
        
        if(duLieu.equals("") == false){
            ArrayList<PhieuNhapDTO> tempArr = new ArrayList<PhieuNhapDTO>();
            PhieuNhapBUS bus = new PhieuNhapBUS();
            
            tempArr = bus.timKiem(mucTimKiem, duLieu);
            
            if(tempArr.size()>0){
                modelTimKiem = new DefaultTableModel();
                
                if(modelTimKiem.getRowCount() == 0){
                    modelTimKiem = new DefaultTableModel(header,0);
                }
                
                for(PhieuNhapDTO pn : tempArr ){
                    Vector row = new Vector();
                    row.add(pn.getMaPN());
                    row.add(pn.getMaNV());
                    row.add(pn.getMaNCC());
                    row.add(pn.getNgayNhap());
                    row.add(pn.getTongTien());
                    
                    modelTimKiem.addRow(row);
                }
                tblPhieuNhap.setModel(modelTimKiem);
                tblPhieuNhap = initHeaderColor(tblPhieuNhap, 14, 142, 233);
                
                flag= false;
                anCacNutChucNang();
            }
            else{
                JOptionPane.showMessageDialog(this, "Rất tiếc. Dữ liệu không được tìm thấy!");
            }
        }
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void pnlMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseClicked
        // TODO add your handling code here:
        try{
            resetTxt();
        }
        catch (Exception ex){
            Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblPhieuNhap.clearSelection();
    }//GEN-LAST:event_pnlMainMouseClicked

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
        // TODO add your handling code here:
        int i = tblPhieuNhap.getSelectedRow();
        if(i >= 0){
            PhieuNhapBUS bus = new PhieuNhapBUS();
            PhieuNhapDTO pn = new PhieuNhapDTO();
            
            if(flag == true){
                pn = PhieuNhapBUS.getDspn().get(i);
            }
            else{
                int index = bus.timIndex(modelTimKiem.getValueAt(i, 0).toString());
                pn = PhieuNhapBUS.getDspn().get(index);
            }
            
            txtMaPN.setText(pn.getMaPN());
            comboBoxMaNV.setSelectedItem(pn.getMaNV());
            comboBoxMaNCC.setSelectedItem(pn.getMaNCC());
            String ngay = pn.getNgayNhap();
            txtTongTien.setText(Float.toString(pn.getTongTien()));
            
            try {
                Date Ngay = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
                DCNgayNhap.setDate(Ngay);
            } catch (ParseException ex) {
                Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            btnSua.setEnabled(true);
            btnXoa.setEnabled(true);
        }
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void btnHienThiChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiChiTietActionPerformed
        // TODO add your handling code here:
        int i = tblPhieuNhap.getSelectedRow();     
        if (i >= 0) 
        {              
            try {
            ctpn = new ChiTietPNFrame(shop, model.getValueAt(i, 0).toString());
            ctpn.setVisible(true);
            ctpn.setDefaultCloseOperation(ctpn.HIDE_ON_CLOSE);   
            } 
            catch (Exception ex) {
            Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_btnHienThiChiTietActionPerformed

    private void btnHienThiTatCaChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiTatCaChiTietActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            ctpn = new ChiTietPNFrame(shop, null);
            ctpn.setVisible(true);
            ctpn.setDefaultCloseOperation(ctpn.HIDE_ON_CLOSE);
           
        } catch (Exception ex) {
            Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHienThiTatCaChiTietActionPerformed

    private void comboBoxMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMaNVActionPerformed

    }//GEN-LAST:event_comboBoxMaNVActionPerformed

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        PN_CTPN_Frame show = new PN_CTPN_Frame();
        show.setVisible(true);
    }//GEN-LAST:event_btnShowActionPerformed

    private void xuatExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExcelFileActionPerformed
        String[] columnNames = {"Mã phiếu nhập","Mã nhân viên","Mã nhà cung cấp","Ngày nhập","Tổng tiền"};
        try {
            XuatExcel xuat = new XuatExcel(tblPhieuNhap, columnNames, "Phiếu Nhập");
        } catch (IOException ex) {
            Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xuatExcelFileActionPerformed

    private void tblPhieuNhapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger())
        {
            rightClickMenu.show(tblPhieuNhap, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblPhieuNhapMouseReleased

    private void nhapExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExcelFileActionPerformed
        // TODO add your handling code here:
        nhapExcel nhap = new nhapExcel(tblPhieuNhap);
        DefaultTableModel newModel = nhap.importExcel();
        if(newModel.getRowCount() > 0)
        {
            tblPhieuNhap.setModel(newModel);
            tblPhieuNhap = initHeaderColor(tblPhieuNhap, 14, 142, 233);
        }
    }//GEN-LAST:event_nhapExcelFileActionPerformed

    private void reportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportPDFActionPerformed
        String[] columnNames = {"Mã phiếu nhập","Mã nhân viên","Mã nhà cung cấp","Ngày nhập","Tổng tiền"};
        try {
            // TODO add your handling code here:
            ReportPDF report = new ReportPDF();
            report.reportAll(tblPhieuNhap, columnNames);
        } catch (DocumentException ex) {
            Logger.getLogger(PhieuNhapFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reportPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCNgayNhap;
    private javax.swing.JButton btnHienThiChiTiet;
    private javax.swing.JButton btnHienThiTatCa;
    private javax.swing.JButton btnHienThiTatCaChiTiet;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> comboBoxMaNCC;
    private javax.swing.JComboBox<String> comboBoxMaNV;
    private javax.swing.JComboBox<String> comboBoxMucTimKiem;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMaPN;
    private javax.swing.JLabel lblNgayNhap;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JMenuItem nhapExcelFile;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JMenuItem reportPDF;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JMenuItem xuatExcelFile;
    // End of variables declaration//GEN-END:variables
}
