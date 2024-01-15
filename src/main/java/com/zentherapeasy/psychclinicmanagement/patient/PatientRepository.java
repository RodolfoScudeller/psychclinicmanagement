package com.zentherapeasy.psychclinicmanagement.patient;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findAllByActiveTrue(Pageable pagination);
    Patient getPatientsByCpfAndActive(String cpf, Boolean active);
}
