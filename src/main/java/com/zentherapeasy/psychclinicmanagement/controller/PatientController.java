package com.zentherapeasy.psychclinicmanagement.controller;

import com.zentherapeasy.psychclinicmanagement.patient.Patient;
import com.zentherapeasy.psychclinicmanagement.patient.PatientListingData;
import com.zentherapeasy.psychclinicmanagement.patient.PatientRegistrationData;
import com.zentherapeasy.psychclinicmanagement.patient.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/patient")
public class PatientController {
    @Autowired
    private PatientRepository repository;

    @PostMapping
    public void registration (@RequestBody @Valid PatientRegistrationData data){
        System.out.println(data);
        repository.save(new Patient(data));
    }

    @GetMapping
    public Page<PatientListingData> list(@PageableDefault(size = 10, sort = {"name"})Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(PatientListingData::new);
    }
}
