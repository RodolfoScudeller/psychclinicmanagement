package com.zentherapeasy.psychclinicmanagement.employees;

import com.zentherapeasy.psychclinicmanagement.address.AddressData;
import jakarta.validation.constraints.NotNull;

public record EmployeesUpdateData(
        @NotNull
        String cpf,
        String name,
        String telephone,
        String email,
        AddressData addressData
) {
}
