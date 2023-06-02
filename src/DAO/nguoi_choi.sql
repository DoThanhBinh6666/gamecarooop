-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 02, 2023 lúc 05:48 AM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.1.12

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
  `ten_nguoi_choi` varchar(255) NOT NULL,
  `diem` int(11) NOT NULL,
  `so_tran_thang` int(11) NOT NULL,
  `so_tran_thua` int(11) NOT NULL,
  `so_tran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoi_choi`
--

INSERT INTO `nguoi_choi` (`ID`, `ten_nguoi_choi`, `diem`, `so_tran_thang`, `so_tran_thua`, `so_tran`) VALUES
(123, 'linh', 0, 0, 0, 0),
(2710, 'binh123', 0, 0, 0, 0),



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
