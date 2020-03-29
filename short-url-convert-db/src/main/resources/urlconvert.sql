CREATE TABLE `urlconvert` (
 `id` int  NOT NULL AUTO_INCREMENT COMMENT '主键',
 `long_url` varchar(150)  NOT NULL  COMMENT '长链接',
 `short_url` varchar(20)  NOT NULL  COMMENT '短链接',
 `hashcode` int  NOT NULL  COMMENT 'hash 码',
 `source` tinyint  NULL DEFAULT 0  COMMENT 'source',
 `type` tinyint  NULL DEFAULT 0  COMMENT '链接类型',
 `deleted` bit  NULL DEFAULT 0  COMMENT '删除位',
 `user_id` int unsigned  NULL DEFAULT 0  COMMENT '用户id',
 `created` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
 `last_modified` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
 COMMENT '最后修改时间',
 PRIMARY KEY (`id`), UNIQUE KEY `HASHCODE` (`hashcode`) USING BTREE ) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT=''