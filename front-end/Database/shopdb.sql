-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 07, 2020 at 12:55 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shopdb`
--
CREATE DATABASE IF NOT EXISTS `shopdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `shopdb`;

-- --------------------------------------------------------

--
-- Table structure for table `tblchitiethd`
--

CREATE TABLE `tblchitiethd` (
  `MaHD` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `DonGia` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblchitiethd`
--

INSERT INTO `tblchitiethd` (`MaHD`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('HD101', 'SP101', 3, 175000),
('HD101', 'SP102', 10, 350000),
('HD102', 'SP106', 1, 195000),
('HD103', 'SP101', 1, 175000),
('HD103', 'SP107', 1, 300000),
('HD104', 'SP101', 1, 175000),
('HD104', 'SP107', 1, 300000),
('HD105', 'SP101', 7, 175000),
('HD105', 'SP105', 1, 285000),
('HD105', 'SP106', 5, 195000),
('HD105', 'SP107', 1, 300000),
('HD106', 'SP102', 2, 175000);

-- --------------------------------------------------------

--
-- Table structure for table `tblchitietkm`
--

CREATE TABLE `tblchitietkm` (
  `MaKM` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuongToiThieu` int(11) DEFAULT NULL,
  `PhanTramKM` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblchitietkm`
--

INSERT INTO `tblchitietkm` (`MaKM`, `MaSP`, `SoLuongToiThieu`, `PhanTramKM`) VALUES
('KM101', 'SP103', 2, 5),
('KM102', 'SP101', 3, 8),
('KM102', 'SP107', 2, 10),
('KM103', 'SP101', 2, 5);

-- --------------------------------------------------------

--
-- Table structure for table `tblchitietpn`
--

CREATE TABLE `tblchitietpn` (
  `MaPN` varchar(10) NOT NULL,
  `MaSP` varchar(10) NOT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `DonGia` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblchitietpn`
--

INSERT INTO `tblchitietpn` (`MaPN`, `MaSP`, `SoLuong`, `DonGia`) VALUES
('PN101', 'SP101', 40, 135000),
('PN102', 'SP101', 20, 135000),
('PN102', 'SP103', 30, 250000),
('PN103', 'SP102', 30, 150000),
('PN104', 'SP103', 30, 250000),
('PN105', 'SP104', 30, 165000),
('PN105', 'SP105', 10, 250000),
('PN106', 'SP101', 5, 175000);

-- --------------------------------------------------------

--
-- Table structure for table `tblhoadon`
--

CREATE TABLE `tblhoadon` (
  `MaHD` varchar(10) NOT NULL,
  `MaKH` varchar(10) DEFAULT NULL,
  `MaNV` varchar(10) DEFAULT NULL,
  `NgayHD` date DEFAULT NULL,
  `TongTien` float DEFAULT 0,
  `MaKM` varchar(10) DEFAULT NULL,
  `ThanhTien` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblhoadon`
--

INSERT INTO `tblhoadon` (`MaHD`, `MaKH`, `MaNV`, `NgayHD`, `TongTien`, `MaKM`, `ThanhTien`) VALUES
('HD101', 'KH101', 'NV101', '2020-02-15', 4025000, NULL, 4025000),
('HD102', 'KH102', 'NV101', '2020-02-20', 195000, NULL, 195000),
('HD103', 'KH101', 'NV102', '2020-02-28', 475000, NULL, 475000),
('HD104', 'KH105', 'NV105', '2020-03-01', 475000, NULL, 475000),
('HD105', 'KH101', 'NV104', '2020-03-01', 2723750, 'KM103', 2042810),
('HD106', 'KH101', 'NV101', '2020-02-11', 350000, 'KM102', 315000);

-- --------------------------------------------------------

--
-- Table structure for table `tblkhachhang`
--

CREATE TABLE `tblkhachhang` (
  `MaKH` varchar(10) NOT NULL,
  `Ho` varchar(20) DEFAULT NULL,
  `Ten` varchar(10) DEFAULT NULL,
  `DiaChi` varchar(100) DEFAULT NULL,
  `SoDT` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblkhachhang`
--

INSERT INTO `tblkhachhang` (`MaKH`, `Ho`, `Ten`, `DiaChi`, `SoDT`) VALUES
('KH101', 'Trần Văn', 'Mạc', 'Mũi Né', '0996421457'),
('KH102', 'Bùi Tiến', 'Hưng', 'TPHCM', '0996402157'),
('KH103', 'Đỗ Phi', 'Long', 'Hà Nội', '0992141465'),
('KH104', 'Lê Thị', 'Ý', 'Vũng Tàu', '0994531446'),
('KH105', 'Trần Đăng', 'Khoa', 'Hà Nội', '0993851422');

-- --------------------------------------------------------

--
-- Table structure for table `tblkhuyenmai`
--

CREATE TABLE `tblkhuyenmai` (
  `MaKM` varchar(10) NOT NULL,
  `TenKM` varchar(30) DEFAULT NULL,
  `GiaDHToiThieu` float DEFAULT NULL,
  `NgayBatDau` date DEFAULT NULL,
  `NgayKetThuc` date DEFAULT NULL,
  `PhanTramKM` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblkhuyenmai`
--

INSERT INTO `tblkhuyenmai` (`MaKM`, `TenKM`, `GiaDHToiThieu`, `NgayBatDau`, `NgayKetThuc`, `PhanTramKM`) VALUES
('KM101', 'Khuyến mãi 1', 400000, '2020-01-30', '2020-02-05', 20),
('KM102', 'Khuyến mãi 2', 300000, '2020-02-10', '2020-02-13', 10),
('KM103', 'Khuyến mãi 3', 500000, '2020-02-28', '2020-03-01', 25);

-- --------------------------------------------------------

--
-- Table structure for table `tblloaisp`
--

CREATE TABLE `tblloaisp` (
  `MaLSP` varchar(10) NOT NULL,
  `TenLSP` varchar(50) DEFAULT NULL,
  `LoaiTienTe` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblloaisp`
--

INSERT INTO `tblloaisp` (`MaLSP`, `TenLSP`, `LoaiTienTe`) VALUES
('LSP101', 'Áo sơ mi', 'VNĐ'),
('LSP102', 'Áo thun', 'VNĐ'),
('LSP103', 'Quần jeans', 'VNĐ'),
('LSP104', 'Váy xòe', 'VNĐ');

-- --------------------------------------------------------

--
-- Table structure for table `tblnhacungcap`
--

CREATE TABLE `tblnhacungcap` (
  `MaNCC` varchar(10) NOT NULL,
  `TenNCC` varchar(20) DEFAULT NULL,
  `SoDT` varchar(11) DEFAULT NULL,
  `DiaChi` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblnhacungcap`
--

INSERT INTO `tblnhacungcap` (`MaNCC`, `TenNCC`, `SoDT`, `DiaChi`) VALUES
('NCC101', 'An Dương', '0996421457', 'Hà Nội'),
('NCC102', 'Dony', '0996421457', 'TPHCM'),
('NCC103', 'Đức Trường', '0996421457', 'Hải Dương'),
('NCC104', 'Phú Thịnh', '0996421457', 'TPHCM');

-- --------------------------------------------------------

--
-- Table structure for table `tblnhanvien`
--

CREATE TABLE `tblnhanvien` (
  `MaNV` varchar(10) NOT NULL,
  `Ho` varchar(20) DEFAULT NULL,
  `Ten` varchar(10) DEFAULT NULL,
  `GioiTinh` bit(1) DEFAULT NULL,
  `NgaySinh` date DEFAULT NULL,
  `DiaChi` varchar(100) DEFAULT NULL,
  `Luong` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblnhanvien`
--

INSERT INTO `tblnhanvien` (`MaNV`, `Ho`, `Ten`, `GioiTinh`, `NgaySinh`, `DiaChi`, `Luong`) VALUES
('NV101', 'Nguyễn Văn', 'A', b'1', '2000-05-14', 'Vũng Tàu', 10000000),
('NV102', 'Nguyễn Thị', 'B', b'0', '2001-06-20', 'TPHCM', 8000000),
('NV103', 'Nguyễn Tuấn', 'C', b'1', '2000-12-22', 'TPHCM', 11000000),
('NV104', 'Hồ Quang', 'D', b'1', '2000-08-02', 'Cần Thơ', 9000000),
('NV105', 'Lê Như', 'Y', b'0', '2000-10-10', 'Đà Lạt', 10000000);

-- --------------------------------------------------------

--
-- Table structure for table `tblnhasanxuat`
--

CREATE TABLE `tblnhasanxuat` (
  `MaNSX` varchar(10) NOT NULL,
  `TenNSX` varchar(20) DEFAULT NULL,
  `QuocGia` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblnhasanxuat`
--

INSERT INTO `tblnhasanxuat` (`MaNSX`, `TenNSX`, `QuocGia`) VALUES
('NSX101', 'ANN', 'Việt Nam'),
('NSX102', 'VAXY', 'Việt Nam'),
('NSX103', 'Zin Queen', 'Việt Nam');

-- --------------------------------------------------------

--
-- Table structure for table `tblphieunhap`
--

CREATE TABLE `tblphieunhap` (
  `MaPN` varchar(10) NOT NULL,
  `MaNV` varchar(10) DEFAULT NULL,
  `MaNCC` varchar(10) DEFAULT NULL,
  `NgayNhap` date DEFAULT NULL,
  `TongTien` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblphieunhap`
--

INSERT INTO `tblphieunhap` (`MaPN`, `MaNV`, `MaNCC`, `NgayNhap`, `TongTien`) VALUES
('PN101', 'NV104', 'NCC102', '2020-01-21', 5400000),
('PN102', 'NV103', 'NCC104', '2020-01-28', 10200000),
('PN103', 'NV105', 'NCC101', '2020-01-30', 4500000),
('PN104', 'NV101', 'NCC102', '2020-02-02', 7500000),
('PN105', 'NV102', 'NCC103', '2020-02-15', 7450000),
('PN106', 'NV101', 'NCC104', '2020-02-24', 875000);

-- --------------------------------------------------------

--
-- Table structure for table `tblsanpham`
--

CREATE TABLE `tblsanpham` (
  `MaSP` varchar(10) NOT NULL,
  `TenSP` varchar(100) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `DonGia` float DEFAULT NULL,
  `MaLSP` varchar(10) DEFAULT NULL,
  `MaNSX` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tblsanpham`
--

INSERT INTO `tblsanpham` (`MaSP`, `TenSP`, `SoLuong`, `DonGia`, `MaLSP`, `MaNSX`) VALUES
('SP101', 'Áo Thun In Họa Tiết 3D', 45, 175000, 'LSP102', 'NSX103'),
('SP102', 'Chân Váy Xòe Xếp Ly', 49, 175000, 'LSP104', 'NSX101'),
('SP103', 'Quần Jean Baggy Rách', 50, 315000, 'LSP103', 'NSX101'),
('SP104', 'Áo Sơ Mi Caro', 60, 195000, 'LSP101', 'NSX102'),
('SP105', 'Chân Váy Kaki Xẻ Tà', 70, 285000, 'LSP104', 'NSX103'),
('SP106', 'Áo Sơ Mi Túi Khóa', 65, 195000, 'LSP101', 'NSX102'),
('SP107', 'Quần Jean Xẻ Tà Phối Ren', 50, 300000, 'LSP103', 'NSX102');

-- --------------------------------------------------------

--
-- Table structure for table `tbltaikhoan`
--

CREATE TABLE `tbltaikhoan` (
  `MaNV` varchar(10) NOT NULL,
  `TenDangNhap` varchar(30) DEFAULT NULL,
  `MatKhau` varchar(30) DEFAULT NULL,
  `Quyen` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tbltaikhoan`
--

INSERT INTO `tbltaikhoan` (`MaNV`, `TenDangNhap`, `MatKhau`, `Quyen`) VALUES
('NV101', 'ADMIN', 'admin123', 'Admin'),
('NV102', 'NHANVIEN102', 'nv102', 'Nhân Viên'),
('NV103', 'NHANVIEN103', 'nv103', 'Nhân Viên'),
('NV104', 'QUANLY104', 'ql104', 'Quản Lý'),
('NV105', 'QUANLY105', 'ql105', 'Quản Lý');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblchitiethd`
--
ALTER TABLE `tblchitiethd`
  ADD PRIMARY KEY (`MaHD`,`MaSP`),
  ADD KEY `FK2_CTHD` (`MaSP`);

--
-- Indexes for table `tblchitietkm`
--
ALTER TABLE `tblchitietkm`
  ADD PRIMARY KEY (`MaKM`,`MaSP`),
  ADD KEY `FK2_CTKM` (`MaSP`);

--
-- Indexes for table `tblchitietpn`
--
ALTER TABLE `tblchitietpn`
  ADD PRIMARY KEY (`MaPN`,`MaSP`),
  ADD KEY `FK2_CTPN` (`MaSP`);

--
-- Indexes for table `tblhoadon`
--
ALTER TABLE `tblhoadon`
  ADD PRIMARY KEY (`MaHD`),
  ADD KEY `FK1_HD` (`MaKH`),
  ADD KEY `FK2_HD` (`MaNV`),
  ADD KEY `FK3_HD` (`MaKM`);

--
-- Indexes for table `tblkhachhang`
--
ALTER TABLE `tblkhachhang`
  ADD PRIMARY KEY (`MaKH`);

--
-- Indexes for table `tblkhuyenmai`
--
ALTER TABLE `tblkhuyenmai`
  ADD PRIMARY KEY (`MaKM`);

--
-- Indexes for table `tblloaisp`
--
ALTER TABLE `tblloaisp`
  ADD PRIMARY KEY (`MaLSP`);

--
-- Indexes for table `tblnhacungcap`
--
ALTER TABLE `tblnhacungcap`
  ADD PRIMARY KEY (`MaNCC`);

--
-- Indexes for table `tblnhanvien`
--
ALTER TABLE `tblnhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Indexes for table `tblnhasanxuat`
--
ALTER TABLE `tblnhasanxuat`
  ADD PRIMARY KEY (`MaNSX`);

--
-- Indexes for table `tblphieunhap`
--
ALTER TABLE `tblphieunhap`
  ADD PRIMARY KEY (`MaPN`),
  ADD KEY `FK1_NH` (`MaNV`),
  ADD KEY `FK2_NH` (`MaNCC`);

--
-- Indexes for table `tblsanpham`
--
ALTER TABLE `tblsanpham`
  ADD PRIMARY KEY (`MaSP`),
  ADD KEY `FK1_SP` (`MaLSP`),
  ADD KEY `FK2_SP` (`MaNSX`);

--
-- Indexes for table `tbltaikhoan`
--
ALTER TABLE `tbltaikhoan`
  ADD PRIMARY KEY (`MaNV`),
  ADD UNIQUE KEY `TenDangNhap` (`TenDangNhap`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblchitiethd`
--
ALTER TABLE `tblchitiethd`
  ADD CONSTRAINT `FK1_CTHD` FOREIGN KEY (`MaHD`) REFERENCES `tblhoadon` (`MaHD`),
  ADD CONSTRAINT `FK2_CTHD` FOREIGN KEY (`MaSP`) REFERENCES `tblsanpham` (`MaSP`);

--
-- Constraints for table `tblchitietkm`
--
ALTER TABLE `tblchitietkm`
  ADD CONSTRAINT `FK1_CTKM` FOREIGN KEY (`MaKM`) REFERENCES `tblkhuyenmai` (`MaKM`),
  ADD CONSTRAINT `FK2_CTKM` FOREIGN KEY (`MaSP`) REFERENCES `tblsanpham` (`MaSP`);

--
-- Constraints for table `tblchitietpn`
--
ALTER TABLE `tblchitietpn`
  ADD CONSTRAINT `FK1_CTPN` FOREIGN KEY (`MaPN`) REFERENCES `tblphieunhap` (`MaPN`),
  ADD CONSTRAINT `FK2_CTPN` FOREIGN KEY (`MaSP`) REFERENCES `tblsanpham` (`MaSP`);

--
-- Constraints for table `tblhoadon`
--
ALTER TABLE `tblhoadon`
  ADD CONSTRAINT `FK1_HD` FOREIGN KEY (`MaKH`) REFERENCES `tblkhachhang` (`MaKH`),
  ADD CONSTRAINT `FK2_HD` FOREIGN KEY (`MaNV`) REFERENCES `tblnhanvien` (`MaNV`),
  ADD CONSTRAINT `FK3_HD` FOREIGN KEY (`MaKM`) REFERENCES `tblkhuyenmai` (`MaKM`);

--
-- Constraints for table `tblphieunhap`
--
ALTER TABLE `tblphieunhap`
  ADD CONSTRAINT `FK1_NH` FOREIGN KEY (`MaNV`) REFERENCES `tblnhanvien` (`MaNV`),
  ADD CONSTRAINT `FK2_NH` FOREIGN KEY (`MaNCC`) REFERENCES `tblnhacungcap` (`MaNCC`);

--
-- Constraints for table `tblsanpham`
--
ALTER TABLE `tblsanpham`
  ADD CONSTRAINT `FK1_SP` FOREIGN KEY (`MaLSP`) REFERENCES `tblloaisp` (`MaLSP`),
  ADD CONSTRAINT `FK2_SP` FOREIGN KEY (`MaNSX`) REFERENCES `tblnhasanxuat` (`MaNSX`);

--
-- Constraints for table `tbltaikhoan`
--
ALTER TABLE `tbltaikhoan`
  ADD CONSTRAINT `FK_TK` FOREIGN KEY (`MaNV`) REFERENCES `tblnhanvien` (`MaNV`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
