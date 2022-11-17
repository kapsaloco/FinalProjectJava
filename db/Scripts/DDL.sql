CREATE DATABASE db_person with template = template0 ENCODING 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';

create extension pgcrypto;

create table Person (
	id uuid primary key default gen_random_uuid(),
	firstName varchar(25) null,
	lastName varchar(25) text null,
	phoneNumber varchar(20) null,
	email varchar(25) null
);