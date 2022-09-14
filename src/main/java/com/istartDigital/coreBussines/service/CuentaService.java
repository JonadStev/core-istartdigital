package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaService {

    Cuenta saveCuenta(Cuenta cuenta);

    List<Cuenta> getAllCuentas();

    List<Cuenta> getCuentasBloqueadas(String desde, String hasta);

    List<Cuenta> getCuentasByIdBloque(long idBloque);

    Optional<Cuenta> getCuentaById(long id);

}
