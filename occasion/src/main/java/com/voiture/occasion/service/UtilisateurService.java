package com.voiture.occasion.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.voiture.occasion.config.auth.TokenProvider;
import com.voiture.occasion.model.Utilisateur;
import com.voiture.occasion.repository.UtilisateurRepository;

@Service
public class UtilisateurService implements UserDetailsService {
    @Autowired
    private UtilisateurRepository repository;
    @Autowired
    private TokenProvider tokenService; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = repository.findByIdUtilisateur(username);
        return user;
    }

    public String login(String email, String password) throws Exception {
        Optional<Utilisateur> user = repository.findUtilisateur(email, password);
        if (user.isPresent()) {
            return tokenService.generateAccessToken(user.get());
        }
        throw new Exception("User not found");
    }

    public String getIdToken(String token) throws JWTVerificationException {
        return tokenService.validateToken(token);
    }

    public Utilisateur save(Utilisateur utilisateur) {
        return repository.save(utilisateur);
    }

}
