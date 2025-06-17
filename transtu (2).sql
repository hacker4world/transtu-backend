-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2025 at 01:46 AM
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

-- --------------------------------------------------------

--
-- Table structure for table `agent`
--

CREATE TABLE `agent` (
  `matricule` int(11) NOT NULL,
  `date_naiss` datetime(6) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `situation_familiale` varchar(255) DEFAULT NULL,
  `code_departement` int(11) DEFAULT NULL,
  `utilisateur_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `agent`
--

INSERT INTO `agent` (`matricule`, `date_naiss`, `nom`, `prenom`, `role`, `situation_familiale`, `code_departement`, `utilisateur_id`) VALUES
(4, '1987-06-11 00:00:00.000000', 'Mourad', 'Ben Abdallah', 'driver', 'marie', 1, 5),
(5, '1974-07-14 00:00:00.000000', 'Mounir', 'Arfaoui', 'receiver', 'marie', 1, 6),
(6, '1991-02-14 00:00:00.000000', 'ahmed', 'mdini', 'driver', 'celibataire', 1, 7),
(7, '1980-09-23 00:00:00.000000', 'mohsen', 'jbeli', 'receiver', 'marie', 1, 8),
(8, '1986-02-01 00:00:00.000000', 'mostfa', 'belhaj', 'driver', 'marie', 1, 9),
(9, '1988-06-17 00:00:00.000000', 'abdel jlil', 'balti', 'receiver', 'celibataire', 1, 10),
(10, '1990-01-20 00:00:00.000000', 'fourat', 'chebbi', 'driver', 'divorce', 1, 11),
(11, '1987-10-23 00:00:00.000000', 'mohamed', 'barguei', 'receiver', 'marie', 1, 12),
(13, '1999-12-10 00:00:00.000000', 'ghassen', 'Arfaoui', 'receiver', 'celibataire', 1, 14),
(14, '1996-10-28 00:00:00.000000', 'aziz', 'cherif', 'driver', 'celibataire', 1, 15),
(15, '1969-01-10 00:00:00.000000', 'khalil', 'nekssi', 'receiver', 'celibataire', 1, 16),
(16, '1988-03-12 00:00:00.000000', 'hazem', 'mensi', 'driver', 'marie', 1, 17),
(17, '1987-05-14 00:00:00.000000', 'ahmed', 'swissi', 'receiver', 'divorce', 1, 18),
(18, '1993-08-14 00:00:00.000000', 'ala', 'khadhrawi', 'driver', 'divorce', 1, 19);

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
(1, NULL, '2021-03-03', '2021-03-28', 25, 5);

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
(1, '2023-05-05', '2023-05-07', 3, 4),
(2, '2023-05-10', '2023-05-12', 3, 5),
(3, '2023-05-15', '2023-05-17', 3, 6),
(4, '2023-05-20', '2023-05-22', 3, 7),
(5, '2023-05-25', '2023-05-27', 3, 4);

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
(1, 'passage', 'passage');

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

-- --------------------------------------------------------

--
-- Table structure for table `liste_tours`
--

CREATE TABLE `liste_tours` (
  `code_service` int(11) NOT NULL,
  `heures_jour` int(11) NOT NULL,
  `heures_nuit` int(11) NOT NULL,
  `jour` int(11) NOT NULL,
  `mois` int(11) NOT NULL,
  `saison` varchar(255) DEFAULT NULL,
  `travail_assure` bit(1) NOT NULL,
  `travail_continue` bit(1) NOT NULL,
  `district_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `liste_tours`
--

INSERT INTO `liste_tours` (`code_service`, `heures_jour`, `heures_nuit`, `jour`, `mois`, `saison`, `travail_assure`, `travail_continue`, `district_id`) VALUES
(119, 8, 0, 1, 6, 'spring', b'1', b'1', 1),
(120, 0, 8, 1, 6, 'spring', b'1', b'1', 1),
(121, 8, 0, 1, 6, 'spring', b'1', b'1', 1),
(122, 0, 8, 2, 6, 'spring', b'1', b'1', 1),
(123, 8, 0, 2, 6, 'spring', b'1', b'1', 1),
(124, 0, 8, 2, 6, 'spring', b'1', b'1', 1),
(125, 8, 0, 3, 6, 'spring', b'1', b'1', 1),
(126, 0, 8, 3, 6, 'spring', b'1', b'1', 1),
(127, 8, 0, 3, 6, 'spring', b'1', b'1', 1),
(128, 0, 8, 4, 6, 'spring', b'1', b'1', 1),
(129, 8, 0, 4, 6, 'spring', b'1', b'1', 1),
(130, 0, 8, 4, 6, 'spring', b'1', b'1', 1),
(131, 8, 0, 5, 6, 'spring', b'1', b'1', 1),
(132, 0, 8, 5, 6, 'spring', b'1', b'1', 1),
(133, 8, 0, 5, 6, 'spring', b'1', b'1', 1),
(134, 0, 8, 6, 6, 'spring', b'1', b'1', 1),
(135, 8, 0, 6, 6, 'spring', b'1', b'1', 1),
(136, 0, 8, 6, 6, 'spring', b'1', b'1', 1),
(137, 8, 0, 7, 6, 'spring', b'1', b'1', 1),
(138, 0, 8, 7, 6, 'spring', b'1', b'1', 1),
(139, 8, 0, 7, 6, 'spring', b'1', b'1', 1);

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
(2, 17, 6, 2025, 16, 11, 122),
(3, 17, 6, 2025, 10, 5, 123),
(4, 17, 6, 2025, 14, 17, 124);

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
  `district_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`matricule`, `code_reset`, `email`, `nom`, `password`, `prenom`, `role`, `district_id`) VALUES
(1, NULL, 'aziz@gmail.com', 'aziz', '12345678', 'arfaoui', 'admin', 1),
(5, NULL, 'mourad@gmail.com', 'Mourad', '12345678', 'Ben Abdallah', 'agent', 1),
(6, NULL, 'mounir@gmail.com', 'Mounir', '12345678', 'Arfaoui', 'agent', 1),
(7, NULL, 'ahmed@gmail.com', 'ahmed', '12345678', 'mdini', 'agent', 1),
(8, NULL, 'mohsen@gmail.com', 'mohsen', '12345678', 'jbeli', 'agent', 1),
(9, NULL, 'mostfa@gmail.com', 'mostfa', '12345678', 'belhaj', 'agent', 1),
(10, NULL, 'abdeljlil@gmail.com', 'abdel jlil', '12345678', 'balti', 'agent', 1),
(11, NULL, 'fourat@gmail.com', 'fourat', '12345678', 'chebbi', 'agent', 1),
(12, NULL, 'mohamed@gmail.com', 'mohamed', '12345678', 'barguei', 'agent', 1),
(14, NULL, 'ghassen@gmail.com', 'ghassen', '12345678', 'Arfaoui', 'agent', 1),
(15, NULL, 'aziz44@gmail.com', 'aziz', '12345678', 'cherif', 'agent', 1),
(16, NULL, 'khalil@gmail.com', 'khalil', '12345678', 'nekssi', 'agent', 1),
(17, NULL, 'hazem@gmail.com', 'hazem', '12345678', 'mensi', 'agent', 1),
(18, NULL, 'ahmed1@gmail.com', 'ahmed', '12345678', 'swissi', 'agent', 1),
(19, NULL, 'ala@gmail.com', 'ala', '12345678', 'khadhrawi', 'agent', 1);

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
  ADD UNIQUE KEY `UKat5dsad3bci3339wbglpcr9f8` (`utilisateur_id`),
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
  ADD KEY `FK1ubkos2q4w726tjxsl4srx3p0` (`district_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absence`
--
ALTER TABLE `absence`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `agent`
--
ALTER TABLE `agent`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `conge`
--
ALTER TABLE `conge`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `defaillance`
--
ALTER TABLE `defaillance`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `district`
--
ALTER TABLE `district`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `latency`
--
ALTER TABLE `latency`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `liste_tours`
--
ALTER TABLE `liste_tours`
  MODIFY `code_service` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;

--
-- AUTO_INCREMENT for table `tour_service`
--
ALTER TABLE `tour_service`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `matricule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

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
  ADD CONSTRAINT `FKeslcr2j3mhky5ifxlwjua7tt6` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`matricule`),
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
  ADD CONSTRAINT `FK1ubkos2q4w726tjxsl4srx3p0` FOREIGN KEY (`district_id`) REFERENCES `district` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
