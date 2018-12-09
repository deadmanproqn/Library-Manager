CREATE TABLE `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `studentid` int(5) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `city` varchar(100) NOT NULL,
  `contact` varchar(20) NOT NULL,
  `librarian` tinyint(1) NOT NULL,
  `admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`,`studentid`),
  UNIQUE KEY `studentid_UNIQUE` (`studentid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
insert into user (studentid,name,password,email,address,city,contact,librarian,admin) values
(123,'nguyen',123,'nguyen@student.vgu.edu.vn','ktx','tdm','ktx',1,1),
(234,'long',234,'long@student.vgu.edu.vn','ktx','tdm','ktx',1,0),
(345,'vinh',345,'vinh@student.vgu.edu.vn','ktx','tdm','ktx',0,0);
