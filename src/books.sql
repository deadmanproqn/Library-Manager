SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+07:00";
drop table if exists books;
create table if not exists books(
	id int(11) NOT NULL AUTO_INCREMENT,
	bookid int(50) NOT NULL unique,
    name varchar(100),
    author varchar(100) NOT NULL,
	publisher varchar(100) NOT NULL,
    quantity int(10) NOT NULL,
	issued int(10) NOT NULL Default 0,
	date timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key (id,bookid)
);

insert INTO books (bookid, name, author, publisher, quantity) VALUES
(1235, 'C In Depth', 'Prof.A', 'PL.A', 2),
(2857, 'DBMS', 'Prof.B', 'PL.B', 3),
(1241, 'Java as fast as Posible', 'Prof.C', 'PL.C', 10);