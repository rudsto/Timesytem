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
    public String postProsjekt (@RequestParam String prosjekt_id,@RequestParam String navn) {
        Prosjekt prosjekt = new Prosjekt();
        prosjekt.setProsjekt_id(prosjekt_id);
        prosjekt.setNavn(navn);
        prosjektService.lagre(prosjekt);
        return "redirect:prosjektopprettet";
    }

    @GetMapping("prosjektopprettet")
    public String getProsjekt(Model model) {
        return "prosjektopprettet";
    }

}
