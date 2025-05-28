-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2025 at 02:59 PM
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
-- Database: `gymdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `activity_logs`
--

CREATE TABLE `activity_logs` (
  `log_id` int(11) NOT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `description` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `activity_logs`
--

INSERT INTO `activity_logs` (`log_id`, `staff_id`, `user_id`, `description`, `created_at`) VALUES
(1, NULL, 7, 'Added new equipment: Jeja (Qty: 17)', '2025-05-21 13:43:02'),
(2, 2, NULL, 'bayot daniel', '2025-05-22 03:05:55'),
(3, NULL, 7, 'Deleted record: 5', '2025-05-26 14:25:30'),
(4, NULL, 7, 'Opened edit form for Equipment ID: 4', '2025-05-26 14:44:16'),
(5, NULL, 7, 'Deleted item - ID: 2; Equipment Name: Monge; Description: Carlo Pumped; Quantity: 2; Price: 2500;', '2025-05-26 15:24:39'),
(6, NULL, 7, 'Added new equipment: Bench Press (Qty: 1)', '2025-05-26 15:26:24'),
(7, NULL, 7, 'Deleted item - ID: 7; Equipment Name: Bench Press; Description: pumped; Quantity: 1; Price: 1500;', '2025-05-26 15:27:49'),
(8, NULL, 7, 'Added new equipment: Pulldown Machine (Qty: 1)', '2025-05-27 05:21:17'),
(9, NULL, 7, 'Added new Staff: Maby ( Colina)', '2025-05-27 09:49:44'),
(10, NULL, 7, 'Deleted item - ID: 4; First Name: Maby; Last Name: Colina; Email: mabsxd@gmail.com; Status: Active;', '2025-05-27 09:51:10'),
(11, NULL, 7, 'Opened edit form for Equipment ID: 8', '2025-05-27 09:53:42'),
(12, NULL, 7, 'Opened edit form for Equipment ID: 8', '2025-05-27 14:56:44'),
(13, NULL, 7, 'Updated Equipment: Pulldown Machine ', '2025-05-27 14:56:49'),
(14, NULL, 7, 'Deleted item - ID: 17; First Name: Ivan; Last Name: Colina; Email: testemail@gmail.com; Status: Active;', '2025-05-27 15:03:11'),
(15, NULL, 7, 'Added new User: Ivan Colina Noted', '2025-05-27 15:04:18'),
(16, NULL, 7, 'Updated User: Ivan Colina Noted ID: 18', '2025-05-27 15:07:12'),
(17, NULL, 7, 'Added Membership for: Ivan Colina Noted (ID: textfield.TextField[,20,70,390x70,disabled,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.border.EmptyBorder@376aab50,flags=288,maximumSize=,minimumSize=,preferredSize=,caretColor=,disabledTextColor=DerivedColor(color=142,143,145 parent=nimbusDisabledText offsets=0.0,0.0,0.0,0 pColor=142,143,145,editable=true,margin=javax.swing.plaf.InsetsUIResource[top=0,left=0,bottom=0,right=0],selectedTextColor=DerivedColor(color=255,255,255 parent=nimbusSelectedText offsets=0.0,0.0,0.0,0 pColor=255,255,255,selectionColor=java.awt.Color[r=76,g=204,b=255],columns=0,columnWidth=0,command=,horizontalAlignment=LEADING])', '2025-05-27 15:11:53'),
(18, NULL, 7, 'Added Membership for: Ivan Colina Noted (ID: 18)', '2025-05-27 15:12:48'),
(19, NULL, 7, 'Deleted item - Membership ID: 31; Member ID: 18; Member Name: Ivan Colina Noted; Start Date: 2025-05-27; End Date: 2025-06-27; Status: Active; Plan: 1 month;', '2025-05-27 15:15:35'),
(20, NULL, 7, 'Edited Membership for: Ivan Colina Noted (ID: 18)', '2025-05-27 15:16:49'),
(21, NULL, 7, 'Announcement posted by Admin (ID: 7)', '2025-05-28 08:22:06'),
(24, 3, NULL, 'eoeooe', '2025-05-28 12:58:26');

-- --------------------------------------------------------

--
-- Table structure for table `announcement`
--

CREATE TABLE `announcement` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `staff_id` int(11) DEFAULT NULL,
  `message` text NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `announcement`
--

INSERT INTO `announcement` (`id`, `user_id`, `staff_id`, `message`, `created_at`) VALUES
(1, NULL, 2, 'Bayot Colina NOTED!', '2025-05-28 07:09:36'),
(3, 7, NULL, 'Hold me down, im six feet from the edge and im thinkin', '2025-05-28 08:22:06');

-- --------------------------------------------------------

--
-- Table structure for table `equipment_tbl`
--

CREATE TABLE `equipment_tbl` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `vendor` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipment_tbl`
--

INSERT INTO `equipment_tbl` (`id`, `name`, `price`, `quantity`, `vendor`, `description`, `address`, `date`) VALUES
(3, 'Russian Roulette', 1500, 2, 'Jericho and kupa', 'Jeja Ka talaga boss', 'Minglanilla, tunghaan', '14-05-2025'),
(4, 'Threadmill', 2500, 2, 'carlo pumped', 'Burn your fats away', 'Tubod High-Lands', '05-08-2025'),
(8, 'Pulldown Machine', 1500, 1, 'Pumped Carlo', 'For back exercises', 'Naga', '05-08-2025');

-- --------------------------------------------------------

--
-- Table structure for table `memberships`
--

