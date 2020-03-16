-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 16, 2020 at 06:16 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `result`
--

-- --------------------------------------------------------

--
-- Table structure for table `hsc`
--

DROP TABLE IF EXISTS `hsc`;
CREATE TABLE IF NOT EXISTS `hsc` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `roll` varchar(20) NOT NULL,
  `reg` varchar(20) NOT NULL,
  `board` varchar(20) NOT NULL,
  `passing_year` int(11) NOT NULL,
  `gpa` double NOT NULL,
  `status` varchar(10) NOT NULL,
  `group_` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hsc`
--

INSERT INTO `hsc` (`userId`, `roll`, `reg`, `board`, `passing_year`, `gpa`, `status`, `group_`) VALUES
(1, '141989', '1218733671', 'Dhaka', 2017, 4.58, 'pass', 'Science'),
(2, '127612', '1278561209', 'Dhaka', 2017, 5, 'pass', 'Science'),
(3, '138434', '1210914765', 'Dhaka', 2017, 5, 'pass', 'Science');

-- --------------------------------------------------------

--
-- Table structure for table `ssc`
--

DROP TABLE IF EXISTS `ssc`;
CREATE TABLE IF NOT EXISTS `ssc` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `roll` varchar(20) NOT NULL,
  `reg` varchar(20) NOT NULL,
  `board` varchar(20) NOT NULL,
  `passing_year` int(11) NOT NULL,
  `gpa` double NOT NULL,
  `status` varchar(10) NOT NULL,
  `group_` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ssc`
--

INSERT INTO `ssc` (`userId`, `roll`, `reg`, `board`, `passing_year`, `gpa`, `status`, `group_`) VALUES
(1, '120544', '1218733671', 'Dhaka', 2015, 4.83, 'pass', 'Science'),
(2, '127610', '1278561209', 'Dhaka', 2015, 5, 'pass', 'Science'),
(3, '113145', '1210914765', 'Dhaka', 2015, 5, 'pass', 'Science');

-- --------------------------------------------------------

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `nick_name` varchar(30) NOT NULL,
  `father_first_name` varchar(30) NOT NULL,
  `father_last_name` varchar(30) DEFAULT NULL,
  `father_nick_name` varchar(30) NOT NULL,
  `mother_first_name` varchar(30) NOT NULL,
  `mother_last_name` varchar(30) DEFAULT NULL,
  `mother_nick_name` varchar(30) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `house_no` varchar(30) NOT NULL,
  `street_no` varchar(30) DEFAULT NULL,
  `village` varchar(30) NOT NULL,
  `post_office` varchar(30) NOT NULL,
  `post_code` varchar(30) NOT NULL,
  `sub_district` varchar(30) NOT NULL,
  `district` varchar(30) NOT NULL,
  `birth_of_date` date NOT NULL,
  `age` int(11) GENERATED ALWAYS AS (floor((to_days(current_timestamp()) - to_days(`birth_of_date`)) / 365)) VIRTUAL,
  `religion` varchar(30) NOT NULL,
  `nationality` varchar(30) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_info`
--

INSERT INTO `user_info` (`userId`, `first_name`, `last_name`, `nick_name`, `father_first_name`, `father_last_name`, `father_nick_name`, `mother_first_name`, `mother_last_name`, `mother_nick_name`, `sex`, `house_no`, `street_no`, `village`, `post_office`, `post_code`, `sub_district`, `district`, `birth_of_date`, `religion`, `nationality`) VALUES
(1, 'Sajjad', 'Hossain', 'Sajjad', 'Abul', 'Kashem', 'Kawsar', 'Nasima', 'Akter', 'Nasima', 'Male', 'KA-512', '24/A', 'Madhobpur', 'Bhawal Rajabari', '1740', 'Sreepur', 'Gazipur', '1998-05-27', 'Islam', 'Bangladeshi'),
(2, 'Mahmuda', 'Akter', 'Tani', 'Abu', 'Bakar', 'Kazi', 'Shahida', 'Begum', 'Shahida', 'Female', '12/A', '7', 'Kalabagan', 'Jahangirnagar University', '1342', 'Savar', 'Dhaka', '1999-02-21', 'Islam', 'Bangladeshi'),
(3, 'Mahbub Islam', 'Mahim', 'Mahim', 'S M Rezaul', 'Karim', 'Rezaul', 'Nurjahan ', 'Begum', 'Nurjahan', 'Male', '56/7', '56', 'Jamsing', 'BPATC', '1343', 'Savar', 'Dhaka', '1998-10-18', 'Islam', 'Bangladeshi');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
