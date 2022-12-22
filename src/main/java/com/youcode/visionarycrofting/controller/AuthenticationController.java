package com.youcode.visionarycrofting.controller;


import com.youcode.visionarycrofting.configspringsecurity.JwtUtils;
import com.youcode.visionarycrofting.dao.UserDao;
import com.youcode.visionarycrofting.entity.UserEntity;
import com.youcode.visionarycrofting.service.UserService;
import com.youcode.visionarycrofting.service.dto.AuthenticationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/visionarycrofting/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserDao userDao;
    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@Valid @RequestBody AuthenticationRequest request){
        UserEntity user = userService.findByEmail(request.getEmail());
        if(user != null && user!= (new UserEntity())){
            return ResponseEntity.ok(jwtUtils.generateToken(new User(user.getEmail(),user.getPassword(), Collections.singleton(new SimpleGrantedAuthority(user.getRole().toString())))));
        }
        return ResponseEntity.status(400).body("Some error has occurred");
    }
}
