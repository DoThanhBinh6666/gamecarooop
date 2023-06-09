-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 09, 2023 lúc 03:25 PM
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
  `diem_so` int(11) NOT NULL,
  `so_tran_thang` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoi_choi`
--

INSERT INTO `nguoi_choi` (`ID`, `ten_nguoi_choi`, `diem_so`, `so_tran_thang`) VALUES
(123, 'linh', 150, 9),
(304, 'lyiulan', 10, 1),
(987, 'nguoichoi', 0, 0),
(1901, 'thanhbinh', 0, 0),
(2511, 'lananh', 40, 5),
(2709, 'duc', 0, 0),
(2710, 'binh123', -40, 3),
(3858, 'lananh', 0, 0),
(7654, 'lan', 0, 0),
(8740, 'lananh', 0, 0),
(9453, 'ly', 0, 0),
(29111, 'them', 0, 0),
(1234556, 'binh', 0, 0),
(25112003, 'lan anh', 10, 1),
(27102003, 'binh123', 10, 1);

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
