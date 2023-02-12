package com.jpa.example.demojpa.event.audit.message;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GenericEventMessage<T> {
    private T event;
}
