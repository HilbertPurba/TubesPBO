-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 06, 2020 at 06:31 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_olshop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `noTelp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `nama`, `email`, `password`, `noTelp`) VALUES
('A001', 'Kevin', 'kevin@gmail.com', '123456', '08159761575');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_cust` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `noTelp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_cust`, `nama`, `email`, `password`, `noTelp`) VALUES
('C001', 'Zefanya', 'zefa@gmail.com', '123456', '085155340807'),
('C002', 'Gilbert', 'gibe@gmail.com', '123456', '087944568989'),
('C003', 'Hilbert', 'hilbert@gmail.com', '123456', '096899468989');

-- --------------------------------------------------------

--
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `id_keranjang` varchar(10) NOT NULL,
  `id_cust` varchar(10) NOT NULL,
  `id_prod` varchar(10) NOT NULL,
  `jumlah_total` int(10) NOT NULL,
  `harga_total` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `keranjang`
--

INSERT INTO `keranjang` (`id_keranjang`, `id_cust`, `id_prod`, `jumlah_total`, `harga_total`) VALUES
('K001', 'C001', 'P001', 1, 200000),
('K002', 'C002', 'P002', 2, 50000),
('K003', 'C003', 'P003', 4, 200000);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id_prod` varchar(10) NOT NULL,
  `id_vendor` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `merk` varchar(255) NOT NULL,
  `harga` int(15) NOT NULL,
  `stok` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id_prod`, `id_vendor`, `nama`, `merk`, `harga`, `stok`) VALUES
('P001', 'V001', 'Mouse Logitech G33', 'Logitech', 200000, 10),
('P002', 'V002', 'Buku Mengaji Cerdas', 'Mizan', 25000, 20),
('P003', 'V003', 'Kaos Trendy Yellow', '3Second', 50000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` varchar(10) NOT NULL,
  `id_keranjang` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `noTelp` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `jenis_pembayaran` varchar(255) NOT NULL,
  `jenis_pengiriman` varchar(255) NOT NULL,
  `kode_promo` varchar(255) NOT NULL,
  `total_harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_keranjang`, `nama`, `noTelp`, `alamat`, `jenis_pembayaran`, `jenis_pengiriman`, `kode_promo`, `total_harga`) VALUES
('T001', 'K001', 'Zefanya', '085155340807', 'Kopo', 'COD', '-', 'DISC10K', 190000),
('T002', 'K002', 'Gilbert', '087944568989', 'Bitung', 'Transfer Bank', 'JNE', 'DISC10K', 40000),
('T003', 'K003', 'Hilbert', '096899468989', 'Pasir Kaliki', 'Transfer Bank', 'JNT', '-', 200000);

-- --------------------------------------------------------

--
-- Table structure for table `vendor`
--

CREATE TABLE `vendor` (
  `id_vendor` varchar(10) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `noTelp` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `vendor`
--

INSERT INTO `vendor` (`id_vendor`, `nama`, `email`, `password`, `noTelp`) VALUES
('V001', 'Megacomp', 'megacomp@gmail.com', '123456', '085644987946'),
('V002', 'Gramedia Online', 'gramed@gmail.com', '123456', '08659964646'),
('V003', '3Second Online', 'threesecond@gmail.com', '123456', '086566894949');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_cust`);

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`id_keranjang`),
  ADD KEY `id_cust` (`id_cust`),
  ADD KEY `id_prod` (`id_prod`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id_prod`),
  ADD KEY `id_vendor` (`id_vendor`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_keranjang` (`id_keranjang`);

--
-- Indexes for table `vendor`
--
ALTER TABLE `vendor`
  ADD PRIMARY KEY (`id_vendor`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD CONSTRAINT `keranjang_ibfk_1` FOREIGN KEY (`id_cust`) REFERENCES `customer` (`id_cust`),
  ADD CONSTRAINT `keranjang_ibfk_2` FOREIGN KEY (`id_prod`) REFERENCES `product` (`id_prod`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`id_vendor`) REFERENCES `vendor` (`id_vendor`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_keranjang`) REFERENCES `keranjang` (`id_keranjang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
