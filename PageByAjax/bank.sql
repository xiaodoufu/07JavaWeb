/*
SQLyog v10.2 
MySQL - 5.6.24 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `news_detail` (
	`id` int (11),
	`categoryId` int (10),
	`title` varchar (300),
	`summary` varchar (600),
	`content` text ,
	`picPath` varchar (150),
	`author` varchar (150),
	`createDate` datetime ,
	`modifyDate` datetime 
); 
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('22','3','建军大业1111111','摘要','								  <!-- 新闻内容 -->\r\n								  								  <!-- 新闻内容 -->\r\n								  								  <!-- 新闻内容 -->\r\n								  								  <!-- 新闻内容 -->\r\n								  								  <!-- 新闻内容 -->\r\n								  								  <!-- 新闻内容 -->\r\n								  								     \r\n								\r\n								\r\n								\r\n								\r\n								\r\n								\r\n								','','author','2017-02-10 09:44:18','2017-05-26 09:43:31');
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('24','3','分手大师1','主演：邓超，孙俪','								     \r\n								','','邓超','2017-02-11 22:55:48','2017-05-08 17:03:11');
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('25','1','发送到','时代风帆大厦','反倒是发的啥地方',NULL,'发的啥地方','2017-02-11 22:59:09',NULL);
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('26','1','元宵','正月十五','吃汤圆',NULL,'陆哲武','2017-02-11 23:08:04',NULL);
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('37','1','情人节','虐狗节','<p style=\"text-align: center;\">\r\n	<span style=\"color:#00ff00;\"><u><em><strong>张三相亲，可能吗？</strong></em></u></span></p>\r\n',NULL,'editor','2017-02-14 10:00:48',NULL);
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('40','1','今天周四','学习吧','骚年','newStar.jpg','editor','2017-02-16 09:40:11',NULL);
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('42','4','娱乐新闻','大新闻','								  <!-- 新闻内容 -->\r\n								  开火车\r\n								','星空1.jpg','张三','2017-02-17 12:17:20',NULL);
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('43','5','hahaha','哈哈','								  <!-- 新闻内容 -->\r\n								  								  <!-- 新闻内容 -->\r\n								  								  <!-- 新闻内容 -->\r\n								  <b><i>ssasasas</i></b>								\r\n								\r\n								\r\n								',NULL,'嘿嘿','2012-02-08 00:00:00',NULL);
insert into `news_detail` (`id`, `categoryId`, `title`, `summary`, `content`, `picPath`, `author`, `createDate`, `modifyDate`) values('46','3','1111','11111','1111111',NULL,'1111111','0012-02-16 00:00:00',NULL);
