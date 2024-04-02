package no.hvl.dat109.prosjekt.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat109.prosjekt.entity.Bruker;

@Service
public class LoginService {
	
	//TODO
	
	public static void loggInnBruker(HttpServletRequest request, Bruker bruker) {
		//TODO
	}
	
	public static void loggUtBruker(HttpSession session) {
		//TODO
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		//TODO
		return false;
	}

}
