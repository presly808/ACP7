show databases;

CREATE DATABASE acp7;

use acp7;

CREATE TABLE users(
NAME VARCHAR (255)NOT NULL ,
CONTACT VARCHAR (10) NOT NULL UNIQUE,
AGE INT
);

SHOW TABLES;

description USERS;

INSERT INTO users (NAME,CONTACT, AGE) VALUES ('IVAN','0930452312',24);
INSERT INTO users (NAME,CONTACT, AGE) VALUES ('IVAкN','0930452312',2344);

SELECT * FROM users;
SELECT NAME, CONTACT, AGE FROM users;

CREATE TABLE ADDRESSES(
CITY VARCHAR (20) ,
STREET VARCHAR (50) ,
NUM INT,
user_contact VARCHAR(10),
FOREIGN KEY (user_contact) REFERENCES users(CONTACT)
);

ALTER TABLE users add PRIMARY KEY (CONTACT);

CREATE TABLE department(
id_department NOT NULL ,
user_department VARCHAR (10),
PRIMARY
);

CREATE TABLE users(
NAME VARCHAR (255)NOT NULL ,
CONTACT VARCHAR (10) NOT NULL UNIQUE,
AGE INT,
);
