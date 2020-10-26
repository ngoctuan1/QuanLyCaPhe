/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package Project;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author tt
 */
public class ShopForm extends javax.swing.JFrame {

    /**
     * Creates new form QLSVForm
     */
    Color  matteBlue = new Color(14,142,233);  
    Color  matteGrey = new Color(223,230,233);
    Color  normalBlack = new Color(51,51,51);
    private CardLayout cardLayout;
    private CardLayout leftMenuCardLayout;

    ThongKeFRM thk = new ThongKeFRM();
    SanPhamFRM sp = new SanPhamFRM(this);
    HoaDonFRM hd = new HoaDonFRM(this);
    DangNhapFRM login = new DangNhapFRM();
    PhieuNhapFRM pn = new PhieuNhapFRM(this);
    LoaiSPFRM lsp = new LoaiSPFRM(sp); 
    KhachHangFRM kh = new KhachHangFRM(this);
    NhaCungCapFRM ncc = new NhaCungCapFRM(pn);
    NhaSanXuatFRM nsx = new NhaSanXuatFRM(sp);
    TaiKhoanFRM tk = new TaiKhoanFRM();
    KhuyenMaiFRM km = new KhuyenMaiFRM();
    NhanVienFRM nv = new NhanVienFRM(pn,tk,hd);
    TimNangCaoFRM tnc = new TimNangCaoFRM();
        
    leftMenuAdmin admin = new leftMenuAdmin(this);
    TrangChuFRM tc = new TrangChuFRM(this,admin);
    leftMenuQuanLy quanLy = new leftMenuQuanLy(this);
    TrangChuFRMQuanLy tcQuanLy = new TrangChuFRMQuanLy(this,quanLy);
    leftMenuNhanVien nhanVien = new leftMenuNhanVien(this);
    TrangChuFRMNhanVien tcNhanVien = new TrangChuFRMNhanVien(this,nhanVien);
    
    String Quyen;
    String Username;
    public ShopForm() throws Exception
    {   
        System.out.println("Chạy thử với quyền admin");
        setTitle("Shop Thời Trang"); 
        initComponents(); 
        
        themPnlVaoCard();
        initIcon();
        lblThuNho.setText("\u2012");
        lblThoat.setText("\u0078");
        menuScrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
        change("Trang Chủ");
        leftMenuCardLayout.show(pnlLeftMenu, "adminMenu");
    }
    
     public ShopForm(String Quyen,String Username) throws Exception
    {   
        this.Quyen = Quyen;
        this.Username = Username;
        initComponents();       
        themPnlVaoCard();
        LblTenDangNhap.setText(Username);
        switch (Quyen)
        {
            case "Admin" : 
            {   
                admin = new leftMenuAdmin(this);
                tc = new TrangChuFRM(this,admin);
                change("Trang Chủ");
                
            };
            break;
            
            case "Quản Lý" :
            {   
                quanLy = new leftMenuQuanLy(this);
                tcQuanLy = new TrangChuFRMQuanLy(this,quanLy);
                change("Quản Lý");
            };    
            break;
            
            case "Nhân Viên" :
            {   
                nhanVien = new leftMenuNhanVien(this);
                tcNhanVien = new TrangChuFRMNhanVien(this,nhanVien);
                change("Nhân_Viên");
            }; 
            break;
        }
        
        setTitle("Shop Thời Trang");    
        initIcon();
        lblThuNho.setText("\u2012");
        lblThoat.setText("\u0078");
        menuScrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
    }
    
    public void change(String str)
    {
        switch(str)
        {
            case "Bán hàng":
            {      
                cardLayout.show(pnlData, "hoaDonForm");
                break;
            }    
            case "Nhập Hàng": 
            {       
                cardLayout.show(pnlData, "phieuNhapForm");
                break;
            }   
            case "Sản Phẩm": 
            {       
                cardLayout.show(pnlData, "sanPhamForm");
                break;
            }   
            case "Loại Sản Phẩm":
            {
                cardLayout.show(pnlData, "loaiSanPhamForm");
                break;
            }   
            case "Nhân Viên": 
            {
                cardLayout.show(pnlData, "nhanVienForm");
                break;
            }   
            case "Khách Hàng": 
            {
                cardLayout.show(pnlData, "khachHangForm");
                break;
            }   
            case "Nhà Cung Cấp": 
            {
                cardLayout.show(pnlData, "nhaCungCapForm");
                break;
            }   
            case "Nhà Sản Xuất": 
            {
                cardLayout.show(pnlData, "nhaSanXuatForm");
                break;
            }   
            case "Khuyến Mãi": 
            {
                cardLayout.show(pnlData, "khuyenMaiForm");
                break;
            }    
            case "Tài Khoản": 
            {
                cardLayout.show(pnlData, "taiKhoanForm");
                break;
            }
            case "Thống Kê": 
            {
                cardLayout.show(pnlData, "thongKeForm");
                break;
            }
            case "Tìm Nâng Cao": 
            {
                cardLayout.show(pnlData,"timNangCaoForm");
                break;
            }
            case "Trang Chủ": 
            {   
                leftMenuCardLayout.show(pnlLeftMenu, "adminMenu");
                cardLayout.show(pnlData, "trangChuForm");
                btnBack.setIcon(null);
                   
            }
            break;
            
            case "Quản Lý": 
            {   
                leftMenuCardLayout.show(pnlLeftMenu, "quanLyMenu");
                cardLayout.show(pnlData, "trangChuFormQuanLy");
                btnBack.setIcon(null);
                  
            }
            break;
            
            case "Nhân_Viên": 
            {   
                leftMenuCardLayout.show(pnlLeftMenu, "nhanVienMenu");
                cardLayout.show(pnlData, "trangChuFormNhanVien");
                btnBack.setIcon(null);
                  
            }
            break;
        }
    }
    
