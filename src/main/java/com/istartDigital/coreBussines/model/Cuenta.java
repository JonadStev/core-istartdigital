package com.istartDigital.coreBussines.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tbl_cuenta")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String correo;
    private String password;
    private String telefono;
    private String ipChip;
    private String modelo;
    private Date fecha;
    private String responsable;
    private String estado;
    private String operadora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bloque")
    private Bloque bloque;

    public Cuenta() {
    }

    public Cuenta(String correo, String password, String telefono, String ipChip, String modelo, Date fecha, String responsable, String estado, String operadora) {
        this.correo = correo;
        this.password = password;
        this.telefono = telefono;
        this.ipChip = ipChip;
        this.modelo = modelo;
        this.fecha = fecha;
        this.responsable = responsable;
        this.estado = estado;
        this.operadora = operadora;
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fecha);
        return strDate;
    }

    public void setFecha(Date fecha) {
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

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

    public long getBloque() {
        return bloque.getId();
    }
}
