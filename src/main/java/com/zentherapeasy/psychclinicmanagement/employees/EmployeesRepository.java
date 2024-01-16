package com.zentherapeasy.psychclinicmanagement.employees;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Long> {
    Page<Employees> findAllByActiveTrue(Pageable pagination);
    Employees getEmployeesByCpfAndActive(String cpf, Boolean active);
}
