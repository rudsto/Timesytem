package no.hvl.dat109.prosjekt.Utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import no.hvl.dat109.prosjekt.entity.Bruker;

/**
 * Serviceklasse for login.
 */
public class LoginUtil {

	public static final int MAX_INACTIVE_INTERVAL = 10 * 60;
	
	/**
	 * Navnet som bruker attribute blir lagret under i httpsession.
	 */
	private static final String BRUKER_ATTRIBUTE_NAVN = "bruker";

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
		loggUtBruker(request.getSession()); // ?? why
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(MAX_INACTIVE_INTERVAL);
		session.setAttribute(BRUKER_ATTRIBUTE_NAVN , bruker);
	}

	/**
	 * Sjekker om en bruker er innlogget.
	 * @param session
	 * @return
	 */
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute(BRUKER_ATTRIBUTE_NAVN) != null;
	}
	
	/**
	 * Henter objectet til den innloggede brukeren fra httpsession.
	 * @param session
	 * @return bruker innlogget in session, null om ingen bruker er innlogget
	 */
	public static Bruker getInnloggetBruker(HttpSession session) {
		if(!erBrukerInnlogget(session)) {
			return null;
		}
		
		Object bruker = session.getAttribute(BRUKER_ATTRIBUTE_NAVN);
		
		if(bruker instanceof Bruker) {
			return (Bruker) bruker;
		}
		
		return null;
	}

}
