package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.model.Cuenta;

import java.util.List;

public interface CuentaService {

    Cuenta saveCuenta(Cuenta cuenta);

    List<Cuenta> getAllCuentas();

    List<Cuenta> getCuentasBloqueadas(String desde, String hasta);

    List<Cuenta> getCuentasByIdBloque(long idBloque);

}
