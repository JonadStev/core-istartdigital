package com.istartDigital.security.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
Entidad encargada de tener la seguridad de la aplicación
Implementa los privilegios de cada usuario
*/
public class UsuarioPrincipal implements UserDetails {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UsuarioPrincipal(String nombre, String apellido, String email, String telefono, String password, Collection<? extends GrantedAuthority> authorities) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
        this.authorities = authorities;
    }

    /*
    Metodo en donde vamos asignar todos los privilegios a cada usuario, es decir su autorización,
    si es un administrador o un usuario normal.
    */
    public static UsuarioPrincipal build(Usuario usuario){
        // Obtener los roles de usuario
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream()
                                  .map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
                                  .collect(Collectors.toList());
        return new UsuarioPrincipal(
                    usuario.getNombre(),
                    usuario.getApellido(),
                    usuario.getEmail(),
                    usuario.getTelefono(),
                    usuario.getPassword(),
                    authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }
}
