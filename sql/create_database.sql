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

-- Opprett prosjekt table ------------------------------------------
CREATE TABLE prosjekt
(
    prosjekt_id     CHARACTER(6) PRIMARY KEY,
    navn      		CHARACTER(64) NOT NULL
);

CREATE TABLE timereg
(
	time_id 			SERIAL PRIMARY KEY,
	antall_timer		INTEGER,
	mobil				CHARACTER(8),
	prosjekt_id			CHARACTER(6),
	FOREIGN KEY (mobil) REFERENCES bruker (mobil),
	FOREIGN KEY (prosjekt_id) REFERENCES prosjekt (prosjekt_id)	
);



select * from dat109_prosjekt.prosjekt;

-- Tilgang bruk database ------------------------------------------
GRANT USAGE ON SCHEMA dat109_prosjekt TO hstudentnummer;
GRANT SELECT ON dat109_prosjekt.bruker TO PUBLIC;
GRANT SELECT ON dat109_prosjekt.prosjekt TO PUBLIC;