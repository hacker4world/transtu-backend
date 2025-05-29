-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2025 at 02:57 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `transtu`
--

-- --------------------------------------------------------

--
-- Table structure for table `absence`
--

CREATE TABLE `absence` (
  `id` bigint(20) NOT NULL,
  `day` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `absence`
--

INSERT INTO `absence` (`id`, `day`, `month`, `year`, `agent_id`) VALUES
(1, 14, 5, 2025, 60),
(2, 14, 5, 2025, 7),
(3, 16, 5, 2025, 10),
(5, 16, 5, 2025, 57),
(7, 16, 5, 2025, 53);

-- --------------------------------------------------------

--
-- Table structure for table `agent`
--

CREATE TABLE `agent` (
  `matricule` int(11) NOT NULL,
  `code_emploi_assure` varchar(255) DEFAULT NULL,
  `code_grade` varchar(255) DEFAULT NULL,
  `date_naiss` datetime(6) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `situation_familiale` varchar(255) DEFAULT NULL,
  `code_departement` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `agent`
--

INSERT INTO `agent` (`matricule`, `code_emploi_assure`, `code_grade`, `date_naiss`, `nom`, `prenom`, `role`, `situation_familiale`, `code_departement`) VALUES
(5, 'EMP005', 'GRD005', '1983-09-12 00:00:00.000000', 'Robert', 'Jacques', 'driver', 'celibataire', 1),
(6, 'EMP006', 'GRD006', '1981-11-05 00:00:00.000000', 'Petit', 'Claude', 'driver', 'marie', 1),
(7, 'EMP007', 'GRD007', '1979-02-18 00:00:00.000000', 'Durand', 'Daniel', 'driver', 'celibataire', 1),
(8, 'EMP008', 'GRD008', '1984-04-25 00:00:00.000000', 'Leroy', 'Paul', 'driver', 'celibataire', 1),
(9, 'EMP009', 'GRD009', '1986-06-08 00:00:00.000000', 'Moreau', 'Marc', 'driver', 'divorce', 1),
(10, 'EMP010', 'GRD010', '1987-08-14 00:00:00.000000', 'Simon', 'Philippe', 'driver', 'celibataire', 1),
(51, 'EMP051', 'GRD051', '1989-10-03 00:00:00.000000', 'Laurent', 'Marie', 'receiver', 'marie', 1),
(52, 'EMP052', 'GRD052', '1990-12-19 00:00:00.000000', 'Aymen', 'Trabelsi', 'receiver', 'celibataire', 1),
(53, 'EMP053', 'GRD053', '1991-01-22 00:00:00.000000', 'Akrem', 'Jbeli', 'receiver', 'celibataire', 1),
(54, 'EMP054', 'GRD054', '1992-03-07 00:00:00.000000', 'Amir', 'Ben Abdallah', 'receiver', 'celibataire', 1),
(55, 'EMP055', 'GRD055', '1993-05-11 00:00:00.000000', 'Roux', 'Catherine', 'receiver', 'celibataire', 1),
(56, 'EMP056', 'GRD056', '1994-07-23 00:00:00.000000', 'David', 'Valérie', 'receiver', 'marie', 1),
(57, 'EMP057', 'GRD057', '1995-09-15 00:00:00.000000', 'Bertrand', 'Françoise', 'receiver', 'celibataire', 1),
(58, 'EMP058', 'GRD058', '1996-11-28 00:00:00.000000', 'Morel', 'Monique', 'receiver', 'marie', 1),
(59, 'EMP059', 'GRD059', '1997-02-04 00:00:00.000000', 'Fournier', 'Christine', 'receiver', 'divorce', 1),
(60, 'EMP060', 'GRD060', '1998-04-17 00:00:00.000000', 'Girard', 'Martine', 'receiver', 'celibataire', 1),
(101, 'EMP101', 'GRD101', '1980-06-09 00:00:00.000000', 'Bonnet', 'Alain', 'driver', 'marie', 2),
(102, 'EMP102', 'GRD102', '1982-08-21 00:00:00.000000', 'Dupont', 'Louis', 'driver', 'celibataire', 2),
(104, 'EMP104', 'GRD104', '1978-12-05 00:00:00.000000', 'Fontaine', 'Henri', 'driver', 'divorce', 2),
(105, 'EMP105', 'GRD105', '1983-01-27 00:00:00.000000', 'Rousseau', 'Étienne', 'driver', 'celibataire', 2),
(106, 'EMP106', 'GRD106', '1981-03-19 00:00:00.000000', 'Vincent', 'Georges', 'driver', 'marie', 2),
(107, 'EMP107', 'GRD107', '1979-05-11 00:00:00.000000', 'Muller', 'Patrick', 'driver', 'celibataire', 2),
(108, 'EMP108', 'GRD108', '1984-07-03 00:00:00.000000', 'Lefevre', 'Roger', 'driver', 'marie', 2),
(109, 'EMP109', 'GRD109', '1986-08-25 00:00:00.000000', 'Faure', 'Olivier', 'driver', 'divorce', 2),
(110, 'EMP110', 'GRD110', '1987-10-17 00:00:00.000000', 'Mercier', 'Nicolas', 'driver', 'celibataire', 2),
(151, 'EMP151', 'GRD151', '1989-12-09 00:00:00.000000', 'Blanc', 'Anne', 'receiver', 'marie', 2),
(152, 'EMP152', 'GRD152', '1990-02-01 00:00:00.000000', 'Guerin', 'Julie', 'receiver', 'celibataire', 2),
(153, 'EMP153', 'GRD153', '1991-03-25 00:00:00.000000', 'Boyer', 'Eliane', 'receiver', 'marie', 2),
(154, 'EMP154', 'GRD154', '1992-05-17 00:00:00.000000', 'Garnier', 'Sylvie', 'receiver', 'divorce', 2),
(155, 'EMP155', 'GRD155', '1993-07-09 00:00:00.000000', 'Chevalier', 'Dominique', 'receiver', 'celibataire', 2),
(156, 'EMP156', 'GRD156', '1994-09-01 00:00:00.000000', 'Francois', 'Hélène', 'receiver', 'marie', 2),
(157, 'EMP157', 'GRD157', '1995-10-23 00:00:00.000000', 'Legrand', 'Chantal', 'receiver', 'celibataire', 2),
(158, 'EMP158', 'GRD158', '1996-12-15 00:00:00.000000', 'Gauthier', 'Brigitte', 'receiver', 'marie', 2),
(159, 'EMP159', 'GRD159', '1997-02-07 00:00:00.000000', 'Perrot', 'Agnès', 'receiver', 'divorce', 2),
(160, 'EMP160', 'GRD160', '1998-04-01 00:00:00.000000', 'Robin', 'Geneviève', 'receiver', 'celibataire', 2),
(166, 'aziz', 'aziz', '2025-05-05 00:00:00.000000', 'aziz', 'aziz', 'receiver', 'celibataire', 1);

-- --------------------------------------------------------

--
-- Table structure for table `conge`
--

CREATE TABLE `conge` (
  `matricule` int(11) NOT NULL,
  `code_conge` varchar(255) DEFAULT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `nbr_jour` int(11) NOT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `conge`
--

INSERT INTO `conge` (`matricule`, `code_conge`, `date_debut`, `date_fin`, `nbr_jour`, `agent_id`) VALUES
(4, NULL, '2025-05-01', '2025-05-05', 4, 5);

-- --------------------------------------------------------

--
-- Table structure for table `defaillance`
--

CREATE TABLE `defaillance` (
  `matricule` int(11) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `nombre_jour` int(11) NOT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `defaillance`
--

INSERT INTO `defaillance` (`matricule`, `date_debut`, `date_fin`, `nombre_jour`, `agent_id`) VALUES
(22, '2025-05-01', '2025-05-07', 6, 5);

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`id`, `address`, `name`) VALUES
(1, 'Passage', 'Passage'),
(2, 'Bir al Qasaa', 'Bir al Qasaa');

-- --------------------------------------------------------

--
-- Table structure for table `jour_hebdomadaire`
--

CREATE TABLE `jour_hebdomadaire` (
  `matricule` int(11) NOT NULL,
  `anne_debut_repos` int(11) NOT NULL,
  `anne_fin_repos` int(11) NOT NULL,
  `code_jour` varchar(255) DEFAULT NULL,
  `jour_debut_repos` int(11) NOT NULL,
  `jour_fin_repos` int(11) NOT NULL,
  `mois_debut_repos` int(11) NOT NULL,
  `mois_fin_repos` int(11) NOT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `latency`
--

CREATE TABLE `latency` (
  `id` bigint(20) NOT NULL,
  `day` int(11) NOT NULL,
  `hours` int(11) NOT NULL,
  `minutes` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `latency`
--

INSERT INTO `latency` (`id`, `day`, `hours`, `minutes`, `month`, `year`, `agent_id`) VALUES
(1, 16, 1, 30, 5, 2025, 10),
(3, 16, 0, 0, 5, 2025, 53);

-- --------------------------------------------------------

--
-- Table structure for table `liste_tours`
--

CREATE TABLE `liste_tours` (
  `code_service` int(11) NOT NULL,
  `jour` int(11) NOT NULL,
  `mois` int(11) NOT NULL,
  `saison` varchar(255) DEFAULT NULL,
  `travail_assure` bit(1) NOT NULL,
  `travail_continue` bit(1) NOT NULL,
  `district_id` int(11) DEFAULT NULL,
  `heures_jour` int(11) NOT NULL,
  `heures_nuit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `liste_tours`
--

INSERT INTO `liste_tours` (`code_service`, `jour`, `mois`, `saison`, `travail_assure`, `travail_continue`, `district_id`, `heures_jour`, `heures_nuit`) VALUES
(101, 1, 1, 'winter', b'1', b'1', 1, 8, 0),
(102, 1, 1, 'winter', b'1', b'0', 1, 0, 6),
(103, 1, 2, 'winter', b'1', b'1', 1, 7, 0),
(104, 1, 2, 'winter', b'0', b'1', 1, 0, 5),
(105, 1, 3, 'spring', b'1', b'0', 1, 6, 0),
(106, 1, 3, 'spring', b'1', b'1', 1, 0, 7),
(107, 1, 4, 'spring', b'0', b'0', 1, 8, 0),
(108, 1, 4, 'spring', b'1', b'1', 1, 0, 6),
(109, 1, 5, 'spring', b'1', b'0', 1, 5, 0),
(110, 1, 5, 'spring', b'0', b'1', 1, 0, 8),
(111, 1, 6, 'summer', b'1', b'1', 1, 7, 0),
(112, 1, 6, 'summer', b'1', b'0', 1, 0, 6),
(113, 1, 7, 'summer', b'0', b'1', 1, 8, 0),
(114, 1, 7, 'summer', b'1', b'1', 1, 0, 5),
(115, 1, 8, 'summer', b'1', b'0', 1, 6, 0),
(116, 1, 8, 'summer', b'0', b'1', 1, 0, 7),
(117, 1, 9, 'autumn', b'1', b'1', 1, 8, 0),
(118, 1, 9, 'autumn', b'1', b'0', 1, 0, 6),
(119, 1, 10, 'autumn', b'0', b'1', 1, 5, 0),
(120, 1, 10, 'autumn', b'1', b'1', 1, 0, 8),
(121, 1, 11, 'autumn', b'1', b'0', 1, 7, 0),
(122, 1, 11, 'autumn', b'0', b'1', 1, 0, 6),
(123, 1, 12, 'winter', b'1', b'1', 1, 8, 0),
(124, 1, 12, 'winter', b'1', b'0', 1, 0, 5),
(125, 1, 1, 'winter', b'0', b'1', 1, 7, 0),
(126, 2, 1, 'winter', b'1', b'1', 1, 0, 6),
(127, 2, 1, 'winter', b'1', b'0', 1, 8, 0),
(128, 2, 2, 'winter', b'1', b'1', 1, 0, 7),
(129, 2, 2, 'winter', b'0', b'1', 1, 5, 0),
(130, 2, 3, 'spring', b'1', b'0', 1, 0, 8),
(131, 2, 3, 'spring', b'1', b'1', 1, 6, 0),
(132, 2, 4, 'spring', b'0', b'0', 1, 0, 7),
(133, 2, 4, 'spring', b'1', b'1', 1, 8, 0),
(134, 2, 5, 'spring', b'1', b'0', 1, 0, 6),
(135, 2, 5, 'spring', b'0', b'1', 1, 5, 0),
(136, 2, 6, 'summer', b'1', b'1', 1, 0, 7),
(137, 2, 6, 'summer', b'1', b'0', 1, 8, 0),
(138, 2, 7, 'summer', b'0', b'1', 1, 0, 6),
(139, 2, 7, 'summer', b'1', b'1', 1, 5, 0),
(140, 2, 8, 'summer', b'1', b'0', 1, 0, 8),
(141, 2, 8, 'summer', b'0', b'1', 1, 7, 0),
(142, 2, 9, 'autumn', b'1', b'1', 1, 0, 6),
(143, 2, 9, 'autumn', b'1', b'0', 1, 8, 0),
(144, 2, 10, 'autumn', b'0', b'1', 1, 0, 5),
(145, 2, 10, 'autumn', b'1', b'1', 1, 7, 0),
(146, 2, 11, 'autumn', b'1', b'0', 1, 0, 8),
(147, 2, 11, 'autumn', b'0', b'1', 1, 6, 0),
(148, 2, 12, 'winter', b'1', b'1', 1, 0, 7),
(149, 2, 12, 'winter', b'1', b'0', 1, 8, 0),
(150, 2, 1, 'winter', b'0', b'1', 1, 0, 6),
(151, 3, 1, 'winter', b'1', b'1', 1, 7, 0),
(152, 3, 1, 'winter', b'1', b'0', 1, 0, 6),
(153, 3, 2, 'winter', b'1', b'1', 1, 5, 0),
(154, 3, 2, 'winter', b'0', b'1', 1, 0, 8),
(155, 3, 3, 'spring', b'1', b'0', 1, 7, 0),
(156, 3, 3, 'spring', b'1', b'1', 1, 0, 6),
(157, 3, 4, 'spring', b'0', b'0', 1, 8, 0),
(158, 3, 4, 'spring', b'1', b'1', 1, 0, 5),
(159, 3, 5, 'spring', b'1', b'0', 1, 7, 0),
(160, 3, 5, 'spring', b'0', b'1', 1, 0, 8),
(161, 3, 6, 'summer', b'1', b'1', 1, 6, 0),
(162, 3, 6, 'summer', b'1', b'0', 1, 0, 7),
(163, 3, 7, 'summer', b'0', b'1', 1, 8, 0),
(164, 3, 7, 'summer', b'1', b'1', 1, 0, 6),
(165, 3, 8, 'summer', b'1', b'0', 1, 5, 0),
(166, 3, 8, 'summer', b'0', b'1', 1, 0, 8),
(167, 3, 9, 'autumn', b'1', b'1', 1, 7, 0),
(168, 3, 9, 'autumn', b'1', b'0', 1, 0, 6),
(169, 3, 10, 'autumn', b'0', b'1', 1, 8, 0),
(170, 3, 10, 'autumn', b'1', b'1', 1, 0, 5),
(171, 3, 11, 'autumn', b'1', b'0', 1, 7, 0),
(172, 3, 11, 'autumn', b'0', b'1', 1, 0, 8),
(173, 3, 12, 'winter', b'1', b'1', 1, 6, 0),
(174, 3, 12, 'winter', b'1', b'0', 1, 0, 7),
(175, 3, 1, 'winter', b'0', b'1', 1, 8, 0),
(176, 4, 1, 'winter', b'1', b'1', 1, 0, 5),
(177, 4, 1, 'winter', b'1', b'0', 1, 7, 0),
(178, 4, 2, 'winter', b'1', b'1', 1, 0, 8),
(179, 4, 2, 'winter', b'0', b'1', 1, 6, 0),
(180, 4, 3, 'spring', b'1', b'0', 1, 0, 7),
(181, 4, 3, 'spring', b'1', b'1', 1, 8, 0),
(182, 4, 4, 'spring', b'0', b'0', 1, 0, 6),
(183, 4, 4, 'spring', b'1', b'1', 1, 5, 0),
(184, 4, 5, 'spring', b'1', b'0', 1, 0, 8),
(185, 4, 5, 'spring', b'0', b'1', 1, 7, 0),
(186, 4, 6, 'summer', b'1', b'1', 1, 0, 6),
(187, 4, 6, 'summer', b'1', b'0', 1, 8, 0),
(188, 4, 7, 'summer', b'0', b'1', 1, 0, 5),
(189, 4, 7, 'summer', b'1', b'1', 1, 7, 0),
(190, 4, 8, 'summer', b'1', b'0', 1, 0, 8),
(191, 4, 8, 'summer', b'0', b'1', 1, 6, 0),
(192, 4, 9, 'autumn', b'1', b'1', 1, 0, 7),
(193, 4, 9, 'autumn', b'1', b'0', 1, 8, 0),
(194, 4, 10, 'autumn', b'0', b'1', 1, 0, 6),
(195, 4, 10, 'autumn', b'1', b'1', 1, 5, 0),
(196, 4, 11, 'autumn', b'1', b'0', 1, 0, 8),
(197, 4, 11, 'autumn', b'0', b'1', 1, 7, 0),
(198, 4, 12, 'winter', b'1', b'1', 1, 0, 6),
(199, 4, 12, 'winter', b'1', b'0', 1, 8, 0),
(200, 4, 1, 'winter', b'0', b'1', 1, 0, 5),
(201, 5, 1, 'winter', b'1', b'1', 1, 6, 0),
(202, 5, 1, 'winter', b'1', b'0', 1, 0, 7),
(203, 5, 2, 'winter', b'1', b'1', 1, 8, 0),
(204, 5, 2, 'winter', b'0', b'1', 1, 0, 5),
(205, 5, 3, 'spring', b'1', b'0', 1, 7, 0),
(206, 5, 3, 'spring', b'1', b'1', 1, 0, 8),
(207, 5, 4, 'spring', b'0', b'0', 1, 6, 0),
(208, 5, 4, 'spring', b'1', b'1', 1, 0, 7),
(209, 5, 5, 'spring', b'1', b'0', 1, 8, 0),
(210, 5, 5, 'spring', b'0', b'1', 1, 0, 6),
(211, 5, 6, 'summer', b'1', b'1', 1, 5, 0),
(212, 5, 6, 'summer', b'1', b'0', 1, 0, 8),
(213, 5, 7, 'summer', b'0', b'1', 1, 7, 0),
(214, 5, 7, 'summer', b'1', b'1', 1, 0, 6),
(215, 5, 8, 'summer', b'1', b'0', 1, 8, 0),
(216, 5, 8, 'summer', b'0', b'1', 1, 0, 5),
(217, 5, 9, 'autumn', b'1', b'1', 1, 7, 0),
(218, 5, 9, 'autumn', b'1', b'0', 1, 0, 8),
(219, 5, 10, 'autumn', b'0', b'1', 1, 6, 0),
(220, 5, 10, 'autumn', b'1', b'1', 1, 0, 7),
(221, 5, 11, 'autumn', b'1', b'0', 1, 8, 0),
(222, 5, 11, 'autumn', b'0', b'1', 1, 0, 6),
(223, 5, 12, 'winter', b'1', b'1', 1, 5, 0),
(224, 5, 12, 'winter', b'1', b'0', 1, 0, 8),
(225, 5, 1, 'winter', b'0', b'1', 1, 7, 0),
(226, 6, 1, 'winter', b'1', b'1', 1, 0, 6),
(227, 6, 1, 'winter', b'1', b'0', 1, 8, 0),
(228, 6, 2, 'winter', b'1', b'1', 1, 0, 7),
(229, 6, 2, 'winter', b'0', b'1', 1, 5, 0),
(230, 6, 3, 'spring', b'1', b'0', 1, 0, 8),
(231, 6, 3, 'spring', b'1', b'1', 1, 7, 0),
(232, 6, 4, 'spring', b'0', b'0', 1, 0, 6),
(233, 6, 4, 'spring', b'1', b'1', 1, 8, 0),
(234, 6, 5, 'spring', b'1', b'0', 1, 0, 5),
(235, 6, 5, 'spring', b'0', b'1', 1, 7, 0),
(236, 6, 6, 'summer', b'1', b'1', 1, 0, 8),
(237, 6, 6, 'summer', b'1', b'0', 1, 6, 0),
(238, 6, 7, 'summer', b'0', b'1', 1, 0, 7),
(239, 6, 7, 'summer', b'1', b'1', 1, 8, 0),
(240, 6, 8, 'summer', b'1', b'0', 1, 0, 6),
(241, 6, 8, 'summer', b'0', b'1', 1, 5, 0),
(242, 6, 9, 'autumn', b'1', b'1', 1, 0, 8),
(243, 6, 9, 'autumn', b'1', b'0', 1, 7, 0),
(244, 6, 10, 'autumn', b'0', b'1', 1, 0, 6),
(245, 6, 10, 'autumn', b'1', b'1', 1, 8, 0),
(246, 6, 11, 'autumn', b'1', b'0', 1, 0, 5),
(247, 6, 11, 'autumn', b'0', b'1', 1, 7, 0),
(248, 6, 12, 'winter', b'1', b'1', 1, 0, 8),
(249, 6, 12, 'winter', b'1', b'0', 1, 6, 0),
(250, 6, 1, 'winter', b'0', b'1', 1, 0, 7),
(251, 7, 1, 'winter', b'1', b'1', 1, 8, 0),
(252, 7, 1, 'winter', b'1', b'0', 1, 0, 6),
(253, 7, 2, 'winter', b'1', b'1', 1, 7, 0),
(254, 7, 2, 'winter', b'0', b'1', 1, 0, 5),
(255, 7, 3, 'spring', b'1', b'0', 1, 8, 0),
(256, 7, 3, 'spring', b'1', b'1', 1, 0, 7),
(257, 7, 4, 'spring', b'0', b'0', 1, 6, 0),
(258, 7, 4, 'spring', b'1', b'1', 1, 0, 8),
(259, 7, 5, 'spring', b'1', b'0', 1, 5, 0),
(260, 7, 5, 'spring', b'0', b'1', 1, 0, 7),
(261, 7, 6, 'summer', b'1', b'1', 1, 8, 0),
(262, 7, 6, 'summer', b'1', b'0', 1, 0, 6),
(263, 7, 7, 'summer', b'0', b'1', 1, 7, 0),
(264, 7, 7, 'summer', b'1', b'1', 1, 0, 5),
(265, 7, 8, 'summer', b'1', b'0', 1, 8, 0),
(266, 7, 8, 'summer', b'0', b'1', 1, 0, 7),
(267, 7, 9, 'autumn', b'1', b'1', 1, 6, 0),
(268, 7, 9, 'autumn', b'1', b'0', 1, 0, 8),
(269, 7, 10, 'autumn', b'0', b'1', 1, 5, 0),
(270, 7, 10, 'autumn', b'1', b'1', 1, 0, 7),
(271, 7, 11, 'autumn', b'1', b'0', 1, 8, 0),
(272, 7, 11, 'autumn', b'0', b'1', 1, 0, 6),
(273, 7, 12, 'winter', b'1', b'1', 1, 7, 0),
(274, 7, 12, 'winter', b'1', b'0', 1, 0, 5),
(275, 7, 1, 'winter', b'0', b'1', 1, 8, 0),
(276, 1, 1, 'winter', b'1', b'1', 2, 0, 7),
(277, 1, 1, 'winter', b'1', b'0', 2, 6, 0),
(278, 1, 2, 'winter', b'1', b'1', 2, 0, 8),
(279, 1, 2, 'winter', b'0', b'1', 2, 5, 0),
(280, 1, 3, 'spring', b'1', b'0', 2, 0, 7),
(281, 1, 3, 'spring', b'1', b'1', 2, 8, 0),
(282, 1, 4, 'spring', b'0', b'0', 2, 0, 6),
(283, 1, 4, 'spring', b'1', b'1', 2, 7, 0),
(284, 1, 5, 'spring', b'1', b'0', 2, 0, 5),
(285, 1, 5, 'spring', b'0', b'1', 2, 8, 0),
(286, 1, 6, 'summer', b'1', b'1', 2, 0, 7),
(287, 1, 6, 'summer', b'1', b'0', 2, 6, 0),
(288, 1, 7, 'summer', b'0', b'1', 2, 0, 8),
(289, 1, 7, 'summer', b'1', b'1', 2, 5, 0),
(290, 1, 8, 'summer', b'1', b'0', 2, 0, 7),
(291, 1, 8, 'summer', b'0', b'1', 2, 8, 0),
(292, 1, 9, 'autumn', b'1', b'1', 2, 0, 6),
(293, 1, 9, 'autumn', b'1', b'0', 2, 7, 0),
(294, 1, 10, 'autumn', b'0', b'1', 2, 0, 5),
(295, 1, 10, 'autumn', b'1', b'1', 2, 8, 0),
(296, 1, 11, 'autumn', b'1', b'0', 2, 0, 7),
(297, 1, 11, 'autumn', b'0', b'1', 2, 6, 0),
(298, 1, 12, 'winter', b'1', b'1', 2, 0, 8),
(299, 1, 12, 'winter', b'1', b'0', 2, 5, 0),
(300, 1, 1, 'winter', b'0', b'1', 2, 0, 7),
(301, 2, 1, 'winter', b'1', b'1', 2, 7, 0),
(302, 2, 1, 'winter', b'1', b'0', 2, 0, 6),
(303, 2, 2, 'winter', b'1', b'1', 2, 5, 0),
(304, 2, 2, 'winter', b'0', b'1', 2, 0, 8),
(305, 2, 3, 'spring', b'1', b'0', 2, 7, 0),
(306, 2, 3, 'spring', b'1', b'1', 2, 0, 6),
(307, 2, 4, 'spring', b'0', b'0', 2, 8, 0),
(308, 2, 4, 'spring', b'1', b'1', 2, 0, 5),
(309, 2, 5, 'spring', b'1', b'0', 2, 7, 0),
(310, 2, 5, 'spring', b'0', b'1', 2, 0, 8),
(311, 2, 6, 'summer', b'1', b'1', 2, 6, 0),
(312, 2, 6, 'summer', b'1', b'0', 2, 0, 7),
(313, 2, 7, 'summer', b'0', b'1', 2, 8, 0),
(314, 2, 7, 'summer', b'1', b'1', 2, 0, 6),
(315, 2, 8, 'summer', b'1', b'0', 2, 5, 0),
(316, 2, 8, 'summer', b'0', b'1', 2, 0, 8),
(317, 2, 9, 'autumn', b'1', b'1', 2, 7, 0),
(318, 2, 9, 'autumn', b'1', b'0', 2, 0, 6),
(319, 2, 10, 'autumn', b'0', b'1', 2, 8, 0),
(320, 2, 10, 'autumn', b'1', b'1', 2, 0, 5),
(321, 2, 11, 'autumn', b'1', b'0', 2, 7, 0),
(322, 2, 11, 'autumn', b'0', b'1', 2, 0, 8),
(323, 2, 12, 'winter', b'1', b'1', 2, 6, 0),
(324, 2, 12, 'winter', b'1', b'0', 2, 0, 7),
(325, 2, 1, 'winter', b'0', b'1', 2, 8, 0),
(326, 3, 1, 'winter', b'1', b'1', 2, 0, 5),
(327, 3, 1, 'winter', b'1', b'0', 2, 7, 0),
(328, 3, 2, 'winter', b'1', b'1', 2, 0, 8),
(329, 3, 2, 'winter', b'0', b'1', 2, 6, 0),
(330, 3, 3, 'spring', b'1', b'0', 2, 0, 7),
(331, 3, 3, 'spring', b'1', b'1', 2, 8, 0),
(332, 3, 4, 'spring', b'0', b'0', 2, 0, 6),
(333, 3, 4, 'spring', b'1', b'1', 2, 5, 0),
(334, 3, 5, 'spring', b'1', b'0', 2, 0, 8),
(335, 3, 5, 'spring', b'0', b'1', 2, 7, 0),
(336, 3, 6, 'summer', b'1', b'1', 2, 0, 6),
(337, 3, 6, 'summer', b'1', b'0', 2, 8, 0),
(338, 3, 7, 'summer', b'0', b'1', 2, 0, 5),
(339, 3, 7, 'summer', b'1', b'1', 2, 7, 0),
(340, 3, 8, 'summer', b'1', b'0', 2, 0, 8),
(341, 3, 8, 'summer', b'0', b'1', 2, 6, 0),
(342, 3, 9, 'autumn', b'1', b'1', 2, 0, 7),
(343, 3, 9, 'autumn', b'1', b'0', 2, 8, 0),
(344, 3, 10, 'autumn', b'0', b'1', 2, 0, 6),
(345, 3, 10, 'autumn', b'1', b'1', 2, 5, 0),
(346, 3, 11, 'autumn', b'1', b'0', 2, 0, 8),
(347, 3, 11, 'autumn', b'0', b'1', 2, 7, 0),
(348, 3, 12, 'winter', b'1', b'1', 2, 0, 6),
(349, 3, 12, 'winter', b'1', b'0', 2, 8, 0),
(350, 3, 1, 'winter', b'0', b'1', 2, 0, 5),
(351, 4, 1, 'winter', b'1', b'1', 2, 6, 0),
(352, 4, 1, 'winter', b'1', b'0', 2, 0, 7),
(353, 4, 2, 'winter', b'1', b'1', 2, 8, 0),
(354, 4, 2, 'winter', b'0', b'1', 2, 0, 5),
(355, 4, 3, 'spring', b'1', b'0', 2, 7, 0),
(356, 4, 3, 'spring', b'1', b'1', 2, 0, 8),
(357, 4, 4, 'spring', b'0', b'0', 2, 6, 0),
(358, 4, 4, 'spring', b'1', b'1', 2, 0, 7),
(359, 4, 5, 'spring', b'1', b'0', 2, 8, 0),
(360, 4, 5, 'spring', b'0', b'1', 2, 0, 6),
(361, 4, 6, 'summer', b'1', b'1', 2, 5, 0),
(362, 4, 6, 'summer', b'1', b'0', 2, 0, 8),
(363, 4, 7, 'summer', b'0', b'1', 2, 7, 0),
(364, 4, 7, 'summer', b'1', b'1', 2, 0, 6),
(365, 4, 8, 'summer', b'1', b'0', 2, 8, 0),
(366, 4, 8, 'summer', b'0', b'1', 2, 0, 5),
(367, 4, 9, 'autumn', b'1', b'1', 2, 7, 0),
(368, 4, 9, 'autumn', b'1', b'0', 2, 0, 8),
(369, 4, 10, 'autumn', b'0', b'1', 2, 6, 0),
(370, 4, 10, 'autumn', b'1', b'1', 2, 0, 7),
(371, 4, 11, 'autumn', b'1', b'0', 2, 8, 0),
(372, 4, 11, 'autumn', b'0', b'1', 2, 0, 6),
(373, 4, 12, 'winter', b'1', b'1', 2, 5, 0),
(374, 4, 12, 'winter', b'1', b'0', 2, 0, 8),
(375, 4, 1, 'winter', b'0', b'1', 2, 7, 0),
(376, 5, 1, 'winter', b'1', b'1', 2, 0, 6),
(377, 5, 1, 'winter', b'1', b'0', 2, 8, 0),
(378, 5, 2, 'winter', b'1', b'1', 2, 0, 7),
(379, 5, 2, 'winter', b'0', b'1', 2, 5, 0),
(380, 5, 3, 'spring', b'1', b'0', 2, 0, 8),
(381, 5, 3, 'spring', b'1', b'1', 2, 7, 0),
(382, 5, 4, 'spring', b'0', b'0', 2, 0, 6),
(383, 5, 4, 'spring', b'1', b'1', 2, 8, 0),
(384, 5, 5, 'spring', b'1', b'0', 2, 0, 5),
(385, 5, 5, 'spring', b'0', b'1', 2, 7, 0),
(386, 5, 6, 'summer', b'1', b'1', 2, 0, 8),
(387, 5, 6, 'summer', b'1', b'0', 2, 6, 0),
(388, 5, 7, 'summer', b'0', b'1', 2, 0, 7),
(389, 5, 7, 'summer', b'1', b'1', 2, 8, 0),
(390, 5, 8, 'summer', b'1', b'0', 2, 0, 6),
(391, 5, 8, 'summer', b'0', b'1', 2, 5, 0),
(392, 5, 9, 'autumn', b'1', b'1', 2, 0, 8),
(393, 5, 9, 'autumn', b'1', b'0', 2, 7, 0),
(394, 5, 10, 'autumn', b'0', b'1', 2, 0, 6),
(395, 5, 10, 'autumn', b'1', b'1', 2, 8, 0),
(396, 5, 11, 'autumn', b'1', b'0', 2, 0, 5),
(397, 5, 11, 'autumn', b'0', b'1', 2, 7, 0),
(398, 5, 12, 'winter', b'1', b'1', 2, 0, 8),
(399, 5, 12, 'winter', b'1', b'0', 2, 6, 0),
(400, 5, 1, 'winter', b'0', b'1', 2, 0, 7),
(401, 6, 1, 'winter', b'1', b'1', 2, 8, 0),
(402, 6, 1, 'winter', b'1', b'0', 2, 0, 6),
(403, 6, 2, 'winter', b'1', b'1', 2, 7, 0),
(404, 6, 2, 'winter', b'0', b'1', 2, 0, 5),
(405, 6, 3, 'spring', b'1', b'0', 2, 8, 0),
(406, 6, 3, 'spring', b'1', b'1', 2, 0, 7),
(407, 6, 4, 'spring', b'0', b'0', 2, 6, 0),
(408, 6, 4, 'spring', b'1', b'1', 2, 0, 8),
(409, 6, 5, 'spring', b'1', b'0', 2, 5, 0),
(410, 6, 5, 'spring', b'0', b'1', 2, 0, 7),
(411, 6, 6, 'summer', b'1', b'1', 2, 8, 0),
(412, 6, 6, 'summer', b'1', b'0', 2, 0, 6),
(413, 6, 7, 'summer', b'0', b'1', 2, 7, 0),
(414, 6, 7, 'summer', b'1', b'1', 2, 0, 5),
(415, 6, 8, 'summer', b'1', b'0', 2, 8, 0),
(416, 6, 8, 'summer', b'0', b'1', 2, 0, 7),
(417, 6, 9, 'autumn', b'1', b'1', 2, 6, 0),
(418, 6, 9, 'autumn', b'1', b'0', 2, 0, 8),
(419, 6, 10, 'autumn', b'0', b'1', 2, 5, 0),
(420, 6, 10, 'autumn', b'1', b'1', 2, 0, 7),
(421, 6, 11, 'autumn', b'1', b'0', 2, 8, 0),
(422, 6, 11, 'autumn', b'0', b'1', 2, 0, 6),
(423, 6, 12, 'winter', b'1', b'1', 2, 7, 0),
(424, 6, 12, 'winter', b'1', b'0', 2, 0, 5),
(425, 6, 1, 'winter', b'0', b'1', 2, 8, 0),
(426, 7, 1, 'winter', b'1', b'1', 2, 0, 6),
(427, 7, 1, 'winter', b'1', b'0', 2, 7, 0),
(428, 7, 2, 'winter', b'1', b'1', 2, 0, 8),
(429, 7, 2, 'winter', b'0', b'1', 2, 5, 0),
(430, 7, 3, 'spring', b'1', b'0', 2, 0, 7),
(431, 7, 3, 'spring', b'1', b'1', 2, 8, 0),
(432, 7, 4, 'spring', b'0', b'0', 2, 0, 6),
(433, 7, 4, 'spring', b'1', b'1', 2, 7, 0),
(434, 7, 5, 'spring', b'1', b'0', 2, 0, 5),
(435, 7, 5, 'spring', b'0', b'1', 2, 8, 0),
(436, 7, 6, 'summer', b'1', b'1', 2, 0, 7),
(437, 7, 6, 'summer', b'1', b'0', 2, 6, 0),
(438, 7, 7, 'summer', b'0', b'1', 2, 0, 8),
(439, 7, 7, 'summer', b'1', b'1', 2, 5, 0),
(440, 7, 8, 'summer', b'1', b'0', 2, 0, 7),
(441, 7, 8, 'summer', b'0', b'1', 2, 8, 0),
(442, 7, 9, 'autumn', b'1', b'1', 2, 0, 6),
(443, 7, 9, 'autumn', b'1', b'0', 2, 7, 0),
(444, 7, 10, 'autumn', b'0', b'1', 2, 0, 5),
(445, 7, 10, 'autumn', b'1', b'1', 2, 8, 0),
(446, 7, 11, 'autumn', b'1', b'0', 2, 0, 7),
(447, 7, 11, 'autumn', b'0', b'1', 2, 6, 0),
(448, 7, 12, 'winter', b'1', b'1', 2, 0, 8),
(449, 7, 12, 'winter', b'1', b'0', 2, 5, 0),
(450, 7, 1, 'winter', b'0', b'1', 2, 0, 6);

-- --------------------------------------------------------

--
-- Table structure for table `pointage_hebdomadaire`
--

CREATE TABLE `pointage_hebdomadaire` (
  `matricule` int(11) NOT NULL,
  `anne` int(11) NOT NULL,
  `heure_25` int(11) NOT NULL,
  `heure_50` int(11) NOT NULL,
  `heure_ferie` int(11) NOT NULL,
  `heure_normale` int(11) NOT NULL,
  `heure_nuit` int(11) NOT NULL,
  `jour` int(11) NOT NULL,
  `mois` int(11) NOT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pointage_journalier`
--

CREATE TABLE `pointage_journalier` (
  `matricule` int(11) NOT NULL,
  `anne` int(11) NOT NULL,
  `code_service` int(11) NOT NULL,
  `heure_continue` int(11) NOT NULL,
  `heure_jour` int(11) NOT NULL,
  `heure_nuit` int(11) NOT NULL,
  `jour` int(11) NOT NULL,
  `mois` int(11) NOT NULL,
  `num_service` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pointage_mensuel`
--

CREATE TABLE `pointage_mensuel` (
  `matricule` int(11) NOT NULL,
  `anne` int(11) NOT NULL,
  `heure_25` int(11) NOT NULL,
  `heure_50` int(11) NOT NULL,
  `heure_ferie` int(11) NOT NULL,
  `heure_normale` int(11) NOT NULL,
  `heure_nuit` int(11) NOT NULL,
  `jour` int(11) NOT NULL,
  `mois` int(11) NOT NULL,
  `agent_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tour_service`
--

CREATE TABLE `tour_service` (
  `id` bigint(20) NOT NULL,
  `day` int(11) NOT NULL,
  `month` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `driver_id` int(11) DEFAULT NULL,
  `receiver_id` int(11) DEFAULT NULL,
  `tour_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tour_service`
--

INSERT INTO `tour_service` (`id`, `day`, `month`, `year`, `driver_id`, `receiver_id`, `tour_id`) VALUES
(4, 0, 0, 0, NULL, 56, 105),
(5, 0, 0, 0, 6, 51, 106),
(6, 0, 0, 0, 8, 52, 107),
(7, 0, 0, 0, 5, 55, 108),
(8, 0, 0, 0, NULL, 58, 109),
(9, 0, 0, 0, 7, 60, 110),
(14, 14, 5, 2025, 7, 60, 159),
(15, 14, 5, 2025, NULL, 55, 160),
(16, 16, 5, 2025, NULL, 57, 180),
(17, 16, 5, 2025, NULL, 59, 181),
(18, 16, 5, 2025, NULL, 53, 182),
(19, 16, 5, 2025, 7, 60, 183),
(20, 16, 5, 2025, 5, 56, 184),
(21, 16, 5, 2025, 6, 55, 185),
(22, 19, 5, 2025, 9, 59, 105),
(23, 19, 5, 2025, 7, 51, 106),
(24, 19, 5, 2025, 6, 56, 107),
(25, 19, 5, 2025, 5, 57, 108),
(26, 19, 5, 2025, 8, 60, 109),
(27, 19, 5, 2025, NULL, 55, 110),
(28, 21, 5, 2025, 5, 51, 155),
(29, 21, 5, 2025, 10, NULL, 156),
(30, 21, 5, 2025, 8, 59, 157),
(31, 21, 5, 2025, 9, 52, 158),
(32, 21, 5, 2025, 6, 166, 159),
(33, 21, 5, 2025, 7, 55, 160),
(34, 16, 5, 2025, 5, 59, 180),
(35, 16, 5, 2025, 9, 58, 181),
(36, 16, 5, 2025, 7, 54, 182),
(37, 16, 5, 2025, 8, 51, 183),
(38, 16, 5, 2025, 10, 60, 184),
(39, 16, 5, 2025, 6, 56, 185),
(40, 21, 5, 2025, 8, 57, 155),
(41, 21, 5, 2025, 9, 59, 156),
(42, 21, 5, 2025, 5, 53, 157),
(43, 21, 5, 2025, 6, 60, 158),
(44, 21, 5, 2025, 7, NULL, 159),
(45, 21, 5, 2025, 10, 51, 160),
(46, 21, 5, 2025, 5, 58, 155),
(47, 21, 5, 2025, 7, 166, 156),
(48, 21, 5, 2025, 6, 56, 157),
(49, 21, 5, 2025, 10, 55, 158),
(50, 21, 5, 2025, 8, 54, 159),
(51, 21, 5, 2025, 9, 57, 160),
(52, 21, 5, 2025, 8, NULL, 155),
(53, 21, 5, 2025, 9, 52, 156),
(54, 21, 5, 2025, 7, 51, 157),
(55, 21, 5, 2025, 10, 58, 158),
(56, 21, 5, 2025, 6, 57, 159),
(57, 21, 5, 2025, 5, 54, 160),
(58, 21, 5, 2025, 8, 54, 155),
(59, 21, 5, 2025, 10, 59, 156),
(60, 21, 5, 2025, 9, 55, 157),
(61, 21, 5, 2025, 5, 51, 158),
(62, 21, 5, 2025, 6, 56, 159),
(63, 21, 5, 2025, 7, 60, 160),
(64, 21, 5, 2025, 5, 52, 155),
(65, 21, 5, 2025, 7, 59, 156),
(66, 21, 5, 2025, 8, NULL, 157),
(67, 21, 5, 2025, 6, 57, 158),
(68, 21, 5, 2025, 9, 56, 159),
(69, 21, 5, 2025, 10, 55, 160),
(70, 21, 5, 2025, 9, 59, 155),
(71, 21, 5, 2025, 8, 57, 156),
(72, 21, 5, 2025, 10, 58, 157),
(73, 21, 5, 2025, 5, 51, 158),
(74, 21, 5, 2025, 7, 55, 159),
(75, 21, 5, 2025, 6, 166, 160),
(76, 21, 5, 2025, 5, 55, 155),
(77, 21, 5, 2025, 10, 53, 156),
(78, 21, 5, 2025, 7, 51, 157),
(79, 21, 5, 2025, 9, 52, 158),
(80, 21, 5, 2025, 6, 166, 159),
(81, 21, 5, 2025, 8, NULL, 160);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `matricule` int(11) NOT NULL,
  `code_reset` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `departement_id` int(11) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`matricule`, `code_reset`, `email`, `nom`, `password`, `prenom`, `role`, `departement_id`, `district_id`) VALUES
(1, '26567', 'zonegaming514@gmail.com', 'abdelaziz', '1234567890', 'arfaoui', 'inspecteur', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrsq0srukhi6tcl9bd7g13gfna` (`agent_id`);

--
-- Indexes for table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FKihv2v47n02505sgqchy14taom` (`code_departement`);

--
-- Indexes for table `conge`
--
ALTER TABLE `conge`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FKbg9uavsyqkqqyr2se7hir5nua` (`agent_id`);

--
-- Indexes for table `defaillance`
--
ALTER TABLE `defaillance`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FK9pv9x2jod4poga6op7s5myh5n` (`agent_id`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `jour_hebdomadaire`
--
ALTER TABLE `jour_hebdomadaire`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FK57j785g7mv5d6hid9o67efl3v` (`agent_id`);

--
-- Indexes for table `latency`
--
ALTER TABLE `latency`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdrfmdwxmopfy1qaqe99495abs` (`agent_id`);

--
-- Indexes for table `liste_tours`
--
ALTER TABLE `liste_tours`
  ADD PRIMARY KEY (`code_service`),
  ADD KEY `FKb2jictftosftj91in5rh0ha3s` (`district_id`);

--
-- Indexes for table `pointage_hebdomadaire`
--
ALTER TABLE `pointage_hebdomadaire`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FKplwdohw2kofk7mjyn47kgur50` (`agent_id`);

--
-- Indexes for table `pointage_journalier`
--
ALTER TABLE `pointage_journalier`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FKq56b7oe68d2p49wytr7hygn7g` (`agent_id`);

--
-- Indexes for table `pointage_mensuel`
--
ALTER TABLE `pointage_mensuel`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FKesco13ogdnlk8rntrd2xl9eo7` (`agent_id`);

--
-- Indexes for table `tour_service`
--
ALTER TABLE `tour_service`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6w6arcgvumm45vecpb8v76yrj` (`driver_id`),
  ADD KEY `FK2jqdk9gsvb3x7l2mabtdvc7fa` (`receiver_id`),
  ADD KEY `FKfxv1l6mralakbxo1h6eui932h` (`tour_id`);

--
-- Indexes for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`matricule`),
  ADD KEY `FKkpnqsi0c83k87e1fodny2d05t` (`departement_id`),
  ADD KEY `FK1ubkos2q4w726tjxsl4srx3p0` (`district_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absence`
--
ALTER TABLE `absence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `agent`
--
ALTER TABLE `agent`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=169;

--
-- AUTO_INCREMENT for table `conge`
--
ALTER TABLE `conge`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `defaillance`
--
ALTER TABLE `defaillance`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `district`
--
ALTER TABLE `district`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `jour_hebdomadaire`
--
ALTER TABLE `jour_hebdomadaire`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `latency`
--
ALTER TABLE `latency`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `liste_tours`
--
ALTER TABLE `liste_tours`
  MODIFY `code_service` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=451;

--
-- AUTO_INCREMENT for table `pointage_hebdomadaire`
--
ALTER TABLE `pointage_hebdomadaire`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pointage_journalier`
--
ALTER TABLE `pointage_journalier`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pointage_mensuel`
--
ALTER TABLE `pointage_mensuel`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tour_service`
--
ALTER TABLE `tour_service`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `FKrsq0srukhi6tcl9bd7g13gfna` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `agent`
--
ALTER TABLE `agent`
  ADD CONSTRAINT `FKihv2v47n02505sgqchy14taom` FOREIGN KEY (`code_departement`) REFERENCES `district` (`id`);

--
-- Constraints for table `conge`
--
ALTER TABLE `conge`
  ADD CONSTRAINT `FKbg9uavsyqkqqyr2se7hir5nua` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `defaillance`
--
ALTER TABLE `defaillance`
  ADD CONSTRAINT `FK9pv9x2jod4poga6op7s5myh5n` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `jour_hebdomadaire`
--
ALTER TABLE `jour_hebdomadaire`
  ADD CONSTRAINT `FK57j785g7mv5d6hid9o67efl3v` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `latency`
--
ALTER TABLE `latency`
  ADD CONSTRAINT `FKdrfmdwxmopfy1qaqe99495abs` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `liste_tours`
--
ALTER TABLE `liste_tours`
  ADD CONSTRAINT `FKb2jictftosftj91in5rh0ha3s` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`);

--
-- Constraints for table `pointage_hebdomadaire`
--
ALTER TABLE `pointage_hebdomadaire`
  ADD CONSTRAINT `FKplwdohw2kofk7mjyn47kgur50` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `pointage_journalier`
--
ALTER TABLE `pointage_journalier`
  ADD CONSTRAINT `FKq56b7oe68d2p49wytr7hygn7g` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `pointage_mensuel`
--
ALTER TABLE `pointage_mensuel`
  ADD CONSTRAINT `FKesco13ogdnlk8rntrd2xl9eo7` FOREIGN KEY (`agent_id`) REFERENCES `agent` (`matricule`);

--
-- Constraints for table `tour_service`
--
ALTER TABLE `tour_service`
  ADD CONSTRAINT `FK2jqdk9gsvb3x7l2mabtdvc7fa` FOREIGN KEY (`receiver_id`) REFERENCES `agent` (`matricule`),
  ADD CONSTRAINT `FK6w6arcgvumm45vecpb8v76yrj` FOREIGN KEY (`driver_id`) REFERENCES `agent` (`matricule`),
  ADD CONSTRAINT `FKfxv1l6mralakbxo1h6eui932h` FOREIGN KEY (`tour_id`) REFERENCES `liste_tours` (`code_service`);

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK1ubkos2q4w726tjxsl4srx3p0` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`),
  ADD CONSTRAINT `FKkpnqsi0c83k87e1fodny2d05t` FOREIGN KEY (`departement_id`) REFERENCES `district` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
