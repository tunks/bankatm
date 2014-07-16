-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 16, 2014 at 10:47 PM
-- Server version: 5.5.37
-- PHP Version: 5.3.10-1ubuntu3.12

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `bank_atm_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE IF NOT EXISTS `accounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_id` int(11) NOT NULL,
  `account_no` int(11) NOT NULL,
  `account_type` varchar(45) NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `balance` double DEFAULT '0',
  `card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `customer_id`, `account_no`, `account_type`, `date_created`, `balance`, `card_id`) VALUES
(3, 18, 0, 'Saving', '2014-07-16 00:00:00', 200, 1),
(4, 19, 2026116, 'Saving', '2014-07-16 00:00:00', 1000, 2),
(5, 20, 2027247, 'Saving', '2014-07-16 00:00:00', 50000, 3),
(6, 21, 2029743, 'Saving', '2014-07-16 00:00:00', 249, 4),
(7, 22, 2027554, 'Saving', '2014-07-16 00:00:00', 340, 5),
(8, 23, 2028407, 'Saving', '2014-07-16 00:00:00', 799, 6),
(9, 24, 2029045, 'Saving', '2014-07-16 00:00:00', 1598, 7);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`id`, `card_number`, `pin_code`, `customer_id`) VALUES
(1, 1000, '1000', 18),
(2, 20250424, '759', 19),
(3, 20262071, '805', 20),
(4, 20255129, '623', 21),
(5, 20297885, '523', 22),
(6, 20217472, '921', 23),
(7, 202101603, '986', 24);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `first_name`, `last_name`, `address`, `phone`, `gender`, `date_of_birth`, `national_id`, `email`) VALUES
(18, 'Tony', 'Ben', 'Washington', '2324223', 'male', NULL, NULL, 'tony@gmail.com'),
(19, 'Ebrima', 'Tunkara', 'NY', '888433', 'male', NULL, NULL, 'ebtunkara@gmail.com'),
(20, 'James', 'Berner', 'Washington', '77777', 'male', NULL, NULL, 'james@gmail.com'),
(21, 'Mariam', 'Helen', 'Washington', '3888343', 'male', NULL, NULL, 'mhelen@gmail.com'),
(22, 'Mariam', 'Helen', 'Seatle', '4543555543', 'male', NULL, NULL, 'mhelen@gmail.com'),
(23, 'Mariam A', 'Helen', 'Washington', '23234223', 'male', NULL, NULL, 'mhelen@gmail.com'),
(24, 'Mariam A', 'Helen', 'Washington', '23234223', 'male', NULL, NULL, 'mhelen@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `sessions`
--

CREATE TABLE IF NOT EXISTS `sessions` (
  `id` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `timestamp` timestamp NULL DEFAULT NULL,
  `session` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE IF NOT EXISTS `transactions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,0) NOT NULL,
  `account_id` int(11) NOT NULL,
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  `type` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `amount`, `account_id`, `date`, `user_id`, `card_id`, `type`) VALUES
(1, 799, 9, '2014-07-16 21:36:31', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `first_name`, `last_name`) VALUES
(1, 'admin', 'admin1', 'John', 'Mendy'),
(8, 'Ebrima', 'Tunkara', 'eTunkara', 'tunkara'),
(9, 'tunk1', 'tunkara', 'Ebrima ', 'Tunkara'),
(10, 'admin2', 'test1', 'Firdus', 'Hassan');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `user_id`, `role`) VALUES
(1, 7, 'administrator'),
(2, 8, 'administrator'),
(3, 9, 'account manager'),
(4, 10, 'administrator');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
