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
	
	@GetMapping
	public String getLogin() {
		return "login";
	}
	
	@PostMapping
	public String mottaLogin(
			@ModelAttribute("login") @Valid LoginSkjema input,
			HttpServletRequest request,	
			RedirectAttributes ra) {
		
		Bruker bruker = brukerService.getBrukerMedMobil(input.getMobil());
		
		if(bruker == null) {
			return visMelding(ra, "Finner ikke bruker med gitt mobil.");
		}
		if(!passordService.erKorrektPassord(input.getPassord(), bruker.getPassord())) {
			return visMelding(ra, "Passord er feil.");
		}
		
		LoginUtil.logInBruker(request, bruker);
		
		return "redirect:login_suksess"; //TODO endre til riktig endepunkt
	}
	
	private String visMelding(RedirectAttributes ra, String melding) {
		ra.addFlashAttribute("loginMelding", melding);

		return "redirect:login";
	}
	
}
