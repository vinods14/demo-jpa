package com.jpa.example.demojpa.controller;

import com.jpa.example.demojpa.entity.Address;
import com.jpa.example.demojpa.entity.Employee;
import com.jpa.example.demojpa.pojo.EmployeeRequest;
import com.jpa.example.demojpa.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee create(@RequestBody EmployeeRequest payload) {
        Address address = Address.builder()
                .street(payload.getAddress().get(0).getStreet())
                .city(payload.getAddress().get(0).getCity())
                .postalCode(payload.getAddress().get(0).getPostalCode())
                .build();
        Set<Address> uniqueAddress = new HashSet<>();
        uniqueAddress.add(address);
        Employee employee = Employee.builder().name(payload.getName()).role(payload.getRole()).address(uniqueAddress).build();
        return service.create(employee);
    }

    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployees(@PathVariable("id") Long id) {
        return service.getEmployee(id);
    }
}
