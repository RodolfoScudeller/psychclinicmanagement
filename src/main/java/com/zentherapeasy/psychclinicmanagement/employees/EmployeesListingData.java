package com.zentherapeasy.psychclinicmanagement.employees;

public record EmployeesListingData(String cpf, String name, String email, String telephone) {
    public EmployeesListingData(Employees employees){
        this(employees.getCpf(), employees.getName(), employees.getEmail(), employees.getTelephone());
    }
}
