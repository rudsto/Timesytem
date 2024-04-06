package no.hvl.dat109.prosjekt.controllers;

import jakarta.servlet.http.HttpServletRequest;

import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.service.BrukerService;
import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.Utils.PassordUtil;

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

    /**
     * @return redirect til login-siden.
     */
    @GetMapping("/")
    public String getIndex() {

        return "redirect:login";
    }

    /**
     * @param model
     * @return login jsp mapping
     */
    @GetMapping("login")
    public String getLogin(Model model) {
        return "innlogging";
    }

    /**
     * Forsøker å logge bruker inn med bruker-input. Redirecter videre ved lykket innlogging. Ved ugyldig
     * innlogging vil det returneres redirect til samme side med en feilmelding.
     * @param ra
     * @param request
     * @param passord - forsøkt passord gitt fra bryker
     * @param mobil - forsøkt mobil gitt fra bruker
     * @return redirect til neste side eller til samme side med feilmelding
     */
    @PostMapping("login")
    public String postLogin(RedirectAttributes ra, HttpServletRequest request, @RequestParam String passord, @RequestParam String mobil) {

        if (LoginUtil.erBrukerInnlogget(request.getSession())) {
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

        if (!PassordUtil.erKorrektPassord(passord, bruker.getSalt(), bruker.getHash())) {
            ra.addFlashAttribute("feilmelding", "Passord er feil");
            ra.addFlashAttribute("mobil", mobil);
            return "redirect:login";
        }

        LoginUtil.loggInnBruker(request, bruker);

        return "redirect:deltagerliste";
    }

    /**
     * Logger bruker ut og returnerer til login siden.
     * @param ra - redirect attributes
     * @param request - http requesten
     * @return redirect til login siden.
     */
    @PostMapping("logut")
    public String postUtlogging(RedirectAttributes ra, HttpServletRequest request) {
        LoginUtil.loggUtBruker(request.getSession());
        ra.addFlashAttribute("feilmelding", "Du er nå logget ut");
        return "redirect:login";
    }
}
