USE [master]
GO
/****** Object:  Database [QL_coffe]    Script Date: 11/14/2020 11:14:20 AM ******/
CREATE DATABASE [QL_coffe]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QL_coffe', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QL_coffe.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QL_coffe_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QL_coffe_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QL_coffe] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QL_coffe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QL_coffe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QL_coffe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QL_coffe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QL_coffe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QL_coffe] SET ARITHABORT OFF 
GO
ALTER DATABASE [QL_coffe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QL_coffe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QL_coffe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QL_coffe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QL_coffe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QL_coffe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QL_coffe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QL_coffe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QL_coffe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QL_coffe] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QL_coffe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QL_coffe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QL_coffe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QL_coffe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QL_coffe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QL_coffe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QL_coffe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QL_coffe] SET RECOVERY FULL 
GO
ALTER DATABASE [QL_coffe] SET  MULTI_USER 
GO
ALTER DATABASE [QL_coffe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QL_coffe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QL_coffe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QL_coffe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QL_coffe] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'QL_coffe', N'ON'
GO
ALTER DATABASE [QL_coffe] SET QUERY_STORE = OFF
GO
USE [QL_coffe]
GO
/****** Object:  Table [dbo].[tblcalam]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblcalam](
	[MaCaLam] [varchar](10) NOT NULL,
	[TinhTrang] [nchar](10) NULL,
	[CaLam] [varchar](20) NULL,
 CONSTRAINT [PK_tblcalam] PRIMARY KEY CLUSTERED 
(
	[MaCaLam] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblchitiethd]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblchitiethd](
	[MaHD] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [varchar](30) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
 CONSTRAINT [PK_tblchitiethd] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblchitiethdtra]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblchitiethdtra](
	[MaTraHang] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [varchar](50) NOT NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[LyDo] [varchar](50) NULL,
 CONSTRAINT [PK_tblchitiethdtra] PRIMARY KEY CLUSTERED 
(
	[MaTraHang] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblchitietpn]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblchitietpn](
	[MaPN] [varchar](10) NOT NULL,
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [varchar](50) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
 CONSTRAINT [PK_tblchitiet] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC,
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblchucvu]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblchucvu](
	[MaChucVu] [varchar](10) NOT NULL,
	[TinhTrang] [nchar](10) NULL,
	[ChucVu] [varchar](20) NULL,
 CONSTRAINT [PK_tblchucvu] PRIMARY KEY CLUSTERED 
(
	[MaChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblcongno]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblcongno](
	[MaCongNo] [varchar](10) NOT NULL,
	[MaTraHang] [varchar](10) NULL,
	[NgayGhiNo] [date] NULL,
	[MaNCC] [varchar](10) NOT NULL,
	[NoiDung] [varchar](50) NULL,
	[TrangThai] [varchar](30) NULL,
 CONSTRAINT [PK_tblcongno_1] PRIMARY KEY CLUSTERED 
(
	[MaCongNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblhoadon]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblhoadon](
	[MaHD] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NULL,
	[NgayHD] [date] NULL,
	[TongTien] [float] NULL,
	[MaKM] [varchar](10) NULL,
	[MaKH] [varchar](10) NULL,
	[TrangThai] [varchar](30) NULL,
	[DiemTichLuyTang] [int] NULL,
 CONSTRAINT [PK_tblhoadon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblhoadondat]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblhoadondat](
	[MaDatHang] [varchar](10) NOT NULL,
	[MaNV] [varchar](10) NULL,
	[MaNCC] [varchar](10) NULL,
	[NgayDatHang] [date] NULL,
	[TrangThai] [int] NULL,
 CONSTRAINT [PK_HoaDonDat] PRIMARY KEY CLUSTERED 
(
	[MaDatHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblhoadontra]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblhoadontra](
	[MaTraHang] [varchar](10) NOT NULL,
	[MaPN] [varchar](10) NULL,
	[MaNV] [varchar](10) NULL,
	[NgayTra] [date] NULL,
	[TrangThai] [int] NULL,
 CONSTRAINT [PK_tblhoadontra] PRIMARY KEY CLUSTERED 
(
	[MaTraHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblkhachhang]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblkhachhang](
	[MaKH] [varchar](10) NOT NULL,
	[Ho] [varchar](20) NULL,
	[Ten] [varchar](10) NULL,
	[DiaChi] [varchar](100) NULL,
	[DiemTichLuy] [int] NULL,
	[SoDT] [varchar](11) NULL,
 CONSTRAINT [PK_tblkhachhang] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblkhuyenmai]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblkhuyenmai](
	[MaKM] [varchar](10) NOT NULL,
	[TenKM] [varchar](30) NULL,
	[GiaDHToiThieu] [float] NULL,
	[NgayBatDau] [date] NULL,
	[NgayKetThuc] [date] NULL,
	[phanTramKhuyenMai] [float] NULL,
	[TrangThai] [int] NULL,
 CONSTRAINT [PK_tblkhuyenmai] PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblloaisp]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblloaisp](
	[MaLSP] [varchar](10) NOT NULL,
	[TenLSP] [varchar](50) NULL,
 CONSTRAINT [PK_tblloaisp] PRIMARY KEY CLUSTERED 
(
	[MaLSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblnhacungcap]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblnhacungcap](
	[MaNCC] [varchar](10) NOT NULL,
	[TenNCC] [varchar](20) NULL,
	[SoDT] [varchar](11) NULL,
	[Email] [nchar](10) NOT NULL,
	[DiaChi] [varchar](100) NULL,
	[TinhTrang] [int] NOT NULL,
 CONSTRAINT [PK_tblnhacungcap] PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblnhanvien]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblnhanvien](
	[MaNV] [varchar](10) NOT NULL,
	[Ho] [varchar](20) NULL,
	[Ten] [varchar](10) NULL,
	[GioiTinh] [bit] NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [varchar](100) NULL,
	[SoDT] [varchar](10) NULL,
	[MaChucVu] [varchar](10) NOT NULL,
	[MaCaLam] [varchar](10) NOT NULL,
	[TinhTrang] [int] NOT NULL,
 CONSTRAINT [PK_tblnhanvien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblphieunhap]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblphieunhap](
	[MaNCC] [varchar](10) NULL,
	[MaDatHang] [varchar](10) NULL,
	[MaNV] [varchar](10) NULL,
	[NgayNhap] [date] NULL,
	[MaPN] [varchar](10) NOT NULL,
	[TongTien] [float] NULL,
 CONSTRAINT [PK_tblphieunhap] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblsanpham]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblsanpham](
	[MaSP] [varchar](10) NOT NULL,
	[TenSP] [varchar](100) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[MaLSP] [varchar](10) NULL,
	[TinhTrang] [varchar](10) NULL,
 CONSTRAINT [PK_tblsanpham] PRIMARY KEY CLUSTERED 
(
	[MaSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbltaikhoan]    Script Date: 11/14/2020 11:14:20 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbltaikhoan](
	[MaNV] [varchar](10) NOT NULL,
	[TenDangNhap] [varchar](30) NULL,
	[MatKhau] [varchar](30) NULL,
	[TinhTrang] [int] NULL,
	[Quyen] [varchar](20) NULL,
 CONSTRAINT [PK_tbltaikhoan] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblhoadon] ADD  CONSTRAINT [DF__tblhoadon__MaNV__2A4B4B5E]  DEFAULT (NULL) FOR [MaNV]
GO
ALTER TABLE [dbo].[tblhoadon] ADD  CONSTRAINT [DF__tblhoadon__NgayH__2B3F6F97]  DEFAULT (NULL) FOR [NgayHD]
GO
ALTER TABLE [dbo].[tblhoadon] ADD  CONSTRAINT [DF__tblhoadon__TongT__2C3393D0]  DEFAULT ((0)) FOR [TongTien]
GO
ALTER TABLE [dbo].[tblhoadon] ADD  CONSTRAINT [DF__tblhoadon__MaKM__2D27B809]  DEFAULT (NULL) FOR [MaKM]
GO
ALTER TABLE [dbo].[tblhoadon] ADD  CONSTRAINT [DF__tblhoadon__MaKH__29572725]  DEFAULT (NULL) FOR [MaKH]
GO
ALTER TABLE [dbo].[tblkhachhang] ADD  CONSTRAINT [DF__tblkhachhang__Ho__300424B4]  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[tblkhachhang] ADD  CONSTRAINT [DF__tblkhachhan__Ten__30F848ED]  DEFAULT (NULL) FOR [Ten]
GO
ALTER TABLE [dbo].[tblkhachhang] ADD  CONSTRAINT [DF__tblkhachh__DiaCh__31EC6D26]  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[tblkhachhang] ADD  CONSTRAINT [DF__tblkhachha__SoDT__32E0915F]  DEFAULT (NULL) FOR [SoDT]
GO
ALTER TABLE [dbo].[tblkhuyenmai] ADD  CONSTRAINT [DF__tblkhuyen__TenKM__34C8D9D1]  DEFAULT (NULL) FOR [TenKM]
GO
ALTER TABLE [dbo].[tblkhuyenmai] ADD  CONSTRAINT [DF__tblkhuyen__GiaDH__35BCFE0A]  DEFAULT (NULL) FOR [GiaDHToiThieu]
GO
ALTER TABLE [dbo].[tblkhuyenmai] ADD  CONSTRAINT [DF__tblkhuyen__NgayB__36B12243]  DEFAULT (NULL) FOR [NgayBatDau]
GO
ALTER TABLE [dbo].[tblkhuyenmai] ADD  CONSTRAINT [DF__tblkhuyen__NgayK__37A5467C]  DEFAULT (NULL) FOR [NgayKetThuc]
GO
ALTER TABLE [dbo].[tblkhuyenmai] ADD  CONSTRAINT [DF__tblkhuyen__PhanT__38996AB5]  DEFAULT (NULL) FOR [TrangThai]
GO
ALTER TABLE [dbo].[tblloaisp] ADD  DEFAULT (NULL) FOR [TenLSP]
GO
ALTER TABLE [dbo].[tblnhacungcap] ADD  CONSTRAINT [DF__tblnhacun__TenNC__3D5E1FD2]  DEFAULT (NULL) FOR [TenNCC]
GO
ALTER TABLE [dbo].[tblnhacungcap] ADD  CONSTRAINT [DF__tblnhacung__SoDT__3E52440B]  DEFAULT (NULL) FOR [SoDT]
GO
ALTER TABLE [dbo].[tblnhacungcap] ADD  CONSTRAINT [DF__tblnhacun__DiaCh__3F466844]  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[tblnhanvien] ADD  CONSTRAINT [DF__tblnhanvien__Ho__412EB0B6]  DEFAULT (NULL) FOR [Ho]
GO
ALTER TABLE [dbo].[tblnhanvien] ADD  CONSTRAINT [DF__tblnhanvien__Ten__4222D4EF]  DEFAULT (NULL) FOR [Ten]
GO
ALTER TABLE [dbo].[tblnhanvien] ADD  CONSTRAINT [DF__tblnhanvi__GioiT__4316F928]  DEFAULT (NULL) FOR [GioiTinh]
GO
ALTER TABLE [dbo].[tblnhanvien] ADD  CONSTRAINT [DF__tblnhanvi__NgayS__440B1D61]  DEFAULT (NULL) FOR [NgaySinh]
GO
ALTER TABLE [dbo].[tblnhanvien] ADD  CONSTRAINT [DF__tblnhanvi__DiaCh__44FF419A]  DEFAULT (NULL) FOR [DiaChi]
GO
ALTER TABLE [dbo].[tblphieunhap] ADD  CONSTRAINT [DF__tblphieun__MaNCC__48CFD27E]  DEFAULT (NULL) FOR [MaNCC]
GO
ALTER TABLE [dbo].[tblphieunhap] ADD  CONSTRAINT [DF__tblphieunh__MaNV__47DBAE45]  DEFAULT (NULL) FOR [MaNV]
GO
ALTER TABLE [dbo].[tblphieunhap] ADD  CONSTRAINT [DF__tblphieun__NgayN__49C3F6B7]  DEFAULT (NULL) FOR [NgayNhap]
GO
ALTER TABLE [dbo].[tblphieunhap] ADD  CONSTRAINT [DF__tblphieun__TongT__4AB81AF0]  DEFAULT ((0)) FOR [TongTien]
GO
ALTER TABLE [dbo].[tblsanpham] ADD  CONSTRAINT [DF__tblsanpha__TenSP__4CA06362]  DEFAULT (NULL) FOR [TenSP]
GO
ALTER TABLE [dbo].[tblsanpham] ADD  CONSTRAINT [DF__tblsanpha__SoLuo__4D94879B]  DEFAULT (NULL) FOR [SoLuong]
GO
ALTER TABLE [dbo].[tblsanpham] ADD  CONSTRAINT [DF__tblsanpha__DonGi__4E88ABD4]  DEFAULT (NULL) FOR [DonGia]
GO
ALTER TABLE [dbo].[tblsanpham] ADD  CONSTRAINT [DF__tblsanpha__MaLSP__4F7CD00D]  DEFAULT (NULL) FOR [TinhTrang]
GO
ALTER TABLE [dbo].[tbltaikhoan] ADD  CONSTRAINT [DF__tbltaikho__TenDa__5165187F]  DEFAULT (NULL) FOR [TenDangNhap]
GO
ALTER TABLE [dbo].[tbltaikhoan] ADD  CONSTRAINT [DF__tbltaikho__MatKh__52593CB8]  DEFAULT (NULL) FOR [MatKhau]
GO
ALTER TABLE [dbo].[tbltaikhoan] ADD  CONSTRAINT [DF__tbltaikho__Quyen__534D60F1]  DEFAULT (NULL) FOR [Quyen]
GO
ALTER TABLE [dbo].[tblchitiethd]  WITH CHECK ADD  CONSTRAINT [FK_tblchitiethd_tblhoadon] FOREIGN KEY([MaHD])
REFERENCES [dbo].[tblhoadon] ([MaHD])
GO
ALTER TABLE [dbo].[tblchitiethd] CHECK CONSTRAINT [FK_tblchitiethd_tblhoadon]
GO
ALTER TABLE [dbo].[tblchitiethd]  WITH CHECK ADD  CONSTRAINT [FK_tblchitiethd_tblsanpham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[tblsanpham] ([MaSP])
GO
ALTER TABLE [dbo].[tblchitiethd] CHECK CONSTRAINT [FK_tblchitiethd_tblsanpham]
GO
ALTER TABLE [dbo].[tblchitiethdtra]  WITH CHECK ADD  CONSTRAINT [FK_tblchitiethdtra_tblhoadontra] FOREIGN KEY([MaTraHang])
REFERENCES [dbo].[tblhoadontra] ([MaTraHang])
GO
ALTER TABLE [dbo].[tblchitiethdtra] CHECK CONSTRAINT [FK_tblchitiethdtra_tblhoadontra]
GO
ALTER TABLE [dbo].[tblchitiethdtra]  WITH CHECK ADD  CONSTRAINT [FK_tblchitiethdtra_tblsanpham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[tblsanpham] ([MaSP])
GO
ALTER TABLE [dbo].[tblchitiethdtra] CHECK CONSTRAINT [FK_tblchitiethdtra_tblsanpham]
GO
ALTER TABLE [dbo].[tblchitietpn]  WITH CHECK ADD  CONSTRAINT [FK_tblchitietpn_tblphieunhap] FOREIGN KEY([MaPN])
REFERENCES [dbo].[tblphieunhap] ([MaPN])
GO
ALTER TABLE [dbo].[tblchitietpn] CHECK CONSTRAINT [FK_tblchitietpn_tblphieunhap]
GO
ALTER TABLE [dbo].[tblchitietpn]  WITH CHECK ADD  CONSTRAINT [FK_tblchitietpn_tblsanpham] FOREIGN KEY([MaSP])
REFERENCES [dbo].[tblsanpham] ([MaSP])
GO
ALTER TABLE [dbo].[tblchitietpn] CHECK CONSTRAINT [FK_tblchitietpn_tblsanpham]
GO
ALTER TABLE [dbo].[tblcongno]  WITH CHECK ADD  CONSTRAINT [FK_tblcongno_tblhoadontra] FOREIGN KEY([MaTraHang])
REFERENCES [dbo].[tblhoadontra] ([MaTraHang])
GO
ALTER TABLE [dbo].[tblcongno] CHECK CONSTRAINT [FK_tblcongno_tblhoadontra]
GO
ALTER TABLE [dbo].[tblcongno]  WITH CHECK ADD  CONSTRAINT [FK_tblcongno_tblnhacungcap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[tblnhacungcap] ([MaNCC])
GO
ALTER TABLE [dbo].[tblcongno] CHECK CONSTRAINT [FK_tblcongno_tblnhacungcap]
GO
ALTER TABLE [dbo].[tblhoadon]  WITH CHECK ADD  CONSTRAINT [FK_tblhoadon_tblkhachhang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[tblkhachhang] ([MaKH])
GO
ALTER TABLE [dbo].[tblhoadon] CHECK CONSTRAINT [FK_tblhoadon_tblkhachhang]
GO
ALTER TABLE [dbo].[tblhoadon]  WITH CHECK ADD  CONSTRAINT [FK_tblhoadon_tblkhuyenmai] FOREIGN KEY([MaKM])
REFERENCES [dbo].[tblkhuyenmai] ([MaKM])
GO
ALTER TABLE [dbo].[tblhoadon] CHECK CONSTRAINT [FK_tblhoadon_tblkhuyenmai]
GO
ALTER TABLE [dbo].[tblhoadon]  WITH CHECK ADD  CONSTRAINT [FK_tblhoadon_tblnhanvien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[tblnhanvien] ([MaNV])
GO
ALTER TABLE [dbo].[tblhoadon] CHECK CONSTRAINT [FK_tblhoadon_tblnhanvien]
GO
ALTER TABLE [dbo].[tblhoadondat]  WITH CHECK ADD  CONSTRAINT [FK_tblhoadondat_tblnhacungcap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[tblnhacungcap] ([MaNCC])
GO
ALTER TABLE [dbo].[tblhoadondat] CHECK CONSTRAINT [FK_tblhoadondat_tblnhacungcap]
GO
ALTER TABLE [dbo].[tblhoadondat]  WITH CHECK ADD  CONSTRAINT [FK_tblhoadondat_tblnhanvien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[tblnhanvien] ([MaNV])
GO
ALTER TABLE [dbo].[tblhoadondat] CHECK CONSTRAINT [FK_tblhoadondat_tblnhanvien]
GO
ALTER TABLE [dbo].[tblhoadontra]  WITH CHECK ADD  CONSTRAINT [FK_tblhoadontra_tblnhanvien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[tblnhanvien] ([MaNV])
GO
ALTER TABLE [dbo].[tblhoadontra] CHECK CONSTRAINT [FK_tblhoadontra_tblnhanvien]
GO
ALTER TABLE [dbo].[tblhoadontra]  WITH CHECK ADD  CONSTRAINT [FK_tblhoadontra_tblphieunhap] FOREIGN KEY([MaPN])
REFERENCES [dbo].[tblphieunhap] ([MaPN])
GO
ALTER TABLE [dbo].[tblhoadontra] CHECK CONSTRAINT [FK_tblhoadontra_tblphieunhap]
GO
ALTER TABLE [dbo].[tblnhanvien]  WITH CHECK ADD  CONSTRAINT [FK_tblnhanvien_tblcalam] FOREIGN KEY([MaCaLam])
REFERENCES [dbo].[tblcalam] ([MaCaLam])
GO
ALTER TABLE [dbo].[tblnhanvien] CHECK CONSTRAINT [FK_tblnhanvien_tblcalam]
GO
ALTER TABLE [dbo].[tblnhanvien]  WITH CHECK ADD  CONSTRAINT [FK_tblnhanvien_tblchucvu] FOREIGN KEY([MaChucVu])
REFERENCES [dbo].[tblchucvu] ([MaChucVu])
GO
ALTER TABLE [dbo].[tblnhanvien] CHECK CONSTRAINT [FK_tblnhanvien_tblchucvu]
GO
ALTER TABLE [dbo].[tblnhanvien]  WITH CHECK ADD  CONSTRAINT [FK_tblnhanvien_tbltaikhoan] FOREIGN KEY([MaNV])
REFERENCES [dbo].[tbltaikhoan] ([MaNV])
GO
ALTER TABLE [dbo].[tblnhanvien] CHECK CONSTRAINT [FK_tblnhanvien_tbltaikhoan]
GO
ALTER TABLE [dbo].[tblphieunhap]  WITH CHECK ADD  CONSTRAINT [FK_tblphieunhap_tblhoadondat] FOREIGN KEY([MaDatHang])
REFERENCES [dbo].[tblhoadondat] ([MaDatHang])
GO
ALTER TABLE [dbo].[tblphieunhap] CHECK CONSTRAINT [FK_tblphieunhap_tblhoadondat]
GO
ALTER TABLE [dbo].[tblphieunhap]  WITH CHECK ADD  CONSTRAINT [FK_tblphieunhap_tblnhacungcap] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[tblnhacungcap] ([MaNCC])
GO
ALTER TABLE [dbo].[tblphieunhap] CHECK CONSTRAINT [FK_tblphieunhap_tblnhacungcap]
GO
ALTER TABLE [dbo].[tblsanpham]  WITH CHECK ADD  CONSTRAINT [FK_tblsanpham_tblloaisp] FOREIGN KEY([MaLSP])
REFERENCES [dbo].[tblloaisp] ([MaLSP])
GO
ALTER TABLE [dbo].[tblsanpham] CHECK CONSTRAINT [FK_tblsanpham_tblloaisp]
GO
USE [master]
GO
ALTER DATABASE [QL_coffe] SET  READ_WRITE 
GO
