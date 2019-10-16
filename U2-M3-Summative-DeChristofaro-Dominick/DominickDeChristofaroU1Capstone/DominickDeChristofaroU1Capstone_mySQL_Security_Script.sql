use game_store;

create table if not exists users(
	username varchar(50) not null primary key,
	password varchar(100) not null,
	enabled boolean not null
);

create table if not exists authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username));
	create unique index ix_auth_username on authorities (username,authority
);

insert into users (username, password, enabled) values ('staff', '$2a$10$LhmejKn91Yq7A/8Cj/MMV..mbwi.bXJAwK90i9ciSEuM5dEcS1QPu', true);
insert into users (username, password, enabled) values ('manager', '$2a$10$LhmejKn91Yq7A/8Cj/MMV..mbwi.bXJAwK90i9ciSEuM5dEcS1QPu', true);
insert into users (username, password, enabled) values ('admin', '$2a$10$LhmejKn91Yq7A/8Cj/MMV..mbwi.bXJAwK90i9ciSEuM5dEcS1QPu', true);

insert into authorities (username, authority) values ('staff', 'ROLE_STAFF');
insert into authorities (username, authority) values ('manager', 'ROLE_STAFF');
insert into authorities (username, authority) values ('manager', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('admin', 'ROLE_STAFF');
insert into authorities (username, authority) values ('admin', 'ROLE_MANAGER');
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');