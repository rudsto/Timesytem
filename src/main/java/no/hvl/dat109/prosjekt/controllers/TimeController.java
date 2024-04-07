package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import no.hvl.dat109.prosjekt.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping("registrertime")
    public String getRegistrerTime(HttpSession session, Model model, RedirectAttributes ra) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å registrere timer");
            return "redirect:login";
        }

        //Logikk her
        return "registrertime";
    }

    @PostMapping("/registrertime")
    public String registrerTimer(HttpSession session, Model model, RedirectAttributes ra) {
        if(!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å registrere timer");
            return "redirect:login";
        }

        //Logikk her
        return "registrertime";
    }
}
