package com.uncoreclave.Autenticacion.servicio;

import com.uncoreclave.Autenticacion.dto.AuthUserDTO;
import com.uncoreclave.Autenticacion.dto.TokenDto;
import com.uncoreclave.Autenticacion.entidad.AuthUser;
import com.uncoreclave.Autenticacion.repositorio.AuthUserRepository;
import com.uncoreclave.Autenticacion.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    AuthUserRepository authUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtProvider jwtProvider;

    public AuthUser save(AuthUserDTO authUserDTO){
        Optional<AuthUser> user= authUserRepository.findByEmail(authUserDTO.getEmail());
        if(!user.isPresent())
            return null;
        String password= passwordEncoder.encode(authUserDTO.getPassword());
        AuthUser authUser= AuthUser.builder()
                .email(authUserDTO.getEmail())
                .password(password)
                .build();
        return authUserRepository.save(authUser);
    }

    public TokenDto login(AuthUserDTO authUserDTO){
        Optional<AuthUser> user= authUserRepository.findByEmail(authUserDTO.getEmail());
        if(!user.isPresent()){
            return null;
        }
        if(passwordEncoder.matches(authUserDTO.getPassword(),user.get().getPassword()))
            return new TokenDto(jwtProvider.crearTokern(user.get()));
        return null;
    }

    public TokenDto validate(String token){
        if(!jwtProvider.validate(token))
            return null;
        String username= jwtProvider.getUserNameFromToken(token);
        if(!authUserRepository.findByEmail(username).isPresent())
            return null;
        return new TokenDto(token);
    }
}
