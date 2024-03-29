package no.hvl.dat109.prosjekt;

import no.hvl.dat109.prosjekt.bruker.Passord;
import no.hvl.dat109.prosjekt.bruker.PassordService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse for klassen PassordService.
 */
@ExtendWith(MockitoExtension.class)
public class PassordServiceTest {


    @Mock
    private PassordService passordService;

    /**
     * Testmetode som tester at salt er korrekt lengde og vilkårlig generert.
     */
    @Test
    public void genererTilfeldigSaltTest() {
        String salt = passordService.genererTilfeldigSalt();
        assertEquals(32, salt.length());
        String anotherSalt = passordService.genererTilfeldigSalt();
        assertTrue(!salt.equals(anotherSalt));
    }

    /**
     * Testmetode som tester tre ulike scenario:
     *      Like passord med lik salt gir lik hash
     *      Like passord med ulik salt gir ulik hash
     *      Ulike passord gir ulik hash uavhengig av salt
     */
    @Test
    public void hashMedSaltTest() {
        String passord1 = "pass1";
        String passord2 = "pass2";

        String salt = passordService.genererTilfeldigSalt();
        String ulikSalt = passordService.genererTilfeldigSalt();

        //Lik pass + lik salt = lik hash
        String hash1 = passordService.hashMedSalt(passord1, salt);
        String hash2 = passordService.hashMedSalt(passord1, salt);
        assertEquals(hash1, hash2);

        //Lik pass + ulik salt = ulik hash
        hash1 = passordService.hashMedSalt(passord1, salt);
        hash2 = passordService.hashMedSalt(passord1, ulikSalt);
        assertNotEquals(hash1, hash2);

        //Ulik pass + whatever = ulik hash
        hash1 = passordService.hashMedSalt(passord1, salt);
        hash2 = passordService.hashMedSalt(passord2, salt);
        assertNotEquals(hash1, hash2);
    }

    /**
     * Tester at erKorrektPassord returnerer korrekt svar ved riktig passord
     */
    @Test
    public void erKorrektPassordTest() {
        String forsoktPassord = "passord1";

        Passord riktigPassord = passordService.krypterPassord("passord1");

        assertTrue(passordService.erKorrektPassord(forsoktPassord, riktigPassord));
    }

    /**
     * Tester at erKorrektPassord returnerer korrekt svar ved feil passord
     */
    @Test
    public void erFeilPassordTest() {
        String forsoktPassord = "feilPassord";

        Passord riktigPassord = passordService.krypterPassord("passord1");

        assertFalse(passordService.erKorrektPassord(forsoktPassord, riktigPassord));

    }
}
