package com.zentherapeasy.psychclinicmanagement.psychologist;


import com.zentherapeasy.psychclinicmanagement.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

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

    public void update(PsychologistUpdateData data){
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.email() != null){
            this.email = data.email();
        }
        if(data.telephone() != null){
            this.telephone = data.telephone();
        }
        if(data.health_insurance() != null){
            this.health_insurance = data.health_insurance();
        }
        if(data.addressData() != null){
            this.address.updateAddress(data.addressData());
        }
    }
}
