-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Tempo de geração: 10-Maio-2023 às 22:06
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clube`
--

CREATE DATABASE clube;
USE clube;
-- --------------------------------------------------------

--
-- Estrutura da tabela `dependentes`
--

CREATE TABLE `dependentes` (
  `id_dependente` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `id_titular` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `dependentes`
--

INSERT INTO `dependentes` (`id_dependente`, `nome`, `nascimento`, `cpf`, `id_titular`) VALUES
(1, 'Vinicius Josué', '2013-05-06', '002.003.004-05', 1),
(2, 'Josué Vinícius', '2013-05-06', '003.004.004-06', 1),
(3, 'Ronaldo Nazareno', '2012-01-08', '004.005.006-07', 2),
(4, 'Tibúrcio Mercedes', '2011-03-04', '005.006.007-08', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `email`
--

CREATE TABLE `email` (
  `id_email` int(11) NOT NULL,
  `email` text DEFAULT NULL,
  `id_titular` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `email`
--

INSERT INTO `email` (`id_email`, `email`, `id_titular`) VALUES
(1, 'josivaldo.99@hotmail.com', 1),
(2, 'fifi_fafa@gmail.com', 2),
(3, 'naocolocaacucarnobolinho@ibest.com', 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `titulares`
--

CREATE TABLE `titulares` (
  `id_titular` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `cpf` varchar(15) DEFAULT NULL,
  `cep` varchar(10) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `titulares`
--

INSERT INTO `titulares` (`id_titular`, `nome`, `nascimento`, `cpf`, `cep`, `tipo`) VALUES
(1, 'Josivaldson Gustamante', '1996-05-30', '123.456.789-10', '99880-000', NULL),
(2, 'Filada Mãe Juca', '1988-06-03', '456.789.123-11', '85600-100', NULL),
(3, 'Clementina Filomena', '1957-01-29', '001.020.060-50', '48999-001', NULL),
(100, 'Dionísio Veras', '2011-11-02', '456.456.456-45', '97785-020', NULL),
(101, 'joano', '2027-06-08', '000-000-000-00', '999-99', 'Titular');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `dependentes`
--
ALTER TABLE `dependentes`
  ADD PRIMARY KEY (`id_dependente`),
  ADD UNIQUE KEY `cpf` (`cpf`),
  ADD KEY `id_titular` (`id_titular`);

--
-- Índices para tabela `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`id_email`),
  ADD KEY `id_titular` (`id_titular`);

--
-- Índices para tabela `titulares`
--
ALTER TABLE `titulares`
  ADD PRIMARY KEY (`id_titular`),
  ADD UNIQUE KEY `cpf` (`cpf`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `dependentes`
--
ALTER TABLE `dependentes`
  MODIFY `id_dependente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT de tabela `email`
--
ALTER TABLE `email`
  MODIFY `id_email` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=100;

--
-- AUTO_INCREMENT de tabela `titulares`
--
ALTER TABLE `titulares`
  MODIFY `id_titular` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `dependentes`
--
ALTER TABLE `dependentes`
  ADD CONSTRAINT `dependentes_ibfk_1` FOREIGN KEY (`id_titular`) REFERENCES `titulares` (`id_titular`);

--
-- Limitadores para a tabela `email`
--
ALTER TABLE `email`
  ADD CONSTRAINT `email_ibfk_1` FOREIGN KEY (`id_titular`) REFERENCES `titulares` (`id_titular`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
