package no.hvl.dat109.prosjekt;


import no.hvl.dat109.prosjekt.Utils.PassordUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testklasse for klassen PassordService.
 */

@ExtendWith(MockitoExtension.class)
public class PassordUtilTest {

//    /**
//     * Oppsett
//     */
//    @BeforeEach
//    public void setup() {
//        passordService = new PassordService();
//    }

    /**
     * Testmetode som tester at salt er korrekt lengde og vilkårlig generert.
     */
    @Test
    public void genererTilfeldigSaltTest() {
        String salt = PassordUtil.genererTilfeldigSalt();
        assertEquals(32, salt.length());
        String anotherSalt = PassordUtil.genererTilfeldigSalt();
        assertFalse(salt.equals(anotherSalt));
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

        String salt = PassordUtil.genererTilfeldigSalt();
        String ulikSalt = PassordUtil.genererTilfeldigSalt();

        //Lik pass + lik salt = lik hash
        String hash1 = PassordUtil.hashMedSalt(passord1, salt);
        String hash2 = PassordUtil.hashMedSalt(passord1, salt);
        assertEquals(hash1, hash2);

        //Lik pass + ulik salt = ulik hash
        hash1 = PassordUtil.hashMedSalt(passord1, salt);
        hash2 = PassordUtil.hashMedSalt(passord1, ulikSalt);
        assertNotEquals(hash1, hash2);

        //Ulik pass + whatever = ulik hash
        hash1 = PassordUtil.hashMedSalt(passord1, salt);
        hash2 = PassordUtil.hashMedSalt(passord2, salt);
        assertNotEquals(hash1, hash2);
    }

    /**
     * Tester at erKorrektPassord returnerer korrekt svar ved riktig passord
     */
    @Test
    public void erKorrektPassordTest() {
    	//TODO
    	
//        String forsoktPassord = "passord1";
//
//        Passord riktigPassord = passordService.krypterPassord("passord1");
//
//        assertTrue(passordService.erKorrektPassord(forsoktPassord, riktigPassord));
    }

    /**
     * Tester at erKorrektPassord returnerer korrekt svar ved feil passord
     */
    @Test
    public void erFeilPassordTest() {
    	//TODO
    	
//        String forsoktPassord = "feilPassord";
//
//        Passord riktigPassord = passordService.krypterPassord("passord1");
//
//        assertFalse(passordService.erKorrektPassord(forsoktPassord, riktigPassord));

    }
}
