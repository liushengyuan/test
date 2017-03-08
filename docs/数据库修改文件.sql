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

