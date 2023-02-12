package com.jpa.example.demojpa.service;

import com.jpa.example.demojpa.dao.EmployeeDAO;
import com.jpa.example.demojpa.entity.Audit;
import com.jpa.example.demojpa.entity.Employee;
import com.jpa.example.demojpa.event.audit.publish.AuditEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeDAO dao;
    private final AuditEventPublisher publisher;

    public Employee create(Employee employee) {
        Employee newEmployee = dao.create(employee);
        Audit event = getAudit("Create event executed.");
        publisher.publishEvent(event);
        return newEmployee;
    }

    public List<Employee> getEmployees() {
        Audit event = getAudit("GetEmployees called.");
        publisher.publishEvent(event);
        return dao.getEmployees();
    }

    public Employee getEmployee(Long id) {
        Audit event = getAudit("GetEmployee event executed for id : " + id);
        publisher.publishEvent(event);
        return dao.getEmployee(id);
    }

    private Audit getAudit(String message) {
        return Audit.builder().message(message).status(HttpStatus.OK.name()).timestamp(Timestamp.from(Instant.now())).build();
    }
}
