DROP SCHEMA IF EXISTS DAT109_PROSJEKT CASCADE;
CREATE SCHEMA DAT109_PROSJEKT;
SET search_path TO DAT109_PROSJEKT;

-- Opprett bruker table --------------------------------------------
CREATE TABLE bruker
(
    mobil     CHARACTER(8) PRIMARY KEY,
    hash      CHARACTER(64) NOT NULL,
    salt      CHARACTER(32) NOT NULL,
    fornavn   CHARACTER VARYING(40),
    etternavn CHARACTER VARYING(40)
);

select * from dat109_prosjekt.bruker;

-- Opprett prosjekt table ------------------------------------------
CREATE TABLE prosjekt
(
    id     CHARACTER(6) PRIMARY KEY,
    navn      CHARACTER(64) NOT NULL
);

select * from dat109_prosjekt.prosjekt;

-- Tilgang bruk database ------------------------------------------
GRANT USAGE ON SCHEMA dat109_prosjekt TO hstudentnummer;
GRANT SELECT ON dat109_prosjekt.bruker TO PUBLIC;
GRANT SELECT ON dat109_prosjekt.prosjekt TO PUBLIC;