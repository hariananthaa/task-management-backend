package com.hsk.apigateway.web.api;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {


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

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public String customers(Principal principal, Model model) {
        Principal principal1 = principal;
        return "Testing....";
    }

}
