CREATE DATABASE user
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE SCHEMA user_service
    AUTHORIZATION postgres;

CREATE TABLE user_service.user_information
(
    dt_create time(3) without time zone NOT NULL,
    dt_update time(3) without time zone NOT NULL,
    uuid uuid NOT NULL,
    mail character varying NOT NULL,
    nick character varying NOT NULL,
    role character varying NOT NULL,
    status character varying NOT NULL,
    password character varying NOT NULL,
    PRIMARY KEY (uuid),
    CONSTRAINT uuid UNIQUE (uuid)
    CONSTRAINT mail UNIQUE (mail)

);

ALTER TABLE IF EXISTS user_service.users
    OWNER to postgres;

CREATE TABLE users_service.authorities
(
    mail character varying,
    authority character varying
);

ALTER TABLE IF EXISTS users_service.authorities
    OWNER to postgres;

CREATE TABLE users_service.users
(
    mail character varying NOT NULL,
    password character varying,
    enabled boolean,
    CONSTRAINT mail_pk PRIMARY KEY (mail)
);

ALTER TABLE IF EXISTS users_service.users
    OWNER to postgres;