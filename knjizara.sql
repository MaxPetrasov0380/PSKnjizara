-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2024 at 07:55 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `knjizara`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `ID` int(11) NOT NULL,
  `KorisnickoIme` longtext NOT NULL,
  `Email` longtext NOT NULL,
  `Sifra` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`ID`, `KorisnickoIme`, `Email`, `Sifra`) VALUES
(1, 'MaxPetras0380', 'mzvara9@gmail.com', 'knjizaradb'),
(2, 'odbrana', 'odbrana@gmail.com', 'odbrana'),
(3, 'KIBOS', 'bojanv2003@gmail.com', 'jaro');

-- --------------------------------------------------------

--
-- Table structure for table `knjizara`
--

CREATE TABLE `knjizara` (
  `ID` int(11) NOT NULL,
  `Naziv` longtext NOT NULL,
  `Kolicina` longtext NOT NULL,
  `Proizvodjac` longtext NOT NULL,
  `Cena` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `knjizara`
--

INSERT INTO `knjizara` (`ID`, `Naziv`, `Kolicina`, `Proizvodjac`, `Cena`) VALUES
(1, 'Crna hemijska olovka', '12', 'Tranoscius', '60'),
(5, 'Gumica', '5', 'Straedtler', '50'),
(6, 'Sveska na kvadratice', '14', 'Zavod', '150'),
(8, 'Grafitna olovka B', '54', 'Straedtler', '80');

-- --------------------------------------------------------

--
-- Table structure for table `radnici`
--

CREATE TABLE `radnici` (
  `ID` int(11) NOT NULL,
  `Ime` longtext NOT NULL,
  `Prezime` longtext NOT NULL,
  `Brojtel` longtext NOT NULL,
  `Adresa` longtext NOT NULL,
  `Email` longtext NOT NULL,
  `PTT` bigint(20) NOT NULL,
  `SSB` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `radnici`
--

INSERT INTO `radnici` (`ID`, `Ime`, `Prezime`, `Brojtel`, `Adresa`, `Email`, `PTT`, `SSB`) VALUES
(9, 'Martin', 'Zvara', '640643000', 'Maršala Tita 88, Aradac', 'mzvara9@gmail.com', 23207, 555333),
(10, 'Bojan', 'Vasiljević', '623334465', 'Bulevar Veljka Vlahovica 57, Zrenjanin', 'bojanv2003@gmail.com', 23000, 123456);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `knjizara`
--
ALTER TABLE `knjizara`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `radnici`
--
ALTER TABLE `radnici`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `knjizara`
--
ALTER TABLE `knjizara`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `radnici`
--
ALTER TABLE `radnici`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
