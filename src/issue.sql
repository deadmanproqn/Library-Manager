SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

drop table if exists issue;
create table if not exists issue(
	id int(11) NOT NULL AUTO_INCREMENT,
	bookid varchar(50) NOT NULL,
	studentid int(11) NOT NULL,
	issueddate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    primary key (id,bookid,studentid)
)
