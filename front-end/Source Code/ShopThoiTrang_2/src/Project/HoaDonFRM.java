/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import com.itextpdf.text.DocumentException;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import com.toedter.calendar.JDateChooser;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author loith
 */
public class HoaDonFRM extends javax.swing.JPanel {

    /**
     * Creates new form HoaDonFRM
     */
    Color flatBlue = new Color(14,142,233);
    Color matteGrey = new Color(223,230,233);
     
    ChiTietHDFrame cthd; 
    ShopForm shop;
    
    public HoaDonFRM(ShopForm shop) throws Exception {
        initComponents();
        this.shop = shop;
        tblScrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
        tblHoaDon = initHeaderColor(tblHoaDon,14,142,233); 
        comboBoxMucTimKiem = myComboBox(comboBoxMucTimKiem,flatBlue);
        DCNgayHD = myDateChooser(DCNgayHD);
        txtTongTien.setText("0");
        txtThanhTien.setText("0");
        docDatabase();
        docComboBox();
        autoGenerateID(txtMaHD);
        tblHoaDon = setColumnWidth(tblHoaDon);
    }
    
    public void docComboBox() throws  Exception{
        NhanVienBUS busNV = new  NhanVienBUS();
        KhachHangBUS busKH = new  KhachHangBUS();
        
        String [] arrayMaNV = busNV.docComboBoxMaNV();
        comboBoxNV.setModel(new javax.swing.DefaultComboBoxModel<>(arrayMaNV));
        comboBoxNV = myComboBox(comboBoxNV,matteGrey);   

        String [] arrayMaKH = busKH.docComboBoxMaKH();   
        comboBoxKH.setModel(new javax.swing.DefaultComboBoxModel<>(arrayMaKH));
        comboBoxKH = myComboBox(comboBoxKH,matteGrey);
    }
        
    public void docComboBoxKH(String ma[]) throws  Exception{
        comboBoxKH.setModel(new javax.swing.DefaultComboBoxModel<>(ma));
    }
    
    public void docComboBoxNV(String ma[]) throws  Exception{
        comboBoxNV.setModel(new javax.swing.DefaultComboBoxModel<>(ma));
    }    
    
     public void resetTxt() throws Exception {
        autoGenerateID(txtMaHD); 
        txtMaHD.setText("");
        DCNgayHD.setDate(null);
        txtTongTien.setText("0");
        txtMaKM.setText("");
        txtThanhTien.setText("0");
    }
    
