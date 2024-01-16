package com.zentherapeasy.psychclinicmanagement.psychologist;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PsychologistRepository extends JpaRepository<Psychologist, Long> {
    Page<Psychologist> findAllByActiveTrue(Pageable pagination);
    Psychologist findPsychologistByCrpAndActive(String crp, Boolean active);
    Optional<Psychologist> findByCrpAndActive(String crp, Boolean active);
}
