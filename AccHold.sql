-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 25 Jan 2021 pada 18.44
-- Versi server: 10.4.13-MariaDB
-- Versi PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `accholder`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `accountholder`
--

CREATE TABLE `accountholder` (
  `holder_id` int(10) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `accountholder`
--

INSERT INTO `accountholder` (`holder_id`, `name`, `address`, `email`) VALUES
(29121, 'pak admi', 'lampung', 'kerasbos'),
(11110001, 'kakaka', 'mamama', 'ksaa'),
(20200001, 'Diffa adien', 'timor lese', 'diffa@yahoo'),
(20200002, '', '', ''),
(20200003, '', '', ''),
(20200004, '', '', ''),
(20200005, '', '', ''),
(20200006, '', '', ''),
(20200007, '', '', ''),
(20200008, '', '', ''),
(20200009, '', '', '');

-- --------------------------------------------------------

--
-- Struktur dari tabel `class`
--

CREATE TABLE `class` (
  `idclass` int(12) NOT NULL,
  `classname` varchar(100) DEFAULT NULL,
  `tutor` varchar(100) DEFAULT NULL,
  `holder_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `corporateholder`
--

CREATE TABLE `corporateholder` (
  `holder_id` int(10) NOT NULL,
  `pangkat` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `corporateholder`
--

INSERT INTO `corporateholder` (`holder_id`, `pangkat`) VALUES
(29121, 'Sukarela'),
(11110001, 'Sukarela'),
(20200002, NULL),
(20200003, NULL),
(20200004, NULL),
(20200005, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `individualholder`
--

CREATE TABLE `individualholder` (
  `holder_id` int(10) NOT NULL,
  `jenjang` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `individualholder`
--

INSERT INTO `individualholder` (`holder_id`, `jenjang`) VALUES
(20200001, 'SMA 12'),
(20200006, NULL),
(20200007, NULL),
(20200008, NULL),
(20200009, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `accountholder`
--
ALTER TABLE `accountholder`
  ADD PRIMARY KEY (`holder_id`);

--
-- Indeks untuk tabel `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`idclass`),
  ADD KEY `class_ibfk_1` (`holder_id`);

--
-- Indeks untuk tabel `corporateholder`
--
ALTER TABLE `corporateholder`
  ADD PRIMARY KEY (`holder_id`);

--
-- Indeks untuk tabel `individualholder`
--
ALTER TABLE `individualholder`
  ADD PRIMARY KEY (`holder_id`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `class`
--
ALTER TABLE `class`
  ADD CONSTRAINT `class_ibfk_1` FOREIGN KEY (`holder_id`) REFERENCES `accountholder` (`holder_id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `corporateholder`
--
ALTER TABLE `corporateholder`
  ADD CONSTRAINT `corporateholder_ibfk_1` FOREIGN KEY (`holder_id`) REFERENCES `accountholder` (`holder_id`) ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `individualholder`
--
ALTER TABLE `individualholder`
  ADD CONSTRAINT `individualholder_ibfk_1` FOREIGN KEY (`holder_id`) REFERENCES `accountholder` (`holder_id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
