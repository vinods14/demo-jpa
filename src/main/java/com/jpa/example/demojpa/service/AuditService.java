package com.jpa.example.demojpa.service;

import com.jpa.example.demojpa.dao.AuditDAO;
import com.jpa.example.demojpa.entity.Audit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuditService {

    private AuditDAO dao;

    public Audit create(Audit audit) {
        return dao.create(audit);
    }

}
