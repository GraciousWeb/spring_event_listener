package com.grace.spring_event_listener.controller;


import com.grace.spring_event_listener.service.EventProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    private final EventProducerService producerService;

    @Autowired
    public EventController(EventProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/trigger-event")
    public String triggerEvent(@RequestParam String message) {
        producerService.publishEvent(message);
        return "Event triggered with message: " + message;
    }
}

