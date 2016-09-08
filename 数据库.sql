-- 数据库名：note
-- 数据库用户名:note
-- 数据库用户密码:notepassword

-- create database note;
grant all privileges on note.* to note@localhost identified by 'notepassword';
flush privileges;

/* id为主键，user为用户名，tel为电话，passwd为密码，email为邮箱 */
CREATE TABLE user (
id int(10) unsigned NOT NULL AUTO_INCREMENT,
user varchar(200) ,
passwd varchar(200) ,
tel varchar(20) NOT NULL ,
email varchar(20) NOT NULL DEFAULT '',
userimg varchar(200) NOT NULL DEFAULT '',
PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*笔记分类表，包括id主键，classname笔记分类名称，classdesc笔记分类备注描述，
articlenum本分类笔记数量，userid关联user表的id */

CREATE TABLE noteclass (
id int(20) unsigned NOT NULL AUTO_INCREMENT,
classname varchar(20) NOT NULL DEFAULT ' ',
classdesc varchar(20) NOT NULL DEFAULT ' ',
articlenum int(10) NOT NULL DEFAULT '0',
userid int(10) unsigned NOT NULL, 

PRIMARY KEY (id),
FOREIGN KEY (userid) REFERENCES user(id),
KEY noteclass_classname (classname)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/* 笔记正文分类，包括id主键，userid所属用户的id，classid笔记分类的id，title标题，desc摘要，
date时间，modified修改时间，content内容 */

CREATE TABLE notearticle (
id int(20) unsigned NOT NULL AUTO_INCREMENT,
userid int(10) unsigned NOT NULL, 
classid int(10) unsigned NOT NULL,
title varchar(50) NOT NULL DEFAULT '',
date datetime,
modified datetime,
descs varchar(500) NOT NULL,
content longtext NOT NULL,
PRIMARY KEY (id),

FOREIGN KEY (userid) REFERENCES user(id), 
FOREIGN KEY (classid) REFERENCES noteclass(id), 

KEY notearticle_title (title),
KEY notearticle_userid (userid),
KEY notearticle_classid (classid)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;


/* 群组表，包括id主键，ownuserid群主用户的id（可删除群组，删除群内消息，文章和销毁群），
title群组名称，desc描述，date创建时间 */

CREATE TABLE groups(
id int(20) unsigned NOT NULL AUTO_INCREMENT,
ownuserid int(10) unsigned NOT NULL,
title varchar(50) NOT NULL DEFAULT '',
date datetime,
descs varchar(500) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (ownuserid) REFERENCES user(id)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;


/* 群组和用户连接表，id主键，userid用户的id，group群组的id */

CREATE TABLE grouplink(
id int(20) unsigned NOT NULL AUTO_INCREMENT,
userid int(10) unsigned NOT NULL,
groupid int(10) unsigned NOT NULL,
PRIMARY KEY (id),

FOREIGN KEY (userid) REFERENCES user(id),
FOREIGN KEY (groupid) REFERENCES groups(id),
  
KEY grouplink_userid (userid),
KEY grouplink_groupid (groupid)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;



/* 群和文章连接表，id主键，groupid群组的id，articleid文章表的id */

CREATE TABLE grouparticle(
id int(20) unsigned NOT NULL AUTO_INCREMENT,
groupid int(10) unsigned NOT NULL,
articleid int(10) unsigned NOT NULL,
PRIMARY KEY (id),

FOREIGN KEY (groupid) REFERENCES groups(id),
FOREIGN KEY (articleid) REFERENCES notearticle(id),

KEY grouparticle_groupid (groupid),
KEY grouparticle_articleid (articleid)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;

/* 群组消息表，包括id主键，groupid所属群的id，title标题，desc摘要，date时间 */
CREATE TABLE groupmsg(
id int(20) unsigned NOT NULL AUTO_INCREMENT,
groupid int(10) unsigned NOT NULL,
title varchar(50) NOT NULL DEFAULT '',
date datetime,
descs varchar(500) NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (groupid) REFERENCES groups(id),

KEY groupmsg_title (title),
KEY groupmsg_groupid (groupid)
) ENGINE=InnoDB AUTO_INCREMENT=183 DEFAULT CHARSET=utf8;
