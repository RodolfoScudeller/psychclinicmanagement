package com.zentherapeasy.psychclinicmanagement.patient;

import com.zentherapeasy.psychclinicmanagement.address.AddressData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientRegistrationData(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String telephone,
        @NotBlank
        @Pattern(regexp = "\\d{11,13}")
        String cpf,
        @NotBlank
        String health_insurance,
        @NotNull
        @Valid
        AddressData addressData
) {
}
