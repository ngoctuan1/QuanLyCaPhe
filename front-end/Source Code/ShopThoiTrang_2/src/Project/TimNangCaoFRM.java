/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author loith
 */
public class TimNangCaoFRM extends javax.swing.JPanel {
    MySQLConnect connect;
    DefaultTableModel model = new DefaultTableModel() ;
    Color  matteBlue = new Color(14,142,233);  
    Color  matteGrey = new Color(223,230,233);
    Color  normalBlack = new Color(51,51,51);
    private CardLayout cardLayout;
    String SelectedTBL;
    String SelectedColumn;
    String lblName;
    
    String[] columnNamesHoaDon = {"MaHD", "MaKH", "MaNV", "NgayHD", "TongTien" ,"MaKM", "ThanhTien"};
    String[] columnNamesChiTietHD = {"MaHD", "MaSP", "SoLuong", "DonGia"};
    String[] columnNamesPhieuNhap = {"MaPN", "MaNV", "MaNCC" ,"NgayNhap", "TongTien"};
    String[] columnNamesChiTietPN = {"MaPN", "MaSP", "SoLuong" ,"DonGia"};
    String[] columnNamesSanPham = {"MaSP","TenSP","SoLuong","DonGia","MaLSP","MaNSX"};
    String[] columnNamesLoaiSP = {"MaLSP" ,"TenLSP", "LoaiTienTe"};
    String[] columnNamesNhanVien = {"MaNV", "Ho", "Ten"/*, "GioiTinh"*/, "NgaySinh", "DiaChi", "Luong"}; // Giới tính vt arr[3]
    String[] columnNamesKhachHang = {"MaKH", "Ho", "Ten" ,"DiaChi", "SoDT"};
    String[] columnNamesNhaCungCap = {"MaNCC", "TenNCC", "SoDT", "DiaChi"};
    String[] columnNamesNhaSanXuat = {"MaNSX", "TenNSX", "QuocGia"};
    String[] columnNamesKhuyenMai = {"MaKM", "TenKM", "GiaDHToiThieu", "NgayBatDau", "NgayKetThuc", "PhanTramKM"};
    String[] columnNamesChiTietKM = {"MaKM", "MaSP" ,"SoLuongToiThieu", "PhanTramKM"};
    String[] columnNamesTaiKhoan = {"MaNV", "TenDangNhap", "MatKhau", "Quyen"};
    // MAC DINH
    String[] columnNames = {"MaHD", "MaKH", "MaNV", "NgayHD", "TongTien" ,"MaKM", "ThanhTien"};
    String table = "TBLHOADON";
    String column;
    int NumberOfColumn = columnNamesHoaDon.length;
    /**
     * Creates new form ThongKeFRM
     */
    public TimNangCaoFRM() {
        connect = new MySQLConnect("localhost", "root", "", "shopdb");
        initComponents();
        themPanelVaoCard();
        DCTuNgay = myDateChooser(DCTuNgay);
        DCDenNgay = myDateChooser(DCDenNgay);
        comboBoxTenBang.setUI(new BasicComboBoxUI() {
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(comboBox) {
                    @Override
                    protected JScrollPane createScroller() {
                        JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        scroller.getVerticalScrollBar().setUI(new MyScrollBarUI());
                        return scroller;
                     } 
                };
            }
        });
        comboBoxTenBang = myComboBox(comboBoxTenBang,matteGrey);
        comboBoxTenBang.addItemListener(itemListener);
        comboBoxCotCuaBang.addItemListener(itemListener2);
        comboBoxCotCuaBang = myComboBox(comboBoxCotCuaBang,matteGrey);
        
                                
                                 
        tblTimNangCao = initHeaderColor(tblTimNangCao,14,142,233);
        
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
                return new BasicComboPopup(comboBox) {                    
                    @Override
                    protected JScrollPane createScroller() {
                        
                        JScrollPane scroller = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                        scroller.getVerticalScrollBar().setUI(new MyScrollBarUI());
                        return scroller;
                     } 
                };
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
    