CREATE TABLE `memberships` (
  `membership_id` int(11) NOT NULL,
  `member_id` int(11) NOT NULL,
  `start_date` varchar(255) NOT NULL,
  `end_date` varchar(255) NOT NULL,
  `member_status` varchar(255) NOT NULL,
  `membership_plan` varchar(255) NOT NULL,
  `payment_amount` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `memberships`
--

INSERT INTO `memberships` (`membership_id`, `member_id`, `start_date`, `end_date`, `member_status`, `membership_plan`, `payment_amount`) VALUES
(30, 18, '2025-05-27', '2025-06-27', 'Active', '3 month', '1500'),
(32, 19, '2025-05-28', '2025-08-28', 'Active', '3 month', '1500');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `membership_id` int(11) NOT NULL,
  `amount` varchar(255) NOT NULL,
  `payment_date` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`payment_id`, `membership_id`, `amount`, `payment_date`) VALUES
(24, 30, '1500', '2025-05-27'),
(26, 32, '1500', '2025-05-28');

-- --------------------------------------------------------

--
-- Table structure for table `staff_tbl`
--

CREATE TABLE `staff_tbl` (
  `staff_id` int(11) NOT NULL,
  `staff_Fname` varchar(255) NOT NULL,
  `staff_Lname` varchar(255) NOT NULL,
  `staff_Phone` varchar(255) NOT NULL,
  `staff_Email` varchar(255) NOT NULL,
  `staff_Birthdate` varchar(255) NOT NULL,
  `staff_Pass` varchar(255) NOT NULL,
  `staff_Status` varchar(255) NOT NULL,
  `staff_Type` varchar(255) NOT NULL,
  `u_image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff_tbl`
--

INSERT INTO `staff_tbl` (`staff_id`, `staff_Fname`, `staff_Lname`, `staff_Phone`, `staff_Email`, `staff_Birthdate`, `staff_Pass`, `staff_Status`, `staff_Type`, `u_image`) VALUES
(2, 'Daniel', 'Peperon', '0988555843', 'rapbeh@gmail.com', '05-08-2005', 'zkqlSH7BMS7elnp5or5zepVt+WUCUS7lMANhogBgO7Q=', 'Active', 'Select Type:', 'userimages/user_2.jpg'),
(3, 'Maby', 'gabs', '555555988586', 'MabyAutahay@gmail.com', '08-08-2005', 'zkqlSH7BMS7elnp5or5zepVt+WUCUS7lMANhogBgO7Q=', 'Active', 'Trainer', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL,
  `user_Fname` varchar(255) NOT NULL,
  `user_Lname` varchar(255) NOT NULL,
  `user_Birthdate` varchar(255) NOT NULL,
  `user_Email` varchar(255) NOT NULL,
  `user_Pass` varchar(255) NOT NULL,
  `user_Type` varchar(255) NOT NULL,
  `user_Phone` varchar(255) NOT NULL,
  `user_Status` varchar(255) NOT NULL,
  `u_image` varchar(255) DEFAULT 'userimages/default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`user_id`, `user_Fname`, `user_Lname`, `user_Birthdate`, `user_Email`, `user_Pass`, `user_Type`, `user_Phone`, `user_Status`, `u_image`) VALUES
(7, 'Ehey', 'Yonzon', '08-05-2005', 'reincoronado14@gmail.com', 'zkqlSH7BMS7elnp5or5zepVt+WUCUS7lMANhogBgO7Q=', 'Admin', '+639193636264', 'Active', 'userimages/user_7.png'),
(16, 'test', 'test', '09-05-2005', 'test@email.com', 'Example@123', 'User', '+639958548852', 'Active', 'default.png'),
(18, 'Ivan', 'Colina Noted', '05-05-2005', 'Test2@email.com', 'zkqlSH7BMS7elnp5or5zepVt+WUCUS7lMANhogBgO7Q=', 'User', '3699955220', 'Active', 'default.png'),
(19, 'Bayot', 'Test', '05-05-2005', 'test1@example.com', 'zkqlSH7BMS7elnp5or5zepVt+WUCUS7lMANhogBgO7Q=', 'User', '+63999885500', 'Active', 'default.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activity_logs`
--
ALTER TABLE `activity_logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `staff_id` (`staff_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `created_at` (`created_at`);

--
-- Indexes for table `announcement`
--
ALTER TABLE `announcement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_staff_id` (`staff_id`),
  ADD KEY `fk_user_id` (`user_id`);

--
-- Indexes for table `equipment_tbl`
--
ALTER TABLE `equipment_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `memberships`
--
ALTER TABLE `memberships`
  ADD PRIMARY KEY (`membership_id`),
  ADD KEY `member_id` (`member_id`),
  ADD KEY `membership_type_id` (`membership_plan`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `payments_ibfk_1` (`membership_id`);

--
-- Indexes for table `staff_tbl`
--
ALTER TABLE `staff_tbl`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activity_logs`
--
ALTER TABLE `activity_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `announcement`
--
ALTER TABLE `announcement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `equipment_tbl`
--
ALTER TABLE `equipment_tbl`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `memberships`
--
ALTER TABLE `memberships`
  MODIFY `membership_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `staff_tbl`
--
ALTER TABLE `staff_tbl`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `activity_logs`
--
ALTER TABLE `activity_logs`
  ADD CONSTRAINT `activity_logs_ibfk_1` FOREIGN KEY (`staff_id`) REFERENCES `staff_tbl` (`staff_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `activity_logs_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `announcement`
--
ALTER TABLE `announcement`
  ADD CONSTRAINT `fk_staff_id` FOREIGN KEY (`staff_id`) REFERENCES `staff_tbl` (`staff_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `memberships`
--
ALTER TABLE `memberships`
  ADD CONSTRAINT `memberships_ibfk_1` FOREIGN KEY (`member_id`) REFERENCES `tbl_user` (`user_id`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`membership_id`) REFERENCES `memberships` (`membership_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
