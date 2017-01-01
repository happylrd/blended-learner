CREATE TABLE `user_action_log` (
 `id`              INT(11)     NOT NULL AUTO_INCREMENT
 COMMENT '自增ID',

 `username`        VARCHAR(20)          DEFAULT NULL
 COMMENT '用户名',

 `method`          VARCHAR(10)          DEFAULT NULL
 COMMENT 'HTTP请求方法',

 `description`     VARCHAR(100)         DEFAULT NULL
 COMMENT '操作描述',

 `request_body`    VARCHAR(60)          DEFAULT NULL
 COMMENT '请求体信息',

 `ip_addr_v4`      VARCHAR(15)          DEFAULT NULL
 COMMENT 'ipV4地址',

 `ip_addr_v6`      VARCHAR(128)         DEFAULT NULL
 COMMENT 'ipv6地址',

 `time`            DATETIME             DEFAULT NULL
 COMMENT '操作时间',

 `session_id`      VARCHAR(45) NOT NULL
 COMMENT '会话ID',

 `os_name`         VARCHAR(20)          DEFAULT NULL
 COMMENT '操作系统名称',

 `os_version`      VARCHAR(20)          DEFAULT NULL
 COMMENT '操作系统版本',

 `browser_name`    VARCHAR(20)          DEFAULT NULL
 COMMENT '浏览器名称',

 `browser_version` VARCHAR(20)          DEFAULT NULL
 COMMENT '浏览器版本',

 PRIMARY KEY (`id`)
)
 ENGINE = InnoDB
 AUTO_INCREMENT = 100
 DEFAULT CHARSET = utf8
 COMMENT = '用户行为日志表';