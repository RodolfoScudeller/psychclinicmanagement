package com.zentherapeasy.psychclinicmanagement.controller;

import com.zentherapeasy.psychclinicmanagement.employees.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeesController {
    @Autowired
    private EmployeesRepository repository;

    @PostMapping
    public void registration (@RequestBody @Valid EmployeesRegistrationData data){
        System.out.println(data);
        repository.save(new Employees(data));
    }

    @GetMapping
    public Page<EmployeesListingData> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(EmployeesListingData::new);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<EmployeesListingData> findOnePatient(@PathVariable String cpf){
        var patient = repository.getEmployeesByCpfAndActive(cpf, true);

        if(patient != null){
            EmployeesListingData employeesListingData = new EmployeesListingData(patient);
            return ResponseEntity.ok(employeesListingData);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid EmployeesUpdateData data){
        var patient = repository.getEmployeesByCpfAndActive(data.cpf(), true);
        patient.update(data);
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity delete(@PathVariable String cpf){
        var patient = repository.getEmployeesByCpfAndActive(cpf, true);

        patient.delete();

        return ResponseEntity.noContent().build();
    }
}
