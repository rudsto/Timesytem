package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProsjektController {

    @Autowired
    private ProsjektService prosjektService;

    /**
     * Metode for å hente skjema for innfylling av nytt prosjekt.
     * @param session brukes for å sørge for at brukeren har en gyldig sesjon.
     * @param model
     * @param ra
     * @return {@link String} som sender brukeren til relevant side
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
     * PostMapping som hånterer de inntastede prosjektfeltene og forsøker å opprette et prosjekt.
     * @param prosjekt_id {@link String} med prosjektets id
     * @param navn {@link String} med prosjekets navn
     * @return redirect
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
     * Sender bruker videre til prosjekt opprettet
     * @param model
     * @return
     */
    @GetMapping("prosjektopprettet")
    public String getProsjekt(Model model) {
        return "prosjektopprettet";
    }

}
