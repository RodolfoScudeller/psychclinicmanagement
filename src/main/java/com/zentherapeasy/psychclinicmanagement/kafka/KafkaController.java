package com.zentherapeasy.psychclinicmanagement.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
class KafkaController {
    @Autowired
    private KafkaProducer service;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        service.sendMessage("Olá, " + name);
        return "OK";
    }
}

