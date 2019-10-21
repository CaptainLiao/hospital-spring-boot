CREATE TABLE `session` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sessionId` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `expired` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户登录状态信息维护表'