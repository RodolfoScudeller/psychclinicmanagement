package com.zentherapeasy.psychclinicmanagement.patient;

public record PatientListingData(String cpf, String name, String email, String telephone, String health_insurance) {
    public PatientListingData(Patient patient){
        this(patient.getCpf(), patient.getName(), patient.getEmail(), patient.getTelephone(), patient.getHealth_insurance());
    }
}
