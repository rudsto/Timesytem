package no.hvl.dat109.prosjekt.Utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;

/**
 *Serviceklasse for passord.
 */
public class PassordUtil {

    /**
     * Genererer en tilfeldig salt av 32 hexadesimale tegn.
     * @return hexadesimal salt
     */
    public static String genererTilfeldigSalt() {
        SecureRandom sr;
        byte[] salt = new byte[16];
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
            sr.nextBytes(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return DatatypeConverter.printHexBinary(salt);
    }

    /**
     * Krypterer passord med en tilfeldig salt, 64 hexadesimale tegn.
     * @return hexadesimal hash
     */
    public static String hashMedSalt(String passord, String salt) {

        if (passord == null || salt == null) { // Burde validert skikkelig!!
            throw new IllegalArgumentException();
        }

        char[] passchar = passord.toCharArray();
        byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);

        byte[] keyhash = null;
        try {
            PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            keyhash = skf.generateSecret(pks)
                    .getEncoded();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return DatatypeConverter.printHexBinary(keyhash);
    }

    /**
     * Kontrollerer at oppgitt passord er korrekt.
     * @param passord
     * @param salt
     * @param hash
     * @return
     */
    public static boolean erKorrektPassord(String passord, String salt, String hash) {

        if (passord == null || salt == null || hash == null) {
            throw new IllegalArgumentException();
        }
        return hash.equals(hashMedSalt(passord, salt));
    }

}
