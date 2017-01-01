CREATE TABLE `user` (
 `username` varchar(20) NOT NULL COMMENT '用户名',
 `password` varchar(20) NOT NULL COMMENT '密码',
  `cellphone_number` varchar(15) COMMENT '手机号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `sex` varchar(3) NOT NULL COMMENT '性别',
  `age` int(3) NOT NULL COMMENT '年龄',
  `is_available` boolean NOT NULL COMMENT '是否可用',
  PRIMARY KEY (`username`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';