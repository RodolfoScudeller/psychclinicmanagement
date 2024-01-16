package com.zentherapeasy.psychclinicmanagement.controller;

import com.zentherapeasy.psychclinicmanagement.psychologist.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/psychologist")
public class PsychologistController {
    @Autowired
    private PsychologistRepository repository;

    @GetMapping
    public Page<PsychologistListingData> list(@PageableDefault(size = 10, sort = {"name"})Pageable pageable){
        return repository.findAllByActiveTrue(pageable).map(PsychologistListingData::new);
    }

    @GetMapping("/{crp}")
    public ResponseEntity<PsychologistListingData> findOnePsychologist(@PathVariable String crp){
        var psychologist = repository.findPsychologistByCrpAndActive(crp, true);

        if(psychologist != null){
            PsychologistListingData psychologistListingData = new PsychologistListingData(psychologist);
            return ResponseEntity.ok(psychologistListingData);
        }else{
            return ResponseEntity.notFound().build();
        }

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

    @DeleteMapping("/{crm}")
    @Transactional
    public ResponseEntity delete(@PathVariable String crp){
        var psychologist = repository.findPsychologistByCrpAndActive(crp, true);

        psychologist.delete();

        return ResponseEntity.noContent().build();
    }
}
