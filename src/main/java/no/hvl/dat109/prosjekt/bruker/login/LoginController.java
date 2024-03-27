package no.hvl.dat109.prosjekt.bruker.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import no.hvl.dat109.prosjekt.bruker.Bruker;
import no.hvl.dat109.prosjekt.bruker.BrukerService;
import no.hvl.dat109.prosjekt.bruker.PassordService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private BrukerService brukerService;
	
	@Autowired 
	private PassordService passordService;
	
	/**
	 * @return endepunktet til loginsiden
	 */
	@GetMapping
	public String getLogin() {
		return "login";
	}
	
	/**
	 * Mottar login-informasjon fra siden og forsøker å logge bruker inn.
	 * Returnerer redirect til neste side ved lykket innlogging.
	 * Ved feil mobil eller passord vil det returneres redirect tilbake til 
	 * samme side med feilmedlding.
	 * 
	 * @param input - input fra bruker med login-info
	 * @param request - informasjon om requesten sendt fra klient
	 * @param ra - redirect attributes
	 * @return redirect til innlogget side eller redirect tilbake med feilmelding.
	 */
	@PostMapping
	public String postLogin(
			@ModelAttribute("login") @Valid LoginSkjema input,
			HttpServletRequest request,	
			RedirectAttributes ra) {

		Bruker bruker = brukerService.finnMedMobil(input.getMobil());
		
		if(bruker == null) {
			return visMelding(ra, "Finner ikke bruker med gitt mobil.");
		}
		if(!passordService.erKorrektPassord(input.getPassord(), bruker.getPassord())) {
			return visMelding(ra, "Passord er feil.");
		}
		
		LoginUtil.logInnBruker(request, bruker);
		
		return "redirect:login_suksess"; //TODO endre til riktig endepunkt
	}
	
	/**
	 * Legger til melding som redirect attribute, og returnerer login-siden
	 * hvor meldingen blir vist.
	 * 
	 * @param ra - redirect attributes
	 * @param melding - som skal vises på login-siden
	 * @return redirect til loginsiden
	 */
	private String visMelding(RedirectAttributes ra, String melding) {
		ra.addFlashAttribute("loginMelding", melding);

		return "redirect:login";
	}
	
}
