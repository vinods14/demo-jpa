package com.jpa.example.demojpa.dao;

import com.jpa.example.demojpa.entity.Employee;
import com.jpa.example.demojpa.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeDAO {
    private final EmployeeRepository repository;

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public Employee getEmployee(Long id){
        return repository.findById(id).orElse(new Employee());
    }
}
