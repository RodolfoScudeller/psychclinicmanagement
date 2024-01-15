package com.zentherapeasy.psychclinicmanagement.patient;

import com.zentherapeasy.psychclinicmanagement.address.AddressData;
import jakarta.validation.constraints.NotNull;

public record PatientUpdateData(
        @NotNull
        String cpf,
        String name,
        String telephone,
        String email,
        String health_insurance,
        AddressData addressData
) {
}
