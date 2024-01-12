package com.zentherapeasy.psychclinicmanagement.psychologist;

public record PsychologistListingData(String crp, String name, String email, String telephone, String health_insurance) {
    public PsychologistListingData(Psychologist psychologist){
        this(psychologist.getCrp(), psychologist.getName(), psychologist.getEmail(), psychologist.getTelephone(), psychologist.getHealth_insurance());
    }
}
