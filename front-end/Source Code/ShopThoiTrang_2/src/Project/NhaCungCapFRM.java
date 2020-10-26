/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
public class NhaCungCapFRM extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonFRM
     */
    Color flatBlue = new Color(14,142,233);
    Color matteGrey = new Color(223,230,233);
    PhieuNhapFRM pn;
    public NhaCungCapFRM(PhieuNhapFRM pn) throws Exception {
        initComponents();
        tblScrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
        comboBoxMucTimKiem = myComboBox(comboBoxMucTimKiem);
        tblNhaCungCap = initHeaderColor(tblNhaCungCap,14,142,233);
        tblNhaCungCap.setDefaultEditor(Object.class, null);
        docDatabase();
        this.pn=pn;
        autoGenerateID();
    }
    
    public JDateChooser myDateChooser(JDateChooser chooser)
    {   
        JTextFieldDateEditor dateChooserEditor = ((JTextFieldDateEditor)chooser.getDateEditor());
        dateChooserEditor.setBackground(matteGrey);
        dateChooserEditor.setBorder(new MatteBorder(3,3,3,3,matteGrey));
        dateChooserEditor.setEditable(false);
        return chooser;
    }
     
     public JComboBox myComboBox(JComboBox box)
    {   
        box.setRenderer(new MyComboBoxRenderer());
        box.setEditor(new MyComboBoxEditor());
        
        box.setUI(new BasicComboBoxUI() 
        {
            @Override
            protected ComboPopup createPopup() 
            {
                BasicComboPopup basicComboPopup = new BasicComboPopup(comboBox);
                basicComboPopup.setBorder(new MatteBorder(4,4,4,4,flatBlue));
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
    public void docDatabase() throws Exception {
        NhaCungCapBUS bus = new NhaCungCapBUS();
        if (NhaCungCapBUS.getDsncc() == null) {
            bus.docDSNCC();
        }

        String[] columnNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"};
        Vector header = createHeader(columnNames);

        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }

        for (NhaCungCapDTO ncc : NhaCungCapBUS.getDsncc()) {
            Vector row = new Vector();
            row.add(ncc.getMaNCC());
            row.add(ncc.getTenNCC());
            row.add(ncc.getSoDT());
            row.add(ncc.getDiaChi());
            model.addRow(row);
        }

        tblNhaCungCap.setModel(model);
        tblNhaCungCap = initHeaderColor(tblNhaCungCap, 14, 142, 233);

    }
    
    public void resetTxt() throws Exception {
        autoGenerateID();
        txtMaNCC.setText("");
        txtTenNCC.setText("");
        txtSĐT.setText("");
        txtDiaChi.setText("");
    }
    
    public boolean checkEmptyTxt() {
        if (txtMaNCC.getText().equals("") || txtTenNCC.getText().equals("") || txtSĐT.getText().equals("") || txtDiaChi.getText().equals("")) {
            return true;
        }
        return false;
    }
    
    void autoGenerateID() throws Exception
    {
        NhaCungCapBUS bus = new NhaCungCapBUS();
        String ID = bus.taoIdTuDong();
        txtMaNCC.setText(ID);
    }

    public void hienCacNutChucNang() {
        btnThem.setEnabled(true);
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
    }

    public void anCacNutChucNang() {
        btnThem.setEnabled(false);
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
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
        pnlMain = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        lblMaNCC = new javax.swing.JLabel();
        lblTenNCC = new javax.swing.JLabel();
        lblSĐT = new javax.swing.JLabel();
        txtMaNCC = new javax.swing.JTextField();
        txtTenNCC = new javax.swing.JTextField();
        pnlChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnHienThiTatCa = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        comboBoxMucTimKiem = new javax.swing.JComboBox<>();
        txtDiaChi = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtSĐT = new javax.swing.JTextField();
        pnlTable = new javax.swing.JPanel();
        tblScrollPane = new javax.swing.JScrollPane();
        tblNhaCungCap = new javax.swing.JTable();

        xuatExcelFile.setText("Export to excel file");
        xuatExcelFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatExcelFileActionPerformed(evt);
            }
        });
        rightClickMenu.add(xuatExcelFile);

        nhapExcelFile.setText("Import Excel File");
        nhapExcelFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nhapExcelFileActionPerformed(evt);
            }
        });
        rightClickMenu.add(nhapExcelFile);

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
        lblTieuDe.setText("NHÀ CUNG CẤP");

        lblMaNCC.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblMaNCC.setForeground(new java.awt.Color(14, 142, 233));
        lblMaNCC.setText("Mã nhà cung cấp:");

        lblTenNCC.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblTenNCC.setForeground(new java.awt.Color(14, 142, 233));
        lblTenNCC.setText("Tên nhà cung cấp:");

        lblSĐT.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblSĐT.setForeground(new java.awt.Color(14, 142, 233));
        lblSĐT.setText("Số điện thoại:");

        txtMaNCC.setBackground(new java.awt.Color(223, 230, 233));
        txtMaNCC.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtMaNCC.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));
        txtMaNCC.setPreferredSize(new java.awt.Dimension(7, 24));

        txtTenNCC.setBackground(new java.awt.Color(223, 230, 233));
        txtTenNCC.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTenNCC.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));
        txtTenNCC.setPreferredSize(new java.awt.Dimension(7, 24));

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
        btnXoa.setEnabled(false);
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
        btnSua.setEnabled(false);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChucNangLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
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

        comboBoxMucTimKiem.setBackground(new java.awt.Color(14, 142, 233));
        comboBoxMucTimKiem.setEditable(true);
        comboBoxMucTimKiem.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        comboBoxMucTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxMucTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã NCC", "Tên NCC", "Số ĐT", "Địa chỉ" }));
        comboBoxMucTimKiem.setToolTipText("null");
        comboBoxMucTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxMucTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMucTimKiemActionPerformed(evt);
            }
        });

        txtDiaChi.setBackground(new java.awt.Color(223, 230, 233));
        txtDiaChi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));
        txtDiaChi.setPreferredSize(new java.awt.Dimension(7, 24));

        lblDiaChi.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(14, 142, 233));
        lblDiaChi.setText("Địa chỉ:");

        txtSĐT.setBackground(new java.awt.Color(223, 230, 233));
        txtSĐT.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtSĐT.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));
        txtSĐT.setPreferredSize(new java.awt.Dimension(7, 24));

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTenNCC, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(lblSĐT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMaNCC)
                    .addComponent(lblDiaChi)
                    .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSĐT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNCC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSĐT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSĐT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        tblNhaCungCap.setModel(new javax.swing.table.DefaultTableModel(
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
        tblNhaCungCap.setSelectionBackground(new java.awt.Color(14, 142, 233));
        tblNhaCungCap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblNhaCungCapMouseReleased(evt);
            }
        });
        tblScrollPane.setViewportView(tblNhaCungCap);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tblScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
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
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
            if (checkEmptyTxt() == true)
            return;
            else {
            NhaCungCapBUS bus = new NhaCungCapBUS();

            if (bus.kiemTraTrung(txtMaNCC.getText())) {
                JOptionPane.showMessageDialog(this, "Mã nhà cung cấp đã tồn tại. Mời nhập Mã nhà cung cấp khác!");
                return;
            }

            NhaCungCapDTO ncc = new NhaCungCapDTO();
            ncc.setMaNCC(txtMaNCC.getText());
            ncc.setTenNCC(txtTenNCC.getText());
            ncc.setSoDT(txtSĐT.getText());
            ncc.setDiaChi(txtDiaChi.getText());

            try {
                bus.them(ncc);
            } catch (Exception ex) {
                Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
            }

            String[] columnNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"};
            Vector header = createHeader(columnNames);

            if (model.getRowCount() == 0) {
                model = new DefaultTableModel(header, 0);
            }

            Vector row = new Vector();
            row.add(ncc.getMaNCC());
            row.add(ncc.getTenNCC());
            row.add(ncc.getSoDT());
            row.add(ncc.getDiaChi());
            
            model.addRow(row);
            tblNhaCungCap.setModel(model);
            
            String [] arrayNCC = new String[NhaCungCapBUS.getDsncc().size()];
                try {
                  arrayNCC = bus.docComboBoxMaNCC();
                } catch (Exception ex) {
                    Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            try {
                pn.docComboBoxNCC(arrayNCC);
            } catch (Exception ex) {
                Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            try {
                 resetTxt();
            } catch (Exception ex) {
                Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblNhaCungCap.getSelectedRow();
        if (i >= 0) {
            int selection = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa dòng này?", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (selection == JOptionPane.YES_OPTION) {
                NhaCungCapBUS bus = new NhaCungCapBUS();
                if (flag == true) 
                {
                    String maNCC = model.getValueAt(i, 0).toString();
                    try {
                        bus.xoa(maNCC);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Bạn không thể xóa dòng này!");
                        return;
                    }

                    model.removeRow(i);
                    tblNhaCungCap.setModel(model);
                } 
                else 
                {
                    String maNhaCungCap = modelTimKiem.getValueAt(i, 0).toString();
                    try {
                        bus.xoa(maNhaCungCap);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Bạn không thể xóa dòng này!");
                        return;
                    }

                    int index = bus.timIndex(maNhaCungCap);

                    modelTimKiem.removeRow(i);
                    tblNhaCungCap.setModel(modelTimKiem);

                    model.removeRow(index);
                }

                btnXoa.setEnabled(false);
                btnSua.setEnabled(false);
                
                    String [] arrayNCC = new String[NhaCungCapBUS.getDsncc().size()];
                try {
                  arrayNCC = bus.docComboBoxMaNCC();
                } catch (Exception ex) {
                    Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
                    try {
                        pn.docComboBoxNCC(arrayNCC);
                    } catch (Exception ex) {
                        Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                
                try {
                    resetTxt();
                } catch (Exception ex) {
                    Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int temp = -1;
        int i = tblNhaCungCap.getSelectedRow();
        if (i >= 0) {
            NhaCungCapBUS bus = new NhaCungCapBUS();
            String maNCCCu;
            if (flag == true) {
                maNCCCu = model.getValueAt(i, 0).toString();
            } else {
                temp = i;
                maNCCCu = modelTimKiem.getValueAt(temp, 0).toString();
                i = bus.timIndex(maNCCCu);
            }

            if (bus.kiemTraTrung(txtMaNCC.getText(), maNCCCu)) {
                JOptionPane.showMessageDialog(this, "Mã nhà cung cấp đã tồn tại. Mời nhập Mã nhà cung cấp khác!");
                return;
            } else {

                NhaCungCapDTO ncc = new NhaCungCapDTO();
                ncc.setMaNCC(txtMaNCC.getText());
                ncc.setTenNCC(txtTenNCC.getText());
                ncc.setSoDT(txtSĐT.getText());
                ncc.setDiaChi(txtDiaChi.getText());

                NhaCungCapDTO old = NhaCungCapBUS.getDsncc().get(i);

                try {
                    bus.sua(ncc, old);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Bạn không thể thay đổi Mã nhà cung cấp này!");
                    return;
                }

                model.setValueAt(ncc.getMaNCC(), i, 0);
                model.setValueAt(ncc.getTenNCC(), i, 1);
                model.setValueAt(ncc.getSoDT(), i, 2);
                model.setValueAt(ncc.getDiaChi(), i, 3);

                if (flag == false) {
                    modelTimKiem.setValueAt(ncc.getMaNCC(), temp, 0);
                    modelTimKiem.setValueAt(ncc.getTenNCC(), temp, 1);
                    modelTimKiem.setValueAt(ncc.getSoDT(), temp, 2);
                    modelTimKiem.setValueAt(ncc.getDiaChi(), temp, 3);
                }

                hienCacNutChucNang();
                
                String [] arrayNCC = new String[NhaCungCapBUS.getDsncc().size()];
                try {
                  arrayNCC = bus.docComboBoxMaNCC();
                } catch (Exception ex) {
                    Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    pn.docComboBoxNCC(arrayNCC);
                } catch (Exception ex) {
                    Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                
                try {
                    resetTxt();
                } catch (Exception ex) {
                    Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnHienThiTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiTatCaActionPerformed
        flag = true;
        tblNhaCungCap.setModel(model);
        btnThem.setEnabled(true);
        tblNhaCungCap = initHeaderColor(tblNhaCungCap, 14, 142, 233);
    }//GEN-LAST:event_btnHienThiTatCaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String mucTimKiem = comboBoxMucTimKiem.getSelectedItem().toString();
        String duLieu = txtTimKiem.getText();

        String[] columnNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"};
        Vector header = createHeader(columnNames);

        if (duLieu.equals("") == false) {
            ArrayList<NhaCungCapDTO> tempArr = new ArrayList<NhaCungCapDTO>();
            NhaCungCapBUS bus = new NhaCungCapBUS();

            tempArr = bus.timKiem(mucTimKiem,duLieu);

            if (tempArr.size() > 0) {
                modelTimKiem = new DefaultTableModel();

                if (modelTimKiem.getRowCount() == 0) {
                    modelTimKiem = new DefaultTableModel(header, 0);
                }

                for (NhaCungCapDTO ncc : tempArr) {
                    Vector row = new Vector();
                    row.add(ncc.getMaNCC());
                    row.add(ncc.getTenNCC());
                    row.add(ncc.getSoDT());
                    row.add(ncc.getDiaChi());

                    modelTimKiem.addRow(row);
                }
                tblNhaCungCap.setModel(modelTimKiem);
                tblNhaCungCap = initHeaderColor(tblNhaCungCap, 14, 142, 233);
                
                flag = false;
                anCacNutChucNang();
                
            } else {
                JOptionPane.showMessageDialog(this, "Rất tiếc. Dữ liệu không được tìm thấy!");
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void comboBoxMucTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxMucTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxMucTimKiemActionPerformed

    private void pnlMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseClicked
        try {
            // TODO add your handling code here:
            resetTxt();
        } catch (Exception ex) {
            Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
        tblNhaCungCap.clearSelection();
    }//GEN-LAST:event_pnlMainMouseClicked

    private void tblNhaCungCapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseClicked
            int i = tblNhaCungCap.getSelectedRow();
            if (i >= 0) {
            NhaCungCapBUS bus = new NhaCungCapBUS();
            NhaCungCapDTO ncc = new NhaCungCapDTO();
            if (flag == true) {
                ncc = NhaCungCapBUS.getDsncc().get(i);
            } else {
                int index = bus.timIndex(modelTimKiem.getValueAt(i, 0).toString());
                ncc = NhaCungCapBUS.getDsncc().get(index);
            }

            txtMaNCC.setText(ncc.getMaNCC());
            txtTenNCC.setText(ncc.getTenNCC());
            txtSĐT.setText(ncc.getSoDT());
            txtDiaChi.setText(ncc.getDiaChi());

            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
        }
    }//GEN-LAST:event_tblNhaCungCapMouseClicked

    private void xuatExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExcelFileActionPerformed
        String[] columnNames = {"Mã nhà cung cấp", "Tên nhà cung cấp", "Số điện thoại", "Địa chỉ"};
        try {
            XuatExcel xuat = new XuatExcel(tblNhaCungCap, columnNames, "Nhà Cung Cấp");
        } catch (IOException ex) {
            Logger.getLogger(NhaCungCapFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xuatExcelFileActionPerformed

    private void tblNhaCungCapMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhaCungCapMouseReleased
        if(evt.isPopupTrigger())
        {
            rightClickMenu.show(tblNhaCungCap, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblNhaCungCapMouseReleased

    private void nhapExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExcelFileActionPerformed
        // TODO add your handling code here:
        nhapExcel nhap = new nhapExcel(tblNhaCungCap);
        DefaultTableModel newModel = nhap.importExcel();
        if(newModel.getRowCount() > 0)
        {
            tblNhaCungCap.setModel(newModel);
            tblNhaCungCap = initHeaderColor(tblNhaCungCap, 14, 142, 233);
        }
    }//GEN-LAST:event_nhapExcelFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHienThiTatCa;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> comboBoxMucTimKiem;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblMaNCC;
    private javax.swing.JLabel lblSĐT;
    private javax.swing.JLabel lblTenNCC;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JMenuItem nhapExcelFile;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JTable tblNhaCungCap;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtSĐT;
    private javax.swing.JTextField txtTenNCC;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JMenuItem xuatExcelFile;
    // End of variables declaration//GEN-END:variables
}
