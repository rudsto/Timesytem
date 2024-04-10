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

    @GetMapping("slettprosjekt")
    public String getSlettProsjekt(HttpSession session, Model model, RedirectAttributes ra) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å opprette prosjekt");
            return "redirect:login";
        }

        model.addAttribute("prosjekter", prosjektService.finnAlle());

        //Logikk her
        return "slettprosjekt";
    }
}
