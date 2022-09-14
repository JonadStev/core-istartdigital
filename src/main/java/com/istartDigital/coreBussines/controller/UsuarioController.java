package com.istartDigital.coreBussines.controller;


import com.istartDigital.security.model.Usuario;
import com.istartDigital.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
