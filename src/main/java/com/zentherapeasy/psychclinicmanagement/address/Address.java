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

    public void updateAddress(AddressData addressData){
        if(addressData.street() != null){
            this.street = addressData.street();
        }
        if(addressData.neighborhood() != null){
            this.neighborhood = addressData.neighborhood();
        }
        if(addressData.zip() != null){
            this.zip = addressData.zip();
        }
        if(addressData.state() != null){
            this.state = addressData.state();
        }
        if(addressData.city() != null){
            this.city = addressData.city();
        }
        if(addressData.number() != null){
            this.number = addressData.number();
        }
        if(addressData.complement() != null){
            this.complement = addressData.complement();
        }
    }
}
