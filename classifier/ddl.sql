CREATE DATABASE classifier
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE SCHEMA classifier
    AUTHORIZATION postgres;

CREATE TABLE classifier.country
(
    dt_create timestamp(3) without time zone,
    dt_update timestamp(3) without time zone,
    uuid uuid,
    title character varying NOT NULL,
    description character varying NOT NULL,
    CONSTRAINT uuid PRIMARY KEY (uuid),
    CONSTRAINT uuid UNIQUE (uuid)
);

CREATE TABLE classifier.category
(
    dt_create timestamp(3) without time zone,
    dt_update timestamp(3) without time zone,
    uuid uuid,
    title character varying NOT NULL,
    CONSTRAINT uuid_p PRIMARY KEY (uuid),
    CONSTRAINT uuid UNIQUE (uuid)
);

ALTER TABLE IF EXISTS classifier.category
    OWNER to postgres;