DROP SCHEMA IF EXISTS DAT109_PROSJEKT CASCADE;
CREATE SCHEMA DAT109_PROSJEKT;
SET search_path TO DAT109_PROSJEKT;

CREATE TABLE bruker
(
    mobil     CHARACTER(8) PRIMARY KEY,
    fornavn   CHARACTER VARYING(40),
    etternavn CHARACTER VARYING(40)
    hash      CHARACTER(64) NOT NULL,
    salt      CHARACTER(32) NOT NULL,
);