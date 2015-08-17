mysql -u root -p
show databases;

CREATE DATABASE acp7;

use acp7;

CREATE TABLE users(
name VARCHAR (255) NOT NULL,
contact VARCHAR (10) NOT NULL UNIQUE ,
age INT,
dep_id VARCHAR (20) NOT NULL,
FOREIGN KEY (dep_id) REFERENCES departments(id)
);

INSERT  INTO users(name, contact, age) VALUES ('Ivan', '4568235876', 50);
INSERT  INTO users(name, contact, age) VALUES ('Maria', '4568235876', 22);
INSERT  INTO users(name, contact, age) VALUES ('Oleg', '4563335876', 13);

SELECT * from users;
SELECT name, contact, age from users;

 ALTER TABLE users ADD PRIMARY KEY (contact);


 CREATE TABLE addresses(
 city VARCHAR (20),
 street VARCHAR (50),
 num INT,
 user_contact VARCHAR (10),
 FOREIGN KEY (user_contact) REFERENCES users(contact)
 );

INSERT INTO addresses VALUES ('Kiev', 'Peremogy', 12, '4568235876');

ALTER TABLE users ADD dep_id VARCHAR (20) NOT NULL;

CREATE TABLE departments(
id int NOT NULL UNIQUE AUTO_INCREMENT,
department_name VARCHAR (20),
PRIMARY KEY (id)
);


ALTER TABLE users ADD FOREIGN KEY (dep_id) REFERENCES departments(id);
