-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 31, 2023 lúc 10:51 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `doangame`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoi_choi`
--

CREATE TABLE `nguoi_choi` (
  `ID` int(11) NOT NULL,
  `ten_nguoi_choi` varchar(255) DEFAULT NULL,
  `so_tran_thang` int(11) DEFAULT NULL,
  `diem_so` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoi_choi`
--

INSERT INTO `nguoi_choi` (`ID`, `ten_nguoi_choi`, `so_tran_thang`, `diem_so`) VALUES
(123, 'linh', NULL, NULL),
(2511, 'linhdaubuoi', NULL, NULL),
(2710, 'binh123', NULL, NULL),
(88888, 'linhdaubuoi', NULL, NULL),
(25112003, 'lanhcuccut', NULL, NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `nguoi_choi`
--
ALTER TABLE `nguoi_choi`
  ADD PRIMARY KEY (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
