
DROP DATABASE IF EXISTS auctionsystem;

CREATE DATABASE auctionsystem;

USE auctionsystem;


DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(12) primary key	NOT NULL,
	`me_password`	varchar(14)	NOT NULL,
	`me_name`	varchar(10)	NOT NULL,
	`me_address`	varchar(35)	NOT NULL,
	`me_contact`	varchar(13)	NOT NULL
);

DROP TABLE IF EXISTS `auction`;

CREATE TABLE `auction` (
	`au_num`	int primary key auto_increment	NOT NULL,
	`au_date`	datetime default current_timestamp	NOT NULL,
	`au_name`	varchar(20)	NOT NULL,
	`au_start_price`	int	NOT NULL,
	`au_winning_bid`	int	NULL,
	`au_me_id`	varchar(12)	NULL
);

DROP TABLE IF EXISTS `bid`;

CREATE TABLE `bid` (
	`bi_num`	int primary key auto_increment	NOT NULL,
	`bi_price`	int	NOT NULL,
	`bi_au_num`	int	NULL,
	`bi_me_id`	varchar(12)	NULL
);