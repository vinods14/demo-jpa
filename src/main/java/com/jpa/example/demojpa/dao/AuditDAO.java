package com.jpa.example.demojpa.dao;

import com.jpa.example.demojpa.entity.Audit;
import com.jpa.example.demojpa.repository.AuditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuditDAO {
    private AuditRepository repository;

    public Audit create(Audit audit){
        return repository.save(audit);
    }
}
