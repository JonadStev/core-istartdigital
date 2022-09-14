package com.istartDigital.coreBussines.dto;

import java.util.Date;

public class BloqueoDto {

    private long id;
    private String usuario;
    private String estadoR1;
    private String fechaPrimeraRevision;
    private String estadoR2;
    private String fechaSegundaRevision;
    private String motivo;
    private int dias;
    private long bloque;
    private long cuenta;

    public BloqueoDto() {
    }

    public BloqueoDto(String usuario, String estadoR1, String fechaPrimeraRevision, String estadoR2, String fechaSegundaRevision, String motivo, int dias, long bloque, long cuenta) {
        this.usuario = usuario;
        this.estadoR1 = estadoR1;
        this.fechaPrimeraRevision = fechaPrimeraRevision;
        this.estadoR2 = estadoR2;
        this.fechaSegundaRevision = fechaSegundaRevision;
        this.motivo = motivo;
        this.dias = dias;
        this.bloque = bloque;
        this.cuenta = cuenta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEstadoR1() {
        return estadoR1;
    }

    public void setEstadoR1(String estadoR1) {
        this.estadoR1 = estadoR1;
    }

    public String getFechaPrimeraRevision() {
        return fechaPrimeraRevision;
    }

    public void setFechaPrimeraRevision(String fechaPrimeraRevision) {
        this.fechaPrimeraRevision = fechaPrimeraRevision;
    }

    public String getEstadoR2() {
        return estadoR2;
    }

    public void setEstadoR2(String estadoR2) {
        this.estadoR2 = estadoR2;
    }

    public String getFechaSegundaRevision() {
        return fechaSegundaRevision;
    }

    public void setFechaSegundaRevision(String fechaSegundaRevision) {
        this.fechaSegundaRevision = fechaSegundaRevision;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public long getBloque() {
        return bloque;
    }

    public void setBloque(long bloque) {
        this.bloque = bloque;
    }

    public long getCuenta() {
        return cuenta;
    }

    public void setCuenta(long cuenta) {
        this.cuenta = cuenta;
    }
}
