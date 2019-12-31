CREATE TABLE `data_res` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) DEFAULT '0',
  `count` int(11) DEFAULT '0',
  `sum` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1668 DEFAULT CHARSET=utf8


CREATE TABLE `t_data` (
  `id` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DWMC` varchar(254) DEFAULT NULL,
  `code` varchar(254) DEFAULT NULL,
  `value` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
