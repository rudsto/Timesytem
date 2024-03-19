package no.hvl.dat109.prosjekt.controllers;

import no.hvl.dat109.prosjekt.entities.Employee;
import no.hvl.dat109.prosjekt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestController {


    @Autowired
    EmployeeService employeeService;

    @GetMapping("/test")
    public String hello(
            Model model
    ){
        List<Employee> emps = employeeService.findAll();
        model.addAttribute("emps", emps);
        return "home";
    }
}
