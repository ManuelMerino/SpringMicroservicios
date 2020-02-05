/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.SpringMicroservicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Merino
 */
@RestController
public class HelloRestController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }
    
    private final AddressService service;

    @Autowired
    public HelloRestController(AddressService service) {
        this.service = service;
    }

    @RequestMapping(value = "/micro-service")
    public String hello() throws Exception {

        String serverAddress = service.getServerAddress();
        return new StringBuilder().append("Hello from IP address: ").append(serverAddress).append("\n").toString();
    }

}
