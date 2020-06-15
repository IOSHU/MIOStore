CREATE DATABASE IF NOT EXISTS miostore;
USE miostore;


CREATE TABLE IF NOT EXISTS person (
	id INTEGER(10) AUTO_INCREMENT,
	_name VARCHAR(50),
        username VARCHAR(50) UNIQUE NOT NULL,
	password VARCHAR(50) NOT NULL,
	address VARCHAR(255),
	phone VARCHAR(11),
	email VARCHAR(50),
	_role VARCHAR(10),
	account_id INTEGER(10),
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS item (
	id INTEGER(10)AUTO_INCREMENT,
	_name VARCHAR(50),
	price FLOAT,
	quantity INTEGER(10),
	image_path VARCHAR(255),
	description VARCHAR(255),
        PRIMARY KEY (id)
);

