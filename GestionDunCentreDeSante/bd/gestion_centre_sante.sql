-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 17 jan. 2022 à 20:50
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_centre_sante`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `name_admin` varchar(255) NOT NULL,
  `pwd_admin` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id_admin`, `name_admin`, `pwd_admin`, `create_date`, `update_date`) VALUES
(1, 'koybi', 'gino', '2022-01-15 00:25:00', '2022-01-15 00:25:00');

-- --------------------------------------------------------

--
-- Structure de la table `compte_medecin`
--

CREATE TABLE `compte_medecin` (
  `id_compte` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `medecin_id` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte_medecin`
--

INSERT INTO `compte_medecin` (`id_compte`, `username`, `pwd`, `medecin_id`, `create_date`, `update_date`) VALUES
(2, 'gdsgdsgdsgdsg', 'gsgs', 0, '2022-01-15 00:34:12', '2022-01-15 00:34:12'),
(3, 'judsqkfsjjq', 'sfgdsg', 2, '2022-01-16 09:19:11', '2022-01-16 09:19:11'),
(4, 'xqdwxd', 'dsqdsq', 1, '2022-01-16 09:20:54', '2022-01-16 09:20:54'),
(6, 'serge', '1234', 5, '2022-01-16 10:41:03', '2022-01-16 10:41:03');

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

CREATE TABLE `consultation` (
  `id_cons` int(11) NOT NULL,
  `traite_cons` tinyint(1) NOT NULL,
  `dossier_id` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `dossier`
--

CREATE TABLE `dossier` (
  `id_dossier` int(11) NOT NULL,
  `nom_dossier` varchar(255) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `dossier_traite` tinyint(1) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `examen`
--

CREATE TABLE `examen` (
  `id_exam` int(11) NOT NULL,
  `nom_exam` varchar(255) NOT NULL,
  `taille` decimal(10,0) NOT NULL,
  `poids` tinyint(4) NOT NULL,
  `frequence_cardiaque` tinyint(4) NOT NULL,
  `allergie` text NOT NULL,
  `taux_glycemi` tinyint(4) NOT NULL,
  `groupe_sanguin` varchar(10) NOT NULL,
  `maladie_chronique` text NOT NULL,
  `consultation_id` int(11) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT current_timestamp(),
  `update_date` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

CREATE TABLE `medecin` (
  `id_medecin` int(11) NOT NULL,
  `nom_medecin` varchar(255) NOT NULL,
  `prenom_medecin` varchar(255) NOT NULL,
  `date_nais` varchar(50) NOT NULL,
  `sexe` char(2) NOT NULL,
  `poste` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `ordonnance`
--

CREATE TABLE `ordonnance` (
  `id_ord` int(11) NOT NULL,
  `nom_ord` text NOT NULL,
  `description_ord` text NOT NULL,
  `consultation_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id_patient` int(11) NOT NULL,
  `nom_patient` varchar(100) NOT NULL,
  `prenom_patient` varchar(255) NOT NULL,
  `date_naissance` varchar(50) NOT NULL,
  `sexe` char(5) NOT NULL,
  `nom_pere` varchar(255) NOT NULL,
  `nom_mere` varchar(255) NOT NULL,
  `compte_medecin_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `soin`
--

CREATE TABLE `soin` (
  `id_soin` int(11) NOT NULL,
  `nom_soin` varchar(255) NOT NULL,
  `dose_soin` text NOT NULL,
  `consultation_id` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Index pour la table `compte_medecin`
--
ALTER TABLE `compte_medecin`
  ADD PRIMARY KEY (`id_compte`);

--
-- Index pour la table `consultation`
--
ALTER TABLE `consultation`
  ADD PRIMARY KEY (`id_cons`);

--
-- Index pour la table `dossier`
--
ALTER TABLE `dossier`
  ADD PRIMARY KEY (`id_dossier`);

--
-- Index pour la table `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`id_exam`);

--
-- Index pour la table `medecin`
--
ALTER TABLE `medecin`
  ADD PRIMARY KEY (`id_medecin`);

--
-- Index pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  ADD PRIMARY KEY (`id_ord`);

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id_patient`);

--
-- Index pour la table `soin`
--
ALTER TABLE `soin`
  ADD PRIMARY KEY (`id_soin`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `compte_medecin`
--
ALTER TABLE `compte_medecin`
  MODIFY `id_compte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `consultation`
--
ALTER TABLE `consultation`
  MODIFY `id_cons` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `dossier`
--
ALTER TABLE `dossier`
  MODIFY `id_dossier` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `examen`
--
ALTER TABLE `examen`
  MODIFY `id_exam` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `medecin`
--
ALTER TABLE `medecin`
  MODIFY `id_medecin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ordonnance`
--
ALTER TABLE `ordonnance`
  MODIFY `id_ord` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_patient` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `soin`
--
ALTER TABLE `soin`
  MODIFY `id_soin` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
