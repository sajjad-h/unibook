CREATE DATABASE result;

CREATE DATABASE unibook;

USE unibook;

CREATE TABLE account (
	userId int NOT NULL,
	email varchar(30) PRIMARY KEY, 
	password varchar(30) NOT NULL, 
	phone_no varchar(30) NOT NULL
);

INSERT INTO account (userId, email, password, phone_no) VALUES (1000, "hoosain.sajjad@gmail.com", "1234", "01755367448");
INSERT INTO account (userId, email, password, phone_no) VALUES (1001, "sajjad.h@gmail.com", "12345", "01305264747");
INSERT INTO account (userId, email, password, phone_no) VALUES (1002, "sajjad-ju@gmail.com", "123456", "01345678910");

USE result;

CREATE TABLE user_info (
	userId int AUTO_INCREMENT PRIMARY KEY,
	first_name varchar(30) NOT NULL,
	last_name varchar(30),
	nick_name varchar(30) NOT NULL,
	father_first_name varchar(30) NOT NULL,
	father_last_name varchar(30),
	father_nick_name varchar(30) NOT NULL,
	mother_first_name varchar(30) NOT NULL,
	mother_last_name varchar(30),
	mother_nick_name varchar(30) NOT NULL,
	sex varchar(10) NOT NULL,
	house_no varchar(30) NOT NULL,
	street_no varchar(30),
	village varchar(30) NOT NULL,
	post_office varchar(30) NOT NULL,
	post_code varchar(30) NOT NULL,
	sub_district varchar(30) NOT NULL,
	district varchar(30) NOT NULL,
	birth_of_date date NOT NULL,
	age int AS (FLOOR(DATEDIFF(NOW(), birth_of_date)/365)),
	religion varchar(30) NOT NULL,
	nationality varchar(30) NOT NULL
);

INSERT INTO `user_info` (`userId`, `first_name`, `last_name`, `nick_name`, `father_first_name`, `father_last_name`, `father_nick_name`, `mother_first_name`, `mother_last_name`, `mother_nick_name`, `sex`, `house_no`, `street_no`, `village`, `post_office`, `post_code`, `sub_district`, `district`, `birth_of_date`, `religion`, `nationality`) VALUES
(1, 'Sajjad', 'Hossain', 'Sajjad', 'Abul', 'Kashem', 'Kawsar', 'Nasima', 'Akter', 'Nasima', 'Male', 'KA-512', '24/A', 'Madhobpur', 'Bhawal Rajabari', '1740', 'Sreepur', 'Gazipur', '1998-05-27', 'Islam', 'Bangladeshi');


CREATE TABLE ssc (
	userId int AUTO_INCREMENT PRIMARY KEY,
	roll varchar(20) NOT NULL,
	reg varchar(20) NOT NULL,
	board varchar(20) NOT NULL,
	passing_year int NOT NULL,
	gpa double NOT NULL,
	status varchar(10) NOT NULL,
	group_ varchar(20) NOT NULL
);

INSERT INTO `ssc` (`userId`, `roll`, `reg`, `board`, `passing_year`, `gpa`, `status`, `group_`) VALUES
(1, '120544', '1218733671', 'Dhaka', 2015, 4.83, 'pass', 'Science');

CREATE TABLE hsc (
	userId int AUTO_INCREMENT PRIMARY KEY,
	roll varchar(20) NOT NULL,
	reg varchar(20) NOT NULL,
	board varchar(20) NOT NULL,
	passing_year int NOT NULL,
	gpa double NOT NULL,
	status varchar(10) NOT NULL,
	group_ varchar(20) NOT NULL
);


INSERT INTO `hsc` (`userId`, `roll`, `reg`, `board`, `passing_year`, `gpa`, `status`, `group_`) VALUES
(1, '141989', '1218733671', 'Dhaka', 2017, 4.58, 'pass', 'Science');



