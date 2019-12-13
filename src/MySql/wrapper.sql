CREATE TABLE `discounts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `discount_end_price` int(11) DEFAULT NULL,
  `discount_start_price` int(11) DEFAULT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_discount` (`discount_start_price`,`discount_end_price`)
);