package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.Role;
import com.myblog.myblog11.entity.User;
import com.myblog.myblog11.payload.LoginDto;
import com.myblog.myblog11.payload.SignUpDto;
import com.myblog.myblog11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;
    // it has record coming from database

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword());// it has record coming from user who try to sign in
        // UsernamePasswordAuthenticationToken class used
        // for call load by username method internally and
        // automatically supply username & password to load by username present in logindto

        // authenticationManager.authenticate is used for compare data come from user & data come from databased
        Authentication authentication = authenticationManager.authenticate(
                usernamePasswordAuthenticationToken
        );

        // here we set session variable it's like session.setSession& ones session is set it return user sign in successfully
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.",
                HttpStatus.OK);
    }

        @PostMapping("/signup")
    public ResponseEntity<?> createRegistration(@RequestBody SignUpDto signUpDto) {
        if (userRepository.existsByEmail(signUpDto.getEmail())) {
            return new ResponseEntity<>("email is already exists", HttpStatus.BAD_REQUEST);
        }
        if (userRepository.existsByUsername(signUpDto.getUsername())) {
            return new ResponseEntity<>("username is already exist", HttpStatus.BAD_REQUEST);
        }
        User user = new User();
        user.setName(signUpDto.getName());
        user.setEmail(signUpDto.getEmail());
        user.setUsername(signUpDto.getUsername());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        Role roles = roleRepository.findByName(signUpDto.getRoleType()).get();
        Set<Role> convertRoleToSet= new HashSet<>();
        convertRoleToSet.add(roles);
        user.setRoles(convertRoleToSet);

        userRepository.save(user);
        return new ResponseEntity<>("Registration done succesfully", HttpStatus.CREATED);
    }
}
