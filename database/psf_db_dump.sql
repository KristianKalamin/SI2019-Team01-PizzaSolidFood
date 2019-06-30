-- MySQL dump 10.13  Distrib 5.7.25, for Win64 (x86_64)
--
-- Host: localhost    Database: psf_db
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additions`
--

DROP TABLE IF EXISTS `additions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `additions` (
  `ID_ADD` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ADD_NAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ADD_PRICE` double(5,2) NOT NULL,
  PRIMARY KEY (`ID_ADD`),
  UNIQUE KEY `ID_ADD` (`ID_ADD`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additions`
--

LOCK TABLES `additions` WRITE;
/*!40000 ALTER TABLE `additions` DISABLE KEYS */;
INSERT INTO `additions` VALUES (1,'Bacon',0.50),(2,'Cheese',0.25),(3,'Mushroom',0.75);
/*!40000 ALTER TABLE `additions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `ID_ORDER` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ORDER_PRICE` double(8,2) NOT NULL,
  `DATE_TIME` datetime NOT NULL,
  `PAYMENT` varchar(250) COLLATE utf8mb4_unicode_ci NOT NULL,
  `QUANTITY` tinyint(3) NOT NULL,
  `ORDER_NUM` int(11) NOT NULL,
  `products_ID_PROD` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`ID_ORDER`,`products_ID_PROD`),
  UNIQUE KEY `ID_ORDER` (`ID_ORDER`),
  KEY `fk_order_products1_idx` (`products_ID_PROD`),
  CONSTRAINT `fk_order_products1` FOREIGN KEY (`products_ID_PROD`) REFERENCES `products` (`ID_PROD`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `psf_db`.`order_BEFORE_INSERT` BEFORE INSERT ON `order` FOR EACH ROW
BEGIN
	set new.date_time = curdate();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `order_has_additions`
--

DROP TABLE IF EXISTS `order_has_additions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_has_additions` (
  `order_ID_ORDER` bigint(20) unsigned NOT NULL,
  `order_products_ID_PROD` bigint(20) unsigned NOT NULL,
  `additions_ID_ADD` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`order_ID_ORDER`,`order_products_ID_PROD`,`additions_ID_ADD`),
  KEY `fk_order_has_additions_additions1_idx` (`additions_ID_ADD`),
  KEY `fk_order_has_additions_order1_idx` (`order_ID_ORDER`,`order_products_ID_PROD`),
  CONSTRAINT `fk_order_has_additions_additions1` FOREIGN KEY (`additions_ID_ADD`) REFERENCES `additions` (`ID_ADD`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_has_additions_order1` FOREIGN KEY (`order_ID_ORDER`, `order_products_ID_PROD`) REFERENCES `order` (`ID_ORDER`, `products_ID_PROD`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_has_additions`
--

LOCK TABLES `order_has_additions` WRITE;
/*!40000 ALTER TABLE `order_has_additions` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_has_additions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `order_with_addition`
--

DROP TABLE IF EXISTS `order_with_addition`;
/*!50001 DROP VIEW IF EXISTS `order_with_addition`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `order_with_addition` AS SELECT 
 1 AS `id_order`,
 1 AS `user_name`,
 1 AS `user_lastname`,
 1 AS `user_type`,
 1 AS `total_price`,
 1 AS `date_time`,
 1 AS `payment`,
 1 AS `quantity`,
 1 AS `order_num`,
 1 AS `prod_name`,
 1 AS `prod_price`,
 1 AS `discount_for_premium_users`,
 1 AS `add_name`,
 1 AS `add_price`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `order_without_addition`
--

DROP TABLE IF EXISTS `order_without_addition`;
/*!50001 DROP VIEW IF EXISTS `order_without_addition`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `order_without_addition` AS SELECT 
 1 AS `id_order`,
 1 AS `user_name`,
 1 AS `user_lastname`,
 1 AS `user_type`,
 1 AS `total_price`,
 1 AS `date_time`,
 1 AS `payment`,
 1 AS `quantity`,
 1 AS `order_num`,
 1 AS `prod_name`,
 1 AS `prod_price`,
 1 AS `discount_for_premium_users`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `ID_ORDERS` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `users_ID_USER` bigint(20) unsigned NOT NULL,
  `TOTAL_PRICE` double(9,2) NOT NULL,
  `ORDERS_ORDER_NUM` int(11) NOT NULL,
  PRIMARY KEY (`ID_ORDERS`,`users_ID_USER`),
  UNIQUE KEY `ID_ORDERS` (`ID_ORDERS`),
  UNIQUE KEY `TOTAL_PRICE_UNIQUE` (`TOTAL_PRICE`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `ID_PROD` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `PROD_NAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `PROD_PRICE` double(7,2) NOT NULL,
  `DISCOUNT_FOR_PREMIUM_USERS` tinyint(3) unsigned DEFAULT NULL,
  `PROD_SIZE` tinyint(3) unsigned NOT NULL,
  `PROD_DESCRIPTION` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `IMAGE` varchar(420) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`ID_PROD`),
  UNIQUE KEY `ID_PROD` (`ID_PROD`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Napoletana',12.35,20,100,'mozzarella cheese, baked ham, mushroom, artichoke and tomato and pizza pugliese, prepared with tomato, mozzarella and onions','img/peperoni.jpg'),(2,'Margherita',15.99,69,100,'San Marzano tomatoes, mozzarella fior di latte, fresh basil, salt and extra-virgin olive oil','img/margherita.jpg'),(3,'Quattro stagioni',20.99,21,100,'artichokes, tomatoes or basil, mushrooms and ham or prosciutto, or olives','img/quattro_stagioni.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_NAME` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `USER_LASTNAME` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ID_USER` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(254) COLLATE utf8mb4_unicode_ci NOT NULL,
  `USER_TYPE` tinyint(3) unsigned NOT NULL,
  `ADDRESS` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `POINTS` smallint(5) unsigned NOT NULL,
  `MONTHLY_ORDERS` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID_USER`),
  UNIQUE KEY `ID_USER` (`ID_USER`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('Mihal','Kalamin',5,'kalamin.michal@gmail.com',0,NULL,6,22);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'psf_db'
--
/*!50003 DROP PROCEDURE IF EXISTS `additions_procedure_premium` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `additions_procedure_premium`(
                                            in product_name varchar(100), 
                                            in order_num int,
                                            in addition_name varchar(100))
BEGIN
    declare _order_price double(8,2);
    declare product_id bigint;
    declare _addition_id varchar(100);
    declare _id_order bigint;
    
    
    select products.id_prod into product_id from products where products.prod_name = product_name;
    select `order`.id_order into _id_order from `order` where `order`.order_num = order_num;
    select additions.id_add into _addition_id from `additions` where additions.add_name = addition_name;
    
    
    insert into `order_has_additions`(ORDER_ID_ORDER, ORDER_PRODUCTS_ID_PROD, ADDITIONS_ID_ADD)
    values(_id_order, product_id, _addition_id);
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `complete_order_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `complete_order_procedure`(in order_num int,
                                            in user_mail varchar(254)
                                            )
BEGIN
    
    declare _points smallint;
    declare _monthly_orders smallint;
    declare _id_user bigint;
    declare _total_price double(9,2);
    declare total_order_price double(8,2);
    declare total_add_price double(5,2);
    declare _id_order bigint;
    
    
    select id_user into _id_user from users where users.email = user_mail;
    
    select sum(`order`.order_price) into total_order_price from `order` where `order`.order_num = order_num;
    select sum(`additions`.add_price) into total_add_price 
    from additions, order_has_additions, `order`
    where 
        order_has_additions.order_id_order = `order`.id_order
        and
        order_has_additions.additions_id_add = additions.id_add
        and
        `order`.ORDER_NUM = order_num;
   
    if total_add_price is null then
		set total_add_price = 0;
	end if;
   
    set _total_price = total_order_price + total_add_price;
    select total_add_price;
    select total_order_price;
    select _total_price;
    
    insert into orders (USERS_ID_USER, TOTAL_PRICE, ORDERS_ORDER_NUM)
    values(_id_user, _total_price, order_num);
	
    select users.points into _points from users where users.email = user_mail;
    select users.monthly_orders into _monthly_orders from users where users.email = user_mail;

    update users
    set points = _points + ROUND(_total_price) / 100,
    monthly_orders = _monthly_orders + 1
    where users.email = user_mail;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `order_procedure` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `order_procedure`(in email varchar(254), 
                                            in product_name varchar(100), 
                                            in payment varchar(250),
                                            in quantity tinyint,
                                            in order_num int)
BEGIN
    
    declare _order_price double(8,2);
    declare product_id bigint;
    declare price double(7,2);
    declare order_price double(8,2);
    declare discount tinyint;
    declare user_type tinyint;
    declare dis tinyint;

    select users.user_type into user_type from users where users.email = email;

    select products.id_prod, products.prod_price, products.discount_for_premium_users
    into product_id, price, discount
    from products where products.prod_name = product_name;
   
	IF user_type = 0 then
		set discount = 0;
    end if;
   
    set dis = price * (discount / 100);
    set order_price = (price - dis) * quantity;
    
    insert into `order`(ORDER_PRICE, PAYMENT, QUANTITY, ORDER_NUM, PRODUCTS_ID_PROD)
    values(order_price, payment, quantity, order_num, product_id);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `order_with_addition`
--

/*!50001 DROP VIEW IF EXISTS `order_with_addition`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `order_with_addition` AS select `order`.`ID_ORDER` AS `id_order`,`users`.`USER_NAME` AS `user_name`,`users`.`USER_LASTNAME` AS `user_lastname`,`users`.`USER_TYPE` AS `user_type`,`orders`.`TOTAL_PRICE` AS `total_price`,`order`.`DATE_TIME` AS `date_time`,`order`.`PAYMENT` AS `payment`,`order`.`QUANTITY` AS `quantity`,`order`.`ORDER_NUM` AS `order_num`,`products`.`PROD_NAME` AS `prod_name`,`products`.`PROD_PRICE` AS `prod_price`,`products`.`DISCOUNT_FOR_PREMIUM_USERS` AS `discount_for_premium_users`,`additions`.`ADD_NAME` AS `add_name`,`additions`.`ADD_PRICE` AS `add_price` from (((((`users` join `orders`) join `order`) join `products`) join `additions`) join `order_has_additions`) where ((`users`.`ID_USER` = `orders`.`users_ID_USER`) and (`orders`.`ORDERS_ORDER_NUM` = `order`.`ORDER_NUM`) and (`order`.`products_ID_PROD` = `products`.`ID_PROD`) and (`order`.`ID_ORDER` = `order_has_additions`.`order_ID_ORDER`) and (`additions`.`ID_ADD` = `order_has_additions`.`additions_ID_ADD`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `order_without_addition`
--

/*!50001 DROP VIEW IF EXISTS `order_without_addition`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `order_without_addition` AS select `order`.`ID_ORDER` AS `id_order`,`users`.`USER_NAME` AS `user_name`,`users`.`USER_LASTNAME` AS `user_lastname`,`users`.`USER_TYPE` AS `user_type`,`orders`.`TOTAL_PRICE` AS `total_price`,`order`.`DATE_TIME` AS `date_time`,`order`.`PAYMENT` AS `payment`,`order`.`QUANTITY` AS `quantity`,`order`.`ORDER_NUM` AS `order_num`,`products`.`PROD_NAME` AS `prod_name`,`products`.`PROD_PRICE` AS `prod_price`,`products`.`DISCOUNT_FOR_PREMIUM_USERS` AS `discount_for_premium_users` from (((`users` join `orders`) join `order`) join `products`) where ((`users`.`ID_USER` = `orders`.`users_ID_USER`) and (`orders`.`ORDERS_ORDER_NUM` = `order`.`ORDER_NUM`) and (`order`.`products_ID_PROD` = `products`.`ID_PROD`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-22 16:59:27
