-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2019 at 07:20 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `veleprodaja`
--

-- --------------------------------------------------------

--
-- Table structure for table `artikal`
--

CREATE TABLE `artikal` (
  `id_artikla` int(9) NOT NULL,
  `id_grupe_artikala` int(9) NOT NULL,
  `naziv_grupe_artikala` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `naziv_artikla` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jedinica_mere` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `neto_cena_artikla` double(50,4) NOT NULL,
  `stopa_pdv_a` double(2,0) NOT NULL,
  `marza_artikla` double(10,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `artikal`
--

INSERT INTO `artikal` (`id_artikla`, `id_grupe_artikala`, `naziv_grupe_artikala`, `naziv_artikla`, `jedinica_mere`, `neto_cena_artikla`, `stopa_pdv_a`, `marza_artikla`) VALUES
(1, 1, 'Pice', 'Vodka Smirnoff Red 1.0l', 'Litar', 1800.0000, 20, 5.0000),
(2, 1, 'Pice', 'Viski Jack Daniels', 'Komad', 3650.0000, 20, 7.0000),
(3, 1, 'Pice', 'Coca Cola 1.5l', 'Komad', 150.0000, 20, 8.0000),
(4, 1, 'Pice', 'Sok Next pomorandža 1.5l', 'Komad', 165.0000, 20, 5.0000),
(5, 1, 'Pice', 'Sok Pago Crna Ribizla 0.2l', 'Komad', 480.0000, 20, 5.0000),
(6, 2, 'Hrana', 'Srnetina', 'Kilogram', 1800.0000, 20, 3.0000),
(7, 2, 'Hrana', 'Jastog', 'Kilogram', 5000.0000, 20, 5.0000),
(8, 2, 'Hrana', 'Cokolada Ritter Sport mini', 'Komad', 350.0000, 20, 4.0000),
(9, 2, 'Hrana', 'Cokolada Kinder 100g', 'Komad', 150.0000, 20, 5.0000),
(10, 2, 'Hrana', 'Njeguška pršuta', 'Kilogram', 1850.0000, 20, 5.0000),
(11, 3, 'Mešovita roba', 'Cigarete Sobranie Black Russian', 'Komad', 550.0000, 20, 5.0000),
(12, 3, 'Mešovita roba', 'Tompus Cohiba Esplendidos', 'Komad', 5350.0000, 20, 5.0000),
(13, 3, 'Mešovita roba', 'Upaljac Zippo Black Ice', 'Komad', 3600.0000, 10, 3.0000),
(14, 3, 'Mešovita roba', 'Victorinox Ranger Red', 'Komad', 4900.0000, 10, 5.0000),
(15, 3, 'Mešovita roba', 'Casopis Svet kompjutera', 'Komad', 200.0000, 10, 3.0000);

-- --------------------------------------------------------

--
-- Table structure for table `filijala`
--

CREATE TABLE `filijala` (
  `id_filijale` int(9) NOT NULL,
  `naziv_filijale` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresa_filijale` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `grad_opstina_filijale` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefon_filijale` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `e_mail_filijale` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pib_filijale` int(21) NOT NULL,
  `tekuci_racun_filijale` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status_filijale` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `filijala`
--

INSERT INTO `filijala` (`id_filijale`, `naziv_filijale`, `adresa_filijale`, `grad_opstina_filijale`, `telefon_filijale`, `e_mail_filijale`, `pib_filijale`, `tekuci_racun_filijale`, `status_filijale`) VALUES
(1, 'Filijala_1', 'Kralja Petra 55', 'Kraljevo', '0648888955', 'filijala1@velet.com', 10710070, '800-123777-70', 'Aktivna'),
(2, 'Filijala_2', 'Nemanjina 66', 'Beograd', '0648888966', 'filijala2@velet.com', 10720080, '800-123888-80', 'Aktivna'),
(3, 'Filijala_3', 'Despota Stefana 77', 'Novi Sad', '0648888977', 'filijala3@velet.com', 10730090, '800-123999-90', 'Aktivna');

-- --------------------------------------------------------

--
-- Table structure for table `grupa_artikala`
--

CREATE TABLE `grupa_artikala` (
  `id_grupe_artikala` int(9) NOT NULL,
  `naziv_grupe_artikala` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `grupa_artikala`
--

INSERT INTO `grupa_artikala` (`id_grupe_artikala`, `naziv_grupe_artikala`) VALUES
(1, 'Pice'),
(2, 'Hrana'),
(3, 'Mešovita roba');

-- --------------------------------------------------------

--
-- Table structure for table `kupac`
--

CREATE TABLE `kupac` (
  `id_kupca` int(9) NOT NULL,
  `naziv_firme_kupca` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresa_kupca` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `grad_opstina_kupca` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefon_kupca` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `e_mail_kupca` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `kontakt_osoba_kupca` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pib_kupca` int(21) NOT NULL,
  `tekuci_racun_kupca` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `valuta_placanja_kupca` int(9) NOT NULL,
  `status_kupca` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kupac`
--

INSERT INTO `kupac` (`id_kupca`, `naziv_firme_kupca`, `adresa_kupca`, `grad_opstina_kupca`, `telefon_kupca`, `e_mail_kupca`, `kontakt_osoba_kupca`, `pib_kupca`, `tekuci_racun_kupca`, `valuta_placanja_kupca`, `status_kupca`) VALUES
(1, 'Euro Trade', 'Hajduk Stankova 45', 'Beograd', '0659988444', 'eutrade@trade.rs', 'Milan Milojevic', 10246687, '140-34765-88', 30, 'Aktivan'),
(2, 'Hotel Kruna', 'Knjeginje Zorke 89', 'Kragujevac', '0637766589', 'komercijala@kruna.rs', 'Milena Stojanovic', 10588754, '120-345987-77', 60, 'Aktivan'),
(3, 'Trgovina SQL', 'Carice Milice 23', 'Subotica', '0603346687', 'sql@gmail.com', 'Andrijana Lukovic', 10546879, '840-3451112-66', 120, 'Aktivan');

-- --------------------------------------------------------

--
-- Table structure for table `magacin`
--

CREATE TABLE `magacin` (
  `id_magacina` int(9) NOT NULL,
  `naziv_magacina` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresa_magacina` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `grad_opstina_magacina` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefon_magacina` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `e_mail_magacina` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `magacin`
--

INSERT INTO `magacin` (`id_magacina`, `naziv_magacina`, `adresa_magacina`, `grad_opstina_magacina`, `telefon_magacina`, `e_mail_magacina`) VALUES
(1, 'Magacin_1', 'Ulica Brestova bb', 'Smorgrad', '069666999', 'mag1@vele.cx');

-- --------------------------------------------------------

--
-- Table structure for table `racun_otpremnica`
--

CREATE TABLE `racun_otpremnica` (
  `id_racuna` int(9) NOT NULL,
  `id_zaposlenog` int(9) NOT NULL,
  `id_kupca` int(9) NOT NULL,
  `datum_racuna` date NOT NULL,
  `datum_naplate_racuna` date NOT NULL,
  `poreska_osnovica_racuna` double(20,4) NOT NULL,
  `ukupan_iznos_obracunatog_pdv_a_racuna` double(20,4) NOT NULL,
  `ukupna_vrednost_racuna` double(20,4) NOT NULL,
  `status_racuna` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `racun_otpremnica`
--

INSERT INTO `racun_otpremnica` (`id_racuna`, `id_zaposlenog`, `id_kupca`, `datum_racuna`, `datum_naplate_racuna`, `poreska_osnovica_racuna`, `ukupan_iznos_obracunatog_pdv_a_racuna`, `ukupna_vrednost_racuna`, `status_racuna`) VALUES
(96, 1, 1, '2019-09-18', '2019-10-18', 182775.0000, 36555.0000, 219330.0000, 'Aktivan'),
(97, 1, 2, '2019-09-18', '2019-11-17', 368225.0000, 73645.0000, 441870.0000, 'Aktivan'),
(98, 1, 3, '2019-09-18', '2020-01-16', 240088.7500, 33910.2500, 273999.0000, 'Aktivan'),
(104, 2, 3, '2019-09-19', '2020-01-17', 102688.0000, 11683.6000, 114371.6000, 'Aktivan'),
(105, 2, 2, '2019-09-19', '2019-11-18', 240280.0000, 48056.0000, 288336.0000, 'Aktivan'),
(106, 2, 2, '2019-09-19', '2019-11-18', 48212.5000, 9642.5000, 57855.0000, 'Aktivan'),
(107, 2, 2, '2019-09-19', '2019-11-18', 7125.0000, 1425.0000, 8550.0000, 'Aktivan'),
(108, 2, 1, '2019-09-19', '2019-10-19', 11522.2500, 2304.4500, 13826.7000, 'Aktivan'),
(109, 3, 3, '2019-09-19', '2020-01-17', 104737.5000, 18620.0000, 123357.5000, 'Aktivan'),
(110, 3, 2, '2019-09-19', '2019-11-18', 100750.0000, 20150.0000, 120900.0000, 'Aktivan'),
(111, 4, 2, '2019-09-19', '2019-11-18', 35482.5000, 7096.5000, 42579.0000, 'Aktivan'),
(112, 1, 2, '2019-09-19', '2019-11-18', 58425.0000, 11685.0000, 70110.0000, 'Aktivan'),
(113, 1, 2, '2019-09-19', '2019-11-18', 96900.0000, 19380.0000, 116280.0000, 'Aktivan'),
(114, 1, 1, '2019-09-23', '2019-10-23', 134480.0000, 26896.0000, 161376.0000, 'Aktivan'),
(115, 1, 2, '2019-09-23', '2019-11-22', 77242.5000, 15448.5000, 92691.0000, 'Aktivan'),
(116, 2, 2, '2019-09-23', '2019-11-22', 77488.0000, 15497.6000, 92985.6000, 'Aktivan'),
(117, 1, 2, '2019-09-24', '2019-11-23', 158130.0000, 31626.0000, 189756.0000, 'Aktivan'),
(118, 1, 1, '2019-09-24', '2019-10-24', 75050.0000, 12682.5000, 87732.5000, 'Aktivan'),
(119, 2, 2, '2019-09-24', '2019-11-23', 86149.5000, 17229.9000, 103379.4000, 'Aktivan'),
(120, 2, 3, '2019-09-24', '2020-01-22', 137870.0000, 24059.0000, 161929.0000, 'Aktivan');

-- --------------------------------------------------------

--
-- Table structure for table `stanje`
--

CREATE TABLE `stanje` (
  `id_artikla` int(9) NOT NULL,
  `id_magacina` int(9) NOT NULL,
  `kolicina_na_lageru` double(10,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stavke_prodaje`
--

CREATE TABLE `stavke_prodaje` (
  `id_stavke_prodaje` int(9) NOT NULL,
  `id_racuna` int(11) NOT NULL,
  `id_artikla` int(9) NOT NULL,
  `kolicina_prodaje` double(20,4) NOT NULL,
  `rabat_prodaje` double(20,4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `stavke_prodaje`
--

INSERT INTO `stavke_prodaje` (`id_stavke_prodaje`, `id_racuna`, `id_artikla`, `kolicina_prodaje`, `rabat_prodaje`) VALUES
(1, 96, 2, 10.0000, 5.0000),
(2, 96, 5, 50.0000, 10.0000),
(3, 96, 7, 20.0000, 5.0000),
(4, 96, 8, 100.0000, 10.0000),
(5, 97, 7, 10.0000, 5.0000),
(6, 97, 10, 40.0000, 10.0000),
(7, 97, 6, 35.0000, 5.0000),
(8, 97, 11, 80.0000, 5.0000),
(9, 97, 12, 30.0000, 5.0000),
(10, 98, 13, 20.0000, 5.0000),
(11, 98, 14, 15.0000, 5.0000),
(12, 98, 15, 15.0000, 5.0000),
(13, 98, 4, 45.0000, 5.0000),
(14, 98, 5, 60.0000, 5.0000),
(15, 98, 6, 10.0000, 5.0000),
(16, 98, 7, 10.0000, 5.0000),
(28, 104, 13, 15.0000, 5.0000),
(29, 104, 14, 8.0000, 5.0000),
(30, 104, 3, 30.0000, 8.0000),
(31, 104, 4, 20.0000, 4.0000),
(32, 104, 5, 15.0000, 5.0000),
(33, 105, 6, 40.0000, 5.0000),
(34, 105, 7, 25.0000, 5.0000),
(35, 105, 8, 50.0000, 3.0000),
(36, 105, 9, 45.0000, 7.0000),
(37, 105, 10, 17.0000, 5.0000),
(38, 106, 1, 5.0000, 5.0000),
(39, 106, 2, 10.0000, 5.0000),
(40, 106, 3, 35.0000, 5.0000),
(41, 107, 9, 15.0000, 5.0000),
(42, 107, 8, 15.0000, 5.0000),
(43, 108, 3, 15.0000, 5.0000),
(44, 108, 4, 15.0000, 3.0000),
(45, 108, 5, 15.0000, 3.0000),
(46, 109, 11, 10.0000, 5.0000),
(47, 109, 12, 15.0000, 5.0000),
(48, 109, 14, 5.0000, 5.0000),
(49, 110, 6, 10.0000, 5.0000),
(50, 110, 7, 10.0000, 3.0000),
(51, 110, 10, 20.0000, 5.0000),
(52, 111, 10, 15.0000, 5.0000),
(53, 111, 5, 20.0000, 5.0000),
(54, 112, 6, 10.0000, 5.0000),
(55, 112, 7, 5.0000, 5.0000),
(56, 112, 10, 10.0000, 5.0000),
(57, 113, 6, 15.0000, 5.0000),
(58, 113, 7, 15.0000, 5.0000),
(59, 114, 1, 5.0000, 5.0000),
(60, 114, 2, 8.0000, 5.0000),
(61, 114, 6, 15.0000, 3.0000),
(62, 114, 7, 15.0000, 4.0000),
(63, 115, 4, 50.0000, 3.0000),
(64, 115, 5, 35.0000, 5.0000),
(65, 115, 10, 30.0000, 4.0000),
(66, 116, 2, 8.0000, 3.0000),
(67, 116, 3, 50.0000, 4.0000),
(68, 116, 6, 10.0000, 5.0000),
(69, 116, 10, 14.0000, 4.0000),
(70, 117, 5, 80.0000, 5.0000),
(71, 117, 6, 15.0000, 5.0000),
(72, 117, 7, 20.0000, 4.0000),
(73, 118, 1, 10.0000, 5.0000),
(74, 118, 2, 10.0000, 5.0000),
(75, 118, 14, 5.0000, 5.0000),
(76, 119, 2, 5.0000, 5.0000),
(77, 119, 10, 12.0000, 4.0000),
(78, 119, 7, 10.0000, 5.0000),
(79, 120, 12, 20.0000, 4.0000),
(80, 120, 13, 10.0000, 5.0000),
(81, 120, 15, 5.0000, 5.0000);

-- --------------------------------------------------------

--
-- Table structure for table `zaposleni`
--

CREATE TABLE `zaposleni` (
  `id_zaposlenog` int(9) NOT NULL,
  `id_filijale` int(9) NOT NULL,
  `ime_zaposlenog` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prezime_zaposlenog` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `jmbg_zaposlenog` varchar(90) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresa_zaposlenog` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `grad_opstina_zaposlenog` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telefon_zaposlenog` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `e_mail_zaposlenog` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `strucna_sprema_zaposlenog` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `datum_pocetka_zaposlenja` date NOT NULL,
  `datum_zavrsetka_zaposlenja` date NOT NULL,
  `plata_zaposlenog` double NOT NULL,
  `tip_zaposlenja` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username_zaposlenog` varchar(25) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password_zaposlenog` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `zaposleni`
--

INSERT INTO `zaposleni` (`id_zaposlenog`, `id_filijale`, `ime_zaposlenog`, `prezime_zaposlenog`, `jmbg_zaposlenog`, `adresa_zaposlenog`, `grad_opstina_zaposlenog`, `telefon_zaposlenog`, `e_mail_zaposlenog`, `strucna_sprema_zaposlenog`, `datum_pocetka_zaposlenja`, `datum_zavrsetka_zaposlenja`, `plata_zaposlenog`, `tip_zaposlenja`, `username_zaposlenog`, `password_zaposlenog`) VALUES
(1, 1, 'Petar', 'Stankovic', '0123456789011', 'Cara Lazara 11', 'Kraljevo', '0648888911', 'petar@velet.com', 'VI stepen', '2019-02-04', '2019-12-31', 120000, 'Admin', 'ps', '11'),
(2, 2, 'Nemanja', 'Milosavljevic', '0123456789022', 'Cara Dušana 22', 'Vrnjacka Banja', '0648888922', 'nemanja@velet.com', 'VII stepen', '2019-02-04', '2019-12-31', 130000, 'Admin', 'nm', '22'),
(3, 3, 'Milan', 'Paunic', '0123456789033', 'Kralja Milana 33', 'Kraljevo', '0648888933', 'milan@velet.com', 'VII stepen', '2019-02-04', '2019-12-31', 110000, 'Menadžer', 'mp', '33'),
(4, 3, 'Marko', 'Jovanovic', '0123456789044', 'Kneza Miloša 44', 'Kraljevo', '0648888944', 'marko@velet.com', 'VII stepen', '2019-02-04', '2019-12-31', 100000, 'Komercijalista', 'mj', '44');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artikal`
--
ALTER TABLE `artikal`
  ADD PRIMARY KEY (`id_artikla`),
  ADD KEY `naziv_artikla` (`naziv_artikla`(191)),
  ADD KEY `id_grupe_artikala` (`id_grupe_artikala`);

--
-- Indexes for table `filijala`
--
ALTER TABLE `filijala`
  ADD PRIMARY KEY (`id_filijale`);

--
-- Indexes for table `grupa_artikala`
--
ALTER TABLE `grupa_artikala`
  ADD PRIMARY KEY (`id_grupe_artikala`);

--
-- Indexes for table `kupac`
--
ALTER TABLE `kupac`
  ADD PRIMARY KEY (`id_kupca`);

--
-- Indexes for table `magacin`
--
ALTER TABLE `magacin`
  ADD PRIMARY KEY (`id_magacina`);

--
-- Indexes for table `racun_otpremnica`
--
ALTER TABLE `racun_otpremnica`
  ADD PRIMARY KEY (`id_racuna`),
  ADD KEY `id_zaposlenog` (`id_zaposlenog`),
  ADD KEY `id_kupca` (`id_kupca`);

--
-- Indexes for table `stanje`
--
ALTER TABLE `stanje`
  ADD PRIMARY KEY (`id_artikla`,`id_magacina`),
  ADD KEY `id_artikla` (`id_artikla`),
  ADD KEY `id_magacina` (`id_magacina`);

--
-- Indexes for table `stavke_prodaje`
--
ALTER TABLE `stavke_prodaje`
  ADD PRIMARY KEY (`id_stavke_prodaje`,`id_racuna`),
  ADD KEY `id_racuna` (`id_racuna`),
  ADD KEY `id_artikla` (`id_artikla`);

--
-- Indexes for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD PRIMARY KEY (`id_zaposlenog`),
  ADD UNIQUE KEY `username_zaposlenog` (`username_zaposlenog`),
  ADD UNIQUE KEY `jmbg_zaposlenog` (`jmbg_zaposlenog`),
  ADD KEY `id_poslovnice` (`id_filijale`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artikal`
--
ALTER TABLE `artikal`
  MODIFY `id_artikla` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `filijala`
--
ALTER TABLE `filijala`
  MODIFY `id_filijale` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `grupa_artikala`
--
ALTER TABLE `grupa_artikala`
  MODIFY `id_grupe_artikala` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `kupac`
--
ALTER TABLE `kupac`
  MODIFY `id_kupca` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `magacin`
--
ALTER TABLE `magacin`
  MODIFY `id_magacina` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `racun_otpremnica`
--
ALTER TABLE `racun_otpremnica`
  MODIFY `id_racuna` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;

--
-- AUTO_INCREMENT for table `stavke_prodaje`
--
ALTER TABLE `stavke_prodaje`
  MODIFY `id_stavke_prodaje` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `zaposleni`
--
ALTER TABLE `zaposleni`
  MODIFY `id_zaposlenog` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artikal`
--
ALTER TABLE `artikal`
  ADD CONSTRAINT `artikal_ibfk_1` FOREIGN KEY (`id_grupe_artikala`) REFERENCES `grupa_artikala` (`id_grupe_artikala`);

--
-- Constraints for table `kupac`
--
ALTER TABLE `kupac`
  ADD CONSTRAINT `kupac_ibfk_1` FOREIGN KEY (`id_kupca`) REFERENCES `racun_otpremnica` (`id_kupca`);

--
-- Constraints for table `racun_otpremnica`
--
ALTER TABLE `racun_otpremnica`
  ADD CONSTRAINT `racun_otpremnica_ibfk_2` FOREIGN KEY (`id_zaposlenog`) REFERENCES `zaposleni` (`id_zaposlenog`);

--
-- Constraints for table `stanje`
--
ALTER TABLE `stanje`
  ADD CONSTRAINT `stanje_ibfk_1` FOREIGN KEY (`id_artikla`) REFERENCES `artikal` (`id_artikla`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stanje_ibfk_2` FOREIGN KEY (`id_magacina`) REFERENCES `magacin` (`id_magacina`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `stavke_prodaje`
--
ALTER TABLE `stavke_prodaje`
  ADD CONSTRAINT `stavke_prodaje_ibfk_2` FOREIGN KEY (`id_artikla`) REFERENCES `artikal` (`id_artikla`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `stavke_prodaje_ibfk_3` FOREIGN KEY (`id_racuna`) REFERENCES `racun_otpremnica` (`id_racuna`);

--
-- Constraints for table `zaposleni`
--
ALTER TABLE `zaposleni`
  ADD CONSTRAINT `zaposleni_ibfk_1` FOREIGN KEY (`id_filijale`) REFERENCES `filijala` (`id_filijale`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
