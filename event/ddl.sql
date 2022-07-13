CREATE DATABASE event-service
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;

CREATE SCHEMA event
    AUTHORIZATION postgres;

CREATE TABLE event.film
(
    dt_create timestamp without time zone,
    dt_update timestamp without time zone,
    uuid uuid,
    title character varying NOT NULL,
    description character varying NOT NULL,
    dt_event timestamp without time zone NOT NULL,
    dt_end_of_sale timestamp with time zone NOT NULL,
    type character varying NOT NULL,
    status character varying NOT NULL,
    release_year bigint NOT NULL,
    release_date timestamp without time zone NOT NULL,
    duration bigint NOT NULL,
    CONSTRAINT uuid PRIMARY KEY (uuid)
        INCLUDE(uuid),
    CONSTRAINT uuid_f UNIQUE (uuid)

);

ALTER TABLE IF EXISTS event.event
    OWNER to postgres;