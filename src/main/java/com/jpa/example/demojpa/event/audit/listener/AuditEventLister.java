package com.jpa.example.demojpa.event.audit.listener;

import com.jpa.example.demojpa.entity.Audit;
import com.jpa.example.demojpa.service.AuditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AuditEventLister {

    private final AuditService service;

    @Async
    @EventListener
    public void onApplicationEvent(Audit eventMessage) {
        log.info("EventMessage : {}", eventMessage.getMessage());
        Audit audit = service.create(eventMessage);
        log.info(audit.getId() != 0 ? "Audit logged" : "Audit log fail.");
    }

}
