package com.istartDigital.coreBussines.controller;


import com.istartDigital.security.model.Usuario;
import com.istartDigital.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
@CrossOrigin
public class UsuarioController {


    @Autowired
    UsuarioService usuarioService;

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @GetMapping("/all")
    public List<Usuario> getUsers() {
        return usuarioService.getAllUser();
    }

    @PreAuthorize("hasRole('ROLE_SUPERVISOR')")
    @PostMapping("/save")
    public Usuario saveUser(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }


}
