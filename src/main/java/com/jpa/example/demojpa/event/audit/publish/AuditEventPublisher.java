package com.jpa.example.demojpa.event.audit.publish;

import com.jpa.example.demojpa.entity.Audit;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AuditEventPublisher {
    private ApplicationEventPublisher publisher;

    public void publishEvent(Audit event) {
        publisher.publishEvent(event);
    }
}
