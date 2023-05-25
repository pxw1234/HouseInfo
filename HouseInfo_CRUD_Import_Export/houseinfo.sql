/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.26 : Database - house_info
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`house_info` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `house_info`;

/*Table structure for table `houseinfo` */

DROP TABLE IF EXISTS `houseinfo`;

CREATE TABLE `houseinfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cell_name` varchar(20) DEFAULT NULL,
  `building_number` int DEFAULT NULL,
  `unit_number` int DEFAULT NULL,
  `room_number` int DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `unit_price` int DEFAULT NULL,
  `house_type` varchar(20) DEFAULT NULL,
  `area` double DEFAULT NULL,
  `purchasing_method` int DEFAULT NULL COMMENT '购买方式:1是分期 2是全款',
  `is_elevator` int DEFAULT NULL COMMENT '电梯: 0是无 1是有',
  `completion_year` int NOT NULL,
  `is_heating` int DEFAULT NULL COMMENT '供暖: 0是无  1是有',
  `greening_area` int DEFAULT NULL COMMENT '例如：38%,存储的38',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `version` int DEFAULT NULL,
  `deleted` int DEFAULT NULL COMMENT '删除1  未删除0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `houseinfo` */

insert  into `houseinfo`(`id`,`cell_name`,`building_number`,`unit_number`,`room_number`,`total_price`,`unit_price`,`house_type`,`area`,`purchasing_method`,`is_elevator`,`completion_year`,`is_heating`,`greening_area`,`create_time`,`update_time`,`version`,`deleted`) values (1,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',107,1,0,2012,0,38,'2023-05-25 13:16:43','2023-05-25 14:35:30',1,1),(2,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',106,1,0,2012,0,38,'2023-05-25 15:05:33','2023-05-25 15:05:33',1,0),(3,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',106,1,0,2012,0,38,'2023-05-25 15:06:29','2023-05-25 15:06:29',1,1),(4,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',106,1,0,2012,0,38,'2023-05-25 16:45:09','2023-05-25 16:45:09',1,0),(6,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',106,1,0,2012,0,38,'2023-05-25 18:07:02','2023-05-25 18:07:02',1,0),(7,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',106,1,0,2012,0,38,'2023-05-25 18:07:02','2023-05-25 18:07:02',1,0),(8,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',106,1,0,2012,0,38,'2023-05-25 18:08:20','2023-05-25 18:08:20',1,0),(9,'明阳建成小区',9,1,1602,106,6000,'四室两厅两卫',106,1,0,2012,0,38,'2023-05-25 18:08:20','2023-05-25 18:08:20',1,0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