    public boolean checkEmptyTxt() {
        SelectedColumn = comboBoxCotCuaBang.getSelectedItem().toString();
        int flag = Define(SelectedColumn);
        if(flag == 2)
        {
            if(DCTuNgay.getDate() == null || DCDenNgay.getDate() == null)
                return true;
        }
        else if(flag == 1)
        {
            if(txtNumData.getText().equals(""))
                return true;
        }
        else if(flag == 0)
        {
            if(txtTextData.getText().equals(""))
              return true;
        }
        return false;
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SoSanh = new javax.swing.ButtonGroup();
        rightClickMenu = new javax.swing.JPopupMenu();
        xuatExcelFile = new javax.swing.JMenuItem();
        nhapExcelFile = new javax.swing.JMenuItem();
        pnlMain = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        comboBoxCotCuaBang = new javax.swing.JComboBox<>();
        lblTenBang = new javax.swing.JLabel();
        comboBoxTenBang = new javax.swing.JComboBox<>();
        lblTenCotCuaBang = new javax.swing.JLabel();
        pnlThongTin = new javax.swing.JPanel();
        pnlTextData = new javax.swing.JPanel();
        lblTextData = new javax.swing.JLabel();
        txtTextData = new javax.swing.JTextField();
        pnlNumberData = new javax.swing.JPanel();
        lblNumData = new javax.swing.JLabel();
        txtNumData = new javax.swing.JTextField();
        LonHonBang = new javax.swing.JRadioButton();
        BeHonBang = new javax.swing.JRadioButton();
        Bang = new javax.swing.JRadioButton();
        pnlDateData = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        DCTuNgay = new com.toedter.calendar.JDateChooser();
        lbl2 = new javax.swing.JLabel();
        DCDenNgay = new com.toedter.calendar.JDateChooser();
        pnlTable = new javax.swing.JPanel();
        tblScrollPane = new javax.swing.JScrollPane();
        tblTimNangCao = new javax.swing.JTable();

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
        lblTieuDe.setText("Tìm Nâng Cao");
        lblTieuDe.setOpaque(true);

        btnTimKiem.setBackground(new java.awt.Color(14, 142, 233));
        btnTimKiem.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_icon.png"))); // NOI18N
        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.setBorder(null);
        btnTimKiem.setContentAreaFilled(false);
        btnTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimKiem.setIconTextGap(15);
        btnTimKiem.setOpaque(true);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        comboBoxCotCuaBang.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboBoxCotCuaBang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MaHD", "MaKH", "MaNV", "NgayHD", "TongTien", "MaKM", "ThanhTien" }));

        lblTenBang.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTenBang.setText("Tên Bảng:");

        comboBoxTenBang.setBackground(new java.awt.Color(14, 142, 233));
        comboBoxTenBang.setEditable(true);
        comboBoxTenBang.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboBoxTenBang.setForeground(new java.awt.Color(255, 255, 255));
        comboBoxTenBang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoá Đơn", "Chi Tiết Hoá Đơn", "Phiếu Nhập", "Chi Tiết Phiếu Nhập", "Sản Phẩm", "Loại Sản Phẩm", "Nhân Viên", "Khách Hàng", "Nhà Cung Cấp", "Nhà Sản Xuất", "Khuyến Mãi", "Chi Tiết Khuyến Mãi", "Tài Khoản" }));
        comboBoxTenBang.setBorder(null);
        comboBoxTenBang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        lblTenCotCuaBang.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblTenCotCuaBang.setText("Tên cột của bảng:");

        pnlThongTin.setOpaque(false);
        pnlThongTin.setLayout(new java.awt.CardLayout());

        pnlTextData.setOpaque(false);

        lblTextData.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblTextData.setText("MaHD");

        txtTextData.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N

        javax.swing.GroupLayout pnlTextDataLayout = new javax.swing.GroupLayout(pnlTextData);
        pnlTextData.setLayout(pnlTextDataLayout);
        pnlTextDataLayout.setHorizontalGroup(
            pnlTextDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlTextDataLayout.setVerticalGroup(
            pnlTextDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTextDataLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlTextDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTextData, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTextData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pnlThongTin.add(pnlTextData, "card2");

        pnlNumberData.setOpaque(false);

        lblNumData.setText("NumData:");

        SoSanh.add(LonHonBang);
        LonHonBang.setSelected(true);
        LonHonBang.setText(">=");

        SoSanh.add(BeHonBang);
        BeHonBang.setText("<=");

        SoSanh.add(Bang);
        Bang.setText("=");

        javax.swing.GroupLayout pnlNumberDataLayout = new javax.swing.GroupLayout(pnlNumberData);
        pnlNumberData.setLayout(pnlNumberDataLayout);
        pnlNumberDataLayout.setHorizontalGroup(
            pnlNumberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumberDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNumberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNumberDataLayout.createSequentialGroup()
                        .addComponent(lblNumData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumData, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnlNumberDataLayout.createSequentialGroup()
                        .addComponent(LonHonBang, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BeHonBang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(Bang, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        pnlNumberDataLayout.setVerticalGroup(
            pnlNumberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNumberDataLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlNumberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumData, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlNumberDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LonHonBang)
                    .addComponent(BeHonBang)
                    .addComponent(Bang))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlThongTin.add(pnlNumberData, "card3");

        pnlDateData.setOpaque(false);

        lbl1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl1.setText("Từ ngày:");

        DCTuNgay.setBackground(new java.awt.Color(223, 230, 233));
        DCTuNgay.setDateFormatString("y-MM-dd");
        DCTuNgay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DCTuNgayMouseMoved(evt);
            }
        });
        DCTuNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DCTuNgayMouseClicked(evt);
            }
        });

