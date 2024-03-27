package no.hvl.dat109.prosjekt.bruker.login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat109.prosjekt.bruker.Bruker;

public class LoginUtil {

	private static final String USER_ATTRIBUTE_NAME = "bruker";

	/**
	 * Invaliderer session slik at innlogget bruker ikke er tilgjengelig
	 * 
	 * @param session
	 */
	public static void logUtBruker(HttpSession session) {
		session.invalidate();
	}
	
	/**
	 * Legger til bruker som en session attribute.
	 * 
	 * @param request
	 * @param bruker
	 */
	public static void logInnBruker(HttpServletRequest request, Bruker bruker) {
		request.getSession().setAttribute(USER_ATTRIBUTE_NAME, bruker);
	}
	
	/**
	 * Sjekker bruker finnes som en session attribute.
	 * 
	 * @param session
	 * @return true hvis bruker er lagt til som session attribute
	 */
	public static boolean erLoggetIn(HttpSession session) {
		return session.getAttribute(USER_ATTRIBUTE_NAME) != null;
	}
	
}