     public JTable setColumnWidth(JTable table)
    {         
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(40);
        
     
        return table;
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
    
    public void setTxtMaKM(String maKM)
    {
        txtMaKM.setText(maKM);
    }
    
    public void resetMoney(String maHD, String maKM) throws Exception
    {
        HoaDonBUS bus = new HoaDonBUS();
        HoaDonDTO old = bus.timHD(maHD);
        HoaDonDTO hd = old;
        
        ChiTietHDBUS cthdBus = new ChiTietHDBUS();
        if(maKM.equals(""))
        {
            hd.setTongTien(cthdBus.tinhTongTien(maHD));
            hd.setThanhTien(bus.tinhThanhTien(maHD, hd.getTongTien()));
        }
        else
        {
            hd.setTongTien(cthdBus.tinhTongTien(maHD, maKM));
            hd.setThanhTien(bus.tinhThanhTien(maHD, hd.getTongTien(), maKM));
        }
        bus.sua(hd, old);
        refreshTableRowMoney(maHD);
    }
    
    public void resetTxtMoney(String maHD, String maKM) throws Exception
    {
        HoaDonBUS bus = new HoaDonBUS();
        HoaDonDTO old = bus.timHD(maHD);
        HoaDonDTO hd = old;
        
        ChiTietHDBUS cthdBus = new ChiTietHDBUS();
        if(maKM.equals(""))
        {
            txtTongTien.setText(Float.toString(cthdBus.tinhTongTien(maHD)));
            Float tongTien = Float.parseFloat(txtTongTien.getText());
            txtThanhTien.setText(Float.toString(bus.tinhThanhTien(maHD, tongTien)));
        }
        else
        {
            txtTongTien.setText(Float.toString(cthdBus.tinhTongTien(maHD, maKM)));
            Float tongTien = Float.parseFloat(txtTongTien.getText());
            txtThanhTien.setText(Float.toString(bus.tinhThanhTien(maHD, tongTien, maKM)));
        }
    }
    
    public void refreshTableRowMoney(String maHD)
    {
        HoaDonBUS bus = new HoaDonBUS();
        int i = -1;
        if(flag == true)
        {
            i = bus.timIndex(maHD);
            model.setValueAt(bus.getDshd().get(i).getTongTien(), i, 4);
            model.setValueAt(bus.getDshd().get(i).getThanhTien(), i, 6);
        }
        else
        {
            for(int j = 0; j < modelTimKiem.getRowCount(); ++j)
            {
                if(modelTimKiem.getValueAt(j, 0).equals(maHD))
                    i = j;
            }
            modelTimKiem.setValueAt(bus.getDshd().get(i).getTongTien(), i, 4);
            modelTimKiem.setValueAt(bus.getDshd().get(i).getThanhTien(), i, 6);
        }
    }
    
    public void refreshTxtThanhTien()
    {
        KhuyenMaiBUS bus = new KhuyenMaiBUS();
        Float phanTramKhuyenMai = bus.timKM(txtMaKM.getText()).getPhanTramKhuyenMai();
        Float thanhTien = Float.parseFloat(txtTongTien.getText()) * (phanTramKhuyenMai / 100);
        txtThanhTien.setText(Float.toString(thanhTien));
    }
    
    public void xoaKM(String maHD) throws Exception
    {
        HoaDonBUS bus = new HoaDonBUS();
        HoaDonDTO old = bus.timHD(maHD);
        HoaDonDTO hd = old;
        hd.setMaKM("");
        bus.sua(hd, old);
        
        int i = -1;
        if(flag == true)
        {
            i = bus.timIndex(maHD);
            model.setValueAt(bus.getDshd().get(i).getMaKM(), i, 5);
        }
        else
        {
            for(int j = 0; j < modelTimKiem.getRowCount(); ++j)
            {
                if(modelTimKiem.getValueAt(j, 0).equals(maHD))
                    i = j;
            }
            modelTimKiem.setValueAt(bus.getDshd().get(i).getMaKM(), i, 5);
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
        pnlMain = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        lblKhachHang = new javax.swing.JLabel();
        lblNhanVien = new javax.swing.JLabel();
        lblNgayHD = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        pnlChucNang = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        lblTongTien = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        lblMaKM = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        btnHienThiTatCa = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnHienThiTatCaChiTiet = new javax.swing.JButton();
        btnHienThiChiTiet = new javax.swing.JButton();
        comboBoxMucTimKiem = new javax.swing.JComboBox<>();
        DCNgayHD = new com.toedter.calendar.JDateChooser();
        btnChonMaKM = new javax.swing.JButton();
        comboBoxKH = new javax.swing.JComboBox<>();
        comboBoxNV = new javax.swing.JComboBox<>();
        btnShow = new javax.swing.JButton();
        pnlTable = new javax.swing.JPanel();
        tblScrollPane = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

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

        reportPDF.setText("In hóa đơn\n");
        reportPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportPDFActionPerformed(evt);
            }
        });
        rightClickMenu.add(reportPDF);

