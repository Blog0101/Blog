
CREATE TABLE `tbl_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '会员名称',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `phone` varchar(11) DEFAULT '' COMMENT '手机号码',
  `password` varchar(32) DEFAULT '' COMMENT '密码',
  `sex` varchar(2) DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `curr_login_time` datetime DEFAULT NULL COMMENT '本次登录时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新资料时间',
  `is_active` int(1) DEFAULT '0' COMMENT '是否已激活，0未激活，1已激活',
  `status` int(2) DEFAULT '0' COMMENT '-1禁用，0启用',
  `birthday` varchar(10) DEFAULT NULL COMMENT '生日',
  `addprovince` varchar(20) DEFAULT '' COMMENT '居住省份',
  `addcity` varchar(20) DEFAULT '' COMMENT '居住城市',
  `addarea` varchar(20) DEFAULT '' COMMENT '居住地区',
  `address` varchar(50) DEFAULT '' COMMENT '居住地址',
  `qq` varchar(15) DEFAULT '' COMMENT 'QQ',
  `wechat` varchar(20) DEFAULT '' COMMENT '微信',
  `contact_phone` varchar(11) DEFAULT '' COMMENT '联系手机号',
  `contact_email` varchar(32) DEFAULT '' COMMENT '联系邮箱',
  `website` varchar(50) DEFAULT '' COMMENT '个人网站',
  `introduce` varchar(255) DEFAULT '' COMMENT '个人介绍',
  `is_admin` int(11) DEFAULT '0' COMMENT '是否管理员，0不是，1是普通管理员，2是超级管理员',
  `follows` INT(11) DEFAULT '0' comment '关注会员数量',
  `fans` INT(11) DEFAULT '0' comment '粉丝数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `tbl_archive` (
  `archive_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '文档标题',
  `member_id` int(11) DEFAULT NULL COMMENT '会员ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `description` varchar(255) DEFAULT NULL COMMENT '描述说明',
  `keywords` varchar(100) DEFAULT NULL COMMENT '关键词',
  `view_rank` int(11) DEFAULT '0' COMMENT '浏览权限，0不限制，1会员',
  `view_count` int(11) DEFAULT '0' COMMENT '浏览次数',
  `writer` varchar(30) DEFAULT '' COMMENT '作者',
  `source` varchar(30) DEFAULT '' COMMENT '来源',
  `pub_time` datetime DEFAULT NULL COMMENT '发布日期',
  `update_time` datetime DEFAULT NULL COMMENT '最后更新时间',
  `thumbnail` varchar(255) DEFAULT NULL COMMENT '缩略图',
  `last_reply` datetime DEFAULT NULL COMMENT '最后回复时间',
  `can_reply` int(1) DEFAULT '0' COMMENT '是否可以回复，0可以回复，1不可以回复',
  `good_num` int(11) DEFAULT '0' COMMENT '点赞数量',
  `bad_num` int(11) DEFAULT '0' COMMENT '踩数量',
  `check_admin` int(11) DEFAULT '0' COMMENT '审核管理员id',
  `content` text COMMENT '内容',
  `favor` int(11) DEFAULT '0' COMMENT '喜欢、点赞',
  PRIMARY KEY (`archive_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_archive_favor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `archive_id` int(11) DEFAULT '0',
  `member_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_archive_id_member_id` (`archive_id`,`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_article_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_member_fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `follow_who` int(11) DEFAULT '0',
  `who_follow` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_follow_who_who_follow` (`follow_who`,`who_follow`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_weibo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `member_id` int(11) NOT NULL,
  `type` int(11) DEFAULT '0' COMMENT '0为普通文本,1为图片',
  `content` varchar(1000) DEFAULT NULL,
  `favor` int(11) DEFAULT '0' COMMENT '赞',
  `status` tinyint(11) DEFAULT '0' COMMENT '0未审核，1已审核，-1审核不通过',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_weibo_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `member_id` int(11) NOT NULL DEFAULT '0',
  `weibo_id` int(11) NOT NULL DEFAULT '0',
  `comment_id` int(11) COMMENT '评论的id',
  `content` varchar(1000) DEFAULT NULL,
  `status` int(11) DEFAULT '0' COMMENT '0正常，1禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `tbl_weibo_favor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `weibo_id` int(11) DEFAULT '0',
  `member_id` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_weibo_id_member_id` (`weibo_id`,`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_picture` (
  `picture_id` INT(11) NOT NULL AUTO_INCREMENT,
  `create_time` datetime DEFAULT NULL,
  `member_id` INT(11),
  `type` INT(11) NOT NULL COMMENT '1是文章图片，2是微博图片，3是群组帖子图片',
  `foreign_id` INT(11) COMMENT '外键ID',
  `path` VARCHAR(255) NOT NULL COMMENT '图片路径',
  `thumbnail_path` VARCHAR(255) COMMENT '缩略图',
  `small_path` VARCHAR(255) COMMENT '按比例缩小的图片',
  `md5` VARCHAR(32) NOT NULL,
  `width` INT(11) DEFAULT '0',
  `height` INT(11) DEFAULT '0',
  `description` VARCHAR(1000),
  `comment_count` INT(11) DEFAULT '0',
  `favor_count` INT(11) DEFAULT '0',
  `album_id` INT(11),
  PRIMARY KEY (picture_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
