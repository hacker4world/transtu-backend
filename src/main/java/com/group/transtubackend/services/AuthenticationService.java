package com.group.transtubackend.services;

import com.group.transtubackend.dto.ApiResponse;
import com.group.transtubackend.dto.LoginDto;
import com.group.transtubackend.dto.LoginResponseDto;
import com.group.transtubackend.entities.Utilisateur;
import com.group.transtubackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    @Autowired
    private  UserRepository userRepository;




    public String login(LoginDto loginDto) {
        Optional<Utilisateur> userOptional = userRepository.findByEmail(loginDto.getEmail());

        if (userOptional.isEmpty()) {
          Utilisateur user= userOptional.get();
          if (user.getPassword().equals(loginDto.getPassword()))
            return "login avec succee";
        }

            return  "compte  non trouver";
    }

}
