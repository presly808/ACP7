CREATE DATABASE acp7;

use acp7;

CREATE TABLE workers(
 id INT NOT NULL UNIQUE AUTO_INCREMENT,
 name VARCHAR(255) NOT NULL,
 contact VARCHAR(10) NOT NULL UNIQUE,
 age INT
);

SHOW tables;

DESC users;

CREATE TABLE department(
 id int NOT NULL UNIQUE AUTO_INCREMENT,
 name VARCHAR(255),
 PRIMARY KEY(id)
);

ALTER TABLE workers
MODIFY COLUMN contact INT;

ALTER TABLE workers
DROP COLUMN NAME;


ALTER TABLE workers
ADD name VARCHAR(255);

INSERT INTO department(name) VALUES ('sales');
INSERT INTO department(name) VALUES ('logistics');
INSERT INTO department(name) VALUES ('managers');
INSERT INTO department(name) VALUES ('additional');

INSERT INTO workers (name, contact, age) VALUES ('Oleg','0933452312', 28);
INSERT INTO workers (name, contact, age) VALUES ('Vasja','0983452312', 18);
INSERT INTO workers (name, contact, age) VALUES ('Olja','0939452312', 19);
INSERT INTO workers (name, contact, age) VALUES ('Olena','0932452312', 23);

SELECT * FROM workers;

ALTER TABLE workers
    ADD COLUMN dep_id INT,
    ADD FOREIGN KEY (dep_id) REFERENCES department(id);

INSERT INTO workers (dep_id) VALUES (4);

UPDATE workers
 SET dep_id = 2
  WHERE id = 1;


INSERT INTO workers (name, contact, age, dep_id) VALUES ('Oma','0937752312', 23, 2);
INSERT INTO workers (name, contact, age, dep_id) VALUES ('Ola','098752312', 28, 2);
INSERT INTO workers (name, contact, age, dep_id) VALUES ('Opa','0936952312', 23, 3);

SELECT * FROM workers AS w INNER JOIN department AS d ON w.dep_id=d.id;

SELECT w.name,w.contact,w.age,d.name FROM workers w INNER JOIN department d ON w.dep_id=d.id WHERE w.age > 24 AND w.contact LIKE '093%' ORDER BY w.name DESC;
SELECT * FROM workers w FUll JOIN department d ON w.dep_id=d.id;