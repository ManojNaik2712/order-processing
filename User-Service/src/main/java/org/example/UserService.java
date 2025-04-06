package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    public String saveuser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
        return "User registered succesfully";
    }

    public String login(LoginDTO loginDTO) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword())
            );
            if (authentication.isAuthenticated()) {
                //It can also work
                //User user=userRepo.findByEmail(loginDTO.getEmail());
                UserDetails user= userRepo.findByEmail(loginDTO.getEmail());
                String token = jwtService.generateToken(loginDTO,user.getAuthorities());
                return token;
            } else {
                System.out.println("Authentication failed!");
                return "fail";
            }
        } catch (Exception e) {
            System.out.println("Authentication error: " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}
