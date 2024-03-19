package no.hvl.dat109.prosjekt.service;

import no.hvl.dat109.prosjekt.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired EmployeeRepo employeeRepo;

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }

}
