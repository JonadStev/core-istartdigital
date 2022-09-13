package com.istartDigital.coreBussines.dto;

import java.util.Date;

public class CuentaDto {

    private long id;
    private String correo;
    private String password;
    private String telefono;
    private String ipChip;
    private String modelo;
    private String fecha;
    private String responsable;
    private String estado;
    private String operadora;
    private long bloque;

    public CuentaDto() {
    }

    public CuentaDto(long id, String correo, String password, String telefono, String ipChip, String modelo, String fecha, String responsable, String estado, String operadora, long bloque) {
        this.id = id;
        this.correo = correo;
        this.password = password;
        this.telefono = telefono;
        this.ipChip = ipChip;
        this.modelo = modelo;
        this.fecha = fecha;
        this.responsable = responsable;
        this.estado = estado;
        this.operadora = operadora;
        this.bloque = bloque;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIpChip() {
        return ipChip;
    }

    public void setIpChip(String ipChip) {
        this.ipChip = ipChip;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    public long getBloque() {
        return bloque;
    }

    public void setBloque(long idBloque) {
        this.bloque = idBloque;
    }
}
