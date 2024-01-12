package com.zentherapeasy.psychclinicmanagement.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String street;
    private String neighborhood;
    private String zip;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Address(AddressData addressData) {
        this.street = addressData.street();
        this.neighborhood = addressData.neighborhood();
        this.zip = addressData.zip();
        this.number = addressData.number();
        this.complement = addressData.complement();
        this.city = addressData.city();
        this.state = addressData.state();
    }
}