        lbl2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lbl2.setText("Đến ngày:");

        DCDenNgay.setBackground(new java.awt.Color(223, 230, 233));
        DCDenNgay.setDateFormatString("y-MM-dd");
        DCDenNgay.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                DCDenNgayMouseMoved(evt);
            }
        });
        DCDenNgay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DCDenNgayMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlDateDataLayout = new javax.swing.GroupLayout(pnlDateData);
        pnlDateData.setLayout(pnlDateDataLayout);
        pnlDateDataLayout.setHorizontalGroup(
            pnlDateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDateDataLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DCDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDateDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DCTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        pnlDateDataLayout.setVerticalGroup(
            pnlDateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDateDataLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlDateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DCTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(pnlDateDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DCDenNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );

        pnlThongTin.add(pnlDateData, "card4");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTenBang, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTenCotCuaBang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxTenBang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxCotCuaBang, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblTenBang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxTenBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTenCotCuaBang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxCotCuaBang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        tblTimNangCao.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTimNangCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTimNangCaoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblTimNangCaoMouseReleased(evt);
            }
        });
        tblScrollPane.setViewportView(tblTimNangCao);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void themPanelVaoCard()
    {   
        cardLayout = (CardLayout) (pnlThongTin.getLayout());
        pnlThongTin.add(pnlTextData,"Text");
        pnlThongTin.add(pnlNumberData,"Number");
        pnlThongTin.add(pnlDateData,"Date");
    }
    
    public Vector createHeader(Object[] columnNames) {
        Vector header = new Vector();
        for (Object colName : columnNames) {
            header.add(colName);
        }

        return header;
    }
    
    void timKiem(String Table, String Column, String duLieu) throws Exception{
        int flag = Define(Column);
        if ( flag == 0 )
        {
            try{
                //String[] columnNames = {"Mã nhà sản xuất", "Tên nhà sản xuất", "Quốc gia"};
                Vector header = createHeader(columnNames);

                model = new DefaultTableModel(header, 0);

                String qry = "SELECT * FROM "+ Table +" WHERE "+ Column +" LIKE '%"+ duLieu +"%' ";
                ResultSet rs = connect.executeQuery(qry);
                while(rs.next()){
                      Vector row = new Vector();
                      for(int i = 1; i <= NumberOfColumn; i++)                     
                          row.add(rs.getString(i));
                      model.addRow(row);
                }
                tblTimNangCao.setModel(model);
                tblTimNangCao = initHeaderColor(tblTimNangCao,14,142,233);
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "lỗi đọc thông tin TimNangCao");
            }
        }
        else if ( flag == 1 )
        {
            try{
                
                Vector header = createHeader(columnNames);

                model = new DefaultTableModel(header, 0);
                String soSanh = "=";
                if (LonHonBang.isSelected())
                soSanh =">=";
                else if (BeHonBang.isSelected())
                soSanh ="<=";
                
                String qry = "SELECT * FROM "+ Table +" WHERE "+ Column +" "+ soSanh +" "+ duLieu;
                ResultSet rs = connect.executeQuery(qry);
                while(rs.next()){
                      Vector row = new Vector();
                      for(int i = 1; i <= NumberOfColumn; i++)                     
                          row.add(rs.getString(i));
                      model.addRow(row);
                }
                tblTimNangCao.setModel(model);
                tblTimNangCao = initHeaderColor(tblTimNangCao,14,142,233);
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "lỗi đọc thông tin TimNangCao");
            }
        }
        else 
        {
            try{
                
                Vector header = createHeader(columnNames);

                model = new DefaultTableModel(header, 0);
                Date TuDate = DCTuNgay.getDate();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String strTuDate = df.format(TuDate);
                
                Date DenDate = DCDenNgay.getDate();
                //DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
                String strDenDate = df.format(DenDate);
                
                String qry = "SELECT * FROM "+ Table +" WHERE "+ Column +" BETWEEN '"+ strTuDate +"' AND '"+ strDenDate+"'";
                ResultSet rs = connect.executeQuery(qry);
                while(rs.next()){
                      Vector row = new Vector();
                      for(int i = 1; i <= NumberOfColumn; i++)                     
                          row.add(rs.getString(i));
                      model.addRow(row);
                }
                tblTimNangCao.setModel(model);
                tblTimNangCao = initHeaderColor(tblTimNangCao,14,142,233);
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(null, "lỗi đọc thông tin TimNangCao");
            }
        }
    }
    
    public int Define(String str)
    {
       int result = 0;
       if (str.equals("SoLuong"))
       {
           result = 1;
           lblName = "SoLuong";
       }
       
       else if (str.equals("DonGia"))
       {
           result = 1;
           lblName = "DonGia";
       }
       else if (str.equals("TongTien"))
       {
           result = 1;
           lblName = "TongTien";
       }
       else if (str.equals("ThanhTien"))
       {
           result = 1;
           lblName = "ThanhTien";
       }
       else if (str.equals("Luong"))
       {
           result = 1;
           lblName = "Luong";
       }
       else if (str.toLowerCase().indexOf("ngay") != -1)
       {
           result = 2;
       }
       else 
       {
           result = 0;
           lblName = comboBoxCotCuaBang.getSelectedItem().toString();
          
       }
       
       return result;
    }
    public void setComboBoxCotCuaBang(String arr[]) throws  Exception{
        comboBoxCotCuaBang.setModel(new javax.swing.DefaultComboBoxModel<>(arr));
    }
    
    ItemListener itemListener = new ItemListener() {
      public void itemStateChanged(ItemEvent itemEvent) {
        int state = itemEvent.getStateChange();
        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
        System.out.println("Item: " + itemEvent.getItem());
        SelectedTBL =  itemEvent.getItem().toString();
        cardLayout.show(pnlThongTin, "Text");
        lblName = "Dữ Liệu: ";
        lblTextData.setText(lblName);
        try
        {
            switch (SelectedTBL)  
            {
                case "Hoá Đơn": setComboBoxCotCuaBang(columnNamesHoaDon);
                NumberOfColumn = columnNamesHoaDon.length;
                columnNames = new String[] {"MaHD", "MaKH", "MaNV", "NgayHD", "TongTien" ,"MaKM", "ThanhTien"};
                table = "TBLHOADON";
                break;
                
                case "Phiếu Nhập": setComboBoxCotCuaBang(columnNamesPhieuNhap);
                NumberOfColumn = columnNamesPhieuNhap.length;
                columnNames = new String[] {"MaPN", "MaNV", "MaNCC" ,"NgayNhap", "TongTien"};
                table = "TBLPHIEUNHAP";
                break;
                
                case "Sản Phẩm": setComboBoxCotCuaBang(columnNamesSanPham);
                NumberOfColumn = columnNamesSanPham.length;
                columnNames = new String[] {"MaSP","TenSP","SoLuong","DonGia","MaLSP","MaNSX"};
                table = "TBLSANPHAM";
                break;
                
                case "Loại Sản Phẩm": setComboBoxCotCuaBang(columnNamesLoaiSP);
                NumberOfColumn = columnNamesLoaiSP.length;
                columnNames = new String[] {"MaLSP" ,"TenLSP", "LoaiTienTe"};
                table = "TBLLOAISP";
                break;
                
                case "Nhân Viên": setComboBoxCotCuaBang(columnNamesNhanVien);
                NumberOfColumn = columnNamesNhanVien.length+1; // gioi tinh rs.getString(4)
                columnNames = new String[] {"MaNV", "Ho", "Ten", "GioiTinh", "NgaySinh", "DiaChi", "Luong"};
                table = "TBLNHANVIEN";
                break;
                
                case "Khách Hàng": setComboBoxCotCuaBang(columnNamesKhachHang);
                NumberOfColumn = columnNamesKhachHang.length;
                columnNames = new String[] {"MaKH", "Ho", "Ten" ,"DiaChi", "SoDT"};
                table = "TBLKHACHHANG";
                break;
                
                case "Nhà Sản Xuất": setComboBoxCotCuaBang(columnNamesNhaSanXuat);
                NumberOfColumn = columnNamesNhaSanXuat.length;
                columnNames = new String[] {"MaNSX", "TenNSX", "QuocGia"};
                table = "TBLNHASANXUAT";
                break;
                
                case "Nhà Cung Cấp": setComboBoxCotCuaBang(columnNamesNhaCungCap);
                NumberOfColumn = columnNamesNhaCungCap.length;
                columnNames = new String[] {"MaNCC", "TenNCC", "SoDT", "DiaChi"};
                table = "TBLNHACUNGCAP";
                break;
                
                case "Tài Khoản": setComboBoxCotCuaBang(columnNamesTaiKhoan);
                NumberOfColumn = columnNamesTaiKhoan.length;
                columnNames = new String[] {"MaNV", "TenDangNhap", "MatKhau", "Quyen"};
                table = "TBLTAIKHOAN";
                break;
                
                case "Khuyến Mãi": setComboBoxCotCuaBang(columnNamesKhuyenMai);
                NumberOfColumn = columnNamesKhuyenMai.length;
                columnNames = new String[] {"MaKM", "TenKM", "GiaDHToiThieu", "NgayBatDau", "NgayKetThuc", "PhanTramKM"};
                table = "TBLKHUYENMAI";
                break;
                
                case "Chi Tiết Hoá Đơn": setComboBoxCotCuaBang(columnNamesChiTietHD);
                NumberOfColumn = columnNamesChiTietHD.length;
                columnNames = new String[] {"MaHD", "MaSP", "SoLuong", "DonGia"};
                table = "TBLCHITIETHD";
                break;
                
                case "Chi Tiết Phiếu Nhập": setComboBoxCotCuaBang(columnNamesChiTietPN);
                NumberOfColumn = columnNamesChiTietPN.length;
                columnNames = new String[] {"MaPN", "MaSP", "SoLuong" ,"DonGia"};
                table = "TBLCHITIETPN";
                break;
                
                case "Chi Tiết Khuyến Mãi": setComboBoxCotCuaBang(columnNamesChiTietKM);
                NumberOfColumn = columnNamesChiTietKM.length;
                columnNames = new String[] {"MaKM", "MaSP" ,"SoLuongToiThieu", "PhanTramKM"};
                table = "TBLCHITIETKM";
                break;
            }
        }
        catch(Exception error)
        {
             error.printStackTrace();
        }
      }    
    };
    
    ItemListener itemListener2 = new ItemListener() {
      public void itemStateChanged(ItemEvent itemEvent) {
        int state = itemEvent.getStateChange();
        System.out.println((state == ItemEvent.SELECTED) ? "Selected" : "Deselected");
        System.out.println("Item: " + itemEvent.getItem());
        SelectedColumn =  itemEvent.getItem().toString();
        
        try
        {
            int flag = Define(SelectedColumn);
            if (flag == 2)
            {
                cardLayout.show(pnlThongTin, "Date");           
            }
            else if (flag == 1)
            {
                cardLayout.show(pnlThongTin, "Number");
                lblNumData.setText(lblName);
            }
            else 
            {
                cardLayout.show(pnlThongTin, "Text");
                lblTextData.setText(lblName);
            }
             
        }
        catch(Exception error)
        {
             error.printStackTrace();
        }
      }    
    };
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        int check = Define(comboBoxCotCuaBang.getSelectedItem().toString());
        if(checkEmptyTxt() == true)
        {
            JOptionPane.showMessageDialog(this, "Dữ liệu còn trống!");
            return;
        }
        
        if ( check == 0)
        {
            try {
                timKiem(table, comboBoxCotCuaBang.getSelectedItem().toString(),txtTextData.getText());
            } catch (Exception ex) {
                Logger.getLogger(TimNangCaoFRM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (check == 1)
        {   
            try {
               timKiem(table, comboBoxCotCuaBang.getSelectedItem().toString(),txtNumData.getText());
           } catch (Exception ex) {
               Logger.getLogger(TimNangCaoFRM.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else
        {    
            try {
               timKiem(table, comboBoxCotCuaBang.getSelectedItem().toString(),null);
           } catch (Exception ex) {
               Logger.getLogger(TimNangCaoFRM.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void pnlMainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlMainMouseMoved

    private void pnlMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseClicked

    }//GEN-LAST:event_pnlMainMouseClicked

    private void tblTimNangCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTimNangCaoMouseClicked
         
    }//GEN-LAST:event_tblTimNangCaoMouseClicked

    private void DCTuNgayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCTuNgayMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DCTuNgayMouseMoved

    private void DCTuNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCTuNgayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DCTuNgayMouseClicked

    private void DCDenNgayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCDenNgayMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DCDenNgayMouseMoved

    private void DCDenNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCDenNgayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DCDenNgayMouseClicked

    private void xuatExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExcelFileActionPerformed
        try {
            XuatExcel xuat = new XuatExcel(tblTimNangCao, columnNames, "Hoá Đơn");
        } catch (IOException ex) {
            Logger.getLogger(TimNangCaoFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xuatExcelFileActionPerformed

    private void tblTimNangCaoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTimNangCaoMouseReleased
        if(evt.isPopupTrigger())
        {
            rightClickMenu.show(tblTimNangCao, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblTimNangCaoMouseReleased

    private void nhapExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExcelFileActionPerformed
        // TODO add your handling code here:
        nhapExcel nhap = new nhapExcel(tblTimNangCao);
        DefaultTableModel newModel = nhap.importExcel();
        if (newModel.getRowCount() > 0) {
            tblTimNangCao.setModel(newModel);
            tblTimNangCao = initHeaderColor(tblTimNangCao, 14, 142, 233);
        }
    }//GEN-LAST:event_nhapExcelFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Bang;
    private javax.swing.JRadioButton BeHonBang;
    private com.toedter.calendar.JDateChooser DCDenNgay;
    private com.toedter.calendar.JDateChooser DCTuNgay;
    private javax.swing.JRadioButton LonHonBang;
    private javax.swing.ButtonGroup SoSanh;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> comboBoxCotCuaBang;
    private javax.swing.JComboBox<String> comboBoxTenBang;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblNumData;
    private javax.swing.JLabel lblTenBang;
    private javax.swing.JLabel lblTenCotCuaBang;
    private javax.swing.JLabel lblTextData;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JMenuItem nhapExcelFile;
    private javax.swing.JPanel pnlDateData;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNumberData;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTextData;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTable tblTimNangCao;
    private javax.swing.JTextField txtNumData;
    private javax.swing.JTextField txtTextData;
    private javax.swing.JMenuItem xuatExcelFile;
    // End of variables declaration//GEN-END:variables
}
