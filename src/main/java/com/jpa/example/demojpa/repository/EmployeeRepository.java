package com.jpa.example.demojpa.repository;

import com.jpa.example.demojpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
