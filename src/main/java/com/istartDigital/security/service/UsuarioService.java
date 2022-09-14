package com.istartDigital.security.service;

import com.istartDigital.security.model.Usuario;
import com.istartDigital.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByEmail(nombreUsuario);
    }

    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public Usuario udpateUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getAllUser(){
        return usuarioRepository.findAll();
    }

}
