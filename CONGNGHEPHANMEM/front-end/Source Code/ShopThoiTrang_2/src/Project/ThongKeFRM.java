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
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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
public class ThongKeFRM extends javax.swing.JPanel {
    Color  matteBlue = new Color(14,142,233);  
    Color  matteGrey = new Color(223,230,233);
    Color  normalBlack = new Color(51,51,51);
    
    private CardLayout cardLayout;
    /**
     * Creates new form ThongKeFRM
     */
    public ThongKeFRM() throws Exception {
        initComponents();
        initIcon();
        DCTuNgay = myDateChooser(DCTuNgay);
        DCDenNgay = myDateChooser(DCDenNgay);
        comboBoxHinhThuc = myComboBox(comboBoxHinhThuc, matteGrey);
        comboBoxMaKH = myComboBox(comboBoxMaKH, matteGrey);
        comboBoxMaSP = myComboBox(comboBoxMaSP, matteGrey);
        docComboBox();
        tblThongKe = initHeaderColor(tblThongKe,14,142,233);
        cardLayout = (CardLayout) (pnlThongTin.getLayout());
        changePnlInfo(comboBoxHinhThuc.getSelectedItem().toString());
    }
    
    public void docComboBox() throws  Exception{
        KhachHangBUS busKH = new  KhachHangBUS();
        SanPhamBUS busSP = new SanPhamBUS();
        
        String [] arrayMaKH = busKH.docComboBoxMaKH();
        comboBoxMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(arrayMaKH));
        comboBoxMaKH = myComboBox(comboBoxMaKH,matteGrey);   

