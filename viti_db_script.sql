CREATE DATABASE IF NOT EXISTS vitidb;

USE vitidb;
set names utf8;
set foreign_key_checks = 0;
SET default_storage_engine=INNODB;

-- ----------------------------
--  table structure for users
-- ----------------------------

CREATE  TABLE address (
  	address1 VARCHAR(30) NOT NULL,
	address2 VARCHAR(30),
	city VARCHAR(30) NOT NULL,
	state VARCHAR(30) NOT NULL,
	country VARCHAR(30) NOT NULL,
	zipcode VARCHAR(10) NOT NULL,
	created_on DATETIME NOT NULL,
  	updated_on DATETIME NOT NULL,
  	user_id BIGINT UNSIGNED,
  	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE  TABLE users (
	user_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	firstname VARCHAR(45) NOT NULL ,
  	middlename VARCHAR(45) NOT NULL ,
  	lastname VARCHAR(45) NOT NULL ,
  	password VARCHAR(45) NOT NULL ,
  	gender VARCHAR(6) NOT NULL,
  	dob DATE,
  	email VARCHAR(30) NOT NULL,
  	mobileno VARCHAR(20) NOT NULL,
  	created_on DATETIME NOT NULL,
  	updated_on DATETIME NOT NULL
  );