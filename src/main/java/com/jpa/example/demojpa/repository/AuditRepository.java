package com.jpa.example.demojpa.repository;

import com.jpa.example.demojpa.entity.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {
}
