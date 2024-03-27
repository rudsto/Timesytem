package no.hvl.dat109.prosjekt.bruker.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import no.hvl.dat109.prosjekt.bruker.Bruker;
import no.hvl.dat109.prosjekt.bruker.BrukerService;
import no.hvl.dat109.prosjekt.bruker.Passord;
import no.hvl.dat109.prosjekt.bruker.PassordService;

@Controller
@RequestMapping("/")
public class LoginController {

	@Autowired
	private BrukerService brukerService;
	
	@Autowired 
	private PassordService passordService;
	
	/**
	 * @param request
	 * @return index-side eller redirect til login om ingen bruker er pålogget.
	 */
	@GetMapping
	public String getIndex(HttpServletRequest request) {
		if(!LoginUtil.erLoggetIn(request.getSession())) {
			return "redirect:login";
		}
		
		return "index";
	}
	
	/**
	 * @param request
	 * @return login-side
	 */
	@GetMapping("login")
	public String getLogin(HttpServletRequest request) { 
		return "login";
	}
	
	/**
	 * Mottar login-informasjon fra siden og forsøker å logge bruker inn.
	 * 
	 * Returnerer redirect til index ved lykket innlogging. Ved feil mobil 
	 * eller passord returneres redirect til samme side med feilmelding.
	 * 
	 * @param input - input fra bruker med login-info
	 * @param request - informasjon om requesten sendt fra klient
	 * @param ra - redirect attributes
	 * @return redirect til index eller redirect tilbake med feilmelding
	 */
	@PostMapping("login")
	public String postLogin(
			@ModelAttribute("login") @Valid LoginSkjema input,
			HttpServletRequest request,	
			RedirectAttributes ra) {
		
		Bruker bruker = brukerService.finnMedMobil(input.getMobil());
		
		if(bruker == null) {
			return visLoginMelding(ra, "Finner ikke bruker med gitt mobil.");
		}
		
		String forsoktPassord = input.getPassord();
		Passord riktigPassord = bruker.getPassord();
		
		if(!passordService.erKorrektPassord(forsoktPassord, riktigPassord)) {
			return visLoginMelding(ra, "Passord er feil.");
		}
		
		LoginUtil.logInnBruker(request, bruker);
		
		return "redirect:";
	}
	
	/**
	 * Logger bruker ut av session og redirecter til login-siden.
	 * 
	 * @param session
	 * @param ra
	 * @return redirect til loginside
	 */
	@PostMapping("logout")
	public String postLogout(HttpSession session, RedirectAttributes ra) {
		LoginUtil.logUtBruker(session);
		
		return visLoginMelding(ra, "Du er logget ut.");
	}
	
	/**
	 * Blir brukt av metoden postLogin(...) ved feilet innlogging.
	 * 
	 * Legger til melding som redirect attribute, og returnerer redirect til
	 * login-siden hvor meldingen blir vist.
	 * 
	 * @param ra - redirect attributes
	 * @param melding - som skal vises på login-siden
	 * @return redirect til loginsiden
	 */
	private static String visLoginMelding(RedirectAttributes ra, String melding) {
		ra.addFlashAttribute("loginMelding", melding);

		return "redirect:login";
	}
	
}
