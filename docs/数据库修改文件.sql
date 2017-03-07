--新建消息表
CREATE TABLE `member_message` (
  `id` int(11) NOT NULL auto_increment,
  `member_id` int(11) default NULL,
  `member_name` varchar(255) default NULL,
  `message` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

