-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 18, 2020 lúc 04:58 AM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.7

CREATE DATABASE IF NOT EXISTS miostore1;
USE miostore1;


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `store`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `account`
--

CREATE TABLE `account` (
  `ID` int(10) NOT NULL,
  `Username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `account`
--

INSERT INTO `account` (`ID`, `Username`, `Password`) VALUES
(12, '1233', '13321'),
(13, '12334', '123'),
(14, 'abc', '123456');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `address`
--

CREATE TABLE `address` (
  `ID` int(10) NOT NULL,
  `Road` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Town` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `City` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `District` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `address`
--

INSERT INTO `address` (`ID`, `Road`, `Town`, `City`, `District`) VALUES
(1, 'Trần phú', 'Hà Đông', 'Hà nội', 'Hà nội');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bill`
--

CREATE TABLE `bill` (
  `ID` int(10) NOT NULL,
  `Order` int(10) DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `ID` int(10) NOT NULL,
  `OrderID` int(10) NOT NULL,
  `Items` int(10) DEFAULT NULL,
  `Customer` int(10) DEFAULT NULL,
  `Quantity` int(10) NOT NULL,
  `Amount` float NOT NULL,
  `ItemID` int(10) NOT NULL,
  `CustomerID` int(10) NOT NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `ID` int(10) NOT NULL,
  `Name` int(10) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Mail` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Gender` int(10) NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TotalSpending` float DEFAULT NULL,
  `CustomerRate` int(10) DEFAULT NULL,
  `AccountID` int(10) NOT NULL,
  `AddressID` int(10) NOT NULL,
  `FullNameID` int(10) NOT NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customerrate`
--

CREATE TABLE `customerrate` (
  `ID` int(10) NOT NULL,
  `CustomerID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `deliverymethod`
--

CREATE TABLE `deliverymethod` (
  `ID` int(10) NOT NULL,
  `OrderID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DeliveryAddress` int(10) DEFAULT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AddressID` int(10) NOT NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `ID` int(10) NOT NULL,
  `Role` int(10) NOT NULL,
  `Department` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Gender` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `AccountID` int(10) NOT NULL,
  `AddressID` int(10) NOT NULL,
  `FullNameID` int(10) NOT NULL
);

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`ID`, `Role`, `Department`, `Birthday`, `Phone`, `Gender`, `AccountID`, `AddressID`, `FullNameID`) VALUES
(1, 1, 'Nhân s?', NULL, '13213', 'Nam', 12, 1, 1),
(2, 1, 'Nhân s?', NULL, '123', 'Nam', 13, 1, 1),
(3, 1, 'Nhân s?', NULL, '123456', 'Nam', 14, 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `fullname`
--

CREATE TABLE `fullname` (
  `ID` int(10) NOT NULL,
  `FirstName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `MiddleName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `LastName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
);

--
-- Đang đổ dữ liệu cho bảng `fullname`
--

INSERT INTO `fullname` (`ID`, `FirstName`, `MiddleName`, `LastName`) VALUES
(1, 'Nguyễn', 'Hữu ', 'Sơn');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `item`
--

CREATE TABLE `item` (
  `ID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SellingPrice` float NOT NULL,
  `Quantity` int(10) NOT NULL,
  `ItemRates` int(10) DEFAULT NULL,
  `Star` float,
  image_path VARCHAR(255),
  description VARCHAR(255)
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `itemrate`
--

CREATE TABLE `itemrate` (
  `ID` int(10) NOT NULL,
  `ItemID` int(10) NOT NULL,
  `Star` int(10) NOT NULL,
  `Comment` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `ID` int(10) NOT NULL,
  `BillID` int(10) NOT NULL,
  `OrderDate` date DEFAULT NULL,
  `Payment` int(10) DEFAULT NULL,
  `Items` int(10) DEFAULT NULL,
  `Quantity` int(10) NOT NULL,
  `Amount` float NOT NULL,
  `Cart` int(10) DEFAULT NULL,
  `Status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DeliveryMethod` int(10) DEFAULT NULL,
  `OrderID` int(10) NOT NULL,
  `CartID` int(10) NOT NULL
);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `paymentmethod`
--

CREATE TABLE `paymentmethod` (
  `ID` int(10) NOT NULL,
  `OrderID` int(10) NOT NULL,
  `Name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Currency` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Discriminator` varchar(255) COLLATE utf8_unicode_ci NOT NULL
);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Cart` (`ItemID`),
  ADD KEY `Cart2` (`CustomerID`),
  ADD KEY `FKCart92266` (`OrderID`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKCustomer95365` (`AccountID`),
  ADD KEY `FKCustomer673544` (`AddressID`),
  ADD KEY `FKCustomer394426` (`FullNameID`);

--
-- Chỉ mục cho bảng `customerrate`
--
ALTER TABLE `customerrate`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKCustomerRa270579` (`CustomerID`);

--
-- Chỉ mục cho bảng `deliverymethod`
--
ALTER TABLE `deliverymethod`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKDeliveryMe413665` (`OrderID`),
  ADD KEY `FKDeliveryMe920723` (`AddressID`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKEmployee390368` (`AccountID`),
  ADD KEY `FKEmployee621458` (`AddressID`),
  ADD KEY `FKEmployee99423` (`FullNameID`);

--
-- Chỉ mục cho bảng `fullname`
--
ALTER TABLE `fullname`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `itemrate`
--
ALTER TABLE `itemrate`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKItemRate408643` (`ItemID`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKOrder345862` (`BillID`),
  ADD KEY `FKOrder795597` (`CartID`);

--
-- Chỉ mục cho bảng `paymentmethod`
--
ALTER TABLE `paymentmethod`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKPaymentMet377403` (`OrderID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `account`
--
ALTER TABLE `account`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `address`
--
ALTER TABLE `address`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `bill`
--
ALTER TABLE `bill`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `cart`
--
ALTER TABLE `cart`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `customerrate`
--
ALTER TABLE `customerrate`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `deliverymethod`
--
ALTER TABLE `deliverymethod`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `fullname`
--
ALTER TABLE `fullname`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `item`
--
ALTER TABLE `item`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `itemrate`
--
ALTER TABLE `itemrate`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `order`
--
ALTER TABLE `order`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `paymentmethod`
--
ALTER TABLE `paymentmethod`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `Cart` FOREIGN KEY (`ItemID`) REFERENCES `item` (`ID`),
  ADD CONSTRAINT `Cart2` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `FKCart92266` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`);

--
-- Các ràng buộc cho bảng `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `FKCustomer394426` FOREIGN KEY (`FullNameID`) REFERENCES `fullname` (`ID`),
  ADD CONSTRAINT `FKCustomer673544` FOREIGN KEY (`AddressID`) REFERENCES `address` (`ID`),
  ADD CONSTRAINT `FKCustomer95365` FOREIGN KEY (`AccountID`) REFERENCES `account` (`ID`);

--
-- Các ràng buộc cho bảng `customerrate`
--
ALTER TABLE `customerrate`
  ADD CONSTRAINT `FKCustomerRa270579` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`ID`);

--
-- Các ràng buộc cho bảng `deliverymethod`
--
ALTER TABLE `deliverymethod`
  ADD CONSTRAINT `FKDeliveryMe413665` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`),
  ADD CONSTRAINT `FKDeliveryMe920723` FOREIGN KEY (`AddressID`) REFERENCES `address` (`ID`);

--
-- Các ràng buộc cho bảng `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `FKEmployee390368` FOREIGN KEY (`AccountID`) REFERENCES `account` (`ID`),
  ADD CONSTRAINT `FKEmployee621458` FOREIGN KEY (`AddressID`) REFERENCES `address` (`ID`),
  ADD CONSTRAINT `FKEmployee99423` FOREIGN KEY (`FullNameID`) REFERENCES `fullname` (`ID`);

--
-- Các ràng buộc cho bảng `itemrate`
--
ALTER TABLE `itemrate`
  ADD CONSTRAINT `FKItemRate408643` FOREIGN KEY (`ItemID`) REFERENCES `item` (`ID`);

--
-- Các ràng buộc cho bảng `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `FKOrder345862` FOREIGN KEY (`BillID`) REFERENCES `bill` (`ID`),
  ADD CONSTRAINT `FKOrder795597` FOREIGN KEY (`CartID`) REFERENCES `cart` (`ID`);

--
-- Các ràng buộc cho bảng `paymentmethod`
--
ALTER TABLE `paymentmethod`
  ADD CONSTRAINT `FKPaymentMet377403` FOREIGN KEY (`OrderID`) REFERENCES `order` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

LOCK TABLES `account` WRITE;
INSERT INTO `account` (`ID`, `Username`, `Password`) VALUES (111, 'hieulc', '123');
UNLOCK TABLES;

LOCK TABLES `fullname` WRITE;
INSERT INTO `fullname` (`ID`, `FirstName`, `MiddleName`, `LastName`) VALUES (1111, 'Hieu', 'Cong', 'Le');
UNLOCK TABLES;

LOCK TABLES `address` WRITE;
INSERT INTO `address` (`ID`, `Road`, `Town`, `City`, `District`) VALUES (11111, 'An Hoa', 'Hadong', 'Hanoi', 'Hanoi');
UNLOCK TABLES;

LOCK TABLES `employee` WRITE;
INSERT INTO `employee` (`ID`, `Role`, `Phone`, `Gender`, `AccountID`, `AddressID`, `FullNameID`) VALUES
(11111, 3, '111111111', 'Male', 111, 11111, 1111);
UNLOCK TABLES;

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item`(`ID`, `Name`, `SellingPrice`, `Quantity`, `image_path`, `description`) VALUES (12,'dell inspirator IO',123.3,1211,'imgs/io.jpg','this is dell laptop'),(16,'Samsung galaxy S20+',20.12,21,'imgs/samsung-galaxy-s20-plus.png','Screen: Dynamic AMOLED 2X, 6.7'),(17,'Earphone Bluetooth Mozard Flex4',123,190,'imgs/tai-nghe-bluetooth-mozard-flex4-den-xanh-1-600x600-1-600x600.jpg','Bluetooth 4.2'),(18,'Laptop Lenovo ThinkPad T560',42.8,75,'imgs/lenovo-thinkpad-t560-300x300.jpg','CPU: 6600U, 2.60 GHz. RAM 32GB'),(19,'Nam MVW ML010-01 Watch',85.1,63,'imgs/mvw-ml010-01-nam-nau-1-600x600.jpg','none '),(20,'Apple Watch S3 LTE 42mm',89,48,'imgs/apple-watch-s3-lte-42mm-vien-nhom-day-cao-su-thum-600x600.jpg','screen: 1.65. IOS 13+'),(21,'Nokia 5.3',32,33,'imgs/nokia-53-den-400x460-400x460.png','Screen: IPS LCD, 6.55'),(22,'Panasonic Inverter 366 ',92,11,'imgs/panasonic-nr-bl389pkvn-1-2-org.jpg','Extra Cool Zone. Inverter Technology.'),(23,'Sharp 1.8l KS-18TJV',38,25,'imgs/panasonic-nr-bl389pkvn-1-2-org.jpg','fast cooking. Volume 1.8l.'),(24,'Robo clean Xiaomi Vacuum Mop SKV4093GL',775,20,'imgs/robot-hut-bui-xiaomi-vacuum-mop-skv4093gl-1-1-org.jpg','Wireless technology, Auto clean room. acitve contineously 2-3 hours  '),(25,'Smart Tivi Samsung UA43RU7200',982.1,32,'imgs/samsung-ua43ru7200-1-2-org.jpg','screen 43 inche, 4K'),(26,'Road GIANT Speeder-D ',532.1,33,'imgs/speeder-d-gloss-white-850.gif','One of bicycle for racing'),(27,'Touring GIANT Escape 1 Disc Asia',652,55,'imgs/escape-1-disc-asia-2020-blue-2000144124.gif','sport design,'),(28,'GIANT TCR Advanced Pro Disc Frame And Fork',4002,5,'imgs/TCR-Advanced-Pro-Disc-2020-Chameleon-Galaxy-850.gif','frame of GIANT TCR Advanced Pro Disc Frame And Fork'),(29,'Clean Code',44,50,'imgs/cleancode.jpg','Clean Code: A Handbook of Agile Software Craftsmanship 1st Edition '),(30,'Effective C++',30.01,100,'imgs/effectivecpp.jpg','Effective C++: 55 Specific Ways to Improve Your Programs and Designs (Professional Computing) 3rd '),(31,'The Giver of Stars',12.01,34,'imgs/thegiverofstars.jpg','The Giver of Stars: A Novel Kindle Edition ');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--   `ID` int(10) NOT NULL,
--   `Name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `SellingPrice` float NOT NULL,
--   `Quantity` int(10) NOT NULL,
--   `ItemRates` int(10) DEFAULT NULL,
--   `Star` float,
--   image_path VARCHAR(255),
--   description VARCHAR(255)
-- 
--   `ID` int(10) NOT NULL,
--   `Role` int(10) NOT NULL,
--   `Department` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `Birthday` date DEFAULT NULL,
--   `Phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `Gender` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
--   `AccountID` int(10) NOT NULL,
--   `AddressID` int(10) NOT NULL,
--   `FullNameID` int(10) NOT NULL