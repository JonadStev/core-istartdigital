package com.istartDigital.coreBussines.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_bloque")
public class Bloque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    private String estado;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bloque")
    private List<Cuenta> cuentas;

    public Bloque() {
    }

    public Bloque(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
