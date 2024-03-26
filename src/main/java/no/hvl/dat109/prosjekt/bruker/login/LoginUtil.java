package no.hvl.dat109.prosjekt.bruker.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat109.prosjekt.bruker.Bruker;

public class LoginUtil {

	private static final String USER_ATTRIBUTE_NAME = "bruker";

	public static void logUtBruker(HttpSession session) {
		session.invalidate();
	}
	
	public static void logInnBruker(HttpServletRequest request, Bruker bruker) {
		request.getSession().setAttribute(USER_ATTRIBUTE_NAME, bruker);
	}
	
	public static boolean erLoggetIn(HttpSession session) {
		return session.getAttribute(USER_ATTRIBUTE_NAME) != null;
	}
	
}
