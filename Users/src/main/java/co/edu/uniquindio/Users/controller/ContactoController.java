package co.edu.uniquindio.Users.controller;



import co.edu.uniquindio.Users.model.Contacto;
import co.edu.uniquindio.Users.repositorio.ContactorRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
@AllArgsConstructor

public class ContactoController {
    private final ContactorRepositorio contactorRepositorio;

    @GetMapping
    public List<Contacto> contactoList(){ return contactorRepositorio.findAll();}
}
