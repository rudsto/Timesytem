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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class ProsjektController {

    @Autowired
    private ProsjektService prosjektService;

    @GetMapping("opprettprosjekt")
    public String getOpprettProsjekt(HttpSession session, Model model, RedirectAttributes ra) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å opprette prosjekt");
            return "redirect:login";
        }

        //Logikk her
        return "opprettprosjekt";
    }

    @PostMapping("opprettprosjekt")
    public String postProsjekt (@Valid @ModelAttribute("prosjekt") Prosjekt prosjekt,
                                RedirectAttributes ra,
                                BindingResult bindingResult
            ) {

        if (prosjekt.getId().isEmpty()) {
            bindingResult.rejectValue("prosjektid", "NotEmpty", "Prosjektid kan ikke være tom");
        }

        //TODO lage en sjekk for prosjektnavn

        ra.addFlashAttribute("prosjekt", prosjekt);
        if (bindingResult.hasErrors()) {
            String feilmeldinger = bindingResult.getAllErrors()
                    .stream()
                    .map(e -> e.getDefaultMessage())
                    .reduce("", (f,e) -> f + e + "<br>");
            ra.addFlashAttribute("feilmeldinger", feilmeldinger);
            return "redirect:opprettprosjekt";
        }
        if (prosjektService.finnMedID(prosjekt.getId()) != null) {
            ra.addFlashAttribute("feilmeldinger", "Prosjektid er allerede registrert");
            return "redirect:opprettprosjekt";
        }
        prosjektService.lagre(prosjekt);
        return "redirect:prosjektopprettet";
    }

    @GetMapping("prosjektopprettet")
    public String getProsjekt(Model model) {
        return "prosjektopprettet";
    }

}
