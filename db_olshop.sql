-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2020 at 08:36 PM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

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
-- Table structure for table `keranjang`
--

CREATE TABLE `keranjang` (
  `id_keranjang` int(3) NOT NULL,
  `id` int(3) NOT NULL,
  `id_prod` int(3) NOT NULL,
  `nama_prod` varchar(255) NOT NULL,
  `jumlah_total` int(10) NOT NULL,
  `harga_total` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `keranjang`
--

INSERT INTO `keranjang` (`id_keranjang`, `id`, `id_prod`, `nama_prod`, `jumlah_total`, `harga_total`) VALUES
(25, 2, 9, 'G431 Wired Headset', 3, 2700000),
(29, 2, 1, 'Legion 5i ', 2, 17900000);

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `id` int(3) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `noTelp` varchar(255) NOT NULL,
  `tipeUser` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`id`, `nama`, `email`, `password`, `noTelp`, `tipeUser`) VALUES
(1, 'Gilbert', 'gibe@gmail.com', '123123', '09876543', 0),
(2, 'Zefa', 'zef@gmail.com', '123', '12345', 0),
(3, 'Megacomp', 'mega@gmail.com', '12345', '021987', 1),
(4, 'Gramedia', 'grame@gmail.com', '0011', '02198789', 1),
(5, 'Agus Computer', 'aguscomp@gmail.com', '112233', '012312', 1),
(6, 'admin', 'admin@gmail.com', 'admin123', '085156987087', 2),
(8, 'Logitech Indonesia', 'logitech@gmail.com', 'logitech', '099887', 1);

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `id_prod` int(3) NOT NULL,
  `id` int(3) NOT NULL,
  `nama_prod` varchar(255) NOT NULL,
  `merk_prod` varchar(255) NOT NULL,
  `harga` int(15) NOT NULL,
  `stok` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`id_prod`, `id`, `nama_prod`, `merk_prod`, `harga`, `stok`) VALUES
(1, 3, 'Legion 5i ', 'Lenovo', 17000000, 7),
(2, 3, 'Pavilion Gaming', 'Hp', 12000000, 5),
(3, 4, 'Acoustic Electric Guitar', 'Yamaha', 2500000, 5),
(8, 8, 'G915 Gaming Keyboard', 'Logitech', 5000000, 5),
(9, 8, 'G431 Wired Headset', 'Logitech', 900000, 7),
(10, 8, 'M331 Wireless Mouse', 'Logitech', 300000, 25),
(11, 3, 'ROG G512LV', 'ASUS', 15000000, 8),
(12, 4, 'Buku Al-Quran', 'Mizan', 15000, 20),
(13, 4, 'Tas Sekolah Trendy', 'Eversac', 150000, 15),
(15, 4, 'Buku SBMPTN 2020', 'Erlangga', 35000, 120),
(16, 3, 'Macbook Pro 2020', 'Apple', 20000000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(3) NOT NULL,
  `id_prod` int(3) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `noTelp` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `jenis_pembayaran` varchar(255) NOT NULL,
  `jenis_pengiriman` varchar(255) NOT NULL,
  `kode_promo` varchar(255) NOT NULL,
  `jumlah_produk` int(5) NOT NULL,
  `total_harga` int(15) NOT NULL,
  `status_kirim` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_prod`, `nama`, `noTelp`, `alamat`, `jenis_pembayaran`, `jenis_pengiriman`, `kode_promo`, `jumlah_produk`, `total_harga`, `status_kirim`) VALUES
(1, 1, 'Zefa', '12345', 'Kopo', 'OVO', 'JNE', '-', 1, 19700000, 'Dikemas'),
(2, 3, 'Gilbert', '09876543', 'DU', 'OVO', 'SiCepat', '-', 1, 2500000, 'Dikirim');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD PRIMARY KEY (`id_keranjang`),
  ADD KEY `id` (`id`),
  ADD KEY `id_prod` (`id_prod`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`id_prod`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `id_prod` (`id_prod`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `keranjang`
--
ALTER TABLE `keranjang`
  MODIFY `id_keranjang` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `produk`
--
ALTER TABLE `produk`
  MODIFY `id_prod` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `keranjang`
--
ALTER TABLE `keranjang`
  ADD CONSTRAINT `keranjang_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pengguna` (`id`),
  ADD CONSTRAINT `keranjang_ibfk_2` FOREIGN KEY (`id_prod`) REFERENCES `produk` (`id_prod`);

--
-- Constraints for table `produk`
--
ALTER TABLE `produk`
  ADD CONSTRAINT `produk_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pengguna` (`id`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`id_prod`) REFERENCES `produk` (`id_prod`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
