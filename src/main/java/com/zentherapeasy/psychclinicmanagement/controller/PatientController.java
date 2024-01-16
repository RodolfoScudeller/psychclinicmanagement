package com.zentherapeasy.psychclinicmanagement.controller;

import com.zentherapeasy.psychclinicmanagement.patient.*;
import com.zentherapeasy.psychclinicmanagement.psychologist.PsychologistListingData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("/{cpf}")
    public ResponseEntity<PatientListingData> findOnePatient(@PathVariable String cpf){
        var patient = repository.getPatientsByCpfAndActive(cpf, true);

        if(patient != null){
            PatientListingData patientListingData = new PatientListingData(patient);
            return ResponseEntity.ok(patientListingData);
        }else{
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PatientUpdateData data){
        var patient = repository.getPatientsByCpfAndActive(data.cpf(), true);
        patient.update(data);
    }

    @DeleteMapping("/{cpf}")
    @Transactional
    public ResponseEntity delete(@PathVariable String cpf){
        var patient = repository.getPatientsByCpfAndActive(cpf, true);

        patient.delete();

        return ResponseEntity.noContent().build();
    }
}
