package com.istartDigital.coreBussines.dto;

public class ReporteCuentasBaneadasPorFechaDto {

    long bloque;
    int data;

    public ReporteCuentasBaneadasPorFechaDto() {
    }

    public ReporteCuentasBaneadasPorFechaDto(long bloque, int data) {
        this.bloque = bloque;
        this.data = data;
    }

    public long getBloque() {
        return bloque;
    }

    public void setBloque(long bloque) {
        this.bloque = bloque;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