        String [] arrayMaSP = busSP.docComboBoxMaSP();   
        comboBoxMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(arrayMaSP));
        comboBoxMaSP = myComboBox(comboBoxMaSP,matteGrey);
    }
        
    public void docComboBoxKH(String ma[]) throws  Exception{
        comboBoxMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(ma));
    }
    
    public void docComboBoxSP(String ma[]) throws  Exception{
        comboBoxMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(ma));
    }    
    
     public void resetTxt() throws Exception {
        DCTuNgay.setDate(null);
        DCDenNgay.setDate(null);
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
    
         public void initIcon()
    {
        ImageIcon logo = new ImageIcon(getClass().getResource("/img/chart_icon_white.png"));
        logo = scale(logo,21,21);
        btnThongKe.setIcon(logo);
    }
    
    public ImageIcon scale(ImageIcon icon,int width, int height)
    {
        Image temp = icon.getImage();
        Image temp2 = temp.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon();
        icon.setImage(temp2);
        return icon;
    }
    
    public boolean checkEmptyTxt() {
        if (DCTuNgay.getDate() == null || DCDenNgay.getDate() == null)
        {
            return true;
        }
        return false;
    }
    
    public void changePnlInfo(String option)
    {
        switch(option)
        {
            case "Từ ngày đến ngày" :
                cardLayout.show(pnlThongTin, "pnlDate");
                break;
            case "Khách hàng và Sản phẩm" :
                cardLayout.show(pnlThongTin, "pnlComboBox");
                break;
        }
    }
    
    boolean isWithinDateRange(Date date) {
        Date startDate = DCTuNgay.getDate();
        Date endDate = DCDenNgay.getDate();
        
        return date.after(startDate) && date.before(endDate);
    }
    
    public float tinhTongCong(DefaultTableModel model)
    {
        float sum = 0;
        int columnNamePos = -1;
        for(int i = 0; i < model.getColumnCount(); ++i)
        {
            if(model.getColumnName(i).equals("Thành tiền"))
            {
                columnNamePos = i;
                break;
            }
        }
        
        for(int i = 0; i < model.getRowCount(); ++i)
        {
            sum += Float.parseFloat(model.getValueAt(i, columnNamePos).toString());
        }
        
        return sum;
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
        btnThongKe = new javax.swing.JButton();
        pnlThongTin = new javax.swing.JPanel();
        pnlThongTinNgay = new javax.swing.JPanel();
        lbl1 = new javax.swing.JLabel();
        DCTuNgay = new com.toedter.calendar.JDateChooser();
        lbl2 = new javax.swing.JLabel();
        DCDenNgay = new com.toedter.calendar.JDateChooser();
        pnlThongTinComboxBox = new javax.swing.JPanel();
        lblMaKH = new javax.swing.JLabel();
        lblMaSP = new javax.swing.JLabel();
        comboBoxMaKH = new javax.swing.JComboBox<>();
        comboBoxMaSP = new javax.swing.JComboBox<>();
        comboBoxHinhThuc = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        pnlTable = new javax.swing.JPanel();
        tblScrollPane = new javax.swing.JScrollPane();
        tblThongKe = new javax.swing.JTable();

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
        lblTieuDe.setText("Thống Kê");
        lblTieuDe.setOpaque(true);

        btnThongKe.setBackground(new java.awt.Color(14, 142, 233));
        btnThongKe.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống kê");
        btnThongKe.setBorder(null);
        btnThongKe.setContentAreaFilled(false);
        btnThongKe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThongKe.setIconTextGap(15);
        btnThongKe.setOpaque(true);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        pnlThongTin.setOpaque(false);
        pnlThongTin.setLayout(new java.awt.CardLayout());

        pnlThongTinNgay.setOpaque(false);

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

        javax.swing.GroupLayout pnlThongTinNgayLayout = new javax.swing.GroupLayout(pnlThongTinNgay);
        pnlThongTinNgay.setLayout(pnlThongTinNgayLayout);
        pnlThongTinNgayLayout.setHorizontalGroup(
            pnlThongTinNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlThongTinNgayLayout.createSequentialGroup()
                        .addComponent(lbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DCTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlThongTinNgayLayout.createSequentialGroup()
                        .addComponent(lbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DCDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        pnlThongTinNgayLayout.setVerticalGroup(
            pnlThongTinNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl1)
                    .addComponent(DCTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(pnlThongTinNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl2)
                    .addComponent(DCDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pnlThongTin.add(pnlThongTinNgay, "pnlDate");

        pnlThongTinComboxBox.setOpaque(false);

        lblMaKH.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblMaKH.setText("Mã khách hàng:");

        lblMaSP.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblMaSP.setText("Mã sản phẩm");

        comboBoxMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboBoxMaSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout pnlThongTinComboxBoxLayout = new javax.swing.GroupLayout(pnlThongTinComboxBox);
        pnlThongTinComboxBox.setLayout(pnlThongTinComboxBoxLayout);
        pnlThongTinComboxBoxLayout.setHorizontalGroup(
            pnlThongTinComboxBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinComboxBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinComboxBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(lblMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlThongTinComboxBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboBoxMaKH, 0, 122, Short.MAX_VALUE)
                    .addComponent(comboBoxMaSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        pnlThongTinComboxBoxLayout.setVerticalGroup(
            pnlThongTinComboxBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlThongTinComboxBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlThongTinComboxBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKH)
                    .addComponent(comboBoxMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(pnlThongTinComboxBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaSP))
                .addGap(18, 18, 18))
        );

        pnlThongTin.add(pnlThongTinComboxBox, "pnlComboBox");

        comboBoxHinhThuc.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        comboBoxHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Từ ngày đến ngày", "Khách hàng và Sản phẩm" }));
        comboBoxHinhThuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxHinhThucItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("Hình thức thống kê:");

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(lblTieuDe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxHinhThuc))
                        .addGap(28, 28, 28)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));

        tblThongKe.setModel(new javax.swing.table.DefaultTableModel(
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
        tblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongKeMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblThongKeMouseReleased(evt);
            }
        });
        tblScrollPane.setViewportView(tblThongKe);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(tblScrollPane)
                .addGap(5, 5, 5))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(tblScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    DefaultTableModel model;
    
    public Vector createHeader(Object[] columnNames) {
        Vector header = new Vector();
        for (Object colName : columnNames) {
            header.add(colName);
        }

        return header;
    }
    
    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        if(comboBoxHinhThuc.getSelectedItem().toString().equals("Từ ngày đến ngày"))
        {
            if(checkEmptyTxt() == true)
            {
                JOptionPane.showMessageDialog(this, "Dữ liệu còn trống!");
                return;
            }
            boolean founded = false;
            String[] columnNames = {"Mã HĐ", "Mã KH", "Mã NV", "Ngày HĐ", "Tổng tiền", "Mã KM", "Thành tiền"};
            Vector header = createHeader(columnNames);
            model = new DefaultTableModel(header, 0);
            for(HoaDonDTO hd : HoaDonBUS.getDshd())
            {
                try {
                    if(isWithinDateRange(new SimpleDateFormat("yyyy-MM-dd").parse(hd.getNgayHD())))
                    {
                        founded = true;
                        
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
                } catch (ParseException ex) {
                    Logger.getLogger(ThongKeFRM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(founded)
            {
                Vector row = new Vector();
                row.add("");
                row.add("");
                row.add("");
                row.add("");
                row.add("");
                row.add("Tổng cộng:");
                row.add(String.valueOf(tinhTongCong(model)));
                model.addRow(row);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Rất tiếc. Dữ liệu không được tìm thấy!");
            }
        }
        else if(comboBoxHinhThuc.getSelectedItem().toString().equals("Khách hàng và Sản phẩm"))
        {
            boolean founded = false;
            String[] columnNames = {"Mã HĐ", "Mã KH", "Mã SP", "Số lượng", "Đơn giá", "Ngày HĐ", "Tổng tiền", "Mã KM", "Thành tiền"};
            Vector header = createHeader(columnNames);
            model = new DefaultTableModel(header, 0);
            
            String maKH = comboBoxMaKH.getSelectedItem().toString();
            String maSP = comboBoxMaSP.getSelectedItem().toString();
            for(HoaDonDTO hd : HoaDonBUS.getDshd())
            {
                if(hd.getMaKH().equals(maKH))
                {
                    ChiTietHDBUS cthdBus = new ChiTietHDBUS();
                    try {
                        cthdBus.docDSCTHD();
                    } catch (Exception ex) {
                        Logger.getLogger(ThongKeFRM.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ChiTietHDDTO cthd = null;
                    cthd = cthdBus.timCTHD(hd.getMaHD(), maSP);
                    if(cthd != null)
                    {
                        founded = true;
                        
                        Vector row = new Vector();
                        row.add(hd.getMaHD());
                        row.add(hd.getMaKH());
                        row.add(cthd.getMaSP());
                        row.add(cthd.getSoLuong());
                        row.add(cthd.getDonGia());
                        row.add(hd.getNgayHD());
                        row.add(cthd.getSoLuong() * cthd.getDonGia());
                        row.add(hd.getMaKM());
                        if(hd.getMaKM() == "")
                        {
                            row.add(cthd.getSoLuong() * cthd.getDonGia());
                        }
                        else
                        {
                            KhuyenMaiBUS kmBus = new KhuyenMaiBUS();
                            row.add(cthd.getSoLuong() * cthd.getDonGia() * kmBus.timKM(hd.getMaKM()).getPhanTramKhuyenMai());
                        }

                        model.addRow(row);
                    }
                }
            }
            
            if(founded)
            {
                Vector row = new Vector();
                row.add("");
                row.add("");
                row.add("");
                row.add("");
                row.add("");
                row.add("");
                row.add("");
                row.add("Tổng cộng:");
                row.add(tinhTongCong(model));
                model.addRow(row);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Rất tiếc. Dữ liệu không được tìm thấy!");
            }
        }
        
        tblThongKe.setModel(model);
        tblThongKe = initHeaderColor(tblThongKe, 14, 142, 233);
        
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void pnlMainMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlMainMouseMoved

    private void pnlMainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMainMouseClicked

    }//GEN-LAST:event_pnlMainMouseClicked

    private void tblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeMouseClicked
         
    }//GEN-LAST:event_tblThongKeMouseClicked

    private void DCTuNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCTuNgayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DCTuNgayMouseClicked

    private void DCTuNgayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCTuNgayMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DCTuNgayMouseMoved

    private void DCDenNgayMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCDenNgayMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_DCDenNgayMouseMoved

    private void DCDenNgayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DCDenNgayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DCDenNgayMouseClicked

    private void comboBoxHinhThucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxHinhThucItemStateChanged
        changePnlInfo(comboBoxHinhThuc.getSelectedItem().toString());
    }//GEN-LAST:event_comboBoxHinhThucItemStateChanged

    private void xuatExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatExcelFileActionPerformed
        String[] columnNames = null ;

        if(comboBoxHinhThuc.getSelectedItem().toString().equals("Từ ngày đến ngày"))
            columnNames = new String[]{"Mã HĐ", "Mã KH", "Mã NV", "Ngày HĐ", "Tổng tiền", "Mã KM", "Thành tiền"};
        else if(comboBoxHinhThuc.getSelectedItem().toString().equals("Khách hàng và Sản phẩm"))
            columnNames = new String[]{"Mã HĐ", "Mã KH", "Mã SP", "Số lượng", "Đơn giá", "Ngày HĐ", "Tổng tiền", "Mã KM", "Thành tiền"};
        
        try {
            XuatExcel xuat = new XuatExcel(tblThongKe, columnNames, "Chi Tiết Thống Kê");
        } catch (IOException ex) {
            Logger.getLogger(ThongKeFRM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xuatExcelFileActionPerformed

    private void tblThongKeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeMouseReleased
        if(evt.isPopupTrigger())
        {
            rightClickMenu.show(tblThongKe, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tblThongKeMouseReleased

    private void nhapExcelFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nhapExcelFileActionPerformed
        // TODO add your handling code here:
        nhapExcel nhap = new nhapExcel(tblThongKe);
        DefaultTableModel newModel = nhap.importExcel();
        if (newModel.getRowCount() > 0) {
            tblThongKe.setModel(newModel);
            tblThongKe = initHeaderColor(tblThongKe, 14, 142, 233);
        }
    }//GEN-LAST:event_nhapExcelFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCDenNgay;
    private com.toedter.calendar.JDateChooser DCTuNgay;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> comboBoxHinhThuc;
    private javax.swing.JComboBox<String> comboBoxMaKH;
    private javax.swing.JComboBox<String> comboBoxMaSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblMaSP;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JMenuItem nhapExcelFile;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlThongTin;
    private javax.swing.JPanel pnlThongTinComboxBox;
    private javax.swing.JPanel pnlThongTinNgay;
    private javax.swing.JPopupMenu rightClickMenu;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTable tblThongKe;
    private javax.swing.JMenuItem xuatExcelFile;
    // End of variables declaration//GEN-END:variables
}
