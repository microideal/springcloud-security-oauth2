package com.microideal.authserver.controller;

import com.microideal.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    @PreAuthorize("isAuthenticated()")
    public Principal userInfo(Principal user){
        return user;
    }

    @GetMapping("/user/microideal")
    @PreAuthorize("hasAuthority('admin')")
    public String microideal(){
        return "microideal is cool";
    }

    @GetMapping("/test/hello")
    @PreAuthorize("hasAuthority('microideal')")
    public String hello(){
        return "microideal";
    }


}
