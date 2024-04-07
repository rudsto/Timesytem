package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.service.ProsjektService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProsjektController {

    @Autowired
    private ProsjektService prosjektService;

}
