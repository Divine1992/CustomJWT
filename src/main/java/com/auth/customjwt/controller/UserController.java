package com.auth.customjwt.controller;

import com.auth.customjwt.model.User;
import com.auth.customjwt.repository.UserRepository;
import com.auth.customjwt.security.CurrentUser;
import com.auth.customjwt.security.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<?> getAll(@CurrentUser UserPrincipal currentUser){
        log.debug("%s user is doing request", currentUser.getUsername());
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
