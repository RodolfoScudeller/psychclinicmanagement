package com.zentherapeasy.psychclinicmanagement.psychologist;

import com.zentherapeasy.psychclinicmanagement.address.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PsychologistRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telephone,
        @NotBlank
        String crp,
        @NotBlank
        String health_insurance,
        @NotBlank
        String password,
        @NotNull
        @Valid
        AddressData addressData
) {
}
