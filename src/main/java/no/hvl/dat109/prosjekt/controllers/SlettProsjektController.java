package no.hvl.dat109.prosjekt.controllers;


import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class SlettProsjektController {

    @Autowired
    private ProsjektService prosjektService;

    /**
     * Viser skjemaet for sletting av prosjekt.
     * Metoden sjekker først at brukeren er innlogget ved sjekk av HttpSession.
     * Hvis brukeren ikke er logget inn, blir brukeren omdirigert til innloggingen med feilmelding.
     *
     * @param session   Den nåværende {@link HttpSession} som brukes for å verifisere om brukeren er innlogget
     * @param model     {@link Model} objekt som brukes for å sende data til visningen
     * @param ra        {@link RedirectAttributes} som brukes for å sende feilmeldinger over til redirect
     * @return          {@link String} som representerer navnet på visningen som skal hentes.
     */
    @GetMapping("slettprosjekt")
    public String getSlettProsjekt(HttpSession session, Model model, RedirectAttributes ra) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å slette prosjekt");
            return "redirect:login";
        }

        model.addAttribute("prosjekter", prosjektService.finnAlle());

        //Logikk her
        return "slettprosjekt";
    }
}
