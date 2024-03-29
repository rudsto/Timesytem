package no.hvl.dat109.prosjekt.bruker;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import jakarta.xml.bind.DatatypeConverter;

@Service
public class PassordService {


	/**
	 * Krypterer gitt streng til hash med et tilfeldig generert salt.
	 * 
	 * @param passord - strengen som skal krypteres
	 * @return the resulting hash and salt
	 */
	public Passord krypterPassord(String passord) {
		String salt = genererTilfeldigSalt();
		String hash = hashMedSalt(passord, salt);
		
		return new Passord(hash, salt);
	}
	
	/**
	 * @return et tilfedlig generert 16 byte salt ved bruk av SHA1PRNG
	 */
	public String genererTilfeldigSalt() {
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
	 * Genererer et kryptigrafisk hash for gitt passord og salt.
	 * 
	 * Algoritmen brukt er PBKDF2WithHmacSHA1
	 * 	- PBKDF2: Password-Based-Key-Derivation-Function
	 *  - WithHmac: HMAC står for Keyed-Hash Message Authentication Code
	 *  - SHA1: SHA1 hashing-algoritme
	 * 
	 * Itereres 1000 ganger.
	 * Output fra denne algoritmen er 256 bits(32 bytes).
	 * 
	 * Se https://en.wikipedia.org/wiki/PBKDF2 for mer info.
	 * 
	 * I slutten er byte-arraye is konvertert til en HEX-streng med 
	 * 64 karakterer/siffer.
	 *  
	 * @param passord
	 * @param salt
	 * @return en 64 karakter lang HEX-streng som representerer et 
	 * 32 byte/256 bit hash.
	 */
	public String hashMedSalt(String password, String salt) {
		if (password == null || salt == null) { // should validate properly!!
			throw new IllegalArgumentException();
		}
		
		char[] passchar = password.toCharArray();
		byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
		byte[] keyhash = null;
		
		try {
			PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			
			keyhash = skf.generateSecret(pks).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return DatatypeConverter.printHexBinary(keyhash);
	}
	
	/**
	 * Sjekker om passord matcher et hash generated with korresponderende
	 * hashMedSalt().
	 * 
	 * @param forsoktPassword - passordstrengen å sjekke
	 * @param riktigPassord - hash og salt generert til riktig passord
	 * @return true hvis passord matcher
	 */
	public boolean erKorrektPassord(String forsoktPassord, Passord riktigPassord) {
		String hash = riktigPassord.getHash();
		String salt = riktigPassord.getSalt();
		
		if (forsoktPassord == null || salt == null || hash == null) {  // should validate properly!!
			throw new IllegalArgumentException();
		}
		
		return hash.equals(hashMedSalt(forsoktPassord, salt));
	}
	
}
