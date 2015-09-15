

--
-- Create schema db_exam
--

CREATE DATABASE IF NOT EXISTS db_exam;
USE db_exam;


DROP TABLE IF EXISTS `tb_grade`;
CREATE TABLE `tb_grade` (
  `id` int(11) NOT NULL,
  `userName` varchar(100) NOT NULL,
  `radioResult` int(11) NOT NULL,
  `fullResule` int(11) NOT NULL,
  `esitResult` int(11) NOT NULL,
  `batsisResult` int(11) NOT NULL,
  `date` varchar(200) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;

--
-- Dumping data for table `tb_grade`
--
INSERT INTO `tb_grade` (`id`,`userName`,`radioResult`,`fullResule`,`esitResult`,`batsisResult`,`date`) VALUES 
 (10,'ls',15,0,10,25,'2011-01-20 14:38:16'),
 (11,'abc',10,0,20,30,'2011-01-20 14:49:29'),
 (12,'zk',20,0,30,50,'2011-01-20 14:59:44');



--
-- Definition of table `tb_question`
--

DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question` (
  `id` int(11) NOT NULL auto_increment,
  `typeid` int(11) NOT NULL,
  `q_subject` varchar(400) NOT NULL,
  `q_answer` varchar(400) NOT NULL,
  `optionA` varchar(400) NOT NULL,
  `optionB` varchar(400) NOT NULL,
  `optionC` varchar(400) NOT NULL,
  `optionD` varchar(400) NOT NULL,
  `note` varchar(400) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=gb2312;

--
-- Dumping data for table `tb_question`
--


INSERT INTO `tb_question` (`id`,`typeid`,`q_subject`,`q_answer`,`optionA`,`optionB`,`optionC`,`optionD`,`note`) VALUES 
 (1,1,'widows是什么','B','应用程序','操作系统','软件','以上都不对','无'),
 (2,1,'下面哪个不属于数据库对象','A','SELECT语句','ad','ad','dfa','无'),
 (3,3,'Java语言是面向对象的程序设计语言','正确','','','','',''),
 (4,1,'下面哪个不属于Java基本数据类型','A','String类型','int类型','char类型','boolean类型','无'),
 (5,2,'WWW正确解释是？','A,B,C,D','全球网','万维网','World Wide Web的缩写','以上叙述全部正确','无'),
 (6,3,'数据库命名后就不能修改了','错误','','','','','无'),
 (7,1,'下面哪个不属于企业管理器的功能','D','注册服务器','配置本地和远程服务器','引入和导出数据','为Windows创建操作系统用户','无'),
 (8,1,'下面哪个不属于企业管理器的功能','D','注册服务器','配置本地和远程服务器','引入和导出数据','为Windows创建操作系统用户','无'),
 (9,1,'下面哪个不属于企业管理器的功能','D','注册服务器','配置本地和远程服务器','引入和导出数据','为Windows创建操作系统用户','无'),
 (10,3,'String是基本数据类型吗？','错误','','','','','无'),
 (11,3,'数组的下标是从“1”开始的','错误','','','','','无'),
 (12,3,'SQl的意思是结构化查询','正确','','','','','无'),
 (13,2,'Internet提供的基本服务有哪些？','A,B,D','E-mail','FTP','Telnet','WWW','无'),
 (14,3,'defg','dfg','','','','','无'),
 (15,1,'sdgf','A','sdf','sdf','ff','gg','无'),
 (16,2,'fghgfr','A','dfg','dfg','cvb','dfg','无'),
 (17,2,'jyty u','D','sdfg','dfgc','cvbrt','eyrtye','无'),
 (18,2,'jtyiuyjkjg','B','sdfgwert','erte','etghg','fgh','无'),
 (19,3,'sf ','正确','dfg','dfg sdfg','dfg','sgert','无'),
 (20,3,'ert','错误','asdf','dfgfg ','sfg','sgert','无'),
 (21,1,'asdf','C','sadf','fgert','ert','sgf','无'),
 (22,2,'ertwert ','A,B,C,D','sf','sdg','fgh','dfgs','无'),
 (23,2,'fgdfg','A,B','dfg','sfger','hgjyt','fhj','fhjj'),
 (25,3,'sfgfghs','错误','','','','','无'),
 (26,3,'sdhgfhj','正确','','','','','无');


--
-- Definition of table `tb_questiontype`
--

DROP TABLE IF EXISTS `tb_questiontype`;
CREATE TABLE `tb_questiontype` (
  `id` int(11) NOT NULL auto_increment,
  `qName` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

--
-- Dumping data for table `tb_questiontype`
--

INSERT INTO `tb_questiontype` (`id`,`qName`) VALUES 
 (1,'单选题'),
 (2,'多选题'),
 (3,'判断题');


--
-- Definition of table `tb_stat`
--

DROP TABLE IF EXISTS `tb_stat`;
CREATE TABLE `tb_stat` (
  `id` int(11) NOT NULL,
  `radio_BL` int(11) NOT NULL,
  `more_BL` int(11) NOT NULL,
  `judge_BL` int(11) NOT NULL,
  `radio_FS` int(11) NOT NULL,
  `more_FS` int(11) NOT NULL,
  `judge_FS` int(11) NOT NULL,
  `exam_time` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312;

--
-- Dumping data for table `tb_stat`
--
INSERT INTO `tb_stat` (`id`,`radio_BL`,`more_BL`,`judge_BL`,`radio_FS`,`more_FS`,`judge_FS`,`exam_time`) VALUES 
 (1,40,30,30,5,10,10,20);


--
-- Definition of table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL auto_increment,
  `userType` int(11) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `passWord` varchar(220) NOT NULL,
  `havaIn` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=gb2312;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id`,`userType`,`UserName`,`passWord`,`havaIn`) VALUES 
 (1,0,'bbb','BCBE3365E6AC95EA2C0343A2395834DD',1),
 (2,1,'aaa','698D51A19D8A121CE581499D7B701668',1),
 (3,0,'tsoft','698D51A19D8A121CE581499D7B701668',1),
 (4,1,'mr','FDB390E945559E74475ED8C8BBB48CA5',1),
 (5,1,'zzk','5DE7FBD4186F39F6CCBBD13AE8C16C3F',1),
 (6,0,'zhangjing','A10F4B7E48419178177232D2D31DC4B8',1),
 (7,0,'zhd','897D517000A3CE543C7422CF84B505F0',1),
 (8,0,'zx','698D51A19D8A121CE581499D7B701668',1),
 (9,0,'lvshuang','698D51A19D8A121CE581499D7B701668',1),
 (10,0,'ls','698D51A19D8A121CE581499D7B701668',1),
 (11,0,'abc','698D51A19D8A121CE581499D7B701668',1),
 (12,0,'zk','698D51A19D8A121CE581499D7B701668',1);