mysql -u root -p

show databases;

CREATE DATABASES acp7;

use acp7;

CREATE  TABLE users(
name VARCHAR (255) NOT NULL ,
contact VARCHAR (10) NOT NULL UNIQUE ,
age INT
);
SHOW tables;

DESC users;

INSERT  INTO users ( name, contact, age) VALUES ('Artem','0935021561','20');
INSERT  INTO users ( name, contact, age) VALUES ('Oleg','0678976542','25');
INSERT  INTO users ( name, contact, age) VALUES ('Sasha','0677167994','29');

SELECT  * FROM users; // show all field;
SELECT  name,contact,age FROM  users;

ALTER TABLE users ADD PRIMARY  KEY (contact);


 CREATE  TABLE addresses(
city VARCHAR (20),
street VARCHAR (50),
num INT,
users_contact VARCHAR (10),
FOREIGN KEY(users_contact)REFERENCES users(contact)

);

CREATE  TABLE depart(
name_depart VARCHAR (20),
users_contact VARCHAR (10),
FOREIGN KEY(users_contact)REFERENCES users(contact)
);

CREATE  TABLE users(
name VARCHAR (255) NOT NULL ,
contact VARCHAR (10) NOT NULL UNIQUE ,
age INT
);