CREATE DATABASE result;

CREATE DATABASE unibook;

CREATE TABLE account (
	userId int,
	email varchar(30) PRIMARY KEY, 
	password varchar(30)
);

INSERT INTO account (userId, email, password) VALUES (1000, "hoosain.sajjad@gmail.com", "1234");
INSERT INTO account (userId, email, password) VALUES (1001, "sajjad.h@gmail.com", "12345");
INSERT INTO account (userId, email, password) VALUES (1001, "sajjad-ju@gmail.com", "123456");

