package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.entity.Time;
import no.hvl.dat109.prosjekt.service.ProsjektService;
import no.hvl.dat109.prosjekt.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RedigerTimeController {

    @Autowired
    TimeService timeService;

    @Autowired
    ProsjektService prosjektService;

    @GetMapping("redigertime")
    public String redigertime(Model model) {
        return null;
    }

    @PostMapping("redigertime")
    public String redigertime(@ModelAttribute("time") Time time, Model model) {
        return null;
    }

    @PostMapping("sletttime")
    public String sletttime(@ModelAttribute("time") Time time, Model model) {
        return null;
    }
}
