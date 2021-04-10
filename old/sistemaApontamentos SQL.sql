-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Dez-2019 às 19:53
-- Versão do servidor: 10.3.16-MariaDB
-- versão do PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistemaindustrial`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_cadastros`
--

CREATE TABLE `tbl_cadastros` (
  `pk_id_codigo` bigint(20) UNSIGNED NOT NULL,
  `cad_tipo` varchar(200) NOT NULL,
  `cad_nome` varchar(400) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_cadastros`
--

INSERT INTO `tbl_cadastros` (`pk_id_codigo`, `cad_tipo`, `cad_nome`) VALUES
(1, 'Motivo de parada', 'Manutenção corretiva'),
(2, 'Motivo de parada', 'Manutenção preventiva'),
(3, 'Motivo de parada', 'Falta de operador'),
(4, 'Motivo de perda', 'Ajuste de maquina'),
(5, 'Motivo de perda', 'Falha operacional'),
(6, 'Motivo de perda', 'Troca de pedido'),
(14, 'Motivo de parada', 'Folga administrativa'),
(15, 'Motivo de parada', 'teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_etapas`
--

CREATE TABLE `tbl_etapas` (
  `pk_id_codigo` int(11) NOT NULL,
  `eta_nome` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_etapas`
--

INSERT INTO `tbl_etapas` (`pk_id_codigo`, `eta_nome`) VALUES
(4, 'Picotadeira'),
(5, 'Extrusão'),
(6, 'Corte e solda'),
(7, 'Picotadeira (Rende Mais)');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_paradas`
--

CREATE TABLE `tbl_paradas` (
  `pk_id_codigo` bigint(20) UNSIGNED NOT NULL,
  `par_produto` varchar(200) NOT NULL,
  `par_etapa` varchar(150) NOT NULL,
  `par_recurso` varchar(150) NOT NULL,
  `par_data_inicio` date NOT NULL,
  `par_data_final` date NOT NULL,
  `par_motivo` varchar(200) NOT NULL,
  `par_operador` varchar(300) NOT NULL,
  `par_time_inicio` time NOT NULL,
  `par_time_termino` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_paradas`
--

INSERT INTO `tbl_paradas` (`pk_id_codigo`, `par_produto`, `par_etapa`, `par_recurso`, `par_data_inicio`, `par_data_final`, `par_motivo`, `par_operador`, `par_time_inicio`, `par_time_termino`) VALUES
(1, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 01', '2019-08-27', '2019-08-28', 'Falta de operador', 'Clara', '00:00:00', '00:00:00'),
(2, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 01', '2019-08-27', '2019-08-28', 'Teste', 'Vinicius', '00:00:00', '00:00:00'),
(4, 'Bobina picotada 30 x 40 cm', 'Picotadeira (Rende Mais)', 'Picotadeira 01', '2019-10-16', '2019-10-16', 'Manutenção corretiva', 'Vinicius', '00:00:00', '00:00:00'),
(5, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 02', '1998-05-08', '1998-05-08', 'Manutenção preventiva', 'Clarinha', '00:00:00', '00:00:00'),
(6, 'Capa de fardo 50 x 80 cm', 'Extrusão', 'Picotadeira 02', '0022-04-11', '0022-04-11', 'Falta de operador', 'Vinicius', '00:00:00', '00:00:00'),
(7, 'Capa de fardo 50 x 80 cm', 'Extrusão', 'Picotadeira 02', '0022-04-11', '0022-04-11', 'Manutenção corretiva', 'Vinicius', '00:00:00', '00:00:00'),
(8, 'Capa de fardo 50 x 80 cm', 'Extrusão', 'Picotadeira 01', '2019-10-16', '2019-10-16', 'Falta de operador', 'Clarinha', '00:00:00', '00:00:00'),
(9, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 02', '2019-10-18', '2019-10-18', 'Manutenção preventiva', 'Vinicius', '00:30:00', '21:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_perdas`
--

CREATE TABLE `tbl_perdas` (
  `pk_id_codigo` bigint(20) UNSIGNED NOT NULL,
  `per_produto` varchar(200) NOT NULL,
  `per_etapa` varchar(150) NOT NULL,
  `per_recurso` varchar(150) NOT NULL,
  `per_data` date NOT NULL,
  `per_motivo` varchar(200) NOT NULL,
  `per_peso` double NOT NULL,
  `per_operador` varchar(300) NOT NULL,
  `per_time_perda` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_perdas`
--

INSERT INTO `tbl_perdas` (`pk_id_codigo`, `per_produto`, `per_etapa`, `per_recurso`, `per_data`, `per_motivo`, `per_peso`, `per_operador`, `per_time_perda`) VALUES
(1, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 01', '2019-08-27', 'Troca de pedido', 15, 'Vinicius', '00:00:00'),
(2, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 01', '2019-08-27', 'Troca de pedido', 15.3, 'Vinicius', '00:00:00'),
(3, 'Bobina picotada 30 x 40 cm', 'Extrusão', 'Picotadeira 01', '2019-08-27', 'Troca de pedido', 15.3, 'Vinicius', '00:00:00'),
(4, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 02', '2019-10-25', 'Falha operacional', 23.3, 'Clarinha', '21:10:00'),
(6, 'Capa de fardo 50 x 80 cm', 'Corte e solda', 'Picotadeira 02', '2019-10-25', 'Falha operacional', 25.3, 'Vinicius', '10:37:00'),
(7, 'Bobina picotada 30 x 40 cm', 'Picotadeira (Rende Mais)', 'Picotadeira 02', '2019-10-24', 'Troca de pedido', 24.5, 'Clarinha', '23:30:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_producao`
--

CREATE TABLE `tbl_producao` (
  `pk_id_codigo` bigint(20) UNSIGNED NOT NULL,
  `pro_produto` varchar(200) NOT NULL,
  `pro_etapa` varchar(150) NOT NULL,
  `pro_recurso` varchar(150) NOT NULL,
  `pro_data_inicio` date NOT NULL,
  `pro_data_final` date NOT NULL,
  `pro_peso` double NOT NULL,
  `pro_operador` varchar(300) NOT NULL,
  `pro_time_inicio` time NOT NULL,
  `pro_time_termino` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_producao`
--

INSERT INTO `tbl_producao` (`pk_id_codigo`, `pro_produto`, `pro_etapa`, `pro_recurso`, `pro_data_inicio`, `pro_data_final`, `pro_peso`, `pro_operador`, `pro_time_inicio`, `pro_time_termino`) VALUES
(3, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 01', '2019-09-12', '2019-09-12', 158.3, 'Vinicius', '00:00:00', '00:00:00'),
(4, 'Bobina picotada 30 x 40 cm', 'Picotadeira', 'Picotadeira 02', '2019-08-27', '2019-08-28', 1528.2, 'Vinicius', '00:00:00', '00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_produtos`
--

CREATE TABLE `tbl_produtos` (
  `pk_id_codigo` bigint(20) UNSIGNED NOT NULL,
  `pro_descricao` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_produtos`
--

INSERT INTO `tbl_produtos` (`pk_id_codigo`, `pro_descricao`) VALUES
(1, 'Bobina picotada 30 x 40 cm'),
(2, 'Capa de fardo 50 x 80 cm'),
(3, 'Bobina rende mais 30 x 40 cm'),
(4, 'teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_recursos`
--

CREATE TABLE `tbl_recursos` (
  `pk_id_codigo` int(20) UNSIGNED NOT NULL,
  `rec_tipo` varchar(100) NOT NULL,
  `rec_descricao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_recursos`
--

INSERT INTO `tbl_recursos` (`pk_id_codigo`, `rec_tipo`, `rec_descricao`) VALUES
(3, 'Picotadeira', 'Picotadeira 02'),
(4, 'Picotadeira', 'Picotadeira 01');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `pk_id_codigo` int(11) NOT NULL,
  `cad_usu_cpf` bigint(20) NOT NULL,
  `cad_usu_nome` varchar(200) NOT NULL,
  `cad_usu_email` varchar(180) DEFAULT NULL,
  `cad_usu_telefone` bigint(20) DEFAULT NULL,
  `cad_usu_dataNasc` date NOT NULL,
  `cad_usu_login` varchar(80) NOT NULL,
  `cad_usu_senha` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`pk_id_codigo`, `cad_usu_cpf`, `cad_usu_nome`, `cad_usu_email`, `cad_usu_telefone`, `cad_usu_dataNasc`, `cad_usu_login`, `cad_usu_senha`) VALUES
(1, 46480415850, 'Vinicius', 'vinicius@hotmail.com', 99999999999, '1998-05-08', 'vinicius', 'vini0805'),
(2, 40369875863, 'Clarinha', 'clara@hotmail.com', 99999999999, '1996-03-27', 'clara', 'amor'),
(4, 12345678950, 'teste', 'teste@tese.com', 19993766542, '1998-05-08', 'teste', 'teste123');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbl_cadastros`
--
ALTER TABLE `tbl_cadastros`
  ADD PRIMARY KEY (`pk_id_codigo`),
  ADD UNIQUE KEY `pk_id_codigo` (`pk_id_codigo`);

--
-- Índices para tabela `tbl_etapas`
--
ALTER TABLE `tbl_etapas`
  ADD PRIMARY KEY (`pk_id_codigo`);

--
-- Índices para tabela `tbl_paradas`
--
ALTER TABLE `tbl_paradas`
  ADD PRIMARY KEY (`pk_id_codigo`),
  ADD UNIQUE KEY `pk_id_codigo` (`pk_id_codigo`);

--
-- Índices para tabela `tbl_perdas`
--
ALTER TABLE `tbl_perdas`
  ADD PRIMARY KEY (`pk_id_codigo`),
  ADD UNIQUE KEY `pk_id_codigo` (`pk_id_codigo`);

--
-- Índices para tabela `tbl_producao`
--
ALTER TABLE `tbl_producao`
  ADD PRIMARY KEY (`pk_id_codigo`),
  ADD UNIQUE KEY `pk_id_codigo` (`pk_id_codigo`);

--
-- Índices para tabela `tbl_produtos`
--
ALTER TABLE `tbl_produtos`
  ADD PRIMARY KEY (`pk_id_codigo`),
  ADD UNIQUE KEY `pk_id_codigo` (`pk_id_codigo`);

--
-- Índices para tabela `tbl_recursos`
--
ALTER TABLE `tbl_recursos`
  ADD PRIMARY KEY (`pk_id_codigo`),
  ADD UNIQUE KEY `pk_id_codigo` (`pk_id_codigo`);

--
-- Índices para tabela `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`pk_id_codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_cadastros`
--
ALTER TABLE `tbl_cadastros`
  MODIFY `pk_id_codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de tabela `tbl_etapas`
--
ALTER TABLE `tbl_etapas`
  MODIFY `pk_id_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `tbl_paradas`
--
ALTER TABLE `tbl_paradas`
  MODIFY `pk_id_codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `tbl_perdas`
--
ALTER TABLE `tbl_perdas`
  MODIFY `pk_id_codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `tbl_producao`
--
ALTER TABLE `tbl_producao`
  MODIFY `pk_id_codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tbl_produtos`
--
ALTER TABLE `tbl_produtos`
  MODIFY `pk_id_codigo` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tbl_recursos`
--
ALTER TABLE `tbl_recursos`
  MODIFY `pk_id_codigo` int(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  MODIFY `pk_id_codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
