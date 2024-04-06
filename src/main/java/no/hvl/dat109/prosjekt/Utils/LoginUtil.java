package no.hvl.dat109.prosjekt.Utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat109.prosjekt.entity.Bruker;

/**
 * Serviceklasse for login.
 */
public class LoginUtil {

	public static final int MAX_INACTIVE_INTERVAL = 10 * 60;

	/**
	 * Logger ut en bruker.
	 * @param session
	 */
	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}

	/**
	 * Logger inn en bruker.
	 * @param request
	 * @param bruker
	 */
	public static void loggInnBruker(HttpServletRequest request, Bruker bruker) {
		loggUtBruker(request.getSession());
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
		session.setAttribute("bruker", bruker);
	}

	/**
	 * Sjekker om en bruker er innlogget.
	 * @param session
	 * @return
	 */
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute("bruker") != null;
	}

}
