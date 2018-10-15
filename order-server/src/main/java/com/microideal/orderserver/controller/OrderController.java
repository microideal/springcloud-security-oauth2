package com.microideal.orderserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@RestController
public class OrderController {

    @GetMapping("/user")
    @PreAuthorize("isAuthenticated()")
    public Principal userInfo(Principal user){
        return user;
    }

    @GetMapping("/test")
    @PreAuthorize("hasAuthority('admin')")
    public String test(){
        return "test";
    }

    @GetMapping("/microideal")
    @PreAuthorize("hasAuthority('microideal')")
    public String microideal(){
        return "microideal";
    }

}
