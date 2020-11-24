-- MariaDB dump 10.18  Distrib 10.4.16-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: db_olshop
-- ------------------------------------------------------
-- Server version	10.4.16-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `connectorprodukkeranjang`
--

DROP TABLE IF EXISTS `connectorprodukkeranjang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connectorprodukkeranjang` (
  `id_keranjang` int(3) NOT NULL,
  `id_prod` int(3) NOT NULL,
  `jumlah_produk` int(4) NOT NULL,
  PRIMARY KEY (`id_keranjang`,`id_prod`),
  KEY `id_keranjang` (`id_keranjang`),
  KEY `id_prod` (`id_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connectorprodukkeranjang`
--

LOCK TABLES `connectorprodukkeranjang` WRITE;
/*!40000 ALTER TABLE `connectorprodukkeranjang` DISABLE KEYS */;
INSERT INTO `connectorprodukkeranjang` VALUES (11,1,1),(11,8,1),(11,9,1),(11,10,1),(12,8,1),(12,9,1),(12,10,2);
/*!40000 ALTER TABLE `connectorprodukkeranjang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `connectorproduktransaksi`
--

DROP TABLE IF EXISTS `connectorproduktransaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `connectorproduktransaksi` (
  `id_transaksi` int(3) NOT NULL,
  `id_prod` int(3) NOT NULL,
  `jumlah_produk` int(5) NOT NULL,
  `total_harga` int(10) NOT NULL,
  PRIMARY KEY (`id_transaksi`,`id_prod`),
  KEY `id_transaksi` (`id_transaksi`),
  KEY `id_prod` (`id_prod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `connectorproduktransaksi`
--

LOCK TABLES `connectorproduktransaksi` WRITE;
/*!40000 ALTER TABLE `connectorproduktransaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `connectorproduktransaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keranjang`
--

DROP TABLE IF EXISTS `keranjang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keranjang` (
  `id_keranjang` int(3) NOT NULL AUTO_INCREMENT,
  `id` int(3) NOT NULL,
  `jumlah_total` int(10) NOT NULL,
  `harga_total` int(15) NOT NULL,
  PRIMARY KEY (`id_keranjang`),
  KEY `id` (`id`),
  CONSTRAINT `keranjang_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pengguna` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keranjang`
--

LOCK TABLES `keranjang` WRITE;
/*!40000 ALTER TABLE `keranjang` DISABLE KEYS */;
INSERT INTO `keranjang` VALUES (11,9,4,23200000),(12,2,4,6500000);
/*!40000 ALTER TABLE `keranjang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pengguna`
--

DROP TABLE IF EXISTS `pengguna`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pengguna` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `noTelp` varchar(255) NOT NULL,
  `tipeUser` int(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pengguna`
--

LOCK TABLES `pengguna` WRITE;
/*!40000 ALTER TABLE `pengguna` DISABLE KEYS */;
INSERT INTO `pengguna` VALUES (1,'Gilbert','gibe@gmail.com','123123','09876543',0),(2,'Zefa','zef@gmail.com','123','12345',0),(3,'Megacomp','mega@gmail.com','12345','021987',1),(4,'Gramedia','grame@gmail.com','0011','02198789',1),(5,'Agus Computer','aguscomp@gmail.com','112233','012312',1),(6,'admin','admin@gmail.com','admin123','085156987087',2),(8,'Logitech Indonesia','logitech@gmail.com','logitech','099887',1),(9,'Lele','lele@gmail.com','lele','08123292',0);
/*!40000 ALTER TABLE `pengguna` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produk`
--

DROP TABLE IF EXISTS `produk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produk` (
  `id_prod` int(3) NOT NULL AUTO_INCREMENT,
  `id` int(3) NOT NULL,
  `nama_prod` varchar(255) NOT NULL,
  `merk_prod` varchar(255) NOT NULL,
  `harga` int(15) NOT NULL,
  `stok` int(5) NOT NULL,
  PRIMARY KEY (`id_prod`),
  KEY `id` (`id`),
  CONSTRAINT `produk_ibfk_1` FOREIGN KEY (`id`) REFERENCES `pengguna` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produk`
--

LOCK TABLES `produk` WRITE;
/*!40000 ALTER TABLE `produk` DISABLE KEYS */;
INSERT INTO `produk` VALUES (1,3,'Legion 5i ','Lenovo',17000000,7),(2,3,'Pavilion Gaming','Hp',12000000,5),(3,4,'Acoustic Electric Guitar','Yamaha',2500000,5),(8,8,'G915 Gaming Keyboard','Logitech',5000000,5),(9,8,'G431 Wired Headset','Logitech',900000,7),(10,8,'M331 Wireless Mouse','Logitech',300000,25),(11,3,'ROG G512LV','ASUS',15000000,8),(12,4,'Buku Al-Quran','Mizan',15000,20),(13,4,'Tas Sekolah Trendy','Eversac',150000,15),(15,4,'Buku SBMPTN 2020','Erlangga',35000,120),(16,3,'Macbook Pro 2020','Apple',20000000,10);
/*!40000 ALTER TABLE `produk` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksi` (
  `id_transaksi` int(3) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) NOT NULL,
  `noTelp` varchar(50) NOT NULL,
  `alamat` varchar(255) NOT NULL,
  `jenis_pembayaran` varchar(255) NOT NULL,
  `jenis_pengiriman` varchar(255) NOT NULL,
  `kode_promo` varchar(255) NOT NULL,
  `total_harga` int(15) NOT NULL,
  `status_kirim` varchar(255) NOT NULL,
  PRIMARY KEY (`id_transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksi`
--

LOCK TABLES `transaksi` WRITE;
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-23 18:23:42
