package com.uncoreclave.Autenticacion.controller;

import com.uncoreclave.Autenticacion.dto.AuthUserDTO;
import com.uncoreclave.Autenticacion.dto.TokenDto;
import com.uncoreclave.Autenticacion.entidad.AuthUser;
import com.uncoreclave.Autenticacion.servicio.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthUserController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody AuthUserDTO authUserDTO){
        TokenDto tokenDto=authService.login(authUserDTO);
        if(tokenDto == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDto);
    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDto> validate(@RequestParam String token){
        TokenDto tokenDto=authService.validate(token);
        if(tokenDto==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(tokenDto);

    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody AuthUserDTO authUserDTO){
        AuthUser authUser= authService.save(authUserDTO);
        if(authUser==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(authUser);
    }


}
