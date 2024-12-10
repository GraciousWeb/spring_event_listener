package com.grace.spring_event_listener.service;

import com.grace.spring_event_listener.event.CustomEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class EventProducerService {

    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    public EventProducerService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(String message) {
        CustomEvent event = new CustomEvent(this, message);
        eventPublisher.publishEvent(event);
        System.out.println("Event published with message: " + message);
    }
}

