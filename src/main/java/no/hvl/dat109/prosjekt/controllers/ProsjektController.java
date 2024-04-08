package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class ProsjektController {

    @Autowired
    private ProsjektService prosjektService;

    /**
     * Viser skjemaet for opprettelse av et nytt prosjekt.
     * Denne metoden sjekker først om brukeren er innlogget ved å benytte seg av en HttpSession.
     * Hvis brukeren ikke er innlogget, blir brukeren omdirigert til innloggingssiden med en feilmelding.
     * @param session   Den nåværende HttpSession som brukes for å verifisere om brukeren er innlogget.
     * @param model     Model-objektet som brukes for å sende data til visningen.
     * @param ra        RedirectAttributes brukes for å sende feilmeldinger over redirect.
     * @return En {@link String} som representerer navnet på visningen som skal rendres. Dette kan være en omdirigering til innloggingssiden eller navnet på visningen for å opprette et nytt prosjekt.
     */
    @GetMapping("opprettprosjekt")
    public String getOpprettProsjekt(HttpSession session, Model model, RedirectAttributes ra) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å opprette prosjekt");
            return "redirect:login";
        }

        //Logikk her
        return "opprettprosjekt";
    }

    /**
     * Behandler innkomne data fra skjemaet for opprettelse av nytt prosjekt. Metoden oppretter et nytt
     * Prosjekt-objekt basert på innsendte data, lagrer dette objektet ved hjelp av ProsjektService,
     * og omdirigerer til en bekreftelsesside for det nylig opprettede prosjektet.
     *
     * @param prosjekt_id   Den unike identifikatoren for det nye prosjektet.
     * @param navn          Navnet på det nye prosjektet.
     * @param ra            RedirectAttributes-objektet som brukes for å legge til attributter som skal være tilgjengelige etter omdirigeringen.
     * @return En {@link String} som representerer en omdirigering til visningen som bekrefter opprettelsen av det nye prosjektet.
     */
    @PostMapping("opprettprosjekt")
    public String postProsjekt (@RequestParam String prosjekt_id,@RequestParam String navn, RedirectAttributes ra) {

        if(prosjektService.finnMedID(prosjekt_id) != null) {
            ra.addFlashAttribute("feilmeldinger", "ID allerede i bruk");
            return "redirect:opprettprosjekt";
        }

        Prosjekt prosjekt = new Prosjekt();
        prosjekt.setProsjekt_id(prosjekt_id);
        prosjekt.setNavn(navn);
        prosjektService.lagre(prosjekt);

        ra.addFlashAttribute("prosjekt", prosjekt);

        return "redirect:prosjektopprettet";
    }

    /**
     * Viser en bekreftelse på at et nytt prosjekt har blitt opprettet. Denne metoden forutsetter at
     * nødvendig informasjon om det nylig opprettede prosjektet er lagt til i modellen via
     * RedirectAttributes i metoden som håndterer POST-forespørselen for prosjektopprettelsen.
     *
     * @param model Model-objektet som brukes for å sende data om det opprettede prosjektet til visningen.
     * @return En {@link String} som representerer navnet på visningen som skal rendres, viser detaljer om det opprettede prosjektet.
     */
    @GetMapping("prosjektopprettet")
    public String getProsjekt(Model model) {
        return "prosjektopprettet";
    }

}
