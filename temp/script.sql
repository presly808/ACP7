mysql -u root -p

show databeses;

CREATE DATABASE acp7;

use acp7;

CREATE TABLE users(
 name VARCHAR(255) NOT NULL,
 contact VARCHAR(10) NOT NULL UNIQUE,
 age INT
);

SHOW tables;

DESC users;

INSERT INTO users(name,contact,age) VALUES ('Ivan','0933452312',24);

SELECT * FROM users; -- comment  --
SELECT name,contact,age FROM users;


ALTER TABLE users ADD PRIMARY KEY (contact);

CREATE TABLE addresses (
 city VARCHAR(20),
 street VARCHAR(50),
 num int,
 user_contact VARCHAR(10),
 FOREIGN KEY (user_contact) REFERENCES users(contact)
);

INSERT INTO addresses (city, street, user_contact) VALUES ('Kiev','Peremogy','0933452312');

CREATE TABLE department(
 id int NOT NULL UNIQUE AUTO_INCREMENT,
 name VARCHAR(255),
 PRIMARY KEY(id)
);

ALTER TABLE users
    ADD COLUMN dep_id INT,
    ADD FOREIGN KEY (dep_id) REFERENCES department(id);


INSERT INTO department(name) VALUES ('sales');
INSERT INTO department(name) VALUES ('logistics');
INSERT INTO department(name) VALUES ('managers');
INSERT INTO department(name) VALUES ('additional');

INSERT INTO users(name,contact,age,dep_id) VALUES ('Andrey','09334511',34,2);
INSERT INTO users(name,contact,age,dep_id) VALUES ('Martin','093222233',22,1);
INSERT INTO users(name,contact,age,dep_id) VALUES ('Lev','0932222312',24,4);

SELECT * FROM users AS u INNER JOIN department AS d ON u.dep_id=d.id;

SELECT * FROM users u LEFT JOIN department d ON u.dep_id=d.id;

SELECT u.name,u.contact,u.age,d.name FROM users u INNER JOIN department d ON u.dep_id=d.id WHERE u.age > 24 AND u.contact LIKE '093%' ORDER BY u.name DESC;
