CREATE SCHEMA IF NOT EXISTS auth_server;
USE auth_server;

CREATE TABLE IF NOT EXISTS users(
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(100) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);
	
CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);

INSERT INTO users (username, password, enabled) VALUES ('plainUser', '$2a$10$KxTc8SYbIB/IaXCWz6NA4ug1pkAYM/e.P.0YQFGE3Ua4FZ6Qf842a', true);
INSERT INTO users (username, password, enabled) VALUES ('managerUser', '$2a$10$QPnaeWBWz1BdDglni2CLzO2YMeifVXtQDPgUOVNETTcj8cEGwqiym', true);
INSERT INTO users (username, password, enabled) VALUES ('adminUser', '$2a$10$Hc878CPLJ4hOtwyzt6V7..LHtzhcR3zqcXOAPseY9QGg05ZxcsTR6', true);

INSERT INTO authorities (username, authority) VALUES ('plainUser', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('managerUser', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('managerUser', 'ROLE_MANAGER');
INSERT INTO authorities (username, authority) VALUES ('adminUser', 'ROLE_USER');
INSERT INTO authorities (username, authority) VALUES ('adminUser', 'ROLE_MANAGER');
INSERT INTO authorities (username, authority) VALUES ('adminUser', 'ROLE_ADMIN');