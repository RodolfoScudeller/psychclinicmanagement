package com.zentherapeasy.psychclinicmanagement.employees;

import com.zentherapeasy.psychclinicmanagement.address.Address;
import com.zentherapeasy.psychclinicmanagement.patient.PatientUpdateData;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "employees")
@Entity(name = "employees")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cpf")
public class Employees {
    @Id
    private String cpf;
    private String name;
    private String email;
    private String telephone;
    private Boolean active;
    private String password;
    @Embedded
    private Address address;

    public Employees(EmployeesRegistrationData employeesRegistrationData) {
        this.cpf = employeesRegistrationData.cpf();
        this.name = employeesRegistrationData.name();
        this.email = employeesRegistrationData.email();
        this.telephone = employeesRegistrationData.telephone();
        this.active = true;
        this.password = employeesRegistrationData.password();
        this.address = new Address(employeesRegistrationData.addressData());
    }

    public void update(EmployeesUpdateData data){
        if(data.name() != null){
            this.name = data.name();
        }
        if(data.email() != null){
            this.email = data.email();
        }
        if(data.telephone() != null){
            this.telephone = data.telephone();
        }
        if(data.addressData() != null){
            this.address.updateAddress(data.addressData());
        }
    }

    public void delete(){
        this.active = false;
    }
}
