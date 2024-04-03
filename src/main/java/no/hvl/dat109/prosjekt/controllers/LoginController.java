package no.hvl.dat109.prosjekt.controllers;

import jakarta.servlet.http.HttpServletRequest;

import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.service.BrukerService;
import no.hvl.dat109.prosjekt.service.LoginService;
import no.hvl.dat109.prosjekt.service.PassordService;
import no.hvl.dat109.prosjekt.service.SystemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private BrukerService brukerService;
    @Autowired
    PassordService passordService;

    @GetMapping("/")
    public String getIndex() {
        return "redirect:login";
    }

    @GetMapping("login")
    public String getLogin(Model model) {
        return "innlogging";
    }

    @PostMapping("login")
    public String postLogin(RedirectAttributes ra, HttpServletRequest request, @RequestParam String passord, @RequestParam String mobil) {

        if (LoginService.erBrukerInnlogget(request.getSession())) {
            return "redirect:deltagerliste";
        }

        System.out.println("mobil: " + mobil);
        System.out.println("passord: " + passord);

        Bruker bruker = brukerService.finnBrukerMedMobil(mobil);

        if (bruker == null) {
            ra.addFlashAttribute("feilmelding", "Finner ikke bruker med dette mobilnummeret");
            ra.addFlashAttribute("mobil", mobil);
            return "redirect:login";
        }

        if (!passordService.erKorrektPassord(passord, bruker.getSalt(), bruker.getHash())) {
            ra.addFlashAttribute("feilmelding", "Passord er feil");
            ra.addFlashAttribute("mobil", mobil);
            return "redirect:login";
        }

        LoginService.loggInnBruker(request, bruker);

        return "redirect:deltagerliste";
    }

    @PostMapping("logut")
    public String postUtlogging(RedirectAttributes ra, HttpServletRequest request) {
        LoginService.loggUtBruker(request.getSession());
        ra.addFlashAttribute("feilmelding", "Du er nå logget ut");
        return "redirect:login";
    }
}