    void themPnlVaoCard() throws Exception
    {
        cardLayout = (CardLayout) (pnlData.getLayout());
        pnlData.add(tc, "trangChuForm");
        pnlData.add(tcQuanLy, "trangChuFormQuanLy");
        pnlData.add(tcNhanVien, "trangChuFormNhanVien");
        
        pnlData.add(hd, "hoaDonForm");
        pnlData.add(pn, "phieuNhapForm");
        pnlData.add(sp, "sanPhamForm");
        pnlData.add(lsp, "loaiSanPhamForm"); 
        pnlData.add(nv, "nhanVienForm");
        pnlData.add(kh, "khachHangForm");
        pnlData.add(ncc, "nhaCungCapForm");
        pnlData.add(nsx, "nhaSanXuatForm");
        pnlData.add(tk, "taiKhoanForm"); 
        pnlData.add(km, "khuyenMaiForm");
        pnlData.add(thk, "thongKeForm");
        pnlData.add(tnc, "timNangCaoForm");
        
        leftMenuCardLayout = (CardLayout) (pnlLeftMenu.getLayout());
        pnlLeftMenu.add(admin, "adminMenu");
        pnlLeftMenu.add(quanLy, "quanLyMenu");
        pnlLeftMenu.add(nhanVien, "nhanVienMenu");
    }
    
    public void setReturnIcon()
    {
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/return_icon_white.png")));
    }
    
    public void initIcon()
    {
        ImageIcon logo = new ImageIcon(getClass().getResource("/img/logo.png"));
        logo = scale(logo,50,50);
        lblLogo.setIcon(logo);
    }
    
    public ImageIcon scale(ImageIcon icon,int width, int height)
    {
        Image temp = icon.getImage();
        Image temp2 = temp.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        icon = new ImageIcon();
        icon.setImage(temp2);
        return icon;
    }
    
    public HoaDonFRM getHoaDonFRM()
    {
        return this.hd;
    }
    
    public SanPhamFRM getSanPhamFRM()
    {
        return this.sp;
    }
    
    public PhieuNhapFRM getPhieuNhapFRM()
    {
        return this.pn;
    }
    
    public ThongKeFRM getThongKeFRM()
    {
        return this.thk;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        pnlMain = new javax.swing.JPanel();
        pnlData = new javax.swing.JPanel();
        lblBar = new javax.swing.JLabel();
        lblThuNho = new javax.swing.JLabel();
        lblThoat = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        pnlHello = new javax.swing.JPanel();
        LblAnhDaiDien = new javax.swing.JLabel();
        LblXinChao = new javax.swing.JLabel();
        LblTenDangNhap = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        menuScrollPane = new javax.swing.JScrollPane();
        pnlLeftMenu = new javax.swing.JPanel();
        pnlFooter = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Shop Thời Trang");
        setUndecorated(true);

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setDividerSize(0);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(874, 594));

        pnlMain.setBackground(new java.awt.Color(255, 255, 255));
        pnlMain.setPreferredSize(new java.awt.Dimension(679, 592));

