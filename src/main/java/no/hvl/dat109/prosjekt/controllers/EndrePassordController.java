package no.hvl.dat109.prosjekt.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.Utils.PassordUtil;
import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.service.BrukerService;

@Controller
public class EndrePassordController {

	public static final String REDIRECT_FEILMELDING_NAVN = "endrePassordFeilmelding";
	
	@Autowired
	private BrukerService brukerService;
	
	/**
	 * Sjekker om bruker er innlogget og returnerer "endrepassord"
	 * 
	 * @param ra
	 * @param request
	 * @return
	 */
	@GetMapping("endrepassord")
	public String getEndrePassord(RedirectAttributes ra, HttpServletRequest request) {
		if(!LoginUtil.erBrukerInnlogget(request.getSession())) {
			ra.addFlashAttribute("feilmelding", "Du må være logget inn for å endre passord.");
			
			return "redirect:login";
		}
		
		return "endrepassord";
	}
	
	/**
	 * Forsøker å endre passord for innlogget bruker.
	 * Validerer gammelt og nytt passord.
	 * Redirecter så videre til endrepassord_suksess.
	 * Ved invalid brukerinput vil det redirectes tilbake til samme side med feilmelding.
	 * 
	 * @param gammeltpassord - tidligere passord som skal byttes
	 * @param nyttpassord - ønsket nytt passord
	 * @param gjentattnyttpassord - gjentatt ønsket nytt passord
	 * @param ra
	 * @param request
	 * @return redirect til endrepassord_suksess
	 */
	@PostMapping("endrepassord")
	public String postEndrePassord(
			@RequestParam String gammeltpassord,
			@RequestParam String nyttpassord,
            @RequestParam String gjentattnyttpassord,
            RedirectAttributes ra,
            HttpServletRequest request) {
		
		Bruker innlogget = LoginUtil.getInnloggetBruker(request.getSession());
		Bruker bruker = brukerService.finnBrukerMedMobil(innlogget.getMobil());
		
		if(gammeltpassord == null || nyttpassord == null || gjentattnyttpassord == null) {
			return redirectMedFeilmelding(ra, "Alle felt må fylles inn");
		}
		if(!PassordUtil.erKorrektPassord(gammeltpassord, bruker.getSalt(), bruker.getHash())) {
			return redirectMedFeilmelding(ra, "Gammelt passord er feil.");
		}
		if(nyttpassord.length() < 5) {
			return redirectMedFeilmelding(ra, "Passordet må være minst 5 tegn");
		}
		if(!nyttpassord.equals(gjentattnyttpassord)) {
			return redirectMedFeilmelding(ra, "Gjentatt nytt passord er ikke likt.");
		}
		
		String salt = PassordUtil.genererTilfeldigSalt();
		String hash = PassordUtil.hashMedSalt(nyttpassord, salt);
		
		bruker.setSalt(salt);
		bruker.setHash(hash);
		
		bruker = brukerService.lagreBruker(bruker);
		
		LoginUtil.loggInnBruker(request, bruker);
		
		return "redirect:endrepassord_suksess";
	}
	
	/**
	 * Hjelpemetode til postEndrePassord().
	 * Legger til feilmelding som redirect attribute og returnerer samme side.
	 * 
	 * @param ra
	 * @param feilmelding
	 * @return redirect til endrepassord igjen
	 */
	private static String redirectMedFeilmelding(RedirectAttributes ra, String feilmelding) {
		ra.addFlashAttribute(REDIRECT_FEILMELDING_NAVN, feilmelding);
		
		return "redirect:endrepassord";
	}
	
	/**
	 * @return "endrepassord"
	 */
	@GetMapping("endrepassord_suksess") 
	public String getEndrePassordSuksess() {
		return "endrepassord_suksess";
	}
	
	/**
	 * @return redirect til deltagerliste
	 */
	@PostMapping("endrepassord_suksess") 
	public String postEndrePassordSuksess() {
		return "redirect:deltagerliste";
	}
	
}
