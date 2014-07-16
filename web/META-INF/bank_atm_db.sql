-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 15, 2014 at 09:55 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bank_atm_db`
--
CREATE DATABASE IF NOT EXISTS `bank_atm_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bank_atm_db`;

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `account_no` int(11) NOT NULL,
  `account_type` varchar(45) NOT NULL,
  `date_created` timestamp DEFAULT CURRENT_TIMESTAMP,
  `balance` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `customer_id`, `account_no`, `account_type`,  `balance`) VALUES
(1, 19, 0, 'Savings', 100);

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE IF NOT EXISTS `cards` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card_number` int(12) NOT NULL,
  `pin_code` varchar(45) NOT NULL,
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `gender` enum('male','female') DEFAULT 'male',
  `date_of_birth` date DEFAULT NULL,
  `national_id` varchar(100) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `first_name`, `last_name`, `address`, `phone`, `gender`, `date_of_birth`, `national_id`, `email`) VALUES
(4, 'Ebrima', 'Tunkara', 'Fairfield', '44343334', 'male', NULL, NULL, 'ebtunkara@gmail.com'),
(5, 'Ebrima T', 'Tunkara', 'Fairfield', '44343334', 'male', NULL, NULL, 'ebtunkara@gmail.com'),
(6, 'Peter', 'Johns', 'NY', '2324224', 'male', NULL, NULL, 'tees@fsfs'),
(7, 'Musa', 'Njie', 'Banjul', '9999', 'male', NULL, NULL, 'mnjie@gaf'),
(8, 'James', 'Arin', 'Washington', '234234', 'male', NULL, NULL, 'james@gmai.com'),
(9, 'James', 'Arin', 'Washington', '234234', 'male', NULL, NULL, 'james@gmai.com'),
(10, 'James', 'Arin', 'Washington', '234234', 'male', NULL, NULL, 'james@gmai.com'),
(11, 'Kaddi', 'Mare', 'Ba', '', 'male', NULL, NULL, ''),
(12, 'Kami', 'Tunkar', 'adfsf', '', 'male', NULL, NULL, 'dfsdf'),
(13, 'Kami', 'Tunkar', 'adfsf', '', 'male', NULL, NULL, 'dfsdf'),
(16, 'lisa', 'Ab', 'll', '123', 'male', NULL, NULL, 'll'),
(17, 'Pateh', 'Demba', 'Banjul', '877', 'male', NULL, NULL, 'apta@kk'),
(18, 'aa', 'bb', 'cc', 'ee', 'male', NULL, NULL, 'dd'),
(19, 'Ousman', 'Camaraa', 'Banjull', '88888', 'male', NULL, NULL, 'test@localhost.local');

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE IF NOT EXISTS `sessions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  `session` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `transancations`
--

CREATE TABLE IF NOT EXISTS `transancations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,0) NOT NULL,
  `account_id` int(11) NOT NULL,
  `date` datetime NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'test', 'test1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
