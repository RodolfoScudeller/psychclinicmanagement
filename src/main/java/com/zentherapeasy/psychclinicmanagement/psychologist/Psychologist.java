package com.zentherapeasy.psychclinicmanagement.psychologist;


import com.zentherapeasy.psychclinicmanagement.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "psychologist")
@Entity(name = "psychologist")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "crp")
public class Psychologist {
    @Id
    private String crp;
    private String name;
    private String email;
    private String telephone;
    private Boolean active;
    private String health_insurance;
    @Embedded
    private Address address;

    public Psychologist(PsychologistRegistrationData psychologistRegistrationData) {
        this.crp = psychologistRegistrationData.crp();
        this.name = psychologistRegistrationData.name();
        this.email = psychologistRegistrationData.email();
        this.telephone = psychologistRegistrationData.telephone();
        this.health_insurance = psychologistRegistrationData.health_insurance();
        this.active = true;
        this.address = new Address(psychologistRegistrationData.addressData());
    }
}
