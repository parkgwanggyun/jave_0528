DROP DATABASE IF EXISTS KHCINEMA;

CREATE DATABASE KHCINEMA;

USE KHCINEMA;

DROP TABLE IF EXISTS `character`;

CREATE TABLE `character` (
	`ch_num`	int primary key auto_increment	NOT NULL,
	`co_role`	char(2)	NULL,
	`ch_name`	varchar(30)	NULL,
	`ch_birth`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `casting`;

CREATE TABLE `casting` (
	`ca_num`	int primary key auto_increment	NOT NULL,
	`ca_name`	varchar(20)	NULL,
	`ca_ch_num`	int	NOT NULL,
	`ca_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `movie`;

CREATE TABLE `movie` (
	`mo_num`	int primary key auto_increment	NOT NULL,
	`mo_title`	varchar(255)	NULL,
	`mo_content`	longtext	NULL,
	`mo_time`	int	NULL,
	`mo_age`	varchar(20)	NULL,
	`mo_date`	date	NULL,
	`mo_genre`	VARCHAR(255)	NULL
);

DROP TABLE IF EXISTS `screen`;

CREATE TABLE `screen` (
	`sc_num`	int primary key auto_increment	NOT NULL,
	`sc_name`	varchar(30)	NULL,
	`sc_seat`	int	NULL
);

DROP TABLE IF EXISTS `schedule`;

CREATE TABLE `schedule` (
	`sd_num`	int primary key auto_increment	NOT NULL,
	`sd_time`	time	NULL,
	`sd_date`	date	NULL,
	`sd_earyly`	int	NULL,
	`sd_sc_num`	int	NOT NULL,
	`sd_mo_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `ticketing`;

CREATE TABLE `ticketing` (
	`ti_num`	int primary key auto_increment	NOT NULL,
	`ti_adult`	int	NULL,
	`ti_teenger`	int	NULL,
	`ti_total`	int	NULL,
	`ti_sd_num`	int	NOT NULL,
	`ti_me_id`	varchar(15)	NOT NULL
);

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
	`me_id`	varchar(15) primary key	NOT NULL,
	`me_pw`	varchar(255)	NULL,
	`me_authority`	varchar(5)	NULL
);

DROP TABLE IF EXISTS `seat`;

CREATE TABLE `seat` (
	`se_num`	int primary key auto_increment	NOT NULL,
	`se_name`	varchar(3)	NULL,
	`se_sc_num`	int	NOT NULL
);

DROP TABLE IF EXISTS `ticketing_list`;

CREATE TABLE `ticketing_list` (
	`tl_num`	int primary key auto_increment	NOT NULL,
	`tl_se_num`	int primary key auto_increment	NOT NULL,
	`tl_ti_num2`	int primary key auto_increment	NOT NULL
);

DROP TABLE IF EXISTS `price`;

CREATE TABLE `price` (
	`pr_num`	int primary key auto_increment	NOT NULL,
	`pr_type`	varchar(10)	NULL,
	`pr_price`	int	NULL
);

ALTER TABLE `character` ADD CONSTRAINT `PK_CHARACTER` PRIMARY KEY (
	`ch_num`
);

ALTER TABLE `casting` ADD CONSTRAINT `PK_CASTING` PRIMARY KEY (
	`ca_num`
);

ALTER TABLE `movie` ADD CONSTRAINT `PK_MOVIE` PRIMARY KEY (
	`mo_num`
);

ALTER TABLE `screen` ADD CONSTRAINT `PK_SCREEN` PRIMARY KEY (
	`sc_num`
);

ALTER TABLE `schedule` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
	`sd_num`
);

ALTER TABLE `ticketing` ADD CONSTRAINT `PK_TICKETING` PRIMARY KEY (
	`ti_num`
);

ALTER TABLE `member` ADD CONSTRAINT `PK_MEMBER` PRIMARY KEY (
	`me_id`
);

ALTER TABLE `seat` ADD CONSTRAINT `PK_SEAT` PRIMARY KEY (
	`se_num`
);

ALTER TABLE `ticketing_list` ADD CONSTRAINT `PK_TICKETING_LIST` PRIMARY KEY (
	`tl_num`
);

ALTER TABLE `price` ADD CONSTRAINT `PK_PRICE` PRIMARY KEY (
	`pr_num`
);
