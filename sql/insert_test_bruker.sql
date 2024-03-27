-- Lager en bruker i databasen brukt til testing.
-- Hash og salt er generert av PassordService med passordet under.
-- Mobil: 12345678
-- Passord: pass

SET search_path TO DAT109_PROSJEKT;

INSERT INTO bruker(mobil, fornavn, etternavn, hash, salt)
VALUES (
	'12345678', 
	'Ole', 
	'Testperson', 
	'1FEE1E38EDD27C387C62DA63CCC5719E9BE5FF953BFEC644603686685ABA0CA6', 
	'755E8932348D2301B70BF90779B0BC4C'
);