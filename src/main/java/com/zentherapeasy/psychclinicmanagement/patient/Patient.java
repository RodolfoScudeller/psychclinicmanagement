package com.zentherapeasy.psychclinicmanagement.patient;

import com.zentherapeasy.psychclinicmanagement.address.Address;
import com.zentherapeasy.psychclinicmanagement.psychologist.PsychologistUpdateData;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "patient")
@Entity(name = "patient")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Patient {
    @Id
    private String cpf;
    private String name;
    private String email;
    private String telephone;
    private Boolean active;
    private String health_insurance;
    @Embedded
    private Address address;

    public Patient(PatientRegistrationData patientRegistrationData) {
        this.cpf = patientRegistrationData.cpf();
        this.name = patientRegistrationData.name();
        this.email = patientRegistrationData.email();
        this.telephone = patientRegistrationData.telephone();
        this.active = true;
        this.health_insurance = patientRegistrationData.health_insurance();
        this.address = new Address(patientRegistrationData.addressData());
    }
    public void update(PatientUpdateData data){
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

    public void delete(){
        this.active = false;
    }
}
