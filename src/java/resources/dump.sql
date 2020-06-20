
LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item`('id', 'name', 'sellingprice', 'quantity', 'image_path', 'description') VALUES (12,'dell inspirator IO',123.3,1211,'imgs/io.jpg','this is dell laptop'),(16,'Samsung galaxy S20+',20.12,21,'imgs/samsung-galaxy-s20-plus.png','Screen: Dynamic AMOLED 2X, 6.7'),(17,'Earphone Bluetooth Mozard Flex4',123,190,'imgs/tai-nghe-bluetooth-mozard-flex4-den-xanh-1-600x600-1-600x600.jpg','Bluetooth 4.2'),(18,'Laptop Lenovo ThinkPad T560',42.8,75,'imgs/lenovo-thinkpad-t560-300x300.jpg','CPU: 6600U, 2.60 GHz. RAM 32GB'),(19,'Nam MVW ML010-01 Watch',85.1,63,'imgs/mvw-ml010-01-nam-nau-1-600x600.jpg','none '),(20,'Apple Watch S3 LTE 42mm',89,48,'imgs/apple-watch-s3-lte-42mm-vien-nhom-day-cao-su-thum-600x600.jpg','screen: 1.65. IOS 13+'),(21,'Nokia 5.3',32,33,'imgs/nokia-53-den-400x460-400x460.png','Screen: IPS LCD, 6.55'),(22,'Panasonic Inverter 366 ',92,11,'imgs/panasonic-nr-bl389pkvn-1-2-org.jpg','Extra Cool Zone. Inverter Technology.'),(23,'Sharp 1.8l KS-18TJV',38,25,'imgs/panasonic-nr-bl389pkvn-1-2-org.jpg','fast cooking. Volume 1.8l.'),(24,'Robo clean Xiaomi Vacuum Mop SKV4093GL',775,20,'imgs/robot-hut-bui-xiaomi-vacuum-mop-skv4093gl-1-1-org.jpg','Wireless technology, Auto clean room. acitve contineously 2-3 hours  '),(25,'Smart Tivi Samsung UA43RU7200',982.1,32,'imgs/samsung-ua43ru7200-1-2-org.jpg','screen 43 inche, 4K'),(26,'Road GIANT Speeder-D ',532.1,33,'imgs/speeder-d-gloss-white-850.gif','One of bicycle for racing'),(27,'Touring GIANT Escape 1 Disc Asia',652,55,'imgs/escape-1-disc-asia-2020-blue-2000144124.gif','sport design,'),(28,'GIANT TCR Advanced Pro Disc Frame And Fork',4002,5,'imgs/TCR-Advanced-Pro-Disc-2020-Chameleon-Galaxy-850.gif','frame of GIANT TCR Advanced Pro Disc Frame And Fork'),(29,'Clean Code',44,50,'imgs/cleancode.jpg','Clean Code: A Handbook of Agile Software Craftsmanship 1st Edition '),(30,'Effective C++',30.01,100,'imgs/effectivecpp.jpg','Effective C++: 55 Specific Ways to Improve Your Programs and Designs (Professional Computing) 3rd '),(31,'The Giver of Stars',12.01,34,'imgs/thegiverofstars.jpg','The Giver of Stars: A Novel Kindle Edition ');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-20 17:06:23
