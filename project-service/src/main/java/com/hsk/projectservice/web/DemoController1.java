package com.hsk.projectservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController1 {

    @GetMapping
//    @PreAuthorize("hasRole('client_user')")
    public String hello(){
        return "Hello from hello api";
    }


    @GetMapping("/hello-2")
//    @PreAuthorize("hasRole('client_admin')")
    public String hello2(){
        return "Hello from keycloak - admin";
    }

}