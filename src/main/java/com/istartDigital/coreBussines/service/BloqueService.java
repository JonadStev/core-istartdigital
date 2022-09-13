package com.istartDigital.coreBussines.service;

import com.istartDigital.coreBussines.model.Bloque;

import java.util.List;
import java.util.Optional;

public interface BloqueService {

    Bloque saveBloque(Bloque bloque);

    List<Bloque> getAllBloque();

    Optional<Bloque> getBloqueById(long id);

}
