package com.istartDigital.security.controller;

import com.istartDigital.security.dto.ReseteoContrasenia;
import com.istartDigital.security.service.RolService;
import com.istartDigital.security.service.UsuarioService;
import com.istartDigital.security.dto.JwtDto;
import com.istartDigital.security.dto.LoginUsuario;
import com.istartDigital.security.dto.NuevoUsuario;
import com.istartDigital.security.enums.RolNombre;
import com.istartDigital.security.jwt.JwtProvider;
import com.istartDigital.security.model.Rol;
import com.istartDigital.security.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;


    @PostMapping("/nuevo")
    public Map<String, String> nuevo(@RequestBody NuevoUsuario nuevoUsuario){
        Map<String, String> map = new HashMap<>();
        if(usuarioService.existsByEmail(nuevoUsuario.getEmail())){
            map.put("message", "El correo electrónico ya existe.");
            return map;
        }
        Usuario usuario = new Usuario(
                nuevoUsuario.getNombre(),
                nuevoUsuario.getApellido(),
                nuevoUsuario.getEmail(),
                nuevoUsuario.getTelefono(),
                passwordEncoder.encode(nuevoUsuario.getPassword()),
                nuevoUsuario.getEstado()
        );
        Set<Rol> roles = new HashSet<>();
        if(nuevoUsuario.getRoles().contains("supervisor")){
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_SUPERVISOR).get());
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_MANTENIMIENTO).get());
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_PRODUCCION).get());
        }else if (nuevoUsuario.getRoles().contains("mantenimiento")){
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_MANTENIMIENTO).get());
        }else {
            // bloqueo
            roles.add(rolService.getByRolNombre(RolNombre.ROLE_PRODUCCION).get());
        }

        usuario.setRoles(roles);
        usuarioService.save(usuario);
        map.put("message", "Usuario guardado correctamente.");
        return map;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario){
        Optional<Usuario> u = usuarioService.getByNombreUsuario(loginUsuario.getNombreUsuario());
        if(u.get().getEstado().equalsIgnoreCase("INACTIVO")){
            return new ResponseEntity(new JwtDto("NO_VALIDO"), HttpStatus.OK);
        }
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(),loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        JwtDto jwtDto = new JwtDto(jwt);
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<JwtDto> refreshToken(@RequestBody JwtDto jwtDto) throws ParseException {
        String token = jwtProvider.refreshToken(jwtDto);
        JwtDto jwt = new JwtDto(token);
        return new ResponseEntity(jwt, HttpStatus.OK);
    }

}