        setPreferredSize(new java.awt.Dimension(683, 535));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setForeground(new java.awt.Color(14, 142, 233));
        pnlMain.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlMainMouseMoved(evt);
            }
        });
        pnlMain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMainMouseClicked(evt);
            }
        });

        lblTieuDe.setBackground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(14, 142, 233));
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("HOÁ ĐƠN");
        lblTieuDe.setOpaque(true);

        lblMaHD.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMaHD.setForeground(new java.awt.Color(14, 142, 233));
        lblMaHD.setText("Mã hoá đơn:");

        lblKhachHang.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblKhachHang.setForeground(new java.awt.Color(14, 142, 233));
        lblKhachHang.setText("Mã khách hàng:");

        lblNhanVien.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNhanVien.setForeground(new java.awt.Color(14, 142, 233));
        lblNhanVien.setText("Mã nhân viên:");

        lblNgayHD.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblNgayHD.setForeground(new java.awt.Color(14, 142, 233));
        lblNgayHD.setText("Ngày hoá đơn:");

        txtMaHD.setBackground(new java.awt.Color(223, 230, 233));
        txtMaHD.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtMaHD.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChucNangLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        pnlChucNangLayout.setVerticalGroup(
            pnlChucNangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChucNangLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        lblTongTien.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(14, 142, 233));
        lblTongTien.setText("Tổng tiền:");

        txtTongTien.setEditable(false);
        txtTongTien.setBackground(new java.awt.Color(223, 230, 233));
        txtTongTien.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtTongTien.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));

        lblMaKM.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblMaKM.setForeground(new java.awt.Color(14, 142, 233));
        lblMaKM.setText("Mã khuyến mãi:");

        lblThanhTien.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblThanhTien.setForeground(new java.awt.Color(14, 142, 233));
        lblThanhTien.setText("Thành tiền:");

        txtMaKM.setEditable(false);
        txtMaKM.setBackground(new java.awt.Color(223, 230, 233));
        txtMaKM.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtMaKM.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));
        txtMaKM.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtMaKMInputMethodTextChanged(evt);
            }
        });

        txtThanhTien.setEditable(false);
        txtThanhTien.setBackground(new java.awt.Color(223, 230, 233));
        txtThanhTien.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        txtThanhTien.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(223, 230, 233)));
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

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
        comboBoxMucTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã HĐ", "Mã KH", "Mã NV", "Ngày HĐ", "Tổng tiền", "Mã KM", "Thành tiền" }));
        comboBoxMucTimKiem.setToolTipText("null");
        comboBoxMucTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        comboBoxMucTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxMucTimKiemActionPerformed(evt);
            }
        });

        DCNgayHD.setBackground(new java.awt.Color(223, 230, 233));
        DCNgayHD.setDateFormatString("y-MM-dd");
        DCNgayHD.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DCNgayHDMouseMoved(evt);
            }
        });
        DCNgayHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DCNgayHDMouseClicked(evt);
            }
        });

        btnChonMaKM.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnChonMaKM.setText("...");
        btnChonMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonMaKMActionPerformed(evt);
            }
        });

        comboBoxKH.setBackground(new java.awt.Color(223, 230, 233));

        comboBoxNV.setBackground(new java.awt.Color(223, 230, 233));
        comboBoxNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxNVActionPerformed(evt);
            }
        });

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
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DCNgayHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaHD)
                                    .addComponent(comboBoxKH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(38, 38, 38))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnHienThiTatCaChiTiet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                                .addComponent(btnHienThiChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnShow, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChonMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHienThiTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxMucTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(lblMaKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnChonMaKM))
                            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DCNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(btnHienThiTatCaChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHienThiChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))))
        );

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseReleased(evt);
            }
        });
        tblScrollPane.setViewportView(tblHoaDon);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void docDatabase() throws Exception {
        HoaDonBUS bus = new HoaDonBUS();
        if (HoaDonBUS.getDshd() == null) {
            bus.docDSHD();
        }

        String[] columnNames = {"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Ngày HĐ","Tổng tiền", "Mã KM", "Thành tiền"};
        Vector header = createHeader(columnNames);

        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }

        for (HoaDonDTO hd : HoaDonBUS.getDshd()) {
            
            Vector row = new Vector();
            row.add(hd.getMaHD());
            row.add(hd.getMaKH());
            row.add(hd.getMaNV());
            row.add(hd.getNgayHD());
            row.add(hd.getTongTien());
            row.add(hd.getMaKM());
            row.add(hd.getThanhTien());

            model.addRow(row);
        }

        tblHoaDon.setModel(model);
        tblHoaDon = initHeaderColor(tblHoaDon, 14, 142, 233);

    }
    
     public boolean checkEmptyTxt() {
        if (txtMaHD.getText().equals("") || DCNgayHD.getDate() == null)
        {
            return true;
        }
        return false;
    }
    
    void autoGenerateID(JTextField txt) throws Exception
    {
        HoaDonBUS bus = new HoaDonBUS();
        String ID = bus.taoIdTuDong();
        txt.setText(ID);
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
    
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (checkEmptyTxt() == true)
        return;
        else {
            HoaDonBUS bus = new HoaDonBUS();

            if (bus.kiemTraTrung(txtMaHD.getText())) {
                JOptionPane.showMessageDialog(this, "Mã hoá đơn đã tồn tại. Mời nhập Mã hoá đơn khác!");
                return;
            }

            HoaDonDTO hd = new HoaDonDTO();
            Date date = DCNgayHD.getDate();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = df.format(date);

            hd.setMaHD(txtMaHD.getText());
            hd.setMaKH(comboBoxKH.getSelectedItem().toString());
            hd.setMaNV(comboBoxNV.getSelectedItem().toString());
            hd.setNgayHD(strDate);
            hd.setTongTien(Float.parseFloat(txtTongTien.getText()));
            hd.setMaKM(txtMaKM.getText());
            hd.setThanhTien(Float.parseFloat(txtThanhTien.getText()));

            try {
                bus.them(hd);
            } catch (Exception ex) {
                Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
            }

            String[] columnNames = {"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Ngày HĐ","Tổng tiền", "Mã KM", "Thành tiền"};
            Vector header = createHeader(columnNames);
           
            if (model.getRowCount() == 0) {
                model = new DefaultTableModel(header, 0);
            }

            Vector row = new Vector();
            row.add(hd.getMaHD());
            row.add(hd.getMaKH());
            row.add(hd.getMaNV());
            row.add(hd.getNgayHD());
            row.add(hd.getTongTien());
            row.add(hd.getMaKM());
            row.add(hd.getThanhTien());

            model.addRow(row);
            tblHoaDon.setModel(model);

            JOptionPane.showMessageDialog(this, "Thêm thành công!");
            try {
                resetTxt();
            } catch (Exception ex) {
                Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();
        if (i >= 0) {
            int selection = JOptionPane.showConfirmDialog(this, "Bạn muốn xóa dòng này?", "Thông báo xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (selection == JOptionPane.YES_OPTION) {
                HoaDonBUS bus = new HoaDonBUS();
                if (flag == true)
                {
                    String maHD = model.getValueAt(i, 0).toString();
                    try {
                        bus.xoa(maHD);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Bạn không thể xóa dòng này!");
                        return;
                    }

                    model.removeRow(i);
                    tblHoaDon.setModel(model);
                }
                else
                {
                    String maHD = modelTimKiem.getValueAt(i, 0).toString();
                    try {
                        bus.xoa(maHD);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, "Bạn không thể xóa dòng này!");
                        return;
                    }

                    int index = bus.timIndex(maHD);

                    modelTimKiem.removeRow(i);
                    tblHoaDon.setModel(modelTimKiem);

                    model.removeRow(index);
                }

                btnXoa.setEnabled(false);
                btnSua.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Xóa thành công!");
                try {
                    resetTxt();
                } catch (Exception ex) {
                    Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int temp = -1;
        int i = tblHoaDon.getSelectedRow();
        if (i >= 0) {
            HoaDonBUS bus = new HoaDonBUS();
            String maHDCu;
            if (flag == true) {
                maHDCu = model.getValueAt(i, 0).toString();
            } else {
                temp = i;
                maHDCu = modelTimKiem.getValueAt(temp, 0).toString();
                i = bus.timIndex(maHDCu);
            }

            if (bus.kiemTraTrung(txtMaHD.getText(), maHDCu)) {
                JOptionPane.showMessageDialog(this, "Mã hoá đơn đã tồn tại. Mời nhập Mã hoá đơn khác!");
                return;
            } else {

                HoaDonDTO hd = new HoaDonDTO();
                Date date = DCNgayHD.getDate();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String strDate = df.format(date);

                hd.setMaHD(txtMaHD.getText());
                hd.setMaKH(comboBoxKH.getSelectedItem().toString());
                hd.setMaNV(comboBoxNV.getSelectedItem().toString());
                hd.setNgayHD(strDate);
                hd.setTongTien(Float.parseFloat(txtTongTien.getText()));
                hd.setMaKM(txtMaKM.getText());
                hd.setThanhTien(Float.parseFloat(txtThanhTien.getText()));

                HoaDonDTO old = HoaDonBUS.getDshd().get(i);

                try {
                    bus.sua(hd, old);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Bạn không thể thay đổi Mã hoá đơn này!");
                    return;
                }

                model.setValueAt(hd.getMaHD(), i, 0);
                model.setValueAt(hd.getMaKH(), i, 1);
                model.setValueAt(hd.getMaNV(), i, 2);
                model.setValueAt(hd.getNgayHD(), i, 3);
                model.setValueAt(hd.getTongTien(), i, 4);
                model.setValueAt(hd.getMaKM(), i, 5);
                model.setValueAt(hd.getThanhTien(), i, 6);

                if (flag == false) {
                    modelTimKiem.setValueAt(hd.getMaHD(), temp, 0);
                    modelTimKiem.setValueAt(hd.getMaKH(), temp, 1);
                    modelTimKiem.setValueAt(hd.getMaNV(), temp, 2);
                    modelTimKiem.setValueAt(hd.getNgayHD(), temp, 3);
                    modelTimKiem.setValueAt(hd.getTongTien(), temp, 4);
                    modelTimKiem.setValueAt(hd.getMaKM(), temp, 5);
                    modelTimKiem.setValueAt(hd.getThanhTien(), temp, 6);
                }

                hienCacNutChucNang();

                JOptionPane.showMessageDialog(this, "Sửa thành công!");
                try {
                    resetTxt();
                } catch (Exception ex) {
                    Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void btnHienThiTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiTatCaActionPerformed
        // TODO add your handling code here:
        flag = true;
        tblHoaDon.setModel(model);
        btnThem.setEnabled(true);
        tblHoaDon = initHeaderColor(tblHoaDon, 14, 142, 233);
        tblHoaDon = setColumnWidth(tblHoaDon);
    }//GEN-LAST:event_btnHienThiTatCaActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        String mucTimKiem = comboBoxMucTimKiem.getSelectedItem().toString();
        String duLieu = txtTimKiem.getText();

        String[] columnNames = {"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Ngày HĐ","Tổng tiền", "Mã KM", "Thành tiền"};
        Vector header = createHeader(columnNames);

        if (duLieu.equals("") == false) {
            ArrayList<HoaDonDTO> tempArr = new ArrayList<HoaDonDTO>();
            HoaDonBUS bus = new HoaDonBUS();

            tempArr = bus.timKiem(mucTimKiem, duLieu);

            if (tempArr.size() > 0) {
                modelTimKiem = new DefaultTableModel();

                if (modelTimKiem.getRowCount() == 0) {
                    modelTimKiem = new DefaultTableModel(header, 0);
                }

                for (HoaDonDTO hd : tempArr) {
                    Vector row = new Vector();
                    row.add(hd.getMaHD());
                    row.add(hd.getMaKH());
                    row.add(hd.getMaNV());
                    row.add(hd.getNgayHD());
                    row.add(hd.getTongTien());
                    row.add(hd.getMaKM());
                    row.add(hd.getThanhTien());

                    modelTimKiem.addRow(row);
                }
                tblHoaDon.setModel(modelTimKiem);
                tblHoaDon = initHeaderColor(tblHoaDon, 14, 142, 233);
                tblHoaDon = setColumnWidth(tblHoaDon);

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

    private void DCNgayHDMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCNgayHDMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_DCNgayHDMouseMoved

    private void DCNgayHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCNgayHDMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_DCNgayHDMouseClicked

    private void pnlMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseClicked
        try {
            resetTxt();
        } catch (Exception ex) {
            Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnlMainMouseClicked

    private void btnHienThiChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiChiTietActionPerformed
        int i = tblHoaDon.getSelectedRow();     
        if (i >= 0) 
        {              
            try {
                cthd = new ChiTietHDFrame(shop, model.getValueAt(i, 0).toString());
                cthd.setVisible(true);
                cthd.setDefaultCloseOperation(cthd.HIDE_ON_CLOSE);   
            } 
            catch (Exception ex) {
                Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }//GEN-LAST:event_btnHienThiChiTietActionPerformed

    private void btnHienThiTatCaChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiTatCaChiTietActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            cthd = new ChiTietHDFrame(shop, null);           
            cthd.setVisible(true);
            cthd.setDefaultCloseOperation(cthd.HIDE_ON_CLOSE);
           
        } catch (Exception ex) {
            Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHienThiTatCaChiTietActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
         
    }//GEN-LAST:event_formMouseMoved

    private void pnlMainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlMainMouseMoved

    private void btnChonMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonMaKMActionPerformed
        int i = tblHoaDon.getSelectedRow();     
        if (i >= 0) 
        {
            String maHD;
            if(flag == true)
                maHD = model.getValueAt(i, 0).toString();
            else
                maHD = modelTimKiem.getValueAt(i, 0).toString();
            try {
                KhuyenMaiHopLeFrame kmhl = new KhuyenMaiHopLeFrame(this, maHD);
                kmhl.setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 dòng trong bảng trước khi tra cứu!");
    }//GEN-LAST:event_btnChonMaKMActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int i = tblHoaDon.getSelectedRow();
       
        if (i >= 0) {
            HoaDonBUS bus = new HoaDonBUS();
            HoaDonDTO hd = new HoaDonDTO();
            if (flag == true) {
                hd = HoaDonBUS.getDshd().get(i);
            } else {
                int index = bus.timIndex(modelTimKiem.getValueAt(i, 0).toString());
                hd = HoaDonBUS.getDshd().get(index);
            }

            txtMaHD.setText(hd.getMaHD());
            comboBoxKH.setSelectedItem(hd.getMaKH());
            comboBoxNV.setSelectedItem(hd.getMaNV());

            String ngay = hd.getNgayHD();
            try {
                Date Ngay = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
                DCNgayHD.setDate(Ngay);
            } catch (ParseException ex) {
                Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtTongTien.setText(Float.toString(hd.getTongTien()));
            txtMaKM.setText(hd.getMaKM());
            txtThanhTien.setText(Float.toString(hd.getThanhTien()));

            btnXoa.setEnabled(true);
            btnSua.setEnabled(true);
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void comboBoxNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxNVActionPerformed

    private void txtMaKMInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtMaKMInputMethodTextChanged
        refreshTxtThanhTien();
    }//GEN-LAST:event_txtMaKMInputMethodTextChanged

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        HD_CTHD_Frame show = new HD_CTHD_Frame();
        show.setVisible(true);
    }//GEN-LAST:event_btnShowActionPerformed

    private void tblHoaDonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseReleased
        if(evt.isPopupTrigger())
        {
            rightClickMenu.show(tblHoaDon, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblHoaDonMouseReleased

    private void xuatExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExcelFileActionPerformed
        String[] columnNames = {"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Ngày HĐ","Tổng tiền", "Mã KM", "Thành tiền"};
        try {
            XuatExcel xuat = new XuatExcel(tblHoaDon, columnNames, "Hoá Đơn");
        } catch (IOException ex) {
            Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xuatExcelFileActionPerformed

    private void nhapExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExcelFileActionPerformed
        // TODO add your handling code here:
        nhapExcel nhap = new nhapExcel(tblHoaDon);
        DefaultTableModel newModel = nhap.importExcel();
        if (newModel.getRowCount() > 0) {
            tblHoaDon.setModel(newModel);
            tblHoaDon = initHeaderColor(tblHoaDon, 14, 142, 233);
        }
    }//GEN-LAST:event_nhapExcelFileActionPerformed

    private void reportPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportPDFActionPerformed
        // TODO add your handling code here:
        int i = tblHoaDon.getSelectedRow();     
        if (i >= 0) 
        { 
            try {
                ReportPDF report = new ReportPDF();
                //report.reportHoaDon(tblHoaDon, i);
            } catch (DocumentException ex) {
                Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            String[] columnNames = {"Mã hoá đơn", "Mã khách hàng", "Mã nhân viên", "Ngày HĐ","Tổng tiền", "Mã KM", "Thành tiền"};
            try {
                ReportPDF report = new ReportPDF();
                report.reportAll(tblHoaDon, columnNames);
            } catch (DocumentException ex) {
                Logger.getLogger(HoaDonFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_reportPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCNgayHD;
    private javax.swing.JButton btnChonMaKM;
    private javax.swing.JButton btnHienThiChiTiet;
    private javax.swing.JButton btnHienThiTatCa;
    private javax.swing.JButton btnHienThiTatCaChiTiet;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> comboBoxKH;
    private javax.swing.JComboBox<String> comboBoxMucTimKiem;
    private javax.swing.JComboBox<String> comboBoxNV;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblKhachHang;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaKM;
    private javax.swing.JLabel lblNgayHD;
    private javax.swing.JLabel lblNhanVien;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JMenuItem nhapExcelFile;
    private javax.swing.JPanel pnlChucNang;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JMenuItem reportPDF;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JMenuItem xuatExcelFile;
    // End of variables declaration//GEN-END:variables
}
