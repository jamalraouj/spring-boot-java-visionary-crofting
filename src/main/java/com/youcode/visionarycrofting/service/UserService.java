package com.youcode.visionarycrofting.service;

import com.youcode.visionarycrofting.classes.Message;
import com.youcode.visionarycrofting.entity.UserEntity;
import com.youcode.visionarycrofting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getAdmins(){
        return userRepository.findAll();
    }
    public UserEntity findByEmail(String email){
        userRepository.findAll().stream().forEach(u -> {
            System.out.println("USER ->"+u.toString());
            System.out.println("EMAIL ->"+u.getEmail());
        });

        Optional<UserEntity> adminOptional = null;
        Message message = new Message();
        if(email == null || email == ""){
            message.setMessage("You must adding email");
            message.setState("Error");
        }else {
            adminOptional = userRepository.findUserByEmail(email);
            if(adminOptional.isPresent()){
                message.setMessage("Success");
                message.setState("Success");
            }
        }
        adminOptional.get().setMessage(message);
        return adminOptional.get();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> adminOptional = userRepository.findUserByEmail(email) ;
        if (adminOptional.isEmpty())
            throw new UsernameNotFoundException("user with email "+email+" not found");
        return new User(adminOptional.get().getEmail(),adminOptional.get().getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_"+adminOptional.get().getRole().toString())));
    }
}