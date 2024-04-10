package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.Utils.LoginUtil;
import no.hvl.dat109.prosjekt.entity.Bruker;
import no.hvl.dat109.prosjekt.entity.Prosjekt;
import no.hvl.dat109.prosjekt.entity.Time;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import no.hvl.dat109.prosjekt.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class RedigerTimeController {

    @Autowired
    TimeService timeService;

    @Autowired
    ProsjektService prosjektService;

    @GetMapping("redigertimer")
    public String getRedigerTimer(HttpSession session, Model model, RedirectAttributes ra) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å registrere timer");
            return "redirect:login";
        }
        Bruker bruker = (Bruker) session.getAttribute("bruker");
        model.addAttribute("prosjekter", prosjektService.finnAlle());

        return "redigertime";
    }

    @PostMapping("velgprosjekt")
    public String postVelgProsjekt(HttpSession session, Model model, RedirectAttributes ra,
                                   @RequestParam String prosjekt_id) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å redigere timer");
            return "redirect:login";
        }
        Bruker bruker = (Bruker) session.getAttribute("bruker");
        Optional<Prosjekt> optionalProsjekt = prosjektService.finnMedID(prosjekt_id);
        Prosjekt prosjekt = optionalProsjekt.orElse(null);
        List<Time> brukerProsjektTimer = timeService.finnBrukerProsjektTimer(bruker, prosjekt);

        if (optionalProsjekt.isEmpty()) {
            ra.addFlashAttribute("feilmelding", "Tast inn et prosjekt fra prosjektoversikten");
            return "redirect:redigertimer";
        }

        model.addAttribute("prosjekt", prosjekt);
        model.addAttribute("timeliste", brukerProsjektTimer);
        ra.addFlashAttribute("timeliste1", brukerProsjektTimer);

        return "redirect:redigertimer";
    }


    @PostMapping("redigertime")
    public String postRedigerTime(HttpSession session, Model model, RedirectAttributes ra,
                                  @RequestParam Integer time_id, @RequestParam int antallTimer) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å redigere timer");
            return "redirect:login";
        }

        Time time = timeService.finnMedId(time_id);
        time.setAntallTimer(antallTimer);

        return "redirect:redigertimer";
    }

    @PostMapping("sletttime")
    public String postSlettTime(HttpSession session, Model model, RedirectAttributes ra,
                                @RequestParam Integer time_id) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("feilmelding", "Du må være innlogget for å redigere timer");
            return "redirect:login";
        }

        timeService.slettTime(time_id);

        return "redirect:redigertimer";
    }
}
