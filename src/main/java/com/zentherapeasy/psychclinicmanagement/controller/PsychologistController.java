package com.zentherapeasy.psychclinicmanagement.controller;

import com.zentherapeasy.psychclinicmanagement.psychologist.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/psychologist")
public class PsychologistController {
    @Autowired
    private PsychologistRepository repository;

    @GetMapping
    public Page<PsychologistListingData> list(@PageableDefault(size = 10, sort = {"name"})Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(PsychologistListingData::new);
    }

    @PostMapping
    public void create(@RequestBody @Valid PsychologistRegistrationData data){
        repository.save(new Psychologist(data));
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid PsychologistUpdateData data){
        var psychologist = repository.findPsychologistByCrpAndActive(data.crp(), true);
        psychologist.update(data);
    }
}
