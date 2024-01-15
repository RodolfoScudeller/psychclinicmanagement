package com.zentherapeasy.psychclinicmanagement.psychologist;

import com.zentherapeasy.psychclinicmanagement.address.AddressData;
import jakarta.validation.constraints.NotNull;

public record PsychologistUpdateData(
        @NotNull
        String crp,
        String name,
        String telephone,
        String email,
        String health_insurance,
        AddressData addressData
) {
}
