CREATE DATABASE IF NOT EXISTS vitidb;

USE vitidb;
set names utf8;
set foreign_key_checks = 0;
SET default_storage_engine=INNODB;

-- ----------------------------
--  table structure for users
-- ----------------------------

CREATE  TABLE users (
	user_id int NOT NULL auto_increment primary key,
  	firstname VARCHAR(45) NOT NULL ,
  	middlename VARCHAR(45) NOT NULL ,
  	lastname VARCHAR(45) NOT NULL ,
  	password VARCHAR(45) NOT NULL ,
  	gender varchar(6) NOT NULL,
  	dob date,
  	email varchar(30) NOT NULL,
  	mobileno VARCHAR(20) NOT NULL,
  	address_id int NOT NULL,
  	FOREIGN KEY fk_address(address_id)
  	REFERENCES address(address_id) ON UPDATE CASCADE ON DELETE RESTRICT
  	created_at DATETIME NOT NULL,
  	updated_at DATETIME NOT NULL
  );
  