-- CREATE DATABASE IF NOT EXISTS vitidb;

DROP DATABASE IF EXISTS vitidb;
CREATE DATABASE vitidb;
USE vitidb;
set names utf8;
set foreign_key_checks = 0;
SET default_storage_engine=INNODB;

-- ----------------------------
--  table structure for users
-- ----------------------------

CREATE TABLE users (
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

DROP TABLE IF EXISTS students;

CREATE TABLE students (
	student_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	firstname VARCHAR(45) NOT NULL ,
  	middlename VARCHAR(45) NOT NULL ,
  	lastname VARCHAR(45) NOT NULL ,
  	password VARCHAR(45) NOT NULL ,
  	gender VARCHAR(6) NOT NULL,
  	dob DATE,
  	email VARCHAR(30) NOT NULL,
  	mobileno VARCHAR(20) NOT NULL,
  	cousre_id VARCHAR(20) NOT NULL,
  	rollno VARCHAR(20) NOT NULL,
  	studentclass  VARCHAR(20) NOT NULL,
  	created_on DATETIME NOT NULL,
  	updated_on DATETIME NOT NULL
  );

DROP TABLE IF EXISTS address;

CREATE  TABLE address (
  	address1 VARCHAR(30) NOT NULL,
	address2 VARCHAR(30),
	city VARCHAR(30) NOT NULL,
	state VARCHAR(30) NOT NULL,
	country VARCHAR(30) NOT NULL,
	zipcode VARCHAR(10) NOT NULL,
	created_on DATETIME NOT NULL,
  	updated_on DATETIME NOT NULL,
  	user_id BIGINT UNSIGNED NULL,
  	student_id BIGINT UNSIGNED NULL,
  	FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  	FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE ON UPDATE CASCADE
);
  
  CREATE TABLE students (
	student_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	firstname VARCHAR(45) NOT NULL ,
  	middlename VARCHAR(45) NOT NULL ,
  	lastname VARCHAR(45) NOT NULL ,
  	password VARCHAR(45) NOT NULL ,
  	gender VARCHAR(6) NOT NULL,
  	dob DATE,
  	email VARCHAR(30) NOT NULL,
  	mobileno VARCHAR(20) NOT NULL,
  	cousre_id VARCHAR(20) NOT NULL,
  	rollno VARCHAR(20) NOT NULL,
  	studentclass  VARCHAR(20) NOT NULL,
  	created_on DATETIME NOT NULL,
  	updated_on DATETIME NOT NULL
  );
  
  CREATE TABLE role (
  	role_id TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	role_name VARCHAR(30)
  );
  
  CREATE TABLE course (
  	course_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	course_name VARCHAR(50)
  );
  
  CREATE TABLE grade (
  	grade_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	grade_name VARCHAR(30)
  );
  
  CREATE TABLE attendance (
  	attendance_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	student_id BIGINT UNSIGNED,
  	FOREIGN KEY (student_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
  	course_id SMALLINT UNSIGNED,
  	FOREIGN KEY (course_id) REFERENCES course(course_id) ON DELETE CASCADE ON UPDATE CASCADE,
  	attendance_date DATE,
  	status TINYINT UNSIGNED,
  	comments VARCHAR(100)
  );
  
  CREATE TABLE STATUS (
  	status_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  	status VARCHAR(20) NOT NULL,
  	remarks VARCHAR(50)
  );
