-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 07, 2020 at 05:51 AM
-- Server version: 10.4.8-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `voting`
--

-- --------------------------------------------------------

--
-- Table structure for table `kecamatan`
--

CREATE TABLE `kecamatan` (
  `id_kecamatan` varchar(5) NOT NULL,
  `id_kota` varchar(5) DEFAULT NULL,
  `NamaKecamatan` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kecamatan`
--

INSERT INTO `kecamatan` (`id_kecamatan`, `id_kota`, `NamaKecamatan`) VALUES
('1', '1', 'Cicendo'),
('2', '1', 'Andir'),
('3', '1', 'Buah batu'),
('4', '2', 'Cimahi Selatan'),
('5', '2', 'Cimahi Tengah'),
('6', '2', 'Cimahi Utara');

-- --------------------------------------------------------

--
-- Table structure for table `kelurahan`
--

CREATE TABLE `kelurahan` (
  `id_kelurahan` varchar(5) NOT NULL,
  `id_kecamatan` varchar(5) DEFAULT NULL,
  `namaKelurahan` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kelurahan`
--

INSERT INTO `kelurahan` (`id_kelurahan`, `id_kecamatan`, `namaKelurahan`) VALUES
('1', '1', 'Pajajaran'),
('10', '5', 'Padasuka'),
('11', '6', 'Cipageran'),
('12', '6', 'Cibabat'),
('2', '1', 'Pasirkaliki'),
('3', '2', 'Ciroyom'),
('4', '2', 'Maleber'),
('5', '3', 'Margasari'),
('6', '3', 'Jatisari'),
('7', '4', 'Leuwigajah'),
('8', '4', 'Cibeureum'),
('9', '5', 'Cimahi');

-- --------------------------------------------------------

--
-- Table structure for table `kota`
--

CREATE TABLE `kota` (
  `id_kota` varchar(5) NOT NULL,
  `id_provinsi` varchar(5) DEFAULT NULL,
  `NamaKota` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kota`
--

INSERT INTO `kota` (`id_kota`, `id_provinsi`, `NamaKota`) VALUES
('1', '1', 'Bandung'),
('2', '1', 'Cimahi');

-- --------------------------------------------------------

--
-- Table structure for table `paslon`
--

CREATE TABLE `paslon` (
  `no_paslon` varchar(5) NOT NULL,
  `nama` varchar(30) DEFAULT NULL,
  `umur` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `paslon`
--

INSERT INTO `paslon` (`no_paslon`, `nama`, `umur`) VALUES
('01', 'Faishal Darma Putra', '40'),
('02', 'Irfan Budi Prakoso', '41'),
('03', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `provinsi`
--

CREATE TABLE `provinsi` (
  `id_provinsi` varchar(5) NOT NULL,
  `NamaProvinsi` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `provinsi`
--

INSERT INTO `provinsi` (`id_provinsi`, `NamaProvinsi`) VALUES
('1', 'Jawa Barat');

-- --------------------------------------------------------

--
-- Table structure for table `suara`
--

CREATE TABLE `suara` (
  `id_suara` varchar(5) NOT NULL,
  `id_suaraProv` varchar(5) DEFAULT NULL,
  `no_paslon` varchar(5) DEFAULT NULL,
  `jumlahSuara` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suara`
--

INSERT INTO `suara` (`id_suara`, `id_suaraProv`, `no_paslon`, `jumlahSuara`) VALUES
('1', '1', '01', 201),
('2', '1', '02', 101);

-- --------------------------------------------------------

--
-- Table structure for table `suara_kecamatan`
--

CREATE TABLE `suara_kecamatan` (
  `id_SuaraKec` varchar(5) NOT NULL,
  `id_kecamatan` varchar(5) DEFAULT NULL,
  `suaraTotal01` int(11) DEFAULT NULL,
  `SuaraTotal02` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suara_kecamatan`
--

INSERT INTO `suara_kecamatan` (`id_SuaraKec`, `id_kecamatan`, `suaraTotal01`, `SuaraTotal02`) VALUES
('1', '1', 35, 17),
('2', '2', 33, 17),
('3', '3', 33, 17),
('4', '4', 33, 17),
('5', '5', 34, 16),
('6', '6', 33, 17);

-- --------------------------------------------------------

--
-- Table structure for table `suara_kelurahan`
--

CREATE TABLE `suara_kelurahan` (
  `id_suaraKel` varchar(5) NOT NULL,
  `id_kelurahan` varchar(5) DEFAULT NULL,
  `suaraTotal01` int(11) DEFAULT NULL,
  `SuaraTotal02` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suara_kelurahan`
--

INSERT INTO `suara_kelurahan` (`id_suaraKel`, `id_kelurahan`, `suaraTotal01`, `SuaraTotal02`) VALUES
('1', '1', 17, 8),
('10', '10', 17, 8),
('11', '11', 17, 8),
('12', '12', 16, 9),
('2', '2', 17, 8),
('3', '3', 16, 8),
('4', '4', 17, 9),
('5', '5', 16, 8),
('6', '6', 17, 9),
('7', '7', 16, 8),
('8', '8', 17, 9),
('9', '9', 17, 8);

-- --------------------------------------------------------

--
-- Table structure for table `suara_kota`
--

CREATE TABLE `suara_kota` (
  `id_suaraKota` varchar(5) NOT NULL,
  `id_kota` varchar(5) DEFAULT NULL,
  `SuaraTotal01` int(11) DEFAULT NULL,
  `SuaraTotal02` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suara_kota`
--

INSERT INTO `suara_kota` (`id_suaraKota`, `id_kota`, `SuaraTotal01`, `SuaraTotal02`) VALUES
('1', '1', 100, 50),
('2', '2', 100, 50);

-- --------------------------------------------------------

--
-- Table structure for table `suara_pemilih`
--

CREATE TABLE `suara_pemilih` (
  `id_pemilih` varchar(5) NOT NULL,
  `no_paslon` varchar(5) DEFAULT NULL,
  `id_tps` varchar(5) DEFAULT NULL,
  `nama` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suara_pemilih`
--

INSERT INTO `suara_pemilih` (`id_pemilih`, `no_paslon`, `id_tps`, `nama`) VALUES
('0001', '01', '1', 'Aditya Mahendra'),
('0002', '01', '1', 'Ardityo Cahyo'),
('0003', '01', '1', 'Muhammad Fadhil'),
('0004', '01', '1', 'Romy Adiputra'),
('0005', '02', '1', 'Edvan Tazul'),
('0006', '02', '1', 'Mayong Sugara'),
('0007', '01', '2', 'Shiba Kabul'),
('0008', '01', '2', 'Julizar Wiranto'),
('0009', '01', '2', 'Reza Ahmad'),
('0010', '01', '2', 'Izzan Faikar'),
('0011', '02', '2', 'Titan Kinan'),
('0012', '02', '2', 'Rizki Syafaat'),
('0013', '01', '3', 'Rizki Yudha'),
('0014', '01', '3', 'Vijay Cheza'),
('0015', '01', '3', 'Zaki Najmudin'),
('0016', '02', '3', 'Rafi Anandita'),
('0017', '02', '3', 'Bayu Iqbal'),
('0018', '01', '4', 'Marcello Rasel'),
('0019', '01', '4', 'Sean Akbar'),
('0020', '01', '4', 'Muhammad Rajih'),
('0021', '02', '4', 'Bagas Hafidz'),
('0024', '01', '5', 'Rifki Alfian'),
('0025', '01', '5', 'Salim Aiman'),
('0026', '01', '5', 'Anang Furqon'),
('0027', '02', '5', 'Alif Aqshal'),
('0028', '01', '6', 'Ahmad Zahri'),
('0029', '01', '6', 'Adiyasa Niastya'),
('0030', '01', '6', 'Azzam Abdurrohman'),
('0031', '01', '6', 'Rizka Nur'),
('0032', '02', '6', 'Andrea Rahmadanisya'),
('0033', '02', '6', 'Sindi Fatika'),
('0034', '01', '7', 'Fitri Herinda'),
('0035', '01', '7', 'Selvie Cahya'),
('0036', '01', '7', 'Nabila Putri'),
('0037', '01', '7', 'Silmi Fahirah'),
('0038', '02', '7', 'Nurul Khaeriyah'),
('0039', '02', '7', 'Rizki Ramadhan'),
('0040', '01', '8', 'Syiti Liviani'),
('0041', '01', '8', 'Nabila Sabita'),
('0042', '01', '8', 'Ferry Ardiansyah'),
('0043', '02', '8', 'Zahrina Aulia'),
('0044', '02', '8', 'Muhammad Farhan'),
('0045', '01', '9', 'Farhan Halim'),
('0046', '01', '9', 'Fadjri Adha'),
('0047', '01', '9', 'Muhammad Vais'),
('0048', '02', '9', 'Muhammad Ariq'),
('0049', '01', '10', 'Abdussalam Fatih'),
('0050', '01', '10', 'Bambang'),
('0051', '01', '10', 'Fahmi Shidqi'),
('0052', '02', '10', 'Muhammad Ichzan'),
('0053', '01', '11', 'Muhammad Rafly'),
('0054', '01', '11', 'Muhammad Reza'),
('0055', '01', '11', 'Ramadhani Triantoro'),
('0056', '01', '11', 'Aryo Tri'),
('0057', '02', '11', 'Satria Dzaky'),
('0058', '02', '11', 'Rakha Dhifan'),
('0059', '01', '12', 'Muhammad Ramadhan'),
('0060', '01', '12', 'Ali Permana'),
('0061', '01', '12', 'Dwinanda Alfiando'),
('0062', '02', '12', 'Faris Muhammad'),
('0063', '02', '12', 'Muhammad Shidqi'),
('0064', '01', '13', 'Sabila Andira'),
('0065', '01', '13', 'Rofi Ramadhan'),
('0066', '01', '13', 'Reza Febriansyah'),
('0067', '02', '13', 'Adam Rahman'),
('0068', '02', '13', 'Akbar Nur'),
('0069', '01', '14', 'Chairul Yaqin'),
('0070', '01', '14', 'Muhammad Raytsi'),
('0071', '01', '14', 'Alwan Azhar'),
('0072', '02', '14', 'Raysha Marvel'),
('0073', '01', '15', 'Devina Chairunissa'),
('0074', '01', '15', 'Annisya Haryadi'),
('0075', '01', '15', 'Devy'),
('0076', '02', '15', 'Vira Noor'),
('0077', '01', '16', 'Bunga Nur'),
('0078', '01', '16', 'Fariza Putri'),
('0079', '01', '16', 'Zahra Putri'),
('0080', '01', '16', 'Yulianti'),
('0081', '02', '16', 'Shafa Lathifah'),
('0082', '02', '16', 'Rachel Anastasya'),
('0083', '01', '17', 'Sendy Gultom'),
('0084', '01', '17', 'Aprilia Sinta'),
('0085', '01', '17', 'Anggi Oktavia'),
('0086', '01', '17', 'Adinda Nazzala'),
('0087', '02', '17', 'Mohammad Rizaldi'),
('0088', '02', '17', 'Meiya Tiannisabri'),
('0089', '01', '18', 'Raihana Qonita Azzahra'),
('0090', '01', '18', 'Afiani Nur Fadhilah'),
('0091', '01', '18', 'Zahira Azkiya Ramadhani'),
('0092', '02', '18', 'Annisa Alya Dewi'),
('0093', '02', '18', 'Funny Lichandra'),
('0094', '01', '19', 'Khalida Hasna'),
('0095', '01', '19', 'Vania Puspita'),
('0096', '01', '19', 'Fadli Fisabilillah'),
('0097', '02', '19', 'Ghaziansyah Mahendra'),
('0098', '02', '19', 'Medina Ramadhani'),
('0099', '01', '20', 'Revydo Bima'),
('0100', '01', '20', 'Reza Ega'),
('0101', '01', '20', 'Tofani'),
('0102', '02', '20', 'Raihan Lutfianto'),
('0103', '01', '21', 'Ferzi Jamal Yerzi'),
('0104', '01', '21', 'Nisa Aulia'),
('0105', '01', '21', 'Zakiya Ainur'),
('0106', '02', '21', 'Hanif Hadani'),
('0107', '02', '21', 'Fakhroni Fadhlur'),
('0108', '01', '22', 'Cindy Charella'),
('0109', '01', '22', 'Fahmi Fauzan'),
('0110', '01', '22', 'Inyoman Yoga'),
('0111', '01', '22', 'Tasyalva Aulia'),
('0112', '02', '22', 'Imam Nurul Ihsan'),
('0113', '02', '22', 'Hilmy Fana'),
('0114', '01', '23', 'Vina Putri'),
('0115', '01', '23', 'Dara Hanifah'),
('0116', '01', '23', 'Khaerani Nur Azizah'),
('0117', '02', '23', 'Ratri Ayu'),
('0118', '02', '23', 'Howard Jeremy'),
('0119', '01', '24', 'Ulya Mahsa'),
('0120', '01', '24', 'Naufal Alif'),
('0121', '01', '24', 'Naufal Firdaus'),
('0122', '02', '24', 'Muhammad Naufal'),
('0123', '01', '25', 'Budi Nugroho'),
('0124', '01', '25', 'Alfan Nugroho'),
('0125', '01', '25', 'Muhammad Ihsanuddin'),
('0126', '02', '25', 'Fidausi Nuzula'),
('0127', '01', '26', 'Mazaya Zafudini'),
('0128', '01', '26', 'Clarissa Hasya'),
('0129', '01', '26', 'Faiza Nurkholida'),
('0130', '01', '26', 'Alya Khaerunisa'),
('0131', '02', '26', 'Rayhan Furqon'),
('0132', '02', '26', 'Fakhrana Kurnia'),
('0133', '01', '27', 'Febryan Herianita'),
('0134', '01', '27', 'Kevin Bintang'),
('0135', '01', '27', 'Raihana Salsabila'),
('0136', '01', '27', 'Aldini Sofyan'),
('0137', '02', '27', 'Joshua Galileh'),
('0138', '02', '27', 'Ryan Aditya'),
('0139', '01', '28', 'Shamgar Otherson'),
('0140', '01', '28', 'Dionisio Febrianto'),
('0141', '01', '28', 'Almer Fandriyanio'),
('0142', '02', '28', 'Gerindra Dimas'),
('0143', '02', '28', 'Akbar Tri'),
('0144', '01', '29', 'Irbah Salsabila'),
('0145', '01', '29', 'Ari Kurniawan'),
('0146', '01', '29', 'Muhammad Ariel'),
('0147', '02', '29', 'Muhammad Mirza'),
('0148', '02', '29', 'Adela Corissa'),
('0149', '01', '30', 'Farel Edris'),
('0150', '01', '30', 'Farhan Halim'),
('0151', '01', '30', 'Irfan Hakim'),
('0152', '02', '30', 'Irfan Dwi'),
('0153', '01', '31', 'Cakra'),
('0154', '01', '31', 'Ihsan Ramadhan'),
('0155', '01', '31', 'Jihad Munggaran'),
('0156', '02', '31', 'Muhammad Fahreza'),
('0157', '02', '31', 'Hadyan Nur'),
('0158', '01', '32', 'Arvinda Mulya'),
('0159', '01', '32', 'Nisa Maulia'),
('0160', '01', '32', 'Raisa Fathya'),
('0161', '02', '32', 'Qisthi Nurul'),
('0162', '02', '32', 'Nurul Ramadhani'),
('0163', '01', '33', 'Nidos Canzola'),
('0164', '01', '33', 'Beckham Putra'),
('0165', '01', '33', 'Gian Zola'),
('0166', '01', '33', 'Febri Haryadi'),
('0167', '02', '33', 'Michael VIeri'),
('0168', '02', '33', 'Pamungkas'),
('0169', '01', '34', 'Fajri Nur'),
('0170', '01', '34', 'Dimas Kurniawan'),
('0171', '01', '34', 'Haris Saputra'),
('0172', '02', '34', 'Adelia Fauzi'),
('0173', '01', '35', 'Kartika Putri'),
('0174', '01', '35', 'Thariq Zaidan'),
('0175', '01', '35', 'Zukhrufikka'),
('0176', '02', '35', 'Intan Purmasari'),
('0177', '01', '36', 'Iffa Khaerunisa'),
('0178', '01', '36', 'Nadia Fitri'),
('0179', '01', '36', 'Muhammad Rifaldi'),
('0180', '01', '36', 'Khalid Izzatul Akbar'),
('0181', '02', '36', 'Muhammad Fauzi'),
('0182', '02', '36', 'Dikho Hafiz Sulistiyo'),
('0183', '01', '37', 'Fauzan Azhari'),
('0184', '01', '37', 'Ilham Prayoga'),
('0185', '01', '37', 'Hafizh Muhammad'),
('0186', '01', '37', 'Akbar Ramadhan'),
('0187', '02', '37', 'Qadri Ramadhan'),
('0188', '02', '37', 'Muhammad Elnossa'),
('0189', '01', '38', 'Almas Bani'),
('0190', '01', '38', 'Dzikri Sinatria'),
('0191', '01', '38', 'Andi Maulana'),
('0192', '02', '38', 'Abi Satria'),
('0193', '02', '38', 'Abu Rijal'),
('0194', '01', '39', 'Achdan Epiloksa'),
('0195', '01', '39', 'Achmad Rafi'),
('0196', '01', '39', 'Adham Erlangga'),
('0197', '02', '39', 'Aditya Gumlar'),
('0198', '02', '39', 'Agnes Zahrani'),
('0199', '01', '40', 'Agung Bitel'),
('0200', '01', '40', 'Agus Narestha'),
('0201', '01', '40', 'Ajeung Angsaweni'),
('0202', '02', '40', 'Akmal Ikhsan'),
('0203', '01', '41', 'Aldiyan Farhan'),
('0204', '01', '41', 'Aldy Renaldi'),
('0205', '01', '41', 'Aldyvia Fedora'),
('0206', '01', '41', 'Alif Farhan'),
('0207', '02', '41', 'Alif Nadhifah'),
('0208', '02', '41', 'Amelisa Putri'),
('0209', '01', '42', 'Ananta Ihza'),
('0210', '01', '42', 'Anas Rasyid'),
('0211', '01', '42', 'Andika Elang'),
('0212', '01', '42', 'Anika Putri Utami'),
('0213', '02', '42', 'Annisa Fajri Hayati'),
('0214', '02', '42', 'Annisa Rahmah'),
('0215', '01', '43', 'Maemunah Sarimah'),
('0216', '01', '43', 'Halimah Kusumah'),
('0217', '01', '43', 'Andre Sulistio'),
('0218', '02', '43', 'Ganjar Gunanjar'),
('0219', '02', '43', 'Saepriloh Ahmadi'),
('0220', '01', '44', 'Richard Milex'),
('0221', '01', '44', 'Aqshal Setiawan'),
('0222', '01', '44', 'Arva Adwitya'),
('0223', '02', '44', 'Aryadi Pramarta'),
('0224', '01', '45', 'Aurora Stepinit'),
('0225', '01', '45', 'Daffa Haris'),
('0226', '01', '45', 'Dennisa Fitriani'),
('0227', '02', '45', 'Danu Ilham'),
('0228', '01', '46', 'Galih Wimba'),
('0229', '01', '46', 'Fikri Maulana'),
('0230', '01', '46', 'Fuad Hawari Wiranto'),
('0231', '01', '46', 'Frilisa Anggraeni'),
('0232', '02', '46', 'Friska Alfanda'),
('0233', '02', '46', 'Dendy Hadinata'),
('0234', '01', '47', 'Kemas Alfarabi'),
('0235', '01', '47', 'Kevin Daniel'),
('0236', '01', '47', 'Mufidah Alfiah'),
('0237', '01', '47', 'Muhammad Aziz'),
('0238', '02', '47', 'Tsany Fauzi'),
('0239', '02', '47', 'Saniyyah Alayubi'),
('0240', '01', '48', 'Rayhan Abdurrazaq'),
('0241', '01', '48', 'Rendi Kustiawan'),
('0242', '01', '48', 'Rendy Pratama'),
('0243', '02', '48', 'Ridhwan Nasir'),
('0244', '02', '48', 'Rifaldo Sitepu'),
('0245', '01', '49', 'Bima Kusuma'),
('0246', '01', '49', 'Caca Aulia'),
('0247', '01', '49', 'Danial Abyantara'),
('0248', '02', '49', 'Edward Riwu'),
('0249', '01', '50', 'Farhan Audianto'),
('0250', '01', '50', 'Ghani Kamil'),
('0251', '01', '50', 'Haekal Rafif'),
('0252', '02', '50', 'Ihsan Ahsanu'),
('0253', '01', '51', 'Inggrid Benita'),
('0254', '01', '51', 'Joel Andrew'),
('0255', '01', '51', 'Jose Vernando'),
('0256', '01', '51', 'Kanita Akmali'),
('0257', '02', '51', 'Labib Abdul Fattah'),
('0258', '02', '51', 'Vina Laraswati'),
('0259', '01', '52', 'Raisa Andini'),
('0260', '01', '52', 'Vincent Ludis'),
('0261', '01', '52', 'Rusdi Purnomo'),
('0262', '01', '52', 'Tono Hartono'),
('0263', '02', '52', 'Sukinep Butanan'),
('0264', '02', '52', 'Ana Sulyanjana'),
('0265', '01', '53', 'Andi Kahfi'),
('0266', '01', '53', 'Faqqih Fiddin'),
('0267', '01', '53', 'Abdul Rozzak'),
('0268', '02', '53', 'Afriadie Firmansyah'),
('0269', '02', '53', 'Achmad Raihan'),
('0270', '01', '54', 'Bagus Bangun Praptama'),
('0272', '01', '54', 'BIlly Ahmad'),
('0273', '01', '54', 'Dany Salsabila'),
('0274', '02', '54', 'Dhimas Hafid'),
('0275', '01', '55', 'Daffa Regenta'),
('0276', '01', '55', 'Muhammad Rizki'),
('0277', '01', '55', 'Muhammad Wildan'),
('0278', '02', '55', 'Fajar Kurnia Safara'),
('0279', '01', '56', 'Althaf Azhar'),
('0280', '01', '56', 'Wildan Faridzhar'),
('0281', '01', '56', 'Windie Nuryasafanah'),
('0282', '01', '56', 'Aletha Almari'),
('0283', '02', '56', 'Alissya Azzahra Fauzia'),
('0284', '02', '56', 'Xavier Omar Azea'),
('0285', '01', '57', 'Maisevli Harika'),
('0286', '01', '57', 'Azha Alvin'),
('0287', '01', '57', 'Basil Haidi'),
('0288', '02', '57', 'Dendy Andra'),
('0289', '02', '57', 'Hafizh Fairussufi'),
('0290', '01', '58', 'Muhammad Nurihsan'),
('0291', '01', '58', 'Samuel Erlangga'),
('0292', '01', '58', 'Sri Tangkelangi'),
('0293', '02', '58', 'Yusuf Surya'),
('0294', '02', '58', 'Anang Rahman'),
('0295', '01', '59', 'Rafy Hutama'),
('0296', '01', '59', 'Gunawan Zulkifli'),
('0297', '01', '59', 'Jeremy Moses'),
('0298', '02', '59', 'Galiz Rezza'),
('0299', '02', '59', 'Dewangga Jales'),
('0300', '01', '60', 'Aldi Lukmansyah'),
('0301', '01', '60', 'Aga Yanuar'),
('0302', '01', '60', 'Ahmad Syafiq'),
('0303', '02', '60', 'Akhdan Kurniadi'),
('0305', '02', '1', 'Jurdi');

-- --------------------------------------------------------

--
-- Table structure for table `suara_provinsi`
--

CREATE TABLE `suara_provinsi` (
  `ID_SuaraProv` varchar(5) NOT NULL,
  `ID_Provinsi` varchar(5) DEFAULT NULL,
  `suaraTotal01` int(11) DEFAULT NULL,
  `SuaraTotal02` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suara_provinsi`
--

INSERT INTO `suara_provinsi` (`ID_SuaraProv`, `ID_Provinsi`, `suaraTotal01`, `SuaraTotal02`) VALUES
('1', '1', 201, '101');

-- --------------------------------------------------------

--
-- Table structure for table `suara_tps`
--

CREATE TABLE `suara_tps` (
  `id_suaraTPS` varchar(5) NOT NULL,
  `id_tps` varchar(5) DEFAULT NULL,
  `suaraTotal01` int(11) DEFAULT NULL,
  `SuaraTotal02` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `suara_tps`
--

INSERT INTO `suara_tps` (`id_suaraTPS`, `id_tps`, `suaraTotal01`, `SuaraTotal02`) VALUES
('1', '1', 4, 2),
('10', '10', 3, 1),
('11', '11', 4, 2),
('12', '12', 3, 2),
('13', '13', 3, 2),
('14', '14', 3, 1),
('15', '15', 3, 1),
('16', '16', 4, 2),
('17', '17', 4, 2),
('18', '18', 3, 2),
('19', '19', 3, 2),
('2', '2', 4, 2),
('20', '20', 3, 1),
('21', '21', 3, 2),
('22', '22', 4, 2),
('23', '23', 3, 2),
('24', '24', 3, 1),
('25', '25', 3, 1),
('26', '26', 4, 2),
('27', '27', 4, 2),
('28', '28', 3, 2),
('29', '29', 3, 2),
('3', '3', 3, 2),
('30', '30', 3, 1),
('31', '31', 3, 2),
('32', '32', 3, 2),
('33', '33', 4, 2),
('34', '34', 3, 1),
('35', '35', 3, 1),
('36', '36', 4, 2),
('37', '37', 4, 2),
('38', '38', 3, 2),
('39', '39', 3, 2),
('4', '4', 3, 1),
('40', '40', 3, 1),
('41', '41', 4, 2),
('42', '42', 4, 2),
('43', '43', 3, 2),
('44', '44', 3, 1),
('45', '45', 3, 1),
('46', '46', 4, 2),
('47', '47', 4, 2),
('48', '48', 3, 2),
('49', '49', 3, 1),
('5', '5', 4, 3),
('50', '50', 3, 1),
('51', '51', 4, 2),
('52', '52', 4, 2),
('53', '53', 3, 2),
('54', '54', 3, 1),
('55', '55', 3, 1),
('56', '56', 4, 2),
('57', '57', 3, 2),
('58', '58', 3, 2),
('59', '59', 3, 2),
('6', '6', 4, 2),
('60', '60', 3, 1),
('7', '7', 4, 2),
('8', '8', 3, 2),
('9', '9', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `tps`
--

CREATE TABLE `tps` (
  `id_tps` varchar(5) NOT NULL,
  `id_kelurahan` varchar(5) DEFAULT NULL,
  `RT` varchar(5) DEFAULT NULL,
  `RW` varchar(5) DEFAULT NULL,
  `no_tps` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tps`
--

INSERT INTO `tps` (`id_tps`, `id_kelurahan`, `RT`, `RW`, `no_tps`) VALUES
('1', '1', '01', '03', 'TPS 001'),
('10', '2', '10', '12', 'TPS 005'),
('11', '3', '08', '10', 'TPS 001'),
('12', '3', '07', '04', 'TPS 002'),
('13', '3', '02', '02', 'TPS 003'),
('14', '3', '03', '02', 'TPS 004'),
('15', '3', '01', '02', 'TPS 005'),
('16', '4', '09', '04', 'TPS 001'),
('17', '4', '02', '04', 'TPS 002'),
('18', '4', '11', '03', 'TPS 003'),
('19', '4', '07', '07', 'TPS 004'),
('2', '1', '03', '09', 'TPS 002'),
('20', '4', '09', '06', 'TPS 005'),
('21', '5', '06', '05', 'TPS 001'),
('22', '5', '04', '08', 'TPS 002'),
('23', '5', '09', '03', 'TPS 003'),
('24', '5', '02', '03', 'TPS 004'),
('25', '5', '04', '05', 'TPS 005'),
('26', '6', '05', '05', 'TPS 001'),
('27', '6', '09', '07', 'TPS 002'),
('28', '6', '01', '09', 'TPS 003'),
('29', '6', '02', '09', 'TPS 004'),
('3', '1', '07', '08', 'TPS 003'),
('30', '6', '01', '01', 'TPS 005'),
('31', '7', '02', '21', 'TPS 001'),
('32', '7', '02', '15', 'TPS 002'),
('33', '7', '05', '14', 'TPS 003'),
('34', '7', '02', '12', 'TPS 004'),
('35', '7', '03', '11', 'TPS 005'),
('36', '8', '01', '01', 'TPS 001'),
('37', '8', '02', '02', 'TPS 002'),
('38', '8', '03', '03', 'TPS 003'),
('39', '8', '04', '04', 'TPS 004'),
('4', '1', '03', '02', 'TPS 004'),
('40', '8', '05', '05', 'TPS 005'),
('41', '9', '06', '06', 'TPS 001'),
('42', '9', '07', '07', 'TPS 002'),
('43', '9', '08', '08', 'TPS 003'),
('44', '9', '09', '09', 'TPS 004'),
('45', '9', '01', '02', 'TPS 005'),
('46', '10', '02', '03', 'TPS 001'),
('47', '10', '03', '04', 'TPS 002'),
('48', '10', '04', '05', 'TPS 003'),
('49', '10', '05', '06', 'TPS 004'),
('5', '1', '09', '08', 'TPS 005'),
('50', '10', '06', '07', 'TPS 005'),
('51', '11', '07', '08', 'TPS 001'),
('52', '11', '08', '09', 'TPS 002'),
('53', '11', '09', '08', 'TPS 003'),
('54', '11', '08', '07', 'TPS 004'),
('55', '11', '07', '06', 'TPS 005'),
('56', '12', '06', '05', 'TPS 001'),
('57', '12', '05', '04', 'TPS 002'),
('58', '12', '04', '03', 'TPS 003'),
('59', '12', '03', '02', 'TPS 004'),
('6', '2', '08', '21', 'TPS 001'),
('60', '12', '02', '01', 'TPS 005'),
('7', '2', '08', '04', 'TPS 002'),
('8', '2', '03', '05', 'TPS 003'),
('9', '2', '11', '07', 'TPS 004');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD PRIMARY KEY (`id_kecamatan`),
  ADD KEY `id_kota` (`id_kota`);

--
-- Indexes for table `kelurahan`
--
ALTER TABLE `kelurahan`
  ADD PRIMARY KEY (`id_kelurahan`),
  ADD KEY `id_kecamatan` (`id_kecamatan`);

--
-- Indexes for table `kota`
--
ALTER TABLE `kota`
  ADD PRIMARY KEY (`id_kota`),
  ADD KEY `id_provinsi` (`id_provinsi`);

--
-- Indexes for table `paslon`
--
ALTER TABLE `paslon`
  ADD PRIMARY KEY (`no_paslon`);

--
-- Indexes for table `provinsi`
--
ALTER TABLE `provinsi`
  ADD PRIMARY KEY (`id_provinsi`);

--
-- Indexes for table `suara`
--
ALTER TABLE `suara`
  ADD PRIMARY KEY (`id_suara`),
  ADD KEY `id_suaraProv` (`id_suaraProv`),
  ADD KEY `no_paslon` (`no_paslon`);

--
-- Indexes for table `suara_kecamatan`
--
ALTER TABLE `suara_kecamatan`
  ADD PRIMARY KEY (`id_SuaraKec`),
  ADD KEY `id_kecamatan` (`id_kecamatan`);

--
-- Indexes for table `suara_kelurahan`
--
ALTER TABLE `suara_kelurahan`
  ADD PRIMARY KEY (`id_suaraKel`),
  ADD KEY `id_kelurahan` (`id_kelurahan`);

--
-- Indexes for table `suara_kota`
--
ALTER TABLE `suara_kota`
  ADD PRIMARY KEY (`id_suaraKota`),
  ADD KEY `id_kota` (`id_kota`);

--
-- Indexes for table `suara_pemilih`
--
ALTER TABLE `suara_pemilih`
  ADD PRIMARY KEY (`id_pemilih`),
  ADD KEY `no_paslon` (`no_paslon`),
  ADD KEY `id_tps` (`id_tps`);

--
-- Indexes for table `suara_provinsi`
--
ALTER TABLE `suara_provinsi`
  ADD PRIMARY KEY (`ID_SuaraProv`),
  ADD KEY `ID_Provinsi` (`ID_Provinsi`);

--
-- Indexes for table `suara_tps`
--
ALTER TABLE `suara_tps`
  ADD PRIMARY KEY (`id_suaraTPS`),
  ADD KEY `no_tps` (`id_tps`);

--
-- Indexes for table `tps`
--
ALTER TABLE `tps`
  ADD PRIMARY KEY (`id_tps`),
  ADD KEY `id_kelurahan` (`id_kelurahan`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `kecamatan`
--
ALTER TABLE `kecamatan`
  ADD CONSTRAINT `kecamatan_ibfk_1` FOREIGN KEY (`id_kota`) REFERENCES `kota` (`id_kota`);

--
-- Constraints for table `kelurahan`
--
ALTER TABLE `kelurahan`
  ADD CONSTRAINT `kelurahan_ibfk_1` FOREIGN KEY (`id_kecamatan`) REFERENCES `kecamatan` (`id_kecamatan`);

--
-- Constraints for table `kota`
--
ALTER TABLE `kota`
  ADD CONSTRAINT `kota_ibfk_1` FOREIGN KEY (`id_provinsi`) REFERENCES `provinsi` (`id_provinsi`);

--
-- Constraints for table `suara`
--
ALTER TABLE `suara`
  ADD CONSTRAINT `suara_ibfk_1` FOREIGN KEY (`id_suaraProv`) REFERENCES `suara_provinsi` (`ID_SuaraProv`),
  ADD CONSTRAINT `suara_ibfk_2` FOREIGN KEY (`no_paslon`) REFERENCES `paslon` (`no_paslon`);

--
-- Constraints for table `suara_kecamatan`
--
ALTER TABLE `suara_kecamatan`
  ADD CONSTRAINT `suara_kecamatan_ibfk_1` FOREIGN KEY (`id_kecamatan`) REFERENCES `kecamatan` (`id_kecamatan`),
  ADD CONSTRAINT `suara_kecamatan_ibfk_2` FOREIGN KEY (`no_paslon`) REFERENCES `paslon` (`no_paslon`);

--
-- Constraints for table `suara_kelurahan`
--
ALTER TABLE `suara_kelurahan`
  ADD CONSTRAINT `suara_kelurahan_ibfk_1` FOREIGN KEY (`id_kelurahan`) REFERENCES `kelurahan` (`id_kelurahan`),
  ADD CONSTRAINT `suara_kelurahan_ibfk_2` FOREIGN KEY (`-`) REFERENCES `paslon` (`no_paslon`);

--
-- Constraints for table `suara_kota`
--
ALTER TABLE `suara_kota`
  ADD CONSTRAINT `suara_kota_ibfk_1` FOREIGN KEY (`id_kota`) REFERENCES `kota` (`id_kota`);

--
-- Constraints for table `suara_pemilih`
--
ALTER TABLE `suara_pemilih`
  ADD CONSTRAINT `suara_pemilih_ibfk_1` FOREIGN KEY (`no_paslon`) REFERENCES `paslon` (`no_paslon`),
  ADD CONSTRAINT `suara_pemilih_ibfk_2` FOREIGN KEY (`id_tps`) REFERENCES `tps` (`id_tps`);

--
-- Constraints for table `suara_provinsi`
--
ALTER TABLE `suara_provinsi`
  ADD CONSTRAINT `suara_provinsi_ibfk_1` FOREIGN KEY (`ID_Provinsi`) REFERENCES `provinsi` (`id_provinsi`);

--
-- Constraints for table `suara_tps`
--
ALTER TABLE `suara_tps`
  ADD CONSTRAINT `suara_tps_ibfk_1` FOREIGN KEY (`id_tps`) REFERENCES `tps` (`id_tps`),
  ADD CONSTRAINT `suara_tps_ibfk_2` FOREIGN KEY (`no_paslon`) REFERENCES `paslon` (`no_paslon`);

--
-- Constraints for table `tps`
--
ALTER TABLE `tps`
  ADD CONSTRAINT `tps_ibfk_1` FOREIGN KEY (`id_kelurahan`) REFERENCES `kelurahan` (`id_kelurahan`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
