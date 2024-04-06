package no.hvl.dat109.prosjekt.controllers;

import javax.servlet.http.HttpSession;

import no.hvl.dat109.prosjekt.service.BrukerService;
import no.hvl.dat109.prosjekt.Utils.LoginUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BrukerController {

    @Autowired
    private BrukerService brukerService;


    @GetMapping("deltagerliste")
    public String getDeltagerListe(HttpSession session, Model model, RedirectAttributes ra) {
        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være logget inn for å se deltagerlisten");
            return "redirect:login";
        }
        model.addAttribute("ansatte", brukerService.finnAlleBrukere());
        return "deltagerliste";
    }

}
