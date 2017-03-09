--新建消息表 2017/3/8
CREATE TABLE `member_message` (
  `id` int(11) NOT NULL auto_increment,
  `member_id` int(11) default NULL,
  `member_name` varchar(255) default NULL,
  `message` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
--默认活动表  2017-3-8
CREATE TABLE `act` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `act_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
--活动商品关联表
CREATE TABLE `act_goods` (
  `id` int(11) NOT NULL,
  `act_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--添加member_email 字段 2017/3/9
alter table member_message add member_email varchar(255) DEFAULT NULL;
--添加member_phone 字段 2017/3/9
alter table member_message add member_phone int(11) DEFAULT NULL;
--创建购物车表
CREATE TABLE `cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_image1` varchar(255) DEFAULT NULL,
  `goods_price` double DEFAULT NULL,
  `is_select` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
--活动表是否显示添加字段  2017-3-9
alter table act add status int(11) DEFAULT NULL;
--cart 添加num 字段  2017-3-9
alter table cart add num int(11) DEFAULT NULL;
alter table cart add member_id int(11) DEFAULT NULL;
--订单表 2017-3-9
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_id` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
