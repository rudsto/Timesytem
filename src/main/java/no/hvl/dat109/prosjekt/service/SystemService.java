package no.hvl.dat109.prosjekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;

import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.repo.BrukerRepo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class SystemService {

//    @Autowired
//    private BrukerRepo brukerRepo;
//
//    private static final int MAX_INTERACTIVE_INTERVAL = 10 * 60;
//
//
//    public List<Bruker> finnAlleBrukere() {
//        return brukerRepo.findAll();
//    }
//
//    public Bruker finnBrukerMedMobil(String mobil) {
//        return brukerRepo.findByMobil(mobil);
//    }
//
//    public Bruker lagreBruker(Bruker bruker) {
//        return brukerRepo.save(bruker);
//    }
//
//    public String genererTilfeldigSalt() {
//        SecureRandom sr;
//        byte[] salt = new byte[16];
//        try {
//            sr = SecureRandom.getInstance("SHA1PRNG");
//            sr.nextBytes(salt);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        return DatatypeConverter.printHexBinary(salt);
//    }
//
//    public String hashMedSalt(String passord, String salt) {
//
//        if (passord == null || salt == null) { // Burde validert skikkelig!!
//            throw new IllegalArgumentException();
//        }
//
//        char[] passchar = passord.toCharArray();
//        byte[] saltbytes = DatatypeConverter.parseHexBinary(salt);
//
//        byte[] keyhash = null;
//        try {
//            PBEKeySpec pks = new PBEKeySpec(passchar, saltbytes, 1000, 256);
//            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//            keyhash = skf.generateSecret(pks)
//                    .getEncoded();
//
//        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
//            e.printStackTrace();
//        }
//        return DatatypeConverter.printHexBinary(keyhash);
//    }
//
//    public boolean validering(String mobil, String passord) {
//        Bruker bruker = finnBrukerMedMobil(mobil);
//        return erKorrektPassord(passord, bruker.getSalt(), bruker.getHash()) && bruker != null;
//    }
//
//    public boolean erKorrektPassord(String passord, String salt, String hash) {
//
//        if (passord == null || salt == null || hash == null) {
//            throw new IllegalArgumentException();
//        }
//        return hash.equals(hashMedSalt(passord, salt));
//    }
//
//    public static void loggUtBruker(HttpSession session) {
//        session.invalidate();
//    }
//
//    public static void loggInnBruker2(HttpServletRequest request, Bruker bruker) {
//        loggUtBruker(request.getSession());
//        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(MAX_INTERACTIVE_INTERVAL);
//        session.setAttribute("bruker", bruker);
//    }
//
//    public static boolean erBrukerInnlogget(HttpSession session) {
//        return session != null && session.getAttribute("bruker") != null;
//    }
//

}