        pnlData.setBackground(new java.awt.Color(255, 255, 255));
        pnlData.setPreferredSize(new java.awt.Dimension(679, 562));
        pnlData.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                pnlDataComponentAdded(evt);
            }
        });
        pnlData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnlDataMouseReleased(evt);
            }
        });
        pnlData.setLayout(new java.awt.CardLayout());

        lblBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                lblBarMouseDragged(evt);
            }
        });
        lblBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblBarMousePressed(evt);
            }
        });

        lblThuNho.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblThuNho.setForeground(new java.awt.Color(14, 142, 233));
        lblThuNho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThuNho.setText("-");
        lblThuNho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThuNhoMouseClicked(evt);
            }
        });

        lblThoat.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblThoat.setForeground(new java.awt.Color(14, 142, 233));
        lblThoat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblThoat.setText("x");
        lblThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThoatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addComponent(lblBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(lblThuNho, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(lblThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblThuNho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(pnlData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setRightComponent(pnlMain);

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setMinimumSize(new java.awt.Dimension(170, 592));
        leftPanel.setPreferredSize(new java.awt.Dimension(170, 592));

        LblAnhDaiDien.setBackground(new java.awt.Color(14, 142, 233));
        LblAnhDaiDien.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        LblAnhDaiDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avatar_icon.png"))); // NOI18N
        LblAnhDaiDien.setOpaque(true);

        LblXinChao.setBackground(new java.awt.Color(14, 142, 233));
        LblXinChao.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        LblXinChao.setForeground(new java.awt.Color(255, 255, 255));
        LblXinChao.setText("Xin chào,");
        LblXinChao.setOpaque(true);

        LblTenDangNhap.setBackground(new java.awt.Color(14, 142, 233));
        LblTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        LblTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        LblTenDangNhap.setText("William");
        LblTenDangNhap.setOpaque(true);

        btnBack.setBackground(new java.awt.Color(14, 142, 233));
        btnBack.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(14, 142, 233));
        btnBack.setBorder(null);
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBack.setOpaque(true);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHelloLayout = new javax.swing.GroupLayout(pnlHello);
        pnlHello.setLayout(pnlHelloLayout);
        pnlHelloLayout.setHorizontalGroup(
            pnlHelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelloLayout.createSequentialGroup()
                .addComponent(LblAnhDaiDien)
                .addGap(0, 0, 0)
                .addGroup(pnlHelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LblXinChao, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(LblTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlHelloLayout.setVerticalGroup(
            pnlHelloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelloLayout.createSequentialGroup()
                .addComponent(LblAnhDaiDien)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlHelloLayout.createSequentialGroup()
                .addComponent(LblXinChao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(LblTenDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuScrollPane.setBorder(null);
        menuScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        menuScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        pnlLeftMenu.setBackground(new java.awt.Color(255, 255, 255));
        pnlLeftMenu.setLayout(new java.awt.CardLayout());
        menuScrollPane.setViewportView(pnlLeftMenu);

        pnlFooter.setBackground(new java.awt.Color(255, 255, 255));
        pnlFooter.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(204, 204, 204)));

        lblLogo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogo.setText("Nexus");
        lblLogo.setIconTextGap(10);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("@ 2020 All Rights Reserved");

        lblLogout.setFont(new java.awt.Font("SansSerif", 1, 10)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(234, 32, 39));
        lblLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logout_icon.png"))); // NOI18N
        lblLogout.setText("Đăng xuất");
        lblLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogout.setIconTextGap(8);
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblLogoutMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogout)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlHello, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(pnlFooter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
                .addComponent(pnlHello, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(menuScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setLeftComponent(leftPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblThuNhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuNhoMouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_lblThuNhoMouseClicked

    private void lblThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThoatMouseClicked
        // TODO add your handling code here:
       System.exit(0);
        
    }//GEN-LAST:event_lblThoatMouseClicked

    private void lblBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBarMousePressed

    private void lblBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBarMouseDragged
        // TODO add your handling code here:
        setLocation (evt.getXOnScreen()-(getWidth()/2),evt.getYOnScreen()-10);
    }//GEN-LAST:event_lblBarMouseDragged

    private void pnlDataMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDataMouseReleased
        // TODO add your handling code here:
      
    }//GEN-LAST:event_pnlDataMouseReleased

    private void pnlDataComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_pnlDataComponentAdded
        // TODO add your handling code here:
        
    }//GEN-LAST:event_pnlDataComponentAdded

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        try {         
            tc = new TrangChuFRM(this,admin);
            tcQuanLy = new TrangChuFRMQuanLy(this, quanLy);
            tcNhanVien = new TrangChuFRMNhanVien(this,nhanVien);
            themPnlVaoCard();
        } catch (Exception ex) {
            Logger.getLogger(ShopForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (Quyen != null)
        {
            switch (Quyen)
            {
                case "Admin" : 
                {
                    cardLayout.show(pnlData, "trangChuForm");
                    btnBack.setIcon(null);
                    btnBack.setEnabled(true);                 
                };
                break;

                case "Quản Lý" : 
                {
                    cardLayout.show(pnlData, "trangChuFormQuanLy");
                    btnBack.setIcon(null);
                    btnBack.setEnabled(true);
 
                };
                break;
                
                case "Nhân Viên" : 
                {
                    cardLayout.show(pnlData, "trangChuFormNhanVien");
                    btnBack.setIcon(null);
                    btnBack.setEnabled(true);
 
                };
                break;
            }
        } 
        else // DUNG DE CHAY KHI KHONG DANG NHAP
        {
            cardLayout.show(pnlData, "trangChuForm");
            btnBack.setIcon(null);
            btnBack.setEnabled(true);
            
            try {
                  tc.setLabel();
            } catch (Exception ex) {
              Logger.getLogger(ShopForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
   
        login = new DangNhapFRM();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void lblLogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseEntered
        // TODO add your handling code here:
      
    }//GEN-LAST:event_lblLogoutMouseEntered

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
            java.util.logging.Logger.getLogger(ShopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShopForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new ShopForm().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ShopForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblAnhDaiDien;
    private javax.swing.JLabel LblTenDangNhap;
    private javax.swing.JLabel LblXinChao;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblBar;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblThoat;
    private javax.swing.JLabel lblThuNho;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JScrollPane menuScrollPane;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlFooter;
    private javax.swing.JPanel pnlHello;
    private javax.swing.JPanel pnlLeftMenu;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
