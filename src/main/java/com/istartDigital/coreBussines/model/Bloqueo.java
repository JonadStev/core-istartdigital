package com.istartDigital.coreBussines.model;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "tbl_bloqueo")
public class Bloqueo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String usuario;
    private String estadoR1;
    private Date fechaPrimeraRevision;
    private String estadoR2;
    private Date fechaSegundaRevision;
    private String motivo;
    private int dias;
    private long bloque;
    private long cuenta;

    public Bloqueo() {
    }

    public Bloqueo(String usuario, String estadoR1, Date fechaPrimeraRevision, String estadoR2, Date fechaSegundaRevision, String motivo, int dias, long bloque, long cuenta) {
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fechaPrimeraRevision);
        return strDate;
    }

    public void setFechaPrimeraRevision(Date fechaPrimeraRevision) {
        this.fechaPrimeraRevision = fechaPrimeraRevision;
    }

    public String getEstadoR2() {
        return estadoR2;
    }

    public void setEstadoR2(String estadoR2) {
        this.estadoR2 = estadoR2;
    }

    public String getFechaSegundaRevision() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(fechaSegundaRevision);
        return strDate;
    }

    public void setFechaSegundaRevision(Date fechaSegundaRevision) {
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
