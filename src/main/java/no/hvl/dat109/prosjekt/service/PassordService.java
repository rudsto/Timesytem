package no.hvl.dat109.prosjekt.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpSession;
import jakarta.xml.bind.DatatypeConverter;

@Service
public class PassordService {
	
	//TODO
	
	public String genererTilfeldigSalt() {
		//TODO
		return null;
	}
	
	public String hashMedSalt(String passord, String salt) {
		//TODO
		return null;
	}
	
	public boolean erKorrektPassord(String passord, String salt, String hash) {
		//TODO
		return false;
	}

}
